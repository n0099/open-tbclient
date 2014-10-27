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
    AddGroupModel aTx;
    o aTw = null;
    private int sourceFrom = 1014;
    private GroupAddressInfoData aTy = new GroupAddressInfoData();
    private int aTz = 0;
    private com.baidu.adp.framework.listener.e aTA = new k(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 3;
        super.onCreate(bundle);
        this.aTx = new AddGroupModel(this);
        this.aTx.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("group_type", 3);
        int intExtra2 = intent.getIntExtra(WriteImageActivityConfig.FORUMID, 0);
        this.sourceFrom = intent.getIntExtra("Intent_Source_From", 1014);
        if (this.sourceFrom == 1011 || this.sourceFrom == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.aTw = new o(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.aTw.N(intExtra, intExtra2);
        HJ();
        TiebaStatic.eventStat(this, "create_g_pv", "pv", 1, new Object[0]);
    }

    private void HJ() {
        registerListener(103101, this.aTA);
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
        this.aTw.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.aTw.KS();
            this.aTw.LJ();
        } else if (i2 == -1) {
            switch (i) {
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.getCurrentAccountObj(), 1);
                    return;
                case 12002:
                    this.aTw.j(intent);
                    return;
                case 12009:
                case 12010:
                    this.aTw.setPortrait(intent.getStringExtra(EditHeadActivity.Jv));
                    this.aTw.LI();
                    this.aTw.LH();
                    return;
                case 21001:
                    this.aTw.setBusiness(intent.getStringExtra("Selected_Business"));
                    this.aTw.cQ(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.aTz = this.aTy.getAddressList().indexOf(this.aTw.getBusiness());
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
        this.aTw.Lt().setEnabled(!z);
        this.aTw.setIsLoading(z);
    }

    private void back() {
        if (this.aTw.Ls() == 1) {
            finish();
        } else {
            this.aTw.LN();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aTw.Lr()) {
            back();
        } else if (view == this.aTw.Lt()) {
            int dip2px = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 0.0f);
            if (!this.aTw.LL()) {
                String errMsg = this.aTw.getErrMsg();
                if (!TextUtils.isEmpty(errMsg)) {
                    showToast(errMsg, dip2px);
                }
            } else if (this.aTw.LG()) {
                if (!this.aTw.Lx()) {
                    setIsLoading(true);
                    this.aTx.setForumId(this.aTw.getForumId());
                    this.aTx.setName(this.aTw.getName());
                    this.aTx.setIntro(this.aTw.getIntro());
                    this.aTx.setGroupType(this.aTw.getGroupType());
                    this.aTx.setPortrait(this.aTw.getPortrait());
                    this.aTx.setPosition(this.aTw.Ly());
                    this.aTx.setBusiness(this.aTw.getBusiness());
                    this.aTx.setLng(this.aTw.Lp());
                    this.aTx.setLat(this.aTw.Lq());
                    this.aTx.setSourceFrom(this.sourceFrom);
                    this.aTx.setFlag(this.aTw.Lz() ? 1 : 0);
                    this.aTx.sendMessage();
                }
            } else {
                this.aTw.LO();
            }
        } else if (this.aTw.Lu() == view) {
            this.aTw.LO();
        } else if (view == this.aTw.Lv() || view == this.aTw.Lw()) {
            this.aTw.LQ();
        } else if (view == this.aTw.LA()) {
            com.baidu.tbadk.core.i.l(this, "edit_place_at_creatgroup");
            switch (this.aTw.KR()) {
                case 0:
                    GroupAddressEditActivity.a(this, 21001, this.aTy.getAddressList(), this.aTz, this.aTw.Lz());
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.aTw.KS();
                    this.aTw.LJ();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.aTw.LB()) {
            this.aTw.clearText();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.aTw.LT();
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
        this.aTx.cancelMessage();
        this.aTw.LK();
    }

    @Override // com.baidu.tieba.im.util.g
    public void a(String str, List<String> list, double d, double d2) {
        this.aTw.fN(String.valueOf(d));
        this.aTw.fM(String.valueOf(d2));
        this.aTw.fO(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.aTy.addAddress(str2);
            }
            this.aTw.setBusiness(list.get(0));
            return;
        }
        this.aTw.fP(str);
    }

    @Override // com.baidu.tieba.im.util.g
    public void Ln() {
        this.aTw.KU();
    }

    @Override // com.baidu.tieba.im.util.g
    public void Lo() {
        this.aTw.KT();
    }
}
