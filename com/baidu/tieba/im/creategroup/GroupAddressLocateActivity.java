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
    private boolean eEq = false;
    private boolean eEC = false;
    private String eED = null;
    private String eEE = null;
    private String[] eEF = null;
    private String eEG = "";
    private int exz = -1;
    private n eEH = null;
    a.b eEI = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aOI();
        }
    };
    a.b eEJ = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.eED = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.eEE = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.eEq = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.eEC = this.eEq;
        }
        this.eEH = new n(this, this.eED, this.eEE, this.eEq);
        this.eEH.a(this.eEJ);
        this.eEH.b(this.eEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eEH != null) {
            this.eEH.aOu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eEH.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aOH()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eEH.aOF()) {
            aOI();
        } else if (view == this.eEH.getBackButton()) {
            if (!aOH()) {
                finish();
            }
        } else if (view == this.eEH.aOO()) {
            this.eEH.aOG();
            this.eEH.aOK();
            this.exz = -1;
        } else if (view == this.eEH.aOP()) {
            switch (this.eEH.aNC()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eEH.aOL();
                    this.eEH.aOt();
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
            this.eEH.aOL();
            this.eEH.aOt();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.eEq = true;
        } else {
            this.eEq = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eEH.aOG();
        this.eEH.aOJ();
        this.exz = i;
    }

    public int getSelectedPosition() {
        return this.exz;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eEH.pc(String.valueOf(d));
        this.eEH.pb(String.valueOf(d2));
        this.eEG = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.eEE);
            this.eEF = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.eEF[i] = (String) arrayList.get(i);
            }
            this.eEH.w(this.eEF);
        } else if (this.eEG.equals(this.eED)) {
            this.eEH.w(new String[0]);
        } else {
            this.eEH.w(new String[]{this.eEG});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aNY() {
        this.eEH.aOM();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aNZ() {
        this.eEH.aNE();
    }

    private boolean aOH() {
        if (this.eEq != this.eEC || this.exz > -1) {
            this.eEH.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOI() {
        Intent intent = new Intent();
        if (this.eEF == null) {
            if (this.exz > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.eEG);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.eEE);
                intent.putExtra("ResultDataAddress", this.eED);
            }
        } else if (this.exz > -1 && this.exz < this.eEF.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.eEF[this.exz]);
            intent.putExtra("ResultDataAddress", this.eEG);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.eEE);
            intent.putExtra("ResultDataAddress", this.eED);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.eEq);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eEH.onChangeSkinType(i);
    }
}
