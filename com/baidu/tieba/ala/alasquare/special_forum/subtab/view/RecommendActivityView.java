package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder;
import d.b.c.a.j;
import d.b.j0.t.d.f.c.c;
/* loaded from: classes4.dex */
public class RecommendActivityView extends d.b.j0.x.b<c> {
    public TbPageContext m;
    public AlaBannerAutoScrollView<d.b.j0.t.d.f.c.b> n;
    public d.b.j0.t.d.h.a.a o;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public RecommendActivityView f14598a;

        /* renamed from: b  reason: collision with root package name */
        public View f14599b;

        public ViewHolder(RecommendActivityView recommendActivityView) {
            super(recommendActivityView.m());
            this.f14598a = recommendActivityView;
            this.f14599b = recommendActivityView.m();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements d.b.j0.t.d.h.a.b {
        public a() {
        }

        @Override // d.b.j0.t.d.h.a.b
        public void a(Object obj) {
            if (obj == null || !(obj instanceof d.b.j0.t.d.f.c.b)) {
                return;
            }
            d.b.j0.t.d.f.c.b bVar = (d.b.j0.t.d.f.c.b) obj;
            if (!StringUtils.isNull(bVar.f62517e)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(RecommendActivityView.this.m.getPageActivity()), new String[]{bVar.f62517e}, true);
            }
            TiebaStatic.log("c12902");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.j0.t.d.h.a.a {

        /* loaded from: classes4.dex */
        public class a extends AlaBannerViewHolder<d.b.j0.t.d.f.c.b> {

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f14602a;

            public a(b bVar, View view) {
                super(view);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.cover);
                this.f14602a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i, d.b.j0.t.d.f.c.b bVar) {
                if (bVar == null || this.f14602a == null || StringUtils.isNull(bVar.f62518f)) {
                    return;
                }
                this.f14602a.W(bVar.f62518f, 10, false);
            }
        }

        public b() {
        }

        @Override // d.b.j0.t.d.h.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i) {
            return new a(this, LayoutInflater.from(RecommendActivityView.this.m.getPageActivity()).inflate(R.layout.special_bar_recommend_activity, viewGroup, false));
        }
    }

    public RecommendActivityView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = new b();
        this.m = tbPageContext;
        AlaBannerAutoScrollView<d.b.j0.t.d.f.c.b> alaBannerAutoScrollView = (AlaBannerAutoScrollView) m().findViewById(R.id.banner_container);
        this.n = alaBannerAutoScrollView;
        alaBannerAutoScrollView.setViewHolderAdapter(this.o);
        this.n.setOnBannerClickListener(new a());
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.special_bar_recommend_banner;
    }

    @Override // d.b.j0.x.b
    public View m() {
        return super.m();
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.n.q(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: v */
    public void n(c cVar) {
        if (cVar == null || ListUtils.isEmpty(cVar.f62520e)) {
            return;
        }
        this.n.n(cVar.f62520e, this.o);
        TiebaStatic.log("c12901");
    }
}
