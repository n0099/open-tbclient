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
    private boolean eAC = false;
    private boolean eAO = false;
    private String eAP = null;
    private String eAQ = null;
    private String[] eAR = null;
    private String eAS = "";
    private int etI = -1;
    private o eAT = null;
    a.b eAU = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aHH();
        }
    };
    a.b eAV = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.eAP = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.eAQ = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.eAC = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.eAO = this.eAC;
        }
        this.eAT = new o(this, this.eAP, this.eAQ, this.eAC);
        this.eAT.a(this.eAV);
        this.eAT.b(this.eAU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eAT != null) {
            this.eAT.aHt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eAT.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aHG()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eAT.aHE()) {
            aHH();
        } else if (view == this.eAT.getBackButton()) {
            if (!aHG()) {
                finish();
            }
        } else if (view == this.eAT.aHN()) {
            this.eAT.aHF();
            this.eAT.aHJ();
            this.etI = -1;
        } else if (view == this.eAT.aHO()) {
            switch (this.eAT.aGA()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eAT.aHK();
                    this.eAT.aHs();
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
            this.eAT.aHK();
            this.eAT.aHs();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.eAC = true;
        } else {
            this.eAC = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eAT.aHF();
        this.eAT.aHI();
        this.etI = i;
    }

    public int getSelectedPosition() {
        return this.etI;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eAT.mV(String.valueOf(d));
        this.eAT.mU(String.valueOf(d2));
        this.eAS = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.eAQ);
            this.eAR = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.eAR[i] = (String) arrayList.get(i);
            }
            this.eAT.s(this.eAR);
        } else if (this.eAS.equals(this.eAP)) {
            this.eAT.s(new String[0]);
        } else {
            this.eAT.s(new String[]{this.eAS});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGW() {
        this.eAT.aHL();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGX() {
        this.eAT.aGC();
    }

    private boolean aHG() {
        if (this.eAC != this.eAO || this.etI > -1) {
            this.eAT.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHH() {
        Intent intent = new Intent();
        if (this.eAR == null) {
            if (this.etI > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.eAS);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.eAQ);
                intent.putExtra("ResultDataAddress", this.eAP);
            }
        } else if (this.etI > -1 && this.etI < this.eAR.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.eAR[this.etI]);
            intent.putExtra("ResultDataAddress", this.eAS);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.eAQ);
            intent.putExtra("ResultDataAddress", this.eAP);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.eAC);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eAT.onChangeSkinType(i);
    }
}
