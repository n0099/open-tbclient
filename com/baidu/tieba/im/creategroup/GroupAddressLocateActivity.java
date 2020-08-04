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
    private boolean iWg = false;
    private boolean iWs = false;
    private String iWt = null;
    private String iWu = null;
    private String[] iWv = null;
    private String iWw = "";
    private int iOw = -1;
    private n iWx = null;
    a.b iWy = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.csO();
        }
    };
    a.b iWz = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.iWt = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.iWu = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.iWg = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.iWs = this.iWg;
        }
        this.iWx = new n(this, this.iWt, this.iWu, this.iWg);
        this.iWx.b(this.iWz);
        this.iWx.c(this.iWy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iWx != null) {
            this.iWx.csA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iWx.onResume();
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
        if (view == this.iWx.csL()) {
            csO();
        } else if (view == this.iWx.getBackButton()) {
            if (!csN()) {
                finish();
            }
        } else if (view == this.iWx.csU()) {
            this.iWx.csM();
            this.iWx.csQ();
            this.iOw = -1;
        } else if (view == this.iWx.csV()) {
            switch (this.iWx.crI()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.iWx.csR();
                    this.iWx.csz();
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
            this.iWx.csR();
            this.iWx.csz();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.iWx.csz();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.iWg = true;
        } else {
            this.iWg = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.iWx.csM();
        this.iWx.csP();
        this.iOw = i;
    }

    public int getSelectedPosition() {
        return this.iOw;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.iWx.Hp(String.valueOf(d));
        this.iWx.Ho(String.valueOf(d2));
        this.iWw = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.iWu);
            this.iWv = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.iWv[i] = (String) arrayList.get(i);
            }
            this.iWx.I(this.iWv);
        } else if (this.iWw.equals(this.iWt)) {
            this.iWx.I(new String[0]);
        } else {
            this.iWx.I(new String[]{this.iWw});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void csf() {
        this.iWx.csS();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void csg() {
        this.iWx.crK();
    }

    private boolean csN() {
        if (this.iWg != this.iWs || this.iOw > -1) {
            this.iWx.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csO() {
        Intent intent = new Intent();
        if (this.iWv == null) {
            if (this.iOw > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.iWw);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.iWu);
                intent.putExtra("ResultDataAddress", this.iWt);
            }
        } else if (this.iOw > -1 && this.iOw < this.iWv.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.iWv[this.iOw]);
            intent.putExtra("ResultDataAddress", this.iWw);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.iWu);
            intent.putExtra("ResultDataAddress", this.iWt);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.iWg);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iWx.onChangeSkinType(i);
    }
}
