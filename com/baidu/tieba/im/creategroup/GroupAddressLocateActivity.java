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
    private boolean eQc = false;
    private boolean eQo = false;
    private String eQp = null;
    private String eQq = null;
    private String[] eQr = null;
    private String eQs = "";
    private int eJm = -1;
    private n eQt = null;
    a.b eQu = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aRk();
        }
    };
    a.b eQv = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.eQp = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.eQq = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.eQc = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.eQo = this.eQc;
        }
        this.eQt = new n(this, this.eQp, this.eQq, this.eQc);
        this.eQt.a(this.eQv);
        this.eQt.b(this.eQu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eQt != null) {
            this.eQt.aQW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eQt.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aRj()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eQt.aRh()) {
            aRk();
        } else if (view == this.eQt.getBackButton()) {
            if (!aRj()) {
                finish();
            }
        } else if (view == this.eQt.aRq()) {
            this.eQt.aRi();
            this.eQt.aRm();
            this.eJm = -1;
        } else if (view == this.eQt.aRr()) {
            switch (this.eQt.aQe()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eQt.aRn();
                    this.eQt.aQV();
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
            this.eQt.aRn();
            this.eQt.aQV();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.eQc = true;
        } else {
            this.eQc = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eQt.aRi();
        this.eQt.aRl();
        this.eJm = i;
    }

    public int getSelectedPosition() {
        return this.eJm;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eQt.pY(String.valueOf(d));
        this.eQt.pX(String.valueOf(d2));
        this.eQs = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.eQq);
            this.eQr = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.eQr[i] = (String) arrayList.get(i);
            }
            this.eQt.z(this.eQr);
        } else if (this.eQs.equals(this.eQp)) {
            this.eQt.z(new String[0]);
        } else {
            this.eQt.z(new String[]{this.eQs});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aQA() {
        this.eQt.aRo();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aQB() {
        this.eQt.aQg();
    }

    private boolean aRj() {
        if (this.eQc != this.eQo || this.eJm > -1) {
            this.eQt.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRk() {
        Intent intent = new Intent();
        if (this.eQr == null) {
            if (this.eJm > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.eQs);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.eQq);
                intent.putExtra("ResultDataAddress", this.eQp);
            }
        } else if (this.eJm > -1 && this.eJm < this.eQr.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.eQr[this.eJm]);
            intent.putExtra("ResultDataAddress", this.eQs);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.eQq);
            intent.putExtra("ResultDataAddress", this.eQp);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.eQc);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eQt.onChangeSkinType(i);
    }
}
