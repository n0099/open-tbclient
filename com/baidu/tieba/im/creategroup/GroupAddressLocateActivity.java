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
    private boolean eAG = false;
    private boolean eAS = false;
    private String eAT = null;
    private String eAU = null;
    private String[] eAV = null;
    private String eAW = "";
    private int etM = -1;
    private o eAX = null;
    a.b eAY = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aHH();
        }
    };
    a.b eAZ = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.eAT = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.eAU = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.eAG = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.eAS = this.eAG;
        }
        this.eAX = new o(this, this.eAT, this.eAU, this.eAG);
        this.eAX.a(this.eAZ);
        this.eAX.b(this.eAY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eAX != null) {
            this.eAX.aHt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eAX.onResume();
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
        if (view == this.eAX.aHE()) {
            aHH();
        } else if (view == this.eAX.getBackButton()) {
            if (!aHG()) {
                finish();
            }
        } else if (view == this.eAX.aHN()) {
            this.eAX.aHF();
            this.eAX.aHJ();
            this.etM = -1;
        } else if (view == this.eAX.aHO()) {
            switch (this.eAX.aGA()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eAX.aHK();
                    this.eAX.aHs();
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
            this.eAX.aHK();
            this.eAX.aHs();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.eAG = true;
        } else {
            this.eAG = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eAX.aHF();
        this.eAX.aHI();
        this.etM = i;
    }

    public int getSelectedPosition() {
        return this.etM;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eAX.mV(String.valueOf(d));
        this.eAX.mU(String.valueOf(d2));
        this.eAW = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.eAU);
            this.eAV = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.eAV[i] = (String) arrayList.get(i);
            }
            this.eAX.s(this.eAV);
        } else if (this.eAW.equals(this.eAT)) {
            this.eAX.s(new String[0]);
        } else {
            this.eAX.s(new String[]{this.eAW});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGW() {
        this.eAX.aHL();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGX() {
        this.eAX.aGC();
    }

    private boolean aHG() {
        if (this.eAG != this.eAS || this.etM > -1) {
            this.eAX.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHH() {
        Intent intent = new Intent();
        if (this.eAV == null) {
            if (this.etM > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.eAW);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.eAU);
                intent.putExtra("ResultDataAddress", this.eAT);
            }
        } else if (this.etM > -1 && this.etM < this.eAV.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.eAV[this.etM]);
            intent.putExtra("ResultDataAddress", this.eAW);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.eAU);
            intent.putExtra("ResultDataAddress", this.eAT);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.eAG);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eAX.onChangeSkinType(i);
    }
}
