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
    private boolean eQd = false;
    private boolean eQp = false;
    private String eQq = null;
    private String eQr = null;
    private String[] eQs = null;
    private String eQt = "";
    private int eJn = -1;
    private n eQu = null;
    a.b eQv = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aRk();
        }
    };
    a.b eQw = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.eQq = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.eQr = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.eQd = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.eQp = this.eQd;
        }
        this.eQu = new n(this, this.eQq, this.eQr, this.eQd);
        this.eQu.a(this.eQw);
        this.eQu.b(this.eQv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eQu != null) {
            this.eQu.aQW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eQu.onResume();
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
        if (view == this.eQu.aRh()) {
            aRk();
        } else if (view == this.eQu.getBackButton()) {
            if (!aRj()) {
                finish();
            }
        } else if (view == this.eQu.aRq()) {
            this.eQu.aRi();
            this.eQu.aRm();
            this.eJn = -1;
        } else if (view == this.eQu.aRr()) {
            switch (this.eQu.aQe()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.eQu.aRn();
                    this.eQu.aQV();
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
            this.eQu.aRn();
            this.eQu.aQV();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.eQd = true;
        } else {
            this.eQd = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eQu.aRi();
        this.eQu.aRl();
        this.eJn = i;
    }

    public int getSelectedPosition() {
        return this.eJn;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.eQu.pY(String.valueOf(d));
        this.eQu.pX(String.valueOf(d2));
        this.eQt = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.eQr);
            this.eQs = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.eQs[i] = (String) arrayList.get(i);
            }
            this.eQu.z(this.eQs);
        } else if (this.eQt.equals(this.eQq)) {
            this.eQu.z(new String[0]);
        } else {
            this.eQu.z(new String[]{this.eQt});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aQA() {
        this.eQu.aRo();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aQB() {
        this.eQu.aQg();
    }

    private boolean aRj() {
        if (this.eQd != this.eQp || this.eJn > -1) {
            this.eQu.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRk() {
        Intent intent = new Intent();
        if (this.eQs == null) {
            if (this.eJn > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.eQt);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.eQr);
                intent.putExtra("ResultDataAddress", this.eQq);
            }
        } else if (this.eJn > -1 && this.eJn < this.eQs.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.eQs[this.eJn]);
            intent.putExtra("ResultDataAddress", this.eQt);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.eQr);
            intent.putExtra("ResultDataAddress", this.eQq);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.eQd);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eQu.onChangeSkinType(i);
    }
}
