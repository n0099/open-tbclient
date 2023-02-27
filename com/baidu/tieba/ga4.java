package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ga4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        na4 na4Var = new na4();
        na4Var.a = str;
        da4.c().a(new ca4(50000, na4Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        na4 na4Var = new na4();
        na4Var.a = str;
        da4.c().a(new ca4(90000, na4Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        na4 na4Var = new na4();
        na4Var.a = str;
        da4.c().a(new ca4(60000, na4Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        na4 na4Var = new na4();
        na4Var.a = str;
        da4.c().a(new ca4(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, na4Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            la4 la4Var = new la4();
            la4Var.b = str;
            la4Var.a = str2;
            da4.c().a(new ca4(30000, la4Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ka4 ka4Var = new ka4();
            ka4Var.b = str;
            ka4Var.c = i;
            ka4Var.d = z ? 1 : 0;
            ka4Var.a = str2;
            da4.c().a(new ca4(100000, ka4Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ka4 ka4Var = new ka4();
            ka4Var.b = str;
            ka4Var.c = i;
            ka4Var.d = z ? 1 : 0;
            ka4Var.a = str2;
            da4.c().a(new ca4(70000, ka4Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ka4 ka4Var = new ka4();
            ka4Var.b = str;
            ka4Var.c = i;
            ka4Var.d = z ? 1 : 0;
            ka4Var.a = str2;
            da4.c().a(new ca4(110000, ka4Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            na4 na4Var = new na4();
            na4Var.a = str;
            da4.c().a(new ca4(20000, na4Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            na4 na4Var = new na4();
            na4Var.a = str;
            da4.c().a(new ca4(10000, na4Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            na4 na4Var = new na4();
            na4Var.a = str;
            da4.c().a(new ca4(120000, na4Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            ma4 ma4Var = new ma4();
            ma4Var.b = str;
            ma4Var.c = i;
            ma4Var.a = str2;
            da4.c().a(new ca4(80000, ma4Var));
        }
    }
}
