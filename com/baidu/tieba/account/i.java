package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.model.be;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, be> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f1083a;
    private com.baidu.tieba.util.ap b;

    private i(ActivationActivity activationActivity) {
        this.f1083a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(ActivationActivity activationActivity, e eVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public be a(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/s/regreal");
            com.baidu.tieba.util.ap apVar = this.b;
            registData = this.f1083a.p;
            apVar.a("un", registData.getName());
            com.baidu.tieba.util.ap apVar2 = this.b;
            registData2 = this.f1083a.p;
            apVar2.a("phonenum", registData2.getPhone());
            com.baidu.tieba.util.ap apVar3 = this.b;
            registData3 = this.f1083a.p;
            apVar3.a("passwd", registData3.getPsw());
            registData4 = this.f1083a.p;
            if (registData4.getVcode() != null) {
                com.baidu.tieba.util.ap apVar4 = this.b;
                registData7 = this.f1083a.p;
                apVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.f1083a.p;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tieba.util.ap apVar5 = this.b;
                registData6 = this.f1083a.p;
                apVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tieba.util.ap apVar6 = this.b;
            editText = this.f1083a.i;
            apVar6.a("smscode", editText.getText().toString());
            String j = this.b.j();
            if (this.b.c()) {
                be beVar = new be();
                beVar.a(j);
                return beVar;
            }
            return null;
        } catch (Exception e) {
            bg.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(be beVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((i) beVar);
        progressBar = this.f1083a.f;
        progressBar.setVisibility(8);
        this.f1083a.m = null;
        this.f1083a.a(true);
        z = this.f1083a.n;
        if (z) {
            relativeLayout = this.f1083a.k;
            relativeLayout.setEnabled(true);
        }
        if (beVar != null) {
            this.f1083a.a(beVar);
            return;
        }
        String g = this.b.g();
        if (g != null && g.length() > 0) {
            textView = this.f1083a.h;
            textView.setVisibility(0);
            textView2 = this.f1083a.h;
            textView2.setText(g);
        }
        if (this.b.e() == 26) {
            this.f1083a.y = 26;
            linearLayout = this.f1083a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.f1083a.c;
            i = this.f1083a.w;
            i2 = this.f1083a.x;
            linearLayout2.setPadding(i, 0, i2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        progressBar = this.f1083a.f;
        progressBar.setVisibility(0);
        relativeLayout = this.f1083a.k;
        relativeLayout.setEnabled(false);
        this.f1083a.a(false);
        textView = this.f1083a.h;
        textView.setVisibility(4);
        textView2 = this.f1083a.h;
        textView2.setText((CharSequence) null);
        linearLayout = this.f1083a.c;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.f1083a.c;
        i = this.f1083a.w;
        i2 = this.f1083a.x;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.f1083a.m = null;
        progressBar = this.f1083a.f;
        progressBar.setVisibility(8);
        z = this.f1083a.n;
        if (z) {
            relativeLayout = this.f1083a.k;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.h();
        }
        this.f1083a.a(true);
        super.cancel(true);
    }
}
