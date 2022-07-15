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
import com.repackage.cu6;
import com.repackage.du6;
import com.repackage.hx;
import com.repackage.nn;
import com.repackage.pi;
import com.repackage.ur4;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class RecommendBarLayout extends LinearLayout implements hx, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public int b;
    public FrameLayout c;
    public TextView d;
    public ViewPager e;
    public ImageView f;
    public BdUniqueId g;
    public RecommendBarPageAdapter h;
    public TbPageContext<?> i;
    public byte j;
    public CustomMessageListener k;

    /* loaded from: classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendBarLayout a;

        public a(RecommendBarLayout recommendBarLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendBarLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendBarLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                nn b = this.a.h.b(i);
                if (b instanceof du6) {
                    du6 du6Var = (du6) b;
                    StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.a.j).param("obj_param1", i);
                    if (!StringUtils.isNull(du6Var.a)) {
                        param = param.param("obj_name", du6Var.a);
                    }
                    TiebaStatic.log(param);
                    StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", du6Var.a()).param("obj_locate", (int) this.a.j);
                    if (!StringUtils.isNull(du6Var.a)) {
                        param2 = param2.param("obj_name", du6Var.a);
                    }
                    TiebaStatic.log(param2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendBarLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecommendBarLayout recommendBarLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendBarLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendBarLayout;
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
                this.a.h.e(longValue, customResponsedMessage.getCmd() == 2001335);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.k = new b(this, 0);
        this.g = bdUniqueId;
        this.a = context;
        this.i = tbPageContext;
        this.j = b2;
        c();
        d();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d071e, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.c = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091a94);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091a92);
            this.e = (ViewPager) findViewById(R.id.obfuscated_res_0x7f091a95);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a90);
            this.e.setOffscreenPageLimit(2);
            RecommendBarPageAdapter recommendBarPageAdapter = new RecommendBarPageAdapter(this.i, this.j);
            this.h = recommendBarPageAdapter;
            this.e.setAdapter(recommendBarPageAdapter);
            this.e.addOnPageChangeListener(new a(this));
            this.c.setOnClickListener(this);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.setTag(this.g);
            MessageManager.getInstance().registerListener(2001335, this.k);
            MessageManager.getInstance().registerListener(2001336, this.k);
        }
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (i != this.b) {
                ur4 d = ur4.d(this.d);
                d.A(R.string.F_X02);
                d.v(R.color.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.h.c(i);
            }
            this.b = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f091a94) {
            nn b2 = this.h.b(this.e.getCurrentItem());
            if (b2 instanceof du6) {
                du6 du6Var = (du6) b2;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.a, du6Var.c)));
                StatisticItem param = new StatisticItem("c13645").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.j);
                if (!StringUtils.isNull(du6Var.a)) {
                    param = param.param("obj_name", du6Var.a);
                }
                TiebaStatic.log(param);
            }
        }
    }

    public void setData(cu6 cu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cu6Var) == null) {
            if (cu6Var != null && !ListUtils.isEmpty(cu6Var.d())) {
                setVisibility(0);
                ((LinearLayout.LayoutParams) this.e.getLayoutParams()).height = pi.f(this.i.getPageActivity(), cu6Var.g() ? R.dimen.tbds660 : R.dimen.tbds728);
                this.e.setCurrentItem(0, true);
                this.h.d(cu6Var);
                TiebaStatic.log(new StatisticItem("c13907").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.j));
                return;
            }
            setVisibility(8);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.g = bdUniqueId;
        }
    }
}
