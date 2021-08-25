package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.p0.n.f;
import c.a.p0.s.q.l0;
import c.a.p0.s.q.m;
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
/* loaded from: classes7.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f52300e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f52301f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f52302g;

    /* renamed from: h  reason: collision with root package name */
    public String f52303h;

    /* renamed from: i  reason: collision with root package name */
    public f f52304i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.s.w.b.d<m> f52305j;

    /* loaded from: classes7.dex */
    public class a implements c.a.p0.n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f52306a;

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
            this.f52306a = homePageTabFeedHeaderView;
        }

        @Override // c.a.p0.n.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z && this.f52306a.f52301f != null) {
                this.f52306a.f52301f.checkAndStartMarqueen();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.p0.n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f52307a;

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
            this.f52307a = homePageTabFeedHeaderView;
        }

        @Override // c.a.p0.n.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z) {
                c.a.q0.f1.j.c.c("c13751", this.f52307a.f52303h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f52308e;

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
            this.f52308e = homePageTabFeedHeaderView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: b */
        public void c(View view, m mVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: d */
        public void a(View view, m mVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                c.a.q0.f1.j.c.a("c13751", mVar, i2 + 1, this.f52308e.f52303h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.a.p0.s.w.b.d<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedHeaderView f52309a;

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
            this.f52309a = homePageTabFeedHeaderView;
        }

        @Override // c.a.p0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                m mVar = new m();
                mVar.g(str);
                c.a.q0.f1.j.c.a("c13750", mVar, i2, this.f52309a.f52303h);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.s.w.b.d
        /* renamed from: c */
        public void a(int i2, m mVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, mVar) == null) || mVar == null) {
                return;
            }
            c.a.q0.f1.j.c.b("c13750", mVar, i2, this.f52309a.f52303h);
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
        this.f52304i = new c(this);
        this.f52305j = new d(this);
        init();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setDescendantFocusability(262144);
            this.f52300e = (TbPageContext) j.a(getContext());
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            AutoBannerLayout autoBannerLayout = this.f52301f;
            if (autoBannerLayout != null) {
                autoBannerLayout.onChangeSkinType(this.f52300e, i2);
            }
            GridIconLayout gridIconLayout = this.f52302g;
            if (gridIconLayout != null) {
                gridIconLayout.onChangeSkinType(this.f52300e, i2);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gridIconLayout = this.f52302g) == null) {
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

    public void setData(c.a.q0.f1.j.h.c cVar) {
        List<m> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null) {
            return;
        }
        setPadding(0, l.g(getContext(), R.dimen.M_H_X003), 0, 0);
        if (this.f52301f == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.f52301f = autoBannerLayout;
            autoBannerLayout.setFrom(YYLiveUtil.SOURCE_CHANNEL_BANNER);
            this.f52301f.setMarqueenTime(3000L);
            this.f52301f.setOnCoverViewCallback(this.f52305j);
            this.f52301f.setBannerHeight(l.g(getContext(), R.dimen.tbds343));
            addView(this.f52301f);
            this.f52301f.setIWindowChangedListener(new a(this));
        }
        this.f52301f.onBindDataToView(cVar.f17925e);
        if (this.f52302g == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.f52302g = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.f52304i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = l.g(this.f52300e.getPageActivity(), R.dimen.M_H_X003);
            addView(this.f52302g, layoutParams);
            int g2 = l.g(this.f52300e.getPageActivity(), R.dimen.M_H_X002);
            int g3 = l.g(this.f52300e.getPageActivity(), R.dimen.tbds30);
            l0 l0Var = cVar.f17926f;
            int size = (l0Var == null || (list = l0Var.f14290e) == null) ? 0 : list.size();
            if (size == 5 || size >= 9) {
                this.f52302g.setPadding(0, g2, 0, g2);
            } else if (size >= 4 && size < 9) {
                this.f52302g.setPadding(g3, g2, g3, g2);
            }
            this.f52302g.setIWindowChangedListener(new b(this));
            this.f52302g.setMaxItem(10);
        }
        this.f52302g.onBindDataToView(cVar.f17926f);
        this.f52302g.onChangeSkinType(this.f52300e, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f52303h = str;
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
        this.f52304i = new c(this);
        this.f52305j = new d(this);
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
        this.f52304i = new c(this);
        this.f52305j = new d(this);
        init();
    }
}
