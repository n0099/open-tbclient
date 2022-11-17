package com.baidu.tieba;

import androidx.annotation.NonNull;
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
/* loaded from: classes3.dex */
public class d89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, m65Var) == null) {
            editorTools.d(new y65(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, m65Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, m65Var) == null) {
            editorTools.d(new o65(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, m65Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, m65Var) == null) {
            editorTools.d(new e75(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, m65Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, m65Var) == null) {
            editorTools.d(new j75(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, m65Var);
        }
    }

    public static k75 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, m65Var)) == null) {
            k75 k75Var = new k75(tbPageContext.getPageActivity(), 4);
            editorTools.d(k75Var);
            editorTools.setActionListener(21, m65Var);
            return k75Var;
        }
        return (k75) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, m65Var) == null) {
            editorTools.d(new w85(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, m65Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, m65Var) == null) {
            editorTools.d(new y85(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, m65Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        CustomResponsedMessage runTask;
        w65 w65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, m65Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), w65.class)) != null && (w65Var = (w65) runTask.getData()) != null) {
            w65Var.o = true;
            w65Var.l = 9;
            editorTools.d(w65Var);
            editorTools.setActionListener(25, m65Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, m65Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            w65 n = editorTools.n(5);
            if (n != null) {
                n.l = 5;
                n.d(true);
            }
            editorTools.setActionListener(24, m65Var);
            editorTools.setActionListener(3, m65Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        w65 w65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), w65.class)) != null && (w65Var = (w65) runTask.getData()) != null) {
            w65Var.o = true;
            w65Var.l = 10;
            editorTools.d(w65Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, m65Var) == null) {
            editorTools.d(new h75(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, m65Var);
            editorTools.setActionListener(12, m65Var);
            editorTools.setActionListener(13, m65Var);
            editorTools.setActionListener(15, m65Var);
            editorTools.setActionListener(48, m65Var);
            editorTools.setActionListener(46, m65Var);
            editorTools.setActionListener(49, m65Var);
            editorTools.setActionListener(47, m65Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull m65 m65Var) {
        w65 w65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, m65Var) == null) && fr8.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), w65.class);
            if (runTask != null && (w65Var = (w65) runTask.getData()) != null) {
                w65Var.l = 3;
                editorTools.d(w65Var);
            }
            editorTools.setActionListener(10, m65Var);
            editorTools.setActionListener(11, m65Var);
        }
    }

    public static o49 m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull m65 m65Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, m65Var)) == null) {
            o49 o49Var = new o49(tbPageContext.getPageActivity(), str);
            boolean z = false;
            o49Var.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            o49Var.l(z);
            editorTools.d(o49Var);
            editorTools.setActionListener(43, m65Var);
            editorTools.setActionListener(55, m65Var);
            editorTools.setActionListener(66, m65Var);
            return o49Var;
        }
        return (o49) invokeLLLL.objValue;
    }
}
