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
    private boolean iiu = false;
    private boolean iiG = false;
    private String iiH = null;
    private String iiI = null;
    private String[] iiJ = null;
    private String iiK = "";
    private int ibC = -1;
    private n iiL = null;
    a.b iiM = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.ceO();
        }
    };
    a.b iiN = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.iiH = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.iiI = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.iiu = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.iiG = this.iiu;
        }
        this.iiL = new n(this, this.iiH, this.iiI, this.iiu);
        this.iiL.b(this.iiN);
        this.iiL.c(this.iiM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iiL != null) {
            this.iiL.ceA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iiL.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && ceN()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iiL.ceL()) {
            ceO();
        } else if (view == this.iiL.getBackButton()) {
            if (!ceN()) {
                finish();
            }
        } else if (view == this.iiL.ceU()) {
            this.iiL.ceM();
            this.iiL.ceQ();
            this.ibC = -1;
        } else if (view == this.iiL.ceV()) {
            switch (this.iiL.cdH()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.iiL.ceR();
                    this.iiL.cez();
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
            this.iiL.ceR();
            this.iiL.cez();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.iiL.cez();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.iiu = true;
        } else {
            this.iiu = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.iiL.ceM();
        this.iiL.ceP();
        this.ibC = i;
    }

    public int getSelectedPosition() {
        return this.ibC;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.iiL.En(String.valueOf(d));
        this.iiL.Em(String.valueOf(d2));
        this.iiK = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.iiI);
            this.iiJ = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.iiJ[i] = (String) arrayList.get(i);
            }
            this.iiL.I(this.iiJ);
        } else if (this.iiK.equals(this.iiH)) {
            this.iiL.I(new String[0]);
        } else {
            this.iiL.I(new String[]{this.iiK});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cee() {
        this.iiL.ceS();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cef() {
        this.iiL.cdJ();
    }

    private boolean ceN() {
        if (this.iiu != this.iiG || this.ibC > -1) {
            this.iiL.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceO() {
        Intent intent = new Intent();
        if (this.iiJ == null) {
            if (this.ibC > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.iiK);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.iiI);
                intent.putExtra("ResultDataAddress", this.iiH);
            }
        } else if (this.ibC > -1 && this.ibC < this.iiJ.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.iiJ[this.ibC]);
            intent.putExtra("ResultDataAddress", this.iiK);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.iiI);
            intent.putExtra("ResultDataAddress", this.iiH);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.iiu);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iiL.onChangeSkinType(i);
    }
}
