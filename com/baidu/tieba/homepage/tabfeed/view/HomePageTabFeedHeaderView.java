package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.a38;
import com.baidu.tieba.q9;
import com.baidu.tieba.sz4;
import com.baidu.tieba.u15;
import com.baidu.tieba.v25;
import com.baidu.tieba.v75;
import com.baidu.tieba.vi;
import com.baidu.tieba.vz4;
import com.baidu.tieba.z18;
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
    public vz4 e;
    public v75<u15> f;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements sz4 {
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

        @Override // com.baidu.tieba.sz4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z && this.a.b != null) {
                this.a.b.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements sz4 {
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

        @Override // com.baidu.tieba.sz4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z) {
                z18.c("c13751", this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements vz4<u15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedHeaderView a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vz4
        /* renamed from: a */
        public void c(View view2, u15 u15Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, u15Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
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
        @Override // com.baidu.tieba.vz4
        /* renamed from: b */
        public void d(View view2, u15 u15Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, u15Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                z18.a("c13751", u15Var, i + 1, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements v75<u15> {
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

        @Override // com.baidu.tieba.v75
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                u15 u15Var = new u15();
                u15Var.e(str);
                z18.a("c13750", u15Var, i, this.a.d);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v75
        /* renamed from: c */
        public void a(int i, u15 u15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, u15Var) != null) || u15Var == null) {
                return;
            }
            z18.b("c13750", u15Var, i, this.a.d);
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
            this.a = (TbPageContext) q9.a(getContext());
        }
    }

    public void e() {
        GridIconLayout gridIconLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (gridIconLayout = this.c) != null) {
            gridIconLayout.f();
        }
    }

    public void f() {
        AutoBannerLayout autoBannerLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (autoBannerLayout = this.b) != null && autoBannerLayout.getCoverFlowView() != null) {
            this.b.getCoverFlowView().x();
        }
    }

    public void g() {
        AutoBannerLayout autoBannerLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (autoBannerLayout = this.b) != null && autoBannerLayout.getCoverFlowView() != null) {
            this.b.getCoverFlowView().m();
        }
    }

    public void setData(a38 a38Var) {
        int i;
        List<u15> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, a38Var) != null) || a38Var == null) {
            return;
        }
        setPadding(0, vi.g(getContext(), R.dimen.M_H_X003), 0, 0);
        if (this.b == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.b = autoBannerLayout;
            autoBannerLayout.setFrom(YYLiveUtil.SOURCE_CHANNEL_BANNER);
            this.b.setMarqueenTime(3000L);
            this.b.setOnCoverViewCallback(this.f);
            this.b.setBannerHeight(vi.g(getContext(), R.dimen.tbds343));
            addView(this.b);
            this.b.setIWindowChangedListener(new a(this));
        }
        this.b.a(a38Var.e);
        if (this.c == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.c = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.e);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = vi.g(this.a.getPageActivity(), R.dimen.M_H_X003);
            addView(this.c, layoutParams);
            int g = vi.g(this.a.getPageActivity(), R.dimen.M_H_X002);
            int g2 = vi.g(this.a.getPageActivity(), R.dimen.tbds30);
            v25 v25Var = a38Var.f;
            if (v25Var != null && (list = v25Var.a) != null) {
                i = list.size();
            } else {
                i = 0;
            }
            if (i != 5 && i < 9) {
                if (i >= 4 && i < 9) {
                    this.c.setPadding(g2, g, g2, g);
                }
            } else {
                this.c.setPadding(0, g, 0, g);
            }
            this.c.setIWindowChangedListener(new b(this));
            this.c.setMaxItem(10);
        }
        this.c.a(a38Var.f);
        this.c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
    }
}
