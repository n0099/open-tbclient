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
    private boolean eMz = false;
    private boolean eML = false;
    private String eMM = null;
    private String eMN = null;
    private String[] eMO = null;
    private String eMP = "";
    private int eFJ = -1;
    private n eMQ = null;
    a.b eMR = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aPW();
        }
    };
    a.b eMS = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.eMM = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.eMN = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.eMz = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.eML = this.eMz;
        }
        this.eMQ = new n(this, this.eMM, this.eMN, this.eMz);
        this.eMQ.a(this.eMS);
        this.eMQ.b(this.eMR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eMQ != null) {
            this.eMQ.aPI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eMQ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aPV()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eMQ.aPT()) {
            aPW();
        } else if (view == this.eMQ.getBackButton()) {
            if (!aPV()) {
                finish();
            }
        } else if (view == this.eMQ.aQc()) {
            this.eMQ.aPU();
            this.eMQ.aPY();
            this.eFJ = -1;
        } else if (view == this.eMQ.aQd()) {
            switch (this.eMQ.aOQ()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eMQ.aPZ();
                    this.eMQ.aPH();
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
            this.eMQ.aPZ();
            this.eMQ.aPH();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.eMz = true;
        } else {
            this.eMz = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eMQ.aPU();
        this.eMQ.aPX();
        this.eFJ = i;
    }

    public int getSelectedPosition() {
        return this.eFJ;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eMQ.pF(String.valueOf(d));
        this.eMQ.pE(String.valueOf(d2));
        this.eMP = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.eMN);
            this.eMO = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.eMO[i] = (String) arrayList.get(i);
            }
            this.eMQ.y(this.eMO);
        } else if (this.eMP.equals(this.eMM)) {
            this.eMQ.y(new String[0]);
        } else {
            this.eMQ.y(new String[]{this.eMP});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aPm() {
        this.eMQ.aQa();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aPn() {
        this.eMQ.aOS();
    }

    private boolean aPV() {
        if (this.eMz != this.eML || this.eFJ > -1) {
            this.eMQ.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPW() {
        Intent intent = new Intent();
        if (this.eMO == null) {
            if (this.eFJ > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.eMP);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.eMN);
                intent.putExtra("ResultDataAddress", this.eMM);
            }
        } else if (this.eFJ > -1 && this.eFJ < this.eMO.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.eMO[this.eFJ]);
            intent.putExtra("ResultDataAddress", this.eMP);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.eMN);
            intent.putExtra("ResultDataAddress", this.eMM);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.eMz);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eMQ.onChangeSkinType(i);
    }
}
