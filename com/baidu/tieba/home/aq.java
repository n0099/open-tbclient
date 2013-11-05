package com.baidu.tieba.home;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.cn;
import com.baidu.tieba.util.be;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<Object, Integer, cn> {

    /* renamed from: a  reason: collision with root package name */
    BasicNameValuePair f1343a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.ag c = null;
    private String d;

    public aq(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = searchActivity;
        this.d = null;
        this.f1343a = null;
        this.d = str;
        this.f1343a = basicNameValuePair;
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
    public cn a(Object... objArr) {
        cn cnVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.ag(this.d);
            this.c.a(this.f1343a);
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            cnVar = new cn();
            try {
                cnVar.a(j);
                return cnVar;
            } catch (Exception e2) {
                e = e2;
                be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return cnVar;
            }
        } catch (Exception e3) {
            cnVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(cn cnVar) {
        ProgressBar progressBar;
        progressBar = this.b.v;
        progressBar.setVisibility(8);
        if (cnVar != null) {
            this.b.z = cnVar;
            this.b.q();
        } else if (this.c != null) {
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
