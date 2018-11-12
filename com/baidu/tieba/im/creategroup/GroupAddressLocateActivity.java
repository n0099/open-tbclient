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
    private boolean eFK = false;
    private boolean eFW = false;
    private String eFX = null;
    private String eFY = null;
    private String[] eFZ = null;
    private String eGa = "";
    private int eyU = -1;
    private n eGb = null;
    a.b eGc = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aOf();
        }
    };
    a.b eGd = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.eFX = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.eFY = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.eFK = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.eFW = this.eFK;
        }
        this.eGb = new n(this, this.eFX, this.eFY, this.eFK);
        this.eGb.a(this.eGd);
        this.eGb.b(this.eGc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eGb != null) {
            this.eGb.aNR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eGb.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aOe()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eGb.aOc()) {
            aOf();
        } else if (view == this.eGb.getBackButton()) {
            if (!aOe()) {
                finish();
            }
        } else if (view == this.eGb.aOl()) {
            this.eGb.aOd();
            this.eGb.aOh();
            this.eyU = -1;
        } else if (view == this.eGb.aOm()) {
            switch (this.eGb.aMZ()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eGb.aOi();
                    this.eGb.aNQ();
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
            this.eGb.aOi();
            this.eGb.aNQ();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.eFK = true;
        } else {
            this.eFK = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eGb.aOd();
        this.eGb.aOg();
        this.eyU = i;
    }

    public int getSelectedPosition() {
        return this.eyU;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eGb.pd(String.valueOf(d));
        this.eGb.pc(String.valueOf(d2));
        this.eGa = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.eFY);
            this.eFZ = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.eFZ[i] = (String) arrayList.get(i);
            }
            this.eGb.y(this.eFZ);
        } else if (this.eGa.equals(this.eFX)) {
            this.eGb.y(new String[0]);
        } else {
            this.eGb.y(new String[]{this.eGa});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aNv() {
        this.eGb.aOj();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aNw() {
        this.eGb.aNb();
    }

    private boolean aOe() {
        if (this.eFK != this.eFW || this.eyU > -1) {
            this.eGb.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOf() {
        Intent intent = new Intent();
        if (this.eFZ == null) {
            if (this.eyU > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.eGa);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.eFY);
                intent.putExtra("ResultDataAddress", this.eFX);
            }
        } else if (this.eyU > -1 && this.eyU < this.eFZ.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.eFZ[this.eyU]);
            intent.putExtra("ResultDataAddress", this.eGa);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.eFY);
            intent.putExtra("ResultDataAddress", this.eFX);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.eFK);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eGb.onChangeSkinType(i);
    }
}
