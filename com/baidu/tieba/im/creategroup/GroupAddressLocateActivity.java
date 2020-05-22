package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
    private boolean ixj = false;
    private boolean ixv = false;
    private String ixw = null;
    private String ixx = null;
    private String[] ixy = null;
    private String ixz = "";
    private int iqv = -1;
    private n ixA = null;
    a.b ixB = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.clk();
        }
    };
    a.b ixC = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.ixw = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.ixx = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.ixj = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.ixv = this.ixj;
        }
        this.ixA = new n(this, this.ixw, this.ixx, this.ixj);
        this.ixA.b(this.ixC);
        this.ixA.c(this.ixB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ixA != null) {
            this.ixA.ckW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ixA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && clj()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ixA.clh()) {
            clk();
        } else if (view == this.ixA.getBackButton()) {
            if (!clj()) {
                finish();
            }
        } else if (view == this.ixA.clq()) {
            this.ixA.cli();
            this.ixA.clm();
            this.iqv = -1;
        } else if (view == this.ixA.clr()) {
            switch (this.ixA.cke()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.ixA.cln();
                    this.ixA.ckV();
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
            this.ixA.cln();
            this.ixA.ckV();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.ixA.ckV();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.ixj = true;
        } else {
            this.ixj = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.ixA.cli();
        this.ixA.cll();
        this.iqv = i;
    }

    public int getSelectedPosition() {
        return this.iqv;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.ixA.FZ(String.valueOf(d));
        this.ixA.FY(String.valueOf(d2));
        this.ixz = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.ixx);
            this.ixy = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.ixy[i] = (String) arrayList.get(i);
            }
            this.ixA.L(this.ixy);
        } else if (this.ixz.equals(this.ixw)) {
            this.ixA.L(new String[0]);
        } else {
            this.ixA.L(new String[]{this.ixz});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void ckB() {
        this.ixA.clo();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void ckC() {
        this.ixA.ckg();
    }

    private boolean clj() {
        if (this.ixj != this.ixv || this.iqv > -1) {
            this.ixA.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clk() {
        Intent intent = new Intent();
        if (this.ixy == null) {
            if (this.iqv > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.ixz);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.ixx);
                intent.putExtra("ResultDataAddress", this.ixw);
            }
        } else if (this.iqv > -1 && this.iqv < this.ixy.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.ixy[this.iqv]);
            intent.putExtra("ResultDataAddress", this.ixz);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.ixx);
            intent.putExtra("ResultDataAddress", this.ixw);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.ixj);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ixA.onChangeSkinType(i);
    }
}
