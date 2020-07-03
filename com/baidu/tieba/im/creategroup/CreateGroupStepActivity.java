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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.model.AddGroupModel;
import com.baidu.tieba.im.util.b;
import java.util.List;
/* loaded from: classes10.dex */
public class CreateGroupStepActivity extends BaseActivity<CreateGroupStepActivity> implements TextWatcher, CompoundButton.OnCheckedChangeListener, b.a {
    AddGroupModel iOD;
    j iOC = null;
    private int sourceFrom = 1014;
    private final GroupAddressInfoData iOE = new GroupAddressInfoData();
    private int iOF = 0;
    private final com.baidu.adp.framework.listener.c iOG = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.creategroup.CreateGroupStepActivity.1
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
                    CreateGroupStepActivity.this.aS(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
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
        this.iOD = new AddGroupModel(this);
        this.iOD.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("group_type", 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.sourceFrom = intent.getIntExtra(CreateGroupStepActivityConfig.INTENT_SOURCE_FROM, 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.iOC = new j(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.iOC.setData(intExtra, intExtra2);
        adjustResizeForSoftInput();
        initListener();
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_pv", "pv", 1, new Object[0]);
    }

    private void initListener() {
        registerListener(CmdConfigSocket.CMD_ADD_GROUP, this.iOG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(String str, int i) {
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
        this.iOC.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.iOC.cod();
            this.iOC.coT();
        } else if (i2 == -1) {
            switch (i) {
                case 12001:
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkApplication.getCurrentAccountObj(), 1, 1.0f)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    this.iOC.X(intent);
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.iOC.setPortrait(intent.getStringExtra(EditHeadActivityConfig.PHOTO_RESOURCE));
                    this.iOC.coS();
                    this.iOC.coR();
                    return;
                case RequestResponseCode.REQUEST_ADDRESS_VIEW /* 21001 */:
                    this.iOC.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.iOC.pe(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.iOF = this.iOE.getAddressList().indexOf(this.iOC.getBusiness());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    am.g(getPageContext());
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
            this.iOC.coT();
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
        this.iOC.coE().setEnabled(!z);
        this.iOC.setIsLoading(z);
    }

    private void back() {
        if (this.iOC.coD() == 1) {
            finish();
        } else {
            this.iOC.coX();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iOC.coC()) {
            back();
        } else if (view == this.iOC.coE()) {
            int dip2px = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getApp(), 0.0f);
            if (!this.iOC.coV()) {
                String errMsg = this.iOC.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.iOC.coQ()) {
                if (!this.iOC.coI()) {
                    setIsLoading(true);
                    this.iOD.setForumId(this.iOC.getForumId());
                    this.iOD.setName(this.iOC.getName());
                    this.iOD.setIntro(this.iOC.getIntro());
                    this.iOD.setGroupType(this.iOC.getGroupType());
                    this.iOD.setPortrait(this.iOC.getPortrait());
                    this.iOD.setPosition(this.iOC.Ym());
                    this.iOD.setBusiness(this.iOC.getBusiness());
                    this.iOD.setLng(this.iOC.coB());
                    this.iOD.setLat(this.iOC.aSE());
                    this.iOD.setSourceFrom(this.sourceFrom);
                    this.iOD.setFlag(this.iOC.coJ() ? 1 : 0);
                    this.iOD.sendMessage();
                }
            } else {
                this.iOC.coY();
            }
        } else if (this.iOC.coF() == view) {
            this.iOC.coY();
        } else if (view == this.iOC.coG() || view == this.iOC.coH()) {
            this.iOC.cpa();
        } else if (view == this.iOC.coK()) {
            TiebaStatic.log("edit_place_at_creatgroup");
            switch (this.iOC.coc()) {
                case 0:
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupAddressEditActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_ADDRESS_VIEW, this.iOE.getAddressList(), this.iOF, this.iOC.coJ())));
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.iOC.cod();
                    this.iOC.coT();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.iOC.coL()) {
            this.iOC.EO();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.iOC.cpd();
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
        this.iOD.cancelMessage();
        this.iOC.coU();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.iOC.GB(String.valueOf(d));
        this.iOC.GA(String.valueOf(d2));
        this.iOC.GC(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.iOE.addAddress(str2);
            }
            this.iOC.setBusiness(list.get(0));
            return;
        }
        this.iOC.GD(str);
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void coz() {
        this.iOC.cof();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void coA() {
        this.iOC.coe();
    }
}
