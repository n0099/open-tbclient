package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class g84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DatagramPacket a;
    public l84 b;

    public g84(DatagramPacket datagramPacket, l84 udpsocket) {
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
                l84 l84Var = this.b;
                if (l84Var != null && (B = l84Var.B()) != null) {
                    B.send(this.a);
                }
            } catch (Throwable unused) {
                l84 l84Var2 = this.b;
                if (l84Var2 != null) {
                    l84Var2.C("send", "send failed");
                }
            }
        }
    }
}
