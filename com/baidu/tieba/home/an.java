package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SearchActivity searchActivity) {
        this.f1126a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        com.baidu.tieba.data.bd bdVar;
        com.baidu.tieba.data.bd bdVar2;
        String str;
        bb bbVar4;
        bb bbVar5;
        com.baidu.tieba.data.bd bdVar3;
        com.baidu.tieba.data.bd bdVar4;
        com.baidu.tieba.data.bd bdVar5;
        String str2;
        bb bbVar6;
        bb bbVar7;
        i2 = this.f1126a.B;
        if (i2 != 0) {
            bbVar = this.f1126a.r;
            if (bbVar.getItemId(i) != -1) {
                bbVar2 = this.f1126a.r;
                if (bbVar2.getItemId(i) != -2) {
                    bbVar3 = this.f1126a.r;
                    com.baidu.tieba.data.bc bcVar = (com.baidu.tieba.data.bc) bbVar3.getItem(i);
                    if (bcVar != null) {
                        if (bcVar.a()) {
                            NewPbActivity.a(this.f1126a, bcVar.c(), null, "search_post");
                            return;
                        } else {
                            NewPbActivity.a(this.f1126a, bcVar.c(), bcVar.b(), "search_post");
                            return;
                        }
                    }
                    return;
                }
                bdVar = this.f1126a.x;
                if (bdVar != null) {
                    SearchActivity searchActivity = this.f1126a;
                    bdVar2 = this.f1126a.x;
                    str = this.f1126a.A;
                    searchActivity.a(bdVar2.d() + 1, str);
                    bbVar4 = this.f1126a.r;
                    bbVar4.a(2);
                    bbVar5 = this.f1126a.r;
                    bbVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            bdVar3 = this.f1126a.x;
            if (bdVar3 != null) {
                bdVar4 = this.f1126a.x;
                if (bdVar4.d() > 1) {
                    SearchActivity searchActivity2 = this.f1126a;
                    bdVar5 = this.f1126a.x;
                    str2 = this.f1126a.A;
                    searchActivity2.a(bdVar5.d() - 1, str2);
                    bbVar6 = this.f1126a.r;
                    bbVar6.a(1);
                    bbVar7 = this.f1126a.r;
                    bbVar7.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        FrsActivity.a(this.f1126a, (String) ((ListView) adapterView).getAdapter().getItem(i), "tb_searchlist", 1);
        this.f1126a.finish();
    }
}
