package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.tr;
import com.baidu.tieba.ur;
import com.baidu.tieba.vr;
import com.baidu.tieba.wr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes4.dex */
public class gs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static as a(es esVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, esVar, bArr)) == null) {
            as asVar = null;
            if (esVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                as asVar2 = new as();
                try {
                    xr a = xr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    asVar2.a(a);
                    List<vr> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (vr vrVar : b) {
                        int a2 = vrVar.a();
                        byte[] b2 = vrVar.b();
                        if (a2 == 0) {
                            int a3 = ms.a(RSA.decrypt(b2));
                            esVar.e(DH.getDHSecretKey(a3, esVar.o().intValue(), esVar.p().intValue()));
                            esVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    tr.a d = tr.d();
                    d.a(a.e());
                    esVar.h(d.b().a());
                    if (esVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    esVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        esVar.j(a.d());
                        return asVar2;
                    }
                    return asVar2;
                } catch (Exception e) {
                    e = e;
                    asVar = asVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return asVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (as) invokeLL.objValue;
        }
    }

    public static byte[] b(es esVar, as asVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, esVar, asVar)) == null) {
            if (asVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            wr.a a = wr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(tt.a(bArr));
            wr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            esVar.d(Integer.valueOf(dHGroupId));
            esVar.g(Integer.valueOf(dHSecret));
            esVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = ms.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = ut.b(wt.b(pt.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            vr.a d2 = vr.d();
            d2.a(0);
            d2.b(tt.a(encrypt));
            linkedList.offer(d2.c());
            vr.a d3 = vr.d();
            d3.a(1);
            d3.b(tt.a(new byte[]{0}));
            linkedList.offer(d3.c());
            vr.a d4 = vr.d();
            d4.a(2);
            d4.b(tt.a(ms.d(dHGroupId)));
            linkedList.offer(d4.c());
            vr.a d5 = vr.d();
            d5.a(3);
            d5.b(tt.a(bytes));
            linkedList.offer(d5.c());
            if (rr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            ur.a d6 = ur.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((vr) it.next());
            }
            d6.b(c);
            d6.c(tt.a(fs.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
