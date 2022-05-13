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
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.co;
import com.repackage.fg;
import com.repackage.gg;
import com.repackage.mi;
/* loaded from: classes3.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ImageView b;
    public TbImageView c;
    public PagerSlidingTabStrip d;
    public LinearLayout e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public NestedScrollHeader.f k;

    /* loaded from: classes3.dex */
    public class a extends fg<co> {
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

        @Override // com.repackage.fg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.repackage.fg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        public void onLoaded(co coVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coVar, str, i) == null) {
                super.onLoaded((a) coVar, str, i);
                if (coVar == null || coVar.p() == null || coVar.p().isRecycled()) {
                    this.b.c.setImageResource(R.drawable.icon_use_gold_n);
                    this.b.c.setTag(R.id.obfuscated_res_0x7f090d9c, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                this.b.c.setImageBitmap(coVar.p());
                this.b.c.setTag(R.id.obfuscated_res_0x7f090d9c, this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            View y;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (y = this.a.d.y(this.a.d.getCurrentTabIndex())) == null || y.getRight() <= this.a.d.getRight()) {
                return;
            }
            this.a.d.scrollTo(this.a.d.getScrollX() + y.getWidth(), 0);
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
        this.a = 3;
        this.f = 0;
        this.i = R.color.CAM_X0105;
        d(context);
    }

    public View c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.d.y(i) : (View) invokeI.objValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4008);
            this.g = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
            this.h = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
            this.f = this.g;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0399, (ViewGroup) this, true);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090d7b);
            this.b = imageView;
            imageView.setClickable(false);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f090d7d);
            this.d = pagerSlidingTabStrip;
            pagerSlidingTabStrip.z(mi.f(context, R.dimen.T_X06), mi.f(context, R.dimen.T_X04), mi.f(context, R.dimen.tbds10), true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.gravity = 1;
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
            this.d.setExpandedTabLayoutParams(layoutParams);
            this.d.setHorizontalFadingEdgeEnabled(true);
            this.d.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds70));
            this.e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090d7c);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090d7a);
            this.c = tbImageView;
            tbImageView.setClickable(false);
            this.b.setOnClickListener(this);
            setOnClickListener(this);
            n(0.0f);
            j();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4009);
        }
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.c.setOnClickListener(this);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.d;
            if (pagerSlidingTabStrip != null) {
                return pagerSlidingTabStrip.A();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public float getBackgroundAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : invokeV.floatValue;
    }

    public ImageView getTaskView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (ImageView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d.B();
        }
    }

    public void j() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, this.j, skinType);
        this.b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e3, SkinManager.getColor(this.i), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.d.C();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e3, SkinManager.getColor(this.i), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public final void l(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            int i = layoutParams.rightMargin;
            int i2 = this.f;
            if (i != i2) {
                layoutParams.rightMargin = i2;
                this.d.setLayoutParams(layoutParams);
                this.d.post(new b(this));
                return;
            }
            return;
        }
        int i3 = layoutParams.rightMargin;
        int i4 = this.f;
        if (i3 != i4) {
            layoutParams.rightMargin = i4;
            this.d.setLayoutParams(layoutParams);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
            String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
            if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
                gg.h().m(missionEntranceIcon, 10, new a(this, missionEntranceUrl), null);
                return;
            }
            this.c.setTag(R.id.obfuscated_res_0x7f090d9c, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.c.setImageResource(R.drawable.icon_use_gold_n);
        }
    }

    public void n(float f) {
        int i;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f) == null) || f > 1.0f || f < 0.0f) {
            return;
        }
        this.j = f;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f, this.a);
        if (this.b == null || (linearLayout = this.e) == null || this.d == null || linearLayout.getAlpha() == f) {
            return;
        }
        this.e.setAlpha(f);
        if (i == 0) {
            this.b.setClickable(true);
            TbImageView tbImageView = this.c;
            if (tbImageView != null) {
                tbImageView.setClickable(true);
            }
            l(true);
            return;
        }
        this.b.setClickable(false);
        TbImageView tbImageView2 = this.c;
        if (tbImageView2 != null) {
            tbImageView2.setClickable(false);
        }
        l(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            if (view2 == this.b) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
                return;
            }
            TbImageView tbImageView = this.c;
            if (view2 == tbImageView) {
                Object tag = tbImageView.getTag(R.id.obfuscated_res_0x7f090d9c);
                if (tag instanceof String) {
                    String str = (String) tag;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    g();
                    NestedScrollHeader.f fVar = this.k;
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
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5011);
            super.onLayout(z, i, i2, i3, i4);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5012);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5003);
            super.onMeasure(i, i2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5004);
        }
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.d.setConcernTabIndex(i);
        }
    }

    public void setEntranceJumpListener(NestedScrollHeader.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.k = fVar;
        }
    }

    public void setMissionEntranceVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.c.setVisibility(0);
                this.f = this.h;
                l(true);
                m();
                return;
            }
            this.f = this.g;
            this.c.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onPageChangeListener) == null) {
            this.d.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            this.d.setOnTabItemClickListener(cVar);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
        }
    }

    public void setShowConcernRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (pagerSlidingTabStrip = this.d) == null) {
            return;
        }
        pagerSlidingTabStrip.setShowConcernRedTip(z);
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.d.setTabItemClicked(z);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, viewPager) == null) {
            this.d.setViewPager(viewPager);
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
        this.a = 3;
        this.f = 0;
        this.i = R.color.CAM_X0105;
        d(context);
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
        this.a = 3;
        this.f = 0;
        this.i = R.color.CAM_X0105;
        d(context);
    }
}
