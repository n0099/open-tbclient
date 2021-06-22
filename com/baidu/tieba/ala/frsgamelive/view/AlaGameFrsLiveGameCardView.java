package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.n0.r.q.a2;
import d.a.o0.v.e.b.c;
import d.a.o0.v.e.d.a;
import d.a.o0.z.b;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveGameCardView extends b<c> {
    public TbPageContext m;
    public a n;

    /* loaded from: classes4.dex */
    public static class AlaGameFrsGameViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public AlaGameFrsLiveGameCardView f14102a;

        public AlaGameFrsGameViewHolder(AlaGameFrsLiveGameCardView alaGameFrsLiveGameCardView) {
            super(alaGameFrsLiveGameCardView.m());
            this.f14102a = alaGameFrsLiveGameCardView;
        }
    }

    public AlaGameFrsLiveGameCardView(TbPageContext<?> tbPageContext) {
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
        a aVar = this.n;
        if (aVar != null) {
            aVar.e(tbPageContext, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void t() {
        this.n = new a(this.m);
        ((ViewGroup) m()).addView(this.n.c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: u */
    public void n(c cVar) {
        a2 a2Var;
        a aVar;
        if (cVar == null || (a2Var = cVar.f65711e) == null || (aVar = this.n) == null) {
            return;
        }
        aVar.d(a2Var);
    }

    public void v(d.a.o0.v.c cVar) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.g(cVar);
        }
    }
}
