package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.r0.m.f;
import d.a.r0.r.q.l0;
import d.a.r0.r.q.m;
import java.util.List;
/* loaded from: classes5.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f16826e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f16827f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f16828g;

    /* renamed from: h  reason: collision with root package name */
    public String f16829h;

    /* renamed from: i  reason: collision with root package name */
    public f f16830i;
    public d.a.r0.r.w.b.d<m> j;

    /* loaded from: classes5.dex */
    public class a implements d.a.r0.m.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f16831a;

        public a(HomePageTabFeedHeaderView homePageTabFeedHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16831a = homePageTabFeedHeaderView;
        }

        @Override // d.a.r0.m.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z && this.f16831a.f16827f != null) {
                this.f16831a.f16827f.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.r0.m.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f16832a;

        public b(HomePageTabFeedHeaderView homePageTabFeedHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16832a = homePageTabFeedHeaderView;
        }

        @Override // d.a.r0.m.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z) {
                d.a.s0.e1.j.c.c("c13751", this.f16832a.f16829h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f16833e;

        public c(HomePageTabFeedHeaderView homePageTabFeedHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16833e = homePageTabFeedHeaderView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.m.f
        /* renamed from: b */
        public void c(View view, m mVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.m.f
        /* renamed from: d */
        public void a(View view, m mVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                d.a.s0.e1.j.c.a("c13751", mVar, i2 + 1, this.f16833e.f16829h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.r0.r.w.b.d<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f16834a;

        public d(HomePageTabFeedHeaderView homePageTabFeedHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16834a = homePageTabFeedHeaderView;
        }

        @Override // d.a.r0.r.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                m mVar = new m();
                mVar.g(str);
                d.a.s0.e1.j.c.a("c13750", mVar, i2, this.f16834a.f16829h);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, mVar) == null) {
                d.a.s0.e1.j.c.b("c13750", mVar, i2, this.f16834a.f16829h);
            }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16830i = new c(this);
        this.j = new d(this);
        c();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setDescendantFocusability(262144);
            this.f16826e = (TbPageContext) j.a(getContext());
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            AutoBannerLayout autoBannerLayout = this.f16827f;
            if (autoBannerLayout != null) {
                autoBannerLayout.onChangeSkinType(this.f16826e, i2);
            }
            GridIconLayout gridIconLayout = this.f16828g;
            if (gridIconLayout != null) {
                gridIconLayout.onChangeSkinType(this.f16826e, i2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
        }
    }

    public void setData(d.a.s0.e1.j.h.c cVar) {
        List<m> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null) {
            return;
        }
        setPadding(0, l.g(getContext(), R.dimen.M_H_X003), 0, 0);
        if (this.f16827f == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.f16827f = autoBannerLayout;
            autoBannerLayout.setMarqueenTime(3000L);
            this.f16827f.setOnCoverViewCallback(this.j);
            this.f16827f.setBannerHeight(l.g(getContext(), R.dimen.tbds343));
            addView(this.f16827f);
            this.f16827f.setIWindowChangedListener(new a(this));
        }
        this.f16827f.a(cVar.f58984e);
        if (this.f16828g == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.f16828g = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.f16830i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = l.g(this.f16826e.getPageActivity(), R.dimen.M_H_X003);
            addView(this.f16828g, layoutParams);
            int g2 = l.g(this.f16826e.getPageActivity(), R.dimen.M_H_X002);
            int g3 = l.g(this.f16826e.getPageActivity(), R.dimen.tbds30);
            l0 l0Var = cVar.f58985f;
            int size = (l0Var == null || (list = l0Var.f56000e) == null) ? 0 : list.size();
            if (size == 5 || size >= 9) {
                this.f16828g.setPadding(0, g2, 0, g2);
            } else if (size >= 4 && size < 9) {
                this.f16828g.setPadding(g3, g2, g3, g2);
            }
            this.f16828g.setIWindowChangedListener(new b(this));
            this.f16828g.setMaxItem(10);
        }
        this.f16828g.a(cVar.f58985f);
        this.f16828g.onChangeSkinType(this.f16826e, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f16829h = str;
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16830i = new c(this);
        this.j = new d(this);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f16830i = new c(this);
        this.j = new d(this);
        c();
    }
}
