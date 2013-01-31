package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        f fVar6;
        f fVar7;
        fVar = this.a.l;
        if (fVar.getItem(i) != null) {
            fVar2 = this.a.l;
            if (fVar2.getItem(i) instanceof com.baidu.tieba.a.ad) {
                fVar7 = this.a.l;
                com.baidu.tieba.a.ad adVar = (com.baidu.tieba.a.ad) fVar7.getItem(i);
                if (adVar != null) {
                    String b = adVar.b();
                    if (com.baidu.tieba.c.ae.d(b)) {
                        FrsActivity.a(this.a, b, "dimension_door");
                        return;
                    }
                    return;
                }
                return;
            }
            fVar3 = this.a.l;
            if (fVar3.getItem(i).equals(6)) {
                fVar5 = this.a.l;
                fVar5.b();
                fVar6 = this.a.l;
                fVar6.notifyDataSetChanged();
                TiebaApplication.b().o();
                return;
            }
            fVar4 = this.a.l;
            if (fVar4.getItem(i).equals(0)) {
                SearchActivity.a(this.a, this.a.getString(R.string.home));
            }
        }
    }
}
