package com.baidu.tieba.home;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.cg;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, Integer, cg> {

    /* renamed from: a  reason: collision with root package name */
    BasicNameValuePair f1419a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.ap c = null;
    private String d;

    public az(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = searchActivity;
        this.d = null;
        this.f1419a = null;
        this.d = str;
        this.f1419a = basicNameValuePair;
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
    public cg a(Object... objArr) {
        cg cgVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.ap(this.d);
            this.c.a(this.f1419a);
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            cgVar = new cg();
            try {
                cgVar.a(j);
                return cgVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bg.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return cgVar;
            }
        } catch (Exception e3) {
            cgVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(cg cgVar) {
        ProgressBar progressBar;
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        if (cgVar != null) {
            this.b.w = cgVar;
            this.b.i();
        } else if (this.c != null) {
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
