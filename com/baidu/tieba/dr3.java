package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.za3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dr3 implements za3.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ dr3 b;

        public a(dr3 dr3Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr3Var, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dr3Var;
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.a == null) {
                    this.b.a = new FrameLayout(this.a.getContext());
                    this.b.a.setBackgroundResource(R.color.obfuscated_res_0x7f060449);
                }
                this.a.removeView(this.b.a);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.a.addView(this.b.a, layoutParams);
            }
        }
    }

    public dr3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public final void e(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) && viewGroup != null && (frameLayout = this.a) != null) {
            viewGroup.removeView(frameLayout);
            this.a = null;
        }
    }

    public final void f(za3 za3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, za3Var) == null) {
            Context context = za3Var.getContext();
            if (za3Var.getContext() instanceof ContextWrapper) {
                context = ((ContextWrapper) za3Var.getContext()).getBaseContext();
            }
            if (context instanceof Activity) {
                eo3.b((Activity) context, za3Var);
            }
        }
    }

    public final void d(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, view2) != null) || viewGroup == null || view2 == null || !(viewGroup instanceof FrameLayout)) {
            return;
        }
        view2.post(new a(this, viewGroup));
    }

    @Override // com.baidu.tieba.za3.c
    public void a(za3 za3Var, za3.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, za3Var, bVar) != null) || za3Var == null || bVar == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        f(za3Var);
        ViewGroup viewGroup = (ViewGroup) za3Var.findViewById(16908290);
        if (viewGroup != null) {
            if (cv2.M().a()) {
                d(viewGroup, bVar.r);
            } else {
                e(viewGroup);
            }
        }
    }
}
