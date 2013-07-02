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
    ArrayList a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.r c = null;
    private String d;

    public ax(SearchActivity searchActivity, String str, ArrayList arrayList) {
        this.b = searchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
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
        editText = this.b.a;
        com.baidu.tieba.util.ab.a(searchActivity, editText);
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
    public com.baidu.tieba.data.au a(Object... objArr) {
        com.baidu.tieba.data.au auVar;
        Exception e;
        String str;
        try {
            this.c = new com.baidu.tieba.util.r(this.d);
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a((BasicNameValuePair) it.next());
            }
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            auVar = new com.baidu.tieba.data.au();
            try {
                auVar.a(j);
                str = this.b.A;
                DatabaseService.o(str);
                return auVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.z.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return auVar;
            }
        } catch (Exception e3) {
            auVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.au auVar) {
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
        if (auVar != null && this.c != null && this.c.c()) {
            this.b.x = auVar;
            bbVar3 = this.b.r;
            bbVar3.notifyDataSetChanged();
            this.b.r();
        } else {
            this.b.a(this.b.getString(R.string.neterror));
        }
        this.b.z = null;
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
        this.b.z = null;
        super.cancel(true);
    }
}
