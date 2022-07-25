package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.LaunchUpApplicationSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aa5;
import com.repackage.t95;
/* loaded from: classes3.dex */
public class TiebaMainApplication extends TiebaBaseApplication {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TiebaMainApplication() {
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

    @Override // com.baidu.tieba.TiebaBaseApplication, com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            super.attachBaseContext(context);
            TbadkApplication.sApp = this;
            t95.b().t(currentTimeMillis);
        }
    }

    @Override // com.baidu.tieba.TiebaBaseApplication, com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.app.Application
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setPageStayOpen(true);
            super.onCreate();
            if (!LaunchUpApplicationSwitch.getIsOn()) {
                if (getSplash() != null) {
                    getSplash().a();
                }
                if (aa5.a(getContext())) {
                    TiebaStatic.log(new StatisticItem("c13616").param("obj_type", 1));
                } else {
                    TiebaStatic.log(new StatisticItem("c13616").param("obj_type", 2));
                }
            }
            t95.b().F(System.currentTimeMillis());
        }
    }
}
