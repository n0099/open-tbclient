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
/* loaded from: classes3.dex */
public class b26 implements wr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b26() {
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

    @Override // com.baidu.tieba.wr2
    public boolean a(Context context, String str, mj3 mj3Var) {
        InterceptResult invokeLLL;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, mj3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            if (q06.l().p() == null) {
                p = "";
            } else {
                p = q06.l().p();
            }
            statisticItem.param("uid", p);
            statisticItem.param("obj_param1", mj3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, mj3Var.e());
            TiebaStatic.log(statisticItem);
            if (mj3Var.j() == 10 && mj3Var.h() == 1013) {
                b(context, mj3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, mj3 mj3Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, mj3Var) == null) {
            t73 b0 = t73.b0();
            if (context != null && b0 != null) {
                String i = yg3.i(gt2.U().M(), b0.Y().G());
                long h = mj3Var.h();
                String r = mj3Var.r();
                if (1020 == h && !TextUtils.isEmpty(r)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    r = rj4.b().a(h);
                }
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(b0.W(), r, "v" + nl3.D() + "/" + i + "/" + mj3Var.a());
                forbiddenInfo.enableSlidingFlag = -1;
                ns2.l(context, "type_need_update_sdk", mj3Var, forbiddenInfo, b0.Y().D());
            }
        }
    }
}
