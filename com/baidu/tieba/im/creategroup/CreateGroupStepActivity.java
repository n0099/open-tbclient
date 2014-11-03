package com.baidu.tieba.im.creategroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.im.model.AddGroupModel;
import java.util.List;
/* loaded from: classes.dex */
public class CreateGroupStepActivity extends BaseActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener, com.baidu.tieba.im.util.g {
    AddGroupModel aTL;
    o aTK = null;
    private int sourceFrom = 1014;
    private GroupAddressInfoData aTM = new GroupAddressInfoData();
    private int aTN = 0;
    private com.baidu.adp.framework.listener.e aTO = new k(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 3;
        super.onCreate(bundle);
        this.aTL = new AddGroupModel(this);
        this.aTL.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("group_type", 3);
        int intExtra2 = intent.getIntExtra(WriteImageActivityConfig.FORUMID, 0);
        this.sourceFrom = intent.getIntExtra("Intent_Source_From", 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.aTK = new o(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.aTK.N(intExtra, intExtra2);
        HN();
        TiebaStatic.eventStat(this, "create_g_pv", "pv", 1, new Object[0]);
    }

    private void HN() {
        registerListener(103101, this.aTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, int i) {
        if (i < 0) {
            showToast(com.baidu.tieba.y.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        Intent intent = new Intent(context, CreateGroupStepActivity.class);
        intent.putExtra("group_type", i);
        intent.putExtra(WriteImageActivityConfig.FORUMID, i2);
        intent.putExtra("Intent_Source_From", i3);
        intent.putExtra("num_create_group_normal", i4);
        intent.putExtra("num_create_group_private", i6);
        intent.putExtra("num_create_group_offical", i5);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aTK.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.aTK.KW();
            this.aTK.LN();
        } else if (i2 == -1) {
            switch (i) {
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.getCurrentAccountObj(), 1);
                    return;
                case 12002:
                    this.aTK.j(intent);
                    return;
                case 12009:
                case 12010:
                    this.aTK.setPortrait(intent.getStringExtra(EditHeadActivity.Jw));
                    this.aTK.LM();
                    this.aTK.LL();
                    return;
                case 21001:
                    this.aTK.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.aTK.cQ(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.aTN = this.aTM.getAddressList().indexOf(this.aTK.getBusiness());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    av.h(this);
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
        this.aTK.Lx().setEnabled(!z);
        this.aTK.setIsLoading(z);
    }

    private void back() {
        if (this.aTK.Lw() == 1) {
            finish();
        } else {
            this.aTK.LR();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aTK.Lv()) {
            back();
        } else if (view == this.aTK.Lx()) {
            int dip2px = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 0.0f);
            if (!this.aTK.LP()) {
                String errMsg = this.aTK.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.aTK.LK()) {
                if (!this.aTK.LB()) {
                    setIsLoading(true);
                    this.aTL.setForumId(this.aTK.getForumId());
                    this.aTL.setName(this.aTK.getName());
                    this.aTL.setIntro(this.aTK.getIntro());
                    this.aTL.setGroupType(this.aTK.getGroupType());
                    this.aTL.setPortrait(this.aTK.getPortrait());
                    this.aTL.setPosition(this.aTK.LC());
                    this.aTL.setBusiness(this.aTK.getBusiness());
                    this.aTL.setLng(this.aTK.Lt());
                    this.aTL.setLat(this.aTK.Lu());
                    this.aTL.setSourceFrom(this.sourceFrom);
                    this.aTL.setFlag(this.aTK.LD() ? 1 : 0);
                    this.aTL.sendMessage();
                }
            } else {
                this.aTK.LS();
            }
        } else if (this.aTK.Ly() == view) {
            this.aTK.LS();
        } else if (view == this.aTK.Lz() || view == this.aTK.LA()) {
            this.aTK.LU();
        } else if (view == this.aTK.LE()) {
            com.baidu.tbadk.core.j.l(this, "edit_place_at_creatgroup");
            switch (this.aTK.KV()) {
                case 0:
                    GroupAddressEditActivity.a(this, 21001, this.aTM.getAddressList(), this.aTN, this.aTK.LD());
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.aTK.KW();
                    this.aTK.LN();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.aTK.LF()) {
            this.aTK.clearText();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.aTK.LX();
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
        this.aTL.cancelMessage();
        this.aTK.LO();
    }

    @Override // com.baidu.tieba.im.util.g
    public void a(String str, List<String> list, double d, double d2) {
        this.aTK.fN(String.valueOf(d));
        this.aTK.fM(String.valueOf(d2));
        this.aTK.fO(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.aTM.addAddress(str2);
            }
            this.aTK.setBusiness(list.get(0));
            return;
        }
        this.aTK.fP(str);
    }

    @Override // com.baidu.tieba.im.util.g
    public void Lr() {
        this.aTK.KY();
    }

    @Override // com.baidu.tieba.im.util.g
    public void Ls() {
        this.aTK.KX();
    }
}
