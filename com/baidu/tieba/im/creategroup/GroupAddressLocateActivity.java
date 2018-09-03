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
    private boolean epj = false;
    private boolean epv = false;
    private String epw = null;
    private String epx = null;
    private String[] epy = null;
    private String epz = "";
    private int eiq = -1;
    private n epA = null;
    a.b epB = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.aJe();
        }
    };
    a.b epC = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.epw = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.epx = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.epj = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.epv = this.epj;
        }
        this.epA = new n(this, this.epw, this.epx, this.epj);
        this.epA.a(this.epC);
        this.epA.b(this.epB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.epA != null) {
            this.epA.aIQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.epA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aJd()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.epA.aJb()) {
            aJe();
        } else if (view == this.epA.getBackButton()) {
            if (!aJd()) {
                finish();
            }
        } else if (view == this.epA.aJk()) {
            this.epA.aJc();
            this.epA.aJg();
            this.eiq = -1;
        } else if (view == this.epA.aJl()) {
            switch (this.epA.aHX()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.epA.aJh();
                    this.epA.aIP();
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
            this.epA.aJh();
            this.epA.aIP();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.epj = true;
        } else {
            this.epj = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.epA.aJc();
        this.epA.aJf();
        this.eiq = i;
    }

    public int getSelectedPosition() {
        return this.eiq;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.epA.nT(String.valueOf(d));
        this.epA.nS(String.valueOf(d2));
        this.epz = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.epx);
            this.epy = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.epy[i] = (String) arrayList.get(i);
            }
            this.epA.t(this.epy);
        } else if (this.epz.equals(this.epw)) {
            this.epA.t(new String[0]);
        } else {
            this.epA.t(new String[]{this.epz});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aIt() {
        this.epA.aJi();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void aIu() {
        this.epA.aHZ();
    }

    private boolean aJd() {
        if (this.epj != this.epv || this.eiq > -1) {
            this.epA.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJe() {
        Intent intent = new Intent();
        if (this.epy == null) {
            if (this.eiq > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.epz);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.epx);
                intent.putExtra("ResultDataAddress", this.epw);
            }
        } else if (this.eiq > -1 && this.eiq < this.epy.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.epy[this.eiq]);
            intent.putExtra("ResultDataAddress", this.epz);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.epx);
            intent.putExtra("ResultDataAddress", this.epw);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.epj);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.epA.onChangeSkinType(i);
    }
}
