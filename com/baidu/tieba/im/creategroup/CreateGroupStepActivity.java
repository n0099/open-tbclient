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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.model.AddGroupModel;
import com.baidu.tieba.im.util.b;
import java.util.List;
/* loaded from: classes3.dex */
public class CreateGroupStepActivity extends BaseActivity<CreateGroupStepActivity> implements TextWatcher, CompoundButton.OnCheckedChangeListener, b.a {
    AddGroupModel eAi;
    k eAh = null;
    private int sourceFrom = 1014;
    private final GroupAddressInfoData eAj = new GroupAddressInfoData();
    private int eAk = 0;
    private final com.baidu.adp.framework.listener.c eAl = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.creategroup.CreateGroupStepActivity.1
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
                    CreateGroupStepActivity.this.aa(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
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
        this.eAi = new AddGroupModel(this);
        this.eAi.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(CreateGroupStepActivityConfig.GROUP_TYPE, 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.sourceFrom = intent.getIntExtra(CreateGroupStepActivityConfig.INTENT_SOURCE_FROM, 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.eAh = new k(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.eAh.ca(intExtra, intExtra2);
        adjustResizeForSoftInput();
        initListener();
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_pv", "pv", 1, new Object[0]);
    }

    private void initListener() {
        registerListener(103101, this.eAl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(String str, int i) {
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
        this.eAh.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.eAh.aGB();
            this.eAh.aHs();
        } else if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkApplication.getCurrentAccountObj(), 1, 1.0f)));
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    this.eAh.O(intent);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.eAh.setPortrait(intent.getStringExtra(EditHeadActivityConfig.PHOTO_RESOURCE));
                    this.eAh.aHr();
                    this.eAh.aHq();
                    return;
                case 21001:
                    this.eAh.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.eAh.hs(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.eAk = this.eAj.getAddressList().indexOf(this.eAh.getBusiness());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    ai.b(getPageContext());
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
        this.eAh.aHc().setEnabled(!z);
        this.eAh.setIsLoading(z);
    }

    private void back() {
        if (this.eAh.aHb() == 1) {
            finish();
        } else {
            this.eAh.aHw();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eAh.aHa()) {
            back();
        } else if (view == this.eAh.aHc()) {
            int dip2px = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getApp(), 0.0f);
            if (!this.eAh.aHu()) {
                String errMsg = this.eAh.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.eAh.aHp()) {
                if (!this.eAh.aHg()) {
                    setIsLoading(true);
                    this.eAi.setForumId(this.eAh.getForumId());
                    this.eAi.setName(this.eAh.getName());
                    this.eAi.setIntro(this.eAh.getIntro());
                    this.eAi.setGroupType(this.eAh.getGroupType());
                    this.eAi.setPortrait(this.eAh.getPortrait());
                    this.eAi.setPosition(this.eAh.aHh());
                    this.eAi.setBusiness(this.eAh.getBusiness());
                    this.eAi.setLng(this.eAh.aGY());
                    this.eAi.setLat(this.eAh.aGZ());
                    this.eAi.setSourceFrom(this.sourceFrom);
                    this.eAi.setFlag(this.eAh.aHi() ? 1 : 0);
                    this.eAi.sendMessage();
                }
            } else {
                this.eAh.aHx();
            }
        } else if (this.eAh.aHd() == view) {
            this.eAh.aHx();
        } else if (view == this.eAh.aHe() || view == this.eAh.aHf()) {
            this.eAh.aHz();
        } else if (view == this.eAh.aHj()) {
            TiebaStatic.log("edit_place_at_creatgroup");
            switch (this.eAh.aGA()) {
                case 0:
                    sendMessage(new CustomMessage(2002001, new GroupAddressEditActivityConfig(getPageContext().getPageActivity(), 21001, this.eAj.getAddressList(), this.eAk, this.eAh.aHi())));
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eAh.aGB();
                    this.eAh.aHs();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.eAh.aHk()) {
            this.eAh.clearText();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.eAh.aHC();
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
        this.eAi.cancelMessage();
        this.eAh.aHt();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eAh.mV(String.valueOf(d));
        this.eAh.mU(String.valueOf(d2));
        this.eAh.mW(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.eAj.addAddress(str2);
            }
            this.eAh.setBusiness(list.get(0));
            return;
        }
        this.eAh.mX(str);
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGW() {
        this.eAh.aGD();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGX() {
        this.eAh.aGC();
    }
}
