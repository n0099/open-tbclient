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
public class dpa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, di5Var) == null) {
            editorTools.d(new qi5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, di5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, di5Var) == null) {
            editorTools.d(new fi5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, di5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, di5Var) == null) {
            editorTools.d(new wi5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, di5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, di5Var) == null) {
            editorTools.d(new bj5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, di5Var);
        }
    }

    public static cj5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, di5Var)) == null) {
            cj5 cj5Var = new cj5(tbPageContext.getPageActivity(), 4);
            editorTools.d(cj5Var);
            editorTools.setActionListener(21, di5Var);
            return cj5Var;
        }
        return (cj5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, di5Var) == null) {
            editorTools.d(new qk5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, di5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, di5Var) == null) {
            editorTools.d(new sk5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, di5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        CustomResponsedMessage runTask;
        oi5 oi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, di5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), oi5.class)) != null && (oi5Var = (oi5) runTask.getData()) != null) {
            oi5Var.o = true;
            oi5Var.l = 9;
            editorTools.d(oi5Var);
            editorTools.setActionListener(25, di5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, di5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            oi5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, di5Var);
            editorTools.setActionListener(3, di5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        oi5 oi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), oi5.class)) != null && (oi5Var = (oi5) runTask.getData()) != null) {
            oi5Var.o = true;
            oi5Var.l = 10;
            editorTools.d(oi5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, di5Var) == null) {
            editorTools.d(new zi5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, di5Var);
            editorTools.setActionListener(12, di5Var);
            editorTools.setActionListener(13, di5Var);
            editorTools.setActionListener(15, di5Var);
            editorTools.setActionListener(48, di5Var);
            editorTools.setActionListener(46, di5Var);
            editorTools.setActionListener(49, di5Var);
            editorTools.setActionListener(47, di5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull di5 di5Var) {
        oi5 oi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, di5Var) == null) && h6a.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), oi5.class);
            if (runTask != null && (oi5Var = (oi5) runTask.getData()) != null) {
                oi5Var.l = 3;
                editorTools.d(oi5Var);
            }
            editorTools.setActionListener(10, di5Var);
            editorTools.setActionListener(11, di5Var);
        }
    }

    public static ila m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull di5 di5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, di5Var)) == null) {
            ila ilaVar = new ila(tbPageContext.getPageActivity(), str);
            boolean z = false;
            ilaVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            ilaVar.l(z);
            editorTools.d(ilaVar);
            editorTools.setActionListener(43, di5Var);
            editorTools.setActionListener(55, di5Var);
            editorTools.setActionListener(66, di5Var);
            editorTools.setActionListener(77, di5Var);
            return ilaVar;
        }
        return (ila) invokeLLLL.objValue;
    }
}
