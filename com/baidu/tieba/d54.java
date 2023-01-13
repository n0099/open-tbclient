package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        k54 k54Var = new k54();
        k54Var.a = str;
        a54.c().a(new z44(50000, k54Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        k54 k54Var = new k54();
        k54Var.a = str;
        a54.c().a(new z44(90000, k54Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        k54 k54Var = new k54();
        k54Var.a = str;
        a54.c().a(new z44(60000, k54Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        k54 k54Var = new k54();
        k54Var.a = str;
        a54.c().a(new z44(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, k54Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            i54 i54Var = new i54();
            i54Var.b = str;
            i54Var.a = str2;
            a54.c().a(new z44(30000, i54Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            h54 h54Var = new h54();
            h54Var.b = str;
            h54Var.c = i;
            h54Var.d = z ? 1 : 0;
            h54Var.a = str2;
            a54.c().a(new z44(100000, h54Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            h54 h54Var = new h54();
            h54Var.b = str;
            h54Var.c = i;
            h54Var.d = z ? 1 : 0;
            h54Var.a = str2;
            a54.c().a(new z44(70000, h54Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            h54 h54Var = new h54();
            h54Var.b = str;
            h54Var.c = i;
            h54Var.d = z ? 1 : 0;
            h54Var.a = str2;
            a54.c().a(new z44(110000, h54Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            k54 k54Var = new k54();
            k54Var.a = str;
            a54.c().a(new z44(20000, k54Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            k54 k54Var = new k54();
            k54Var.a = str;
            a54.c().a(new z44(10000, k54Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            k54 k54Var = new k54();
            k54Var.a = str;
            a54.c().a(new z44(120000, k54Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            j54 j54Var = new j54();
            j54Var.b = str;
            j54Var.c = i;
            j54Var.a = str2;
            a54.c().a(new z44(80000, j54Var));
        }
    }
}
