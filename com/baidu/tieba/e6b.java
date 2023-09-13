package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, ti5Var) == null) {
            editorTools.d(new gj5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, ti5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, ti5Var) == null) {
            editorTools.d(new vi5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, ti5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, ti5Var) == null) {
            editorTools.d(new mj5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, ti5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, ti5Var) == null) {
            editorTools.d(new rj5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, ti5Var);
        }
    }

    public static sj5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, ti5Var)) == null) {
            sj5 sj5Var = new sj5(tbPageContext.getPageActivity(), 4);
            editorTools.d(sj5Var);
            editorTools.setActionListener(21, ti5Var);
            return sj5Var;
        }
        return (sj5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, ti5Var) == null) {
            editorTools.d(new hl5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, ti5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, ti5Var) == null) {
            editorTools.d(new jl5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, ti5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        CustomResponsedMessage runTask;
        ej5 ej5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, ti5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), ej5.class)) != null && (ej5Var = (ej5) runTask.getData()) != null) {
            ej5Var.o = true;
            ej5Var.l = 9;
            editorTools.d(ej5Var);
            editorTools.setActionListener(25, ti5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, ti5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            ej5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, ti5Var);
            editorTools.setActionListener(3, ti5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        ej5 ej5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), ej5.class)) != null && (ej5Var = (ej5) runTask.getData()) != null) {
            ej5Var.o = true;
            ej5Var.l = 10;
            editorTools.d(ej5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, ti5Var) == null) {
            editorTools.d(new pj5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, ti5Var);
            editorTools.setActionListener(12, ti5Var);
            editorTools.setActionListener(13, ti5Var);
            editorTools.setActionListener(15, ti5Var);
            editorTools.setActionListener(48, ti5Var);
            editorTools.setActionListener(46, ti5Var);
            editorTools.setActionListener(49, ti5Var);
            editorTools.setActionListener(47, ti5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull ti5 ti5Var) {
        ej5 ej5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, ti5Var) == null) && pja.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), ej5.class);
            if (runTask != null && (ej5Var = (ej5) runTask.getData()) != null) {
                ej5Var.l = 3;
                editorTools.d(ej5Var);
            }
            editorTools.setActionListener(10, ti5Var);
            editorTools.setActionListener(11, ti5Var);
        }
    }

    public static c0b m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull ti5 ti5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, ti5Var)) == null) {
            c0b c0bVar = new c0b(tbPageContext.getPageActivity(), str);
            c0bVar.l(0);
            editorTools.d(c0bVar);
            editorTools.setActionListener(43, ti5Var);
            editorTools.setActionListener(55, ti5Var);
            editorTools.setActionListener(66, ti5Var);
            editorTools.setActionListener(77, ti5Var);
            return c0bVar;
        }
        return (c0b) invokeLLLL.objValue;
    }
}
