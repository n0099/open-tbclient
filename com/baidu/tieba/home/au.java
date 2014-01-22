package com.baidu.tieba.home;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends BdAsyncTask<Object, Integer, SearchPostModel> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.ax c = null;
    private String d;

    public au(SearchActivity searchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
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
        editText = this.b.c;
        com.baidu.adp.lib.g.g.a(searchActivity, editText);
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
    public SearchPostModel a(Object... objArr) {
        SearchPostModel searchPostModel;
        Exception e;
        String str;
        try {
            this.c = new com.baidu.tieba.util.ax(this.d);
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String m = this.c.m();
            if (!this.c.d() || m == null) {
                return null;
            }
            searchPostModel = new SearchPostModel();
            try {
                searchPostModel.parserJson(m);
                str = this.b.A;
                DatabaseService.n(str);
                return searchPostModel;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.g.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return searchPostModel;
            }
        } catch (Exception e3) {
            searchPostModel = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SearchPostModel searchPostModel) {
        ProgressBar progressBar;
        az azVar;
        az azVar2;
        az azVar3;
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        azVar = this.b.r;
        azVar.a(0);
        azVar2 = this.b.r;
        azVar2.notifyDataSetChanged();
        if (searchPostModel != null && this.c != null && this.c.d()) {
            this.b.x = searchPostModel;
            azVar3 = this.b.r;
            azVar3.notifyDataSetChanged();
            this.b.i();
        } else {
            this.b.showToast(this.b.getString(R.string.neterror));
        }
        this.b.z = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.k();
            this.c = null;
        }
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        this.b.z = null;
        super.cancel(true);
    }
}
