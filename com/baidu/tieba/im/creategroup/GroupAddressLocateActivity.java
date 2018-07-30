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
    private boolean epn = false;
    private boolean epz = false;
    private String epA = null;
    private String epB = null;
    private String[] epC = null;
    private String epD = "";
    private int eiu = -1;
    private n epE = null;
    a.b epF = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aJh();
        }
    };
    a.b epG = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.epA = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.epB = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.epn = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.epz = this.epn;
        }
        this.epE = new n(this, this.epA, this.epB, this.epn);
        this.epE.a(this.epG);
        this.epE.b(this.epF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.epE != null) {
            this.epE.aIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.epE.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aJg()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.epE.aJe()) {
            aJh();
        } else if (view == this.epE.getBackButton()) {
            if (!aJg()) {
                finish();
            }
        } else if (view == this.epE.aJn()) {
            this.epE.aJf();
            this.epE.aJj();
            this.eiu = -1;
        } else if (view == this.epE.aJo()) {
            switch (this.epE.aIa()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.epE.aJk();
                    this.epE.aIS();
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
            this.epE.aJk();
            this.epE.aIS();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.epn = true;
        } else {
            this.epn = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.epE.aJf();
        this.epE.aJi();
        this.eiu = i;
    }

    public int getSelectedPosition() {
        return this.eiu;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.epE.nR(String.valueOf(d));
        this.epE.nQ(String.valueOf(d2));
        this.epD = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.epB);
            this.epC = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.epC[i] = (String) arrayList.get(i);
            }
            this.epE.u(this.epC);
        } else if (this.epD.equals(this.epA)) {
            this.epE.u(new String[0]);
        } else {
            this.epE.u(new String[]{this.epD});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aIw() {
        this.epE.aJl();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aIx() {
        this.epE.aIc();
    }

    private boolean aJg() {
        if (this.epn != this.epz || this.eiu > -1) {
            this.epE.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJh() {
        Intent intent = new Intent();
        if (this.epC == null) {
            if (this.eiu > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.epD);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.epB);
                intent.putExtra("ResultDataAddress", this.epA);
            }
        } else if (this.eiu > -1 && this.eiu < this.epC.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.epC[this.eiu]);
            intent.putExtra("ResultDataAddress", this.epD);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.epB);
            intent.putExtra("ResultDataAddress", this.epA);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.epn);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.epE.onChangeSkinType(i);
    }
}
