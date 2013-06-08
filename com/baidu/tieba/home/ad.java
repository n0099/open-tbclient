package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.a.av;
import com.baidu.tieba.a.aw;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        ar arVar;
        ar arVar2;
        ar arVar3;
        aw awVar;
        aw awVar2;
        String str;
        ar arVar4;
        ar arVar5;
        aw awVar3;
        aw awVar4;
        aw awVar5;
        String str2;
        ar arVar6;
        ar arVar7;
        i2 = this.a.B;
        if (i2 != 0) {
            arVar = this.a.r;
            if (arVar.getItemId(i) != -1) {
                arVar2 = this.a.r;
                if (arVar2.getItemId(i) != -2) {
                    arVar3 = this.a.r;
                    av avVar = (av) arVar3.getItem(i);
                    if (avVar != null) {
                        if (avVar.a()) {
                            NewPbActivity.a(this.a, avVar.c(), null, "search_post");
                            return;
                        } else {
                            NewPbActivity.a(this.a, avVar.c(), avVar.b(), "search_post");
                            return;
                        }
                    }
                    return;
                }
                awVar = this.a.x;
                if (awVar != null) {
                    SearchActivity searchActivity = this.a;
                    awVar2 = this.a.x;
                    str = this.a.A;
                    searchActivity.a(awVar2.d() + 1, str);
                    arVar4 = this.a.r;
                    arVar4.a(2);
                    arVar5 = this.a.r;
                    arVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            awVar3 = this.a.x;
            if (awVar3 != null) {
                awVar4 = this.a.x;
                if (awVar4.d() > 1) {
                    SearchActivity searchActivity2 = this.a;
                    awVar5 = this.a.x;
                    str2 = this.a.A;
                    searchActivity2.a(awVar5.d() - 1, str2);
                    arVar6 = this.a.r;
                    arVar6.a(1);
                    arVar7 = this.a.r;
                    arVar7.notifyDataSetChanged();
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
