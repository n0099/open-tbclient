package com.baidu.tieba.frs.entelechy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
import d.a.c.e.k.b;
import d.a.c.e.p.l;
import d.a.i0.r.f0.q.c;
import d.a.j0.q0.k;
import d.a.j0.q0.x;
import d.a.j0.x.t;
/* loaded from: classes4.dex */
public class FrsUserRecommendAdapter extends k<x, FrsUserRecommendViewHolder> {
    public boolean w;
    public String x;
    public b<UserRecommendItemView> y;

    /* loaded from: classes4.dex */
    public static class FrsUserRecommendViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16065a;

        /* renamed from: b  reason: collision with root package name */
        public FlexibleHorizontalScrollView f16066b;

        /* renamed from: c  reason: collision with root package name */
        public UserRecommendLayout f16067c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16068d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16069e;

        /* renamed from: f  reason: collision with root package name */
        public final String f16070f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f16071g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f16072h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendLayout userRecommendLayout;
                d.a.i0.r.f0.q.a j;
                FrsUserRecommendViewHolder frsUserRecommendViewHolder = FrsUserRecommendViewHolder.this;
                FlexibleHorizontalScrollView flexibleHorizontalScrollView = frsUserRecommendViewHolder.f16066b;
                if (flexibleHorizontalScrollView == null || (userRecommendLayout = frsUserRecommendViewHolder.f16067c) == null) {
                    return;
                }
                flexibleHorizontalScrollView.smoothScrollBy(userRecommendLayout.getChildItemWidth(), 0);
                if ((view.getTag() instanceof c) && (j = ((c) view.getTag()).j()) != null) {
                    FrsUserRecommendViewHolder.this.e(j.getUserId(), 2);
                }
                if (FrsUserRecommendViewHolder.this.f16069e) {
                    TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 9).param("fid", FrsUserRecommendViewHolder.this.f16070f));
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view instanceof ClickableHeaderImageView) {
                    FrsUserRecommendViewHolder.this.e(((ClickableHeaderImageView) view).getUserId(), 1);
                }
                if (FrsUserRecommendViewHolder.this.f16069e) {
                    TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 9).param("fid", FrsUserRecommendViewHolder.this.f16070f));
                }
            }
        }

        public FrsUserRecommendViewHolder(View view, boolean z, String str) {
            super(view);
            this.f16069e = false;
            this.f16071g = new a();
            this.f16072h = new b();
            this.f16069e = z;
            this.f16070f = str;
            this.f16066b = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            UserRecommendLayout userRecommendLayout = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.f16067c = userRecommendLayout;
            userRecommendLayout.setItemSpace(l.g(view.getContext(), R.dimen.ds16));
            this.f16067c.setAfterLikeBtnClickListener(this.f16071g);
            this.f16067c.setAfterHeaderLickListener(this.f16072h);
            this.f16068d = (TextView) view.findViewById(R.id.user_recommend_document);
            this.f16065a = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        public final void e(String str, int i2) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12531").param("obj_locate", i2).param("obj_id", str));
        }
    }

    /* loaded from: classes4.dex */
    public class a implements d.a.c.e.k.c<UserRecommendItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ UserRecommendItemView a(UserRecommendItemView userRecommendItemView) {
            UserRecommendItemView userRecommendItemView2 = userRecommendItemView;
            e(userRecommendItemView2);
            return userRecommendItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ UserRecommendItemView c(UserRecommendItemView userRecommendItemView) {
            UserRecommendItemView userRecommendItemView2 = userRecommendItemView;
            h(userRecommendItemView2);
            return userRecommendItemView2;
        }

        public UserRecommendItemView e(UserRecommendItemView userRecommendItemView) {
            return userRecommendItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(UserRecommendItemView userRecommendItemView) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public UserRecommendItemView d() {
            return new UserRecommendItemView(FrsUserRecommendAdapter.this.f40319e);
        }

        public UserRecommendItemView h(UserRecommendItemView userRecommendItemView) {
            return userRecommendItemView;
        }
    }

    public FrsUserRecommendAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.w = false;
        this.y = new b<>(new a(), 10, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: u0 */
    public FrsUserRecommendViewHolder P(ViewGroup viewGroup) {
        FrsUserRecommendViewHolder frsUserRecommendViewHolder = new FrsUserRecommendViewHolder(LayoutInflater.from(this.f40319e).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.w, this.x);
        frsUserRecommendViewHolder.f16067c.setViewPool(this.y);
        return frsUserRecommendViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: v0 */
    public View W(int i2, View view, ViewGroup viewGroup, x xVar, FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
        if (xVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            frsUserRecommendViewHolder.f16068d.setText(xVar.e());
            frsUserRecommendViewHolder.f16067c.setPageContext(this.o);
            frsUserRecommendViewHolder.f16067c.setData(xVar.f());
            frsUserRecommendViewHolder.f16066b.setMaxOverScrollDistance(frsUserRecommendViewHolder.f16067c.getChildItemWidth());
            frsUserRecommendViewHolder.f16068d.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0106));
            frsUserRecommendViewHolder.f16065a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0205));
            if (!xVar.h()) {
                for (MetaData metaData : xVar.f()) {
                    if (metaData != null && !d.a.c.e.p.k.isEmpty(metaData.getUserId())) {
                        t.b().a(new StatisticItem("c12530").param("obj_id", metaData.getUserId()));
                    }
                }
                xVar.l(true);
            }
        }
        return frsUserRecommendViewHolder.a();
    }

    public void w0(String str) {
        this.x = str;
    }

    public void x0() {
        this.w = true;
    }
}
