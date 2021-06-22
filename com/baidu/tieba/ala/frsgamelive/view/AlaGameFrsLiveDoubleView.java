package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.o0.v.c;
import d.a.o0.v.h.b.a;
import d.a.o0.z.b;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveDoubleView extends b<a> {
    public d.a.o0.v.e.d.b m;
    public d.a.o0.v.e.d.b n;

    /* loaded from: classes4.dex */
    public static class AlaGameFrsLiveDoubleViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public AlaGameFrsLiveDoubleView f14101a;

        public AlaGameFrsLiveDoubleViewHolder(AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView) {
            super(alaGameFrsLiveDoubleView.m());
            this.f14101a = alaGameFrsLiveDoubleView;
        }
    }

    public AlaGameFrsLiveDoubleView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        t();
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.ala_sub_list_game_live;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        this.m.e(tbPageContext, i2);
        this.n.e(tbPageContext, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void t() {
        this.m = new d.a.o0.v.e.d.b(k());
        this.n = new d.a.o0.v.e.d.b(k());
        ViewGroup viewGroup = (ViewGroup) m();
        View view = new View(b());
        viewGroup.addView(this.m.c());
        viewGroup.addView(view, new LinearLayout.LayoutParams(k().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.n.c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: u */
    public void n(a aVar) {
        if (aVar != null) {
            this.m.d(aVar.f65806e);
            this.n.d(aVar.f65807f);
        }
    }

    public void v(String str) {
        this.m.f(str);
        this.n.f(str);
    }

    public void w(c cVar) {
        this.m.g(cVar);
        this.n.g(cVar);
    }
}
