package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.lcp.sdk.pb.LcmPb$LcmNotify;
import com.baidu.lcp.sdk.pb.LcmPb$LcmRequest;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$event_timestamp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes4.dex */
public class g80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public final int d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? z ? 1 : 0 : invokeZ.intValue;
    }

    public g80() {
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

    public final byte[] a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            if (i == 1) {
                return g(bArr);
            }
            return bArr;
        }
        return (byte[]) invokeLI.objValue;
    }

    public y70 b(y70 y70Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y70Var, z)) == null) {
            y70Var.p = z;
            h(y70Var, f(y70Var.i, y70Var.j, y70Var.o, d(false)), a(y70Var.a, d(false)));
            return y70Var;
        }
        return (y70) invokeLZ.objValue;
    }

    public y70 c(Context context, long j) {
        InterceptResult invokeLJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j)) == null) {
            long random = (long) ((Math.random() * 1000000.0d) + 10000.0d);
            y70 y70Var = new y70();
            y70Var.o = random;
            boolean z2 = true;
            y70Var.p = true;
            y70Var.i = 1L;
            y70Var.j = j;
            if (j == 1) {
                z = true;
            } else {
                z = false;
            }
            y70Var.m = z;
            if (j != 3) {
                z2 = false;
            }
            y70Var.l = z2;
            h(y70Var, f(1L, j, random, d(false)), a(e(context, random, j), d(false)));
            return y70Var;
        }
        return (y70) invokeLJ.objValue;
    }

    public final byte[] e(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        LcmPb$LcmRequest build;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j2 == 4) {
                LcmPb$LcmNotify.b newBuilder = LcmPb$LcmNotify.newBuilder();
                newBuilder.v(j);
                newBuilder.u(2);
                LcmPb$LcmNotify build2 = newBuilder.build();
                LcmPb$RpcData.b newBuilder2 = LcmPb$RpcData.newBuilder();
                newBuilder2.C(build2);
                return newBuilder2.build().toByteArray();
            }
            if (j2 == 1) {
                try {
                    LcmPb$Common lcmPb$Common = (LcmPb$Common) p80.c(context, false);
                    LcmPb$LcmRequest.b newBuilder3 = LcmPb$LcmRequest.newBuilder();
                    newBuilder3.y(j);
                    newBuilder3.w(lcmPb$Common);
                    newBuilder3.B(s80.j(context));
                    newBuilder3.A(System.currentTimeMillis());
                    newBuilder3.z(o70.c(context));
                    newBuilder3.x(s80.d(context));
                    build = newBuilder3.build();
                    r80.a("PbProcessor", "cuid :" + lcmPb$Common.getCuid() + ", device :" + lcmPb$Common.getDeviceType() + ", os:" + lcmPb$Common.getOsVersion() + ", man :" + lcmPb$Common.getManufacture() + ", model :" + lcmPb$Common.getModelType() + ", appId :" + lcmPb$Common.getAppId() + ", app :" + lcmPb$Common.getAppVersion() + ", sdk :" + lcmPb$Common.getSdkVersion() + ", token :" + build.getToken() + ", net :" + lcmPb$Common.getNetwork() + ", rom :" + lcmPb$Common.getRomVersion() + ", start :" + build.getStartType() + "，connType :" + build.getConnType());
                } catch (Exception unused) {
                    LcmPb$LcmRequest.b newBuilder4 = LcmPb$LcmRequest.newBuilder();
                    newBuilder4.y(j);
                    newBuilder4.B(s80.j(context));
                    newBuilder4.A(System.currentTimeMillis());
                    newBuilder4.z(o70.c(context));
                    newBuilder4.x(s80.d(context));
                    build = newBuilder4.build();
                }
            } else if (j2 == 2) {
                LcmPb$LcmRequest.b newBuilder5 = LcmPb$LcmRequest.newBuilder();
                newBuilder5.y(j);
                newBuilder5.A(System.currentTimeMillis());
                build = newBuilder5.build();
            } else {
                LcmPb$LcmRequest.b newBuilder6 = LcmPb$LcmRequest.newBuilder();
                newBuilder6.y(j);
                newBuilder6.A(System.currentTimeMillis());
                build = newBuilder6.build();
            }
            r80.f("PbProcessor", "logId :" + j + ", requestTime :" + build.getTimestamp() + "，methodId :" + j2);
            LcmPb$RpcData.b newBuilder7 = LcmPb$RpcData.newBuilder();
            newBuilder7.D(build);
            return newBuilder7.build().toByteArray();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final byte[] f(long j, long j2, long j3, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)})) == null) {
            RpcMetaPb$event_timestamp.b newBuilder = RpcMetaPb$event_timestamp.newBuilder();
            newBuilder.t(t70.a(true));
            newBuilder.u(System.currentTimeMillis());
            RpcMetaPb$event_timestamp build = newBuilder.build();
            RpcMetaPb$RpcRequestMeta.b newBuilder2 = RpcMetaPb$RpcRequestMeta.newBuilder();
            newBuilder2.v(j3);
            newBuilder2.y(j);
            newBuilder2.w(j2);
            newBuilder2.x(1);
            newBuilder2.l(build);
            RpcMetaPb$RpcRequestMeta build2 = newBuilder2.build();
            RpcMetaPb$RpcMeta.b newBuilder3 = RpcMetaPb$RpcMeta.newBuilder();
            newBuilder3.E(build2);
            newBuilder3.D(j3);
            newBuilder3.C(i);
            newBuilder3.z(1);
            return newBuilder3.build().toByteArray();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final byte[] g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public final y70 h(y70 y70Var, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, y70Var, bArr, bArr2)) == null) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12 + bArr2.length);
                allocate.put((byte) 108);
                allocate.put((byte) 99);
                allocate.put((byte) 112);
                allocate.put((byte) 1);
                allocate.putInt(bArr.length + bArr2.length);
                allocate.putInt(bArr.length);
                allocate.put(bArr);
                allocate.put(bArr2);
                y70Var.a = allocate.array();
            } catch (Exception unused) {
            }
            return y70Var;
        }
        return (y70) invokeLLL.objValue;
    }
}
