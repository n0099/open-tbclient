package com.baidu.tieba.home;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.bq;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask {
    BasicNameValuePair a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.r c = null;
    private String d;

    public ay(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = searchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = basicNameValuePair;
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
    public bq a(Object... objArr) {
        bq bqVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.r(this.d);
            this.c.a(this.a);
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            bqVar = new bq();
            try {
                bqVar.a(j);
                return bqVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.z.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return bqVar;
            }
        } catch (Exception e3) {
            bqVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bq bqVar) {
        ProgressBar progressBar;
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        if (bqVar != null) {
            this.b.w = bqVar;
            this.b.r();
        }
        this.b.y = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
