package com.baidu.tieba;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.tieba.b04;
import com.baidu.tieba.p23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FullScreenFloatView a;

    /* loaded from: classes3.dex */
    public class a implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ a04 b;

        public a(a04 a04Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a04Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a04Var;
            this.a = activity;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.d(this.a);
            }
        }
    }

    public a04() {
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

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            FullScreenFloatView a2 = u13.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.a = a2;
            a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f0175));
            this.a.setFloatImageBackground(R.drawable.obfuscated_res_0x7f08015d);
            this.a.setAutoAttachEnable(false);
            this.a.setDragImageListener(new a(this, activity));
            this.a.setVisibility(0);
        }
    }

    public void c(b04.c cVar, Activity activity) {
        f34 f34Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, activity) == null) && activity != null && this.a == null) {
            if (zz3.f((cVar == null || (f34Var = cVar.c) == null) ? null : f34Var.f).b()) {
                b(activity);
            }
        }
    }

    public final void d(Activity activity) {
        l33 M;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || (M = l33.M()) == null || M.Y() == null) {
            return;
        }
        Resources resources = activity.getResources();
        String u = SwanInspectorEndpoint.v().u(resources);
        p23.a aVar = new p23.a(activity);
        aVar.V(resources.getString(R.string.obfuscated_res_0x7f0f01db));
        aVar.x(u);
        aVar.n(new ti3());
        aVar.m(false);
        aVar.O(R.string.obfuscated_res_0x7f0f01a2, null);
        aVar.X();
    }
}
