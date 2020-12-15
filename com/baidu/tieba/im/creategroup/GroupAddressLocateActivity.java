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
    private boolean kpy = false;
    private boolean kpK = false;
    private String kpL = null;
    private String kpM = null;
    private String[] kpN = null;
    private String kpO = "";
    private int khP = -1;
    private n kpP = null;
    a.b kpQ = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cVy();
        }
    };
    a.b kpR = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.kpL = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.kpM = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.kpy = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.kpK = this.kpy;
        }
        this.kpP = new n(this, this.kpL, this.kpM, this.kpy);
        this.kpP.b(this.kpR);
        this.kpP.c(this.kpQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kpP != null) {
            this.kpP.cVk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kpP.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cVx()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kpP.cVv()) {
            cVy();
        } else if (view == this.kpP.getBackButton()) {
            if (!cVx()) {
                finish();
            }
        } else if (view == this.kpP.cVE()) {
            this.kpP.cVw();
            this.kpP.cVA();
            this.khP = -1;
        } else if (view == this.kpP.cVF()) {
            switch (this.kpP.cUt()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.kpP.cVB();
                    this.kpP.cVj();
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
            this.kpP.cVB();
            this.kpP.cVj();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.kpP.cVj();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.kpy = true;
        } else {
            this.kpy = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.kpP.cVw();
        this.kpP.cVz();
        this.khP = i;
    }

    public int getSelectedPosition() {
        return this.khP;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.kpP.MX(String.valueOf(d));
        this.kpP.MW(String.valueOf(d2));
        this.kpO = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.kpM);
            this.kpN = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.kpN[i] = (String) arrayList.get(i);
            }
            this.kpP.M(this.kpN);
        } else if (this.kpO.equals(this.kpL)) {
            this.kpP.M(new String[0]);
        } else {
            this.kpP.M(new String[]{this.kpO});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cUP() {
        this.kpP.cVC();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cUQ() {
        this.kpP.cUv();
    }

    private boolean cVx() {
        if (this.kpy != this.kpK || this.khP > -1) {
            this.kpP.RU();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVy() {
        Intent intent = new Intent();
        if (this.kpN == null) {
            if (this.khP > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.kpO);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.kpM);
                intent.putExtra("ResultDataAddress", this.kpL);
            }
        } else if (this.khP > -1 && this.khP < this.kpN.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.kpN[this.khP]);
            intent.putExtra("ResultDataAddress", this.kpO);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.kpM);
            intent.putExtra("ResultDataAddress", this.kpL);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.kpy);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kpP.onChangeSkinType(i);
    }
}
