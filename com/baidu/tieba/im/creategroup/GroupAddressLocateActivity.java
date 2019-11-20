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
/* loaded from: classes5.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean gDm = false;
    private boolean gDy = false;
    private String gDz = null;
    private String gDA = null;
    private String[] gDB = null;
    private String gDC = "";
    private int gwu = -1;
    private n gDD = null;
    a.b gDE = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bzS();
        }
    };
    a.b gDF = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.gDz = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.gDA = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.gDm = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.gDy = this.gDm;
        }
        this.gDD = new n(this, this.gDz, this.gDA, this.gDm);
        this.gDD.b(this.gDF);
        this.gDD.c(this.gDE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gDD != null) {
            this.gDD.bzE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gDD.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bzR()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gDD.bzP()) {
            bzS();
        } else if (view == this.gDD.getBackButton()) {
            if (!bzR()) {
                finish();
            }
        } else if (view == this.gDD.bzY()) {
            this.gDD.bzQ();
            this.gDD.bzU();
            this.gwu = -1;
        } else if (view == this.gDD.bzZ()) {
            switch (this.gDD.byL()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.gDD.bzV();
                    this.gDD.bzD();
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
            this.gDD.bzV();
            this.gDD.bzD();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gDm = true;
        } else {
            this.gDm = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.gDD.bzQ();
        this.gDD.bzT();
        this.gwu = i;
    }

    public int qe() {
        return this.gwu;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gDD.xv(String.valueOf(d));
        this.gDD.xu(String.valueOf(d2));
        this.gDC = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.gDA);
            this.gDB = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.gDB[i] = (String) arrayList.get(i);
            }
            this.gDD.y(this.gDB);
        } else if (this.gDC.equals(this.gDz)) {
            this.gDD.y(new String[0]);
        } else {
            this.gDD.y(new String[]{this.gDC});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bzi() {
        this.gDD.bzW();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bzj() {
        this.gDD.byN();
    }

    private boolean bzR() {
        if (this.gDm != this.gDy || this.gwu > -1) {
            this.gDD.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzS() {
        Intent intent = new Intent();
        if (this.gDB == null) {
            if (this.gwu > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.gDC);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.gDA);
                intent.putExtra("ResultDataAddress", this.gDz);
            }
        } else if (this.gwu > -1 && this.gwu < this.gDB.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.gDB[this.gwu]);
            intent.putExtra("ResultDataAddress", this.gDC);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.gDA);
            intent.putExtra("ResultDataAddress", this.gDz);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.gDm);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gDD.onChangeSkinType(i);
    }
}
