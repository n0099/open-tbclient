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
/* loaded from: classes3.dex */
public class de7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ud7 ud7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, ud7Var, i) == null) || ud7Var == null || ud7Var.C() == null || ListUtils.isEmpty(ud7Var.n()) || ud7Var.n().size() < 2) {
            return;
        }
        List<NewFloorInfo> n = ud7Var.n();
        if (n.size() > 2) {
            if (StringHelper.equals(ud7Var.C().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                if (n.get(1) != null) {
                    if (n.get(1).is_floor.intValue() == 0) {
                        b(ud7Var, 12, i);
                        return;
                    } else if (n.get(1).is_floor.intValue() == 1) {
                        b(ud7Var, 13, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (n.get(1) != null) {
                if (n.get(1).is_floor.intValue() == 0) {
                    if (ud7Var.z() != null) {
                        if (StringHelper.equals(ud7Var.z().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                            b(ud7Var, 14, i);
                            return;
                        } else {
                            b(ud7Var, 15, i);
                            return;
                        }
                    }
                    return;
                } else if (n.get(1).is_floor.intValue() == 1) {
                    b(ud7Var, 16, i);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        b(ud7Var, 11, i);
    }

    public static void b(ud7 ud7Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, ud7Var, i, i2) == null) || ud7Var == null || ud7Var.A() == null || ud7Var.r() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12928");
        statisticItem.param("tid", ud7Var.r().f);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", ud7Var.r().e);
        statisticItem.param("fname", ud7Var.r().d);
        statisticItem.param("pid", ud7Var.t());
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }
}
