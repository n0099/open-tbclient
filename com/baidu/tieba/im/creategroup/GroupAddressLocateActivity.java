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
    private boolean iPb = false;
    private boolean iPn = false;
    private String iPo = null;
    private String iPp = null;
    private String[] iPq = null;
    private String iPr = "";
    private int iIp = -1;
    private n iPs = null;
    a.b iPt = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cpj();
        }
    };
    a.b iPu = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.iPo = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.iPp = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.iPb = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.iPn = this.iPb;
        }
        this.iPs = new n(this, this.iPo, this.iPp, this.iPb);
        this.iPs.b(this.iPu);
        this.iPs.c(this.iPt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iPs != null) {
            this.iPs.coV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iPs.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cpi()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iPs.cpg()) {
            cpj();
        } else if (view == this.iPs.getBackButton()) {
            if (!cpi()) {
                finish();
            }
        } else if (view == this.iPs.cpp()) {
            this.iPs.cph();
            this.iPs.cpl();
            this.iIp = -1;
        } else if (view == this.iPs.cpq()) {
            switch (this.iPs.cod()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.iPs.cpm();
                    this.iPs.coU();
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
            this.iPs.cpm();
            this.iPs.coU();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.iPs.coU();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.iPb = true;
        } else {
            this.iPb = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.iPs.cph();
        this.iPs.cpk();
        this.iIp = i;
    }

    public int getSelectedPosition() {
        return this.iIp;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.iPs.GB(String.valueOf(d));
        this.iPs.GA(String.valueOf(d2));
        this.iPr = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.iPp);
            this.iPq = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.iPq[i] = (String) arrayList.get(i);
            }
            this.iPs.K(this.iPq);
        } else if (this.iPr.equals(this.iPo)) {
            this.iPs.K(new String[0]);
        } else {
            this.iPs.K(new String[]{this.iPr});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void coA() {
        this.iPs.cpn();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void coB() {
        this.iPs.cof();
    }

    private boolean cpi() {
        if (this.iPb != this.iPn || this.iIp > -1) {
            this.iPs.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpj() {
        Intent intent = new Intent();
        if (this.iPq == null) {
            if (this.iIp > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.iPr);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.iPp);
                intent.putExtra("ResultDataAddress", this.iPo);
            }
        } else if (this.iIp > -1 && this.iIp < this.iPq.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.iPq[this.iIp]);
            intent.putExtra("ResultDataAddress", this.iPr);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.iPp);
            intent.putExtra("ResultDataAddress", this.iPo);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.iPb);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iPs.onChangeSkinType(i);
    }
}
