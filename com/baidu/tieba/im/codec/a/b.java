package com.baidu.tieba.im.codec.a;

import com.baidu.adp.lib.h.d;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.codec.NetworkMessage;
import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.exception.IMException;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.k;
import com.baidu.tieba.im.message.AckedMessage;
import com.baidu.tieba.im.message.Message;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.codec.b<c> {

    /* renamed from: a  reason: collision with root package name */
    org.msgpack.a f1567a = new org.msgpack.a();
    private Map<Integer, n<c>> b = new HashMap();

    @Override // com.baidu.tieba.im.codec.b
    public byte[] a(NetworkMessage networkMessage) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", String.valueOf(networkMessage.getCmd()));
        hashMap.put(SocialConstants.PARAM_CUID, i.a());
        if (networkMessage.getMsgTag() != null) {
            hashMap.put("msgTag", networkMessage.getMsgTag().toMap());
        }
        if (networkMessage.getData() != null) {
            Map map = networkMessage.getData().toMap();
            if (map == null) {
                map = new HashMap();
            }
            hashMap.put("data", map);
        }
        return this.f1567a.a((org.msgpack.a) hashMap);
    }

    @Override // com.baidu.tieba.im.codec.b
    public List<Message> a(byte[] bArr, boolean z, int i, int i2) {
        q qVar;
        AckedMessage.MessageTag messageTag = null;
        c cVar = new c(bArr, i, i2);
        LinkedList<Message> linkedList = new LinkedList<>();
        int b = cVar.b("cmd");
        if (b > 0) {
            n<c> nVar = this.b.get(Integer.valueOf(b));
            if (nVar == null) {
                throw new IMException(k.f);
            }
            c e = cVar.e("error");
            if (e != null) {
                qVar = new q();
                qVar.f1576a = e.a("errno", 0);
                qVar.b = e.a("errmsg");
                qVar.c = e.a("usermsg");
            } else {
                qVar = null;
            }
            try {
                nVar.a(linkedList, cVar.e("data"), qVar, b);
            } catch (Exception e2) {
                throw new IMException(k.e, e2);
            }
        }
        boolean z2 = cVar.b("isAck") == 1;
        if (z2) {
            if (z) {
                if (b == 0) {
                    if (d.a()) {
                        d.a("cmd missed." + cVar);
                    }
                    throw new IMException(k.b);
                }
                c e3 = cVar.e("msgTag");
                if (e3 != null) {
                    messageTag = new AckedMessage.MessageTag();
                    messageTag.setSequence(e3.b("sequence"));
                }
                AckedMessage ackedMessage = new AckedMessage();
                ackedMessage.setCmd(b);
                ackedMessage.setAck(z2);
                ackedMessage.setMsgTag(messageTag);
                linkedList.add(0, ackedMessage);
            }
        } else {
            a d = cVar.d("multiMsg");
            if (d != null) {
                for (int i3 = 0; i3 < d.a(); i3++) {
                    c a2 = d.a(i3);
                    if (a2 != null) {
                        int b2 = a2.b("cmd");
                        n<c> nVar2 = this.b.get(Integer.valueOf(b2));
                        if (nVar2 == null) {
                            d.a("no MessageTransformer for command:" + b2);
                        } else {
                            try {
                                nVar2.a(linkedList, a2.e("data"), null, b2);
                            } catch (Exception e4) {
                                throw new IMException(k.e, e4);
                            }
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    @Override // com.baidu.tieba.im.codec.b
    public void a(int i, n<c> nVar) {
        this.b.put(Integer.valueOf(i), nVar);
    }
}
