package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class h54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DatagramPacket a;
    public m54 b;

    public h54(DatagramPacket datagramPacket, m54 udpsocket) {
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
        DatagramSocket C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                m54 m54Var = this.b;
                if (m54Var == null || (C = m54Var.C()) == null) {
                    return;
                }
                C.send(this.a);
            } catch (Throwable unused) {
                m54 m54Var2 = this.b;
                if (m54Var2 != null) {
                    m54Var2.D("send", "send failed");
                }
            }
        }
    }
}
