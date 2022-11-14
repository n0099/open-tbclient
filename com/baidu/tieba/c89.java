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
public class c89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, editorTools, l65Var) == null) {
            editorTools.d(new x65(tbPageContext.getPageActivity(), 7));
            editorTools.setActionListener(16, l65Var);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, editorTools, l65Var) == null) {
            editorTools.d(new n65(tbPageContext.getPageActivity(), 10));
            editorTools.setActionListener(59, l65Var);
        }
    }

    public static void e(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, editorTools, l65Var) == null) {
            editorTools.d(new d75(tbPageContext.getPageActivity(), 12));
            editorTools.setActionListener(69, l65Var);
        }
    }

    public static void f(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, tbPageContext, editorTools, l65Var) == null) {
            editorTools.d(new i75(tbPageContext.getPageActivity(), 11));
            editorTools.setActionListener(61, l65Var);
        }
    }

    public static j75 g(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, tbPageContext, editorTools, l65Var)) == null) {
            j75 j75Var = new j75(tbPageContext.getPageActivity(), 4);
            editorTools.d(j75Var);
            editorTools.setActionListener(21, l65Var);
            return j75Var;
        }
        return (j75) invokeLLL.objValue;
    }

    public static void j(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, editorTools, l65Var) == null) {
            editorTools.d(new v85(tbPageContext.getPageActivity(), 2));
            editorTools.setActionListener(60, l65Var);
        }
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, editorTools, l65Var) == null) {
            editorTools.d(new x85(tbPageContext.getPageActivity(), 8));
            editorTools.setActionListener(22, l65Var);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        CustomResponsedMessage runTask;
        v65 v65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, editorTools, l65Var) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, tbPageContext.getPageActivity()), v65.class)) != null && (v65Var = (v65) runTask.getData()) != null) {
            v65Var.o = true;
            v65Var.l = 9;
            editorTools.d(v65Var);
            editorTools.setActionListener(25, l65Var);
        }
    }

    public static void d(@NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, editorTools, l65Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            editorTools.h(arrayList);
            v65 n = editorTools.n(5);
            if (n != null) {
                n.l = 5;
                n.d(true);
            }
            editorTools.setActionListener(24, l65Var);
            editorTools.setActionListener(3, l65Var);
        }
    }

    public static void i(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        CustomResponsedMessage runTask;
        v65 v65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, editorTools) == null) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, tbPageContext.getPageActivity()), v65.class)) != null && (v65Var = (v65) runTask.getData()) != null) {
            v65Var.o = true;
            v65Var.l = 10;
            editorTools.d(v65Var);
        }
    }

    public static void h(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, editorTools, l65Var) == null) {
            editorTools.d(new g75(tbPageContext.getPageActivity(), 1));
            editorTools.setActionListener(14, l65Var);
            editorTools.setActionListener(12, l65Var);
            editorTools.setActionListener(13, l65Var);
            editorTools.setActionListener(15, l65Var);
            editorTools.setActionListener(48, l65Var);
            editorTools.setActionListener(46, l65Var);
            editorTools.setActionListener(49, l65Var);
            editorTools.setActionListener(47, l65Var);
        }
    }

    public static void k(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, @NonNull l65 l65Var) {
        v65 v65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, editorTools, l65Var) == null) && er8.a()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, tbPageContext.getPageActivity()), v65.class);
            if (runTask != null && (v65Var = (v65) runTask.getData()) != null) {
                v65Var.l = 3;
                editorTools.d(v65Var);
            }
            editorTools.setActionListener(10, l65Var);
            editorTools.setActionListener(11, l65Var);
        }
    }

    public static n49 m(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools, String str, @NonNull l65 l65Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, tbPageContext, editorTools, str, l65Var)) == null) {
            n49 n49Var = new n49(tbPageContext.getPageActivity(), str);
            boolean z = false;
            n49Var.k(0);
            if (SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1) {
                z = true;
            }
            n49Var.l(z);
            editorTools.d(n49Var);
            editorTools.setActionListener(43, l65Var);
            editorTools.setActionListener(55, l65Var);
            editorTools.setActionListener(66, l65Var);
            return n49Var;
        }
        return (n49) invokeLLLL.objValue;
    }
}
