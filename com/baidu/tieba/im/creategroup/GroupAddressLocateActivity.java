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
/* loaded from: classes10.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean iiA = false;
    private boolean iiM = false;
    private String iiN = null;
    private String iiO = null;
    private String[] iiP = null;
    private String iiQ = "";
    private int ibI = -1;
    private n iiR = null;
    a.b iiS = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.ceN();
        }
    };
    a.b iiT = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.iiN = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.iiO = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.iiA = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.iiM = this.iiA;
        }
        this.iiR = new n(this, this.iiN, this.iiO, this.iiA);
        this.iiR.b(this.iiT);
        this.iiR.c(this.iiS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iiR != null) {
            this.iiR.cez();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iiR.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && ceM()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iiR.ceK()) {
            ceN();
        } else if (view == this.iiR.getBackButton()) {
            if (!ceM()) {
                finish();
            }
        } else if (view == this.iiR.ceT()) {
            this.iiR.ceL();
            this.iiR.ceP();
            this.ibI = -1;
        } else if (view == this.iiR.ceU()) {
            switch (this.iiR.cdG()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.iiR.ceQ();
                    this.iiR.cey();
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
            this.iiR.ceQ();
            this.iiR.cey();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.iiR.cey();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.iiA = true;
        } else {
            this.iiA = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.iiR.ceL();
        this.iiR.ceO();
        this.ibI = i;
    }

    public int getSelectedPosition() {
        return this.ibI;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.iiR.Eq(String.valueOf(d));
        this.iiR.Ep(String.valueOf(d2));
        this.iiQ = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.iiO);
            this.iiP = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.iiP[i] = (String) arrayList.get(i);
            }
            this.iiR.I(this.iiP);
        } else if (this.iiQ.equals(this.iiN)) {
            this.iiR.I(new String[0]);
        } else {
            this.iiR.I(new String[]{this.iiQ});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void ced() {
        this.iiR.ceR();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cee() {
        this.iiR.cdI();
    }

    private boolean ceM() {
        if (this.iiA != this.iiM || this.ibI > -1) {
            this.iiR.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceN() {
        Intent intent = new Intent();
        if (this.iiP == null) {
            if (this.ibI > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.iiQ);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.iiO);
                intent.putExtra("ResultDataAddress", this.iiN);
            }
        } else if (this.ibI > -1 && this.ibI < this.iiP.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.iiP[this.ibI]);
            intent.putExtra("ResultDataAddress", this.iiQ);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.iiO);
            intent.putExtra("ResultDataAddress", this.iiN);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.iiA);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iiR.onChangeSkinType(i);
    }
}
