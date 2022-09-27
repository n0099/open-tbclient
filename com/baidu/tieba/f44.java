package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            m44 m44Var = new m44();
            m44Var.a = str;
            c44.c().a(new b44(50000, m44Var));
        }
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            m44 m44Var = new m44();
            m44Var.a = str;
            c44.c().a(new b44(90000, m44Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            j44 j44Var = new j44();
            j44Var.b = str;
            j44Var.c = i;
            j44Var.d = z ? 1 : 0;
            j44Var.a = str2;
            c44.c().a(new b44(100000, j44Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            m44 m44Var = new m44();
            m44Var.a = str;
            c44.c().a(new b44(20000, m44Var));
        }
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            m44 m44Var = new m44();
            m44Var.a = str;
            c44.c().a(new b44(60000, m44Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            m44 m44Var = new m44();
            m44Var.a = str;
            c44.c().a(new b44(10000, m44Var));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            m44 m44Var = new m44();
            m44Var.a = str;
            c44.c().a(new b44(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, m44Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            j44 j44Var = new j44();
            j44Var.b = str;
            j44Var.c = i;
            j44Var.d = z ? 1 : 0;
            j44Var.a = str2;
            c44.c().a(new b44(70000, j44Var));
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            k44 k44Var = new k44();
            k44Var.b = str;
            k44Var.a = str2;
            c44.c().a(new b44(30000, k44Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            l44 l44Var = new l44();
            l44Var.b = str;
            l44Var.c = i;
            l44Var.a = str2;
            c44.c().a(new b44(80000, l44Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            j44 j44Var = new j44();
            j44Var.b = str;
            j44Var.c = i;
            j44Var.d = z ? 1 : 0;
            j44Var.a = str2;
            c44.c().a(new b44(110000, j44Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            m44 m44Var = new m44();
            m44Var.a = str;
            c44.c().a(new b44(120000, m44Var));
        }
    }
}
