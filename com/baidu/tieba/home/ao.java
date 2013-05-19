package com.baidu.tieba.home;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.c.bn;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.lib.a.a {
    BasicNameValuePair a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.d.t c = null;
    private String d;

    public ao(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = searchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        FrameLayout frameLayout;
        progressBar = this.b.s;
        progressBar.setVisibility(0);
        textView = this.b.v;
        textView.setVisibility(8);
        frameLayout = this.b.m;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public bn a(Object... objArr) {
        bn bnVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.d.t(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (!this.c.b() || i == null) {
                return null;
            }
            bnVar = new bn();
            try {
                bnVar.a(i);
                return bnVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.d.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return bnVar;
            }
        } catch (Exception e3) {
            bnVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(bn bnVar) {
        ProgressBar progressBar;
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        if (bnVar != null) {
            this.b.w = bnVar;
            this.b.r();
        }
        this.b.y = null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
