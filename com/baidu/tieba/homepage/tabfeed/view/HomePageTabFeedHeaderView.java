package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import b.a.e.a.j;
import b.a.e.f.p.l;
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
    public TbPageContext<?> f50693e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f50694f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f50695g;

    /* renamed from: h  reason: collision with root package name */
    public String f50696h;

    /* renamed from: i  reason: collision with root package name */
    public f f50697i;
    public b.a.q0.s.w.b.d<m> j;

    /* loaded from: classes9.dex */
    public class a implements b.a.q0.n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f50698a;

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
            this.f50698a = homePageTabFeedHeaderView;
        }

        @Override // b.a.q0.n.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z && this.f50698a.f50694f != null) {
                this.f50698a.f50694f.checkAndStartMarqueen();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.a.q0.n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f50699a;

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
            this.f50699a = homePageTabFeedHeaderView;
        }

        @Override // b.a.q0.n.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z) {
                b.a.r0.h1.j.c.c("c13751", this.f50699a.f50696h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f50700e;

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
            this.f50700e = homePageTabFeedHeaderView;
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
                b.a.r0.h1.j.c.a("c13751", mVar, i2 + 1, this.f50700e.f50696h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements b.a.q0.s.w.b.d<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f50701a;

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
            this.f50701a = homePageTabFeedHeaderView;
        }

        @Override // b.a.q0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                m mVar = new m();
                mVar.g(str);
                b.a.r0.h1.j.c.a("c13750", mVar, i2, this.f50701a.f50696h);
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
            b.a.r0.h1.j.c.b("c13750", mVar, i2, this.f50701a.f50696h);
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
        this.f50697i = new c(this);
        this.j = new d(this);
        init();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setDescendantFocusability(262144);
            this.f50693e = (TbPageContext) j.a(getContext());
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            AutoBannerLayout autoBannerLayout = this.f50694f;
            if (autoBannerLayout != null) {
                autoBannerLayout.onChangeSkinType(this.f50693e, i2);
            }
            GridIconLayout gridIconLayout = this.f50695g;
            if (gridIconLayout != null) {
                gridIconLayout.onChangeSkinType(this.f50693e, i2);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gridIconLayout = this.f50695g) == null) {
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
        if (this.f50694f == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.f50694f = autoBannerLayout;
            autoBannerLayout.setFrom(YYLiveUtil.SOURCE_CHANNEL_BANNER);
            this.f50694f.setMarqueenTime(3000L);
            this.f50694f.setOnCoverViewCallback(this.j);
            this.f50694f.setBannerHeight(l.g(getContext(), R.dimen.tbds343));
            addView(this.f50694f);
            this.f50694f.setIWindowChangedListener(new a(this));
        }
        this.f50694f.onBindDataToView(cVar.f19037e);
        if (this.f50695g == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.f50695g = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.f50697i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = l.g(this.f50693e.getPageActivity(), R.dimen.M_H_X003);
            addView(this.f50695g, layoutParams);
            int g2 = l.g(this.f50693e.getPageActivity(), R.dimen.M_H_X002);
            int g3 = l.g(this.f50693e.getPageActivity(), R.dimen.tbds30);
            l0 l0Var = cVar.f19038f;
            int size = (l0Var == null || (list = l0Var.f14168e) == null) ? 0 : list.size();
            if (size == 5 || size >= 9) {
                this.f50695g.setPadding(0, g2, 0, g2);
            } else if (size >= 4 && size < 9) {
                this.f50695g.setPadding(g3, g2, g3, g2);
            }
            this.f50695g.setIWindowChangedListener(new b(this));
            this.f50695g.setMaxItem(10);
        }
        this.f50695g.onBindDataToView(cVar.f19038f);
        this.f50695g.onChangeSkinType(this.f50693e, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f50696h = str;
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
        this.f50697i = new c(this);
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
        this.f50697i = new c(this);
        this.j = new d(this);
        init();
    }
}
