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
import d.a.c.a.j;
import d.a.j0.t.d.f.c.c;
/* loaded from: classes4.dex */
public class RecommendActivityView extends d.a.j0.x.b<c> {
    public TbPageContext m;
    public AlaBannerAutoScrollView<d.a.j0.t.d.f.c.b> n;
    public d.a.j0.t.d.h.a.a o;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public RecommendActivityView f14671a;

        /* renamed from: b  reason: collision with root package name */
        public View f14672b;

        public ViewHolder(RecommendActivityView recommendActivityView) {
            super(recommendActivityView.l());
            this.f14671a = recommendActivityView;
            this.f14672b = recommendActivityView.l();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements d.a.j0.t.d.h.a.b {
        public a() {
        }

        @Override // d.a.j0.t.d.h.a.b
        public void a(Object obj) {
            if (obj == null || !(obj instanceof d.a.j0.t.d.f.c.b)) {
                return;
            }
            d.a.j0.t.d.f.c.b bVar = (d.a.j0.t.d.f.c.b) obj;
            if (!StringUtils.isNull(bVar.f60705e)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(RecommendActivityView.this.m.getPageActivity()), new String[]{bVar.f60705e}, true);
            }
            TiebaStatic.log("c12902");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.j0.t.d.h.a.a {

        /* loaded from: classes4.dex */
        public class a extends AlaBannerViewHolder<d.a.j0.t.d.f.c.b> {

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f14675a;

            public a(b bVar, View view) {
                super(view);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.cover);
                this.f14675a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i2) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i2, d.a.j0.t.d.f.c.b bVar) {
                if (bVar == null || this.f14675a == null || StringUtils.isNull(bVar.f60706f)) {
                    return;
                }
                this.f14675a.V(bVar.f60706f, 10, false);
            }
        }

        public b() {
        }

        @Override // d.a.j0.t.d.h.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i2) {
            return new a(this, LayoutInflater.from(RecommendActivityView.this.m.getPageActivity()).inflate(R.layout.special_bar_recommend_activity, viewGroup, false));
        }
    }

    public RecommendActivityView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = new b();
        this.m = tbPageContext;
        AlaBannerAutoScrollView<d.a.j0.t.d.f.c.b> alaBannerAutoScrollView = (AlaBannerAutoScrollView) l().findViewById(R.id.banner_container);
        this.n = alaBannerAutoScrollView;
        alaBannerAutoScrollView.setViewHolderAdapter(this.o);
        this.n.setOnBannerClickListener(new a());
        n(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.special_bar_recommend_banner;
    }

    @Override // d.a.j0.x.b
    public View l() {
        return super.l();
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        this.n.q(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: t */
    public void m(c cVar) {
        if (cVar == null || ListUtils.isEmpty(cVar.f60708e)) {
            return;
        }
        this.n.n(cVar.f60708e, this.o);
        TiebaStatic.log("c12901");
    }
}
