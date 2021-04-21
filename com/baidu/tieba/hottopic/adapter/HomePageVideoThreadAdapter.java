package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.b.j0.j2.e;
import d.b.j0.x.b0;
import d.b.j0.x.e0.l;
/* loaded from: classes4.dex */
public class HomePageVideoThreadAdapter extends d.b.c.j.e.a<l, HomePageVideoThreadViewHolder> {
    public BdUniqueId m;
    public TbPageContext<HotTopicActivity> n;
    public d.b.j0.x.l o;
    public b0<l> p;

    /* loaded from: classes4.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements e {

        /* renamed from: e  reason: collision with root package name */
        public d.b.j0.x.l f17212e;

        public HomePageVideoThreadViewHolder(d.b.j0.x.l lVar) {
            super(lVar.m());
            this.f17212e = lVar;
        }

        @Override // d.b.j0.j2.e
        public boolean D() {
            return false;
        }

        @Override // d.b.j0.j2.e
        public int getCurrentPosition() {
            d.b.j0.x.l lVar = this.f17212e;
            if (lVar == null) {
                return 0;
            }
            return lVar.getCurrentPosition();
        }

        @Override // d.b.j0.j2.e
        public String getPlayUrl() {
            d.b.j0.x.l lVar = this.f17212e;
            if (lVar == null) {
                return null;
            }
            return lVar.R();
        }

        @Override // d.b.j0.j2.e
        public View getVideoContainer() {
            d.b.j0.x.l lVar = this.f17212e;
            if (lVar == null) {
                return null;
            }
            return lVar.S();
        }

        @Override // d.b.j0.j2.e
        public boolean isPlayStarted() {
            d.b.j0.x.l lVar = this.f17212e;
            if (lVar == null) {
                return false;
            }
            return lVar.g0();
        }

        @Override // d.b.j0.j2.e
        public boolean isPlaying() {
            d.b.j0.x.l lVar = this.f17212e;
            if (lVar == null) {
                return false;
            }
            return lVar.isPlaying();
        }

        @Override // d.b.j0.j2.e
        public void startPlay() {
            d.b.j0.x.l lVar = this.f17212e;
            if (lVar != null) {
                lVar.startPlay();
            }
        }

        @Override // d.b.j0.j2.e
        public void stopPlay() {
            d.b.j0.x.l lVar = this.f17212e;
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
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            if (lVar == null || lVar.n() == null || StringUtils.isNull(lVar.n().w1()) || StringUtils.isNull(lVar.M()) || HomePageVideoThreadAdapter.this.n == null || !(HomePageVideoThreadAdapter.this.n.getOrignalPage() instanceof d.b.j0.c1.b.a)) {
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
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public HomePageVideoThreadViewHolder R(ViewGroup viewGroup) {
        d.b.j0.x.l lVar = new d.b.j0.x.l(this.n);
        this.o = lVar;
        lVar.o0(false);
        this.o.j0(this.m);
        this.o.setFrom("hottopic");
        return new HomePageVideoThreadViewHolder(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        if (lVar != null) {
            lVar.U(i + 1);
            lVar.U = 1;
        }
        homePageVideoThreadViewHolder.f17212e.n(lVar);
        homePageVideoThreadViewHolder.f17212e.q(this.p);
        TbPageContext<HotTopicActivity> tbPageContext = this.n;
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof d.b.j0.c1.b.a)) {
            this.n.getOrignalPage().businessStatisticForTopic(lVar);
        }
        return homePageVideoThreadViewHolder.a();
    }
}
