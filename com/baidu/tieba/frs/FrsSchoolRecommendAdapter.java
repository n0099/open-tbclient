package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import d.b.h0.r.q.q1;
import d.b.h0.r.q.r1;
import d.b.i0.p0.a1;
import d.b.i0.p0.k;
import d.b.i0.p0.q2.d;
import d.b.i0.p0.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendAdapter extends k<q1, FrsSchoolRecommendViewHolder> {
    public d w;

    /* loaded from: classes4.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d f16085a;

        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, d dVar) {
            super(dVar.m());
            this.f16085a = dVar;
        }
    }

    public FrsSchoolRecommendAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: t0 */
    public FrsSchoolRecommendViewHolder R(ViewGroup viewGroup) {
        this.w = new d(this.o, this.i);
        return new FrsSchoolRecommendViewHolder(this, this.w);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: u0 */
    public View X(int i, View view, ViewGroup viewGroup, q1 q1Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        super.X(i, view, viewGroup, q1Var, frsSchoolRecommendViewHolder);
        this.w = frsSchoolRecommendViewHolder.f16085a;
        ArrayList<r1> y4 = q1Var.y4();
        if (y4.size() <= 0) {
            return null;
        }
        y yVar = new y();
        yVar.showTopDivider = true;
        yVar.mGroupTitle = q1Var.x1();
        for (int i2 = 0; i2 != y4.size(); i2++) {
            r1 r1Var = y4.get(i2);
            if (r1Var != null) {
                a1 a1Var = new a1();
                a1Var.f57324a.setUserId(r1Var.d());
                a1Var.f57324a.setUserName(r1Var.e());
                a1Var.f57324a.setPortrait(r1Var.c());
                a1Var.f57324a.getGodUserData().setIsLike(r1Var.b() == 1);
                a1Var.f57324a.getGodUserData().setIntro(r1Var.a());
                yVar.g(a1Var);
            }
        }
        this.w.o(this.o, this.r);
        frsSchoolRecommendViewHolder.f16085a.n(yVar);
        return frsSchoolRecommendViewHolder.a();
    }
}
