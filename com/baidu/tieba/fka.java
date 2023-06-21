package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull zh5 zh5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, zh5Var, str) == null) {
            if ("e1".equals(str)) {
                nka.h(tbPageContext, editorTools, zh5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                nka.j(tbPageContext, editorTools, zh5Var);
            } else if ("e3".equals(str)) {
                nka.k(tbPageContext, editorTools, zh5Var);
            } else if ("e4".equals(str)) {
                nka.g(tbPageContext, editorTools, zh5Var);
            } else if ("e5".equals(str)) {
                nka.d(editorTools, zh5Var);
            } else if ("e6".equals(str)) {
                nka.a(tbPageContext, editorTools, zh5Var);
            } else if ("e7".equals(str)) {
                nka.l(tbPageContext, editorTools, zh5Var);
            } else if ("e8".equals(str)) {
                nka.b(tbPageContext, editorTools, zh5Var);
            } else if ("e9".equals(str)) {
                nka.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                nka.c(tbPageContext, editorTools, zh5Var);
            } else if ("e11".equals(str)) {
                nka.f(tbPageContext, editorTools, zh5Var);
            } else if ("e12".equals(str)) {
                nka.e(tbPageContext, editorTools, zh5Var);
            }
        }
    }
}
