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
/* loaded from: classes22.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean kbS = false;
    private boolean kce = false;
    private String kcf = null;
    private String kcg = null;
    private String[] kch = null;
    private String kci = "";
    private int jUj = -1;
    private n kcj = null;
    a.b kck = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cQj();
        }
    };
    a.b kcl = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.kcf = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.kcg = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.kbS = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.kce = this.kbS;
        }
        this.kcj = new n(this, this.kcf, this.kcg, this.kbS);
        this.kcj.b(this.kcl);
        this.kcj.c(this.kck);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kcj != null) {
            this.kcj.cPV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kcj.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cQi()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kcj.cQg()) {
            cQj();
        } else if (view == this.kcj.getBackButton()) {
            if (!cQi()) {
                finish();
            }
        } else if (view == this.kcj.cQp()) {
            this.kcj.cQh();
            this.kcj.cQl();
            this.jUj = -1;
        } else if (view == this.kcj.cQq()) {
            switch (this.kcj.cPe()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.kcj.cQm();
                    this.kcj.cPU();
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
            this.kcj.cQm();
            this.kcj.cPU();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.kcj.cPU();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.kbS = true;
        } else {
            this.kbS = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.kcj.cQh();
        this.kcj.cQk();
        this.jUj = i;
    }

    public int getSelectedPosition() {
        return this.jUj;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.kcj.LP(String.valueOf(d));
        this.kcj.LO(String.valueOf(d2));
        this.kci = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.kcg);
            this.kch = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.kch[i] = (String) arrayList.get(i);
            }
            this.kcj.M(this.kch);
        } else if (this.kci.equals(this.kcf)) {
            this.kcj.M(new String[0]);
        } else {
            this.kcj.M(new String[]{this.kci});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cPA() {
        this.kcj.cQn();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cPB() {
        this.kcj.cPg();
    }

    private boolean cQi() {
        if (this.kbS != this.kce || this.jUj > -1) {
            this.kcj.PA();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQj() {
        Intent intent = new Intent();
        if (this.kch == null) {
            if (this.jUj > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.kci);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.kcg);
                intent.putExtra("ResultDataAddress", this.kcf);
            }
        } else if (this.jUj > -1 && this.jUj < this.kch.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.kch[this.jUj]);
            intent.putExtra("ResultDataAddress", this.kci);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.kcg);
            intent.putExtra("ResultDataAddress", this.kcf);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.kbS);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kcj.onChangeSkinType(i);
    }
}
