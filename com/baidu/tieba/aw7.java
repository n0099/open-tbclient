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
/* loaded from: classes5.dex */
public class aw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(e46 e46Var, ForumData forumData, List<bn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{e46Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        m46 m46Var = new m46(e46Var, 5);
        m46Var.G(list);
        if (forumData != null) {
            m46Var.w(forumData.getId());
            m46Var.v(forumData.getFirst_class());
            m46Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            m46Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        m46Var.A(z);
        m46Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, m46Var));
    }

    public static void b(e46 e46Var, FrsViewData frsViewData, List<bn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, e46Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(e46Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(pja pjaVar, List<bn> list, List<bn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, pjaVar, list, list2) == null) && pjaVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : pja.f) {
                bn bnVar = (bn) ListUtils.getItem(list, i);
                if (bnVar != null && (indexOf = list2.indexOf(bnVar)) >= 0) {
                    pjaVar.a(i, indexOf);
                }
            }
        }
    }
}
