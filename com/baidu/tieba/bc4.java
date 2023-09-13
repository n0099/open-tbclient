package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes5.dex */
public class bc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ic4 ic4Var = new ic4();
        ic4Var.a = str;
        yb4.c().a(new xb4(50000, ic4Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ic4 ic4Var = new ic4();
        ic4Var.a = str;
        yb4.c().a(new xb4(90000, ic4Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ic4 ic4Var = new ic4();
        ic4Var.a = str;
        yb4.c().a(new xb4(60000, ic4Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ic4 ic4Var = new ic4();
        ic4Var.a = str;
        yb4.c().a(new xb4(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, ic4Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            gc4 gc4Var = new gc4();
            gc4Var.b = str;
            gc4Var.a = str2;
            yb4.c().a(new xb4(30000, gc4Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            fc4 fc4Var = new fc4();
            fc4Var.b = str;
            fc4Var.c = i;
            fc4Var.d = z ? 1 : 0;
            fc4Var.a = str2;
            yb4.c().a(new xb4(DefaultOggSeeker.MATCH_BYTE_RANGE, fc4Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            fc4 fc4Var = new fc4();
            fc4Var.b = str;
            fc4Var.c = i;
            fc4Var.d = z ? 1 : 0;
            fc4Var.a = str2;
            yb4.c().a(new xb4(70000, fc4Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            fc4 fc4Var = new fc4();
            fc4Var.b = str;
            fc4Var.c = i;
            fc4Var.d = z ? 1 : 0;
            fc4Var.a = str2;
            yb4.c().a(new xb4(110000, fc4Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            ic4 ic4Var = new ic4();
            ic4Var.a = str;
            yb4.c().a(new xb4(20000, ic4Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            ic4 ic4Var = new ic4();
            ic4Var.a = str;
            yb4.c().a(new xb4(10000, ic4Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            ic4 ic4Var = new ic4();
            ic4Var.a = str;
            yb4.c().a(new xb4(120000, ic4Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            hc4 hc4Var = new hc4();
            hc4Var.b = str;
            hc4Var.c = i;
            hc4Var.a = str2;
            yb4.c().a(new xb4(80000, hc4Var));
        }
    }
}
