package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
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
import d.a.n0.a.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public CustomMessageTask F;
    public CustomMessageTask G;
    public StickyAppBarLayout H;
    public NestedScrollHeader I;
    public d.a.o0.d0.e J;
    public d.a.o0.b1.c.b K;
    public boolean L;
    public d.a.o0.b1.d.f.b M;
    public d.a.o0.b1.d.e N;
    public d.a.o0.b1.d.d O;

    /* renamed from: e  reason: collision with root package name */
    public Context f16420e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f16421f;

    /* renamed from: g  reason: collision with root package name */
    public HomeTabBarView f16422g;

    /* renamed from: h  reason: collision with root package name */
    public PluginErrorTipView f16423h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f16424i;
    public FrameLayout j;
    public CustomViewPager k;
    public View l;
    public View m;
    public TBSpecificationBtn n;
    public boolean o;
    public AlphaAnimation p;
    public AlphaAnimation q;
    public NewScrollFragmentAdapter r;
    public t s;
    public d.a.o0.d0.e t;
    public List<s> u;
    public boolean v;
    public boolean w;
    public GestureDetector x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (i2 == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                boolean G = ScrollFragmentTabHost.this.G();
                TiebaStatic.log(new StatisticItem("c12350").param("obj_type", G ? 1 : 0));
                if (G && ScrollFragmentTabHost.this.r != null) {
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
            d.a.n0.r.n.b.i().n(ScrollFragmentTabHost.this.r.p(i2) == 1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
            if (i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) {
                if (ScrollFragmentTabHost.this.A(i2) != 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                }
            }
            int p = ScrollFragmentTabHost.this.r.p(ScrollFragmentTabHost.this.k.getCurrentItem());
            if (p == 5) {
                if (ScrollFragmentTabHost.this.w) {
                    ScrollFragmentTabHost.this.w = false;
                } else {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", ScrollFragmentTabHost.this.I() ? 1 : 0);
                    statisticItem.eventStat();
                }
            }
            if (p == 0) {
                ScrollFragmentTabHost.this.w();
            }
            View c2 = ScrollFragmentTabHost.this.f16422g.c(0);
            if ((c2 instanceof LinearLayout) && TbadkCoreApplication.isLogin() && d.a.n0.b.d.h()) {
                LinearLayout linearLayout = (LinearLayout) c2;
                if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (p == 0) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                }
            }
            if (ScrollFragmentTabHost.this.u != null && ScrollFragmentTabHost.this.r != null) {
                int p2 = ScrollFragmentTabHost.this.r.p(ScrollFragmentTabHost.this.k.getCurrentItem());
                if (p2 == 5) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                    for (s sVar : ScrollFragmentTabHost.this.u) {
                        sVar.c();
                    }
                } else if (p2 == 1) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                    for (s sVar2 : ScrollFragmentTabHost.this.u) {
                        sVar2.b();
                    }
                } else if (p2 == 0) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                    for (s sVar3 : ScrollFragmentTabHost.this.u) {
                        sVar3.a();
                    }
                } else if (p2 == 6) {
                    ScrollFragmentTabHost.this.setScrollShadow(true);
                } else if (p2 == 7) {
                    ScrollFragmentTabHost.this.setScrollShadow(true);
                } else if (p2 == 8) {
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                } else {
                    ScrollFragmentTabHost.this.x();
                    ScrollFragmentTabHost.this.setScrollShadow(false);
                }
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.A(i2));
            if (ScrollFragmentTabHost.this.A(i2) == 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        d.a.n0.r.d0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    d.a.n0.r.d0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                }
                if (ScrollFragmentTabHost.this.f16422g.f()) {
                    ScrollFragmentTabHost.this.f16422g.setShowHotTopicRedTip(false);
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
            if (ScrollFragmentTabHost.this.A(i2) == 1 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(ScrollFragmentTabHost.this.f16421f, null)) {
                ScrollFragmentTabHost.this.u(i2);
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.k.getCurrentItem() != i2) {
                    if (ScrollFragmentTabHost.this.A(i2) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.A(i2) == 7) {
                    TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.A(i2) == 8) {
                    TiebaStatic.log(new StatisticItem("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.A(i2));
                if (ScrollFragmentTabHost.this.A(i2) == 5) {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", ScrollFragmentTabHost.this.I() ? 1 : 0);
                    statisticItem.eventStat();
                    ScrollFragmentTabHost.this.w = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            d.a.n0.r.d0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        d.a.n0.r.d0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.f16422g.f()) {
                        ScrollFragmentTabHost.this.f16422g.setShowHotTopicRedTip(false);
                    }
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
            if (!z || ScrollFragmentTabHost.this.J == null) {
                return;
            }
            ScrollFragmentTabHost.this.J.I();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NestedScrollHeader.f {
        public d() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            if (ScrollFragmentTabHost.this.J != null) {
                ScrollFragmentTabHost.this.J.I();
                ScrollFragmentTabHost.this.J = null;
            }
            if (ScrollFragmentTabHost.this.f16421f != null) {
                UrlManager.getInstance().dealOneLink(ScrollFragmentTabHost.this.f16421f, new String[]{str});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements NestedScrollHeader.f {
        public e() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            if (ScrollFragmentTabHost.this.J != null) {
                ScrollFragmentTabHost.this.J.I();
                ScrollFragmentTabHost.this.J = null;
            }
            if (ScrollFragmentTabHost.this.f16421f != null) {
                UrlManager.getInstance().dealOneLink(ScrollFragmentTabHost.this.f16421f, new String[]{str});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements GestureDetector.OnGestureListener {
        public f() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > 40.0f) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(ScrollFragmentTabHost.this.f16421f, null);
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Animation.AnimationListener {
        public g() {
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
    public class h implements d.a.o0.b1.d.e {
        public h() {
        }

        @Override // d.a.o0.b1.d.e
        public void a(int i2) {
            ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.r.o(i2), false);
            ScrollFragmentTabHost.this.r.z(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements d.a.o0.b1.d.d {
        public i() {
        }

        @Override // d.a.o0.b1.d.d
        public void a(int i2) {
            ScrollFragmentTabHost.this.M.b(i2, ScrollFragmentTabHost.this.N);
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
            if (ScrollFragmentTabHost.this.k == null) {
                return;
            }
            if (FullBrowseHelper.checkIsFullBrowseMode()) {
                ScrollFragmentTabHost.this.k.setScrollable(false, ScrollFragmentTabHost.this.x);
            } else {
                ScrollFragmentTabHost.this.k.setScrollable(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
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
                ScrollFragmentTabHost.this.U();
            } else {
                ScrollFragmentTabHost.this.x();
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
            if (customResponsedMessage == null || ScrollFragmentTabHost.this.J == null) {
                return;
            }
            ScrollFragmentTabHost.this.J.I();
            ScrollFragmentTabHost.this.J = null;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f16438e;

            public a(m mVar, ImageView imageView) {
                this.f16438e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16438e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f16439e;

            public b(m mVar, ImageView imageView) {
                this.f16439e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16439e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.f16422g.c(0);
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
                if (ScrollFragmentTabHost.this.f16422g != null) {
                    ScrollFragmentTabHost.this.K.l(ScrollFragmentTabHost.this.f16422g.getBackgroundAlpha());
                    ScrollFragmentTabHost.this.K.k(TbadkCoreApplication.getInst().getSkinType());
                }
                ScrollFragmentTabHost.this.K.n(ScrollFragmentTabHost.this.H);
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
    public class n extends CustomMessageListener {
        public n(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || ScrollFragmentTabHost.this.L == d.a.n0.b.d.h()) {
                return;
            }
            ScrollFragmentTabHost.this.f16422g.j();
            if (d.a.n0.b.d.h() && ScrollFragmentTabHost.this.v) {
                ScrollFragmentTabHost.this.w();
                ScrollFragmentTabHost.this.S();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16442e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f16443f;

            public a(o oVar, TextView textView, int i2) {
                this.f16442e = textView;
                this.f16443f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16442e.setMaxWidth(this.f16443f + ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16444e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f16445f;

            public b(o oVar, TextView textView, int i2) {
                this.f16444e = textView;
                this.f16445f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f16444e.setMaxWidth(this.f16445f - ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Animator.AnimatorListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16446e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f16447f;

            public c(o oVar, TextView textView, String str) {
                this.f16446e = textView;
                this.f16447f = str;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.f16446e.setText(this.f16447f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public o(int i2) {
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
            LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.f16422g.c(0);
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
                    d.a.n0.r.d0.b.j().v("key_home_concern_all_status", 1);
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
                d.a.n0.r.d0.b.j().v("key_home_concern_all_status", 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public p(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ScrollFragmentTabHost.this.r == null || customResponsedMessage == null || customResponsedMessage.getData() == null || ScrollFragmentTabHost.this.f16422g == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            ScrollFragmentTabHost.this.r.Q();
            ScrollFragmentTabHost.this.r.O();
            ScrollFragmentTabHost.this.k.setAdapter(ScrollFragmentTabHost.this.r);
            ScrollFragmentTabHost.this.f16422g.setHotTopicTabIndex(ScrollFragmentTabHost.this.r.n());
            ScrollFragmentTabHost.this.f16422g.j();
        }
    }

    /* loaded from: classes4.dex */
    public class q implements CustomMessageTask.CustomRunnable<p.b> {
        public q() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<p.b> customMessage) {
            if (ScrollFragmentTabHost.this.f16421f != null && !ScrollFragmentTabHost.this.f16421f.getPageActivity().isFinishing() && ScrollFragmentTabHost.this.H != null && ScrollFragmentTabHost.this.I != null) {
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.f16422g.getTaskView() : ScrollFragmentTabHost.this.I.getTaskView();
                if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof p.b)) {
                    p.b data = customMessage.getData();
                    int intValue = data.f52529c.intValue() > 0 ? data.f52529c.intValue() * 1000 : 5000;
                    String str = data.f52533g;
                    if (TextUtils.isEmpty(str)) {
                        str = ScrollFragmentTabHost.this.f16421f.getString(R.string.task_float_tip_toast);
                    }
                    String fixedText = UtilHelper.getFixedText(str, 20);
                    if (ScrollFragmentTabHost.this.J != null) {
                        ScrollFragmentTabHost.this.J.I();
                    }
                    ScrollFragmentTabHost scrollFragmentTabHost = ScrollFragmentTabHost.this;
                    scrollFragmentTabHost.J = new d.a.o0.d0.e(scrollFragmentTabHost.f16421f, taskView);
                    ScrollFragmentTabHost.this.J.O(48);
                    ScrollFragmentTabHost.this.J.h0(true);
                    ScrollFragmentTabHost.this.J.L(4);
                    ScrollFragmentTabHost.this.J.N(intValue);
                    ScrollFragmentTabHost.this.J.U(true);
                    ScrollFragmentTabHost.this.J.j0(0);
                    ScrollFragmentTabHost.this.J.l0(fixedText);
                    return new CustomResponsedMessage<>(2921409, Boolean.TRUE);
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class r implements CustomMessageTask.CustomRunnable<Boolean> {
        public r() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.H == null) {
                return null;
            }
            ScrollFragmentTabHost.this.x();
            boolean z = false;
            if (customMessage.getData().booleanValue()) {
                z = ScrollFragmentTabHost.this.H.f();
            } else if (ScrollFragmentTabHost.this.H.d() && ScrollFragmentTabHost.this.v) {
                z = true;
                ScrollFragmentTabHost.this.H.f();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, Boolean.TRUE));
            return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class s {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    /* loaded from: classes4.dex */
    public interface t {
        void a(int i2);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.w = false;
        this.y = new j(2921563);
        this.z = new k(2921400);
        this.A = new l(2921415);
        this.B = new m(2921501);
        this.C = new n(2001371);
        this.D = new o(2921502);
        this.E = new p(2921509);
        this.F = new CustomMessageTask(2921409, new q());
        this.G = new CustomMessageTask(2921405, new r());
        this.M = new d.a.o0.b1.d.f.b();
        this.N = new h();
        this.O = new i();
        C();
    }

    public int A(int i2) {
        return this.r.p(i2);
    }

    public boolean B() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        return newScrollFragmentAdapter != null && newScrollFragmentAdapter.getCount() > 0;
    }

    public final void C() {
        this.f16420e = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.H = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.I = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.f16422g = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.f16423h = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.f16424i = (NoNetworkView) findViewById(R.id.view_no_network);
        this.j = (FrameLayout) findViewById(R.id.home_pager_container);
        this.k = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.l = findViewById(R.id.divider_line);
        this.m = findViewById(R.id.divider_shadow);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.n = tBSpecificationBtn;
        tBSpecificationBtn.setVisibility(8);
        this.K = new d.a.o0.b1.c.b(this.f16420e);
        this.L = d.a.n0.b.d.h();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.H.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) this.j.getLayoutParams())).topMargin = 0;
        this.f16422g.setOnPageChangeListener(new a());
        this.f16422g.setOnTabItemClickListener(new b());
        this.H.setOnHeaderStickyListener(new c());
        this.I.setEntranceJumpListener(new d());
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.I.setVisibility(8);
            this.f16422g.setMissionEntranceVisibility(true);
            this.f16422g.setEntranceJumpListener(new e());
            return;
        }
        this.I.setVisibility(0);
        this.f16422g.setMissionEntranceVisibility(false);
    }

    public void D(TbPageContext tbPageContext, NoNetworkView.b bVar) {
        this.f16421f = tbPageContext;
        this.f16424i.a(bVar);
        MessageManager.getInstance().registerListener(this.z);
        MessageManager.getInstance().registerListener(this.A);
        MessageManager.getInstance().registerListener(this.D);
        MessageManager.getInstance().registerListener(this.B);
        MessageManager.getInstance().registerListener(this.C);
        MessageManager.getInstance().registerListener(this.E);
        MessageManager.getInstance().registerListener(this.y);
        this.F.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.F);
    }

    @RequiresApi(api = 3)
    public void E(FragmentManager fragmentManager, d.a.o0.b1.d.b bVar, ConcernPageView.l lVar) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.f16420e, fragmentManager, bVar, lVar);
        this.r = newScrollFragmentAdapter;
        newScrollFragmentAdapter.H(this);
        this.k.setOffscreenPageLimit(2);
        this.k.setAdapter(this.r);
        int m2 = this.r.m();
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.r;
        if (HomePageStatic.f16264a) {
            m2 = 0;
        }
        this.k.setCurrentItem(newScrollFragmentAdapter2.o(m2));
        this.f16422g.setViewPager(this.k);
        this.f16422g.setConcernTabIndex(this.r.o(0));
        if (this.r.n() != -1) {
            this.f16422g.setHotTopicTabIndex(this.r.n());
            this.f16422g.setShowHotTopicRedTip(H());
        }
        this.x = new GestureDetector(this.f16420e, new f());
        if (FullBrowseHelper.checkIsFullBrowseMode()) {
            this.k.setScrollable(false, this.x);
        } else {
            this.k.setScrollable(true);
        }
    }

    public final boolean F() {
        return this.m.getVisibility() == 0;
    }

    public boolean G() {
        if (this.f16422g == null || !this.r.u()) {
            return false;
        }
        return this.f16422g.e();
    }

    public final boolean H() {
        long currentTimeMillis = System.currentTimeMillis();
        if (TbadkCoreApplication.isLogin()) {
            return !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && currentTimeMillis - d.a.n0.r.d0.b.j().l(TbadkCoreApplication.getCurrentAccount(), 0L) >= 86400000;
        }
        return currentTimeMillis - d.a.n0.r.d0.b.j().l("unlogin_hot_top_timestamp", 0L) >= 86400000;
    }

    public boolean I() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        if (this.f16422g == null || (newScrollFragmentAdapter = this.r) == null || !newScrollFragmentAdapter.v()) {
            return false;
        }
        return this.f16422g.f();
    }

    public void J() {
        HomeTabBarView homeTabBarView;
        StickyAppBarLayout stickyAppBarLayout = this.H;
        if (stickyAppBarLayout == null || stickyAppBarLayout.d() || (homeTabBarView = this.f16422g) == null || homeTabBarView.getTaskView() == null || this.f16422g.getTaskView().getVisibility() == 0) {
            return;
        }
        this.f16422g.i();
    }

    public void K() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter == null || HomePageStatic.f16264a) {
            return;
        }
        this.k.setAdapter(newScrollFragmentAdapter);
        this.f16422g.j();
        this.M.a(this.N);
    }

    public void L(boolean z) {
    }

    public void M(int i2) {
        PluginErrorTipView pluginErrorTipView;
        NoNetworkView noNetworkView;
        d.a.n0.r.u.c.d(this.H).n(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        this.I.p();
        this.f16422g.k();
        TbPageContext tbPageContext = this.f16421f;
        if (tbPageContext != null && (noNetworkView = this.f16424i) != null) {
            noNetworkView.c(tbPageContext, i2);
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.A(i2);
        }
        TbPageContext tbPageContext2 = this.f16421f;
        if (tbPageContext2 != null && (pluginErrorTipView = this.f16423h) != null) {
            pluginErrorTipView.e(tbPageContext2, i2);
        }
        d.a.o0.b1.c.b bVar = this.K;
        if (bVar != null) {
            bVar.k(i2);
        }
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0203);
        SkinManager.setBackgroundResource(this.m, R.drawable.personalize_tab_shadow);
    }

    public void N() {
        MessageManager.getInstance().unRegisterTask(2921409);
        d.a.o0.d0.e eVar = this.J;
        if (eVar != null) {
            eVar.I();
            this.J = null;
        }
        w();
        MessageManager.getInstance().unRegisterListener(this.C);
    }

    public void O() {
        HomeTabBarView homeTabBarView = this.f16422g;
        if (homeTabBarView != null) {
            homeTabBarView.l();
        }
    }

    public void P() {
        this.r.q(this.O);
    }

    public void Q() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.B();
        }
    }

    public void R(s sVar) {
        List<s> list = this.u;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.u.remove(sVar);
    }

    public void S() {
        if (TbadkCoreApplication.isLogin()) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int o2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.o(0) : 0;
            if (this.t == null) {
                d.a.o0.d0.e eVar = new d.a.o0.d0.e(this.f16421f, this.f16422g.c(o2));
                this.t = eVar;
                eVar.g0(R.drawable.bg_tip_blue_up_left);
                this.t.O(16);
                this.t.U(true);
                this.t.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.t.h0(true);
                this.t.N(4000);
            }
            this.t.m0(this.f16420e.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void T() {
        if (d.a.n0.r.d0.b.j().k("key_concern_tab_tips_switch", 0) == 0) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        int o2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.o(0) : 0;
        if (this.t == null) {
            d.a.o0.d0.e eVar = new d.a.o0.d0.e(this.f16421f, this.f16422g.c(o2));
            this.t = eVar;
            eVar.g0(R.drawable.bg_tip_blue_up);
            this.t.O(32);
            this.t.U(true);
            this.t.h0(true);
            this.t.k0(d.a.c.e.p.l.g(this.f16420e, R.dimen.ds16));
            this.t.N(4000);
        }
        this.t.n0(this.f16420e.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
    }

    public void U() {
        if (this.o && !F()) {
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

    public void V() {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.K();
        }
    }

    public void W(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.M(dataRes, z);
        }
    }

    public void X(String str, int i2, int i3) {
        if (this.k == null) {
            return;
        }
        this.r.N(str, i2, i3);
    }

    public void Y(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.P(dataRes, z, z2);
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
            return newScrollFragmentAdapter.l();
        }
        return null;
    }

    public int getCurrentTabType() {
        return this.r.p(this.k.getCurrentItem());
    }

    public FrameLayout getFrameLayout() {
        return this.j;
    }

    public int getVideoRecommendIndex() {
        if (this.k.getAdapter() != null) {
            int count = this.k.getAdapter().getCount();
            for (int i2 = 0; i2 < count; i2++) {
                if (this.r.p(i2) == 8) {
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
            this.G.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.G);
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
        this.f16422g.setTabItemClicked(z);
        this.r.I(i2);
        this.k.setCurrentItem(i2);
    }

    public void setFakeClickCurrentTab(int i2) {
        setCurrentTab(this.r.o(i2), true);
    }

    public void setOnTabSelectedListener(t tVar) {
        this.s = tVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.f16422g.setPageUniqueId(bdUniqueId);
        this.z.setTag(bdUniqueId);
        this.A.setTag(bdUniqueId);
        this.D.setTag(bdUniqueId);
        this.B.setTag(bdUniqueId);
        this.E.setTag(bdUniqueId);
        this.y.setTag(bdUniqueId);
    }

    public void setPrimary(boolean z) {
        this.v = z;
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.G(z);
        }
        NoNetworkView noNetworkView = this.f16424i;
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
        if (this.f16422g == null || !this.r.u()) {
            return;
        }
        this.f16422g.setShowConcernRedTip(z);
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
        if (newScrollFragmentAdapter != null) {
            newScrollFragmentAdapter.J(str);
        }
    }

    public final void u(int i2) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_type", z(i2));
        TiebaStaticHelper.addYYParam(statisticItem);
        TiebaStatic.log(statisticItem);
    }

    public void v(s sVar) {
        if (this.u == null) {
            this.u = new ArrayList();
        }
        this.u.add(sVar);
    }

    public void w() {
        d.a.o0.d0.e eVar = this.t;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void x() {
        if (this.o && F()) {
            if (this.q == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.q = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.q.setDuration(300L);
                this.q.setAnimationListener(new g());
            }
            this.m.startAnimation(this.q);
        }
    }

    public void y() {
        this.r.k();
    }

    public final int z(int i2) {
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

    public void setCurrentTab(int i2) {
        setCurrentTab(this.r.o(i2), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.r.r(str), false);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = false;
        this.y = new j(2921563);
        this.z = new k(2921400);
        this.A = new l(2921415);
        this.B = new m(2921501);
        this.C = new n(2001371);
        this.D = new o(2921502);
        this.E = new p(2921509);
        this.F = new CustomMessageTask(2921409, new q());
        this.G = new CustomMessageTask(2921405, new r());
        this.M = new d.a.o0.b1.d.f.b();
        this.N = new h();
        this.O = new i();
        C();
    }
}
