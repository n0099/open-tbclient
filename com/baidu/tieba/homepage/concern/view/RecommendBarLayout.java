package com.baidu.tieba.homepage.concern.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.adapter.RecommendBarPageAdapter;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.r.u.c;
import d.b.i.q;
import d.b.i0.z0.b.f.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class RecommendBarLayout extends LinearLayout implements q, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final Context f17054e;

    /* renamed from: f  reason: collision with root package name */
    public int f17055f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f17056g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17057h;
    public ViewPager i;
    public ImageView j;
    public BdUniqueId k;
    public RecommendBarPageAdapter l;
    public TbPageContext<?> m;
    public byte n;
    public CustomMessageListener o;

    /* loaded from: classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            n i2 = RecommendBarLayout.this.l.i(i);
            if (i2 instanceof d) {
                d dVar = (d) i2;
                StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) RecommendBarLayout.this.n).param("obj_param1", i);
                if (!StringUtils.isNull(dVar.f62796e)) {
                    param = param.param("obj_name", dVar.f62796e);
                }
                TiebaStatic.log(param);
                StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.a()).param("obj_locate", (int) RecommendBarLayout.this.n);
                if (!StringUtils.isNull(dVar.f62796e)) {
                    param2 = param2.param("obj_name", dVar.f62796e);
                }
                TiebaStatic.log(param2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            if (longValue == 0) {
                return;
            }
            RecommendBarLayout.this.l.l(longValue, customResponsedMessage.getCmd() == 2001335);
        }
    }

    public RecommendBarLayout(TbPageContext<?> tbPageContext, Context context, BdUniqueId bdUniqueId, byte b2) {
        super(context, null, 0);
        this.f17055f = 3;
        this.o = new b(0);
        this.k = bdUniqueId;
        this.f17054e = context;
        this.m = tbPageContext;
        this.n = b2;
        c();
        d();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_bar_card, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f17056g = (FrameLayout) findViewById(R.id.recommend_bar_top);
        this.f17057h = (TextView) findViewById(R.id.recommend_bar_title);
        this.i = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
        this.j = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
        this.i.setOffscreenPageLimit(2);
        RecommendBarPageAdapter recommendBarPageAdapter = new RecommendBarPageAdapter(this.m, this.n);
        this.l = recommendBarPageAdapter;
        this.i.setAdapter(recommendBarPageAdapter);
        this.i.addOnPageChangeListener(new a());
        this.f17056g.setOnClickListener(this);
    }

    public final void d() {
        this.o.setTag(this.k);
        MessageManager.getInstance().registerListener(2001335, this.o);
        MessageManager.getInstance().registerListener(2001336, this.o);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.f17055f) {
            c a2 = c.a(this.f17057h);
            a2.s(R.string.F_X02);
            a2.n(R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.l.j(i);
        }
        this.f17055f = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.recommend_bar_top) {
            return;
        }
        n i = this.l.i(this.i.getCurrentItem());
        if (i instanceof d) {
            d dVar = (d) i;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.f17054e, dVar.f62798g)));
            StatisticItem param = new StatisticItem("c13645").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.n);
            if (!StringUtils.isNull(dVar.f62796e)) {
                param = param.param("obj_name", dVar.f62796e);
            }
            TiebaStatic.log(param);
        }
    }

    public void setData(d.b.i0.z0.b.f.c cVar) {
        if (cVar != null && !ListUtils.isEmpty(cVar.z())) {
            setVisibility(0);
            ((LinearLayout.LayoutParams) this.i.getLayoutParams()).height = l.g(this.m.getPageActivity(), cVar.A() ? R.dimen.tbds660 : R.dimen.tbds728);
            this.i.setCurrentItem(0, true);
            this.l.k(cVar);
            TiebaStatic.log(new StatisticItem("c13907").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.n));
            return;
        }
        setVisibility(8);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.k = bdUniqueId;
    }
}
