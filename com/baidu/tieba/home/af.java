package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        aw awVar;
        aw awVar2;
        aw awVar3;
        com.baidu.tieba.a.ar arVar;
        com.baidu.tieba.a.ar arVar2;
        String str;
        aw awVar4;
        aw awVar5;
        com.baidu.tieba.a.ar arVar3;
        com.baidu.tieba.a.ar arVar4;
        com.baidu.tieba.a.ar arVar5;
        String str2;
        aw awVar6;
        aw awVar7;
        i2 = this.a.D;
        if (i2 != 0) {
            awVar = this.a.o;
            if (awVar.getItemId(i) != -1) {
                awVar2 = this.a.o;
                if (awVar2.getItemId(i) != -2) {
                    awVar3 = this.a.o;
                    com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) awVar3.getItem(i);
                    if (aqVar != null) {
                        if (aqVar.a()) {
                            PbActivity.a(this.a, aqVar.c(), "search_post");
                            return;
                        } else {
                            PbActivity.a(this.a, aqVar.c(), aqVar.b(), "search_post");
                            return;
                        }
                    }
                    return;
                }
                arVar = this.a.u;
                if (arVar != null) {
                    SearchActivity searchActivity = this.a;
                    arVar2 = this.a.u;
                    str = this.a.x;
                    searchActivity.a(arVar2.d() + 1, str);
                    awVar4 = this.a.o;
                    awVar4.a(2);
                    awVar5 = this.a.o;
                    awVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            arVar3 = this.a.u;
            if (arVar3 != null) {
                arVar4 = this.a.u;
                if (arVar4.d() > 1) {
                    SearchActivity searchActivity2 = this.a;
                    arVar5 = this.a.u;
                    str2 = this.a.x;
                    searchActivity2.a(arVar5.d() - 1, str2);
                    awVar6 = this.a.o;
                    awVar6.a(1);
                    awVar7 = this.a.o;
                    awVar7.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        FrsActivity.a(this.a, (String) ((ListView) adapterView).getAdapter().getItem(i), "tb_searchlist", 1);
        this.a.finish();
    }
}
