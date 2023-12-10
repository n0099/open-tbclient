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
public class d68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(t06 t06Var, ForumData forumData, List<pi> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{t06Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        b16 b16Var = new b16(t06Var, 5);
        b16Var.G(list);
        if (forumData != null) {
            b16Var.w(forumData.getId());
            b16Var.v(forumData.getFirst_class());
            b16Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            b16Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        b16Var.A(z);
        b16Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, b16Var));
    }

    public static void b(t06 t06Var, FrsViewData frsViewData, List<pi> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, t06Var, frsViewData, list, i) == null) && frsViewData != null) {
            a(t06Var, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(ewa ewaVar, List<pi> list, List<pi> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, ewaVar, list, list2) == null) && ewaVar != null && ListUtils.getCount(list) > 0 && ListUtils.getCount(list2) > 0) {
            for (int i : ewa.f) {
                pi piVar = (pi) ListUtils.getItem(list, i);
                if (piVar != null && (indexOf = list2.indexOf(piVar)) >= 0) {
                    ewaVar.a(i, indexOf);
                }
            }
        }
    }
}
