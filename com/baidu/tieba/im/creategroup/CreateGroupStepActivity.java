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
    AddGroupModel gFF;
    j gFE = null;
    private int sourceFrom = 1014;
    private final GroupAddressInfoData gFG = new GroupAddressInfoData();
    private int gFH = 0;
    private final com.baidu.adp.framework.listener.c gFI = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.creategroup.CreateGroupStepActivity.1
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
                    CreateGroupStepActivity.this.aF(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
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
        this.gFF = new AddGroupModel(this);
        this.gFF.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(CreateGroupStepActivityConfig.GROUP_TYPE, 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.sourceFrom = intent.getIntExtra(CreateGroupStepActivityConfig.INTENT_SOURCE_FROM, 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.gFE = new j(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.gFE.setData(intExtra, intExtra2);
        adjustResizeForSoftInput();
        initListener();
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_pv", "pv", 1, new Object[0]);
    }

    private void initListener() {
        registerListener(103101, this.gFI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(String str, int i) {
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
        this.gFE.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.gFE.bCd();
            this.gFE.bCU();
        } else if (i2 == -1) {
            switch (i) {
                case SapiGIDEvent.TIME_FREQ /* 12001 */:
                    sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) SapiGIDEvent.TIME_FREQ, 12010, (Uri) null, TbadkApplication.getCurrentAccountObj(), 1, 1.0f)));
                    return;
                case 12002:
                    this.gFE.an(intent);
                    return;
                case 12009:
                case 12010:
                    this.gFE.setPortrait(intent.getStringExtra(EditHeadActivityConfig.PHOTO_RESOURCE));
                    this.gFE.bCT();
                    this.gFE.bCS();
                    return;
                case 21001:
                    this.gFE.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.gFE.lY(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.gFH = this.gFG.getAddressList().indexOf(this.gFE.getBusiness());
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
        this.gFE.bCF().setEnabled(!z);
        this.gFE.setIsLoading(z);
    }

    private void back() {
        if (this.gFE.bCE() == 1) {
            finish();
        } else {
            this.gFE.bCY();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gFE.bCD()) {
            back();
        } else if (view == this.gFE.bCF()) {
            int dip2px = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getApp(), 0.0f);
            if (!this.gFE.bCW()) {
                String errMsg = this.gFE.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.gFE.bCR()) {
                if (!this.gFE.bCJ()) {
                    setIsLoading(true);
                    this.gFF.setForumId(this.gFE.getForumId());
                    this.gFF.setName(this.gFE.getName());
                    this.gFF.setIntro(this.gFE.getIntro());
                    this.gFF.setGroupType(this.gFE.getGroupType());
                    this.gFF.setPortrait(this.gFE.getPortrait());
                    this.gFF.setPosition(this.gFE.yP());
                    this.gFF.setBusiness(this.gFE.getBusiness());
                    this.gFF.setLng(this.gFE.bCB());
                    this.gFF.setLat(this.gFE.bCC());
                    this.gFF.setSourceFrom(this.sourceFrom);
                    this.gFF.setFlag(this.gFE.bCK() ? 1 : 0);
                    this.gFF.sendMessage();
                }
            } else {
                this.gFE.bCZ();
            }
        } else if (this.gFE.bCG() == view) {
            this.gFE.bCZ();
        } else if (view == this.gFE.bCH() || view == this.gFE.bCI()) {
            this.gFE.bDb();
        } else if (view == this.gFE.bCL()) {
            TiebaStatic.log("edit_place_at_creatgroup");
            switch (this.gFE.bCc()) {
                case 0:
                    sendMessage(new CustomMessage(2002001, new GroupAddressEditActivityConfig(getPageContext().getPageActivity(), 21001, this.gFG.getAddressList(), this.gFH, this.gFE.bCK())));
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.gFE.bCd();
                    this.gFE.bCU();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.gFE.bCM()) {
            this.gFE.clearText();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.gFE.bDe();
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
        this.gFF.cancelMessage();
        this.gFE.bCV();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gFE.zc(String.valueOf(d));
        this.gFE.zb(String.valueOf(d2));
        this.gFE.zd(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.gFG.addAddress(str2);
            }
            this.gFE.setBusiness(list.get(0));
            return;
        }
        this.gFE.ze(str);
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bCz() {
        this.gFE.bCf();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bCA() {
        this.gFE.bCe();
    }
}
