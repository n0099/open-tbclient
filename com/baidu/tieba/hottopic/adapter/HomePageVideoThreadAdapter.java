package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.a.j0.j2.e;
import d.a.j0.x.b0;
import d.a.j0.x.e0.l;
/* loaded from: classes4.dex */
public class HomePageVideoThreadAdapter extends d.a.c.j.e.a<l, HomePageVideoThreadViewHolder> {
    public BdUniqueId m;
    public TbPageContext<HotTopicActivity> n;
    public d.a.j0.x.l o;
    public b0<l> p;

    /* loaded from: classes4.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements e {

        /* renamed from: e  reason: collision with root package name */
        public d.a.j0.x.l f17505e;

        public HomePageVideoThreadViewHolder(d.a.j0.x.l lVar) {
            super(lVar.l());
            this.f17505e = lVar;
        }

        @Override // d.a.j0.j2.e
        public boolean C() {
            return false;
        }

        @Override // d.a.j0.j2.e
        public int getCurrentPosition() {
            d.a.j0.x.l lVar = this.f17505e;
            if (lVar == null) {
                return 0;
            }
            return lVar.getCurrentPosition();
        }

        @Override // d.a.j0.j2.e
        public String getPlayUrl() {
            d.a.j0.x.l lVar = this.f17505e;
            if (lVar == null) {
                return null;
            }
            return lVar.O();
        }

        @Override // d.a.j0.j2.e
        public View getVideoContainer() {
            d.a.j0.x.l lVar = this.f17505e;
            if (lVar == null) {
                return null;
            }
            return lVar.P();
        }

        @Override // d.a.j0.j2.e
        public boolean isPlayStarted() {
            d.a.j0.x.l lVar = this.f17505e;
            if (lVar == null) {
                return false;
            }
            return lVar.b0();
        }

        @Override // d.a.j0.j2.e
        public boolean isPlaying() {
            d.a.j0.x.l lVar = this.f17505e;
            if (lVar == null) {
                return false;
            }
            return lVar.isPlaying();
        }

        @Override // d.a.j0.j2.e
        public void startPlay() {
            d.a.j0.x.l lVar = this.f17505e;
            if (lVar != null) {
                lVar.startPlay();
            }
        }

        @Override // d.a.j0.j2.e
        public void stopPlay() {
            d.a.j0.x.l lVar = this.f17505e;
            if (lVar != null) {
                lVar.stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            if (lVar == null || lVar.m() == null || StringUtils.isNull(lVar.m().w1()) || StringUtils.isNull(lVar.M()) || HomePageVideoThreadAdapter.this.n == null || !(HomePageVideoThreadAdapter.this.n.getOrignalPage() instanceof d.a.j0.c1.b.a)) {
                return;
            }
            ((HotTopicActivity) HomePageVideoThreadAdapter.this.n.getOrignalPage()).businessStatisticForTopicClick(lVar);
        }
    }

    public HomePageVideoThreadAdapter(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = new a();
        this.n = tbPageContext;
        this.m = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public HomePageVideoThreadViewHolder P(ViewGroup viewGroup) {
        d.a.j0.x.l lVar = new d.a.j0.x.l(this.n);
        this.o = lVar;
        lVar.j0(false);
        this.o.f0(this.m);
        this.o.setFrom("hottopic");
        return new HomePageVideoThreadViewHolder(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        if (lVar != null) {
            lVar.U(i2 + 1);
            lVar.U = 1;
        }
        homePageVideoThreadViewHolder.f17505e.m(lVar);
        homePageVideoThreadViewHolder.f17505e.o(this.p);
        TbPageContext<HotTopicActivity> tbPageContext = this.n;
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof d.a.j0.c1.b.a)) {
            this.n.getOrignalPage().businessStatisticForTopic(lVar);
        }
        return homePageVideoThreadViewHolder.a();
    }
}
