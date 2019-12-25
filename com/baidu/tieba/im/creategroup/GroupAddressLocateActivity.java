package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
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
/* loaded from: classes7.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean hrr = false;
    private boolean hrD = false;
    private String hrE = null;
    private String hrF = null;
    private String[] hrG = null;
    private String hrH = "";
    private int hkC = -1;
    private n hrI = null;
    a.b hrJ = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bRi();
        }
    };
    a.b hrK = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.hrE = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.hrF = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.hrr = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.hrD = this.hrr;
        }
        this.hrI = new n(this, this.hrE, this.hrF, this.hrr);
        this.hrI.b(this.hrK);
        this.hrI.c(this.hrJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hrI != null) {
            this.hrI.bQU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hrI.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bRh()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hrI.bRf()) {
            bRi();
        } else if (view == this.hrI.getBackButton()) {
            if (!bRh()) {
                finish();
            }
        } else if (view == this.hrI.bRo()) {
            this.hrI.bRg();
            this.hrI.bRk();
            this.hkC = -1;
        } else if (view == this.hrI.bRp()) {
            switch (this.hrI.bQc()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.hrI.bRl();
                    this.hrI.bQT();
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
            this.hrI.bRl();
            this.hrI.bQT();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.hrr = true;
        } else {
            this.hrr = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.hrI.bRg();
        this.hrI.bRj();
        this.hkC = i;
    }

    public int getSelectedPosition() {
        return this.hkC;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.hrI.Ce(String.valueOf(d));
        this.hrI.Cd(String.valueOf(d2));
        this.hrH = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.hrF);
            this.hrG = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.hrG[i] = (String) arrayList.get(i);
            }
            this.hrI.H(this.hrG);
        } else if (this.hrH.equals(this.hrE)) {
            this.hrI.H(new String[0]);
        } else {
            this.hrI.H(new String[]{this.hrH});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void onLoadFailed() {
        this.hrI.bRm();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bQz() {
        this.hrI.bQe();
    }

    private boolean bRh() {
        if (this.hrr != this.hrD || this.hkC > -1) {
            this.hrI.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRi() {
        Intent intent = new Intent();
        if (this.hrG == null) {
            if (this.hkC > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.hrH);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.hrF);
                intent.putExtra("ResultDataAddress", this.hrE);
            }
        } else if (this.hkC > -1 && this.hkC < this.hrG.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.hrG[this.hkC]);
            intent.putExtra("ResultDataAddress", this.hrH);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.hrF);
            intent.putExtra("ResultDataAddress", this.hrE);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.hrr);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hrI.onChangeSkinType(i);
    }
}
