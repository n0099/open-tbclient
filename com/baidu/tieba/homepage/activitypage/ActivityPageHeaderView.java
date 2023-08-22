package com.baidu.tieba.homepage.activitypage;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bz7;
import com.baidu.tieba.d78;
import com.baidu.tieba.ev5;
import com.baidu.tieba.fu5;
import com.baidu.tieba.j15;
import com.baidu.tieba.k75;
import com.baidu.tieba.l9;
import com.baidu.tieba.oz4;
import com.baidu.tieba.rz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ActivityPageHeaderView extends LinearLayout implements ev5<bz7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public AutoBannerLayout b;
    public GridIconLayout c;
    public String d;
    public rz4 e;
    public k75<j15> f;

    @Override // com.baidu.tieba.ev5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements rz4<j15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityPageHeaderView a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz4
        /* renamed from: a */
        public void c(View view2, j15 j15Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, j15Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
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
        @Override // com.baidu.tieba.rz4
        /* renamed from: b */
        public void d(View view2, j15 j15Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, j15Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                d78.a("c13751", j15Var, i + 1, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements k75<j15> {
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

        @Override // com.baidu.tieba.k75
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                j15 j15Var = new j15();
                j15Var.e(str);
                d78.a("c13750", j15Var, i, this.a.d);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k75
        /* renamed from: c */
        public void a(int i, j15 j15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, j15Var) == null) {
                d78.b("c13750", j15Var, i, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements oz4 {
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

        @Override // com.baidu.tieba.oz4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z && this.a.b != null) {
                this.a.b.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements oz4 {
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

        @Override // com.baidu.tieba.oz4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z) {
                d78.c("c13751", this.a.d);
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
        c();
    }

    @Override // com.baidu.tieba.gv5
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

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setDescendantFocusability(262144);
            this.a = (TbPageContext) l9.a(getContext());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fv5
    /* renamed from: d */
    public fu5 onBindDataToView(bz7 bz7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bz7Var)) == null) {
            if (bz7Var == null) {
                return null;
            }
            setPadding(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds44), 0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds60));
            if (this.b == null) {
                AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
                this.b = autoBannerLayout;
                autoBannerLayout.setMarqueenTime(3000L);
                this.b.setOnCoverViewCallback(this.f);
                this.b.setBannerHeight(BdUtilHelper.getDimens(getContext(), R.dimen.tbds328));
                int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds44);
                this.b.setPadding(dimens, 0, dimens, 0);
                addView(this.b);
                this.b.setIWindowChangedListener(new c(this));
            }
            this.b.onBindDataToView(bz7Var.f);
            if (this.c == null) {
                GridIconLayout gridIconLayout = new GridIconLayout(getContext());
                this.c = gridIconLayout;
                gridIconLayout.setOnItemCoverListener(this.e);
                addView(this.c);
                this.c.setIWindowChangedListener(new d(this));
                this.c.setPadding(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds61), 0, 0);
                this.c.setVerticalSpace(BdUtilHelper.getDimens(getContext(), R.dimen.tbds61));
                this.c.setMaxItem(10);
            }
            this.c.onBindDataToView(bz7Var.g);
            return new fu5();
        }
        return (fu5) invokeL.objValue;
    }
}
