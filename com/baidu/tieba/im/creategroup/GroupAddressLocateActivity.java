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
/* loaded from: classes17.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean jll = false;
    private boolean jlx = false;
    private String jly = null;
    private String jlz = null;
    private String[] jlA = null;
    private String jlB = "";
    private int jdz = -1;
    private n jlC = null;
    a.b jlD = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cDG();
        }
    };
    a.b jlE = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.jly = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.jlz = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.jll = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.jlx = this.jll;
        }
        this.jlC = new n(this, this.jly, this.jlz, this.jll);
        this.jlC.b(this.jlE);
        this.jlC.c(this.jlD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jlC != null) {
            this.jlC.cDs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jlC.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cDF()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jlC.cDD()) {
            cDG();
        } else if (view == this.jlC.getBackButton()) {
            if (!cDF()) {
                finish();
            }
        } else if (view == this.jlC.cDM()) {
            this.jlC.cDE();
            this.jlC.cDI();
            this.jdz = -1;
        } else if (view == this.jlC.cDN()) {
            switch (this.jlC.cCB()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.jlC.cDJ();
                    this.jlC.cDr();
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
            this.jlC.cDJ();
            this.jlC.cDr();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.jlC.cDr();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.jll = true;
        } else {
            this.jll = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.jlC.cDE();
        this.jlC.cDH();
        this.jdz = i;
    }

    public int getSelectedPosition() {
        return this.jdz;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.jlC.Ki(String.valueOf(d));
        this.jlC.Kh(String.valueOf(d2));
        this.jlB = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.jlz);
            this.jlA = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.jlA[i] = (String) arrayList.get(i);
            }
            this.jlC.J(this.jlA);
        } else if (this.jlB.equals(this.jly)) {
            this.jlC.J(new String[0]);
        } else {
            this.jlC.J(new String[]{this.jlB});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cCX() {
        this.jlC.cDK();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cCY() {
        this.jlC.cCD();
    }

    private boolean cDF() {
        if (this.jll != this.jlx || this.jdz > -1) {
            this.jlC.Nv();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDG() {
        Intent intent = new Intent();
        if (this.jlA == null) {
            if (this.jdz > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.jlB);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.jlz);
                intent.putExtra("ResultDataAddress", this.jly);
            }
        } else if (this.jdz > -1 && this.jdz < this.jlA.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.jlA[this.jdz]);
            intent.putExtra("ResultDataAddress", this.jlB);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.jlz);
            intent.putExtra("ResultDataAddress", this.jly);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.jll);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jlC.onChangeSkinType(i);
    }
}
