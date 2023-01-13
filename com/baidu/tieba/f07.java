package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.nx8;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class f07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qy6 qy6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, qy6Var, str) == null) && !TextUtils.isEmpty(str) && qy6Var != null && !TextUtils.isEmpty(qy6Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", qy6Var.c);
            statisticItem.param("obj_name", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void f(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65541, null, frsModelController, j) != null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.q0() - j, frsModelController.s0(), frsModelController.r0(), currentTimeMillis - frsModelController.p0());
    }

    public static void b(vn6 vn6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        x15 adAdSense;
        gs6 a0;
        List<yn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{vn6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && vn6Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<yn> list2 = null;
            if (vn6Var == null) {
                a0 = null;
            } else {
                a0 = vn6Var.a0();
            }
            if (a0 != null) {
                list2 = a0.f();
            }
            if (threadData != null) {
                list = Collections.singletonList(threadData);
            } else {
                list = list2;
            }
            if (list != null && list2 != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    for (yn ynVar : list2) {
                        for (yn ynVar2 : list) {
                            if (ynVar == ynVar2 && (ynVar2 instanceof ThreadData)) {
                                nx8.c cVar = new nx8.c();
                                ((ThreadData) ynVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (yn ynVar3 : list) {
                        if (ynVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) ynVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                nx8.c cVar2 = new nx8.c();
                                threadData2.getTid();
                                arrayList.add(cVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    frsViewData.getForum().getFirst_class();
                    frsViewData.getForum().getSecond_class();
                }
            }
        }
    }

    public static void c(hv4 hv4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, hv4Var) != null) || hv4Var == null) {
            return;
        }
        String d = hv4Var.d();
        if (StringUtils.isNull(d)) {
            d = hv4Var.g();
        }
        String str = d;
        String b = hv4Var.b();
        String c = hv4Var.c();
        String i = hv4Var.i();
        nx8.c("frs", "CLICK", b, c, i, "tieba.baidu.com/p/" + hv4Var.i(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController P0 = frsFragment.P0();
            vn6 u1 = frsFragment.u1();
            if (u1 != null && P0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    qy6 qy6Var = new qy6();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    qy6Var.a = z;
                    qy6Var.c = frsViewData.getForum().getId();
                    qy6Var.d = frsViewData.getForum().getName();
                    qy6Var.b = P0.b0();
                    qy6 qy6Var2 = sy6.p0;
                    if (qy6Var2 != null) {
                        qy6Var.e = qy6Var2.e;
                        qy6Var.f = qy6Var2.f;
                    }
                    ry6.k().h(qy6Var, threadData, 1);
                    py6.e(threadData, 1, frsFragment.getUniqueId(), qy6Var, frsFragment.getTbPageTag());
                }
                b(u1, frsViewData, frsFragment.l(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            hn4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            py6.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
