package com.baidu.tieba.account;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private com.baidu.tieba.f j;
    private View a = null;
    private Dialog b = null;
    private EditText c = null;
    private RadioGroup d = null;
    private CompoundButton.OnCheckedChangeListener e = null;
    private RadioButton f = null;
    private RadioButton g = null;
    private RadioButton h = null;
    private Button i = null;
    private Button k = null;
    private af l = null;
    private ae m = null;
    private TextView n = null;
    private Button o = null;
    private ProgressBar p = null;
    private ProgressBar q = null;
    private TextView r = null;
    private String s = null;
    private AccountData t = null;
    private ad u = null;
    private ad v = null;

    public y(com.baidu.tieba.f fVar) {
        this.j = null;
        this.j = fVar;
    }

    public void a(String str) {
        this.s = str;
    }

    public void a(AccountData accountData) {
        this.t = accountData;
    }

    public void a(ad adVar) {
        this.u = adVar;
    }

    public void b(ad adVar) {
        this.v = adVar;
    }

    public void a() {
        if (this.b == null) {
            this.a = this.j.getLayoutInflater().inflate(R.layout.main_input_username, (ViewGroup) null);
            this.c = (EditText) this.a.findViewById(R.id.account);
            this.c.setHint(String.valueOf(this.j.getString(R.string.input_name)) + ":");
            this.i = (Button) this.a.findViewById(R.id.back);
            this.i.setOnClickListener(new z(this));
            this.k = (Button) this.a.findViewById(R.id.check_username);
            this.k.setOnClickListener(new aa(this));
            this.p = (ProgressBar) this.a.findViewById(R.id.check_progress);
            this.o = (Button) this.a.findViewById(R.id.confirm);
            this.o.setOnClickListener(new ab(this));
            this.q = (ProgressBar) this.a.findViewById(R.id.confirm_progress);
            this.n = (TextView) this.a.findViewById(R.id.error_info);
            this.d = (RadioGroup) this.a.findViewById(R.id.names_group);
            this.f = (RadioButton) this.a.findViewById(R.id.name1);
            this.g = (RadioButton) this.a.findViewById(R.id.name2);
            this.h = (RadioButton) this.a.findViewById(R.id.name3);
            this.e = new ac(this);
            this.f.setOnCheckedChangeListener(this.e);
            this.g.setOnCheckedChangeListener(this.e);
            this.h.setOnCheckedChangeListener(this.e);
            this.r = (TextView) this.a.findViewById(R.id.phone_info);
            d();
            this.b = new Dialog(this.j, R.style.input_username_dialog);
            this.b.setCanceledOnTouchOutside(false);
            this.b.getWindow().setSoftInputMode(20);
            this.b.setCancelable(false);
            this.b.setCanceledOnTouchOutside(false);
        }
        if (!this.b.isShowing()) {
            this.c.setText((CharSequence) null);
            d();
            b((String) null);
            if (this.s == null || this.s.length() <= 0) {
                this.r.setText("Hi," + this.j.getString(R.string.bar_friend));
            } else {
                this.r.setText("Hi," + this.s);
            }
            this.b.show();
            this.b.setContentView(this.a);
            WindowManager.LayoutParams attributes = this.b.getWindow().getAttributes();
            attributes.gravity = 51;
            attributes.x = 0;
            attributes.y = 0;
            attributes.width = -1;
            attributes.height = -1;
            this.b.getWindow().setAttributes(attributes);
            this.j.ShowSoftKeyPadDelay(this.c, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
            this.c.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.v != null) {
            this.v.a(null);
        }
    }

    public void a(ArrayList<String> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.d.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.f.setText(arrayList.get(0));
                this.f.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.g.setText(arrayList.get(1));
                this.g.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.h.setText(arrayList.get(2));
                this.h.setVisibility(0);
            }
        }
    }

    public void b() {
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        e();
    }

    public boolean c() {
        return this.b != null && this.b.isShowing();
    }

    public void d() {
        this.d.setVisibility(8);
        this.d.clearCheck();
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.f.setChecked(false);
        this.g.setChecked(false);
        this.h.setChecked(false);
    }

    public void e() {
        if (this.b != null && this.b.isShowing()) {
            this.b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (str == null) {
            this.n.setVisibility(8);
            this.n.setText((CharSequence) null);
            return;
        }
        this.n.setVisibility(0);
        this.n.setText(str);
    }
}
