package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/* loaded from: classes5.dex */
public final class cd4 extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public id4 a;
    public volatile boolean b;

    @SuppressLint({"MobilebdThread"})
    public cd4() {
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

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.b = z;
        }
    }

    public final void c(id4 id4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, id4Var) == null) {
            this.a = id4Var;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        DatagramSocket B;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            while (this.b) {
                try {
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[4096], 4096);
                    id4 id4Var = this.a;
                    if (id4Var != null && (B = id4Var.B()) != null) {
                        B.receive(datagramPacket);
                    }
                    id4 id4Var2 = this.a;
                    if (id4Var2 != null) {
                        id4Var2.y(datagramPacket);
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Throwable unused2) {
                    id4 id4Var3 = this.a;
                    if (id4Var3 != null) {
                        id4Var3.C(StatConstants.VALUE_TYPE_RECEIVE, "receive failed");
                    }
                }
            }
        }
    }
}
