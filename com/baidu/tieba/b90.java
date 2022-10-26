package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
/* loaded from: classes3.dex */
public class b90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b90() {
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

    public final s80 a(s80 s80Var, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, s80Var, bArr)) == null) {
            LcmPb$RpcData parseFrom = LcmPb$RpcData.parseFrom(bArr);
            if (parseFrom.hasLcmResponse()) {
                LcmPb$LcmResponse lcmResponse = parseFrom.getLcmResponse();
                m90.a("PbProcessor", "methodId ：" + s80Var.i + ", logId :" + lcmResponse.getLogId() + ", errMsg :" + lcmResponse.getErrorMsg() + ", errCode :" + lcmResponse.getErrorCode() + ", pingMS :" + lcmResponse.getNextIntervalMs());
                if (lcmResponse.getErrorCode() == 0) {
                    long j = s80Var.i;
                    if (j == 1) {
                        s80Var.j = 0;
                        s80Var.g = lcmResponse.getNextIntervalMs();
                    } else if (j == 2) {
                        s80Var.j = -1;
                    } else if (j == 3) {
                        s80Var.g = lcmResponse.getNextIntervalMs();
                    } else if (j == 4) {
                        m90.a("PbProcessor", "parseLcmResponse notify");
                    }
                } else {
                    s80Var.c = lcmResponse.getErrorCode();
                    s80Var.d = lcmResponse.getErrorMsg();
                    s80Var.j = -1;
                }
            } else if (parseFrom.hasLcmNotify()) {
                m90.a("PbProcessor", "lcmpb hasLcmNotify");
            } else if (parseFrom.hasLcmRequest()) {
                s80Var.n = parseFrom.getLcmRequest().getLogId();
            }
            return s80Var;
        }
        return (s80) invokeLL.objValue;
    }

    public s80 b(InputStream inputStream) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) {
            s80 s80Var = new s80();
            if (inputStream instanceof ByteArrayInputStream) {
                m90.a("PbProcessor", "parseResponse quic");
            } else if (inputStream instanceof DataInputStream) {
                DataInputStream dataInputStream = (DataInputStream) inputStream;
                byte readByte = dataInputStream.readByte();
                byte readByte2 = dataInputStream.readByte();
                byte readByte3 = dataInputStream.readByte();
                byte readByte4 = dataInputStream.readByte();
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                if (readInt <= 1048576 && readInt2 <= 1048576) {
                    byte[] bArr = new byte[readInt2];
                    dataInputStream.readFully(bArr);
                    int i = readInt - readInt2;
                    byte[] bArr2 = new byte[i];
                    dataInputStream.readFully(bArr2);
                    m90.e("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2 + ", payload :" + i);
                    c(s80Var, bArr, bArr2);
                    return s80Var;
                }
                m90.b("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2);
                throw new Exception(" Failed to allocate a larger byte allocation, data length = " + readInt);
            }
            return s80Var;
        }
        return (s80) invokeL.objValue;
    }

    public final s80 c(s80 s80Var, byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, s80Var, bArr, bArr2)) == null) {
            RpcMetaPb$RpcMeta parseFrom = RpcMetaPb$RpcMeta.parseFrom(bArr);
            if (parseFrom.getCompressType() == 1) {
                bArr2 = d(bArr2);
                m90.a("PbProcessor", "payload is gzip compressed，length : " + bArr2.length);
            }
            s80Var.f = bArr2;
            if (parseFrom.hasNotify()) {
                RpcMetaPb$RpcNotifyMeta notify = parseFrom.getNotify();
                s80Var.c = 0;
                s80Var.d = "notify";
                s80Var.h = notify.getServiceId();
                s80Var.i = notify.getMethodId();
                s80Var.n = notify.getLogId();
                s80Var.e = true;
            } else if (parseFrom.hasResponse()) {
                RpcMetaPb$RpcResponseMeta response = parseFrom.getResponse();
                s80Var.c = response.getErrorCode();
                s80Var.d = response.getErrorText();
                s80Var.h = response.getServiceId();
                s80Var.i = response.getMethodId();
                s80Var.n = response.getLogId();
                s80Var.e = false;
                if (s80Var.c == 0 && s80Var.h == 1) {
                    a(s80Var, bArr2);
                    return s80Var;
                }
            } else if (parseFrom.hasRequest()) {
                RpcMetaPb$RpcRequestMeta request = parseFrom.getRequest();
                s80Var.h = request.getServiceId();
                s80Var.i = request.getMethodId();
                m90.a("PbProcessor", "parseRpcMeta requestMeta");
                a(s80Var, bArr2);
            }
            return s80Var;
        }
        return (s80) invokeLLL.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x003b: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:18:0x003b */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        GZIPInputStream gZIPInputStream;
        IOException e;
        GZIPInputStream gZIPInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream3 = null;
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = gZIPInputStream.read(bArr2);
                            if (read < 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            m90.c("SocketTransceiver", "Exception ", e2);
                        }
                        return byteArray;
                    } catch (IOException e3) {
                        e = e3;
                        m90.c("SocketTransceiver", "unzip exception :", e);
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e4) {
                                m90.c("SocketTransceiver", "Exception ", e4);
                                return bArr;
                            }
                        }
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        return bArr;
                    }
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream3 = gZIPInputStream2;
                    if (gZIPInputStream3 != null) {
                        try {
                            gZIPInputStream3.close();
                        } catch (Exception e5) {
                            m90.c("SocketTransceiver", "Exception ", e5);
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e6) {
                gZIPInputStream = null;
                e = e6;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPInputStream3 != null) {
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }
}
