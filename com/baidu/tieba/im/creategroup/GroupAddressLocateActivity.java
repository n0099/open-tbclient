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
    private boolean hyH = false;
    private boolean hyT = false;
    private String hyU = null;
    private String hyV = null;
    private String[] hyW = null;
    private String hyX = "";
    private int hrT = -1;
    private n hyY = null;
    a.b hyZ = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bUn();
        }
    };
    a.b hza = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.hyU = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.hyV = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.hyH = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.hyT = this.hyH;
        }
        this.hyY = new n(this, this.hyU, this.hyV, this.hyH);
        this.hyY.b(this.hza);
        this.hyY.c(this.hyZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hyY != null) {
            this.hyY.bTZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hyY.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bUm()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hyY.bUk()) {
            bUn();
        } else if (view == this.hyY.getBackButton()) {
            if (!bUm()) {
                finish();
            }
        } else if (view == this.hyY.bUt()) {
            this.hyY.bUl();
            this.hyY.bUp();
            this.hrT = -1;
        } else if (view == this.hyY.bUu()) {
            switch (this.hyY.bTh()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.hyY.bUq();
                    this.hyY.bTY();
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
            this.hyY.bUq();
            this.hyY.bTY();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.hyY.bTY();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.hyH = true;
        } else {
            this.hyH = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.hyY.bUl();
        this.hyY.bUo();
        this.hrT = i;
    }

    public int getSelectedPosition() {
        return this.hrT;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.hyY.CF(String.valueOf(d));
        this.hyY.CE(String.valueOf(d2));
        this.hyX = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.hyV);
            this.hyW = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.hyW[i] = (String) arrayList.get(i);
            }
            this.hyY.I(this.hyW);
        } else if (this.hyX.equals(this.hyU)) {
            this.hyY.I(new String[0]);
        } else {
            this.hyY.I(new String[]{this.hyX});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void onLoadFailed() {
        this.hyY.bUr();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bTE() {
        this.hyY.bTj();
    }

    private boolean bUm() {
        if (this.hyH != this.hyT || this.hrT > -1) {
            this.hyY.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUn() {
        Intent intent = new Intent();
        if (this.hyW == null) {
            if (this.hrT > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.hyX);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.hyV);
                intent.putExtra("ResultDataAddress", this.hyU);
            }
        } else if (this.hrT > -1 && this.hrT < this.hyW.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.hyW[this.hrT]);
            intent.putExtra("ResultDataAddress", this.hyX);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.hyV);
            intent.putExtra("ResultDataAddress", this.hyU);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.hyH);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hyY.onChangeSkinType(i);
    }
}
