package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        az azVar;
        az azVar2;
        az azVar3;
        com.baidu.tieba.a.ap apVar;
        com.baidu.tieba.a.ap apVar2;
        String str;
        az azVar4;
        az azVar5;
        com.baidu.tieba.a.ap apVar3;
        com.baidu.tieba.a.ap apVar4;
        com.baidu.tieba.a.ap apVar5;
        String str2;
        az azVar6;
        az azVar7;
        i2 = this.a.D;
        if (i2 != 0) {
            azVar = this.a.o;
            if (azVar.getItemId(i) != -1) {
                azVar2 = this.a.o;
                if (azVar2.getItemId(i) != -2) {
                    azVar3 = this.a.o;
                    com.baidu.tieba.a.ao aoVar = (com.baidu.tieba.a.ao) azVar3.getItem(i);
                    if (aoVar != null) {
                        if (aoVar.a()) {
                            PbActivity.a(this.a, aoVar.c(), "search_post");
                            return;
                        } else {
                            PbActivity.a(this.a, aoVar.c(), aoVar.b(), "search_post");
                            return;
                        }
                    }
                    return;
                }
                apVar = this.a.u;
                if (apVar != null) {
                    SearchActivity searchActivity = this.a;
                    apVar2 = this.a.u;
                    str = this.a.x;
                    searchActivity.a(apVar2.d() + 1, str);
                    azVar4 = this.a.o;
                    azVar4.a(2);
                    azVar5 = this.a.o;
                    azVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            apVar3 = this.a.u;
            if (apVar3 != null) {
                apVar4 = this.a.u;
                if (apVar4.d() > 1) {
                    SearchActivity searchActivity2 = this.a;
                    apVar5 = this.a.u;
                    str2 = this.a.x;
                    searchActivity2.a(apVar5.d() - 1, str2);
                    azVar6 = this.a.o;
                    azVar6.a(1);
                    azVar7 = this.a.o;
                    azVar7.notifyDataSetChanged();
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
