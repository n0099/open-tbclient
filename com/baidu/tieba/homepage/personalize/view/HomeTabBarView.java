package com.baidu.tieba.homepage.personalize.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.h17;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.in;
import com.baidu.tieba.l55;
import com.baidu.tieba.q57;
import com.baidu.tieba.rn8;
import com.baidu.tieba.sg;
import com.baidu.tieba.tg;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TbImageView b;
    public PagerSlidingTabStrip c;
    public LinearLayout d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public int j;
    public NewHotTipLabelView k;
    public e l;
    public View m;
    public View n;
    public float o;
    public float p;
    public Runnable q;

    /* loaded from: classes4.dex */
    public interface e {
        void a(String str);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomeTabBarView a;

        public a(HomeTabBarView homeTabBarView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeTabBarView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homeTabBarView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p() && this.a.m != null && this.a.j != -1) {
                HomeTabBarView homeTabBarView = this.a;
                homeTabBarView.n = homeTabBarView.k(homeTabBarView, homeTabBarView.m, this.a.j);
                HomeTabBarView homeTabBarView2 = this.a;
                homeTabBarView2.l(homeTabBarView2.k, this.a.n);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends sg<in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HomeTabBarView b;

        public b(HomeTabBarView homeTabBarView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeTabBarView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homeTabBarView;
            this.a = str;
        }

        @Override // com.baidu.tieba.sg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.baidu.tieba.sg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inVar, str, i) == null) {
                super.onLoaded((b) inVar, str, i);
                if (inVar != null && inVar.p() != null && !inVar.p().isRecycled()) {
                    this.b.b.setImageBitmap(inVar.p());
                    this.b.b.setTag(R.id.obfuscated_res_0x7f090ddf, this.a);
                    return;
                }
                this.b.b.setImageResource(R.drawable.icon_use_gold_n);
                this.b.b.setTag(R.id.obfuscated_res_0x7f090ddf, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomeTabBarView a;

        public c(HomeTabBarView homeTabBarView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeTabBarView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homeTabBarView;
        }

        @Override // java.lang.Runnable
        public void run() {
            View z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (z = this.a.c.z(this.a.c.getCurrentTabIndex())) != null && z.getRight() > this.a.c.getRight()) {
                this.a.c.scrollTo(this.a.c.getScrollX() + z.getWidth(), 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ HomeTabBarView b;

        public d(HomeTabBarView homeTabBarView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeTabBarView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homeTabBarView;
            this.a = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.setVisibility(8);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeTabBarView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.h = R.color.CAM_X0105;
        this.j = -1;
        this.q = new a(this);
        o(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (view2 == this.a) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
                return;
            }
            TbImageView tbImageView = this.b;
            if (view2 == tbImageView) {
                Object tag = tbImageView.getTag(R.id.obfuscated_res_0x7f090ddf);
                if (!(tag instanceof String)) {
                    return;
                }
                String str = (String) tag;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                r();
                e eVar = this.l;
                if (eVar != null) {
                    eVar.a(str);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.h = R.color.CAM_X0105;
        this.j = -1;
        this.q = new a(this);
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.h = R.color.CAM_X0105;
        this.j = -1;
        this.q = new a(this);
        o(context);
    }

    public View k(ViewGroup viewGroup, View view2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, viewGroup, view2, i)) == null) {
            if (viewGroup != null && view2 != null && i != -1) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(yi.g(getContext(), R.dimen.tbds18), yi.g(getContext(), R.dimen.tbds18));
                layoutParams.topMargin = yi.g(getContext(), R.dimen.tbds20);
                layoutParams.leftMargin = yi.g(getContext(), R.dimen.tbds11);
                View view3 = new View(getContext());
                view3.setLayoutParams(layoutParams);
                SkinManager.setBackgroundResource(view3, R.drawable.icon_news_red_dot);
                view3.setTag(R.id.obfuscated_res_0x7f090e2d, Integer.valueOf(i));
                view3.setTranslationX(this.o);
                view3.setTranslationY(this.p);
                viewGroup.addView(view3);
                return view3;
            }
            return null;
        }
        return (View) invokeLLI.objValue;
    }

    public View m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return this.c.z(i);
        }
        return (View) invokeI.objValue;
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.c.setConcernTabIndex(i);
        }
    }

    public void setEntranceJumpListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void setMissionEntranceVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.b.setVisibility(0);
                this.e = this.g;
                x(true);
                y();
                return;
            }
            this.e = this.f;
            this.b.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onPageChangeListener) == null) {
            this.c.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            this.c.setOnTabItemClickListener(cVar);
        }
    }

    public void setRedDotTip(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            this.n = view2;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && (pagerSlidingTabStrip = this.c) != null) {
            pagerSlidingTabStrip.setShowConcernRedTip(z);
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.c.setTabItemClicked(z);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, viewPager) == null) {
            this.c.setViewPager(viewPager);
        }
    }

    public void j(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.c.s(z, z2);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5003);
            super.onMeasure(i, i2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5004);
        }
    }

    public float getBackgroundAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return invokeV.floatValue;
    }

    public View getRedDotTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return (View) invokeV.objValue;
    }

    public View getTabStrip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void n() {
        NewHotTipLabelView newHotTipLabelView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (newHotTipLabelView = this.k) != null) {
            newHotTipLabelView.setVisibility(8);
            h17.c("key_new_hot_tip_dismiss_time", System.currentTimeMillis());
            this.k.c();
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            NewHotTipLabelView newHotTipLabelView = this.k;
            if (newHotTipLabelView == null || newHotTipLabelView.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.c;
            if (pagerSlidingTabStrip != null) {
                return pagerSlidingTabStrip.C();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c.D();
        }
    }

    public void setTabStripCenterInParent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.addRule(13);
            layoutParams.removeRule(9);
            this.c.setLayoutParams(layoutParams);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.c.E();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ah.a().removeCallbacks(this.q);
        }
    }

    public void i(float f, float f2, View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), view2, Integer.valueOf(i)}) == null) {
            if (this.k == null) {
                this.k = new NewHotTipLabelView(getContext());
            }
            this.o = f;
            this.p = f2;
            this.k.setView(this, f, f2);
            this.m = view2;
            this.j = i;
            ah.a().postDelayed(this.q, 5000L);
        }
    }

    public final void l(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, view3) == null) {
            view3.setAlpha(0.0f);
            view3.setVisibility(0);
            view3.animate().alpha(1.0f).setDuration(800L).setListener(null);
            view2.animate().alpha(0.0f).setDuration(800L).setListener(new d(this, view2));
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4008);
            this.f = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
            this.g = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
            this.e = this.f;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d039f, (ViewGroup) this, true);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090dd4);
            this.a = imageView;
            imageView.setClickable(false);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f090dd6);
            this.c = pagerSlidingTabStrip;
            pagerSlidingTabStrip.A(yi.g(context, R.dimen.T_X06), yi.g(context, R.dimen.T_X04), yi.g(context, R.dimen.tbds10), true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.gravity = 1;
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
            this.c.setExpandedTabLayoutParams(layoutParams);
            this.c.setHorizontalFadingEdgeEnabled(true);
            this.c.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds70));
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090dd5);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090dd3);
            this.b = tbImageView;
            tbImageView.setClickable(false);
            this.a.setOnClickListener(this);
            setOnClickListener(this);
            z(0.0f);
            u();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4009);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5011);
            super.onLayout(z, i, i2, i3, i4);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5012);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (TbadkApplication.getInst().isUseLuckyHeader()) {
                this.a.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.a.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a44, SkinManager.getColor(this.h), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
        }
    }

    public final void t(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048604, this, f) == null) {
            l55 f2 = q57.f(TbadkApplication.getInst().getHomeBarShowTabName());
            if (f2 != null) {
                setBackgroundColor(rn8.a(rn8.f(q57.d(f2)), f));
            } else {
                SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void x(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048608, this, z) == null) && (layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams()) != null) {
            if (z) {
                int i = layoutParams.rightMargin;
                int i2 = this.e;
                if (i != i2) {
                    layoutParams.rightMargin = i2;
                    this.c.setLayoutParams(layoutParams);
                    this.c.post(new c(this));
                    return;
                }
                return;
            }
            int i3 = layoutParams.rightMargin;
            int i4 = this.e;
            if (i3 != i4) {
                layoutParams.rightMargin = i4;
                this.c.setLayoutParams(layoutParams);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
            String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
            if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
                tg.h().m(missionEntranceIcon, 10, new b(this, missionEntranceUrl), null);
                return;
            }
            this.b.setTag(R.id.obfuscated_res_0x7f090ddf, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.b.setImageResource(R.drawable.icon_use_gold_n);
        }
    }

    public void z(float f) {
        int i;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048610, this, f) == null) && f <= 1.0f && f >= 0.0f) {
            this.i = f;
            if (TbadkApplication.getInst().isUseLuckyHeader()) {
                t(f);
            } else {
                SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f, TbadkCoreApplication.getInst().getSkinType());
            }
            if (this.a != null && (linearLayout = this.d) != null && this.c != null && linearLayout.getAlpha() != f) {
                this.d.setAlpha(f);
                if (i == 0) {
                    this.a.setClickable(true);
                    TbImageView tbImageView = this.b;
                    if (tbImageView != null) {
                        tbImageView.setClickable(true);
                    }
                    x(true);
                    return;
                }
                this.a.setClickable(false);
                TbImageView tbImageView2 = this.b;
                if (tbImageView2 != null) {
                    tbImageView2.setClickable(false);
                }
                x(false);
            }
        }
    }
}
