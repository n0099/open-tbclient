package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class eja extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bja a;
    public final /* synthetic */ aja b;

    public eja(aja ajaVar, bja bjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ajaVar, bjaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ajaVar;
        this.a = bjaVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if (!"com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) || extras == null || !extras.containsKey("install.status")) {
                return;
            }
            this.b.p();
            int i = extras.getInt("install.status");
            if (i != 1 && i != 2 && i != 3) {
                if (i != 4) {
                    if (i == 6) {
                        this.a.a(com.google.ar.core.p.CANCELLED);
                        return;
                    }
                    return;
                }
                this.a.a(com.google.ar.core.p.COMPLETED);
                return;
            }
            this.a.a(com.google.ar.core.p.ACCEPTED);
        }
    }
}
