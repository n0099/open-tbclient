package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.o53;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h32 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k63 a;

        public a(k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k63Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                SwanAppActivity w = this.a.w();
                if (w != null && Build.VERSION.SDK_INT >= 21) {
                    w.finishAndRemoveTask();
                }
                System.exit(0);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            a = z;
        }
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            c(context, !a());
        }
    }

    public static void c(Context context, boolean z) {
        k63 M;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) && (M = k63.M()) != null) {
            i32.c(z);
            if (z) {
                i = R.string.obfuscated_res_0x7f0f01da;
            } else {
                i = R.string.obfuscated_res_0x7f0f014e;
            }
            o53.a aVar = new o53.a(context);
            aVar.V(context.getString(R.string.obfuscated_res_0x7f0f018a));
            aVar.x(context.getString(i));
            aVar.n(new sl3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0151, new a(M));
            aVar.X();
        }
    }
}
