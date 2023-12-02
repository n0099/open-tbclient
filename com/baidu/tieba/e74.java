package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes5.dex */
public class e74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        l74 l74Var = new l74();
        l74Var.a = str;
        b74.c().a(new a74(50000, l74Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        l74 l74Var = new l74();
        l74Var.a = str;
        b74.c().a(new a74(90000, l74Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        l74 l74Var = new l74();
        l74Var.a = str;
        b74.c().a(new a74(60000, l74Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        l74 l74Var = new l74();
        l74Var.a = str;
        b74.c().a(new a74(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, l74Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            j74 j74Var = new j74();
            j74Var.b = str;
            j74Var.a = str2;
            b74.c().a(new a74(30000, j74Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            i74 i74Var = new i74();
            i74Var.b = str;
            i74Var.c = i;
            i74Var.d = z ? 1 : 0;
            i74Var.a = str2;
            b74.c().a(new a74(DefaultOggSeeker.MATCH_BYTE_RANGE, i74Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            i74 i74Var = new i74();
            i74Var.b = str;
            i74Var.c = i;
            i74Var.d = z ? 1 : 0;
            i74Var.a = str2;
            b74.c().a(new a74(70000, i74Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            i74 i74Var = new i74();
            i74Var.b = str;
            i74Var.c = i;
            i74Var.d = z ? 1 : 0;
            i74Var.a = str2;
            b74.c().a(new a74(110000, i74Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            l74 l74Var = new l74();
            l74Var.a = str;
            b74.c().a(new a74(20000, l74Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            l74 l74Var = new l74();
            l74Var.a = str;
            b74.c().a(new a74(10000, l74Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            l74 l74Var = new l74();
            l74Var.a = str;
            b74.c().a(new a74(120000, l74Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            k74 k74Var = new k74();
            k74Var.b = str;
            k74Var.c = i;
            k74Var.a = str2;
            b74.c().a(new a74(80000, k74Var));
        }
    }
}
