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
    private boolean iWe = false;
    private boolean iWq = false;
    private String iWr = null;
    private String iWs = null;
    private String[] iWt = null;
    private String iWu = "";
    private int iOu = -1;
    private n iWv = null;
    a.b iWw = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.csO();
        }
    };
    a.b iWx = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.iWr = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.iWs = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.iWe = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.iWq = this.iWe;
        }
        this.iWv = new n(this, this.iWr, this.iWs, this.iWe);
        this.iWv.b(this.iWx);
        this.iWv.c(this.iWw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iWv != null) {
            this.iWv.csA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iWv.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && csN()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iWv.csL()) {
            csO();
        } else if (view == this.iWv.getBackButton()) {
            if (!csN()) {
                finish();
            }
        } else if (view == this.iWv.csU()) {
            this.iWv.csM();
            this.iWv.csQ();
            this.iOu = -1;
        } else if (view == this.iWv.csV()) {
            switch (this.iWv.crI()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.iWv.csR();
                    this.iWv.csz();
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
            this.iWv.csR();
            this.iWv.csz();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.iWv.csz();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.iWe = true;
        } else {
            this.iWe = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.iWv.csM();
        this.iWv.csP();
        this.iOu = i;
    }

    public int getSelectedPosition() {
        return this.iOu;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.iWv.Hp(String.valueOf(d));
        this.iWv.Ho(String.valueOf(d2));
        this.iWu = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.iWs);
            this.iWt = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.iWt[i] = (String) arrayList.get(i);
            }
            this.iWv.I(this.iWt);
        } else if (this.iWu.equals(this.iWr)) {
            this.iWv.I(new String[0]);
        } else {
            this.iWv.I(new String[]{this.iWu});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void csf() {
        this.iWv.csS();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void csg() {
        this.iWv.crK();
    }

    private boolean csN() {
        if (this.iWe != this.iWq || this.iOu > -1) {
            this.iWv.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csO() {
        Intent intent = new Intent();
        if (this.iWt == null) {
            if (this.iOu > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.iWu);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.iWs);
                intent.putExtra("ResultDataAddress", this.iWr);
            }
        } else if (this.iOu > -1 && this.iOu < this.iWt.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.iWt[this.iOu]);
            intent.putExtra("ResultDataAddress", this.iWu);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.iWs);
            intent.putExtra("ResultDataAddress", this.iWr);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.iWe);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iWv.onChangeSkinType(i);
    }
}
