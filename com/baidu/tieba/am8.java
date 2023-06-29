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
/* loaded from: classes5.dex */
public class am8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ll8 ll8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, ll8Var, i) == null) && ll8Var != null && ll8Var.w() != null && !ListUtils.isEmpty(ll8Var.k()) && ll8Var.k().size() >= 2) {
            List<NewFloorInfo> k = ll8Var.k();
            if (k.size() > 2) {
                if (StringHelper.equals(ll8Var.w().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    if (k.get(1) != null) {
                        if (k.get(1).is_floor.intValue() == 0) {
                            b(ll8Var, 12, i);
                            return;
                        } else if (k.get(1).is_floor.intValue() == 1) {
                            b(ll8Var, 13, i);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (k.get(1) != null) {
                    if (k.get(1).is_floor.intValue() == 0) {
                        if (ll8Var.q() != null) {
                            if (StringHelper.equals(ll8Var.q().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                                b(ll8Var, 14, i);
                                return;
                            } else {
                                b(ll8Var, 15, i);
                                return;
                            }
                        }
                        return;
                    } else if (k.get(1).is_floor.intValue() == 1) {
                        b(ll8Var, 16, i);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            b(ll8Var, 11, i);
        }
    }

    public static void b(ll8 ll8Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, ll8Var, i, i2) == null) && ll8Var != null && ll8Var.s() != null && ll8Var.l() != null) {
            StatisticItem statisticItem = new StatisticItem("c12928");
            statisticItem.param("tid", ll8Var.l().f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", ll8Var.l().e);
            statisticItem.param("fname", ll8Var.l().d);
            statisticItem.param("pid", ll8Var.n());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
