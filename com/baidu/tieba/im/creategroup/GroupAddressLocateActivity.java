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
    private boolean kpw = false;
    private boolean kpI = false;
    private String kpJ = null;
    private String kpK = null;
    private String[] kpL = null;
    private String kpM = "";
    private int khN = -1;
    private n kpN = null;
    a.b kpO = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cVx();
        }
    };
    a.b kpP = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.kpJ = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.kpK = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.kpw = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.kpI = this.kpw;
        }
        this.kpN = new n(this, this.kpJ, this.kpK, this.kpw);
        this.kpN.b(this.kpP);
        this.kpN.c(this.kpO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kpN != null) {
            this.kpN.cVj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kpN.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cVw()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kpN.cVu()) {
            cVx();
        } else if (view == this.kpN.getBackButton()) {
            if (!cVw()) {
                finish();
            }
        } else if (view == this.kpN.cVD()) {
            this.kpN.cVv();
            this.kpN.cVz();
            this.khN = -1;
        } else if (view == this.kpN.cVE()) {
            switch (this.kpN.cUs()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.kpN.cVA();
                    this.kpN.cVi();
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
            this.kpN.cVA();
            this.kpN.cVi();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.kpN.cVi();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.kpw = true;
        } else {
            this.kpw = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.kpN.cVv();
        this.kpN.cVy();
        this.khN = i;
    }

    public int getSelectedPosition() {
        return this.khN;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.kpN.MX(String.valueOf(d));
        this.kpN.MW(String.valueOf(d2));
        this.kpM = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.kpK);
            this.kpL = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.kpL[i] = (String) arrayList.get(i);
            }
            this.kpN.M(this.kpL);
        } else if (this.kpM.equals(this.kpJ)) {
            this.kpN.M(new String[0]);
        } else {
            this.kpN.M(new String[]{this.kpM});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cUO() {
        this.kpN.cVB();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cUP() {
        this.kpN.cUu();
    }

    private boolean cVw() {
        if (this.kpw != this.kpI || this.khN > -1) {
            this.kpN.RU();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVx() {
        Intent intent = new Intent();
        if (this.kpL == null) {
            if (this.khN > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.kpM);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.kpK);
                intent.putExtra("ResultDataAddress", this.kpJ);
            }
        } else if (this.khN > -1 && this.khN < this.kpL.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.kpL[this.khN]);
            intent.putExtra("ResultDataAddress", this.kpM);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.kpK);
            intent.putExtra("ResultDataAddress", this.kpJ);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.kpw);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kpN.onChangeSkinType(i);
    }
}
