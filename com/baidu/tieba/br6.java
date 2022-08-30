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
public class br6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ok5 ok5Var, ForumData forumData, List<pn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{ok5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        wk5 wk5Var = new wk5(ok5Var, 5);
        wk5Var.G(list);
        if (forumData != null) {
            wk5Var.w(forumData.getId());
            wk5Var.v(forumData.getFirst_class());
            wk5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            wk5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        wk5Var.A(z);
        wk5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wk5Var));
    }

    public static void b(ok5 ok5Var, FrsViewData frsViewData, List<pn> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, ok5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(ok5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(al8 al8Var, List<pn> list, List<pn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, al8Var, list, list2) == null) || al8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : al8.f) {
            pn pnVar = (pn) ListUtils.getItem(list, i);
            if (pnVar != null && (indexOf = list2.indexOf(pnVar)) >= 0) {
                al8Var.a(i, indexOf);
            }
        }
    }
}
