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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vea;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class fr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(go7 go7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, go7Var, str) == null) && !TextUtils.isEmpty(str) && go7Var != null && !TextUtils.isEmpty(go7Var.c)) {
            StatisticItem statisticItem = new StatisticItem("c11942");
            statisticItem.param("fid", go7Var.c);
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
        TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.x0() - j, frsModelController.z0(), frsModelController.y0(), currentTimeMillis - frsModelController.w0());
    }

    public static void b(ed7 ed7Var, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        v65 adAdSense;
        wh7 b0;
        List<yh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ed7Var, frsViewData, str, Boolean.valueOf(z), threadData}) == null) && ed7Var != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.e()) {
            List<yh> list2 = null;
            if (ed7Var == null) {
                b0 = null;
            } else {
                b0 = ed7Var.b0();
            }
            if (b0 != null) {
                list2 = b0.f();
            }
            if (threadData != null) {
                list = Collections.singletonList(threadData);
            } else {
                list = list2;
            }
            if (list != null && list2 != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    for (yh yhVar : list2) {
                        for (yh yhVar2 : list) {
                            if (yhVar == yhVar2 && (yhVar2 instanceof ThreadData)) {
                                vea.c cVar = new vea.c();
                                ((ThreadData) yhVar2).getTid();
                                arrayList.add(cVar);
                            }
                        }
                    }
                } else {
                    for (yh yhVar3 : list) {
                        if (yhVar3 instanceof ThreadData) {
                            ThreadData threadData2 = (ThreadData) yhVar3;
                            if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                                threadData2.showStatus = 2;
                                vea.c cVar2 = new vea.c();
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

    public static void c(ny4 ny4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, ny4Var) != null) || ny4Var == null) {
            return;
        }
        String e = ny4Var.e();
        if (StringUtils.isNull(e)) {
            e = ny4Var.h();
        }
        String str = e;
        String c = ny4Var.c();
        String d = ny4Var.d();
        String k = ny4Var.k();
        vea.c("frs", "CLICK", c, d, k, "tieba.baidu.com/p/" + ny4Var.k(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) && threadData != null && frsViewData != null) {
            FrsModelController l1 = frsFragment.l1();
            ed7 R1 = frsFragment.R1();
            if (R1 != null && l1 != null) {
                if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    go7 go7Var = new go7();
                    if (frsViewData.needLog == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    go7Var.a = z;
                    go7Var.c = frsViewData.getForum().getId();
                    go7Var.d = frsViewData.getForum().getName();
                    go7Var.b = l1.i0();
                    go7 go7Var2 = io7.q0;
                    if (go7Var2 != null) {
                        go7Var.e = go7Var2.e;
                        go7Var.f = go7Var2.f;
                    }
                    ho7.k().h(go7Var, threadData, 1);
                    fo7.e(threadData, 1, frsFragment.getUniqueId(), go7Var, frsFragment.getTbPageTag());
                }
                b(R1, frsViewData, frsFragment.w(), true, threadData);
            }
        }
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            ko4.a(param, str);
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
            fo7.d(threadData, frsViewData.getForum().getId(), i);
        }
    }
}
