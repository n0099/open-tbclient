package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GroupAddressLocateActivity extends BaseActivity implements AdapterView.OnItemClickListener, com.baidu.adp.widget.BdSwitchView.c, com.baidu.tieba.im.util.g {
    private boolean aUn = false;
    private boolean aUC = false;
    private String aUD = null;
    private String aUE = null;
    private String[] aUF = null;
    private String aUG = "";
    private int aUH = -1;
    private v aUI = null;
    DialogInterface.OnClickListener aUJ = new s(this);
    DialogInterface.OnClickListener aUK = new t(this);

    public static void a(Activity activity, int i, String str, String str2, boolean z) {
        Intent intent = new Intent(activity, GroupAddressLocateActivity.class);
        intent.putExtra("IntentDataOldAddress", str);
        intent.putExtra("IntentDataOldBusiness", str2);
        intent.putExtra("IntentDataIsHiddenAddress", z);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aUD = intent.getStringExtra("IntentDataOldAddress");
            this.aUE = intent.getStringExtra("IntentDataOldBusiness");
            this.aUn = intent.getBooleanExtra("IntentDataIsHiddenAddress", false);
            this.aUC = this.aUn;
        }
        this.aUI = new v(this, this.aUD, this.aUE, this.aUn);
        this.aUI.c(this.aUK);
        this.aUI.d(this.aUJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aUI != null) {
            this.aUI.LO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aUI.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && Mc()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aUI.LZ()) {
            Md();
        } else if (view == this.aUI.Ma()) {
            if (!Mc()) {
                finish();
            }
        } else if (view == this.aUI.Mj()) {
            this.aUI.Mb();
            this.aUI.Mf();
            this.aUH = -1;
        } else if (view == this.aUI.Mk()) {
            switch (this.aUI.KV()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.aUI.Mg();
                    this.aUI.LN();
                    return;
                case 3:
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.aUI.Mg();
            this.aUI.LN();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.aUn = true;
        } else {
            this.aUn = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.aUI.Mb();
        this.aUI.Me();
        this.aUH = i;
    }

    public int sg() {
        return this.aUH;
    }

    @Override // com.baidu.tieba.im.util.g
    public void a(String str, List<String> list, double d, double d2) {
        this.aUI.fN(String.valueOf(d));
        this.aUI.fM(String.valueOf(d2));
        this.aUG = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.aUE);
            this.aUF = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.aUF[i] = (String) arrayList.get(i);
            }
            this.aUI.w(this.aUF);
        } else if (this.aUG.equals(this.aUD)) {
            this.aUI.w(new String[0]);
        } else {
            this.aUI.w(new String[]{this.aUG});
        }
    }

    @Override // com.baidu.tieba.im.util.g
    public void Lr() {
        this.aUI.Mh();
    }

    @Override // com.baidu.tieba.im.util.g
    public void Ls() {
        this.aUI.KX();
    }

    private boolean Mc() {
        if (this.aUn != this.aUC || this.aUH > -1) {
            this.aUI.Ml();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Md() {
        Intent intent = new Intent();
        if (this.aUF == null) {
            if (this.aUH > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.aUG);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.aUE);
                intent.putExtra("ResultDataAddress", this.aUD);
            }
        } else if (this.aUH > -1 && this.aUH < this.aUF.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.aUF[this.aUH]);
            intent.putExtra("ResultDataAddress", this.aUG);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.aUE);
            intent.putExtra("ResultDataAddress", this.aUD);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.aUn);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aUI.onChangeSkinType(i);
    }
}
