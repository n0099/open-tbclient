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
public class GroupAddressLocateActivity extends BaseActivity implements AdapterView.OnItemClickListener, com.baidu.adp.widget.BdSwitchView.c, com.baidu.tieba.im.e.h {
    private boolean c = false;
    private boolean d = false;
    private String e = null;
    private String f = null;
    private String[] g = null;
    private String h = "";
    private int i = -1;
    private u j = null;
    DialogInterface.OnClickListener a = new r(this);
    DialogInterface.OnClickListener b = new s(this);

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
            this.e = intent.getStringExtra("IntentDataOldAddress");
            this.f = intent.getStringExtra("IntentDataOldBusiness");
            this.c = intent.getBooleanExtra("IntentDataIsHiddenAddress", false);
            this.d = this.c;
        }
        this.j = new u(this, this.e, this.f, this.c);
        this.j.a(this.b);
        this.j.b(this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.j != null) {
            this.j.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.j.i();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && d()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.j.j()) {
            e();
        } else if (view == this.j.k()) {
            if (!d()) {
                finish();
            }
        } else if (view == this.j.l()) {
            this.j.e();
            this.j.d();
            this.i = -1;
        } else if (view == this.j.m()) {
            switch (this.j.n()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.j.f();
                    this.j.a();
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
            this.j.f();
            this.j.a();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.c = true;
        } else {
            this.c = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.j.e();
        this.j.c();
        this.i = i;
    }

    public int c() {
        return this.i;
    }

    @Override // com.baidu.tieba.im.e.h
    public void a(String str, List<String> list, double d, double d2) {
        this.j.b(String.valueOf(d));
        this.j.a(String.valueOf(d2));
        this.h = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.f);
            this.g = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.g[i] = (String) arrayList.get(i);
            }
            this.j.a(this.g);
        } else if (this.h.equals(this.e)) {
            this.j.a(new String[0]);
        } else {
            this.j.a(new String[]{this.h});
        }
    }

    @Override // com.baidu.tieba.im.e.h
    public void a() {
        this.j.g();
    }

    @Override // com.baidu.tieba.im.e.h
    public void b() {
        this.j.h();
    }

    private boolean d() {
        if (this.c != this.d || this.i > -1) {
            this.j.o();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Intent intent = new Intent();
        if (this.g == null) {
            if (this.i > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.h);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.f);
                intent.putExtra("ResultDataAddress", this.e);
            }
        } else if (this.i > -1 && this.i < this.g.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.g[this.i]);
            intent.putExtra("ResultDataAddress", this.h);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.f);
            intent.putExtra("ResultDataAddress", this.e);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.c);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.j.a(i);
    }
}
