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
    private boolean ewC = false;
    private boolean ewO = false;
    private String ewP = null;
    private String ewQ = null;
    private String[] ewR = null;
    private String ewS = "";
    private int epJ = -1;
    private n ewT = null;
    a.b ewU = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aLt();
        }
    };
    a.b ewV = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.ewP = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.ewQ = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.ewC = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.ewO = this.ewC;
        }
        this.ewT = new n(this, this.ewP, this.ewQ, this.ewC);
        this.ewT.a(this.ewV);
        this.ewT.b(this.ewU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ewT != null) {
            this.ewT.aLf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ewT.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aLs()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ewT.aLq()) {
            aLt();
        } else if (view == this.ewT.getBackButton()) {
            if (!aLs()) {
                finish();
            }
        } else if (view == this.ewT.aLz()) {
            this.ewT.aLr();
            this.ewT.aLv();
            this.epJ = -1;
        } else if (view == this.ewT.aLA()) {
            switch (this.ewT.aKm()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.ewT.aLw();
                    this.ewT.aLe();
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
            this.ewT.aLw();
            this.ewT.aLe();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.ewC = true;
        } else {
            this.ewC = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.ewT.aLr();
        this.ewT.aLu();
        this.epJ = i;
    }

    public int getSelectedPosition() {
        return this.epJ;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.ewT.oA(String.valueOf(d));
        this.ewT.oz(String.valueOf(d2));
        this.ewS = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.ewQ);
            this.ewR = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.ewR[i] = (String) arrayList.get(i);
            }
            this.ewT.v(this.ewR);
        } else if (this.ewS.equals(this.ewP)) {
            this.ewT.v(new String[0]);
        } else {
            this.ewT.v(new String[]{this.ewS});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aKI() {
        this.ewT.aLx();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aKJ() {
        this.ewT.aKo();
    }

    private boolean aLs() {
        if (this.ewC != this.ewO || this.epJ > -1) {
            this.ewT.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLt() {
        Intent intent = new Intent();
        if (this.ewR == null) {
            if (this.epJ > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.ewS);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.ewQ);
                intent.putExtra("ResultDataAddress", this.ewP);
            }
        } else if (this.epJ > -1 && this.epJ < this.ewR.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.ewR[this.epJ]);
            intent.putExtra("ResultDataAddress", this.ewS);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.ewQ);
            intent.putExtra("ResultDataAddress", this.ewP);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.ewC);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ewT.onChangeSkinType(i);
    }
}
