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
/* loaded from: classes4.dex */
public class ew9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, mb5Var) == null) {
            editorTools.d(new yb5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, mb5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, mb5Var) == null) {
            editorTools.d(new ob5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, mb5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, mb5Var) == null) {
            editorTools.d(new ec5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, mb5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, mb5Var) == null) {
            editorTools.d(new jc5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, mb5Var);
        }
    }

    public static kc5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, mb5Var)) == null) {
            kc5 kc5Var = new kc5(tbPageContext.getPageActivity(), 4);
            editorTools.d(kc5Var);
            editorTools.setActionListener(21, mb5Var);
            return kc5Var;
        }
        return (kc5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, mb5Var) == null) {
            editorTools.d(new xd5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, mb5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, mb5Var) == null) {
            editorTools.d(new zd5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, mb5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        CustomResponsedMessage runTask;
        wb5 wb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, mb5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), wb5.class)) != null && (wb5Var = (wb5) runTask.getData()) != null) {
            wb5Var.o = true;
            wb5Var.l = 9;
            editorTools.d(wb5Var);
            editorTools.setActionListener(25, mb5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, mb5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            wb5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, mb5Var);
            editorTools.setActionListener(3, mb5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        wb5 wb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), wb5.class)) != null && (wb5Var = (wb5) runTask.getData()) != null) {
            wb5Var.o = true;
            wb5Var.l = 10;
            editorTools.d(wb5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, mb5Var) == null) {
            editorTools.d(new hc5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, mb5Var);
            editorTools.setActionListener(12, mb5Var);
            editorTools.setActionListener(13, mb5Var);
            editorTools.setActionListener(15, mb5Var);
            editorTools.setActionListener(48, mb5Var);
            editorTools.setActionListener(46, mb5Var);
            editorTools.setActionListener(49, mb5Var);
            editorTools.setActionListener(47, mb5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mb5 mb5Var) {
        wb5 wb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, mb5Var) == null) && vd9.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), wb5.class);
            if (runTask != null && (wb5Var = (wb5) runTask.getData()) != null) {
                wb5Var.l = 3;
                editorTools.d(wb5Var);
            }
            editorTools.setActionListener(10, mb5Var);
            editorTools.setActionListener(11, mb5Var);
        }
    }

    public static js9 m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull mb5 mb5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, mb5Var)) == null) {
            js9 js9Var = new js9(tbPageContext.getPageActivity(), str);
            boolean z = false;
            js9Var.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            js9Var.l(z);
            editorTools.d(js9Var);
            editorTools.setActionListener(43, mb5Var);
            editorTools.setActionListener(55, mb5Var);
            editorTools.setActionListener(66, mb5Var);
            return js9Var;
        }
        return (js9) invokeLLLL.objValue;
    }
}
