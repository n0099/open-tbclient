package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes3.dex */
public class dt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(pn5 pn5Var, ForumData forumData, List list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{pn5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        xn5 xn5Var = new xn5(pn5Var, 5);
        xn5Var.G(list);
        if (forumData != null) {
            xn5Var.w(forumData.getId());
            xn5Var.v(forumData.getFirst_class());
            xn5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            xn5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        xn5Var.A(z);
        xn5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, xn5Var));
    }

    public static void b(pn5 pn5Var, FrsViewData frsViewData, List list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, pn5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(pn5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(in8 in8Var, List list, List list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, in8Var, list, list2) == null) && in8Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : in8.f) {
                eo eoVar = (eo) ListUtils.getItem(list, i);
                if (eoVar != null && (indexOf = list2.indexOf(eoVar)) >= 0) {
                    in8Var.a(i, indexOf);
                }
            }
        }
    }
}
