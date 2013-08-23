package com.baidu.tieba.home;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1170a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.v c = null;
    private String d;

    public ay(SearchActivity searchActivity, String str, ArrayList arrayList) {
        this.b = searchActivity;
        this.d = null;
        this.f1170a = null;
        this.d = str;
        this.f1170a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        TextView textView;
        EditText editText;
        ListView listView;
        ProgressBar progressBar;
        textView = this.b.y;
        textView.setVisibility(8);
        SearchActivity searchActivity = this.b;
        editText = this.b.c;
        UtilHelper.a(searchActivity, editText);
        listView = this.b.s;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.v;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.ay a(Object... objArr) {
        com.baidu.tieba.data.ay ayVar;
        Exception e;
        String str;
        try {
            this.c = new com.baidu.tieba.util.v(this.d);
            Iterator it = this.f1170a.iterator();
            while (it.hasNext()) {
                this.c.a((BasicNameValuePair) it.next());
            }
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            ayVar = new com.baidu.tieba.data.ay();
            try {
                ayVar.a(j);
                str = this.b.D;
                DatabaseService.m(str);
                return ayVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aq.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return ayVar;
            }
        } catch (Exception e3) {
            ayVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ay ayVar) {
        ProgressBar progressBar;
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        progressBar = this.b.v;
        progressBar.setVisibility(8);
        bcVar = this.b.u;
        bcVar.a(0);
        bcVar2 = this.b.u;
        bcVar2.notifyDataSetChanged();
        if (ayVar != null && this.c != null && this.c.c()) {
            this.b.A = ayVar;
            bcVar3 = this.b.u;
            bcVar3.notifyDataSetChanged();
            this.b.p();
        } else {
            this.b.a(this.b.getString(R.string.neterror));
        }
        this.b.C = null;
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
        this.b.C = null;
        super.cancel(true);
    }
}
