package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.a.a {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tieba.d.t b;

    private h(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(ActivationActivity activationActivity, h hVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.c.ai a(String... strArr) {
        com.baidu.tieba.a.au auVar;
        com.baidu.tieba.a.au auVar2;
        com.baidu.tieba.a.au auVar3;
        com.baidu.tieba.a.au auVar4;
        com.baidu.tieba.a.au auVar5;
        EditText editText;
        com.baidu.tieba.a.au auVar6;
        com.baidu.tieba.a.au auVar7;
        try {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/regreal");
            com.baidu.tieba.d.t tVar = this.b;
            auVar = this.a.r;
            tVar.a("un", auVar.a());
            com.baidu.tieba.d.t tVar2 = this.b;
            auVar2 = this.a.r;
            tVar2.a("phonenum", auVar2.c());
            com.baidu.tieba.d.t tVar3 = this.b;
            auVar3 = this.a.r;
            tVar3.a("passwd", auVar3.b());
            auVar4 = this.a.r;
            if (auVar4.d() != null) {
                com.baidu.tieba.d.t tVar4 = this.b;
                auVar7 = this.a.r;
                tVar4.a("vcode", auVar7.d());
            }
            auVar5 = this.a.r;
            if (auVar5.e() != null) {
                com.baidu.tieba.d.t tVar5 = this.b;
                auVar6 = this.a.r;
                tVar5.a("vcode_md5", auVar6.e());
            }
            com.baidu.tieba.d.t tVar6 = this.b;
            editText = this.a.k;
            tVar6.a("smscode", editText.getText().toString());
            String i = this.b.i();
            if (this.b.b()) {
                com.baidu.tieba.c.ai aiVar = new com.baidu.tieba.c.ai();
                aiVar.a(i);
                return aiVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.c.ai aiVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((Object) aiVar);
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        this.a.o = null;
        this.a.a(true);
        z = this.a.p;
        if (z) {
            relativeLayout = this.a.m;
            relativeLayout.setEnabled(true);
        }
        if (aiVar != null) {
            this.a.a(aiVar);
            return;
        }
        String f = this.b.f();
        if (f != null && f.length() > 0) {
            textView = this.a.j;
            textView.setVisibility(0);
            textView2 = this.a.j;
            textView2.setText(f);
        }
        if (this.b.d() == 26) {
            this.a.A = 26;
            linearLayout = this.a.e;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.a.e;
            i = this.a.y;
            i2 = this.a.z;
            linearLayout2.setPadding(i, 0, i2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        progressBar = this.a.h;
        progressBar.setVisibility(0);
        relativeLayout = this.a.m;
        relativeLayout.setEnabled(false);
        this.a.a(false);
        textView = this.a.j;
        textView.setVisibility(4);
        textView2 = this.a.j;
        textView2.setText((CharSequence) null);
        linearLayout = this.a.e;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.a.e;
        i = this.a.y;
        i2 = this.a.z;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.b();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.a.o = null;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        z = this.a.p;
        if (z) {
            relativeLayout = this.a.m;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.g();
        }
        this.a.a(true);
        super.cancel(true);
    }
}
