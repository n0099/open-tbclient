package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SearchActivity searchActivity) {
        this.f1332a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        au auVar;
        au auVar2;
        au auVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        au auVar4;
        au auVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        au auVar6;
        au auVar7;
        i2 = this.f1332a.E;
        if (i2 != 0) {
            auVar = this.f1332a.u;
            if (auVar.getItemId(i) == -1) {
                searchPostModel3 = this.f1332a.A;
                if (searchPostModel3 != null) {
                    searchPostModel4 = this.f1332a.A;
                    if (searchPostModel4.getCurrentPage() > 1) {
                        SearchActivity searchActivity = this.f1332a;
                        searchPostModel5 = this.f1332a.A;
                        str2 = this.f1332a.D;
                        searchActivity.a(searchPostModel5.getCurrentPage() - 1, str2);
                        auVar6 = this.f1332a.u;
                        auVar6.a(1);
                        auVar7 = this.f1332a.u;
                        auVar7.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            auVar2 = this.f1332a.u;
            if (auVar2.getItemId(i) == -2) {
                searchPostModel = this.f1332a.A;
                if (searchPostModel != null) {
                    SearchActivity searchActivity2 = this.f1332a;
                    searchPostModel2 = this.f1332a.A;
                    str = this.f1332a.D;
                    searchActivity2.a(searchPostModel2.getCurrentPage() + 1, str);
                    auVar4 = this.f1332a.u;
                    auVar4.a(2);
                    auVar5 = this.f1332a.u;
                    auVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            auVar3 = this.f1332a.u;
            com.baidu.tieba.data.ax axVar = (com.baidu.tieba.data.ax) auVar3.getItem(i);
            if (axVar != null) {
                if (axVar.a()) {
                    NewPbActivity.a(this.f1332a, axVar.c(), null, "search_post");
                    return;
                } else {
                    NewPbActivity.a(this.f1332a, axVar.c(), axVar.b(), "search_post");
                    return;
                }
            }
            return;
        }
        FrsActivity.a(this.f1332a, (String) ((ListView) adapterView).getAdapter().getItem(i), "tb_searchlist", 1);
        this.f1332a.finish();
    }
}
