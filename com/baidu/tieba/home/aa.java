package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.data.ax;
import com.baidu.tieba.data.ay;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SearchActivity searchActivity) {
        this.f1192a = searchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        ay ayVar;
        ay ayVar2;
        String str;
        ao aoVar4;
        ao aoVar5;
        ay ayVar3;
        ay ayVar4;
        ay ayVar5;
        String str2;
        ao aoVar6;
        ao aoVar7;
        i2 = this.f1192a.E;
        if (i2 != 0) {
            aoVar = this.f1192a.u;
            if (aoVar.getItemId(i) != -1) {
                aoVar2 = this.f1192a.u;
                if (aoVar2.getItemId(i) != -2) {
                    aoVar3 = this.f1192a.u;
                    ax axVar = (ax) aoVar3.getItem(i);
                    if (axVar != null) {
                        if (axVar.a()) {
                            NewPbActivity.a(this.f1192a, axVar.c(), null, "search_post");
                            return;
                        } else {
                            NewPbActivity.a(this.f1192a, axVar.c(), axVar.b(), "search_post");
                            return;
                        }
                    }
                    return;
                }
                ayVar = this.f1192a.A;
                if (ayVar != null) {
                    SearchActivity searchActivity = this.f1192a;
                    ayVar2 = this.f1192a.A;
                    str = this.f1192a.D;
                    searchActivity.a(ayVar2.d() + 1, str);
                    aoVar4 = this.f1192a.u;
                    aoVar4.a(2);
                    aoVar5 = this.f1192a.u;
                    aoVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            ayVar3 = this.f1192a.A;
            if (ayVar3 != null) {
                ayVar4 = this.f1192a.A;
                if (ayVar4.d() > 1) {
                    SearchActivity searchActivity2 = this.f1192a;
                    ayVar5 = this.f1192a.A;
                    str2 = this.f1192a.D;
                    searchActivity2.a(ayVar5.d() - 1, str2);
                    aoVar6 = this.f1192a.u;
                    aoVar6.a(1);
                    aoVar7 = this.f1192a.u;
                    aoVar7.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        FrsActivity.a(this.f1192a, (String) ((ListView) adapterView).getAdapter().getItem(i), "tb_searchlist", 1);
        this.f1192a.finish();
    }
}
