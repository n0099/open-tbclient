package com.baidu.tieba.home;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.cd;
import com.baidu.tieba.util.av;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask<Object, Integer, cd> {

    /* renamed from: a  reason: collision with root package name */
    BasicNameValuePair f1203a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.z c = null;
    private String d;

    public al(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = searchActivity;
        this.d = null;
        this.f1203a = null;
        this.d = str;
        this.f1203a = basicNameValuePair;
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
    public cd a(Object... objArr) {
        cd cdVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.z(this.d);
            this.c.a(this.f1203a);
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            cdVar = new cd();
            try {
                cdVar.a(j);
                return cdVar;
            } catch (Exception e2) {
                e = e2;
                av.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return cdVar;
            }
        } catch (Exception e3) {
            cdVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(cd cdVar) {
        ProgressBar progressBar;
        progressBar = this.b.v;
        progressBar.setVisibility(8);
        if (cdVar != null) {
            this.b.z = cdVar;
            this.b.q();
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
