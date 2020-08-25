package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.GroupAddressEditActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.model.AddGroupModel;
import com.baidu.tieba.im.util.b;
import java.util.List;
/* loaded from: classes17.dex */
public class CreateGroupStepActivity extends BaseActivity<CreateGroupStepActivity> implements TextWatcher, CompoundButton.OnCheckedChangeListener, b.a {
    AddGroupModel jkH;
    j jkG = null;
    private int sourceFrom = 1014;
    private final GroupAddressInfoData jkI = new GroupAddressInfoData();
    private int jkJ = 0;
    private final com.baidu.adp.framework.listener.c jkK = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.creategroup.CreateGroupStepActivity.1
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
                    CreateGroupStepActivity.this.aU(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
                    return;
                }
                RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
                if (responseAddGroupMessage.getAddGroupInfo() == null) {
                    CreateGroupStepActivity.this.showToast(R.string.group_create_fail);
                    return;
                }
                CreateGroupStepActivity.this.showToast(R.string.group_create_success);
                if (1012 != CreateGroupStepActivity.this.sourceFrom) {
                    CreateGroupStepActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(CreateGroupStepActivity.this.getPageContext().getContext(), TbadkApplication.getCurrentAccount(), 0)));
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
        this.jkH = new AddGroupModel(this);
        this.jkH.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("group_type", 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.sourceFrom = intent.getIntExtra(CreateGroupStepActivityConfig.INTENT_SOURCE_FROM, 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.jkG = new j(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.jkG.setData(intExtra, intExtra2);
        adjustResizeForSoftInput();
        initListener();
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_pv", "pv", 1, new Object[0]);
    }

    private void initListener() {
        registerListener(CmdConfigSocket.CMD_ADD_GROUP, this.jkK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(String str, int i) {
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
        this.jkG.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.jkG.cCB();
            this.jkG.cDq();
        } else if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkApplication.getCurrentAccountObj(), 1, 1.0f)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    this.jkG.aa(intent);
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.jkG.setPortrait(intent.getStringExtra(EditHeadActivityConfig.PHOTO_RESOURCE));
                    this.jkG.cDp();
                    this.jkG.cDo();
                    return;
                case RequestResponseCode.REQUEST_ADDRESS_VIEW /* 21001 */:
                    this.jkG.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.jkG.qq(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.jkJ = this.jkI.getAddressList().indexOf(this.jkG.getBusiness());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    ao.g(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.jkG.cDq();
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
        this.jkG.cDb().setEnabled(!z);
        this.jkG.setIsLoading(z);
    }

    private void back() {
        if (this.jkG.cDa() == 1) {
            finish();
        } else {
            this.jkG.cDu();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jkG.cCZ()) {
            back();
        } else if (view == this.jkG.cDb()) {
            int dip2px = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getApp(), 0.0f);
            if (!this.jkG.cDs()) {
                String errMsg = this.jkG.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.jkG.cDn()) {
                if (!this.jkG.cDf()) {
                    setIsLoading(true);
                    this.jkH.setForumId(this.jkG.getForumId());
                    this.jkH.setName(this.jkG.getName());
                    this.jkH.setIntro(this.jkG.getIntro());
                    this.jkH.setGroupType(this.jkG.getGroupType());
                    this.jkH.setPortrait(this.jkG.getPortrait());
                    this.jkH.setPosition(this.jkG.aeY());
                    this.jkH.setBusiness(this.jkG.getBusiness());
                    this.jkH.setLng(this.jkG.cCY());
                    this.jkH.setLat(this.jkG.beT());
                    this.jkH.setSourceFrom(this.sourceFrom);
                    this.jkH.setFlag(this.jkG.cDg() ? 1 : 0);
                    this.jkH.sendMessage();
                }
            } else {
                this.jkG.cDv();
            }
        } else if (this.jkG.cDc() == view) {
            this.jkG.cDv();
        } else if (view == this.jkG.cDd() || view == this.jkG.cDe()) {
            this.jkG.cDx();
        } else if (view == this.jkG.cDh()) {
            TiebaStatic.log("edit_place_at_creatgroup");
            switch (this.jkG.cCA()) {
                case 0:
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupAddressEditActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_ADDRESS_VIEW, this.jkI.getAddressList(), this.jkJ, this.jkG.cDg())));
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.jkG.cCB();
                    this.jkG.cDq();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.jkG.cDi()) {
            this.jkG.KA();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.jkG.cDA();
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
        this.jkH.cancelMessage();
        this.jkG.cDr();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.jkG.Kh(String.valueOf(d));
        this.jkG.Kg(String.valueOf(d2));
        this.jkG.Ki(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.jkI.addAddress(str2);
            }
            this.jkG.setBusiness(list.get(0));
            return;
        }
        this.jkG.Kj(str);
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cCW() {
        this.jkG.cCD();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cCX() {
        this.jkG.cCC();
    }
}
