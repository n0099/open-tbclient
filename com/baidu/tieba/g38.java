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
/* loaded from: classes6.dex */
public class g38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(i06 i06Var, ForumData forumData, List<oi> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{i06Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        q06 q06Var = new q06(i06Var, 5);
        q06Var.G(list);
        if (forumData != null) {
            q06Var.w(forumData.getId());
            q06Var.v(forumData.getFirst_class());
            q06Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            q06Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        q06Var.A(z);
        q06Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, q06Var));
    }

    public static void b(i06 i06Var, FrsViewData frsViewData, List<oi> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, i06Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(i06Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(lra lraVar, List<oi> list, List<oi> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, lraVar, list, list2) == null) && lraVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : lra.f) {
                oi oiVar = (oi) ListUtils.getItem(list, i);
                if (oiVar != null && (indexOf = list2.indexOf(oiVar)) >= 0) {
                    lraVar.a(i, indexOf);
                }
            }
        }
    }
}
