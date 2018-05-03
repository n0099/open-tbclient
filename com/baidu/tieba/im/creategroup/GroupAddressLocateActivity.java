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
    private boolean dVh = false;
    private boolean dVt = false;
    private String dVu = null;
    private String dVv = null;
    private String[] dVw = null;
    private String dVx = "";
    private int dOr = -1;
    private n dVy = null;
    a.b dVz = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aCG();
        }
    };
    a.b dVA = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.dVu = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.dVv = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.dVh = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.dVt = this.dVh;
        }
        this.dVy = new n(this, this.dVu, this.dVv, this.dVh);
        this.dVy.a(this.dVA);
        this.dVy.b(this.dVz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dVy != null) {
            this.dVy.aCt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dVy.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aCF()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.dVy.aCD()) {
            aCG();
        } else if (view2 == this.dVy.getBackButton()) {
            if (!aCF()) {
                finish();
            }
        } else if (view2 == this.dVy.aCM()) {
            this.dVy.aCE();
            this.dVy.aCI();
            this.dOr = -1;
        } else if (view2 == this.dVy.aCN()) {
            switch (this.dVy.aBA()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.dVy.aCJ();
                    this.dVy.aCs();
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
            this.dVy.aCJ();
            this.dVy.aCs();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.dVh = true;
        } else {
            this.dVh = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        this.dVy.aCE();
        this.dVy.aCH();
        this.dOr = i;
    }

    public int getSelectedPosition() {
        return this.dOr;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.dVy.mZ(String.valueOf(d));
        this.dVy.mY(String.valueOf(d2));
        this.dVx = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.dVv);
            this.dVw = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.dVw[i] = (String) arrayList.get(i);
            }
            this.dVy.u(this.dVw);
        } else if (this.dVx.equals(this.dVu)) {
            this.dVy.u(new String[0]);
        } else {
            this.dVy.u(new String[]{this.dVx});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aBW() {
        this.dVy.aCK();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aBX() {
        this.dVy.aBC();
    }

    private boolean aCF() {
        if (this.dVh != this.dVt || this.dOr > -1) {
            this.dVy.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCG() {
        Intent intent = new Intent();
        if (this.dVw == null) {
            if (this.dOr > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.dVx);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.dVv);
                intent.putExtra("ResultDataAddress", this.dVu);
            }
        } else if (this.dOr > -1 && this.dOr < this.dVw.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.dVw[this.dOr]);
            intent.putExtra("ResultDataAddress", this.dVx);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.dVv);
            intent.putExtra("ResultDataAddress", this.dVu);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.dVh);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dVy.onChangeSkinType(i);
    }
}
