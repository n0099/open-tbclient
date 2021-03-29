package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.i0.t.e.b.c;
import d.b.i0.t.e.d.a;
import d.b.i0.x.b;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveGameCardView extends b<c> {
    public TbPageContext m;
    public a n;

    /* loaded from: classes4.dex */
    public static class AlaGameFrsGameViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public AlaGameFrsLiveGameCardView f14996a;

        public AlaGameFrsGameViewHolder(AlaGameFrsLiveGameCardView alaGameFrsLiveGameCardView) {
            super(alaGameFrsLiveGameCardView.m());
            this.f14996a = alaGameFrsLiveGameCardView;
        }
    }

    public AlaGameFrsLiveGameCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = tbPageContext;
        u();
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_sub_list_game_live;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.e(tbPageContext, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void u() {
        this.n = new a(this.m);
        ((ViewGroup) m()).addView(this.n.c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(c cVar) {
        a2 a2Var;
        a aVar;
        if (cVar == null || (a2Var = cVar.f60686e) == null || (aVar = this.n) == null) {
            return;
        }
        aVar.d(a2Var);
    }

    public void w(d.b.i0.t.c cVar) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.g(cVar);
        }
    }
}
