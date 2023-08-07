package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class g6a extends EdgeFloat.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g6a(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(activity);
        int equipmentHeight = BdUtilHelper.getEquipmentHeight(activity);
        int statusBarHeight = BdUtilHelper.getStatusBarHeight(activity);
        E(equipmentHeight);
        F(equipmentWidth);
        K(statusBarHeight);
    }
}
