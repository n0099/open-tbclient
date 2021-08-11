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
import c.a.e.e.p.l;
import c.a.e.k.e.n;
import c.a.l.q;
import c.a.o0.s.u.c;
import c.a.p0.f1.c.f.d;
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
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class RecommendBarLayout extends LinearLayout implements q, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_RECOMMEND_BAR_CONCERN = "c13644";
    public static final String KEY_RECOMMEND_BAR_FORUM = "c13988";
    public static final String KEY_RECOMMEND_BAR_FORUM_SHOW = "c13643";
    public static final String KEY_RECOMMEND_BAR_MORE = "c13645";
    public static final String KEY_RECOMMEND_BAR_SHOW = "c13907";
    public static final String KEY_RECOMMEND_TAB_SHOW = "c14004";
    public static final int MAX_RECOMMEND_BAR_COUNT = 3;
    public static final int MAX_RECOMMEND_TAB_COUNT = 6;
    public static final byte RECOMMEND_SOURCE_CONCERN = 4;
    public static final byte RECOMMEND_SOURCE_PERSONALIZE = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f51801e;

    /* renamed from: f  reason: collision with root package name */
    public int f51802f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f51803g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51804h;

    /* renamed from: i  reason: collision with root package name */
    public ViewPager f51805i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f51806j;
    public BdUniqueId k;
    public RecommendBarPageAdapter l;
    public TbPageContext<?> m;
    public byte n;
    public CustomMessageListener o;

    /* loaded from: classes7.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendBarLayout f51807e;

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
            this.f51807e = recommendBarLayout;
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
                n pagerModelByIndex = this.f51807e.l.getPagerModelByIndex(i2);
                if (pagerModelByIndex instanceof d) {
                    d dVar = (d) pagerModelByIndex;
                    StatisticItem param = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.f51807e.n).param("obj_param1", i2);
                    if (!StringUtils.isNull(dVar.f17038e)) {
                        param = param.param("obj_name", dVar.f17038e);
                    }
                    TiebaStatic.log(param);
                    StatisticItem param2 = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_FORUM_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.b()).param("obj_locate", (int) this.f51807e.n);
                    if (!StringUtils.isNull(dVar.f17038e)) {
                        param2 = param2.param("obj_name", dVar.f17038e);
                    }
                    TiebaStatic.log(param2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendBarLayout f51808a;

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
            this.f51808a = recommendBarLayout;
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
                this.f51808a.l.updateFollowState(longValue, customResponsedMessage.getCmd() == 2001335);
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
        this.f51802f = 3;
        this.o = new b(this, 0);
        this.k = bdUniqueId;
        this.f51801e = context;
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
            this.f51803g = (FrameLayout) findViewById(R.id.recommend_bar_top);
            this.f51804h = (TextView) findViewById(R.id.recommend_bar_title);
            this.f51805i = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
            this.f51806j = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
            this.f51805i.setOffscreenPageLimit(2);
            RecommendBarPageAdapter recommendBarPageAdapter = new RecommendBarPageAdapter(this.m, this.n);
            this.l = recommendBarPageAdapter;
            this.f51805i.setAdapter(recommendBarPageAdapter);
            this.f51805i.addOnPageChangeListener(new a(this));
            this.f51803g.setOnClickListener(this);
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

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (i2 != this.f51802f) {
                c d2 = c.d(this.f51804h);
                d2.y(R.string.F_X02);
                d2.t(R.color.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f51806j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.l.onSkinTypeChanged(i2);
            }
            this.f51802f = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view.getId() == R.id.recommend_bar_top) {
            n pagerModelByIndex = this.l.getPagerModelByIndex(this.f51805i.getCurrentItem());
            if (pagerModelByIndex instanceof d) {
                d dVar = (d) pagerModelByIndex;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.f51801e, dVar.f17040g)));
                StatisticItem param = new StatisticItem(KEY_RECOMMEND_BAR_MORE).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.n);
                if (!StringUtils.isNull(dVar.f17038e)) {
                    param = param.param("obj_name", dVar.f17038e);
                }
                TiebaStatic.log(param);
            }
        }
    }

    public void setData(c.a.p0.f1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar != null && !ListUtils.isEmpty(cVar.g())) {
                setVisibility(0);
                ((LinearLayout.LayoutParams) this.f51805i.getLayoutParams()).height = l.g(this.m.getPageActivity(), cVar.i() ? R.dimen.tbds660 : R.dimen.tbds728);
                this.f51805i.setCurrentItem(0, true);
                this.l.setRecommendDatas(cVar);
                TiebaStatic.log(new StatisticItem(KEY_RECOMMEND_BAR_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.n));
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
