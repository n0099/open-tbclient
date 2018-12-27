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
    private boolean ePq = false;
    private boolean ePC = false;
    private String ePD = null;
    private String ePE = null;
    private String[] ePF = null;
    private String ePG = "";
    private int eIA = -1;
    private n ePH = null;
    a.b ePI = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aQK();
        }
    };
    a.b ePJ = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.ePD = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.ePE = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.ePq = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.ePC = this.ePq;
        }
        this.ePH = new n(this, this.ePD, this.ePE, this.ePq);
        this.ePH.a(this.ePJ);
        this.ePH.b(this.ePI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ePH != null) {
            this.ePH.aQw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ePH.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aQJ()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ePH.aQH()) {
            aQK();
        } else if (view == this.ePH.getBackButton()) {
            if (!aQJ()) {
                finish();
            }
        } else if (view == this.ePH.aQQ()) {
            this.ePH.aQI();
            this.ePH.aQM();
            this.eIA = -1;
        } else if (view == this.ePH.aQR()) {
            switch (this.ePH.aPE()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.ePH.aQN();
                    this.ePH.aQv();
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
            this.ePH.aQN();
            this.ePH.aQv();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.ePq = true;
        } else {
            this.ePq = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.ePH.aQI();
        this.ePH.aQL();
        this.eIA = i;
    }

    public int getSelectedPosition() {
        return this.eIA;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.ePH.pI(String.valueOf(d));
        this.ePH.pH(String.valueOf(d2));
        this.ePG = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.ePE);
            this.ePF = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.ePF[i] = (String) arrayList.get(i);
            }
            this.ePH.y(this.ePF);
        } else if (this.ePG.equals(this.ePD)) {
            this.ePH.y(new String[0]);
        } else {
            this.ePH.y(new String[]{this.ePG});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aQa() {
        this.ePH.aQO();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aQb() {
        this.ePH.aPG();
    }

    private boolean aQJ() {
        if (this.ePq != this.ePC || this.eIA > -1) {
            this.ePH.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        Intent intent = new Intent();
        if (this.ePF == null) {
            if (this.eIA > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.ePG);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.ePE);
                intent.putExtra("ResultDataAddress", this.ePD);
            }
        } else if (this.eIA > -1 && this.eIA < this.ePF.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.ePF[this.eIA]);
            intent.putExtra("ResultDataAddress", this.ePG);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.ePE);
            intent.putExtra("ResultDataAddress", this.ePD);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.ePq);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ePH.onChangeSkinType(i);
    }
}
