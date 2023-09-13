package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class dd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DatagramPacket a;
    public id4 b;

    public dd4(DatagramPacket datagramPacket, id4 udpsocket) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {datagramPacket, udpsocket};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(udpsocket, "udpsocket");
        this.a = datagramPacket;
        this.b = udpsocket;
    }

    public final void a() {
        DatagramSocket B;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                id4 id4Var = this.b;
                if (id4Var != null && (B = id4Var.B()) != null) {
                    B.send(this.a);
                }
            } catch (Throwable unused) {
                id4 id4Var2 = this.b;
                if (id4Var2 != null) {
                    id4Var2.C("send", "send failed");
                }
            }
        }
    }
}
