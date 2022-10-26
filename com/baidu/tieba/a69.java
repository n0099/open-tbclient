package com.baidu.tieba;

import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, m55Var, str) == null) {
            if ("e1".equals(str)) {
                i69.h(tbPageContext, editorTools, m55Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                i69.j(tbPageContext, editorTools, m55Var);
            } else if ("e3".equals(str)) {
                i69.k(tbPageContext, editorTools, m55Var);
            } else if ("e4".equals(str)) {
                i69.g(tbPageContext, editorTools, m55Var);
            } else if ("e5".equals(str)) {
                i69.d(editorTools, m55Var);
            } else if ("e6".equals(str)) {
                i69.a(tbPageContext, editorTools, m55Var);
            } else if ("e7".equals(str)) {
                i69.l(tbPageContext, editorTools, m55Var);
            } else if ("e8".equals(str)) {
                i69.b(tbPageContext, editorTools, m55Var);
            } else if ("e9".equals(str)) {
                i69.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                i69.c(tbPageContext, editorTools, m55Var);
            } else if ("e11".equals(str)) {
                i69.f(tbPageContext, editorTools, m55Var);
            } else if ("e12".equals(str)) {
                i69.e(tbPageContext, editorTools, m55Var);
            }
        }
    }
}
