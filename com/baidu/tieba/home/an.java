package com.baidu.tieba.home;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.a.av;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.adp.lib.a.a {
    ArrayList a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.d.t c = null;
    private String d;

    public an(SearchActivity searchActivity, String str, ArrayList arrayList) {
        this.b = searchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        TextView textView;
        EditText editText;
        ListView listView;
        ProgressBar progressBar;
        textView = this.b.v;
        textView.setVisibility(8);
        SearchActivity searchActivity = this.b;
        editText = this.b.c;
        com.baidu.tieba.d.ag.a(searchActivity, editText);
        listView = this.b.p;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.s;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public av a(Object... objArr) {
        av avVar;
        Exception e;
        String str;
        try {
            this.c = new com.baidu.tieba.d.t(this.d);
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a((BasicNameValuePair) it.next());
            }
            String i = this.c.i();
            if (!this.c.b() || i == null) {
                return null;
            }
            avVar = new av();
            try {
                avVar.a(i);
                str = this.b.A;
                com.baidu.tieba.d.k.l(str);
                return avVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.d.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return avVar;
            }
        } catch (Exception e3) {
            avVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(av avVar) {
        ProgressBar progressBar;
        ar arVar;
        ar arVar2;
        ar arVar3;
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        arVar = this.b.r;
        arVar.a(0);
        arVar2 = this.b.r;
        arVar2.notifyDataSetChanged();
        if (avVar != null && this.c != null && this.c.b()) {
            this.b.x = avVar;
            arVar3 = this.b.r;
            arVar3.notifyDataSetChanged();
            this.b.r();
        } else {
            this.b.a(this.b.getString(R.string.neterror));
        }
        this.b.z = null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.s;
        progressBar.setVisibility(8);
        this.b.z = null;
        super.cancel(true);
    }
}
