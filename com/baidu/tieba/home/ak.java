package com.baidu.tieba.home;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.ay;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<Object, Integer, ay> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f1202a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.z c = null;
    private String d;

    public ak(SearchActivity searchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = searchActivity;
        this.d = null;
        this.f1202a = null;
        this.d = str;
        this.f1202a = arrayList;
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
    public ay a(Object... objArr) {
        ay ayVar;
        Exception e;
        String str;
        try {
            this.c = new com.baidu.tieba.util.z(this.d);
            Iterator<BasicNameValuePair> it = this.f1202a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            ayVar = new ay();
            try {
                ayVar.a(j);
                str = this.b.D;
                DatabaseService.m(str);
                return ayVar;
            } catch (Exception e2) {
                e = e2;
                av.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
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
    public void a(ay ayVar) {
        ProgressBar progressBar;
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        progressBar = this.b.v;
        progressBar.setVisibility(8);
        aoVar = this.b.u;
        aoVar.a(0);
        aoVar2 = this.b.u;
        aoVar2.notifyDataSetChanged();
        if (ayVar != null && this.c != null && this.c.c()) {
            this.b.A = ayVar;
            aoVar3 = this.b.u;
            aoVar3.notifyDataSetChanged();
            this.b.q();
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
