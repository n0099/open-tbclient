package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupAddressLocateActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.util.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean gEd = false;
    private boolean gEp = false;
    private String gEq = null;
    private String gEr = null;
    private String[] gEs = null;
    private String gEt = "";
    private int gxl = -1;
    private n gEu = null;
    a.b gEv = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bzU();
        }
    };
    a.b gEw = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            GroupAddressLocateActivity.this.setResult(0);
            aVar.dismiss();
            GroupAddressLocateActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.gEq = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.gEr = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.gEd = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.gEp = this.gEd;
        }
        this.gEu = new n(this, this.gEq, this.gEr, this.gEd);
        this.gEu.b(this.gEw);
        this.gEu.c(this.gEv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gEu != null) {
            this.gEu.bzG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gEu.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bzT()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gEu.bzR()) {
            bzU();
        } else if (view == this.gEu.getBackButton()) {
            if (!bzT()) {
                finish();
            }
        } else if (view == this.gEu.bAa()) {
            this.gEu.bzS();
            this.gEu.bzW();
            this.gxl = -1;
        } else if (view == this.gEu.bAb()) {
            switch (this.gEu.byN()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.gEu.bzX();
                    this.gEu.bzF();
                    return;
                case 3:
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.gEu.bzX();
            this.gEu.bzF();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gEd = true;
        } else {
            this.gEd = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.gEu.bzS();
        this.gEu.bzV();
        this.gxl = i;
    }

    public int qd() {
        return this.gxl;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gEu.xv(String.valueOf(d));
        this.gEu.xu(String.valueOf(d2));
        this.gEt = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.gEr);
            this.gEs = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.gEs[i] = (String) arrayList.get(i);
            }
            this.gEu.y(this.gEs);
        } else if (this.gEt.equals(this.gEq)) {
            this.gEu.y(new String[0]);
        } else {
            this.gEu.y(new String[]{this.gEt});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bzk() {
        this.gEu.bzY();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bzl() {
        this.gEu.byP();
    }

    private boolean bzT() {
        if (this.gEd != this.gEp || this.gxl > -1) {
            this.gEu.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzU() {
        Intent intent = new Intent();
        if (this.gEs == null) {
            if (this.gxl > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.gEt);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.gEr);
                intent.putExtra("ResultDataAddress", this.gEq);
            }
        } else if (this.gxl > -1 && this.gxl < this.gEs.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.gEs[this.gxl]);
            intent.putExtra("ResultDataAddress", this.gEt);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.gEr);
            intent.putExtra("ResultDataAddress", this.gEq);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.gEd);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gEu.onChangeSkinType(i);
    }
}
