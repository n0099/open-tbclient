package com.baidu.tieba.homepage.concern.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.adapter.RecommendBarPageAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.j.q;
import d.a.r0.r.u.c;
import d.a.s0.e1.c.f.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class RecommendBarLayout extends LinearLayout implements q, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f16494e;

    /* renamed from: f  reason: collision with root package name */
    public int f16495f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f16496g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16497h;

    /* renamed from: i  reason: collision with root package name */
    public ViewPager f16498i;
    public ImageView j;
    public BdUniqueId k;
    public RecommendBarPageAdapter l;
    public TbPageContext<?> m;
    public byte n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendBarLayout f16499e;

        public a(RecommendBarLayout recommendBarLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendBarLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16499e = recommendBarLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                n i3 = this.f16499e.l.i(i2);
                if (i3 instanceof d) {
                    d dVar = (d) i3;
                    StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.f16499e.n).param("obj_param1", i2);
                    if (!StringUtils.isNull(dVar.f58465e)) {
                        param = param.param("obj_name", dVar.f58465e);
                    }
                    TiebaStatic.log(param);
                    StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.b()).param("obj_locate", (int) this.f16499e.n);
                    if (!StringUtils.isNull(dVar.f58465e)) {
                        param2 = param2.param("obj_name", dVar.f58465e);
                    }
                    TiebaStatic.log(param2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendBarLayout f16500a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecommendBarLayout recommendBarLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendBarLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16500a = recommendBarLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (longValue == 0) {
                    return;
                }
                this.f16500a.l.l(longValue, customResponsedMessage.getCmd() == 2001335);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendBarLayout(TbPageContext<?> tbPageContext, Context context, BdUniqueId bdUniqueId, byte b2) {
        super(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, context, bdUniqueId, Byte.valueOf(b2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16495f = 3;
        this.o = new b(this, 0);
        this.k = bdUniqueId;
        this.f16494e = context;
        this.m = tbPageContext;
        this.n = b2;
        c();
        d();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.recommend_bar_card, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.f16496g = (FrameLayout) findViewById(R.id.recommend_bar_top);
            this.f16497h = (TextView) findViewById(R.id.recommend_bar_title);
            this.f16498i = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
            this.j = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
            this.f16498i.setOffscreenPageLimit(2);
            RecommendBarPageAdapter recommendBarPageAdapter = new RecommendBarPageAdapter(this.m, this.n);
            this.l = recommendBarPageAdapter;
            this.f16498i.setAdapter(recommendBarPageAdapter);
            this.f16498i.addOnPageChangeListener(new a(this));
            this.f16496g.setOnClickListener(this);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o.setTag(this.k);
            MessageManager.getInstance().registerListener(2001335, this.o);
            MessageManager.getInstance().registerListener(2001336, this.o);
        }
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (i2 != this.f16495f) {
                c d2 = c.d(this.f16497h);
                d2.y(R.string.F_X02);
                d2.t(R.color.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.l.j(i2);
            }
            this.f16495f = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view.getId() == R.id.recommend_bar_top) {
            n i2 = this.l.i(this.f16498i.getCurrentItem());
            if (i2 instanceof d) {
                d dVar = (d) i2;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.f16494e, dVar.f58467g)));
                StatisticItem param = new StatisticItem("c13645").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.n);
                if (!StringUtils.isNull(dVar.f58465e)) {
                    param = param.param("obj_name", dVar.f58465e);
                }
                TiebaStatic.log(param);
            }
        }
    }

    public void setData(d.a.s0.e1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar != null && !ListUtils.isEmpty(cVar.c())) {
                setVisibility(0);
                ((LinearLayout.LayoutParams) this.f16498i.getLayoutParams()).height = l.g(this.m.getPageActivity(), cVar.d() ? R.dimen.tbds660 : R.dimen.tbds728);
                this.f16498i.setCurrentItem(0, true);
                this.l.k(cVar);
                TiebaStatic.log(new StatisticItem("c13907").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.n));
                return;
            }
            setVisibility(8);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.k = bdUniqueId;
        }
    }
}
