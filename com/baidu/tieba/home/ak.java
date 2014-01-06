package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        az azVar;
        az azVar2;
        az azVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        az azVar4;
        az azVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        az azVar6;
        az azVar7;
        i2 = this.a.B;
        if (i2 != 0) {
            azVar = this.a.r;
            if (azVar.getItemId(i) == -1) {
                searchPostModel3 = this.a.x;
                if (searchPostModel3 != null) {
                    searchPostModel4 = this.a.x;
                    if (searchPostModel4.getCurrentPage() > 1) {
                        SearchActivity searchActivity = this.a;
                        searchPostModel5 = this.a.x;
                        str2 = this.a.A;
                        searchActivity.a(searchPostModel5.getCurrentPage() - 1, str2);
                        azVar6 = this.a.r;
                        azVar6.a(1);
                        azVar7 = this.a.r;
                        azVar7.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            azVar2 = this.a.r;
            if (azVar2.getItemId(i) == -2) {
                searchPostModel = this.a.x;
                if (searchPostModel != null) {
                    SearchActivity searchActivity2 = this.a;
                    searchPostModel2 = this.a.x;
                    str = this.a.A;
                    searchActivity2.a(searchPostModel2.getCurrentPage() + 1, str);
                    azVar4 = this.a.r;
                    azVar4.a(2);
                    azVar5 = this.a.r;
                    azVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            azVar3 = this.a.r;
            com.baidu.tieba.data.aw awVar = (com.baidu.tieba.data.aw) azVar3.getItem(i);
            if (awVar != null) {
                if (awVar.a()) {
                    NewPbActivity.a(this.a, awVar.c(), (String) null, "search_post");
                    return;
                } else {
                    NewPbActivity.a(this.a, awVar.c(), awVar.b(), "search_post");
                    return;
                }
            }
            return;
        }
        FrsActivity.a(this.a, (String) ((ListView) adapterView).getAdapter().getItem(i), "tb_searchlist", 1);
        this.a.finish();
    }
}
