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
    private boolean ggg = false;
    private boolean ggs = false;
    private String ggt = null;
    private String ggu = null;
    private String[] ggv = null;
    private String ggw = "";
    private int fZo = -1;
    private n ggx = null;
    a.b ggy = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.brP();
        }
    };
    a.b ggz = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.ggt = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.ggu = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.ggg = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.ggs = this.ggg;
        }
        this.ggx = new n(this, this.ggt, this.ggu, this.ggg);
        this.ggx.b(this.ggz);
        this.ggx.c(this.ggy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ggx != null) {
            this.ggx.brB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ggx.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && brO()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ggx.brM()) {
            brP();
        } else if (view == this.ggx.getBackButton()) {
            if (!brO()) {
                finish();
            }
        } else if (view == this.ggx.brV()) {
            this.ggx.brN();
            this.ggx.brR();
            this.fZo = -1;
        } else if (view == this.ggx.brW()) {
            switch (this.ggx.bqJ()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.ggx.brS();
                    this.ggx.brA();
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
            this.ggx.brS();
            this.ggx.brA();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.ggg = true;
        } else {
            this.ggg = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.ggx.brN();
        this.ggx.brQ();
        this.fZo = i;
    }

    public int getSelectedPosition() {
        return this.fZo;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.ggx.wC(String.valueOf(d));
        this.ggx.wB(String.valueOf(d2));
        this.ggw = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.ggu);
            this.ggv = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.ggv[i] = (String) arrayList.get(i);
            }
            this.ggx.y(this.ggv);
        } else if (this.ggw.equals(this.ggt)) {
            this.ggx.y(new String[0]);
        } else {
            this.ggx.y(new String[]{this.ggw});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void brf() {
        this.ggx.brT();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void brg() {
        this.ggx.bqL();
    }

    private boolean brO() {
        if (this.ggg != this.ggs || this.fZo > -1) {
            this.ggx.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brP() {
        Intent intent = new Intent();
        if (this.ggv == null) {
            if (this.fZo > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.ggw);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.ggu);
                intent.putExtra("ResultDataAddress", this.ggt);
            }
        } else if (this.fZo > -1 && this.fZo < this.ggv.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.ggv[this.fZo]);
            intent.putExtra("ResultDataAddress", this.ggw);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.ggu);
            intent.putExtra("ResultDataAddress", this.ggt);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.ggg);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ggx.onChangeSkinType(i);
    }
}
