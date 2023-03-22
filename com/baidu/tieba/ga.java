package com.baidu.tieba;

import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class ga {
    public static /* synthetic */ Interceptable $ic;
    public static ga a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448305171, "Lcom/baidu/tieba/ga;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448305171, "Lcom/baidu/tieba/ga;");
        }
    }

    public ga() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ga f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (ga.class) {
                    if (a == null) {
                        a = new ga();
                    }
                }
            }
            return a;
        }
        return (ga) invokeV.objValue;
    }

    public byte[] a(byte[] bArr, int i, int i2) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                di.a(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                fg.d(byteArrayOutputStream);
                fg.c(byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }

    public byte[] g(byte[] bArr, int i, int i2) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i, i2)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                di.c(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                fg.d(byteArrayOutputStream);
                fg.c(byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }

    public SocketResponsedMessage b(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        InterceptResult invokeCommon;
        int i2;
        SocketResponsedMessage newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), bArr, socketMessage, socketMessageTask, Boolean.valueOf(z)})) == null) {
            try {
                Class<? extends SocketResponsedMessage> responsedClass = socketMessageTask.getResponsedClass();
                try {
                    newInstance = responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception unused) {
                    newInstance = responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
                }
                newInstance.setOrginalMessage(socketMessage);
                if (z) {
                    try {
                        newInstance.onDecodeFailedInBackGround(i, bArr, da.c);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    newInstance.decodeInBackGround(i, bArr);
                }
                return newInstance;
            } catch (Throwable th) {
                long j = 0;
                if (socketMessage != null) {
                    j = socketMessage.getClientLogID();
                }
                long j2 = j;
                if (bArr != null) {
                    i2 = bArr.length;
                } else {
                    i2 = 0;
                }
                BdStatisticsManager.getInstance().error("im", j2, (String) null, "cmd", Integer.valueOf(i), "byteslength", Integer.valueOf(i2), "comment", th.getMessage());
                throw new CoderException(da.c);
            }
        }
        return (SocketResponsedMessage) invokeCommon.objValue;
    }

    public ha c(byte[] bArr) throws CoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            int f = fa.f();
            if (bArr != null && bArr.length >= f) {
                fa a2 = fa.a(bArr);
                if (a2 != null) {
                    ha haVar = new ha();
                    haVar.a = a2;
                    haVar.b = bArr;
                    haVar.c = f;
                    haVar.d = bArr.length - f;
                    return haVar;
                }
                throw new CoderException(da.b);
            }
            throw new CoderException(da.b);
        }
        return (ha) invokeL.objValue;
    }

    public ha d(ha haVar) throws CoderException {
        InterceptResult invokeL;
        fa faVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, haVar)) == null) {
            if (haVar != null && (faVar = haVar.a) != null && haVar.b != null) {
                if (faVar.d() && haVar.d > 0) {
                    if (ia.a().b() != null) {
                        try {
                            byte[] a2 = pi.a(ia.a().b(), haVar.b, haVar.c, haVar.d);
                            haVar.b = a2;
                            haVar.c = 0;
                            haVar.d = a2.length;
                        } catch (Exception unused) {
                            throw new CoderException(da.h);
                        }
                    } else {
                        throw new CoderException(da.g);
                    }
                }
                if (faVar.c() && (i = haVar.d) > 0) {
                    try {
                        byte[] g = g(haVar.b, haVar.c, i);
                        haVar.b = g;
                        haVar.c = 0;
                        haVar.d = g.length;
                    } catch (Exception unused2) {
                        throw new CoderException(da.f);
                    }
                }
                return haVar;
            }
            throw new CoderException(da.b);
        }
        return (ha) invokeL.objValue;
    }

    public byte[] e(SocketMessage socketMessage, int i, boolean z, boolean z2) throws CoderException {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{socketMessage, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (socketMessage == null) {
                return null;
            }
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
            if (encodeExtraDataInBackGround != null) {
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + fa.g);
                if (encodeExtraDataInBackGround.length <= Integer.MAX_VALUE) {
                    allocate.putInt(encodeExtraDataInBackGround.length);
                    allocate.put(encodeExtraDataInBackGround);
                    allocate.put(encodeInBackGround);
                    encodeInBackGround = allocate.array();
                    z3 = true;
                } else {
                    throw new CoderException(da.e);
                }
            } else {
                z3 = false;
            }
            if (encodeInBackGround != null && z) {
                encodeInBackGround = a(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = pi.c(ia.a().b(), encodeInBackGround);
            }
            return fa.i(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        }
        return (byte[]) invokeCommon.objValue;
    }
}
