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
    private boolean dWo = false;
    private boolean dWA = false;
    private String dWB = null;
    private String dWC = null;
    private String[] dWD = null;
    private String dWE = "";
    private int dPy = -1;
    private n dWF = null;
    a.b dWG = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aCE();
        }
    };
    a.b dWH = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.dWB = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.dWC = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.dWo = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.dWA = this.dWo;
        }
        this.dWF = new n(this, this.dWB, this.dWC, this.dWo);
        this.dWF.a(this.dWH);
        this.dWF.b(this.dWG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dWF != null) {
            this.dWF.aCr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dWF.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aCD()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.dWF.aCB()) {
            aCE();
        } else if (view2 == this.dWF.getBackButton()) {
            if (!aCD()) {
                finish();
            }
        } else if (view2 == this.dWF.aCK()) {
            this.dWF.aCC();
            this.dWF.aCG();
            this.dPy = -1;
        } else if (view2 == this.dWF.aCL()) {
            switch (this.dWF.aBy()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.dWF.aCH();
                    this.dWF.aCq();
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
            this.dWF.aCH();
            this.dWF.aCq();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.dWo = true;
        } else {
            this.dWo = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        this.dWF.aCC();
        this.dWF.aCF();
        this.dPy = i;
    }

    public int getSelectedPosition() {
        return this.dPy;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.dWF.nc(String.valueOf(d));
        this.dWF.nb(String.valueOf(d2));
        this.dWE = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.dWC);
            this.dWD = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.dWD[i] = (String) arrayList.get(i);
            }
            this.dWF.u(this.dWD);
        } else if (this.dWE.equals(this.dWB)) {
            this.dWF.u(new String[0]);
        } else {
            this.dWF.u(new String[]{this.dWE});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aBU() {
        this.dWF.aCI();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aBV() {
        this.dWF.aBA();
    }

    private boolean aCD() {
        if (this.dWo != this.dWA || this.dPy > -1) {
            this.dWF.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCE() {
        Intent intent = new Intent();
        if (this.dWD == null) {
            if (this.dPy > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.dWE);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.dWC);
                intent.putExtra("ResultDataAddress", this.dWB);
            }
        } else if (this.dPy > -1 && this.dPy < this.dWD.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.dWD[this.dPy]);
            intent.putExtra("ResultDataAddress", this.dWE);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.dWC);
            intent.putExtra("ResultDataAddress", this.dWB);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.dWo);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dWF.onChangeSkinType(i);
    }
}
