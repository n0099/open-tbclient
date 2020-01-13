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
/* loaded from: classes8.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean huU = false;
    private boolean hvg = false;
    private String hvh = null;
    private String hvi = null;
    private String[] hvj = null;
    private String hvk = "";
    private int hof = -1;
    private n hvl = null;
    a.b hvm = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bSr();
        }
    };
    a.b hvn = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.hvh = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.hvi = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.huU = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.hvg = this.huU;
        }
        this.hvl = new n(this, this.hvh, this.hvi, this.huU);
        this.hvl.b(this.hvn);
        this.hvl.c(this.hvm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hvl != null) {
            this.hvl.bSd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hvl.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bSq()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hvl.bSo()) {
            bSr();
        } else if (view == this.hvl.getBackButton()) {
            if (!bSq()) {
                finish();
            }
        } else if (view == this.hvl.bSx()) {
            this.hvl.bSp();
            this.hvl.bSt();
            this.hof = -1;
        } else if (view == this.hvl.bSy()) {
            switch (this.hvl.bRl()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.hvl.bSu();
                    this.hvl.bSc();
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
            this.hvl.bSu();
            this.hvl.bSc();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.huU = true;
        } else {
            this.huU = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.hvl.bSp();
        this.hvl.bSs();
        this.hof = i;
    }

    public int getSelectedPosition() {
        return this.hof;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.hvl.Co(String.valueOf(d));
        this.hvl.Cn(String.valueOf(d2));
        this.hvk = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.hvi);
            this.hvj = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.hvj[i] = (String) arrayList.get(i);
            }
            this.hvl.H(this.hvj);
        } else if (this.hvk.equals(this.hvh)) {
            this.hvl.H(new String[0]);
        } else {
            this.hvl.H(new String[]{this.hvk});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void onLoadFailed() {
        this.hvl.bSv();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bRI() {
        this.hvl.bRn();
    }

    private boolean bSq() {
        if (this.huU != this.hvg || this.hof > -1) {
            this.hvl.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSr() {
        Intent intent = new Intent();
        if (this.hvj == null) {
            if (this.hof > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.hvk);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.hvi);
                intent.putExtra("ResultDataAddress", this.hvh);
            }
        } else if (this.hof > -1 && this.hof < this.hvj.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.hvj[this.hof]);
            intent.putExtra("ResultDataAddress", this.hvk);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.hvi);
            intent.putExtra("ResultDataAddress", this.hvh);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.huU);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hvl.onChangeSkinType(i);
    }
}
