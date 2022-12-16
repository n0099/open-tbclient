package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull n65 n65Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, editorTools, n65Var, str) == null) {
            if ("e1".equals(str)) {
                mb9.h(tbPageContext, editorTools, n65Var);
            } else if (Config.SESSTION_TRACK_END_TIME.equals(str)) {
                mb9.j(tbPageContext, editorTools, n65Var);
            } else if ("e3".equals(str)) {
                mb9.k(tbPageContext, editorTools, n65Var);
            } else if ("e4".equals(str)) {
                mb9.g(tbPageContext, editorTools, n65Var);
            } else if ("e5".equals(str)) {
                mb9.d(editorTools, n65Var);
            } else if ("e6".equals(str)) {
                mb9.a(tbPageContext, editorTools, n65Var);
            } else if ("e7".equals(str)) {
                mb9.l(tbPageContext, editorTools, n65Var);
            } else if ("e8".equals(str)) {
                mb9.b(tbPageContext, editorTools, n65Var);
            } else if ("e9".equals(str)) {
                mb9.i(tbPageContext, editorTools);
            } else if ("e10".equals(str)) {
                mb9.c(tbPageContext, editorTools, n65Var);
            } else if ("e11".equals(str)) {
                mb9.f(tbPageContext, editorTools, n65Var);
            } else if ("e12".equals(str)) {
                mb9.e(tbPageContext, editorTools, n65Var);
            }
        }
    }
}
