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
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.GroupAddressEditActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.model.AddGroupModel;
import com.baidu.tieba.im.util.b;
import java.util.List;
/* loaded from: classes5.dex */
public class CreateGroupStepActivity extends BaseActivity<CreateGroupStepActivity> implements TextWatcher, CompoundButton.OnCheckedChangeListener, b.a {
    AddGroupModel gCW;
    j gCV = null;
    private int sourceFrom = 1014;
    private final GroupAddressInfoData gCX = new GroupAddressInfoData();
    private int gCY = 0;
    private final com.baidu.adp.framework.listener.c gCZ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.creategroup.CreateGroupStepActivity.1
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
                    CreateGroupStepActivity.this.aD(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
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
        this.gCW = new AddGroupModel(this);
        this.gCW.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(CreateGroupStepActivityConfig.GROUP_TYPE, 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.sourceFrom = intent.getIntExtra(CreateGroupStepActivityConfig.INTENT_SOURCE_FROM, 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.gCV = new j(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.gCV.setData(intExtra, intExtra2);
        adjustResizeForSoftInput();
        initListener();
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_pv", "pv", 1, new Object[0]);
    }

    private void initListener() {
        registerListener(103101, this.gCZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(String str, int i) {
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
        this.gCV.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.gCV.bBb();
            this.gCV.bBS();
        } else if (i2 == -1) {
            switch (i) {
                case SapiGIDEvent.TIME_FREQ /* 12001 */:
                    sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) SapiGIDEvent.TIME_FREQ, 12010, (Uri) null, TbadkApplication.getCurrentAccountObj(), 1, 1.0f)));
                    return;
                case 12002:
                    this.gCV.al(intent);
                    return;
                case 12009:
                case 12010:
                    this.gCV.setPortrait(intent.getStringExtra(EditHeadActivityConfig.PHOTO_RESOURCE));
                    this.gCV.bBR();
                    this.gCV.bBQ();
                    return;
                case 21001:
                    this.gCV.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.gCV.lV(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.gCY = this.gCX.getAddressList().indexOf(this.gCV.getBusiness());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    al.c(getPageContext());
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
        this.gCV.bBD().setEnabled(!z);
        this.gCV.setIsLoading(z);
    }

    private void back() {
        if (this.gCV.bBC() == 1) {
            finish();
        } else {
            this.gCV.bBW();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gCV.bBB()) {
            back();
        } else if (view == this.gCV.bBD()) {
            int dip2px = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getApp(), 0.0f);
            if (!this.gCV.bBU()) {
                String errMsg = this.gCV.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.gCV.bBP()) {
                if (!this.gCV.bBH()) {
                    setIsLoading(true);
                    this.gCW.setForumId(this.gCV.getForumId());
                    this.gCW.setName(this.gCV.getName());
                    this.gCW.setIntro(this.gCV.getIntro());
                    this.gCW.setGroupType(this.gCV.getGroupType());
                    this.gCW.setPortrait(this.gCV.getPortrait());
                    this.gCW.setPosition(this.gCV.yL());
                    this.gCW.setBusiness(this.gCV.getBusiness());
                    this.gCW.setLng(this.gCV.bBz());
                    this.gCW.setLat(this.gCV.bBA());
                    this.gCW.setSourceFrom(this.sourceFrom);
                    this.gCW.setFlag(this.gCV.bBI() ? 1 : 0);
                    this.gCW.sendMessage();
                }
            } else {
                this.gCV.bBX();
            }
        } else if (this.gCV.bBE() == view) {
            this.gCV.bBX();
        } else if (view == this.gCV.bBF() || view == this.gCV.bBG()) {
            this.gCV.bBZ();
        } else if (view == this.gCV.bBJ()) {
            TiebaStatic.log("edit_place_at_creatgroup");
            switch (this.gCV.bBa()) {
                case 0:
                    sendMessage(new CustomMessage(2002001, new GroupAddressEditActivityConfig(getPageContext().getPageActivity(), 21001, this.gCX.getAddressList(), this.gCY, this.gCV.bBI())));
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.gCV.bBb();
                    this.gCV.bBS();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.gCV.bBK()) {
            this.gCV.clearText();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.gCV.bCc();
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
        this.gCW.cancelMessage();
        this.gCV.bBT();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gCV.yC(String.valueOf(d));
        this.gCV.yB(String.valueOf(d2));
        this.gCV.yD(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.gCX.addAddress(str2);
            }
            this.gCV.setBusiness(list.get(0));
            return;
        }
        this.gCV.yE(str);
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bBx() {
        this.gCV.bBd();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bBy() {
        this.gCV.bBc();
    }
}
