package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends AsyncTask {
    ArrayList a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.c.t c = null;
    private String d;

    public av(SearchActivity searchActivity, String str, ArrayList arrayList) {
        this.b = searchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        TextView textView;
        EditText editText;
        ListView listView;
        ProgressBar progressBar;
        textView = this.b.s;
        textView.setVisibility(8);
        SearchActivity searchActivity = this.b;
        editText = this.b.c;
        com.baidu.tieba.c.ai.a(searchActivity, editText);
        listView = this.b.m;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.p;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.ap doInBackground(Object... objArr) {
        com.baidu.tieba.a.ap apVar;
        Exception e;
        String str;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a((BasicNameValuePair) it.next());
            }
            String i = this.c.i();
            if (!this.c.b() || i == null) {
                return null;
            }
            apVar = new com.baidu.tieba.a.ap();
            try {
                apVar.a(i);
                str = this.b.x;
                com.baidu.tieba.c.k.k(str);
                return apVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return apVar;
            }
        } catch (Exception e3) {
            apVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.ap apVar) {
        ProgressBar progressBar;
        az azVar;
        az azVar2;
        az azVar3;
        progressBar = this.b.p;
        progressBar.setVisibility(8);
        azVar = this.b.o;
        azVar.a(0);
        azVar2 = this.b.o;
        azVar2.notifyDataSetChanged();
        if (apVar != null && this.c != null && this.c.b()) {
            this.b.u = apVar;
            azVar3 = this.b.o;
            azVar3.notifyDataSetChanged();
            this.b.q();
        } else {
            this.b.b(this.b.getString(R.string.neterror));
        }
        this.b.w = null;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.p;
        progressBar.setVisibility(8);
        this.b.w = null;
        super.cancel(true);
    }
}
