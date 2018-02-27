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
    private boolean eAq = false;
    private boolean eAC = false;
    private String eAD = null;
    private String eAE = null;
    private String[] eAF = null;
    private String eAG = "";
    private int etw = -1;
    private o eAH = null;
    a.b eAI = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aHG();
        }
    };
    a.b eAJ = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.eAD = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.eAE = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.eAq = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.eAC = this.eAq;
        }
        this.eAH = new o(this, this.eAD, this.eAE, this.eAq);
        this.eAH.a(this.eAJ);
        this.eAH.b(this.eAI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eAH != null) {
            this.eAH.aHs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eAH.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aHF()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eAH.aHD()) {
            aHG();
        } else if (view == this.eAH.getBackButton()) {
            if (!aHF()) {
                finish();
            }
        } else if (view == this.eAH.aHM()) {
            this.eAH.aHE();
            this.eAH.aHI();
            this.etw = -1;
        } else if (view == this.eAH.aHN()) {
            switch (this.eAH.aGz()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eAH.aHJ();
                    this.eAH.aHr();
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
            this.eAH.aHJ();
            this.eAH.aHr();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.eAq = true;
        } else {
            this.eAq = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eAH.aHE();
        this.eAH.aHH();
        this.etw = i;
    }

    public int getSelectedPosition() {
        return this.etw;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eAH.mV(String.valueOf(d));
        this.eAH.mU(String.valueOf(d2));
        this.eAG = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.eAE);
            this.eAF = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.eAF[i] = (String) arrayList.get(i);
            }
            this.eAH.s(this.eAF);
        } else if (this.eAG.equals(this.eAD)) {
            this.eAH.s(new String[0]);
        } else {
            this.eAH.s(new String[]{this.eAG});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGV() {
        this.eAH.aHK();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGW() {
        this.eAH.aGB();
    }

    private boolean aHF() {
        if (this.eAq != this.eAC || this.etw > -1) {
            this.eAH.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHG() {
        Intent intent = new Intent();
        if (this.eAF == null) {
            if (this.etw > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.eAG);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.eAE);
                intent.putExtra("ResultDataAddress", this.eAD);
            }
        } else if (this.etw > -1 && this.etw < this.eAF.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.eAF[this.etw]);
            intent.putExtra("ResultDataAddress", this.eAG);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.eAE);
            intent.putExtra("ResultDataAddress", this.eAD);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.eAq);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eAH.onChangeSkinType(i);
    }
}
