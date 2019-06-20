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
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.model.AddGroupModel;
import com.baidu.tieba.im.util.b;
import java.util.List;
/* loaded from: classes5.dex */
public class CreateGroupStepActivity extends BaseActivity<CreateGroupStepActivity> implements TextWatcher, CompoundButton.OnCheckedChangeListener, b.a {
    AddGroupModel gwL;
    j gwK = null;
    private int sourceFrom = 1014;
    private final GroupAddressInfoData gwM = new GroupAddressInfoData();
    private int gwN = 0;
    private final com.baidu.adp.framework.listener.c gwO = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.creategroup.CreateGroupStepActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103101) {
                CreateGroupStepActivity.this.setIsLoading(false);
                if (!(socketResponsedMessage instanceof ResponseAddGroupMessage)) {
                    CreateGroupStepActivity.this.showToast(R.string.group_create_fail);
                    return;
                }
                ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
                if (responseAddGroupMessage.getError() != 0) {
                    CreateGroupStepActivity.this.aC(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
                    return;
                }
                RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
                if (responseAddGroupMessage.getAddGroupInfo() == null) {
                    CreateGroupStepActivity.this.showToast(R.string.group_create_fail);
                    return;
                }
                CreateGroupStepActivity.this.showToast(R.string.group_create_success);
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
        this.gwL = new AddGroupModel(this);
        this.gwL.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(CreateGroupStepActivityConfig.GROUP_TYPE, 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.sourceFrom = intent.getIntExtra(CreateGroupStepActivityConfig.INTENT_SOURCE_FROM, 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.gwK = new j(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.gwK.setData(intExtra, intExtra2);
        adjustResizeForSoftInput();
        initListener();
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_pv", "pv", 1, new Object[0]);
    }

    private void initListener() {
        registerListener(103101, this.gwO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(String str, int i) {
        if (i < 0) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gwK.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.gwK.byx();
            this.gwK.bzn();
        } else if (i2 == -1) {
            switch (i) {
                case 12001:
                    sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkApplication.getCurrentAccountObj(), 1, 1.0f)));
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    this.gwK.al(intent);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.gwK.setPortrait(intent.getStringExtra(EditHeadActivityConfig.PHOTO_RESOURCE));
                    this.gwK.bzm();
                    this.gwK.bzl();
                    return;
                case 21001:
                    this.gwK.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.gwK.lH(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.gwN = this.gwM.getAddressList().indexOf(this.gwK.getBusiness());
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
        this.gwK.byY().setEnabled(!z);
        this.gwK.setIsLoading(z);
    }

    private void back() {
        if (this.gwK.byX() == 1) {
            finish();
        } else {
            this.gwK.bzr();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gwK.byW()) {
            back();
        } else if (view == this.gwK.byY()) {
            int dip2px = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getApp(), 0.0f);
            if (!this.gwK.bzp()) {
                String errMsg = this.gwK.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.gwK.bzk()) {
                if (!this.gwK.bzc()) {
                    setIsLoading(true);
                    this.gwL.setForumId(this.gwK.getForumId());
                    this.gwL.setName(this.gwK.getName());
                    this.gwL.setIntro(this.gwK.getIntro());
                    this.gwL.setGroupType(this.gwK.getGroupType());
                    this.gwL.setPortrait(this.gwK.getPortrait());
                    this.gwL.setPosition(this.gwK.yg());
                    this.gwL.setBusiness(this.gwK.getBusiness());
                    this.gwL.setLng(this.gwK.byU());
                    this.gwL.setLat(this.gwK.byV());
                    this.gwL.setSourceFrom(this.sourceFrom);
                    this.gwL.setFlag(this.gwK.bzd() ? 1 : 0);
                    this.gwL.sendMessage();
                }
            } else {
                this.gwK.bzs();
            }
        } else if (this.gwK.byZ() == view) {
            this.gwK.bzs();
        } else if (view == this.gwK.bza() || view == this.gwK.bzb()) {
            this.gwK.bzu();
        } else if (view == this.gwK.bze()) {
            TiebaStatic.log("edit_place_at_creatgroup");
            switch (this.gwK.byw()) {
                case 0:
                    sendMessage(new CustomMessage(2002001, new GroupAddressEditActivityConfig(getPageContext().getPageActivity(), 21001, this.gwM.getAddressList(), this.gwN, this.gwK.bzd())));
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.gwK.byx();
                    this.gwK.bzn();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.gwK.bzf()) {
            this.gwK.clearText();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.gwK.bzx();
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
        this.gwL.cancelMessage();
        this.gwK.bzo();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gwK.xS(String.valueOf(d));
        this.gwK.xR(String.valueOf(d2));
        this.gwK.xT(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.gwM.addAddress(str2);
            }
            this.gwK.setBusiness(list.get(0));
            return;
        }
        this.gwK.xU(str);
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void byS() {
        this.gwK.byz();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void byT() {
        this.gwK.byy();
    }
}
