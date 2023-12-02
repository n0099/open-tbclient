package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, ie5Var, str) == null) {
            if ("e1".equals(str)) {
                okb.h(tbPageContext, editorTools, ie5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                okb.j(tbPageContext, editorTools, ie5Var);
            } else if ("e3".equals(str)) {
                okb.k(tbPageContext, editorTools, ie5Var);
            } else if ("e4".equals(str)) {
                okb.g(tbPageContext, editorTools, ie5Var);
            } else if ("e5".equals(str)) {
                okb.d(editorTools, ie5Var);
            } else if ("e6".equals(str)) {
                okb.a(tbPageContext, editorTools, ie5Var);
            } else if ("e7".equals(str)) {
                okb.l(tbPageContext, editorTools, ie5Var);
            } else if ("e8".equals(str)) {
                okb.b(tbPageContext, editorTools, ie5Var);
            } else if ("e9".equals(str)) {
                okb.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                okb.c(tbPageContext, editorTools, ie5Var);
            } else if ("e11".equals(str)) {
                okb.f(tbPageContext, editorTools, ie5Var);
            } else if ("e12".equals(str)) {
                okb.e(tbPageContext, editorTools, ie5Var);
            }
        }
    }
}
