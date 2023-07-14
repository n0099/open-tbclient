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
/* loaded from: classes5.dex */
public class bya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, aj5Var) == null) {
            editorTools.d(new nj5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, aj5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, aj5Var) == null) {
            editorTools.d(new cj5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, aj5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, aj5Var) == null) {
            editorTools.d(new tj5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, aj5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, aj5Var) == null) {
            editorTools.d(new yj5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, aj5Var);
        }
    }

    public static zj5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, aj5Var)) == null) {
            zj5 zj5Var = new zj5(tbPageContext.getPageActivity(), 4);
            editorTools.d(zj5Var);
            editorTools.setActionListener(21, aj5Var);
            return zj5Var;
        }
        return (zj5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, aj5Var) == null) {
            editorTools.d(new ol5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, aj5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, aj5Var) == null) {
            editorTools.d(new ql5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, aj5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        CustomResponsedMessage runTask;
        lj5 lj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, aj5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), lj5.class)) != null && (lj5Var = (lj5) runTask.getData()) != null) {
            lj5Var.o = true;
            lj5Var.l = 9;
            editorTools.d(lj5Var);
            editorTools.setActionListener(25, aj5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, aj5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            lj5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, aj5Var);
            editorTools.setActionListener(3, aj5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        lj5 lj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), lj5.class)) != null && (lj5Var = (lj5) runTask.getData()) != null) {
            lj5Var.o = true;
            lj5Var.l = 10;
            editorTools.d(lj5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, aj5Var) == null) {
            editorTools.d(new wj5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, aj5Var);
            editorTools.setActionListener(12, aj5Var);
            editorTools.setActionListener(13, aj5Var);
            editorTools.setActionListener(15, aj5Var);
            editorTools.setActionListener(48, aj5Var);
            editorTools.setActionListener(46, aj5Var);
            editorTools.setActionListener(49, aj5Var);
            editorTools.setActionListener(47, aj5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull aj5 aj5Var) {
        lj5 lj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, aj5Var) == null) && sea.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), lj5.class);
            if (runTask != null && (lj5Var = (lj5) runTask.getData()) != null) {
                lj5Var.l = 3;
                editorTools.d(lj5Var);
            }
            editorTools.setActionListener(10, aj5Var);
            editorTools.setActionListener(11, aj5Var);
        }
    }

    public static gua m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull aj5 aj5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, aj5Var)) == null) {
            gua guaVar = new gua(tbPageContext.getPageActivity(), str);
            boolean z = false;
            guaVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            guaVar.l(z);
            editorTools.d(guaVar);
            editorTools.setActionListener(43, aj5Var);
            editorTools.setActionListener(55, aj5Var);
            editorTools.setActionListener(66, aj5Var);
            editorTools.setActionListener(77, aj5Var);
            return guaVar;
        }
        return (gua) invokeLLLL.objValue;
    }
}
