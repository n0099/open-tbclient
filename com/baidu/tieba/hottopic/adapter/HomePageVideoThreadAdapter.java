package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.a.o0.k2.e;
import d.a.o0.z.b0;
import d.a.o0.z.e0.l;
/* loaded from: classes4.dex */
public class HomePageVideoThreadAdapter extends d.a.c.k.e.a<l, HomePageVideoThreadViewHolder> {
    public BdUniqueId m;
    public TbPageContext<HotTopicActivity> n;
    public d.a.o0.z.l o;
    public b0<l> p;

    /* loaded from: classes4.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements e {

        /* renamed from: e  reason: collision with root package name */
        public d.a.o0.z.l f16888e;

        public HomePageVideoThreadViewHolder(d.a.o0.z.l lVar) {
            super(lVar.m());
            this.f16888e = lVar;
        }

        @Override // d.a.o0.k2.e
        public boolean C() {
            return false;
        }

        @Override // d.a.o0.k2.e
        public int getCurrentPosition() {
            d.a.o0.z.l lVar = this.f16888e;
            if (lVar == null) {
                return 0;
            }
            return lVar.getCurrentPosition();
        }

        @Override // d.a.o0.k2.e
        public String getPlayUrl() {
            d.a.o0.z.l lVar = this.f16888e;
            if (lVar == null) {
                return null;
            }
            return lVar.P();
        }

        @Override // d.a.o0.k2.e
        public View getVideoContainer() {
            d.a.o0.z.l lVar = this.f16888e;
            if (lVar == null) {
                return null;
            }
            return lVar.Q();
        }

        @Override // d.a.o0.k2.e
        public boolean isPlayStarted() {
            d.a.o0.z.l lVar = this.f16888e;
            if (lVar == null) {
                return false;
            }
            return lVar.c0();
        }

        @Override // d.a.o0.k2.e
        public boolean isPlaying() {
            d.a.o0.z.l lVar = this.f16888e;
            if (lVar == null) {
                return false;
            }
            return lVar.isPlaying();
        }

        @Override // d.a.o0.k2.e
        public void startPlay() {
            d.a.o0.z.l lVar = this.f16888e;
            if (lVar != null) {
                lVar.startPlay();
            }
        }

        @Override // d.a.o0.k2.e
        public void stopPlay() {
            d.a.o0.z.l lVar = this.f16888e;
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
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            if (lVar == null || lVar.i() == null || StringUtils.isNull(lVar.i().z1()) || StringUtils.isNull(lVar.M()) || HomePageVideoThreadAdapter.this.n == null || !(HomePageVideoThreadAdapter.this.n.getOrignalPage() instanceof d.a.o0.d1.b.a)) {
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
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public HomePageVideoThreadViewHolder Q(ViewGroup viewGroup) {
        d.a.o0.z.l lVar = new d.a.o0.z.l(this.n);
        this.o = lVar;
        lVar.k0(false);
        this.o.g0(this.m);
        this.o.setFrom("hottopic");
        return new HomePageVideoThreadViewHolder(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        if (lVar != null) {
            lVar.U(i2 + 1);
            lVar.V = 1;
        }
        homePageVideoThreadViewHolder.f16888e.n(lVar);
        homePageVideoThreadViewHolder.f16888e.p(this.p);
        TbPageContext<HotTopicActivity> tbPageContext = this.n;
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof d.a.o0.d1.b.a)) {
            this.n.getOrignalPage().businessStatisticForTopic(lVar);
        }
        return homePageVideoThreadViewHolder.a();
    }
}
