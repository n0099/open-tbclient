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
public class at extends BdAsyncTask<Object, Integer, SearchPostModel> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.util.an c = null;
    private String d;

    public at(SearchActivity searchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
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
        com.baidu.adp.lib.h.g.a(searchActivity, editText);
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
            this.c = new com.baidu.tieba.util.an(this.d);
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String l = this.c.l();
            if (!this.c.c() || l == null) {
                return null;
            }
            searchPostModel = new SearchPostModel();
            try {
                searchPostModel.parserJson(l);
                str = this.b.A;
                DatabaseService.n(str);
                return searchPostModel;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
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
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        ayVar = this.b.r;
        ayVar.a(0);
        ayVar2 = this.b.r;
        ayVar2.notifyDataSetChanged();
        if (searchPostModel != null && this.c != null && this.c.c()) {
            this.b.x = searchPostModel;
            ayVar3 = this.b.r;
            ayVar3.notifyDataSetChanged();
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
            this.c.j();
            this.c = null;
        }
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        this.b.z = null;
        super.cancel(true);
    }
}
