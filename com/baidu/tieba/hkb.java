package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ie5 ie5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, ie5Var, str) == null) {
            if ("e1".equals(str)) {
                pkb.h(tbPageContext, editorTools, ie5Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                pkb.j(tbPageContext, editorTools, ie5Var);
            } else if ("e3".equals(str)) {
                pkb.k(tbPageContext, editorTools, ie5Var);
            } else if ("e4".equals(str)) {
                pkb.g(tbPageContext, editorTools, ie5Var);
            } else if ("e5".equals(str)) {
                pkb.d(editorTools, ie5Var);
            } else if ("e6".equals(str)) {
                pkb.a(tbPageContext, editorTools, ie5Var);
            } else if ("e7".equals(str)) {
                pkb.l(tbPageContext, editorTools, ie5Var);
            } else if ("e8".equals(str)) {
                pkb.b(tbPageContext, editorTools, ie5Var);
            } else if ("e9".equals(str)) {
                pkb.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                pkb.c(tbPageContext, editorTools, ie5Var);
            } else if ("e11".equals(str)) {
                pkb.f(tbPageContext, editorTools, ie5Var);
            } else if ("e12".equals(str)) {
                pkb.e(tbPageContext, editorTools, ie5Var);
            }
        }
    }
}
