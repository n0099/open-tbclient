package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ao aoVar;
        ao aoVar2;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        com.baidu.tieba.c.k.j(str);
        FrsActivity.a(this.a, str, "tb_searchlist");
        aoVar = this.a.i;
        aoVar.a(i);
        aoVar2 = this.a.i;
        aoVar2.notifyDataSetChanged();
        this.a.finish();
    }
}
