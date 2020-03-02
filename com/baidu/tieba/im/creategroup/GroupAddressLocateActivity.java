package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
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
    private boolean hwV = false;
    private boolean hxh = false;
    private String hxi = null;
    private String hxj = null;
    private String[] hxk = null;
    private String hxl = "";
    private int hqh = -1;
    private n hxm = null;
    a.b hxn = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bTU();
        }
    };
    a.b hxo = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.hxi = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.hxj = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.hwV = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.hxh = this.hwV;
        }
        this.hxm = new n(this, this.hxi, this.hxj, this.hwV);
        this.hxm.b(this.hxo);
        this.hxm.c(this.hxn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hxm != null) {
            this.hxm.bTG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hxm.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bTT()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hxm.bTR()) {
            bTU();
        } else if (view == this.hxm.getBackButton()) {
            if (!bTT()) {
                finish();
            }
        } else if (view == this.hxm.bUa()) {
            this.hxm.bTS();
            this.hxm.bTW();
            this.hqh = -1;
        } else if (view == this.hxm.bUb()) {
            switch (this.hxm.bSO()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.hxm.bTX();
                    this.hxm.bTF();
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
            this.hxm.bTX();
            this.hxm.bTF();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.hwV = true;
        } else {
            this.hwV = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.hxm.bTS();
        this.hxm.bTV();
        this.hqh = i;
    }

    public int getSelectedPosition() {
        return this.hqh;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.hxm.CE(String.valueOf(d));
        this.hxm.CD(String.valueOf(d2));
        this.hxl = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.hxj);
            this.hxk = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.hxk[i] = (String) arrayList.get(i);
            }
            this.hxm.I(this.hxk);
        } else if (this.hxl.equals(this.hxi)) {
            this.hxm.I(new String[0]);
        } else {
            this.hxm.I(new String[]{this.hxl});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void onLoadFailed() {
        this.hxm.bTY();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bTl() {
        this.hxm.bSQ();
    }

    private boolean bTT() {
        if (this.hwV != this.hxh || this.hqh > -1) {
            this.hxm.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTU() {
        Intent intent = new Intent();
        if (this.hxk == null) {
            if (this.hqh > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.hxl);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.hxj);
                intent.putExtra("ResultDataAddress", this.hxi);
            }
        } else if (this.hqh > -1 && this.hqh < this.hxk.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.hxk[this.hqh]);
            intent.putExtra("ResultDataAddress", this.hxl);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.hxj);
            intent.putExtra("ResultDataAddress", this.hxi);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.hwV);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hxm.onChangeSkinType(i);
    }
}
