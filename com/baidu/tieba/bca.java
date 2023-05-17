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
public class bca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, te5Var) == null) {
            editorTools.d(new ff5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, te5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, te5Var) == null) {
            editorTools.d(new ve5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, te5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, te5Var) == null) {
            editorTools.d(new lf5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, te5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, te5Var) == null) {
            editorTools.d(new qf5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, te5Var);
        }
    }

    public static rf5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, te5Var)) == null) {
            rf5 rf5Var = new rf5(tbPageContext.getPageActivity(), 4);
            editorTools.d(rf5Var);
            editorTools.setActionListener(21, te5Var);
            return rf5Var;
        }
        return (rf5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, te5Var) == null) {
            editorTools.d(new eh5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, te5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, te5Var) == null) {
            editorTools.d(new gh5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, te5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        CustomResponsedMessage runTask;
        df5 df5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, te5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), df5.class)) != null && (df5Var = (df5) runTask.getData()) != null) {
            df5Var.o = true;
            df5Var.l = 9;
            editorTools.d(df5Var);
            editorTools.setActionListener(25, te5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, te5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            df5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, te5Var);
            editorTools.setActionListener(3, te5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        df5 df5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), df5.class)) != null && (df5Var = (df5) runTask.getData()) != null) {
            df5Var.o = true;
            df5Var.l = 10;
            editorTools.d(df5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, te5Var) == null) {
            editorTools.d(new of5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, te5Var);
            editorTools.setActionListener(12, te5Var);
            editorTools.setActionListener(13, te5Var);
            editorTools.setActionListener(15, te5Var);
            editorTools.setActionListener(48, te5Var);
            editorTools.setActionListener(46, te5Var);
            editorTools.setActionListener(49, te5Var);
            editorTools.setActionListener(47, te5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull te5 te5Var) {
        df5 df5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, te5Var) == null) && lt9.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), df5.class);
            if (runTask != null && (df5Var = (df5) runTask.getData()) != null) {
                df5Var.l = 3;
                editorTools.d(df5Var);
            }
            editorTools.setActionListener(10, te5Var);
            editorTools.setActionListener(11, te5Var);
        }
    }

    public static g8a m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull te5 te5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, te5Var)) == null) {
            g8a g8aVar = new g8a(tbPageContext.getPageActivity(), str);
            boolean z = false;
            g8aVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            g8aVar.l(z);
            editorTools.d(g8aVar);
            editorTools.setActionListener(43, te5Var);
            editorTools.setActionListener(55, te5Var);
            editorTools.setActionListener(66, te5Var);
            return g8aVar;
        }
        return (g8a) invokeLLLL.objValue;
    }
}
