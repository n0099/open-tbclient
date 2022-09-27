package com.baidu.tieba;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.FeedbackConfigurations;
import com.baidu.ufosdk.FeedbackManager;
import com.baidu.ufosdk.IConfigurations;
/* loaded from: classes3.dex */
public class bu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Intent a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            b();
            return FeedbackManager.getInstance(TbadkCoreApplication.getInst().getContext()).getFeedbackIntentWithCategory(0, "https://ufosdk.baidu.com/ufosdk/helpCenter/qtbMBmwrIBtM25TGeonQxQ%3D%3D");
        }
        return (Intent) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            FeedbackConfigurations.Builder builder = new FeedbackConfigurations.Builder();
            builder.setAppIdentifier(TbadkCoreApplication.getInst().getPackageName(), TbadkCoreApplication.getInst().getVersionName() != null ? TbadkCoreApplication.getInst().getVersionName() : "");
            builder.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                builder.setAccount(TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentAccount());
            }
            builder.setFeedbackBackbar(0);
            IConfigurations build = builder.build();
            build.setThemeMode(TbadkCoreApplication.getInst().getSkinType() != 0 ? 1 : 0);
            FeedbackManager.getInstance(TbadkCoreApplication.getInst().getContext()).initFeedbackSDK(build);
        }
    }
}
