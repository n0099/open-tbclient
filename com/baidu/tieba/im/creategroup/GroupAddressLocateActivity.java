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
    private boolean gDu = false;
    private boolean gDG = false;
    private String gDH = null;
    private String gDI = null;
    private String[] gDJ = null;
    private String gDK = "";
    private int gwF = -1;
    private n gDL = null;
    a.b gDM = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bCh();
        }
    };
    a.b gDN = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.gDH = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.gDI = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.gDu = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.gDG = this.gDu;
        }
        this.gDL = new n(this, this.gDH, this.gDI, this.gDu);
        this.gDL.b(this.gDN);
        this.gDL.c(this.gDM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gDL != null) {
            this.gDL.bBT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gDL.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bCg()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gDL.bCe()) {
            bCh();
        } else if (view == this.gDL.getBackButton()) {
            if (!bCg()) {
                finish();
            }
        } else if (view == this.gDL.bCn()) {
            this.gDL.bCf();
            this.gDL.bCj();
            this.gwF = -1;
        } else if (view == this.gDL.bCo()) {
            switch (this.gDL.bBa()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.gDL.bCk();
                    this.gDL.bBS();
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
            this.gDL.bCk();
            this.gDL.bBS();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gDu = true;
        } else {
            this.gDu = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.gDL.bCf();
        this.gDL.bCi();
        this.gwF = i;
    }

    public int getSelectedPosition() {
        return this.gwF;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gDL.yC(String.valueOf(d));
        this.gDL.yB(String.valueOf(d2));
        this.gDK = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.gDI);
            this.gDJ = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.gDJ[i] = (String) arrayList.get(i);
            }
            this.gDL.x(this.gDJ);
        } else if (this.gDK.equals(this.gDH)) {
            this.gDL.x(new String[0]);
        } else {
            this.gDL.x(new String[]{this.gDK});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bBx() {
        this.gDL.bCl();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bBy() {
        this.gDL.bBc();
    }

    private boolean bCg() {
        if (this.gDu != this.gDG || this.gwF > -1) {
            this.gDL.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCh() {
        Intent intent = new Intent();
        if (this.gDJ == null) {
            if (this.gwF > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.gDK);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.gDI);
                intent.putExtra("ResultDataAddress", this.gDH);
            }
        } else if (this.gwF > -1 && this.gwF < this.gDJ.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.gDJ[this.gwF]);
            intent.putExtra("ResultDataAddress", this.gDK);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.gDI);
            intent.putExtra("ResultDataAddress", this.gDH);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.gDu);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gDL.onChangeSkinType(i);
    }
}
