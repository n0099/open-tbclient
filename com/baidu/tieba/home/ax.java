package com.baidu.tieba.home;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1136a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.u c = null;
    private String d;

    public ax(SearchActivity searchActivity, String str, ArrayList arrayList) {
        this.b = searchActivity;
        this.d = null;
        this.f1136a = null;
        this.d = str;
        this.f1136a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        TextView textView;
        EditText editText;
        ListView listView;
        ProgressBar progressBar;
        textView = this.b.v;
        textView.setVisibility(8);
        SearchActivity searchActivity = this.b;
        editText = this.b.f1110a;
        com.baidu.tieba.util.am.a(searchActivity, editText);
        listView = this.b.p;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.s;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.bd a(Object... objArr) {
        com.baidu.tieba.data.bd bdVar;
        Exception e;
        String str;
        try {
            this.c = new com.baidu.tieba.util.u(this.d);
            Iterator it = this.f1136a.iterator();
            while (it.hasNext()) {
                this.c.a((BasicNameValuePair) it.next());
            }
            String k = this.c.k();
            if (!this.c.d() || k == null) {
                return null;
            }
            bdVar = new com.baidu.tieba.data.bd();
            try {
                bdVar.a(k);
                str = this.b.A;
                DatabaseService.o(str);
                return bdVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aj.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return bdVar;
            }
        } catch (Exception e3) {
            bdVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bd bdVar) {
        ProgressBar progressBar;
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        bbVar = this.b.r;
        bbVar.a(0);
        bbVar2 = this.b.r;
        bbVar2.notifyDataSetChanged();
        if (bdVar != null && this.c != null && this.c.d()) {
            this.b.x = bdVar;
            bbVar3 = this.b.r;
            bbVar3.notifyDataSetChanged();
            this.b.p();
        } else {
            this.b.a(this.b.getString(R.string.neterror));
        }
        this.b.z = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.i();
            this.c = null;
        }
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        this.b.z = null;
        super.cancel(true);
    }
}
