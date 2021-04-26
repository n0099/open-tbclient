package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import d.a.i0.r.q.q1;
import d.a.i0.r.q.r1;
import d.a.j0.q0.a1;
import d.a.j0.q0.k;
import d.a.j0.q0.r2.d;
import d.a.j0.q0.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendAdapter extends k<q1, FrsSchoolRecommendViewHolder> {
    public d w;

    /* loaded from: classes4.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d f15925a;

        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, d dVar) {
            super(dVar.l());
            this.f15925a = dVar;
        }
    }

    public FrsSchoolRecommendAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: t0 */
    public FrsSchoolRecommendViewHolder P(ViewGroup viewGroup) {
        this.w = new d(this.o, this.f40323i);
        return new FrsSchoolRecommendViewHolder(this, this.w);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: u0 */
    public View W(int i2, View view, ViewGroup viewGroup, q1 q1Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        super.W(i2, view, viewGroup, q1Var, frsSchoolRecommendViewHolder);
        this.w = frsSchoolRecommendViewHolder.f15925a;
        ArrayList<r1> z4 = q1Var.z4();
        if (z4.size() <= 0) {
            return null;
        }
        y yVar = new y();
        yVar.showTopDivider = true;
        yVar.mGroupTitle = q1Var.x1();
        for (int i3 = 0; i3 != z4.size(); i3++) {
            r1 r1Var = z4.get(i3);
            if (r1Var != null) {
                a1 a1Var = new a1();
                a1Var.f57483a.setUserId(r1Var.d());
                a1Var.f57483a.setUserName(r1Var.e());
                a1Var.f57483a.setPortrait(r1Var.c());
                a1Var.f57483a.getGodUserData().setIsLike(r1Var.b() == 1);
                a1Var.f57483a.getGodUserData().setIntro(r1Var.a());
                yVar.h(a1Var);
            }
        }
        this.w.n(this.o, this.r);
        frsSchoolRecommendViewHolder.f15925a.m(yVar);
        return frsSchoolRecommendViewHolder.a();
    }
}
