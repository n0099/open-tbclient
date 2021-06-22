package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.n0.r.q.a2;
import d.a.o0.v.e.b.c;
import d.a.o0.z.b;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveNormalCardView extends b<c> {
    public TbPageContext m;
    public d.a.o0.v.e.d.b n;

    /* loaded from: classes4.dex */
    public static class AlaGameFrsNormalViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public AlaGameFrsLiveNormalCardView f14103a;

        public AlaGameFrsNormalViewHolder(AlaGameFrsLiveNormalCardView alaGameFrsLiveNormalCardView) {
            super(alaGameFrsLiveNormalCardView.m());
            this.f14103a = alaGameFrsLiveNormalCardView;
        }
    }

    public AlaGameFrsLiveNormalCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = tbPageContext;
        t();
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.ala_sub_list_game_live;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        d.a.o0.v.e.d.b bVar = this.n;
        if (bVar != null) {
            bVar.e(tbPageContext, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void t() {
        this.n = new d.a.o0.v.e.d.b(this.m);
        ((ViewGroup) m()).addView(this.n.c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: u */
    public void n(c cVar) {
        a2 a2Var;
        d.a.o0.v.e.d.b bVar;
        if (cVar == null || (a2Var = cVar.f65711e) == null || (bVar = this.n) == null) {
            return;
        }
        bVar.d(a2Var);
    }

    public void v(d.a.o0.v.c cVar) {
        d.a.o0.v.e.d.b bVar = this.n;
        if (bVar != null) {
            bVar.g(cVar);
        }
    }
}
