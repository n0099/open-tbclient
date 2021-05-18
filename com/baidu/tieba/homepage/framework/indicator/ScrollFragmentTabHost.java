package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import d.a.j0.a.o;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageTask D;
    public CustomMessageTask E;
    public StickyAppBarLayout F;
    public NestedScrollHeader G;
    public d.a.k0.b0.e H;
    public d.a.k0.a1.b.b I;
    public boolean J;
    public d.a.k0.a1.c.f.b K;
    public d.a.k0.a1.c.e L;
    public d.a.k0.a1.c.d M;

    /* renamed from: e  reason: collision with root package name */
    public Context f16367e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f16368f;

    /* renamed from: g  reason: collision with root package name */
    public HomeTabBarView f16369g;

    /* renamed from: h  reason: collision with root package name */
    public PluginErrorTipView f16370h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f16371i;
    public FrameLayout j;
    public CustomViewPager k;
    public View l;
    public View m;
    public TBSpecificationBtn n;
    public boolean o;
    public AlphaAnimation p;
    public AlphaAnimation q;
    public NewScrollFragmentAdapter r;
    public r s;
    public d.a.k0.b0.e t;
    public List<q> u;
    public boolean v;
    public boolean w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (i2 == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                boolean F = ScrollFragmentTabHost.this.F();
                TiebaStatic.log(new StatisticItem("c12350").param("obj_type", F ? 1 : 0));
                if (F && ScrollFragmentTabHost.this.r != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                    ScrollFragmentTabHost.this.r.L();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            ScrollFragmentTabHost.this.r.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (ScrollFragmentTabHost.this.s != null) {
                ScrollFragmentTabHost.this.s.a(i2);
            }
            d.a.j0.r.n.b.i().n(ScrollFragmentTabHost.this.r.n(i2) == 1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
            if (i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) {
                if (ScrollFragmentTabHost.this.z(i2) != 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                }
            }
            int n = ScrollFragmentTabHost.this.r.n(ScrollFragmentTabHost.this.k.getCurrentItem());
            if (n == 5) {
                if (ScrollFragmentTabHost.this.w) {
                    ScrollFragmentTabHost.this.w = false;
                } else {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", ScrollFragmentTabHost.this.H() ? 1 : 0);
                    statisticItem.eventStat();
                }
            }
            if (n == 0) {
                ScrollFragmentTabHost.this.v();
            }
            View c2 = ScrollFragmentTabHost.this.f16369g.c(0);
            if ((c2 instanceof LinearLayout) && TbadkCoreApplication.isLogin() && d.a.j0.b.d.h()) {
                LinearLayout linearLayout = (LinearLayout) c2;
                if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (n == 0) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                }
            }
            if (ScrollFragmentTabHost.this.u != null && ScrollFragmentTabHost.this.r != null) {
                int n2 = ScrollFragmentTabHost.this.r.n(ScrollFragmentTabHost.this.k.getCurrentItem());
                if (n2 == 5) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                    for (q qVar : ScrollFragmentTabHost.this.u) {
                        qVar.c();
                    }
                } else if (n2 == 1) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                    for (q qVar2 : ScrollFragmentTabHost.this.u) {
                        qVar2.b();
                    }
                } else if (n2 == 0) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                    for (q qVar3 : ScrollFragmentTabHost.this.u) {
                        qVar3.a();
                    }
                } else if (n2 == 6) {
                    ScrollFragmentTabHost.this.setScrollShadow(true);
                } else if (n2 == 7) {
                    ScrollFragmentTabHost.this.setScrollShadow(true);
                } else if (n2 == 8) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                } else {
                    ScrollFragmentTabHost.this.w();
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                }
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.z(i2));
            if (ScrollFragmentTabHost.this.z(i2) == 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        d.a.j0.r.d0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    d.a.j0.r.d0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                }
                if (ScrollFragmentTabHost.this.f16369g.f()) {
                    ScrollFragmentTabHost.this.f16369g.setShowHotTopicRedTip(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PagerSlidingTabStrip.c {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.c
        public void a(View view, int i2) {
            if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(ScrollFragmentTabHost.this.f16368f)) {
                return;
            }
            ScrollFragmentTabHost.this.t(i2);
            int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
            if ((i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.k.getCurrentItem() != i2) {
                if (ScrollFragmentTabHost.this.z(i2) != 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                }
            }
            if (ScrollFragmentTabHost.this.z(i2) == 7) {
                TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "1"));
            } else if (ScrollFragmentTabHost.this.z(i2) == 8) {
                TiebaStatic.log(new StatisticItem("c13580"));
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.z(i2));
            if (ScrollFragmentTabHost.this.z(i2) == 5) {
                StatisticItem statisticItem = new StatisticItem("c13740");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_type", ScrollFragmentTabHost.this.H() ? 1 : 0);
                statisticItem.eventStat();
                ScrollFragmentTabHost.this.w = true;
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        d.a.j0.r.d0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    d.a.j0.r.d0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                }
                if (ScrollFragmentTabHost.this.f16369g.f()) {
                    ScrollFragmentTabHost.this.f16369g.setShowHotTopicRedTip(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements StickyAppBarLayout.b {
        public c() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.b
        public void a(boolean z) {
            if (!z || ScrollFragmentTabHost.this.H == null) {
                return;
            }
            ScrollFragmentTabHost.this.H.I();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NestedScrollHeader.f {
        public d() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            if (ScrollFragmentTabHost.this.H != null) {
                ScrollFragmentTabHost.this.H.I();
                ScrollFragmentTabHost.this.H = null;
            }
            if (ScrollFragmentTabHost.this.f16368f != null) {
                UrlManager.getInstance().dealOneLink(ScrollFragmentTabHost.this.f16368f, new String[]{str});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements NestedScrollHeader.f {
        public e() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            if (ScrollFragmentTabHost.this.H != null) {
                ScrollFragmentTabHost.this.H.I();
                ScrollFragmentTabHost.this.H = null;
            }
            if (ScrollFragmentTabHost.this.f16368f != null) {
                UrlManager.getInstance().dealOneLink(ScrollFragmentTabHost.this.f16368f, new String[]{str});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ScrollFragmentTabHost.this.m.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.k0.a1.c.e {
        public g() {
        }

        @Override // d.a.k0.a1.c.e
        public void a(int i2) {
            ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.r.m(i2), false);
            ScrollFragmentTabHost.this.r.x(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.a.k0.a1.c.d {
        public h() {
        }

        @Override // d.a.k0.a1.c.d
        public void a(int i2) {
            ScrollFragmentTabHost.this.K.b(i2, ScrollFragmentTabHost.this.L);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                z = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
            if (z) {
                ScrollFragmentTabHost.this.T();
            } else {
                ScrollFragmentTabHost.this.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || ScrollFragmentTabHost.this.H == null) {
                return;
            }
            ScrollFragmentTabHost.this.H.I();
            ScrollFragmentTabHost.this.H = null;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f16383e;

            public a(k kVar, ImageView imageView) {
                this.f16383e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16383e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f16384e;

            public b(k kVar, ImageView imageView) {
                this.f16384e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16384e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.f16369g.c(0);
            if (intValue == 1) {
                if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 1) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (Float.floatToIntBits(imageView.getRotationX()) == Float.floatToIntBits(0.0f)) {
                        ValueAnimator ofInt = ValueAnimator.ofInt(0, 180);
                        ofInt.setDuration(200L);
                        ofInt.setStartDelay(30L);
                        ofInt.addUpdateListener(new a(this, imageView));
                        ofInt.start();
                    }
                }
                if (ScrollFragmentTabHost.this.f16369g != null) {
                    ScrollFragmentTabHost.this.I.l(ScrollFragmentTabHost.this.f16369g.getBackgroundAlpha());
                    ScrollFragmentTabHost.this.I.k(TbadkCoreApplication.getInst().getSkinType());
                }
                ScrollFragmentTabHost.this.I.n(ScrollFragmentTabHost.this.F);
            } else if (!(linearLayout instanceof LinearLayout) || linearLayout.getChildCount() <= 1) {
            } else {
                ImageView imageView2 = (ImageView) linearLayout.getChildAt(1);
                if (Float.floatToIntBits(imageView2.getRotationX()) == Float.floatToIntBits(180.0f)) {
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(180, 0);
                    ofInt2.setDuration(200L);
                    ofInt2.setStartDelay(30L);
                    ofInt2.addUpdateListener(new b(this, imageView2));
                    ofInt2.start();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || ScrollFragmentTabHost.this.J == d.a.j0.b.d.h()) {
                return;
            }
            ScrollFragmentTabHost.this.f16369g.i();
            if (d.a.j0.b.d.h() && ScrollFragmentTabHost.this.v) {
                ScrollFragmentTabHost.this.v();
                ScrollFragmentTabHost.this.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16387e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f16388f;

            public a(m mVar, TextView textView, int i2) {
                this.f16387e = textView;
                this.f16388f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16387e.setMaxWidth(this.f16388f + ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16389e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f16390f;

            public b(m mVar, TextView textView, int i2) {
                this.f16389e = textView;
                this.f16390f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16389e.setMaxWidth(this.f16390f - ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Animator.AnimatorListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16391e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f16392f;

            public c(m mVar, TextView textView, String str) {
                this.f16391e = textView;
                this.f16392f = str;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.f16391e.setText(this.f16392f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public m(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
            String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.f16369g.c(0);
            if (intValue == 1) {
                if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    if (string2.equals(textView.getText())) {
                        int measuredWidth = textView.getMeasuredWidth();
                        textView.setText(string);
                        int measureText = (int) textView.getPaint().measureText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                        int measureText2 = (int) textView.getPaint().measureText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                        if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                            ofInt.setDuration(360L);
                            ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                            ofInt.start();
                        }
                    }
                    d.a.j0.r.d0.b.j().v("key_home_concern_all_status", 1);
                }
            } else if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                TextView textView2 = (TextView) linearLayout.getChildAt(0);
                if (string.equals(textView2.getText())) {
                    int measuredWidth2 = textView2.getMeasuredWidth();
                    int measureText3 = (int) textView2.getPaint().measureText(string);
                    int measureText4 = (int) textView2.getPaint().measureText(string2);
                    if (measuredWidth2 > 0 && measureText3 > 0 && measureText4 > 0) {
                        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, measureText3 - measureText4);
                        ofInt2.setDuration(360L);
                        ofInt2.addUpdateListener(new b(this, textView2, measuredWidth2));
                        ofInt2.addListener(new c(this, textView2, string2));
                        ofInt2.start();
                    }
                }
                d.a.j0.r.d0.b.j().v("key_home_concern_all_status", 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public n(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ScrollFragmentTabHost.this.r == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            ScrollFragmentTabHost.this.r.P();
            if (!booleanValue || !d.a.j0.c1.b.c.d()) {
                ScrollFragmentTabHost.this.r.B();
            } else {
                ScrollFragmentTabHost.this.r.A();
            }
            ScrollFragmentTabHost.this.f16369g.p();
        }
    }

    /* loaded from: classes4.dex */
    public class o implements CustomMessageTask.CustomRunnable<o.b> {
        public o() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<o.b> customMessage) {
            if (ScrollFragmentTabHost.this.f16368f != null && !ScrollFragmentTabHost.this.f16368f.getPageActivity().isFinishing() && ScrollFragmentTabHost.this.F != null && ScrollFragmentTabHost.this.G != null) {
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.f16369g.getTaskView() : ScrollFragmentTabHost.this.G.getTaskView();
                if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof o.b)) {
                    o.b data = customMessage.getData();
                    int intValue = data.f48724c.intValue() > 0 ? data.f48724c.intValue() * 1000 : 5000;
                    String str = data.f48728g;
                    if (TextUtils.isEmpty(str)) {
                        str = ScrollFragmentTabHost.this.f16368f.getString(R.string.task_float_tip_toast);
                    }
                    String fixedText = UtilHelper.getFixedText(str, 20);
                    if (ScrollFragmentTabHost.this.H != null) {
                        ScrollFragmentTabHost.this.H.I();
                    }
                    ScrollFragmentTabHost scrollFragmentTabHost = ScrollFragmentTabHost.this;
                    scrollFragmentTabHost.H = new d.a.k0.b0.e(scrollFragmentTabHost.f16368f, taskView);
                    ScrollFragmentTabHost.this.H.O(48);
                    ScrollFragmentTabHost.this.H.h0(true);
                    ScrollFragmentTabHost.this.H.L(4);
                    ScrollFragmentTabHost.this.H.N(intValue);
                    ScrollFragmentTabHost.this.H.U(true);
                    ScrollFragmentTabHost.this.H.j0(0);
                    ScrollFragmentTabHost.this.H.l0(fixedText);
                    return new CustomResponsedMessage<>(2921409, Boolean.TRUE);
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class p implements CustomMessageTask.CustomRunnable<Boolean> {
        public p() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.F == null) {
                return null;
            }
            ScrollFragmentTabHost.this.w();
            boolean z = false;
            if (customMessage.getData().booleanValue()) {
                z = ScrollFragmentTabHost.this.F.f();
            } else if (ScrollFragmentTabHost.this.F.d() && ScrollFragmentTabHost.this.v) {
                z = true;
                ScrollFragmentTabHost.this.F.f();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, Boolean.TRUE));
            return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class q {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    /* loaded from: classes4.dex */
    public interface r {
        void a(int i2);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.w = false;
        this.x = new i(2921400);
        this.y = new j(2921415);
        this.z = new k(2921501);
        this.A = new l(2001371);
        this.B = new m(2921502);
        this.C = new n(2921509);
        this.D = new CustomMessageTask(2921409, new o());
        this.E = new CustomMessageTask(2921405, new p());
        this.K = new d.a.k0.a1.c.f.b();
        this.L = new g();
        this.M = new h();
        B();
    }

    public boolean A() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        return newScrollFragmentAdapter != null && newScrollFragmentAdapter.getCount() > 0;
    }

    public final void B() {
        this.f16367e = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.F = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.G = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.f16369g = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.f16370h = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.f16371i = (NoNetworkView) findViewById(R.id.view_no_network);
        this.j = (FrameLayout) findViewById(R.id.home_pager_container);
        this.k = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.l = findViewById(R.id.divider_line);
        this.m = findViewById(R.id.divider_shadow);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.n = tBSpecificationBtn;
        tBSpecificationBtn.setVisibility(8);
        this.I = new d.a.k0.a1.b.b(this.f16367e);
        this.J = d.a.j0.b.d.h();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.F.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) this.j.getLayoutParams())).topMargin = 0;
        this.f16369g.setOnPageChangeListener(new a());
        this.f16369g.setOnTabItemClickListener(new b());
        this.F.setOnHeaderStickyListener(new c());
        this.G.setEntranceJumpListener(new d());
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.G.setVisibility(8);
            this.f16369g.setMissionEntranceVisibility(true);
            this.f16369g.setEntranceJumpListener(new e());
            return;
        }
        this.G.setVisibility(0);
        this.f16369g.setMissionEntranceVisibility(false);
    }

    public void C(TbPageContext tbPageContext, NoNetworkView.b bVar) {
        this.f16368f = tbPageContext;
        this.f16371i.a(bVar);
        MessageManager.getInstance().registerListener(this.x);
        MessageManager.getInstance().registerListener(this.y);
        MessageManager.getInstance().registerListener(this.B);
        MessageManager.getInstance().registerListener(this.z);
        MessageManager.getInstance().registerListener(this.A);
        MessageManager.getInstance().registerListener(this.C);
        this.D.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.D);
    }

    public void D(FragmentManager fragmentManager, d.a.k0.a1.c.b bVar, ConcernPageView.l lVar) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.f16367e, fragmentManager, bVar, lVar);
        this.r = newScrollFragmentAdapter;
        newScrollFragmentAdapter.H(this);
        this.k.setOffscreenPageLimit(2);
        this.k.setAdapter(this.r);
        int k2 = this.r.k();
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.r;
        if (HomePageStatic.f16217a) {
            k2 = 0;
        }
        this.k.setCurrentItem(newScrollFragmentAdapter2.m(k2));
        this.f16369g.setViewPager(this.k);
        this.f16369g.setConcernTabIndex(this.r.m(0));
        if (this.r.l() != -1) {
            this.f16369g.setHotTopicTabIndex(this.r.l());
            this.f16369g.setShowHotTopicRedTip(G());
        }
        if (FullBrowseHelper.checkIsFullBrowseMode()) {
            this.k.setScrollable(false);
        } else {
            this.k.setScrollable(true);
        }
    }

    public final boolean E() {
        return this.m.getVisibility() == 0;
    }

    public boolean F() {
        if (this.f16369g == null || !this.r.s()) {
            return false;
        }
        return this.f16369g.e();
    }

    public final boolean G() {
        long currentTimeMillis = System.currentTimeMillis();
        if (TbadkCoreApplication.isLogin()) {
            return !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && currentTimeMillis - d.a.j0.r.d0.b.j().l(TbadkCoreApplication.getCurrentAccount(), 0L) >= 86400000;
        }
        return currentTimeMillis - d.a.j0.r.d0.b.j().l("unlogin_hot_top_timestamp", 0L) >= 86400000;
    }

    public boolean H() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        if (this.f16369g == null || (newScrollFragmentAdapter = this.r) == null || !newScrollFragmentAdapter.t()) {
            return false;
        }
        return this.f16369g.f();
    }

    public void I() {
        HomeTabBarView homeTabBarView;
        StickyAppBarLayout stickyAppBarLayout = this.F;
        if (stickyAppBarLayout == null || stickyAppBarLayout.d() || (homeTabBarView = this.f16369g) == null || homeTabBarView.getTaskView() == null || this.f16369g.getTaskView().getVisibility() == 0) {
            return;
        }
        this.f16369g.h();
    }

    public void J() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter == null || HomePageStatic.f16217a) {
            return;
        }
        this.k.setAdapter(newScrollFragmentAdapter);
        this.f16369g.i();
        this.K.a(this.L);
    }

    public void K(boolean z) {
    }

    public void L(int i2) {
        PluginErrorTipView pluginErrorTipView;
        NoNetworkView noNetworkView;
        d.a.j0.r.u.c.d(this.F).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        this.G.o();
        this.f16369g.j();
        TbPageContext tbPageContext = this.f16368f;
        if (tbPageContext != null && (noNetworkView = this.f16371i) != null) {
            noNetworkView.c(tbPageContext, i2);
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.y(i2);
        }
        TbPageContext tbPageContext2 = this.f16368f;
        if (tbPageContext2 != null && (pluginErrorTipView = this.f16370h) != null) {
            pluginErrorTipView.e(tbPageContext2, i2);
        }
        d.a.k0.a1.b.b bVar = this.I;
        if (bVar != null) {
            bVar.k(i2);
        }
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0203);
        SkinManager.setBackgroundResource(this.m, R.drawable.personalize_tab_shadow);
    }

    public void M() {
        MessageManager.getInstance().unRegisterTask(2921409);
        d.a.k0.b0.e eVar = this.H;
        if (eVar != null) {
            eVar.I();
            this.H = null;
        }
        v();
        MessageManager.getInstance().unRegisterListener(this.A);
    }

    public void N() {
        HomeTabBarView homeTabBarView = this.f16369g;
        if (homeTabBarView != null) {
            homeTabBarView.k();
        }
    }

    public void O() {
        this.r.o(this.M);
    }

    public void P() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.z();
        }
    }

    public void Q(q qVar) {
        List<q> list = this.u;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.u.remove(qVar);
    }

    public void R() {
        if (TbadkCoreApplication.isLogin()) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int m2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.m(0) : 0;
            if (this.t == null) {
                d.a.k0.b0.e eVar = new d.a.k0.b0.e(this.f16368f, this.f16369g.c(m2));
                this.t = eVar;
                eVar.g0(R.drawable.bg_tip_blue_up_left);
                this.t.O(16);
                this.t.U(true);
                this.t.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.t.h0(true);
                this.t.N(4000);
            }
            this.t.m0(this.f16367e.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void S() {
        if (d.a.j0.r.d0.b.j().k("key_concern_tab_tips_switch", 0) == 0) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        int m2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.m(0) : 0;
        if (this.t == null) {
            d.a.k0.b0.e eVar = new d.a.k0.b0.e(this.f16368f, this.f16369g.c(m2));
            this.t = eVar;
            eVar.g0(R.drawable.bg_tip_blue_up);
            this.t.O(32);
            this.t.U(true);
            this.t.h0(true);
            this.t.k0(d.a.c.e.p.l.g(this.f16367e, R.dimen.ds16));
            this.t.N(4000);
        }
        this.t.n0(this.f16367e.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
    }

    public void T() {
        if (this.o && !E()) {
            this.m.setVisibility(0);
            if (this.p == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.p = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.p.setDuration(300L);
            }
            this.m.startAnimation(this.p);
        }
    }

    public void U() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.K();
        }
    }

    public void V(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.M(dataRes, z);
        }
    }

    public void W(String str, int i2, int i3) {
        if (this.k == null) {
            return;
        }
        this.r.N(str, i2, i3);
    }

    public void X(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.O(dataRes, z, z2);
        }
    }

    public int getCurrentIndex() {
        CustomViewPager customViewPager = this.k;
        if (customViewPager != null) {
            return customViewPager.getCurrentItem();
        }
        return -1;
    }

    public String getCurrentPageKey() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            return newScrollFragmentAdapter.j();
        }
        return null;
    }

    public int getCurrentTabType() {
        return this.r.n(this.k.getCurrentItem());
    }

    public FrameLayout getFrameLayout() {
        return this.j;
    }

    public int getVideoRecommendIndex() {
        if (this.k.getAdapter() != null) {
            int count = this.k.getAdapter().getCount();
            for (int i2 = 0; i2 < count; i2++) {
                if (this.r.n(i2) == 8) {
                    return i2;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.E.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.E);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            MessageManager.getInstance().unRegisterTask(2921405);
        }
    }

    public void setCurrentTab(int i2, boolean z) {
        if (i2 < 0 || i2 >= this.r.getCount()) {
            return;
        }
        this.f16369g.setTabItemClicked(z);
        this.r.I(i2);
        this.k.setCurrentItem(i2);
    }

    public void setFakeClickCurrentTab(int i2) {
        setCurrentTab(this.r.m(i2), true);
    }

    public void setOnTabSelectedListener(r rVar) {
        this.s = rVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.f16369g.setPageUniqueId(bdUniqueId);
        this.x.setTag(bdUniqueId);
        this.y.setTag(bdUniqueId);
        this.B.setTag(bdUniqueId);
        this.z.setTag(bdUniqueId);
        this.C.setTag(bdUniqueId);
    }

    public void setPrimary(boolean z) {
        this.v = z;
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.G(z);
        }
        NoNetworkView noNetworkView = this.f16371i;
        if (noNetworkView == null || !z) {
            return;
        }
        noNetworkView.setVisibility(d.a.c.e.p.j.A() ? 8 : 0);
    }

    public void setScrollShadow(boolean z) {
        this.o = z;
        if (z) {
            View view = this.l;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.l;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.f16369g == null || !this.r.s()) {
            return;
        }
        this.f16369g.setShowConcernRedTip(z);
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.J(str);
        }
    }

    public final void t(int i2) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_type", y(i2));
        TiebaStaticHelper.addYYParam(statisticItem);
        TiebaStatic.log(statisticItem);
    }

    public void u(q qVar) {
        if (this.u == null) {
            this.u = new ArrayList();
        }
        this.u.add(qVar);
    }

    public void v() {
        d.a.k0.b0.e eVar = this.t;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void w() {
        if (this.o && E()) {
            if (this.q == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.q = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.q.setDuration(300L);
                this.q.setAnimationListener(new f());
            }
            this.m.startAnimation(this.q);
        }
    }

    public void x() {
        this.r.i();
    }

    public final int y(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return i2 != 4 ? -1 : 5;
                    }
                    return 4;
                }
                return 3;
            }
            return 1;
        }
        return 2;
    }

    public int z(int i2) {
        return this.r.n(i2);
    }

    public void setCurrentTab(int i2) {
        setCurrentTab(this.r.m(i2), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.r.p(str), false);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = false;
        this.x = new i(2921400);
        this.y = new j(2921415);
        this.z = new k(2921501);
        this.A = new l(2001371);
        this.B = new m(2921502);
        this.C = new n(2921509);
        this.D = new CustomMessageTask(2921409, new o());
        this.E = new CustomMessageTask(2921405, new p());
        this.K = new d.a.k0.a1.c.f.b();
        this.L = new g();
        this.M = new h();
        B();
    }
}
