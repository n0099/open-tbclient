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
import com.baidu.tieba.fp8;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class cv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qt6 qt6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, qt6Var, str) == null) && !TextUtils.isEmpty(str) && qt6Var != null && !TextUtils.isEmpty(qt6Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", qt6Var.c);
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
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.i0() - j, frsModelController.k0(), frsModelController.j0(), currentTimeMillis - frsModelController.h0());
    }

    public static void b(aj6 aj6Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        g15 adAdSense;
        jn6 Y;
        List<wn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aj6Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && aj6Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<wn> list2 = null;
            if (aj6Var == null) {
                Y = null;
            } else {
                Y = aj6Var.Y();
            }
            if (Y != null) {
                list2 = Y.f();
            }
            if (threadData != null) {
                list = Collections.singletonList(threadData);
            } else {
                list = list2;
            }
            if (list != null && list2 != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    for (wn wnVar : list2) {
                        for (wn wnVar2 : list) {
                            if (wnVar == wnVar2 && (wnVar2 instanceof ThreadData)) {
                                fp8.c cVar = new fp8.c();
                                ((ThreadData) wnVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (wn wnVar3 : list) {
                        if (wnVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) wnVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                fp8.c cVar2 = new fp8.c();
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

    public static void c(tu4 tu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, tu4Var) != null) || tu4Var == null) {
            return;
        }
        String d = tu4Var.d();
        if (StringUtils.isNull(d)) {
            d = tu4Var.g();
        }
        String str = d;
        String b = tu4Var.b();
        String c = tu4Var.c();
        String i = tu4Var.i();
        fp8.c("frs", "CLICK", b, c, i, "tieba.baidu.com/p/" + tu4Var.i(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController J0 = frsFragment.J0();
            aj6 j1 = frsFragment.j1();
            if (j1 != null && J0 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    qt6 qt6Var = new qt6();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    qt6Var.a = z;
                    qt6Var.c = frsViewData.getForum().getId();
                    qt6Var.d = frsViewData.getForum().getName();
                    qt6Var.b = J0.U();
                    qt6 qt6Var2 = st6.p0;
                    if (qt6Var2 != null) {
                        qt6Var.e = qt6Var2.e;
                        qt6Var.f = qt6Var2.f;
                    }
                    rt6.k().h(qt6Var, threadData, 1);
                    pt6.e(threadData, 1, frsFragment.getUniqueId(), qt6Var, frsFragment.getTbPageTag());
                }
                b(j1, frsViewData, frsFragment.k(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            dn4.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) && frsViewData != null && frsViewData.getForum() != null) {
            pt6.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
