package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SearchActivity searchActivity) {
        this.f1408a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        bd bdVar4;
        bd bdVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        bd bdVar6;
        bd bdVar7;
        i2 = this.f1408a.B;
        if (i2 != 0) {
            bdVar = this.f1408a.r;
            if (bdVar.getItemId(i) == -1) {
                searchPostModel3 = this.f1408a.x;
                if (searchPostModel3 != null) {
                    searchPostModel4 = this.f1408a.x;
                    if (searchPostModel4.getCurrentPage() > 1) {
                        SearchActivity searchActivity = this.f1408a;
                        searchPostModel5 = this.f1408a.x;
                        str2 = this.f1408a.A;
                        searchActivity.a(searchPostModel5.getCurrentPage() - 1, str2);
                        bdVar6 = this.f1408a.r;
                        bdVar6.a(1);
                        bdVar7 = this.f1408a.r;
                        bdVar7.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            bdVar2 = this.f1408a.r;
            if (bdVar2.getItemId(i) == -2) {
                searchPostModel = this.f1408a.x;
                if (searchPostModel != null) {
                    SearchActivity searchActivity2 = this.f1408a;
                    searchPostModel2 = this.f1408a.x;
                    str = this.f1408a.A;
                    searchActivity2.a(searchPostModel2.getCurrentPage() + 1, str);
                    bdVar4 = this.f1408a.r;
                    bdVar4.a(2);
                    bdVar5 = this.f1408a.r;
                    bdVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            bdVar3 = this.f1408a.r;
            com.baidu.tieba.data.av avVar = (com.baidu.tieba.data.av) bdVar3.getItem(i);
            if (avVar != null) {
                if (avVar.a()) {
                    NewPbActivity.a(this.f1408a, avVar.c(), null, "search_post");
                    return;
                } else {
                    NewPbActivity.a(this.f1408a, avVar.c(), avVar.b(), "search_post");
                    return;
                }
            }
            return;
        }
        FrsActivity.a(this.f1408a, (String) ((ListView) adapterView).getAdapter().getItem(i), "tb_searchlist", 1);
        this.f1408a.finish();
    }
}
