package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
/* loaded from: classes23.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean kbi = false;
    private boolean kbu = false;
    private String kbv = null;
    private String kbw = null;
    private String[] kbx = null;
    private String kby = "";
    private int jTz = -1;
    private n kbz = null;
    a.b kbA = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cQD();
        }
    };
    a.b kbB = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.kbv = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.kbw = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.kbi = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.kbu = this.kbi;
        }
        this.kbz = new n(this, this.kbv, this.kbw, this.kbi);
        this.kbz.b(this.kbB);
        this.kbz.c(this.kbA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kbz != null) {
            this.kbz.cQp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kbz.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cQC()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kbz.cQA()) {
            cQD();
        } else if (view == this.kbz.getBackButton()) {
            if (!cQC()) {
                finish();
            }
        } else if (view == this.kbz.cQJ()) {
            this.kbz.cQB();
            this.kbz.cQF();
            this.jTz = -1;
        } else if (view == this.kbz.cQK()) {
            switch (this.kbz.cPy()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.kbz.cQG();
                    this.kbz.cQo();
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
            this.kbz.cQG();
            this.kbz.cQo();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.kbz.cQo();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.kbi = true;
        } else {
            this.kbi = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.kbz.cQB();
        this.kbz.cQE();
        this.jTz = i;
    }

    public int getSelectedPosition() {
        return this.jTz;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.kbz.Mo(String.valueOf(d));
        this.kbz.Mn(String.valueOf(d2));
        this.kby = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.kbw);
            this.kbx = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.kbx[i] = (String) arrayList.get(i);
            }
            this.kbz.L(this.kbx);
        } else if (this.kby.equals(this.kbv)) {
            this.kbz.L(new String[0]);
        } else {
            this.kbz.L(new String[]{this.kby});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cPU() {
        this.kbz.cQH();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cPV() {
        this.kbz.cPA();
    }

    private boolean cQC() {
        if (this.kbi != this.kbu || this.jTz > -1) {
            this.kbz.Qj();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQD() {
        Intent intent = new Intent();
        if (this.kbx == null) {
            if (this.jTz > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.kby);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.kbw);
                intent.putExtra("ResultDataAddress", this.kbv);
            }
        } else if (this.jTz > -1 && this.jTz < this.kbx.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.kbx[this.jTz]);
            intent.putExtra("ResultDataAddress", this.kby);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.kbw);
            intent.putExtra("ResultDataAddress", this.kbv);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.kbi);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kbz.onChangeSkinType(i);
    }
}
