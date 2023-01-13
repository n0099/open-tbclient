package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.or;
import com.baidu.tieba.pr;
import com.baidu.tieba.qr;
import com.baidu.tieba.rr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes3.dex */
public class bs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static vr a(zr zrVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, zrVar, bArr)) == null) {
            vr vrVar = null;
            if (zrVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                vr vrVar2 = new vr();
                try {
                    sr a = sr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    vrVar2.a(a);
                    List<qr> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (qr qrVar : b) {
                        int a2 = qrVar.a();
                        byte[] b2 = qrVar.b();
                        if (a2 == 0) {
                            int a3 = hs.a(RSA.decrypt(b2));
                            zrVar.e(DH.getDHSecretKey(a3, zrVar.o().intValue(), zrVar.p().intValue()));
                            zrVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    or.a d = or.d();
                    d.a(a.e());
                    zrVar.h(d.b().a());
                    if (zrVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    zrVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        zrVar.j(a.d());
                        return vrVar2;
                    }
                    return vrVar2;
                } catch (Exception e) {
                    e = e;
                    vrVar = vrVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return vrVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (vr) invokeLL.objValue;
        }
    }

    public static byte[] b(zr zrVar, vr vrVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, zrVar, vrVar)) == null) {
            if (vrVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            rr.a a = rr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(ot.a(bArr));
            rr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            zrVar.d(Integer.valueOf(dHGroupId));
            zrVar.g(Integer.valueOf(dHSecret));
            zrVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = hs.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = pt.b(rt.b(kt.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            qr.a d2 = qr.d();
            d2.a(0);
            d2.b(ot.a(encrypt));
            linkedList.offer(d2.c());
            qr.a d3 = qr.d();
            d3.a(1);
            d3.b(ot.a(new byte[]{0}));
            linkedList.offer(d3.c());
            qr.a d4 = qr.d();
            d4.a(2);
            d4.b(ot.a(hs.d(dHGroupId)));
            linkedList.offer(d4.c());
            qr.a d5 = qr.d();
            d5.a(3);
            d5.b(ot.a(bytes));
            linkedList.offer(d5.c());
            if (mr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            pr.a d6 = pr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((qr) it.next());
            }
            d6.b(c);
            d6.c(ot.a(as.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
