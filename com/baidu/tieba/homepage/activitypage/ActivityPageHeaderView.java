package com.baidu.tieba.homepage.activitypage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import c.a.d.a.j;
import c.a.d.f.p.n;
import c.a.q0.m.f;
import c.a.q0.r.r.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ActivityPageHeaderView extends LinearLayout implements c.a.q0.a1.i.d<c.a.r0.o1.b.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f42754e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f42755f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f42756g;

    /* renamed from: h  reason: collision with root package name */
    public String f42757h;

    /* renamed from: i  reason: collision with root package name */
    public f f42758i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.r.x.b.d<m> f42759j;

    /* loaded from: classes5.dex */
    public class a implements f<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ActivityPageHeaderView f42760e;

        public a(ActivityPageHeaderView activityPageHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityPageHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42760e = activityPageHeaderView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.m.f
        /* renamed from: b */
        public void c(View view, m mVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.m.f
        /* renamed from: d */
        public void a(View view, m mVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, mVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                c.a.r0.o1.k.c.a("c13751", mVar, i2 + 1, this.f42760e.f42757h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.q0.r.x.b.d<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityPageHeaderView a;

        public b(ActivityPageHeaderView activityPageHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityPageHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activityPageHeaderView;
        }

        @Override // c.a.q0.r.x.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                m mVar = new m();
                mVar.g(str);
                c.a.r0.o1.k.c.a("c13750", mVar, i2, this.a.f42757h);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.r.x.b.d
        /* renamed from: c */
        public void a(int i2, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, mVar) == null) {
                c.a.r0.o1.k.c.b("c13750", mVar, i2, this.a.f42757h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.a.q0.m.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityPageHeaderView a;

        public c(ActivityPageHeaderView activityPageHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityPageHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activityPageHeaderView;
        }

        @Override // c.a.q0.m.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z && this.a.f42755f != null) {
                this.a.f42755f.checkAndStartMarqueen();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.a.q0.m.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityPageHeaderView a;

        public d(ActivityPageHeaderView activityPageHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityPageHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activityPageHeaderView;
        }

        @Override // c.a.q0.m.c
        public void a(View view, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Boolean.valueOf(z), obj}) == null) && z) {
                c.a.r0.o1.k.c.c("c13751", this.a.f42757h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityPageHeaderView(Context context, String str, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42758i = new a(this);
        this.f42759j = new b(this);
        this.f42757h = str2;
        init();
    }

    @Override // c.a.q0.a1.i.d
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            setDescendantFocusability(262144);
            this.f42754e = (TbPageContext) j.a(getContext());
        }
    }

    @Override // c.a.q0.a1.i.f
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            AutoBannerLayout autoBannerLayout = this.f42755f;
            if (autoBannerLayout != null) {
                autoBannerLayout.onChangeSkinType(this.f42754e, i2);
            }
            GridIconLayout gridIconLayout = this.f42756g;
            if (gridIconLayout != null) {
                gridIconLayout.onChangeSkinType(this.f42754e, i2);
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a1.i.e
    public c.a.q0.a1.d.c onBindDataToView(c.a.r0.o1.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            setPadding(0, n.f(getContext(), R.dimen.tbds44), 0, n.f(getContext(), R.dimen.tbds60));
            if (this.f42755f == null) {
                AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
                this.f42755f = autoBannerLayout;
                autoBannerLayout.setMarqueenTime(3000L);
                this.f42755f.setOnCoverViewCallback(this.f42759j);
                this.f42755f.setBannerHeight(n.f(getContext(), R.dimen.tbds328));
                int f2 = n.f(getContext(), R.dimen.tbds44);
                this.f42755f.setPadding(f2, 0, f2, 0);
                addView(this.f42755f);
                this.f42755f.setIWindowChangedListener(new c(this));
            }
            this.f42755f.onBindDataToView(bVar.f19650f);
            if (this.f42756g == null) {
                GridIconLayout gridIconLayout = new GridIconLayout(getContext());
                this.f42756g = gridIconLayout;
                gridIconLayout.setOnItemCoverListener(this.f42758i);
                addView(this.f42756g);
                this.f42756g.setIWindowChangedListener(new d(this));
                this.f42756g.setPadding(0, n.f(getContext(), R.dimen.tbds61), 0, 0);
                this.f42756g.setVerticalSpace(n.f(getContext(), R.dimen.tbds61));
                this.f42756g.setMaxItem(10);
            }
            this.f42756g.onBindDataToView(bVar.f19651g);
            return new c.a.q0.a1.d.c();
        }
        return (c.a.q0.a1.d.c) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityPageHeaderView(Context context) {
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
        this.f42758i = new a(this);
        this.f42759j = new b(this);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityPageHeaderView(Context context, AttributeSet attributeSet) {
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
        this.f42758i = new a(this);
        this.f42759j = new b(this);
        init();
    }
}
