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
import com.baidu.tieba.py9;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class er7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(mo7 mo7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, mo7Var, str) == null) && !TextUtils.isEmpty(str) && mo7Var != null && !TextUtils.isEmpty(mo7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", mo7Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.E0() - j, frsModelController.G0(), frsModelController.F0(), currentTimeMillis - frsModelController.D0());
    }

    public static void b(od7 od7Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        ic5 adAdSense;
        zh7 a0;
        List<vn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{od7Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && od7Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<vn> list2 = null;
            if (od7Var == null) {
                a0 = null;
            } else {
                a0 = od7Var.a0();
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
                    for (vn vnVar : list2) {
                        for (vn vnVar2 : list) {
                            if (vnVar == vnVar2 && (vnVar2 instanceof ThreadData)) {
                                py9.c cVar = new py9.c();
                                ((ThreadData) vnVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (vn vnVar3 : list) {
                        if (vnVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) vnVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                py9.c cVar2 = new py9.c();
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

    public static void c(l45 l45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, l45Var) != null) || l45Var == null) {
            return;
        }
        String e = l45Var.e();
        if (StringUtils.isNull(e)) {
            e = l45Var.h();
        }
        String str = e;
        String c = l45Var.c();
        String d = l45Var.d();
        String k = l45Var.k();
        py9.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + l45Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController V0 = frsFragment.V0();
            od7 y1 = frsFragment.y1();
            if (y1 != null && V0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    mo7 mo7Var = new mo7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mo7Var.a = z;
                    mo7Var.c = frsViewData.getForum().getId();
                    mo7Var.d = frsViewData.getForum().getName();
                    mo7Var.b = V0.p0();
                    mo7 mo7Var2 = oo7.q0;
                    if (mo7Var2 != null) {
                        mo7Var.e = mo7Var2.e;
                        mo7Var.f = mo7Var2.f;
                    }
                    no7.k().h(mo7Var, threadData, 1);
                    lo7.e(threadData, 1, frsFragment.getUniqueId(), mo7Var, frsFragment.getTbPageTag());
                }
                b(y1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            xu4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            lo7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
