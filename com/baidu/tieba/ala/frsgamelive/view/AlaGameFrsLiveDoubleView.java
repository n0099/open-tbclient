package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.i0.t.c;
import d.b.i0.t.h.b.a;
import d.b.i0.x.b;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveDoubleView extends b<a> {
    public d.b.i0.t.e.d.b m;
    public d.b.i0.t.e.d.b n;

    /* loaded from: classes4.dex */
    public static class AlaGameFrsLiveDoubleViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public AlaGameFrsLiveDoubleView f14994a;

        public AlaGameFrsLiveDoubleViewHolder(AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView) {
            super(alaGameFrsLiveDoubleView.m());
            this.f14994a = alaGameFrsLiveDoubleView;
        }
    }

    public AlaGameFrsLiveDoubleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        u();
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.ala_sub_list_game_live;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.m.e(tbPageContext, i);
        this.n.e(tbPageContext, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void u() {
        this.m = new d.b.i0.t.e.d.b(l());
        this.n = new d.b.i0.t.e.d.b(l());
        ViewGroup viewGroup = (ViewGroup) m();
        View view = new View(b());
        viewGroup.addView(this.m.c());
        viewGroup.addView(view, new LinearLayout.LayoutParams(l().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.n.c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(a aVar) {
        if (aVar != null) {
            this.m.d(aVar.f60772e);
            this.n.d(aVar.f60773f);
        }
    }

    public void w(String str) {
        this.m.f(str);
        this.n.f(str);
    }

    public void x(c cVar) {
        this.m.g(cVar);
        this.n.g(cVar);
    }
}
