package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.bu4;
import com.baidu.tieba.e38;
import com.baidu.tieba.eu4;
import com.baidu.tieba.f25;
import com.baidu.tieba.f48;
import com.baidu.tieba.k4;
import com.baidu.tieba.wv4;
import com.baidu.tieba.yw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public AutoBannerLayout b;
    public GridIconLayout c;
    public String d;
    public eu4 e;
    public f25<wv4> f;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements bu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedHeaderView a;

        public a(HomePageTabFeedHeaderView homePageTabFeedHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedHeaderView;
        }

        @Override // com.baidu.tieba.bu4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z && this.a.b != null) {
                this.a.b.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedHeaderView a;

        public b(HomePageTabFeedHeaderView homePageTabFeedHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedHeaderView;
        }

        @Override // com.baidu.tieba.bu4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z) {
                e38.c("c13751", this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements eu4<wv4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedHeaderView a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.eu4
        /* renamed from: a */
        public void d(View view2, wv4 wv4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wv4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            }
        }

        public c(HomePageTabFeedHeaderView homePageTabFeedHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedHeaderView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.eu4
        /* renamed from: c */
        public void b(View view2, wv4 wv4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, wv4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                e38.a("c13751", wv4Var, i + 1, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements f25<wv4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedHeaderView a;

        public d(HomePageTabFeedHeaderView homePageTabFeedHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedHeaderView;
        }

        @Override // com.baidu.tieba.f25
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                wv4 wv4Var = new wv4();
                wv4Var.e(str);
                e38.a("c13750", wv4Var, i, this.a.d);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f25
        /* renamed from: c */
        public void a(int i, wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wv4Var) != null) || wv4Var == null) {
                return;
            }
            e38.b("c13750", wv4Var, i, this.a.d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageTabFeedHeaderView(Context context) {
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
        this.e = new c(this);
        this.f = new d(this);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
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
        this.e = new c(this);
        this.f = new d(this);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i) {
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
        this.e = new c(this);
        this.f = new d(this);
        c();
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            AutoBannerLayout autoBannerLayout = this.b;
            if (autoBannerLayout != null) {
                autoBannerLayout.onChangeSkinType(this.a, i);
            }
            GridIconLayout gridIconLayout = this.c;
            if (gridIconLayout != null) {
                gridIconLayout.onChangeSkinType(this.a, i);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onWindowVisibilityChanged(i);
        }
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.d = str;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setDescendantFocusability(262144);
            this.a = (TbPageContext) k4.a(getContext());
        }
    }

    public void e() {
        GridIconLayout gridIconLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (gridIconLayout = this.c) != null) {
            gridIconLayout.e();
        }
    }

    public void f() {
        AutoBannerLayout autoBannerLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (autoBannerLayout = this.b) != null && autoBannerLayout.getCoverFlowView() != null) {
            this.b.getCoverFlowView().D();
        }
    }

    public void g() {
        AutoBannerLayout autoBannerLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (autoBannerLayout = this.b) != null && autoBannerLayout.getCoverFlowView() != null) {
            this.b.getCoverFlowView().o();
        }
    }

    public void setData(f48 f48Var) {
        int i;
        List<wv4> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, f48Var) != null) || f48Var == null) {
            return;
        }
        setPadding(0, BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003), 0, 0);
        if (this.b == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.b = autoBannerLayout;
            autoBannerLayout.setFrom(YYLiveUtil.SOURCE_CHANNEL_BANNER);
            this.b.setMarqueenTime(3000L);
            this.b.setOnCoverViewCallback(this.f);
            this.b.setBannerHeight(BdUtilHelper.getDimens(getContext(), R.dimen.tbds343));
            addView(this.b);
            this.b.setIWindowChangedListener(new a(this));
        }
        this.b.onBindDataToView(f48Var.e);
        if (this.c == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.c = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.e);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_H_X003);
            addView(this.c, layoutParams);
            int dimens = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_H_X002);
            int dimens2 = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds30);
            yw4 yw4Var = f48Var.f;
            if (yw4Var != null && (list = yw4Var.a) != null) {
                i = list.size();
            } else {
                i = 0;
            }
            if (i != 5 && i < 9) {
                if (i >= 4 && i < 9) {
                    this.c.setPadding(dimens2, dimens, dimens2, dimens);
                }
            } else {
                this.c.setPadding(0, dimens, 0, dimens);
            }
            this.c.setIWindowChangedListener(new b(this));
            this.c.setMaxItem(10);
        }
        this.c.onBindDataToView(f48Var.f);
        this.c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
    }
}
