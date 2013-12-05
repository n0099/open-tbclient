package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1449a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SearchActivity searchActivity) {
        this.f1449a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        ay ayVar4;
        ay ayVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        ay ayVar6;
        ay ayVar7;
        i2 = this.f1449a.B;
        if (i2 != 0) {
            ayVar = this.f1449a.r;
            if (ayVar.getItemId(i) == -1) {
                searchPostModel3 = this.f1449a.x;
                if (searchPostModel3 != null) {
                    searchPostModel4 = this.f1449a.x;
                    if (searchPostModel4.getCurrentPage() > 1) {
                        SearchActivity searchActivity = this.f1449a;
                        searchPostModel5 = this.f1449a.x;
                        str2 = this.f1449a.A;
                        searchActivity.a(searchPostModel5.getCurrentPage() - 1, str2);
                        ayVar6 = this.f1449a.r;
                        ayVar6.a(1);
                        ayVar7 = this.f1449a.r;
                        ayVar7.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            ayVar2 = this.f1449a.r;
            if (ayVar2.getItemId(i) == -2) {
                searchPostModel = this.f1449a.x;
                if (searchPostModel != null) {
                    SearchActivity searchActivity2 = this.f1449a;
                    searchPostModel2 = this.f1449a.x;
                    str = this.f1449a.A;
                    searchActivity2.a(searchPostModel2.getCurrentPage() + 1, str);
                    ayVar4 = this.f1449a.r;
                    ayVar4.a(2);
                    ayVar5 = this.f1449a.r;
                    ayVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            ayVar3 = this.f1449a.r;
            com.baidu.tieba.data.au auVar = (com.baidu.tieba.data.au) ayVar3.getItem(i);
            if (auVar != null) {
                if (auVar.a()) {
                    NewPbActivity.a(this.f1449a, auVar.c(), null, "search_post");
                    return;
                } else {
                    NewPbActivity.a(this.f1449a, auVar.c(), auVar.b(), "search_post");
                    return;
                }
            }
            return;
        }
        FrsActivity.a(this.f1449a, (String) ((ListView) adapterView).getAdapter().getItem(i), "tb_searchlist", 1);
        this.f1449a.finish();
    }
}
