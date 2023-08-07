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
public class exa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, mh5Var) == null) {
            editorTools.d(new zh5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, mh5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, mh5Var) == null) {
            editorTools.d(new oh5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, mh5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, mh5Var) == null) {
            editorTools.d(new fi5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, mh5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, mh5Var) == null) {
            editorTools.d(new ki5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, mh5Var);
        }
    }

    public static li5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, mh5Var)) == null) {
            li5 li5Var = new li5(tbPageContext.getPageActivity(), 4);
            editorTools.d(li5Var);
            editorTools.setActionListener(21, mh5Var);
            return li5Var;
        }
        return (li5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, mh5Var) == null) {
            editorTools.d(new ak5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, mh5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, mh5Var) == null) {
            editorTools.d(new ck5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, mh5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        CustomResponsedMessage runTask;
        xh5 xh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, mh5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), xh5.class)) != null && (xh5Var = (xh5) runTask.getData()) != null) {
            xh5Var.o = true;
            xh5Var.l = 9;
            editorTools.d(xh5Var);
            editorTools.setActionListener(25, mh5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, mh5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            xh5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, mh5Var);
            editorTools.setActionListener(3, mh5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        xh5 xh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), xh5.class)) != null && (xh5Var = (xh5) runTask.getData()) != null) {
            xh5Var.o = true;
            xh5Var.l = 10;
            editorTools.d(xh5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, mh5Var) == null) {
            editorTools.d(new ii5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, mh5Var);
            editorTools.setActionListener(12, mh5Var);
            editorTools.setActionListener(13, mh5Var);
            editorTools.setActionListener(15, mh5Var);
            editorTools.setActionListener(48, mh5Var);
            editorTools.setActionListener(46, mh5Var);
            editorTools.setActionListener(49, mh5Var);
            editorTools.setActionListener(47, mh5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull mh5 mh5Var) {
        xh5 xh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, mh5Var) == null) && mda.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), xh5.class);
            if (runTask != null && (xh5Var = (xh5) runTask.getData()) != null) {
                xh5Var.l = 3;
                editorTools.d(xh5Var);
            }
            editorTools.setActionListener(10, mh5Var);
            editorTools.setActionListener(11, mh5Var);
        }
    }

    public static jta m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull mh5 mh5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, mh5Var)) == null) {
            jta jtaVar = new jta(tbPageContext.getPageActivity(), str);
            boolean z = false;
            jtaVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            jtaVar.l(z);
            editorTools.d(jtaVar);
            editorTools.setActionListener(43, mh5Var);
            editorTools.setActionListener(55, mh5Var);
            editorTools.setActionListener(66, mh5Var);
            editorTools.setActionListener(77, mh5Var);
            return jtaVar;
        }
        return (jta) invokeLLLL.objValue;
    }
}
