package com.baidu.tieba.homepage.activitypage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.kg5;
import com.baidu.tieba.lf5;
import com.baidu.tieba.lr4;
import com.baidu.tieba.np4;
import com.baidu.tieba.nw6;
import com.baidu.tieba.o37;
import com.baidu.tieba.pv4;
import com.baidu.tieba.qp4;
import com.baidu.tieba.w9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ActivityPageHeaderView extends LinearLayout implements kg5<nw6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public AutoBannerLayout b;
    public GridIconLayout c;
    public String d;
    public qp4 e;
    public pv4<lr4> f;

    /* loaded from: classes4.dex */
    public class a implements qp4<lr4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityPageHeaderView a;

        public a(ActivityPageHeaderView activityPageHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityPageHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activityPageHeaderView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qp4
        /* renamed from: a */
        public void d(View view2, lr4 lr4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, lr4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qp4
        /* renamed from: b */
        public void c(View view2, lr4 lr4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, lr4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                o37.a("c13751", lr4Var, i + 1, this.a.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements pv4<lr4> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activityPageHeaderView;
        }

        @Override // com.baidu.tieba.pv4
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                lr4 lr4Var = new lr4();
                lr4Var.e(str);
                o37.a("c13750", lr4Var, i, this.a.d);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pv4
        /* renamed from: c */
        public void a(int i, lr4 lr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, lr4Var) == null) {
                o37.b("c13750", lr4Var, i, this.a.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements np4 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activityPageHeaderView;
        }

        @Override // com.baidu.tieba.np4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z && this.a.b != null) {
                this.a.b.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements np4 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activityPageHeaderView;
        }

        @Override // com.baidu.tieba.np4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z) {
                o37.c("c13751", this.a.d);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.f = new b(this);
        this.d = str2;
        d();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            setDescendantFocusability(262144);
            this.a = (TbPageContext) w9.a(getContext());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lg5
    /* renamed from: e */
    public lf5 a(nw6 nw6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nw6Var)) == null) {
            if (nw6Var == null) {
                return null;
            }
            setPadding(0, ej.f(getContext(), R.dimen.tbds44), 0, ej.f(getContext(), R.dimen.tbds60));
            if (this.b == null) {
                AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
                this.b = autoBannerLayout;
                autoBannerLayout.setMarqueenTime(3000L);
                this.b.setOnCoverViewCallback(this.f);
                this.b.setBannerHeight(ej.f(getContext(), R.dimen.tbds328));
                int f = ej.f(getContext(), R.dimen.tbds44);
                this.b.setPadding(f, 0, f, 0);
                addView(this.b);
                this.b.setIWindowChangedListener(new c(this));
            }
            this.b.a(nw6Var.f);
            if (this.c == null) {
                GridIconLayout gridIconLayout = new GridIconLayout(getContext());
                this.c = gridIconLayout;
                gridIconLayout.setOnItemCoverListener(this.e);
                addView(this.c);
                this.c.setIWindowChangedListener(new d(this));
                this.c.setPadding(0, ej.f(getContext(), R.dimen.tbds61), 0, 0);
                this.c.setVerticalSpace(ej.f(getContext(), R.dimen.tbds61));
                this.c.setMaxItem(10);
            }
            this.c.a(nw6Var.g);
            return new lf5();
        }
        return (lf5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kg5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mg5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            AutoBannerLayout autoBannerLayout = this.b;
            if (autoBannerLayout != null) {
                autoBannerLayout.onChangeSkinType(this.a, i);
            }
            GridIconLayout gridIconLayout = this.c;
            if (gridIconLayout != null) {
                gridIconLayout.onChangeSkinType(this.a, i);
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onWindowVisibilityChanged(i);
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.f = new b(this);
        d();
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
        this.e = new a(this);
        this.f = new b(this);
        d();
    }
}
