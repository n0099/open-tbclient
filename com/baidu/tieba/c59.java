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
public class c59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, v45Var) == null) {
            editorTools.d(new h55(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, v45Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        CustomResponsedMessage runTask;
        f55 f55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, v45Var) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), f55.class)) == null || (f55Var = (f55) runTask.getData()) == null) {
            return;
        }
        f55Var.o = true;
        f55Var.l = 9;
        editorTools.d(f55Var);
        editorTools.setActionListener(25, v45Var);
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, v45Var) == null) {
            editorTools.d(new x45(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, v45Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, v45Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            f55 n = editorTools.n(5);
            if (n != null) {
                n.l = 5;
                n.d(true);
            }
            editorTools.setActionListener(24, v45Var);
            editorTools.setActionListener(3, v45Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, v45Var) == null) {
            editorTools.d(new n55(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, v45Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, v45Var) == null) {
            editorTools.d(new s55(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, v45Var);
        }
    }

    public static t55 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, v45Var)) == null) {
            t55 t55Var = new t55(tbPageContext.getPageActivity(), 4);
            editorTools.d(t55Var);
            editorTools.setActionListener(21, v45Var);
            return t55Var;
        }
        return (t55) invokeLLL.objValue;
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, v45Var) == null) {
            editorTools.d(new q55(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, v45Var);
            editorTools.setActionListener(12, v45Var);
            editorTools.setActionListener(13, v45Var);
            editorTools.setActionListener(15, v45Var);
            editorTools.setActionListener(48, v45Var);
            editorTools.setActionListener(46, v45Var);
            editorTools.setActionListener(49, v45Var);
            editorTools.setActionListener(47, v45Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        f55 f55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) || (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), f55.class)) == null || (f55Var = (f55) runTask.getData()) == null) {
            return;
        }
        f55Var.o = true;
        f55Var.l = 10;
        editorTools.d(f55Var);
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, v45Var) == null) {
            editorTools.d(new f75(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, v45Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        f55 f55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, v45Var) == null) && no8.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), f55.class);
            if (runTask != null && (f55Var = (f55) runTask.getData()) != null) {
                f55Var.l = 3;
                editorTools.d(f55Var);
            }
            editorTools.setActionListener(10, v45Var);
            editorTools.setActionListener(11, v45Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, v45Var) == null) {
            editorTools.d(new h75(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, v45Var);
        }
    }

    public static y19 m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull v45 v45Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, v45Var)) == null) {
            y19 y19Var = new y19(tbPageContext.getPageActivity(), str);
            y19Var.k(0);
            y19Var.l(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            editorTools.d(y19Var);
            editorTools.setActionListener(43, v45Var);
            editorTools.setActionListener(55, v45Var);
            editorTools.setActionListener(66, v45Var);
            return y19Var;
        }
        return (y19) invokeLLLL.objValue;
    }
}
