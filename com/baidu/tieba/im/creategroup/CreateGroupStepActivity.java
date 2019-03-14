package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.GroupAddressEditActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.model.AddGroupModel;
import com.baidu.tieba.im.util.b;
import java.util.List;
/* loaded from: classes5.dex */
public class CreateGroupStepActivity extends BaseActivity<CreateGroupStepActivity> implements TextWatcher, CompoundButton.OnCheckedChangeListener, b.a {
    AddGroupModel gfI;
    j gfH = null;
    private int sourceFrom = 1014;
    private final GroupAddressInfoData gfJ = new GroupAddressInfoData();
    private int gfK = 0;
    private final com.baidu.adp.framework.listener.c gfL = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.creategroup.CreateGroupStepActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103101) {
                CreateGroupStepActivity.this.setIsLoading(false);
                if (!(socketResponsedMessage instanceof ResponseAddGroupMessage)) {
                    CreateGroupStepActivity.this.showToast(d.j.group_create_fail);
                    return;
                }
                ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
                if (responseAddGroupMessage.getError() != 0) {
                    CreateGroupStepActivity.this.aG(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
                    return;
                }
                RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
                if (responseAddGroupMessage.getAddGroupInfo() == null) {
                    CreateGroupStepActivity.this.showToast(d.j.group_create_fail);
                    return;
                }
                CreateGroupStepActivity.this.showToast(d.j.group_create_success);
                if (1012 != CreateGroupStepActivity.this.sourceFrom) {
                    CreateGroupStepActivity.this.sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(CreateGroupStepActivity.this.getPageContext().getContext(), TbadkApplication.getCurrentAccount(), 0)));
                }
                CreateGroupStepActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 3;
        super.onCreate(bundle);
        this.gfI = new AddGroupModel(this);
        this.gfI.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(CreateGroupStepActivityConfig.GROUP_TYPE, 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.sourceFrom = intent.getIntExtra(CreateGroupStepActivityConfig.INTENT_SOURCE_FROM, 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.gfH = new j(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.gfH.setData(intExtra, intExtra2);
        adjustResizeForSoftInput();
        initListener();
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_pv", "pv", 1, new Object[0]);
    }

    private void initListener() {
        registerListener(103101, this.gfL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, int i) {
        if (i < 0) {
            showToast(d.j.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gfH.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.gfH.bqK();
            this.gfH.brA();
        } else if (i2 == -1) {
            switch (i) {
                case 12001:
                    sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkApplication.getCurrentAccountObj(), 1, 1.0f)));
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    this.gfH.ai(intent);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.gfH.setPortrait(intent.getStringExtra(EditHeadActivityConfig.PHOTO_RESOURCE));
                    this.gfH.brz();
                    this.gfH.bry();
                    return;
                case 21001:
                    this.gfH.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.gfH.kR(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.gfK = this.gfJ.getAddressList().indexOf(this.gfH.getBusiness());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    ak.c(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            back();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsLoading(boolean z) {
        this.gfH.brl().setEnabled(!z);
        this.gfH.setIsLoading(z);
    }

    private void back() {
        if (this.gfH.brk() == 1) {
            finish();
        } else {
            this.gfH.brE();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gfH.brj()) {
            back();
        } else if (view == this.gfH.brl()) {
            int dip2px = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getApp(), 0.0f);
            if (!this.gfH.brC()) {
                String errMsg = this.gfH.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.gfH.brx()) {
                if (!this.gfH.brp()) {
                    setIsLoading(true);
                    this.gfI.setForumId(this.gfH.getForumId());
                    this.gfI.setName(this.gfH.getName());
                    this.gfI.setIntro(this.gfH.getIntro());
                    this.gfI.setGroupType(this.gfH.getGroupType());
                    this.gfI.setPortrait(this.gfH.getPortrait());
                    this.gfI.setPosition(this.gfH.xp());
                    this.gfI.setBusiness(this.gfH.getBusiness());
                    this.gfI.setLng(this.gfH.brh());
                    this.gfI.setLat(this.gfH.bri());
                    this.gfI.setSourceFrom(this.sourceFrom);
                    this.gfI.setFlag(this.gfH.brq() ? 1 : 0);
                    this.gfI.sendMessage();
                }
            } else {
                this.gfH.brF();
            }
        } else if (this.gfH.brm() == view) {
            this.gfH.brF();
        } else if (view == this.gfH.brn() || view == this.gfH.bro()) {
            this.gfH.brH();
        } else if (view == this.gfH.brr()) {
            TiebaStatic.log("edit_place_at_creatgroup");
            switch (this.gfH.bqJ()) {
                case 0:
                    sendMessage(new CustomMessage(2002001, new GroupAddressEditActivityConfig(getPageContext().getPageActivity(), 21001, this.gfJ.getAddressList(), this.gfK, this.gfH.brq())));
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.gfH.bqK();
                    this.gfH.brA();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.gfH.brs()) {
            this.gfH.clearText();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.gfH.brK();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gfI.cancelMessage();
        this.gfH.brB();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gfH.wC(String.valueOf(d));
        this.gfH.wB(String.valueOf(d2));
        this.gfH.wD(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.gfJ.addAddress(str2);
            }
            this.gfH.setBusiness(list.get(0));
            return;
        }
        this.gfH.wE(str);
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void brf() {
        this.gfH.bqM();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void brg() {
        this.gfH.bqL();
    }
}
