package com.baidu.tieba.homepage.personalize.view;

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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tieba.an;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.kg;
import com.baidu.tieba.lg;
import com.baidu.tieba.m15;
import com.baidu.tieba.nj8;
import com.baidu.tieba.ri;
import com.baidu.tieba.t17;
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
    public NestedScrollHeader.f j;

    /* loaded from: classes4.dex */
    public class a extends kg<an> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HomeTabBarView b;

        public a(HomeTabBarView homeTabBarView, String str) {
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

        @Override // com.baidu.tieba.kg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.baidu.tieba.kg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg
        public void onLoaded(an anVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, anVar, str, i) == null) {
                super.onLoaded((a) anVar, str, i);
                if (anVar == null || anVar.p() == null || anVar.p().isRecycled()) {
                    this.b.b.setImageResource(R.drawable.icon_use_gold_n);
                    this.b.b.setTag(R.id.obfuscated_res_0x7f090d9f, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                this.b.b.setImageBitmap(anVar.p());
                this.b.b.setTag(R.id.obfuscated_res_0x7f090d9f, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomeTabBarView a;

        public b(HomeTabBarView homeTabBarView) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (z = this.a.c.z(this.a.c.getCurrentTabIndex())) == null || z.getRight() <= this.a.c.getRight()) {
                return;
            }
            this.a.c.scrollTo(this.a.c.getScrollX() + z.getWidth(), 0);
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
        e(context);
    }

    public void c(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.c.s(z, z2);
        }
    }

    public View d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.c.z(i) : (View) invokeI.objValue;
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4008);
            this.f = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
            this.g = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
            this.e = this.f;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0395, (ViewGroup) this, true);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090d7c);
            this.a = imageView;
            imageView.setClickable(false);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f090d7e);
            this.c = pagerSlidingTabStrip;
            pagerSlidingTabStrip.A(ri.f(context, R.dimen.T_X06), ri.f(context, R.dimen.T_X04), ri.f(context, R.dimen.tbds10), true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.gravity = 1;
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
            this.c.setExpandedTabLayoutParams(layoutParams);
            this.c.setHorizontalFadingEdgeEnabled(true);
            this.c.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds70));
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090d7d);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090d7b);
            this.b = tbImageView;
            tbImageView.setClickable(false);
            this.a.setOnClickListener(this);
            setOnClickListener(this);
            p(0.0f);
            l();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4009);
        }
    }

    public void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.b.setOnClickListener(this);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.c;
            if (pagerSlidingTabStrip != null) {
                return pagerSlidingTabStrip.C();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public float getBackgroundAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : invokeV.floatValue;
    }

    public ImageView getTaskView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (ImageView) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c.D();
        }
    }

    public final void k(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            m15 f2 = t17.f(TbadkApplication.getInst().getHomeBarShowTabName());
            if (f2 != null) {
                setBackgroundColor(nj8.a(nj8.f(t17.d(f2)), f));
            } else {
                SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (UbsABTestHelper.isHomeTabModifyABTestA()) {
                this.c.E();
                return;
            }
            if (TbadkApplication.getInst().isUseLuckyHeader()) {
                this.a.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a07, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
                k(this.i);
            } else {
                this.a.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a07, SkinManager.getColor(this.h), WebPManager.ResourceStateType.NORMAL_PRESS));
                SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, this.i, TbadkCoreApplication.getInst().getSkinType());
            }
            this.c.E();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (TbadkApplication.getInst().isUseLuckyHeader()) {
                this.a.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a07, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.a.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a07, SkinManager.getColor(this.h), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
        }
    }

    public final void n(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            int i = layoutParams.rightMargin;
            int i2 = this.e;
            if (i != i2) {
                layoutParams.rightMargin = i2;
                this.c.setLayoutParams(layoutParams);
                this.c.post(new b(this));
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

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
            String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
            if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
                lg.h().m(missionEntranceIcon, 10, new a(this, missionEntranceUrl), null);
                return;
            }
            this.b.setTag(R.id.obfuscated_res_0x7f090d9f, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.b.setImageResource(R.drawable.icon_use_gold_n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            if (view2 == this.a) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
                return;
            }
            TbImageView tbImageView = this.b;
            if (view2 == tbImageView) {
                Object tag = tbImageView.getTag(R.id.obfuscated_res_0x7f090d9f);
                if (tag instanceof String) {
                    String str = (String) tag;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    h();
                    NestedScrollHeader.f fVar = this.j;
                    if (fVar != null) {
                        fVar.a(str);
                    }
                }
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5011);
            super.onLayout(z, i, i2, i3, i4);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5012);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5003);
            super.onMeasure(i, i2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5004);
        }
    }

    public void p(float f) {
        int i;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048594, this, f) == null) || f > 1.0f || f < 0.0f) {
            return;
        }
        this.i = f;
        if (TbadkApplication.getInst().isUseLuckyHeader()) {
            k(f);
        } else {
            SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f, TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.a == null || (linearLayout = this.d) == null || this.c == null || linearLayout.getAlpha() == f) {
            return;
        }
        this.d.setAlpha(f);
        if (i == 0) {
            this.a.setClickable(true);
            TbImageView tbImageView = this.b;
            if (tbImageView != null) {
                tbImageView.setClickable(true);
            }
            n(true);
            return;
        }
        this.a.setClickable(false);
        TbImageView tbImageView2 = this.b;
        if (tbImageView2 != null) {
            tbImageView2.setClickable(false);
        }
        n(false);
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.c.setConcernTabIndex(i);
        }
    }

    public void setEntranceJumpListener(NestedScrollHeader.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.j = fVar;
        }
    }

    public void setMissionEntranceVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                this.b.setVisibility(0);
                this.e = this.g;
                n(true);
                o();
                return;
            }
            this.e = this.f;
            this.b.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onPageChangeListener) == null) {
            this.c.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            this.c.setOnTabItemClickListener(cVar);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
        }
    }

    public void setShowConcernRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (pagerSlidingTabStrip = this.c) == null) {
            return;
        }
        pagerSlidingTabStrip.setShowConcernRedTip(z);
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.c.setTabItemClicked(z);
        }
    }

    public void setTabStripCenterInParent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.addRule(13);
            layoutParams.removeRule(9);
            this.c.setLayoutParams(layoutParams);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, viewPager) == null) {
            this.c.setViewPager(viewPager);
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
        e(context);
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
        e(context);
    }
}
