package com.baidu.tieba.home;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.cb;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    BasicNameValuePair f1171a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.v c = null;
    private String d;

    public az(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = searchActivity;
        this.d = null;
        this.f1171a = null;
        this.d = str;
        this.f1171a = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        FrameLayout frameLayout;
        progressBar = this.b.v;
        progressBar.setVisibility(0);
        textView = this.b.y;
        textView.setVisibility(8);
        frameLayout = this.b.p;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public cb a(Object... objArr) {
        cb cbVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.v(this.d);
            this.c.a(this.f1171a);
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            cbVar = new cb();
            try {
                cbVar.a(j);
                return cbVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aq.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return cbVar;
            }
        } catch (Exception e3) {
            cbVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(cb cbVar) {
        ProgressBar progressBar;
        progressBar = this.b.v;
        progressBar.setVisibility(8);
        if (cbVar != null) {
            this.b.z = cbVar;
            this.b.p();
        }
        this.b.B = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        progressBar = this.b.v;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
