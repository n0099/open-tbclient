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
    private boolean gfU = false;
    private boolean ggg = false;
    private String ggh = null;
    private String ggi = null;
    private String[] ggj = null;
    private String ggk = "";
    private int fZc = -1;
    private n ggl = null;
    a.b ggm = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.brM();
        }
    };
    a.b ggn = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.ggh = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.ggi = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.gfU = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.ggg = this.gfU;
        }
        this.ggl = new n(this, this.ggh, this.ggi, this.gfU);
        this.ggl.b(this.ggn);
        this.ggl.c(this.ggm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ggl != null) {
            this.ggl.bry();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ggl.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && brL()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ggl.brJ()) {
            brM();
        } else if (view == this.ggl.getBackButton()) {
            if (!brL()) {
                finish();
            }
        } else if (view == this.ggl.brS()) {
            this.ggl.brK();
            this.ggl.brO();
            this.fZc = -1;
        } else if (view == this.ggl.brT()) {
            switch (this.ggl.bqG()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.ggl.brP();
                    this.ggl.brx();
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
            this.ggl.brP();
            this.ggl.brx();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gfU = true;
        } else {
            this.gfU = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.ggl.brK();
        this.ggl.brN();
        this.fZc = i;
    }

    public int getSelectedPosition() {
        return this.fZc;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.ggl.wB(String.valueOf(d));
        this.ggl.wA(String.valueOf(d2));
        this.ggk = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.ggi);
            this.ggj = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.ggj[i] = (String) arrayList.get(i);
            }
            this.ggl.y(this.ggj);
        } else if (this.ggk.equals(this.ggh)) {
            this.ggl.y(new String[0]);
        } else {
            this.ggl.y(new String[]{this.ggk});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void brc() {
        this.ggl.brQ();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void brd() {
        this.ggl.bqI();
    }

    private boolean brL() {
        if (this.gfU != this.ggg || this.fZc > -1) {
            this.ggl.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brM() {
        Intent intent = new Intent();
        if (this.ggj == null) {
            if (this.fZc > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.ggk);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.ggi);
                intent.putExtra("ResultDataAddress", this.ggh);
            }
        } else if (this.fZc > -1 && this.fZc < this.ggj.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.ggj[this.fZc]);
            intent.putExtra("ResultDataAddress", this.ggk);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.ggi);
            intent.putExtra("ResultDataAddress", this.ggh);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.gfU);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ggl.onChangeSkinType(i);
    }
}
