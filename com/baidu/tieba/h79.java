package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.NewFloorInfo;
/* loaded from: classes6.dex */
public class h79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(n69 n69Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, n69Var, i) == null) && n69Var != null && n69Var.u() != null && !ListUtils.isEmpty(n69Var.k()) && n69Var.k().size() >= 2) {
            List<NewFloorInfo> k = n69Var.k();
            if (k.size() > 2) {
                if (StringHelper.equals(n69Var.u().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (k.get(1) != null) {
                        if (k.get(1).is_floor.intValue() == 0) {
                            b(n69Var, 12, i);
                            return;
                        } else if (k.get(1).is_floor.intValue() == 1) {
                            b(n69Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (k.get(1) != null) {
                    if (k.get(1).is_floor.intValue() == 0) {
                        if (n69Var.q() != null) {
                            if (StringHelper.equals(n69Var.q().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(n69Var, 14, i);
                                return;
                            } else {
                                b(n69Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (k.get(1).is_floor.intValue() == 1) {
                        b(n69Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(n69Var, 11, i);
        }
    }

    public static void b(n69 n69Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, n69Var, i, i2) == null) && n69Var != null && n69Var.s() != null && n69Var.l() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", n69Var.l().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", n69Var.l().e);
            statisticItem.param("fname", n69Var.l().d);
            statisticItem.param("pid", n69Var.o());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
