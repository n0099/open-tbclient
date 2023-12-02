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
public class g79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(m69 m69Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, m69Var, i) == null) && m69Var != null && m69Var.u() != null && !ListUtils.isEmpty(m69Var.k()) && m69Var.k().size() >= 2) {
            List<NewFloorInfo> k = m69Var.k();
            if (k.size() > 2) {
                if (StringHelper.equals(m69Var.u().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (k.get(1) != null) {
                        if (k.get(1).is_floor.intValue() == 0) {
                            b(m69Var, 12, i);
                            return;
                        } else if (k.get(1).is_floor.intValue() == 1) {
                            b(m69Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (k.get(1) != null) {
                    if (k.get(1).is_floor.intValue() == 0) {
                        if (m69Var.q() != null) {
                            if (StringHelper.equals(m69Var.q().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(m69Var, 14, i);
                                return;
                            } else {
                                b(m69Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (k.get(1).is_floor.intValue() == 1) {
                        b(m69Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(m69Var, 11, i);
        }
    }

    public static void b(m69 m69Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, m69Var, i, i2) == null) && m69Var != null && m69Var.s() != null && m69Var.l() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", m69Var.l().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", m69Var.l().e);
            statisticItem.param("fname", m69Var.l().d);
            statisticItem.param("pid", m69Var.o());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
