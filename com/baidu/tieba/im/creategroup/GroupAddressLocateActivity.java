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
/* loaded from: classes23.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean jVl = false;
    private boolean jVx = false;
    private String jVy = null;
    private String jVz = null;
    private String[] jVA = null;
    private String jVB = "";
    private int jNC = -1;
    private n jVC = null;
    a.b jVD = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cOc();
        }
    };
    a.b jVE = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.jVy = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.jVz = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.jVl = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.jVx = this.jVl;
        }
        this.jVC = new n(this, this.jVy, this.jVz, this.jVl);
        this.jVC.b(this.jVE);
        this.jVC.c(this.jVD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jVC != null) {
            this.jVC.cNO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jVC.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cOb()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jVC.cNZ()) {
            cOc();
        } else if (view == this.jVC.getBackButton()) {
            if (!cOb()) {
                finish();
            }
        } else if (view == this.jVC.cOi()) {
            this.jVC.cOa();
            this.jVC.cOe();
            this.jNC = -1;
        } else if (view == this.jVC.cOj()) {
            switch (this.jVC.cMX()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.jVC.cOf();
                    this.jVC.cNN();
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
            this.jVC.cOf();
            this.jVC.cNN();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.jVC.cNN();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.jVl = true;
        } else {
            this.jVl = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.jVC.cOa();
        this.jVC.cOd();
        this.jNC = i;
    }

    public int getSelectedPosition() {
        return this.jNC;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.jVC.LX(String.valueOf(d));
        this.jVC.LW(String.valueOf(d2));
        this.jVB = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.jVz);
            this.jVA = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.jVA[i] = (String) arrayList.get(i);
            }
            this.jVC.L(this.jVA);
        } else if (this.jVB.equals(this.jVy)) {
            this.jVC.L(new String[0]);
        } else {
            this.jVC.L(new String[]{this.jVB});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cNt() {
        this.jVC.cOg();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cNu() {
        this.jVC.cMZ();
    }

    private boolean cOb() {
        if (this.jVl != this.jVx || this.jNC > -1) {
            this.jVC.PJ();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOc() {
        Intent intent = new Intent();
        if (this.jVA == null) {
            if (this.jNC > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.jVB);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.jVz);
                intent.putExtra("ResultDataAddress", this.jVy);
            }
        } else if (this.jNC > -1 && this.jNC < this.jVA.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.jVA[this.jNC]);
            intent.putExtra("ResultDataAddress", this.jVB);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.jVz);
            intent.putExtra("ResultDataAddress", this.jVy);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.jVl);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jVC.onChangeSkinType(i);
    }
}
