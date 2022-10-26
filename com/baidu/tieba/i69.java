package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class i69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, m55Var) == null) {
            editorTools.d(new y55(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, m55Var);
        }
    }

    public static void c(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, m55Var) == null) {
            editorTools.d(new o55(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, m55Var);
        }
    }

    public static void e(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, m55Var) == null) {
            editorTools.d(new e65(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, m55Var);
        }
    }

    public static void f(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, m55Var) == null) {
            editorTools.d(new j65(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, m55Var);
        }
    }

    public static k65 g(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, m55Var)) == null) {
            k65 k65Var = new k65(tbPageContext.getPageActivity(), 4);
            editorTools.d(k65Var);
            editorTools.setActionListener(21, m55Var);
            return k65Var;
        }
        return (k65) invokeLLL.objValue;
    }

    public static void j(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, m55Var) == null) {
            editorTools.d(new w75(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, m55Var);
        }
    }

    public static void l(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, m55Var) == null) {
            editorTools.d(new y75(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, m55Var);
        }
    }

    public static void b(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        CustomResponsedMessage runTask;
        w55 w55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, m55Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage(2001339, tbPageContext.getPageActivity()), w55.class)) != null && (w55Var = (w55) runTask.getData()) != null) {
            w55Var.o = true;
            w55Var.l = 9;
            editorTools.d(w55Var);
            editorTools.setActionListener(25, m55Var);
        }
    }

    public static void d(EditorTools editorTools, m55 m55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, m55Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            w55 n = editorTools.n(5);
            if (n != null) {
                n.l = 5;
                n.d(true);
            }
            editorTools.setActionListener(24, m55Var);
            editorTools.setActionListener(3, m55Var);
        }
    }

    public static void i(TbPageContext tbPageContext, EditorTools editorTools) {
        CustomResponsedMessage runTask;
        w55 w55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage(2001342, tbPageContext.getPageActivity()), w55.class)) != null && (w55Var = (w55) runTask.getData()) != null) {
            w55Var.o = true;
            w55Var.l = 10;
            editorTools.d(w55Var);
        }
    }

    public static void h(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, m55Var) == null) {
            editorTools.d(new h65(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, m55Var);
            editorTools.setActionListener(12, m55Var);
            editorTools.setActionListener(13, m55Var);
            editorTools.setActionListener(15, m55Var);
            editorTools.setActionListener(48, m55Var);
            editorTools.setActionListener(46, m55Var);
            editorTools.setActionListener(49, m55Var);
            editorTools.setActionListener(47, m55Var);
        }
    }

    public static void k(TbPageContext tbPageContext, EditorTools editorTools, m55 m55Var) {
        w55 w55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, m55Var) == null) && jp8.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage(2001448, tbPageContext.getPageActivity()), w55.class);
            if (runTask != null && (w55Var = (w55) runTask.getData()) != null) {
                w55Var.l = 3;
                editorTools.d(w55Var);
            }
            editorTools.setActionListener(10, m55Var);
            editorTools.setActionListener(11, m55Var);
        }
    }

    public static t29 m(TbPageContext tbPageContext, EditorTools editorTools, String str, m55 m55Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, m55Var)) == null) {
            t29 t29Var = new t29(tbPageContext.getPageActivity(), str);
            boolean z = false;
            t29Var.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            t29Var.l(z);
            editorTools.d(t29Var);
            editorTools.setActionListener(43, m55Var);
            editorTools.setActionListener(55, m55Var);
            editorTools.setActionListener(66, m55Var);
            return t29Var;
        }
        return (t29) invokeLLLL.objValue;
    }
}
