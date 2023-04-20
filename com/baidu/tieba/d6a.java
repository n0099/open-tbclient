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
public class d6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, rc5Var) == null) {
            editorTools.d(new dd5(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, rc5Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, rc5Var) == null) {
            editorTools.d(new tc5(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, rc5Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, rc5Var) == null) {
            editorTools.d(new jd5(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, rc5Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, rc5Var) == null) {
            editorTools.d(new od5(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, rc5Var);
        }
    }

    public static pd5 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, rc5Var)) == null) {
            pd5 pd5Var = new pd5(tbPageContext.getPageActivity(), 4);
            editorTools.d(pd5Var);
            editorTools.setActionListener(21, rc5Var);
            return pd5Var;
        }
        return (pd5) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, rc5Var) == null) {
            editorTools.d(new cf5(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, rc5Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, rc5Var) == null) {
            editorTools.d(new ef5(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, rc5Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        CustomResponsedMessage runTask;
        bd5 bd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, rc5Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), bd5.class)) != null && (bd5Var = (bd5) runTask.getData()) != null) {
            bd5Var.o = true;
            bd5Var.l = 9;
            editorTools.d(bd5Var);
            editorTools.setActionListener(25, rc5Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, rc5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            bd5 p = editorTools.p(5);
            if (p != null) {
                p.l = 5;
                p.d(true);
            }
            editorTools.setActionListener(24, rc5Var);
            editorTools.setActionListener(3, rc5Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        bd5 bd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), bd5.class)) != null && (bd5Var = (bd5) runTask.getData()) != null) {
            bd5Var.o = true;
            bd5Var.l = 10;
            editorTools.d(bd5Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, rc5Var) == null) {
            editorTools.d(new md5(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, rc5Var);
            editorTools.setActionListener(12, rc5Var);
            editorTools.setActionListener(13, rc5Var);
            editorTools.setActionListener(15, rc5Var);
            editorTools.setActionListener(48, rc5Var);
            editorTools.setActionListener(46, rc5Var);
            editorTools.setActionListener(49, rc5Var);
            editorTools.setActionListener(47, rc5Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull rc5 rc5Var) {
        bd5 bd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, rc5Var) == null) && un9.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), bd5.class);
            if (runTask != null && (bd5Var = (bd5) runTask.getData()) != null) {
                bd5Var.l = 3;
                editorTools.d(bd5Var);
            }
            editorTools.setActionListener(10, rc5Var);
            editorTools.setActionListener(11, rc5Var);
        }
    }

    public static i2a m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull rc5 rc5Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, rc5Var)) == null) {
            i2a i2aVar = new i2a(tbPageContext.getPageActivity(), str);
            boolean z = false;
            i2aVar.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            i2aVar.l(z);
            editorTools.d(i2aVar);
            editorTools.setActionListener(43, rc5Var);
            editorTools.setActionListener(55, rc5Var);
            editorTools.setActionListener(66, rc5Var);
            return i2aVar;
        }
        return (i2a) invokeLLLL.objValue;
    }
}
