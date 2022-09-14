package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubbleManager;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public abstract class gs0 extends is0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public ViewGroup b;
    @JvmField
    public q61 c;
    @JvmField
    public boolean d;

    /* loaded from: classes4.dex */
    public static final class a implements BubbleManager.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs0 a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(gs0 gs0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs0Var;
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b = null;
            }
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    public gs0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.cs0
    public void k(ht0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_ON_INFO)) {
                int g = event.g(1);
                if ((g == 904 || g == 956) && w() != null) {
                    y();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cs0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.m();
            this.b = null;
            q61 q61Var = this.c;
            if (q61Var != null) {
                q61Var.k();
            }
        }
    }

    public void v() {
        q61 q61Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (q61Var = this.c) == null) {
            return;
        }
        q61Var.c();
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String string = context.getResources().getString(R.string.obfuscated_res_0x7f0f0b84);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…eo_switch_fullscreen_tip)");
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.d && this.b != null) {
            if (!q().V0()) {
                r().X(true, true);
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int color = context.getResources().getColor(R.color.obfuscated_res_0x7f06087a);
            m61 m61Var = (m61) BubbleManager.t(m61.class);
            m61Var.j(w(), this.b);
            m61Var.q(x());
            m61Var.r(-1, -1);
            m61Var.l(color, color);
            m61Var.m(1, 12.0f);
            m61Var.p(-2.0f);
            m61Var.n(BubblePosition.DOWN);
            m61Var.k(5000);
            m61Var.i(true);
            m61Var.o(new a(this));
            q61 h = m61Var.h();
            this.c = h;
            if (h != null) {
                h.p();
            }
            this.d = false;
            r().U(5000);
        }
    }
}
