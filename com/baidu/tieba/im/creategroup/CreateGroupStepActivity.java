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
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.model.AddGroupModel;
import com.baidu.tieba.im.util.b;
import java.util.List;
/* loaded from: classes3.dex */
public class CreateGroupStepActivity extends BaseActivity<CreateGroupStepActivity> implements TextWatcher, CompoundButton.OnCheckedChangeListener, b.a {
    AddGroupModel eDT;
    j eDS = null;
    private int sourceFrom = 1014;
    private final GroupAddressInfoData eDU = new GroupAddressInfoData();
    private int eDV = 0;
    private final com.baidu.adp.framework.listener.c eDW = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.creategroup.CreateGroupStepActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103101) {
                CreateGroupStepActivity.this.setIsLoading(false);
                if (!(socketResponsedMessage instanceof ResponseAddGroupMessage)) {
                    CreateGroupStepActivity.this.showToast(e.j.group_create_fail);
                    return;
                }
                ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
                if (responseAddGroupMessage.getError() != 0) {
                    CreateGroupStepActivity.this.aj(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
                    return;
                }
                RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
                if (responseAddGroupMessage.getAddGroupInfo() == null) {
                    CreateGroupStepActivity.this.showToast(e.j.group_create_fail);
                    return;
                }
                CreateGroupStepActivity.this.showToast(e.j.group_create_success);
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
        this.eDT = new AddGroupModel(this);
        this.eDT.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(CreateGroupStepActivityConfig.GROUP_TYPE, 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.sourceFrom = intent.getIntExtra(CreateGroupStepActivityConfig.INTENT_SOURCE_FROM, 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.eDS = new j(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.eDS.setData(intExtra, intExtra2);
        adjustResizeForSoftInput();
        initListener();
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_pv", "pv", 1, new Object[0]);
    }

    private void initListener() {
        registerListener(103101, this.eDW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(String str, int i) {
        if (i < 0) {
            showToast(e.j.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eDS.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.eDS.aND();
            this.eDS.aOt();
        } else if (i2 == -1) {
            switch (i) {
                case 12001:
                    sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkApplication.getCurrentAccountObj(), 1, 1.0f)));
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    this.eDS.R(intent);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.eDS.setPortrait(intent.getStringExtra(EditHeadActivityConfig.PHOTO_RESOURCE));
                    this.eDS.aOs();
                    this.eDS.aOr();
                    return;
                case 21001:
                    this.eDS.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.eDS.ic(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.eDV = this.eDU.getAddressList().indexOf(this.eDS.getBusiness());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    ak.b(getPageContext());
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
        this.eDS.aOe().setEnabled(!z);
        this.eDS.setIsLoading(z);
    }

    private void back() {
        if (this.eDS.aOd() == 1) {
            finish();
        } else {
            this.eDS.aOx();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eDS.aOc()) {
            back();
        } else if (view == this.eDS.aOe()) {
            int dip2px = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getApp(), 0.0f);
            if (!this.eDS.aOv()) {
                String errMsg = this.eDS.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.eDS.aOq()) {
                if (!this.eDS.aOi()) {
                    setIsLoading(true);
                    this.eDT.setForumId(this.eDS.getForumId());
                    this.eDT.setName(this.eDS.getName());
                    this.eDT.setIntro(this.eDS.getIntro());
                    this.eDT.setGroupType(this.eDS.getGroupType());
                    this.eDT.setPortrait(this.eDS.getPortrait());
                    this.eDT.setPosition(this.eDS.getAddressName());
                    this.eDT.setBusiness(this.eDS.getBusiness());
                    this.eDT.setLng(this.eDS.aOa());
                    this.eDT.setLat(this.eDS.aOb());
                    this.eDT.setSourceFrom(this.sourceFrom);
                    this.eDT.setFlag(this.eDS.aOj() ? 1 : 0);
                    this.eDT.sendMessage();
                }
            } else {
                this.eDS.aOy();
            }
        } else if (this.eDS.aOf() == view) {
            this.eDS.aOy();
        } else if (view == this.eDS.aOg() || view == this.eDS.aOh()) {
            this.eDS.aOA();
        } else if (view == this.eDS.aOk()) {
            TiebaStatic.log("edit_place_at_creatgroup");
            switch (this.eDS.aNC()) {
                case 0:
                    sendMessage(new CustomMessage(2002001, new GroupAddressEditActivityConfig(getPageContext().getPageActivity(), 21001, this.eDU.getAddressList(), this.eDV, this.eDS.aOj())));
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eDS.aND();
                    this.eDS.aOt();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.eDS.aOl()) {
            this.eDS.clearText();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.eDS.aOD();
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
        this.eDT.cancelMessage();
        this.eDS.aOu();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eDS.pc(String.valueOf(d));
        this.eDS.pb(String.valueOf(d2));
        this.eDS.pd(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.eDU.addAddress(str2);
            }
            this.eDS.setBusiness(list.get(0));
            return;
        }
        this.eDS.pe(str);
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aNY() {
        this.eDS.aNF();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aNZ() {
        this.eDS.aNE();
    }
}
