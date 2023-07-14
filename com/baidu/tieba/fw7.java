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
import com.baidu.tieba.eda;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class fw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(it7 it7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, it7Var, str) == null) && !TextUtils.isEmpty(str) && it7Var != null && !TextUtils.isEmpty(it7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", it7Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.F0() - j, frsModelController.H0(), frsModelController.G0(), currentTimeMillis - frsModelController.E0());
    }

    public static void b(ei7 ei7Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        ed5 adAdSense;
        qm7 a0;
        List<yn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ei7Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && ei7Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<yn> list2 = null;
            if (ei7Var == null) {
                a0 = null;
            } else {
                a0 = ei7Var.a0();
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
                                eda.c cVar = new eda.c();
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
                                eda.c cVar2 = new eda.c();
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

    public static void c(x45 x45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, x45Var) != null) || x45Var == null) {
            return;
        }
        String e = x45Var.e();
        if (StringUtils.isNull(e)) {
            e = x45Var.h();
        }
        String str = e;
        String c = x45Var.c();
        String d = x45Var.d();
        String k = x45Var.k();
        eda.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + x45Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController V0 = frsFragment.V0();
            ei7 y1 = frsFragment.y1();
            if (y1 != null && V0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    it7 it7Var = new it7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    it7Var.a = z;
                    it7Var.c = frsViewData.getForum().getId();
                    it7Var.d = frsViewData.getForum().getName();
                    it7Var.b = V0.q0();
                    it7 it7Var2 = kt7.q0;
                    if (it7Var2 != null) {
                        it7Var.e = it7Var2.e;
                        it7Var.f = it7Var2.f;
                    }
                    jt7.k().h(it7Var, threadData, 1);
                    ht7.e(threadData, 1, frsFragment.getUniqueId(), it7Var, frsFragment.getTbPageTag());
                }
                b(y1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            uu4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            ht7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
