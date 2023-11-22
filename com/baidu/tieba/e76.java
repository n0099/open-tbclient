package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes5.dex */
public class e76 implements jq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e76() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.jq2
    public boolean a(Context context, String str, zh3 zh3Var) {
        InterceptResult invokeLLL;
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, zh3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            if (t56.k().n() == null) {
                n = "";
            } else {
                n = t56.k().n();
            }
            statisticItem.param("uid", n);
            statisticItem.param("obj_param1", zh3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, zh3Var.e());
            TiebaStatic.log(statisticItem);
            if (zh3Var.j() == 10 && zh3Var.h() == 1013) {
                b(context, zh3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, zh3 zh3Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zh3Var) == null) {
            g63 c0 = g63.c0();
            if (context != null && c0 != null) {
                String i = lf3.i(tr2.V().getCoreVersion(), c0.Z().H());
                long h = zh3Var.h();
                String r = zh3Var.r();
                if (1020 == h && !TextUtils.isEmpty(r)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    r = ei4.b().a(h);
                }
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(c0.X(), r, "v" + ak3.D() + "/" + i + "/" + zh3Var.a());
                forbiddenInfo.enableSlidingFlag = -1;
                ar2.l(context, "type_need_update_sdk", zh3Var, forbiddenInfo, c0.Z().D());
            }
        }
    }
}
