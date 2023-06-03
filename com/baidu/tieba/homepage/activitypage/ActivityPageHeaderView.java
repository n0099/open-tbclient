package com.baidu.tieba.homepage.activitypage;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.iv5;
import com.baidu.tieba.ju5;
import com.baidu.tieba.q9;
import com.baidu.tieba.qu7;
import com.baidu.tieba.s15;
import com.baidu.tieba.sz4;
import com.baidu.tieba.t75;
import com.baidu.tieba.vi;
import com.baidu.tieba.vz4;
import com.baidu.tieba.x18;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ActivityPageHeaderView extends LinearLayout implements iv5<qu7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public AutoBannerLayout b;
    public GridIconLayout c;
    public String d;
    public vz4 e;
    public t75<s15> f;

    @Override // com.baidu.tieba.iv5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements vz4<s15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityPageHeaderView a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vz4
        /* renamed from: a */
        public void c(View view2, s15 s15Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, s15Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            }
        }

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
        @Override // com.baidu.tieba.vz4
        /* renamed from: b */
        public void d(View view2, s15 s15Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, s15Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                x18.a("c13751", s15Var, i + 1, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements t75<s15> {
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

        @Override // com.baidu.tieba.t75
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                s15 s15Var = new s15();
                s15Var.e(str);
                x18.a("c13750", s15Var, i, this.a.d);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t75
        /* renamed from: c */
        public void a(int i, s15 s15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, s15Var) == null) {
                x18.b("c13750", s15Var, i, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements sz4 {
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

        @Override // com.baidu.tieba.sz4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z && this.a.b != null) {
                this.a.b.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements sz4 {
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

        @Override // com.baidu.tieba.sz4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z) {
                x18.c("c13751", this.a.d);
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
        this.d = str2;
        d();
    }

    @Override // com.baidu.tieba.kv5
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

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            setDescendantFocusability(262144);
            this.a = (TbPageContext) q9.a(getContext());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jv5
    /* renamed from: e */
    public ju5 a(qu7 qu7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qu7Var)) == null) {
            if (qu7Var == null) {
                return null;
            }
            setPadding(0, vi.g(getContext(), R.dimen.tbds44), 0, vi.g(getContext(), R.dimen.tbds60));
            if (this.b == null) {
                AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
                this.b = autoBannerLayout;
                autoBannerLayout.setMarqueenTime(3000L);
                this.b.setOnCoverViewCallback(this.f);
                this.b.setBannerHeight(vi.g(getContext(), R.dimen.tbds328));
                int g = vi.g(getContext(), R.dimen.tbds44);
                this.b.setPadding(g, 0, g, 0);
                addView(this.b);
                this.b.setIWindowChangedListener(new c(this));
            }
            this.b.a(qu7Var.f);
            if (this.c == null) {
                GridIconLayout gridIconLayout = new GridIconLayout(getContext());
                this.c = gridIconLayout;
                gridIconLayout.setOnItemCoverListener(this.e);
                addView(this.c);
                this.c.setIWindowChangedListener(new d(this));
                this.c.setPadding(0, vi.g(getContext(), R.dimen.tbds61), 0, 0);
                this.c.setVerticalSpace(vi.g(getContext(), R.dimen.tbds61));
                this.c.setMaxItem(10);
            }
            this.c.a(qu7Var.g);
            return new ju5();
        }
        return (ju5) invokeL.objValue;
    }
}
