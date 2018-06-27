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
    private boolean elu = false;
    private boolean elG = false;
    private String elH = null;
    private String elI = null;
    private String[] elJ = null;
    private String elK = "";
    private int eeE = -1;
    private n elL = null;
    a.b elM = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aIg();
        }
    };
    a.b elN = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.elH = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.elI = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.elu = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.elG = this.elu;
        }
        this.elL = new n(this, this.elH, this.elI, this.elu);
        this.elL.a(this.elN);
        this.elL.b(this.elM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.elL != null) {
            this.elL.aHT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.elL.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aIf()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.elL.aId()) {
            aIg();
        } else if (view == this.elL.getBackButton()) {
            if (!aIf()) {
                finish();
            }
        } else if (view == this.elL.aIm()) {
            this.elL.aIe();
            this.elL.aIi();
            this.eeE = -1;
        } else if (view == this.elL.aIn()) {
            switch (this.elL.aHa()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.elL.aIj();
                    this.elL.aHS();
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
            this.elL.aIj();
            this.elL.aHS();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.elu = true;
        } else {
            this.elu = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.elL.aIe();
        this.elL.aIh();
        this.eeE = i;
    }

    public int getSelectedPosition() {
        return this.eeE;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.elL.nP(String.valueOf(d));
        this.elL.nO(String.valueOf(d2));
        this.elK = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.elI);
            this.elJ = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.elJ[i] = (String) arrayList.get(i);
            }
            this.elL.v(this.elJ);
        } else if (this.elK.equals(this.elH)) {
            this.elL.v(new String[0]);
        } else {
            this.elL.v(new String[]{this.elK});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aHw() {
        this.elL.aIk();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aHx() {
        this.elL.aHc();
    }

    private boolean aIf() {
        if (this.elu != this.elG || this.eeE > -1) {
            this.elL.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIg() {
        Intent intent = new Intent();
        if (this.elJ == null) {
            if (this.eeE > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.elK);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.elI);
                intent.putExtra("ResultDataAddress", this.elH);
            }
        } else if (this.eeE > -1 && this.eeE < this.elJ.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.elJ[this.eeE]);
            intent.putExtra("ResultDataAddress", this.elK);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.elI);
            intent.putExtra("ResultDataAddress", this.elH);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.elu);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.elL.onChangeSkinType(i);
    }
}
