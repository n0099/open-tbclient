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
import com.baidu.tieba.a5;
import com.baidu.tieba.av4;
import com.baidu.tieba.cj8;
import com.baidu.tieba.f35;
import com.baidu.tieba.ms5;
import com.baidu.tieba.nr5;
import com.baidu.tieba.tw4;
import com.baidu.tieba.ua8;
import com.baidu.tieba.xu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ActivityPageHeaderView extends LinearLayout implements ms5<ua8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public AutoBannerLayout b;
    public GridIconLayout c;
    public String d;
    public av4 e;
    public f35<tw4> f;

    @Override // com.baidu.tieba.ms5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements av4<tw4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityPageHeaderView a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.av4
        /* renamed from: a */
        public void d(View view2, tw4 tw4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, tw4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
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
        @Override // com.baidu.tieba.av4
        /* renamed from: c */
        public void b(View view2, tw4 tw4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, tw4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                cj8.a("c13751", tw4Var, i + 1, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f35<tw4> {
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

        @Override // com.baidu.tieba.f35
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                tw4 tw4Var = new tw4();
                tw4Var.e(str);
                cj8.a("c13750", tw4Var, i, this.a.d);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f35
        /* renamed from: c */
        public void a(int i, tw4 tw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, tw4Var) == null) {
                cj8.b("c13750", tw4Var, i, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xu4 {
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

        @Override // com.baidu.tieba.xu4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z && this.a.b != null) {
                this.a.b.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements xu4 {
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

        @Override // com.baidu.tieba.xu4
        public void a(View view2, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Boolean.valueOf(z), obj}) == null) && z) {
                cj8.c("c13751", this.a.d);
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

    @Override // com.baidu.tieba.os5
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
            this.a = (TbPageContext) a5.a(getContext());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ns5
    /* renamed from: d */
    public nr5 onBindDataToView(ua8 ua8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ua8Var)) == null) {
            if (ua8Var == null) {
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
            this.b.onBindDataToView(ua8Var.f);
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
            this.c.onBindDataToView(ua8Var.g);
            return new nr5();
        }
        return (nr5) invokeL.objValue;
    }
}
