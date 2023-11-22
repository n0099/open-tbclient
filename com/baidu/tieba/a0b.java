package com.baidu.tieba;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.FeedbackConfigurations;
import com.baidu.ufosdk.FeedbackManager;
import com.baidu.ufosdk.IConfigurations;
/* loaded from: classes5.dex */
public class a0b {
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
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            FeedbackConfigurations.Builder builder = new FeedbackConfigurations.Builder();
            if (TbadkCoreApplication.getInst().getVersionName() != null) {
                str = TbadkCoreApplication.getInst().getVersionName();
            } else {
                str = "";
            }
            builder.setAppIdentifier(TbadkCoreApplication.getInst().getPackageName(), str);
            builder.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                builder.setAccount(TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentAccount());
            }
            int i = 0;
            builder.setFeedbackBackbar(0);
            IConfigurations build = builder.build();
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                i = 1;
            }
            build.setThemeMode(i);
            FeedbackManager.getInstance(TbadkCoreApplication.getInst().getContext()).initFeedbackSDK(build);
        }
    }
}
