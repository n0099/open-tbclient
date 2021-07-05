package com.baidu.tieba.ad.download.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.q.d.e;
/* loaded from: classes5.dex */
public class AppNotificationReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AppNotificationReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String extractPackageName(Intent intent) {
        InterceptResult invokeL;
        Uri data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, intent)) == null) {
            if (intent == null || (data = intent.getData()) == null) {
                return null;
            }
            return data.getEncodedSchemeSpecificPart();
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String extractPackageName;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
            return;
        }
        if (PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
            String extractPackageName2 = extractPackageName(intent);
            if (extractPackageName2 != null) {
                e.c().d(context, extractPackageName2);
            }
        } else if (!PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction()) || (extractPackageName = extractPackageName(intent)) == null) {
        } else {
            e.c().p(context, extractPackageName);
        }
    }
}
