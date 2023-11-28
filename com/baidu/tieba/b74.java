package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes5.dex */
public class b74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        i74 i74Var = new i74();
        i74Var.a = str;
        y64.c().a(new x64(50000, i74Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        i74 i74Var = new i74();
        i74Var.a = str;
        y64.c().a(new x64(90000, i74Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        i74 i74Var = new i74();
        i74Var.a = str;
        y64.c().a(new x64(60000, i74Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        i74 i74Var = new i74();
        i74Var.a = str;
        y64.c().a(new x64(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, i74Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            g74 g74Var = new g74();
            g74Var.b = str;
            g74Var.a = str2;
            y64.c().a(new x64(30000, g74Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            f74 f74Var = new f74();
            f74Var.b = str;
            f74Var.c = i;
            f74Var.d = z ? 1 : 0;
            f74Var.a = str2;
            y64.c().a(new x64(DefaultOggSeeker.MATCH_BYTE_RANGE, f74Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            f74 f74Var = new f74();
            f74Var.b = str;
            f74Var.c = i;
            f74Var.d = z ? 1 : 0;
            f74Var.a = str2;
            y64.c().a(new x64(70000, f74Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            f74 f74Var = new f74();
            f74Var.b = str;
            f74Var.c = i;
            f74Var.d = z ? 1 : 0;
            f74Var.a = str2;
            y64.c().a(new x64(110000, f74Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            i74 i74Var = new i74();
            i74Var.a = str;
            y64.c().a(new x64(20000, i74Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            i74 i74Var = new i74();
            i74Var.a = str;
            y64.c().a(new x64(10000, i74Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            i74 i74Var = new i74();
            i74Var.a = str;
            y64.c().a(new x64(120000, i74Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            h74 h74Var = new h74();
            h74Var.b = str;
            h74Var.c = i;
            h74Var.a = str2;
            y64.c().a(new x64(80000, h74Var));
        }
    }
}
