package com.baidu.tieba.home;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ch;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends BdAsyncTask<Object, Integer, ch> {

    /* renamed from: a  reason: collision with root package name */
    BasicNameValuePair f1460a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.am c = null;
    private String d;

    public au(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = searchActivity;
        this.d = null;
        this.f1460a = null;
        this.d = str;
        this.f1460a = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public ch a(Object... objArr) {
        ch chVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.am(this.d);
            this.c.a(this.f1460a);
            String l = this.c.l();
            if (!this.c.c() || l == null) {
                return null;
            }
            chVar = new ch();
            try {
                chVar.a(l);
                return chVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bd.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return chVar;
            }
        } catch (Exception e3) {
            chVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ch chVar) {
        ProgressBar progressBar;
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        if (chVar != null) {
            this.b.w = chVar;
            this.b.i();
        } else if (this.c != null) {
        }
        this.b.y = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
