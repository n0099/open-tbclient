package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.i0.r.q.a2;
import d.b.j0.t.e.b.c;
import d.b.j0.x.b;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveNormalCardView extends b<c> {
    public TbPageContext m;
    public d.b.j0.t.e.d.b n;

    /* loaded from: classes4.dex */
    public static class AlaGameFrsNormalViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public AlaGameFrsLiveNormalCardView f14668a;

        public AlaGameFrsNormalViewHolder(AlaGameFrsLiveNormalCardView alaGameFrsLiveNormalCardView) {
            super(alaGameFrsLiveNormalCardView.m());
            this.f14668a = alaGameFrsLiveNormalCardView;
        }
    }

    public AlaGameFrsLiveNormalCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = tbPageContext;
        u();
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.ala_sub_list_game_live;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        d.b.j0.t.e.d.b bVar = this.n;
        if (bVar != null) {
            bVar.e(tbPageContext, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void u() {
        this.n = new d.b.j0.t.e.d.b(this.m);
        ((ViewGroup) m()).addView(this.n.c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: v */
    public void n(c cVar) {
        a2 a2Var;
        d.b.j0.t.e.d.b bVar;
        if (cVar == null || (a2Var = cVar.f62671e) == null || (bVar = this.n) == null) {
            return;
        }
        bVar.d(a2Var);
    }

    public void w(d.b.j0.t.c cVar) {
        d.b.j0.t.e.d.b bVar = this.n;
        if (bVar != null) {
            bVar.g(cVar);
        }
    }
}
