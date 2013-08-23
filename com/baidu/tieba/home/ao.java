package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SearchActivity searchActivity) {
        this.f1160a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        com.baidu.tieba.data.ay ayVar;
        com.baidu.tieba.data.ay ayVar2;
        String str;
        bc bcVar4;
        bc bcVar5;
        com.baidu.tieba.data.ay ayVar3;
        com.baidu.tieba.data.ay ayVar4;
        com.baidu.tieba.data.ay ayVar5;
        String str2;
        bc bcVar6;
        bc bcVar7;
        i2 = this.f1160a.E;
        if (i2 != 0) {
            bcVar = this.f1160a.u;
            if (bcVar.getItemId(i) != -1) {
                bcVar2 = this.f1160a.u;
                if (bcVar2.getItemId(i) != -2) {
                    bcVar3 = this.f1160a.u;
                    com.baidu.tieba.data.ax axVar = (com.baidu.tieba.data.ax) bcVar3.getItem(i);
                    if (axVar != null) {
                        if (axVar.a()) {
                            NewPbActivity.a(this.f1160a, axVar.c(), null, "search_post");
                            return;
                        } else {
                            NewPbActivity.a(this.f1160a, axVar.c(), axVar.b(), "search_post");
                            return;
                        }
                    }
                    return;
                }
                ayVar = this.f1160a.A;
                if (ayVar != null) {
                    SearchActivity searchActivity = this.f1160a;
                    ayVar2 = this.f1160a.A;
                    str = this.f1160a.D;
                    searchActivity.a(ayVar2.d() + 1, str);
                    bcVar4 = this.f1160a.u;
                    bcVar4.a(2);
                    bcVar5 = this.f1160a.u;
                    bcVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            ayVar3 = this.f1160a.A;
            if (ayVar3 != null) {
                ayVar4 = this.f1160a.A;
                if (ayVar4.d() > 1) {
                    SearchActivity searchActivity2 = this.f1160a;
                    ayVar5 = this.f1160a.A;
                    str2 = this.f1160a.D;
                    searchActivity2.a(ayVar5.d() - 1, str2);
                    bcVar6 = this.f1160a.u;
                    bcVar6.a(1);
                    bcVar7 = this.f1160a.u;
                    bcVar7.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        FrsActivity.a(this.f1160a, (String) ((ListView) adapterView).getAdapter().getItem(i), "tb_searchlist", 1);
        this.f1160a.finish();
    }
}
