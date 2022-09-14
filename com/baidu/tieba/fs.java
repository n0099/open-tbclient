package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.sr;
import com.baidu.tieba.tr;
import com.baidu.tieba.ur;
import com.baidu.tieba.vr;
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
public class fs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static zr a(ds dsVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, dsVar, bArr)) != null) {
            return (zr) invokeLL.objValue;
        }
        zr zrVar = null;
        if (dsVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            zr zrVar2 = new zr();
            try {
                wr a = wr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (a == null) {
                    return null;
                }
                zrVar2.a(a);
                List<ur> b = a.b();
                if (b == null) {
                    return null;
                }
                for (ur urVar : b) {
                    int a2 = urVar.a();
                    byte[] b2 = urVar.b();
                    if (a2 == 0) {
                        int a3 = ls.a(RSA.decrypt(b2));
                        dsVar.e(DH.getDHSecretKey(a3, dsVar.o().intValue(), dsVar.p().intValue()));
                        dsVar.l(Integer.valueOf(a3));
                    }
                }
                if (a.e() == null) {
                    return null;
                }
                sr.a d = sr.d();
                d.a(a.e());
                dsVar.h(d.b().a());
                if (dsVar.q() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("liftTime=" + a.c());
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("expireTime=" + currentTimeMillis);
                dsVar.c(currentTimeMillis);
                if (a.d() != null) {
                    dsVar.j(a.d());
                    return zrVar2;
                }
                return zrVar2;
            } catch (Exception e) {
                e = e;
                zrVar = zrVar2;
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                return zrVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static byte[] b(ds dsVar, zr zrVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dsVar, zrVar)) == null) {
            if (zrVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            vr.a a = vr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(st.a(bArr));
            vr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            dsVar.d(Integer.valueOf(dHGroupId));
            dsVar.g(Integer.valueOf(dHSecret));
            dsVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = ls.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = tt.b(vt.b(ot.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            ur.a d2 = ur.d();
            d2.a(0);
            d2.b(st.a(encrypt));
            linkedList.offer(d2.c());
            ur.a d3 = ur.d();
            d3.a(1);
            d3.b(st.a(new byte[]{0}));
            linkedList.offer(d3.c());
            ur.a d4 = ur.d();
            d4.a(2);
            d4.b(st.a(ls.d(dHGroupId)));
            linkedList.offer(d4.c());
            ur.a d5 = ur.d();
            d5.a(3);
            d5.b(st.a(bytes));
            linkedList.offer(d5.c());
            if (qr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            tr.a d6 = tr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((ur) it.next());
            }
            d6.b(c);
            d6.c(st.a(es.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
