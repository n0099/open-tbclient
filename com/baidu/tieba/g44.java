package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        n44 n44Var = new n44();
        n44Var.a = str;
        d44.c().a(new c44(50000, n44Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        n44 n44Var = new n44();
        n44Var.a = str;
        d44.c().a(new c44(90000, n44Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        n44 n44Var = new n44();
        n44Var.a = str;
        d44.c().a(new c44(60000, n44Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        n44 n44Var = new n44();
        n44Var.a = str;
        d44.c().a(new c44(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, n44Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            l44 l44Var = new l44();
            l44Var.b = str;
            l44Var.a = str2;
            d44.c().a(new c44(30000, l44Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            k44 k44Var = new k44();
            k44Var.b = str;
            k44Var.c = i;
            k44Var.d = z ? 1 : 0;
            k44Var.a = str2;
            d44.c().a(new c44(100000, k44Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            k44 k44Var = new k44();
            k44Var.b = str;
            k44Var.c = i;
            k44Var.d = z ? 1 : 0;
            k44Var.a = str2;
            d44.c().a(new c44(70000, k44Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            k44 k44Var = new k44();
            k44Var.b = str;
            k44Var.c = i;
            k44Var.d = z ? 1 : 0;
            k44Var.a = str2;
            d44.c().a(new c44(110000, k44Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            n44 n44Var = new n44();
            n44Var.a = str;
            d44.c().a(new c44(20000, n44Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            n44 n44Var = new n44();
            n44Var.a = str;
            d44.c().a(new c44(10000, n44Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            n44 n44Var = new n44();
            n44Var.a = str;
            d44.c().a(new c44(120000, n44Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            m44 m44Var = new m44();
            m44Var.b = str;
            m44Var.c = i;
            m44Var.a = str2;
            d44.c().a(new c44(80000, m44Var));
        }
    }
}
