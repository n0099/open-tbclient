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
    private boolean eEr = false;
    private boolean eED = false;
    private String eEE = null;
    private String eEF = null;
    private String[] eEG = null;
    private String eEH = "";
    private int exA = -1;
    private n eEI = null;
    a.b eEJ = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aOI();
        }
    };
    a.b eEK = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.eEE = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.eEF = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.eEr = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.eED = this.eEr;
        }
        this.eEI = new n(this, this.eEE, this.eEF, this.eEr);
        this.eEI.a(this.eEK);
        this.eEI.b(this.eEJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eEI != null) {
            this.eEI.aOu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eEI.onResume();
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
        if (view == this.eEI.aOF()) {
            aOI();
        } else if (view == this.eEI.getBackButton()) {
            if (!aOH()) {
                finish();
            }
        } else if (view == this.eEI.aOO()) {
            this.eEI.aOG();
            this.eEI.aOK();
            this.exA = -1;
        } else if (view == this.eEI.aOP()) {
            switch (this.eEI.aNC()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eEI.aOL();
                    this.eEI.aOt();
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
            this.eEI.aOL();
            this.eEI.aOt();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.eEr = true;
        } else {
            this.eEr = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eEI.aOG();
        this.eEI.aOJ();
        this.exA = i;
    }

    public int getSelectedPosition() {
        return this.exA;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eEI.pc(String.valueOf(d));
        this.eEI.pb(String.valueOf(d2));
        this.eEH = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.eEF);
            this.eEG = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.eEG[i] = (String) arrayList.get(i);
            }
            this.eEI.w(this.eEG);
        } else if (this.eEH.equals(this.eEE)) {
            this.eEI.w(new String[0]);
        } else {
            this.eEI.w(new String[]{this.eEH});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aNY() {
        this.eEI.aOM();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aNZ() {
        this.eEI.aNE();
    }

    private boolean aOH() {
        if (this.eEr != this.eED || this.exA > -1) {
            this.eEI.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOI() {
        Intent intent = new Intent();
        if (this.eEG == null) {
            if (this.exA > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.eEH);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.eEF);
                intent.putExtra("ResultDataAddress", this.eEE);
            }
        } else if (this.exA > -1 && this.exA < this.eEG.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.eEG[this.exA]);
            intent.putExtra("ResultDataAddress", this.eEH);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.eEF);
            intent.putExtra("ResultDataAddress", this.eEE);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.eEr);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eEI.onChangeSkinType(i);
    }
}
