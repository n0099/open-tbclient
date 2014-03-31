package com.baidu.tbadk.coreExtra.view;

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
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class p {
    private com.baidu.tbadk.a j;
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
    private w l = null;
    private v m = null;
    private TextView n = null;
    private Button o = null;
    private ProgressBar p = null;
    private ProgressBar q = null;
    private TextView r = null;
    private String s = null;
    private AccountData t = null;
    private u u = null;
    private u v = null;

    public p(com.baidu.tbadk.a aVar) {
        this.j = null;
        this.j = aVar;
    }

    public final void a(String str) {
        this.s = str;
    }

    public final void a(AccountData accountData) {
        this.t = accountData;
    }

    public final void a(u uVar) {
        this.u = uVar;
    }

    public final void b(u uVar) {
        this.v = uVar;
    }

    public final void a() {
        if (this.b == null) {
            this.a = this.j.getLayoutInflater().inflate(com.baidu.tbadk.k.main_input_username, (ViewGroup) null);
            this.c = (EditText) this.a.findViewById(com.baidu.tbadk.j.account);
            this.c.setHint(String.valueOf(this.j.getString(com.baidu.tbadk.l.input_name)) + ":");
            this.i = (Button) this.a.findViewById(com.baidu.tbadk.j.back);
            this.i.setOnClickListener(new q(this));
            this.k = (Button) this.a.findViewById(com.baidu.tbadk.j.check_username);
            this.k.setOnClickListener(new r(this));
            this.p = (ProgressBar) this.a.findViewById(com.baidu.tbadk.j.check_progress);
            this.o = (Button) this.a.findViewById(com.baidu.tbadk.j.confirm);
            this.o.setOnClickListener(new s(this));
            this.q = (ProgressBar) this.a.findViewById(com.baidu.tbadk.j.confirm_progress);
            this.n = (TextView) this.a.findViewById(com.baidu.tbadk.j.error_info);
            this.d = (RadioGroup) this.a.findViewById(com.baidu.tbadk.j.names_group);
            this.f = (RadioButton) this.a.findViewById(com.baidu.tbadk.j.name1);
            this.g = (RadioButton) this.a.findViewById(com.baidu.tbadk.j.name2);
            this.h = (RadioButton) this.a.findViewById(com.baidu.tbadk.j.name3);
            this.e = new t(this);
            this.f.setOnCheckedChangeListener(this.e);
            this.g.setOnCheckedChangeListener(this.e);
            this.h.setOnCheckedChangeListener(this.e);
            this.r = (TextView) this.a.findViewById(com.baidu.tbadk.j.phone_info);
            d();
            this.b = new Dialog(this.j, com.baidu.tbadk.m.input_username_dialog);
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
                this.r.setText("Hi," + this.j.getString(com.baidu.tbadk.l.bar_friend));
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
            this.j.ShowSoftKeyPadDelay(this.c, 150);
            this.c.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(p pVar) {
        if (pVar.v != null) {
            pVar.v.a(null);
        }
    }

    public final void a(ArrayList<String> arrayList) {
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

    public final void b() {
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

    public final boolean c() {
        return this.b != null && this.b.isShowing();
    }

    public final void d() {
        this.d.setVisibility(8);
        this.d.clearCheck();
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.f.setChecked(false);
        this.g.setChecked(false);
        this.h.setChecked(false);
    }

    public final void e() {
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
