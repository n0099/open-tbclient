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
    private boolean jIM = false;
    private boolean jIY = false;
    private String jIZ = null;
    private String jJa = null;
    private String[] jJb = null;
    private String jJc = "";
    private int jBd = -1;
    private n jJd = null;
    a.b jJe = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cKV();
        }
    };
    a.b jJf = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.jIZ = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.jJa = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.jIM = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.jIY = this.jIM;
        }
        this.jJd = new n(this, this.jIZ, this.jJa, this.jIM);
        this.jJd.b(this.jJf);
        this.jJd.c(this.jJe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jJd != null) {
            this.jJd.cKH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jJd.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cKU()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jJd.cKS()) {
            cKV();
        } else if (view == this.jJd.getBackButton()) {
            if (!cKU()) {
                finish();
            }
        } else if (view == this.jJd.cLb()) {
            this.jJd.cKT();
            this.jJd.cKX();
            this.jBd = -1;
        } else if (view == this.jJd.cLc()) {
            switch (this.jJd.cJQ()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.jJd.cKY();
                    this.jJd.cKG();
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
            this.jJd.cKY();
            this.jJd.cKG();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.jJd.cKG();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.jIM = true;
        } else {
            this.jIM = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.jJd.cKT();
        this.jJd.cKW();
        this.jBd = i;
    }

    public int getSelectedPosition() {
        return this.jBd;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.jJd.Lz(String.valueOf(d));
        this.jJd.Ly(String.valueOf(d2));
        this.jJc = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.jJa);
            this.jJb = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.jJb[i] = (String) arrayList.get(i);
            }
            this.jJd.K(this.jJb);
        } else if (this.jJc.equals(this.jIZ)) {
            this.jJd.K(new String[0]);
        } else {
            this.jJd.K(new String[]{this.jJc});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cKm() {
        this.jJd.cKZ();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cKn() {
        this.jJd.cJS();
    }

    private boolean cKU() {
        if (this.jIM != this.jIY || this.jBd > -1) {
            this.jJd.Pd();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKV() {
        Intent intent = new Intent();
        if (this.jJb == null) {
            if (this.jBd > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.jJc);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.jJa);
                intent.putExtra("ResultDataAddress", this.jIZ);
            }
        } else if (this.jBd > -1 && this.jBd < this.jJb.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.jJb[this.jBd]);
            intent.putExtra("ResultDataAddress", this.jJc);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.jJa);
            intent.putExtra("ResultDataAddress", this.jIZ);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.jIM);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jJd.onChangeSkinType(i);
    }
}
