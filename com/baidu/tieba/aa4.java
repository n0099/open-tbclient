package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes4.dex */
public class aa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ha4 ha4Var = new ha4();
        ha4Var.a = str;
        x94.c().a(new w94(50000, ha4Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ha4 ha4Var = new ha4();
        ha4Var.a = str;
        x94.c().a(new w94(90000, ha4Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ha4 ha4Var = new ha4();
        ha4Var.a = str;
        x94.c().a(new w94(60000, ha4Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ha4 ha4Var = new ha4();
        ha4Var.a = str;
        x94.c().a(new w94(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, ha4Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            fa4 fa4Var = new fa4();
            fa4Var.b = str;
            fa4Var.a = str2;
            x94.c().a(new w94(30000, fa4Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ea4 ea4Var = new ea4();
            ea4Var.b = str;
            ea4Var.c = i;
            ea4Var.d = z ? 1 : 0;
            ea4Var.a = str2;
            x94.c().a(new w94(DefaultOggSeeker.MATCH_BYTE_RANGE, ea4Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ea4 ea4Var = new ea4();
            ea4Var.b = str;
            ea4Var.c = i;
            ea4Var.d = z ? 1 : 0;
            ea4Var.a = str2;
            x94.c().a(new w94(70000, ea4Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ea4 ea4Var = new ea4();
            ea4Var.b = str;
            ea4Var.c = i;
            ea4Var.d = z ? 1 : 0;
            ea4Var.a = str2;
            x94.c().a(new w94(110000, ea4Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            ha4 ha4Var = new ha4();
            ha4Var.a = str;
            x94.c().a(new w94(20000, ha4Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            ha4 ha4Var = new ha4();
            ha4Var.a = str;
            x94.c().a(new w94(10000, ha4Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            ha4 ha4Var = new ha4();
            ha4Var.a = str;
            x94.c().a(new w94(120000, ha4Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            ga4 ga4Var = new ga4();
            ga4Var.b = str;
            ga4Var.c = i;
            ga4Var.a = str2;
            x94.c().a(new w94(80000, ga4Var));
        }
    }
}
