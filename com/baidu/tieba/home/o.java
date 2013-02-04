package com.baidu.tieba.home;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(HomeActivity homeActivity) {
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
        fVar = this.a.f;
        if (fVar.getItem(i) != null) {
            fVar2 = this.a.f;
            if (fVar2.getItem(i) instanceof com.baidu.tieba.a.ac) {
                fVar7 = this.a.f;
                com.baidu.tieba.a.ac acVar = (com.baidu.tieba.a.ac) fVar7.getItem(i);
                if (acVar != null) {
                    String b = acVar.b();
                    if (com.baidu.tieba.c.ad.d(b)) {
                        FrsActivity.a(this.a, b, "tb_forumlist");
                        return;
                    }
                    return;
                }
                return;
            }
            fVar3 = this.a.f;
            if (!fVar3.getItem(i).equals(6)) {
                fVar4 = this.a.f;
                if (fVar4.getItem(i).equals(0)) {
                    SearchActivity.a(this.a, this.a.getString(R.string.home));
                    return;
                }
                return;
            }
            fVar5 = this.a.f;
            fVar5.b();
            fVar6 = this.a.f;
            fVar6.notifyDataSetChanged();
            TiebaApplication.a().m();
        }
    }
}
