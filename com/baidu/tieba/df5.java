package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.local.view.LocalInputContainer;
import com.baidu.tieba.lg5;
import com.baidu.tieba.xqa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class df5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public Context b;
    public View c;
    public ef5 d;
    public gf5 e;

    public df5(Context context, View view2, ef5 ef5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, ef5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (!k(context, view2, ef5Var)) {
            return;
        }
        this.b = context;
        this.c = view2;
        this.d = ef5Var;
        c();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.c instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.c).addView(this.a, layoutParams);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            this.a.v();
            if (this.c != null && this.a.getParent() != null) {
                View view2 = this.c;
                if (view2 instanceof RelativeLayout) {
                    ((RelativeLayout) view2).removeView(this.a);
                }
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = new gf5(this.d);
        }
    }

    public final void j() {
        gf5 gf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (gf5Var = this.e) == null) {
            return;
        }
        gf5Var.d(new xqa.i() { // from class: com.baidu.tieba.ze5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.xqa.i
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    df5.this.i(str);
                }
            }
        });
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EditorTools a = ((lf5) new mf5(this.d).a(this.b)).a();
            this.a = a;
            a.setId(R.id.local_input_tool);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.cf5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        df5.this.f(view2);
                    }
                }
            });
            Context context = this.b;
            if (context instanceof Activity) {
                lg5.b((Activity) context, this.a.b, new lg5.b() { // from class: com.baidu.tieba.bf5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.lg5.b
                    public final void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            df5.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.u(36).m).setSendBtnClickListener(new LocalInputContainer.c() { // from class: com.baidu.tieba.af5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(ef5 ef5Var, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, ef5Var, str) == null) {
                        df5.this.h(ef5Var, str);
                    }
                }
            });
            a();
        }
    }

    public /* synthetic */ void f(View view2) {
        b();
    }

    public /* synthetic */ void g(boolean z) {
        if (z) {
            this.a.b.setVisibility(0);
            this.a.b.setBackgroundColorId(R.color.CAM_X0207);
            return;
        }
        this.a.b.o();
    }

    public /* synthetic */ void i(String str) {
        this.a.K(new xd5(6, 36, str));
    }

    public /* synthetic */ void h(ef5 ef5Var, String str) {
        gf5 gf5Var = this.e;
        if (gf5Var != null) {
            gf5Var.f(ef5Var, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", ef5Var.a().a);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean k(Context context, View view2, ef5 ef5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, view2, ef5Var)) == null) {
            if ((context instanceof Activity) && view2 != null && ef5Var != null) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void l() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (editorTools = this.a) != null && editorTools.u(36) != null) {
            le5 le5Var = this.a.u(36).m;
            if (le5Var instanceof LocalInputContainer) {
                String inputContentDraft = ((LocalInputContainer) le5Var).getInputContentDraft();
                gf5 gf5Var = this.e;
                if (gf5Var != null) {
                    gf5Var.e(inputContentDraft);
                }
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.a != null) {
            j();
            this.a.m();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SHOW);
            statisticItem.addParam("obj_id", this.d.a().a);
            TiebaStatic.log(statisticItem);
        }
    }
}
