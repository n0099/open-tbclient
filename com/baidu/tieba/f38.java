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
public class f38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(h06 h06Var, ForumData forumData, List<oi> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{h06Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        p06 p06Var = new p06(h06Var, 5);
        p06Var.G(list);
        if (forumData != null) {
            p06Var.w(forumData.getId());
            p06Var.v(forumData.getFirst_class());
            p06Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            p06Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        p06Var.A(z);
        p06Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p06Var));
    }

    public static void b(h06 h06Var, FrsViewData frsViewData, List<oi> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, h06Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(h06Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(kra kraVar, List<oi> list, List<oi> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, kraVar, list, list2) == null) && kraVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : kra.f) {
                oi oiVar = (oi) ListUtils.getItem(list, i);
                if (oiVar != null && (indexOf = list2.indexOf(oiVar)) >= 0) {
                    kraVar.a(i, indexOf);
                }
            }
        }
    }
}
