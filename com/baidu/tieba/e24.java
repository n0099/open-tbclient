package com.baidu.tieba;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.tieba.f24;
import com.baidu.tieba.t43;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FullScreenFloatView a;

    /* loaded from: classes5.dex */
    public class a implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ e24 b;

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onDrag() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(e24 e24Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e24Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e24Var;
            this.a = activity;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.d(this.a);
            }
        }
    }

    public e24() {
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

    public void c(f24.c cVar, Activity activity) {
        d24 d24Var;
        j54 j54Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, activity) == null) && activity != null && this.a == null) {
            if (cVar != null && (j54Var = cVar.c) != null) {
                d24Var = j54Var.f;
            } else {
                d24Var = null;
            }
            if (d24.f(d24Var).b()) {
                b(activity);
            }
        }
    }

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            FullScreenFloatView a2 = y33.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.a = a2;
            a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01a4));
            this.a.setFloatImageBackground(R.drawable.obfuscated_res_0x7f080178);
            this.a.setAutoAttachEnable(false);
            this.a.setDragImageListener(new a(this, activity));
            this.a.setVisibility(0);
        }
    }

    public final void d(Activity activity) {
        p53 M;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (M = p53.M()) != null && M.Z() != null) {
            Resources resources = activity.getResources();
            String u = SwanInspectorEndpoint.v().u(resources);
            t43.a aVar = new t43.a(activity);
            aVar.V(resources.getString(R.string.obfuscated_res_0x7f0f020a));
            aVar.x(u);
            aVar.n(new xk3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f01d1, null);
            aVar.X();
        }
    }
}
