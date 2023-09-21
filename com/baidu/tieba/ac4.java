package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes5.dex */
public class ac4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        hc4 hc4Var = new hc4();
        hc4Var.a = str;
        xb4.c().a(new wb4(50000, hc4Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        hc4 hc4Var = new hc4();
        hc4Var.a = str;
        xb4.c().a(new wb4(90000, hc4Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        hc4 hc4Var = new hc4();
        hc4Var.a = str;
        xb4.c().a(new wb4(60000, hc4Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        hc4 hc4Var = new hc4();
        hc4Var.a = str;
        xb4.c().a(new wb4(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, hc4Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            fc4 fc4Var = new fc4();
            fc4Var.b = str;
            fc4Var.a = str2;
            xb4.c().a(new wb4(30000, fc4Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ec4 ec4Var = new ec4();
            ec4Var.b = str;
            ec4Var.c = i;
            ec4Var.d = z ? 1 : 0;
            ec4Var.a = str2;
            xb4.c().a(new wb4(DefaultOggSeeker.MATCH_BYTE_RANGE, ec4Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ec4 ec4Var = new ec4();
            ec4Var.b = str;
            ec4Var.c = i;
            ec4Var.d = z ? 1 : 0;
            ec4Var.a = str2;
            xb4.c().a(new wb4(70000, ec4Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ec4 ec4Var = new ec4();
            ec4Var.b = str;
            ec4Var.c = i;
            ec4Var.d = z ? 1 : 0;
            ec4Var.a = str2;
            xb4.c().a(new wb4(110000, ec4Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            hc4 hc4Var = new hc4();
            hc4Var.a = str;
            xb4.c().a(new wb4(20000, hc4Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            hc4 hc4Var = new hc4();
            hc4Var.a = str;
            xb4.c().a(new wb4(10000, hc4Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            hc4 hc4Var = new hc4();
            hc4Var.a = str;
            xb4.c().a(new wb4(120000, hc4Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            gc4 gc4Var = new gc4();
            gc4Var.b = str;
            gc4Var.c = i;
            gc4Var.a = str2;
            xb4.c().a(new wb4(80000, gc4Var));
        }
    }
}
