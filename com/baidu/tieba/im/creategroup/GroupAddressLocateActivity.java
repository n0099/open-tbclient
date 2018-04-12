package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupAddressLocateActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.util.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean dVk = false;
    private boolean dVw = false;
    private String dVx = null;
    private String dVy = null;
    private String[] dVz = null;
    private String dVA = "";
    private int dOu = -1;
    private n dVB = null;
    a.b dVC = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aCG();
        }
    };
    a.b dVD = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.dVx = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.dVy = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.dVk = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.dVw = this.dVk;
        }
        this.dVB = new n(this, this.dVx, this.dVy, this.dVk);
        this.dVB.a(this.dVD);
        this.dVB.b(this.dVC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dVB != null) {
            this.dVB.aCt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dVB.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aCF()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.dVB.aCD()) {
            aCG();
        } else if (view2 == this.dVB.getBackButton()) {
            if (!aCF()) {
                finish();
            }
        } else if (view2 == this.dVB.aCM()) {
            this.dVB.aCE();
            this.dVB.aCI();
            this.dOu = -1;
        } else if (view2 == this.dVB.aCN()) {
            switch (this.dVB.aBA()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.dVB.aCJ();
                    this.dVB.aCs();
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
            this.dVB.aCJ();
            this.dVB.aCs();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.dVk = true;
        } else {
            this.dVk = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        this.dVB.aCE();
        this.dVB.aCH();
        this.dOu = i;
    }

    public int getSelectedPosition() {
        return this.dOu;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.dVB.mZ(String.valueOf(d));
        this.dVB.mY(String.valueOf(d2));
        this.dVA = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.dVy);
            this.dVz = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.dVz[i] = (String) arrayList.get(i);
            }
            this.dVB.u(this.dVz);
        } else if (this.dVA.equals(this.dVx)) {
            this.dVB.u(new String[0]);
        } else {
            this.dVB.u(new String[]{this.dVA});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aBW() {
        this.dVB.aCK();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aBX() {
        this.dVB.aBC();
    }

    private boolean aCF() {
        if (this.dVk != this.dVw || this.dOu > -1) {
            this.dVB.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCG() {
        Intent intent = new Intent();
        if (this.dVz == null) {
            if (this.dOu > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.dVA);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.dVy);
                intent.putExtra("ResultDataAddress", this.dVx);
            }
        } else if (this.dOu > -1 && this.dOu < this.dVz.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.dVz[this.dOu]);
            intent.putExtra("ResultDataAddress", this.dVA);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.dVy);
            intent.putExtra("ResultDataAddress", this.dVx);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.dVk);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dVB.onChangeSkinType(i);
    }
}
