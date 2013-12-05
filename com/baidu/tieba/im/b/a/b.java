package com.baidu.tieba.im.b.a;

import com.baidu.adp.lib.h.e;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.b.n;
import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.exception.IMException;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.k;
import com.baidu.tieba.im.message.Message;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.b.b<d> {

    /* renamed from: a  reason: collision with root package name */
    org.msgpack.a f1515a = new org.msgpack.a();
    private Map<Integer, n<d>> b = new HashMap();

    @Override // com.baidu.tieba.im.b.b
    public byte[] a(Message message) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", String.valueOf(message.getCmd()));
        hashMap.put(SocialConstants.PARAM_CUID, i.a());
        if (message != null) {
            Map map = message.toMap();
            if (map == null) {
                map = new HashMap();
            }
            hashMap.put("data", map);
        }
        return this.f1515a.a((org.msgpack.a) hashMap);
    }

    @Override // com.baidu.tieba.im.b.b
    public List<Message> a(byte[] bArr, boolean z, int i, int i2) {
        q qVar = null;
        d dVar = new d(bArr, i, i2);
        LinkedList<Message> linkedList = new LinkedList<>();
        int b = dVar.b("cmd");
        if (b > 0) {
            n<d> nVar = this.b.get(Integer.valueOf(b));
            if (nVar == null) {
                throw new IMException(k.f);
            }
            d f = dVar.f("error");
            if (f != null) {
                qVar = new q();
                qVar.f1525a = f.a("errno", 0);
                qVar.b = f.a("errmsg");
                qVar.c = f.a("usermsg");
            }
            try {
                nVar.a(linkedList, dVar.f("data"), qVar, b);
            } catch (Exception e) {
                throw new IMException(k.e, e);
            }
        }
        a e2 = dVar.e("multiMsg");
        if (e2 != null) {
            for (int i3 = 0; i3 < e2.a(); i3++) {
                d a2 = e2.a(i3);
                if (a2 != null) {
                    int b2 = a2.b("cmd");
                    n<d> nVar2 = this.b.get(Integer.valueOf(b2));
                    if (nVar2 == null) {
                        e.a("no MessageTransformer for command:" + b2);
                    } else {
                        try {
                            nVar2.a(linkedList, a2.f("data"), null, b2);
                        } catch (Exception e3) {
                            throw new IMException(k.e, e3);
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    @Override // com.baidu.tieba.im.b.b
    public void a(int i, n<d> nVar) {
        this.b.put(Integer.valueOf(i), nVar);
    }
}
