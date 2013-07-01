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
    final /* synthetic */ SearchActivity f902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SearchActivity searchActivity) {
        this.f902a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        com.baidu.tieba.data.au auVar;
        com.baidu.tieba.data.au auVar2;
        String str;
        bb bbVar4;
        bb bbVar5;
        com.baidu.tieba.data.au auVar3;
        com.baidu.tieba.data.au auVar4;
        com.baidu.tieba.data.au auVar5;
        String str2;
        bb bbVar6;
        bb bbVar7;
        i2 = this.f902a.B;
        if (i2 != 0) {
            bbVar = this.f902a.r;
            if (bbVar.getItemId(i) != -1) {
                bbVar2 = this.f902a.r;
                if (bbVar2.getItemId(i) != -2) {
                    bbVar3 = this.f902a.r;
                    com.baidu.tieba.data.at atVar = (com.baidu.tieba.data.at) bbVar3.getItem(i);
                    if (atVar != null) {
                        if (atVar.a()) {
                            NewPbActivity.a(this.f902a, atVar.c(), null, "search_post");
                            return;
                        } else {
                            NewPbActivity.a(this.f902a, atVar.c(), atVar.b(), "search_post");
                            return;
                        }
                    }
                    return;
                }
                auVar = this.f902a.x;
                if (auVar != null) {
                    SearchActivity searchActivity = this.f902a;
                    auVar2 = this.f902a.x;
                    str = this.f902a.A;
                    searchActivity.a(auVar2.d() + 1, str);
                    bbVar4 = this.f902a.r;
                    bbVar4.a(2);
                    bbVar5 = this.f902a.r;
                    bbVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            auVar3 = this.f902a.x;
            if (auVar3 != null) {
                auVar4 = this.f902a.x;
                if (auVar4.d() > 1) {
                    SearchActivity searchActivity2 = this.f902a;
                    auVar5 = this.f902a.x;
                    str2 = this.f902a.A;
                    searchActivity2.a(auVar5.d() - 1, str2);
                    bbVar6 = this.f902a.r;
                    bbVar6.a(1);
                    bbVar7 = this.f902a.r;
                    bbVar7.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        FrsActivity.a(this.f902a, (String) ((ListView) adapterView).getAdapter().getItem(i), "tb_searchlist", 1);
        this.f902a.finish();
    }
}
