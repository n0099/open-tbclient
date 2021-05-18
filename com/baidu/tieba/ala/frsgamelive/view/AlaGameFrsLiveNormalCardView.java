package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.j0.r.q.a2;
import d.a.k0.t.e.b.c;
import d.a.k0.x.b;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveNormalCardView extends b<c> {
    public TbPageContext m;
    public d.a.k0.t.e.d.b n;

    /* loaded from: classes4.dex */
    public static class AlaGameFrsNormalViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public AlaGameFrsLiveNormalCardView f14061a;

        public AlaGameFrsNormalViewHolder(AlaGameFrsLiveNormalCardView alaGameFrsLiveNormalCardView) {
            super(alaGameFrsLiveNormalCardView.l());
            this.f14061a = alaGameFrsLiveNormalCardView;
        }
    }

    public AlaGameFrsLiveNormalCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = tbPageContext;
        s();
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.ala_sub_list_game_live;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        d.a.k0.t.e.d.b bVar = this.n;
        if (bVar != null) {
            bVar.e(tbPageContext, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void s() {
        this.n = new d.a.k0.t.e.d.b(this.m);
        ((ViewGroup) l()).addView(this.n.c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: t */
    public void m(c cVar) {
        a2 a2Var;
        d.a.k0.t.e.d.b bVar;
        if (cVar == null || (a2Var = cVar.f61583e) == null || (bVar = this.n) == null) {
            return;
        }
        bVar.d(a2Var);
    }

    public void u(d.a.k0.t.c cVar) {
        d.a.k0.t.e.d.b bVar = this.n;
        if (bVar != null) {
            bVar.g(cVar);
        }
    }
}
