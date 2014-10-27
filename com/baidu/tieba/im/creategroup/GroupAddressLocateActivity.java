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
    private boolean aTZ = false;
    private boolean aUo = false;
    private String aUp = null;
    private String aUq = null;
    private String[] aUr = null;
    private String aUs = "";
    private int aUt = -1;
    private v aUu = null;
    DialogInterface.OnClickListener aUv = new s(this);
    DialogInterface.OnClickListener aUw = new t(this);

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
            this.aUp = intent.getStringExtra("IntentDataOldAddress");
            this.aUq = intent.getStringExtra("IntentDataOldBusiness");
            this.aTZ = intent.getBooleanExtra("IntentDataIsHiddenAddress", false);
            this.aUo = this.aTZ;
        }
        this.aUu = new v(this, this.aUp, this.aUq, this.aTZ);
        this.aUu.c(this.aUw);
        this.aUu.d(this.aUv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aUu != null) {
            this.aUu.LK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aUu.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && LY()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aUu.LV()) {
            LZ();
        } else if (view == this.aUu.LW()) {
            if (!LY()) {
                finish();
            }
        } else if (view == this.aUu.Mf()) {
            this.aUu.LX();
            this.aUu.Mb();
            this.aUt = -1;
        } else if (view == this.aUu.Mg()) {
            switch (this.aUu.KR()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.aUu.Mc();
                    this.aUu.LJ();
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
            this.aUu.Mc();
            this.aUu.LJ();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.aTZ = true;
        } else {
            this.aTZ = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.aUu.LX();
        this.aUu.Ma();
        this.aUt = i;
    }

    public int se() {
        return this.aUt;
    }

    @Override // com.baidu.tieba.im.util.g
    public void a(String str, List<String> list, double d, double d2) {
        this.aUu.fN(String.valueOf(d));
        this.aUu.fM(String.valueOf(d2));
        this.aUs = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.aUq);
            this.aUr = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.aUr[i] = (String) arrayList.get(i);
            }
            this.aUu.w(this.aUr);
        } else if (this.aUs.equals(this.aUp)) {
            this.aUu.w(new String[0]);
        } else {
            this.aUu.w(new String[]{this.aUs});
        }
    }

    @Override // com.baidu.tieba.im.util.g
    public void Ln() {
        this.aUu.Md();
    }

    @Override // com.baidu.tieba.im.util.g
    public void Lo() {
        this.aUu.KT();
    }

    private boolean LY() {
        if (this.aTZ != this.aUo || this.aUt > -1) {
            this.aUu.Mh();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LZ() {
        Intent intent = new Intent();
        if (this.aUr == null) {
            if (this.aUt > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.aUs);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.aUq);
                intent.putExtra("ResultDataAddress", this.aUp);
            }
        } else if (this.aUt > -1 && this.aUt < this.aUr.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.aUr[this.aUt]);
            intent.putExtra("ResultDataAddress", this.aUs);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.aUq);
            intent.putExtra("ResultDataAddress", this.aUp);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.aTZ);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aUu.onChangeSkinType(i);
    }
}
