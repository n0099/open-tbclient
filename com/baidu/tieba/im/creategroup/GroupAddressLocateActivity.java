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
/* loaded from: classes5.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean gEm = false;
    private boolean gEy = false;
    private String gEz = null;
    private String gEA = null;
    private String[] gEB = null;
    private String gEC = "";
    private int gxx = -1;
    private n gED = null;
    a.b gEE = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bCv();
        }
    };
    a.b gEF = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.gEz = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.gEA = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.gEm = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.gEy = this.gEm;
        }
        this.gED = new n(this, this.gEz, this.gEA, this.gEm);
        this.gED.b(this.gEF);
        this.gED.c(this.gEE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gED != null) {
            this.gED.bCh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gED.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bCu()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gED.bCs()) {
            bCv();
        } else if (view == this.gED.getBackButton()) {
            if (!bCu()) {
                finish();
            }
        } else if (view == this.gED.bCB()) {
            this.gED.bCt();
            this.gED.bCx();
            this.gxx = -1;
        } else if (view == this.gED.bCC()) {
            switch (this.gED.bBo()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.gED.bCy();
                    this.gED.bCg();
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
            this.gED.bCy();
            this.gED.bCg();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gEm = true;
        } else {
            this.gEm = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.gED.bCt();
        this.gED.bCw();
        this.gxx = i;
    }

    public int getSelectedPosition() {
        return this.gxx;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gED.yD(String.valueOf(d));
        this.gED.yC(String.valueOf(d2));
        this.gEC = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.gEA);
            this.gEB = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.gEB[i] = (String) arrayList.get(i);
            }
            this.gED.x(this.gEB);
        } else if (this.gEC.equals(this.gEz)) {
            this.gED.x(new String[0]);
        } else {
            this.gED.x(new String[]{this.gEC});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bBL() {
        this.gED.bCz();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bBM() {
        this.gED.bBq();
    }

    private boolean bCu() {
        if (this.gEm != this.gEy || this.gxx > -1) {
            this.gED.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCv() {
        Intent intent = new Intent();
        if (this.gEB == null) {
            if (this.gxx > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.gEC);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.gEA);
                intent.putExtra("ResultDataAddress", this.gEz);
            }
        } else if (this.gxx > -1 && this.gxx < this.gEB.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.gEB[this.gxx]);
            intent.putExtra("ResultDataAddress", this.gEC);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.gEA);
            intent.putExtra("ResultDataAddress", this.gEz);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.gEm);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gED.onChangeSkinType(i);
    }
}
