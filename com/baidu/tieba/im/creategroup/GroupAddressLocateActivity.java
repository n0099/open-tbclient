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
    private boolean jtP = false;
    private boolean jub = false;
    private String juc = null;
    private String jud = null;
    private String[] jue = null;
    private String juf = "";
    private int jmf = -1;
    private n jug = null;
    a.b juh = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cHm();
        }
    };
    a.b jui = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.juc = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.jud = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.jtP = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.jub = this.jtP;
        }
        this.jug = new n(this, this.juc, this.jud, this.jtP);
        this.jug.b(this.jui);
        this.jug.c(this.juh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jug != null) {
            this.jug.cGY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jug.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cHl()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jug.cHj()) {
            cHm();
        } else if (view == this.jug.getBackButton()) {
            if (!cHl()) {
                finish();
            }
        } else if (view == this.jug.cHs()) {
            this.jug.cHk();
            this.jug.cHo();
            this.jmf = -1;
        } else if (view == this.jug.cHt()) {
            switch (this.jug.cGh()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.jug.cHp();
                    this.jug.cGX();
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
            this.jug.cHp();
            this.jug.cGX();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.jug.cGX();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.jtP = true;
        } else {
            this.jtP = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.jug.cHk();
        this.jug.cHn();
        this.jmf = i;
    }

    public int getSelectedPosition() {
        return this.jmf;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.jug.KK(String.valueOf(d));
        this.jug.KJ(String.valueOf(d2));
        this.juf = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.jud);
            this.jue = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.jue[i] = (String) arrayList.get(i);
            }
            this.jug.J(this.jue);
        } else if (this.juf.equals(this.juc)) {
            this.jug.J(new String[0]);
        } else {
            this.jug.J(new String[]{this.juf});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cGD() {
        this.jug.cHq();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cGE() {
        this.jug.cGj();
    }

    private boolean cHl() {
        if (this.jtP != this.jub || this.jmf > -1) {
            this.jug.NY();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHm() {
        Intent intent = new Intent();
        if (this.jue == null) {
            if (this.jmf > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.juf);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.jud);
                intent.putExtra("ResultDataAddress", this.juc);
            }
        } else if (this.jmf > -1 && this.jmf < this.jue.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.jue[this.jmf]);
            intent.putExtra("ResultDataAddress", this.juf);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.jud);
            intent.putExtra("ResultDataAddress", this.juc);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.jtP);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jug.onChangeSkinType(i);
    }
}
