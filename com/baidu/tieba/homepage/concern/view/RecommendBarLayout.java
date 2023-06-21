package com.baidu.tieba.homepage.concern.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
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
import com.baidu.tieba.b2a;
import com.baidu.tieba.bz9;
import com.baidu.tieba.homepage.concern.adapter.RecommendBarPageAdapter;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.o95;
import com.baidu.tieba.p75;
import com.baidu.tieba.qw7;
import com.baidu.tieba.qy;
import com.baidu.tieba.ug;
import com.baidu.tieba.wi;
import com.baidu.tieba.wn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class RecommendBarLayout extends LinearLayout implements qy, View.OnClickListener {
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

    /* loaded from: classes6.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendBarLayout a;

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
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                wn b = this.a.h.b(i);
                if (b instanceof qw7) {
                    qw7 qw7Var = (qw7) b;
                    StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.a.j).param("obj_param1", i);
                    if (!StringUtils.isNull(qw7Var.a)) {
                        param = param.param("obj_name", qw7Var.a);
                    }
                    TiebaStatic.log(param);
                    StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", qw7Var.a()).param("obj_locate", (int) this.a.j);
                    if (!StringUtils.isNull(qw7Var.a)) {
                        param2 = param2.param("obj_name", qw7Var.a);
                    }
                    TiebaStatic.log(param2);
                    TiebaStatic.log(new StatisticItem("c15344").param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.h != null) {
                boolean z = true;
                if (customResponsedMessage.getCmd() != 2001335 && customResponsedMessage.getCmd() != 2001336) {
                    if (customResponsedMessage.getCmd() == 2001437) {
                        if (!(customResponsedMessage.getData() instanceof b2a)) {
                            return;
                        }
                        b2a b2aVar = (b2a) customResponsedMessage.getData();
                        if (b2aVar.b) {
                            this.a.h.g(b2aVar.a, true);
                        }
                    } else if (customResponsedMessage.getCmd() != 2001266 || !(customResponsedMessage.getData() instanceof bz9)) {
                    } else {
                        bz9 bz9Var = (bz9) customResponsedMessage.getData();
                        if (bz9Var.n() == 0) {
                            this.a.h.g(ug.g(bz9Var.g(), 0L), false);
                        }
                    }
                } else if (!(customResponsedMessage.getData() instanceof Long)) {
                } else {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RecommendBarPageAdapter recommendBarPageAdapter = this.a.h;
                        if (customResponsedMessage.getCmd() != 2001335) {
                            z = false;
                        }
                        recommendBarPageAdapter.g(longValue, z);
                    }
                }
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
        d();
        f();
    }

    public final boolean e(@NonNull RecommendBarCardModel recommendBarCardModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recommendBarCardModel)) == null) {
            if (ListUtils.getCount(recommendBarCardModel.i()) == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.g = bdUniqueId;
        }
    }

    public final int c(@NonNull RecommendBarCardModel recommendBarCardModel) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, recommendBarCardModel)) == null) {
            if (recommendBarCardModel.l()) {
                i = R.dimen.tbds660;
            } else {
                i = R.dimen.tbds728;
            }
            List<wn> i2 = recommendBarCardModel.i();
            if (!ListUtils.isEmpty(i2) && (i2.get(0) instanceof qw7)) {
                int b2 = ((qw7) i2.get(0)).b();
                if (b2 != 1) {
                    if (b2 == 2) {
                        if (recommendBarCardModel.l()) {
                            return R.dimen.tbds450;
                        }
                        return R.dimen.tbds516;
                    }
                    return i;
                } else if (recommendBarCardModel.l()) {
                    return R.dimen.tbds242;
                } else {
                    return R.dimen.tbds310;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, view2) != null) || view2.getId() != R.id.obfuscated_res_0x7f091dc3) {
            return;
        }
        o95.p().F("key_home_show_card_not_click", 0);
        wn b2 = this.h.b(this.e.getCurrentItem());
        if (b2 instanceof qw7) {
            qw7 qw7Var = (qw7) b2;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.a, qw7Var.c)));
            StatisticItem param = new StatisticItem("c13645").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.j);
            if (!StringUtils.isNull(qw7Var.a)) {
                param = param.param("obj_name", qw7Var.a);
            }
            TiebaStatic.log(param);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0812, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.c = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091dc3);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091dc1);
            this.e = (ViewPager) findViewById(R.id.obfuscated_res_0x7f091dc4);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091dbf);
            this.e.setOffscreenPageLimit(2);
            RecommendBarPageAdapter recommendBarPageAdapter = new RecommendBarPageAdapter(this.i, this.j);
            this.h = recommendBarPageAdapter;
            this.e.setAdapter(recommendBarPageAdapter);
            this.e.addOnPageChangeListener(new a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.setTag(this.g);
            MessageManager.getInstance().registerListener(2001335, this.k);
            MessageManager.getInstance().registerListener(2001336, this.k);
            MessageManager.getInstance().registerListener(2001437, this.k);
            MessageManager.getInstance().registerListener(2001266, this.k);
        }
    }

    @Override // com.baidu.tieba.qy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (i != this.b) {
                p75 d = p75.d(this.d);
                d.D(R.string.F_X02);
                d.C(R.dimen.T_X07);
                d.x(R.color.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.h.c(i);
            }
            this.b = i;
        }
    }

    public void setData(RecommendBarCardModel recommendBarCardModel) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, recommendBarCardModel) == null) {
            if (recommendBarCardModel != null && !ListUtils.isEmpty(recommendBarCardModel.i())) {
                setVisibility(0);
                o95.p().F("key_home_show_card_not_click", o95.p().q("key_home_show_card_not_click", 0) + 1);
                ((LinearLayout.LayoutParams) this.e.getLayoutParams()).height = wi.g(this.i.getPageActivity(), c(recommendBarCardModel));
                this.e.setCurrentItem(0, true);
                Activity pageActivity = this.i.getPageActivity();
                if (e(recommendBarCardModel)) {
                    i = R.dimen.tbds0;
                } else {
                    i = R.dimen.tbds89;
                }
                this.e.setPadding(0, 0, wi.g(pageActivity, i), 0);
                this.h.f(recommendBarCardModel);
                if (recommendBarCardModel.k() && !TextUtils.isEmpty(recommendBarCardModel.h())) {
                    this.d.setText(recommendBarCardModel.h());
                    this.f.setVisibility(8);
                    this.c.setOnClickListener(null);
                } else {
                    this.d.setText(this.i.getString(R.string.obfuscated_res_0x7f0f11ab));
                    this.f.setVisibility(0);
                    this.c.setOnClickListener(this);
                }
                TiebaStatic.log(new StatisticItem("c13907").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.j));
                TiebaStatic.log(new StatisticItem("c15341").param("uid", TbadkCoreApplication.getCurrentAccount()));
                return;
            }
            setVisibility(8);
        }
    }
}
