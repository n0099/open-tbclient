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
public class fl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(rz5 rz5Var, ForumData forumData, List<rn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{rz5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        zz5 zz5Var = new zz5(rz5Var, 5);
        zz5Var.G(list);
        if (forumData != null) {
            zz5Var.w(forumData.getId());
            zz5Var.v(forumData.getFirst_class());
            zz5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            zz5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        zz5Var.A(z);
        zz5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, zz5Var));
    }

    public static void b(rz5 rz5Var, FrsViewData frsViewData, List<rn> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, rz5Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(rz5Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(jr9 jr9Var, List<rn> list, List<rn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, jr9Var, list, list2) == null) && jr9Var != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : jr9.f) {
                rn rnVar = (rn) ListUtils.getItem(list, i);
                if (rnVar != null && (indexOf = list2.indexOf(rnVar)) >= 0) {
                    jr9Var.a(i, indexOf);
                }
            }
        }
    }
}
