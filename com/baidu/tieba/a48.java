package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.asa;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class a48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(a18 a18Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, a18Var, str) == null) && !TextUtils.isEmpty(str) && a18Var != null && !TextUtils.isEmpty(a18Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", a18Var.c);
            statisticItem.param("obj_name", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void g(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65542, null, frsModelController, j) != null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.y0() - j, frsModelController.A0(), frsModelController.z0(), currentTimeMillis - frsModelController.x0());
    }

    public static void b(vp7 vp7Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        q75 adAdSense;
        qu7 a0;
        List<oi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{vp7Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && vp7Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<oi> list2 = null;
            if (vp7Var == null) {
                a0 = null;
            } else {
                a0 = vp7Var.a0();
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
                    for (oi oiVar : list2) {
                        for (oi oiVar2 : list) {
                            if (oiVar == oiVar2 && (oiVar2 instanceof ThreadData)) {
                                asa.c cVar = new asa.c();
                                ((ThreadData) oiVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (oi oiVar3 : list) {
                        if (oiVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) oiVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                asa.c cVar2 = new asa.c();
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

    public static void c(fz4 fz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, fz4Var) != null) || fz4Var == null) {
            return;
        }
        String e = fz4Var.e();
        if (StringUtils.isNull(e)) {
            e = fz4Var.h();
        }
        String str = e;
        String c = fz4Var.c();
        String d = fz4Var.d();
        String k = fz4Var.k();
        asa.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + fz4Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController y1 = frsFragment.y1();
            vp7 i2 = frsFragment.i2();
            if (i2 != null && y1 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    a18 a18Var = new a18();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a18Var.a = z;
                    a18Var.c = frsViewData.getForum().getId();
                    a18Var.d = frsViewData.getForum().getName();
                    a18Var.b = y1.j0();
                    a18 a18Var2 = c18.q0;
                    if (a18Var2 != null) {
                        a18Var.e = a18Var2.e;
                        a18Var.f = a18Var2.f;
                    }
                    b18.k().h(a18Var, threadData, 1);
                    z08.e(threadData, 1, frsFragment.getUniqueId(), a18Var, frsFragment.getTbPageTag());
                }
                b(i2, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            bp4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(String str, int i, int i2, @NonNull Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), exc}) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "recycleviewNotify").param("obj_source", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("cuid", TbadkCoreApplication.getInst().getCuid()).param("obj_param1", i).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("extra", exc.toString()));
            throw new RuntimeException(exc);
        }
    }

    public static void h(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65543, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            z08.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
