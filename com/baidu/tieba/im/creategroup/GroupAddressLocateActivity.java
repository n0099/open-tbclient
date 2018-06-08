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
    private boolean ehB = false;
    private boolean ehN = false;
    private String ehO = null;
    private String ehP = null;
    private String[] ehQ = null;
    private String ehR = "";
    private int eaK = -1;
    private n ehS = null;
    a.b ehT = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aHz();
        }
    };
    a.b ehU = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.ehO = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.ehP = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.ehB = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.ehN = this.ehB;
        }
        this.ehS = new n(this, this.ehO, this.ehP, this.ehB);
        this.ehS.a(this.ehU);
        this.ehS.b(this.ehT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ehS != null) {
            this.ehS.aHm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ehS.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aHy()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ehS.aHw()) {
            aHz();
        } else if (view == this.ehS.getBackButton()) {
            if (!aHy()) {
                finish();
            }
        } else if (view == this.ehS.aHF()) {
            this.ehS.aHx();
            this.ehS.aHB();
            this.eaK = -1;
        } else if (view == this.ehS.aHG()) {
            switch (this.ehS.aGt()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.ehS.aHC();
                    this.ehS.aHl();
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
            this.ehS.aHC();
            this.ehS.aHl();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.ehB = true;
        } else {
            this.ehB = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.ehS.aHx();
        this.ehS.aHA();
        this.eaK = i;
    }

    public int getSelectedPosition() {
        return this.eaK;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.ehS.nO(String.valueOf(d));
        this.ehS.nN(String.valueOf(d2));
        this.ehR = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.ehP);
            this.ehQ = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.ehQ[i] = (String) arrayList.get(i);
            }
            this.ehS.u(this.ehQ);
        } else if (this.ehR.equals(this.ehO)) {
            this.ehS.u(new String[0]);
        } else {
            this.ehS.u(new String[]{this.ehR});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGP() {
        this.ehS.aHD();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aGQ() {
        this.ehS.aGv();
    }

    private boolean aHy() {
        if (this.ehB != this.ehN || this.eaK > -1) {
            this.ehS.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHz() {
        Intent intent = new Intent();
        if (this.ehQ == null) {
            if (this.eaK > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.ehR);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.ehP);
                intent.putExtra("ResultDataAddress", this.ehO);
            }
        } else if (this.eaK > -1 && this.eaK < this.ehQ.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.ehQ[this.eaK]);
            intent.putExtra("ResultDataAddress", this.ehR);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.ehP);
            intent.putExtra("ResultDataAddress", this.ehO);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.ehB);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ehS.onChangeSkinType(i);
    }
}
