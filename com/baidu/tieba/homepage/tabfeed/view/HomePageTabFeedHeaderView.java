package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import b.a.e.a.j;
import b.a.e.e.p.l;
import b.a.q0.n.f;
import b.a.q0.s.q.l0;
import b.a.q0.s.q.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f49782e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f49783f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f49784g;

    /* renamed from: h  reason: collision with root package name */
    public String f49785h;

    /* renamed from: i  reason: collision with root package name */
    public f f49786i;
    public b.a.q0.s.w.b.d<m> j;

    /* loaded from: classes9.dex */
    public class a implements b.a.q0.n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f49787a;

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
            this.f49787a = homePageTabFeedHeaderView;
        }

        @Override // b.a.q0.n.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z && this.f49787a.f49783f != null) {
                this.f49787a.f49783f.checkAndStartMarqueen();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.a.q0.n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f49788a;

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
            this.f49788a = homePageTabFeedHeaderView;
        }

        @Override // b.a.q0.n.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z) {
                b.a.r0.h1.j.c.c("c13751", this.f49788a.f49785h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f49789e;

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
            this.f49789e = homePageTabFeedHeaderView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.f
        /* renamed from: b */
        public void c(View view, m mVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.f
        /* renamed from: d */
        public void a(View view, m mVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                b.a.r0.h1.j.c.a("c13751", mVar, i2 + 1, this.f49789e.f49785h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements b.a.q0.s.w.b.d<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f49790a;

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
            this.f49790a = homePageTabFeedHeaderView;
        }

        @Override // b.a.q0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                m mVar = new m();
                mVar.g(str);
                b.a.r0.h1.j.c.a("c13750", mVar, i2, this.f49790a.f49785h);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.s.w.b.d
        /* renamed from: c */
        public void a(int i2, m mVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, mVar) == null) || mVar == null) {
                return;
            }
            b.a.r0.h1.j.c.b("c13750", mVar, i2, this.f49790a.f49785h);
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
        this.f49786i = new c(this);
        this.j = new d(this);
        init();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setDescendantFocusability(262144);
            this.f49782e = (TbPageContext) j.a(getContext());
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            AutoBannerLayout autoBannerLayout = this.f49783f;
            if (autoBannerLayout != null) {
                autoBannerLayout.onChangeSkinType(this.f49782e, i2);
            }
            GridIconLayout gridIconLayout = this.f49784g;
            if (gridIconLayout != null) {
                gridIconLayout.onChangeSkinType(this.f49782e, i2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
        }
    }

    public void onDestroy() {
        GridIconLayout gridIconLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gridIconLayout = this.f49784g) == null) {
            return;
        }
        gridIconLayout.onDestroy();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
        }
    }

    public void setData(b.a.r0.h1.j.h.c cVar) {
        List<m> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null) {
            return;
        }
        setPadding(0, l.g(getContext(), R.dimen.M_H_X003), 0, 0);
        if (this.f49783f == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.f49783f = autoBannerLayout;
            autoBannerLayout.setFrom(YYLiveUtil.SOURCE_CHANNEL_BANNER);
            this.f49783f.setMarqueenTime(3000L);
            this.f49783f.setOnCoverViewCallback(this.j);
            this.f49783f.setBannerHeight(l.g(getContext(), R.dimen.tbds343));
            addView(this.f49783f);
            this.f49783f.setIWindowChangedListener(new a(this));
        }
        this.f49783f.onBindDataToView(cVar.f17568e);
        if (this.f49784g == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.f49784g = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.f49786i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = l.g(this.f49782e.getPageActivity(), R.dimen.M_H_X003);
            addView(this.f49784g, layoutParams);
            int g2 = l.g(this.f49782e.getPageActivity(), R.dimen.M_H_X002);
            int g3 = l.g(this.f49782e.getPageActivity(), R.dimen.tbds30);
            l0 l0Var = cVar.f17569f;
            int size = (l0Var == null || (list = l0Var.f13388e) == null) ? 0 : list.size();
            if (size == 5 || size >= 9) {
                this.f49784g.setPadding(0, g2, 0, g2);
            } else if (size >= 4 && size < 9) {
                this.f49784g.setPadding(g3, g2, g3, g2);
            }
            this.f49784g.setIWindowChangedListener(new b(this));
            this.f49784g.setMaxItem(10);
        }
        this.f49784g.onBindDataToView(cVar.f17569f);
        this.f49784g.onChangeSkinType(this.f49782e, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f49785h = str;
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
        this.f49786i = new c(this);
        this.j = new d(this);
        init();
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
        this.f49786i = new c(this);
        this.j = new d(this);
        init();
    }
}
