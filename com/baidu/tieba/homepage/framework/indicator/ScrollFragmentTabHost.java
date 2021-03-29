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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import d.b.h0.a.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes3.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageTask D;
    public CustomMessageTask E;
    public StickyAppBarLayout F;
    public NestedScrollHeader G;
    public d.b.i0.b0.e H;
    public d.b.i0.z0.b.b I;
    public boolean J;
    public d.b.i0.z0.c.f.b K;
    public d.b.i0.z0.c.e L;
    public d.b.i0.z0.c.d M;

    /* renamed from: e  reason: collision with root package name */
    public Context f17111e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f17112f;

    /* renamed from: g  reason: collision with root package name */
    public HomeTabBarView f17113g;

    /* renamed from: h  reason: collision with root package name */
    public PluginErrorTipView f17114h;
    public NoNetworkView i;
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
    public d.b.i0.b0.e t;
    public List<q> u;
    public boolean v;
    public boolean w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                boolean C = ScrollFragmentTabHost.this.C();
                TiebaStatic.log(new StatisticItem("c12350").param("obj_type", C ? 1 : 0));
                if (C && ScrollFragmentTabHost.this.r != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                    ScrollFragmentTabHost.this.r.Q();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            ScrollFragmentTabHost.this.r.onPageScrolled(i, f2, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ScrollFragmentTabHost.this.s != null) {
                ScrollFragmentTabHost.this.s.a(i);
            }
            d.b.h0.r.n.b.i().n(ScrollFragmentTabHost.this.r.q(i) == 1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
            if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                if (ScrollFragmentTabHost.this.w(i) != 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                }
            }
            int q = ScrollFragmentTabHost.this.r.q(ScrollFragmentTabHost.this.k.getCurrentItem());
            if (q == 5) {
                if (ScrollFragmentTabHost.this.w) {
                    ScrollFragmentTabHost.this.w = false;
                } else {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", ScrollFragmentTabHost.this.E() ? 1 : 0);
                    statisticItem.eventStat();
                }
            }
            if (q == 0) {
                ScrollFragmentTabHost.this.t();
            }
            View c2 = ScrollFragmentTabHost.this.f17113g.c(0);
            if ((c2 instanceof LinearLayout) && TbadkCoreApplication.isLogin() && d.b.h0.b.d.h()) {
                LinearLayout linearLayout = (LinearLayout) c2;
                if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (q == 0) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                }
            }
            if (ScrollFragmentTabHost.this.u != null && ScrollFragmentTabHost.this.r != null) {
                int q2 = ScrollFragmentTabHost.this.r.q(ScrollFragmentTabHost.this.k.getCurrentItem());
                if (q2 == 5) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                    for (q qVar : ScrollFragmentTabHost.this.u) {
                        qVar.c();
                    }
                } else if (q2 == 1) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                    for (q qVar2 : ScrollFragmentTabHost.this.u) {
                        qVar2.b();
                    }
                } else if (q2 == 0) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                    for (q qVar3 : ScrollFragmentTabHost.this.u) {
                        qVar3.a();
                    }
                } else if (q2 == 6) {
                    ScrollFragmentTabHost.this.setScrollShadow(true);
                } else if (q2 == 7) {
                    ScrollFragmentTabHost.this.setScrollShadow(true);
                } else if (q2 == 8) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                } else {
                    ScrollFragmentTabHost.this.u();
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                }
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.w(i));
            if (ScrollFragmentTabHost.this.w(i) == 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        d.b.h0.r.d0.b.i().v(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    d.b.h0.r.d0.b.i().v("unlogin_hot_top_timestamp", currentTimeMillis);
                }
                if (ScrollFragmentTabHost.this.f17113g.f()) {
                    ScrollFragmentTabHost.this.f17113g.setShowHotTopicRedTip(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements PagerSlidingTabStrip.c {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.c
        public void a(View view, int i) {
            int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
            if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.k.getCurrentItem() != i) {
                if (ScrollFragmentTabHost.this.w(i) != 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                }
            }
            if (ScrollFragmentTabHost.this.w(i) == 7) {
                TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "1"));
            } else if (ScrollFragmentTabHost.this.w(i) == 8) {
                TiebaStatic.log(new StatisticItem("c13580"));
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.w(i));
            if (ScrollFragmentTabHost.this.w(i) == 5) {
                StatisticItem statisticItem = new StatisticItem("c13740");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_type", ScrollFragmentTabHost.this.E() ? 1 : 0);
                statisticItem.eventStat();
                ScrollFragmentTabHost.this.w = true;
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        d.b.h0.r.d0.b.i().v(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    d.b.h0.r.d0.b.i().v("unlogin_hot_top_timestamp", currentTimeMillis);
                }
                if (ScrollFragmentTabHost.this.f17113g.f()) {
                    ScrollFragmentTabHost.this.f17113g.setShowHotTopicRedTip(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements StickyAppBarLayout.b {
        public c() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.b
        public void a(boolean z) {
            if (!z || ScrollFragmentTabHost.this.H == null) {
                return;
            }
            ScrollFragmentTabHost.this.H.H();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements NestedScrollHeader.f {
        public d() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            if (ScrollFragmentTabHost.this.H != null) {
                ScrollFragmentTabHost.this.H.H();
                ScrollFragmentTabHost.this.H = null;
            }
            if (ScrollFragmentTabHost.this.f17112f != null) {
                UrlManager.getInstance().dealOneLink(ScrollFragmentTabHost.this.f17112f, new String[]{str});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements NestedScrollHeader.f {
        public e() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            if (ScrollFragmentTabHost.this.H != null) {
                ScrollFragmentTabHost.this.H.H();
                ScrollFragmentTabHost.this.H = null;
            }
            if (ScrollFragmentTabHost.this.f17112f != null) {
                UrlManager.getInstance().dealOneLink(ScrollFragmentTabHost.this.f17112f, new String[]{str});
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class g implements d.b.i0.z0.c.e {
        public g() {
        }

        @Override // d.b.i0.z0.c.e
        public void a(int i) {
            ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.r.p(i), false);
            ScrollFragmentTabHost.this.r.B(i);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.b.i0.z0.c.d {
        public h() {
        }

        @Override // d.b.i0.z0.c.d
        public void a(int i) {
            ScrollFragmentTabHost.this.K.b(i, ScrollFragmentTabHost.this.L);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                z = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
            if (z) {
                ScrollFragmentTabHost.this.Q();
            } else {
                ScrollFragmentTabHost.this.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || ScrollFragmentTabHost.this.H == null) {
                return;
            }
            ScrollFragmentTabHost.this.H.H();
            ScrollFragmentTabHost.this.H = null;
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f17126e;

            public a(k kVar, ImageView imageView) {
                this.f17126e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f17126e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f17127e;

            public b(k kVar, ImageView imageView) {
                this.f17127e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f17127e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public k(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.f17113g.c(0);
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
                if (ScrollFragmentTabHost.this.f17113g != null) {
                    ScrollFragmentTabHost.this.I.l(ScrollFragmentTabHost.this.f17113g.getBackgroundAlpha());
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

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public l(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || ScrollFragmentTabHost.this.J == d.b.h0.b.d.h()) {
                return;
            }
            ScrollFragmentTabHost.this.f17113g.j();
            if (d.b.h0.b.d.h() && ScrollFragmentTabHost.this.v) {
                ScrollFragmentTabHost.this.t();
                ScrollFragmentTabHost.this.O();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f17130e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f17131f;

            public a(m mVar, TextView textView, int i) {
                this.f17130e = textView;
                this.f17131f = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f17130e.setMaxWidth(this.f17131f + ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f17132e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f17133f;

            public b(m mVar, TextView textView, int i) {
                this.f17132e = textView;
                this.f17133f = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f17132e.setMaxWidth(this.f17133f - ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Animator.AnimatorListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f17134e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f17135f;

            public c(m mVar, TextView textView, String str) {
                this.f17134e = textView;
                this.f17135f = str;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.f17134e.setText(this.f17135f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public m(int i) {
            super(i);
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
            LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.f17113g.c(0);
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
                    d.b.h0.r.d0.b.i().u("key_home_concern_all_status", 1);
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
                d.b.h0.r.d0.b.i().u("key_home_concern_all_status", 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends CustomMessageListener {
        public n(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ScrollFragmentTabHost.this.r == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            ScrollFragmentTabHost.this.r.U();
            if (!booleanValue || !d.b.h0.c1.b.c.d()) {
                ScrollFragmentTabHost.this.r.I();
            } else {
                ScrollFragmentTabHost.this.r.G();
            }
            ScrollFragmentTabHost.this.f17113g.q();
        }
    }

    /* loaded from: classes3.dex */
    public class o implements CustomMessageTask.CustomRunnable<n.b> {
        public o() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<n.b> customMessage) {
            if (ScrollFragmentTabHost.this.f17112f != null && !ScrollFragmentTabHost.this.f17112f.getPageActivity().isFinishing() && ScrollFragmentTabHost.this.F != null && ScrollFragmentTabHost.this.G != null) {
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.f17113g.getTaskView() : ScrollFragmentTabHost.this.G.getTaskView();
                if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.b)) {
                    n.b data = customMessage.getData();
                    int intValue = data.f49605c.intValue() > 0 ? data.f49605c.intValue() * 1000 : 5000;
                    String str = data.f49609g;
                    if (TextUtils.isEmpty(str)) {
                        str = ScrollFragmentTabHost.this.f17112f.getString(R.string.task_float_tip_toast);
                    }
                    String fixedText = UtilHelper.getFixedText(str, 20);
                    if (ScrollFragmentTabHost.this.H != null) {
                        ScrollFragmentTabHost.this.H.H();
                    }
                    ScrollFragmentTabHost scrollFragmentTabHost = ScrollFragmentTabHost.this;
                    scrollFragmentTabHost.H = new d.b.i0.b0.e(scrollFragmentTabHost.f17112f, taskView);
                    ScrollFragmentTabHost.this.H.N(48);
                    ScrollFragmentTabHost.this.H.d0(true);
                    ScrollFragmentTabHost.this.H.K(4);
                    ScrollFragmentTabHost.this.H.M(intValue);
                    ScrollFragmentTabHost.this.H.T(true);
                    ScrollFragmentTabHost.this.H.f0(0);
                    ScrollFragmentTabHost.this.H.h0(fixedText);
                    return new CustomResponsedMessage<>(2921409, Boolean.TRUE);
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class p implements CustomMessageTask.CustomRunnable<Boolean> {
        public p() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.F == null) {
                return null;
            }
            ScrollFragmentTabHost.this.u();
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

    /* loaded from: classes3.dex */
    public static abstract class q {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    /* loaded from: classes3.dex */
    public interface r {
        void a(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.w = false;
        this.x = new i(2921400);
        this.y = new j(2921415);
        this.z = new k(2921501);
        this.A = new l(2921506);
        this.B = new m(2921502);
        this.C = new n(2921509);
        this.D = new CustomMessageTask(2921409, new o());
        this.E = new CustomMessageTask(2921405, new p());
        this.K = new d.b.i0.z0.c.f.b();
        this.L = new g();
        this.M = new h();
        y();
    }

    public void A(FragmentManager fragmentManager, d.b.i0.z0.c.b bVar, ConcernPageView.l lVar) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.f17111e, fragmentManager, bVar, lVar);
        this.r = newScrollFragmentAdapter;
        newScrollFragmentAdapter.L(this);
        this.k.setOffscreenPageLimit(2);
        this.k.setAdapter(this.r);
        int n2 = this.r.n();
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.r;
        if (HomePageStatic.f16972a) {
            n2 = 0;
        }
        this.k.setCurrentItem(newScrollFragmentAdapter2.p(n2));
        this.f17113g.setViewPager(this.k);
        this.f17113g.setConcernTabIndex(this.r.p(0));
        if (this.r.o() != -1) {
            this.f17113g.setHotTopicTabIndex(this.r.o());
            this.f17113g.setShowHotTopicRedTip(D());
        }
    }

    public final boolean B() {
        return this.m.getVisibility() == 0;
    }

    public boolean C() {
        if (this.f17113g == null || !this.r.w()) {
            return false;
        }
        return this.f17113g.e();
    }

    public final boolean D() {
        long currentTimeMillis = System.currentTimeMillis();
        if (TbadkCoreApplication.isLogin()) {
            return !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && currentTimeMillis - d.b.h0.r.d0.b.i().k(TbadkCoreApplication.getCurrentAccount(), 0L) >= 86400000;
        }
        return currentTimeMillis - d.b.h0.r.d0.b.i().k("unlogin_hot_top_timestamp", 0L) >= 86400000;
    }

    public boolean E() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        if (this.f17113g == null || (newScrollFragmentAdapter = this.r) == null || !newScrollFragmentAdapter.x()) {
            return false;
        }
        return this.f17113g.f();
    }

    public void F() {
        HomeTabBarView homeTabBarView;
        StickyAppBarLayout stickyAppBarLayout = this.F;
        if (stickyAppBarLayout == null || stickyAppBarLayout.d() || (homeTabBarView = this.f17113g) == null || homeTabBarView.getTaskView() == null || this.f17113g.getTaskView().getVisibility() == 0) {
            return;
        }
        this.f17113g.i();
    }

    public void G() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter == null || HomePageStatic.f16972a) {
            return;
        }
        this.k.setAdapter(newScrollFragmentAdapter);
        this.f17113g.j();
        this.K.a(this.L);
    }

    public void H(boolean z) {
    }

    public void I(int i2) {
        PluginErrorTipView pluginErrorTipView;
        NoNetworkView noNetworkView;
        d.b.h0.r.u.c.a(this.F).i(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        this.G.k();
        this.f17113g.k();
        TbPageContext tbPageContext = this.f17112f;
        if (tbPageContext != null && (noNetworkView = this.i) != null) {
            noNetworkView.c(tbPageContext, i2);
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.E(i2);
        }
        TbPageContext tbPageContext2 = this.f17112f;
        if (tbPageContext2 != null && (pluginErrorTipView = this.f17114h) != null) {
            pluginErrorTipView.e(tbPageContext2, i2);
        }
        d.b.i0.z0.b.b bVar = this.I;
        if (bVar != null) {
            bVar.k(i2);
        }
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0203);
        SkinManager.setBackgroundResource(this.m, R.drawable.personalize_tab_shadow);
    }

    public void J() {
        MessageManager.getInstance().unRegisterTask(2921409);
        d.b.i0.b0.e eVar = this.H;
        if (eVar != null) {
            eVar.H();
            this.H = null;
        }
        t();
        MessageManager.getInstance().unRegisterListener(this.A);
    }

    public void K() {
        HomeTabBarView homeTabBarView = this.f17113g;
        if (homeTabBarView != null) {
            homeTabBarView.l();
        }
    }

    public void L() {
        this.r.r(this.M);
    }

    public void M() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.F();
        }
    }

    public void N(q qVar) {
        List<q> list = this.u;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.u.remove(qVar);
    }

    public void O() {
        if (TbadkCoreApplication.isLogin()) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int p2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.p(0) : 0;
            if (this.t == null) {
                d.b.i0.b0.e eVar = new d.b.i0.b0.e(this.f17112f, this.f17113g.c(p2));
                this.t = eVar;
                eVar.c0(R.drawable.bg_tip_blue_up_left);
                this.t.N(16);
                this.t.T(true);
                this.t.f0(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.t.d0(true);
                this.t.M(4000);
            }
            this.t.i0(this.f17111e.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void P() {
        if (d.b.h0.r.d0.b.i().j("key_concern_tab_tips_switch", 0) == 0) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        int p2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.p(0) : 0;
        if (this.t == null) {
            d.b.i0.b0.e eVar = new d.b.i0.b0.e(this.f17112f, this.f17113g.c(p2));
            this.t = eVar;
            eVar.c0(R.drawable.bg_tip_blue_up);
            this.t.N(32);
            this.t.T(true);
            this.t.d0(true);
            this.t.g0(d.b.b.e.p.l.g(this.f17111e, R.dimen.ds16));
            this.t.M(4000);
        }
        this.t.j0(this.f17111e.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
    }

    public void Q() {
        if (this.o && !B()) {
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

    public void R() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.P();
        }
    }

    public void S(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.R(dataRes, z);
        }
    }

    public void T(String str, int i2, int i3) {
        if (this.k == null) {
            return;
        }
        this.r.S(str, i2, i3);
    }

    public void U(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.T(dataRes, z, z2);
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
            return newScrollFragmentAdapter.m();
        }
        return null;
    }

    public int getCurrentTabType() {
        return this.r.q(this.k.getCurrentItem());
    }

    public FrameLayout getFrameLayout() {
        return this.j;
    }

    public int getVideoRecommendIndex() {
        if (this.k.getAdapter() != null) {
            int count = this.k.getAdapter().getCount();
            for (int i2 = 0; i2 < count; i2++) {
                if (this.r.q(i2) == 8) {
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

    public void s(q qVar) {
        if (this.u == null) {
            this.u = new ArrayList();
        }
        this.u.add(qVar);
    }

    public void setCurrentTab(int i2, boolean z) {
        if (i2 < 0 || i2 >= this.r.getCount()) {
            return;
        }
        this.f17113g.setTabItemClicked(z);
        this.r.M(i2);
        this.k.setCurrentItem(i2);
    }

    public void setFakeClickCurrentTab(int i2) {
        setCurrentTab(this.r.p(i2), true);
    }

    public void setOnTabSelectedListener(r rVar) {
        this.s = rVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.f17113g.setPageUniqueId(bdUniqueId);
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
            newScrollFragmentAdapter.K(z);
        }
        NoNetworkView noNetworkView = this.i;
        if (noNetworkView == null || !z) {
            return;
        }
        noNetworkView.setVisibility(d.b.b.e.p.j.A() ? 8 : 0);
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
        if (this.f17113g == null || !this.r.w()) {
            return;
        }
        this.f17113g.setShowConcernRedTip(z);
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.O(str);
        }
    }

    public void t() {
        d.b.i0.b0.e eVar = this.t;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void u() {
        if (this.o && B()) {
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

    public void v() {
        this.r.l();
    }

    public int w(int i2) {
        return this.r.q(i2);
    }

    public boolean x() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        return newScrollFragmentAdapter != null && newScrollFragmentAdapter.getCount() > 0;
    }

    public final void y() {
        this.f17111e = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.F = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.G = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.f17113g = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.f17114h = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.i = (NoNetworkView) findViewById(R.id.view_no_network);
        this.j = (FrameLayout) findViewById(R.id.home_pager_container);
        this.k = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.l = findViewById(R.id.divider_line);
        this.m = findViewById(R.id.divider_shadow);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.n = tBSpecificationBtn;
        tBSpecificationBtn.setVisibility(8);
        this.I = new d.b.i0.z0.b.b(this.f17111e);
        this.J = d.b.h0.b.d.h();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.F.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) this.j.getLayoutParams())).topMargin = 0;
        this.f17113g.setOnPageChangeListener(new a());
        this.f17113g.setOnTabItemClickListener(new b());
        this.F.setOnHeaderStickyListener(new c());
        this.G.setEntranceJumpListener(new d());
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.G.setVisibility(8);
            this.f17113g.setMissionEntranceVisibility(true);
            this.f17113g.setEntranceJumpListener(new e());
            return;
        }
        this.G.setVisibility(0);
        this.f17113g.setMissionEntranceVisibility(false);
    }

    public void z(TbPageContext tbPageContext, NoNetworkView.b bVar) {
        this.f17112f = tbPageContext;
        this.i.a(bVar);
        MessageManager.getInstance().registerListener(this.x);
        MessageManager.getInstance().registerListener(this.y);
        MessageManager.getInstance().registerListener(this.B);
        MessageManager.getInstance().registerListener(this.z);
        MessageManager.getInstance().registerListener(this.A);
        MessageManager.getInstance().registerListener(this.C);
        this.D.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.D);
    }

    public void setCurrentTab(int i2) {
        setCurrentTab(this.r.p(i2), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.r.s(str), false);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = false;
        this.x = new i(2921400);
        this.y = new j(2921415);
        this.z = new k(2921501);
        this.A = new l(2921506);
        this.B = new m(2921502);
        this.C = new n(2921509);
        this.D = new CustomMessageTask(2921409, new o());
        this.E = new CustomMessageTask(2921405, new p());
        this.K = new d.b.i0.z0.c.f.b();
        this.L = new g();
        this.M = new h();
        y();
    }
}
