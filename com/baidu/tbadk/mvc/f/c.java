package com.baidu.tbadk.mvc.f;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.v;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.mvc.b.c;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c<T extends com.baidu.tbadk.mvc.b.c> extends a<T> {
    public c(int i, String str, Class<T> cls) {
        super(i, str, cls);
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        String str;
        ArrayList arrayList;
        String str2;
        List<v<String>> b;
        String str3;
        com.baidu.tbadk.mvc.b.c cVar;
        byte[] bArr;
        com.baidu.tbadk.mvc.b.c cVar2;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        com.baidu.tbadk.mvc.b.c cVar3 = (com.baidu.tbadk.mvc.b.c) ua();
        if (readCacheMessage.isNeedUid()) {
            str = TbadkApplication.getCurrentAccount();
            if (str == null) {
                str = "";
            }
        } else {
            str = null;
        }
        if (cVar3 != null) {
            if (readCacheMessage.getRequestData() == null) {
                if (cVar3 instanceof com.baidu.tbadk.mvc.b.b) {
                    List<v<byte[]>> c = s.c(com.baidu.tbadk.core.a.a.kS().C(this.fj, str));
                    if (c != null) {
                        ArrayList arrayList2 = new ArrayList(c.size());
                        for (v<byte[]> vVar : c) {
                            if (vVar != null && (bArr = vVar.value) != null && (cVar2 = (com.baidu.tbadk.mvc.b.c) ua()) != null) {
                                ((com.baidu.tbadk.mvc.b.b) cVar2).z(bArr);
                                arrayList2.add(cVar2);
                            }
                        }
                        arrayList = arrayList2;
                    }
                } else if ((cVar3 instanceof e) && (b = s.b(com.baidu.tbadk.core.a.a.kS().D(this.fj, str))) != null) {
                    ArrayList arrayList3 = new ArrayList(b.size());
                    for (v<String> vVar2 : b) {
                        if (vVar2 != null && (str3 = vVar2.value) != null && (cVar = (com.baidu.tbadk.mvc.b.c) ua()) != null) {
                            ((e) cVar).dL(str3);
                            arrayList3.add(cVar);
                        }
                    }
                    arrayList = arrayList3;
                }
            } else {
                String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                String sY = readCacheMessage.getRequestData().sY();
                if (cVar3 instanceof com.baidu.tbadk.mvc.b.b) {
                    byte[] bArr2 = com.baidu.tbadk.core.a.a.kS().C(sY, str).get(cacheKey);
                    if (bArr2 != null) {
                        ((com.baidu.tbadk.mvc.b.b) cVar3).z(bArr2);
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(cVar3);
                        arrayList = arrayList4;
                    }
                } else if ((cVar3 instanceof e) && (str2 = com.baidu.tbadk.core.a.a.kS().D(sY, str).get(cacheKey)) != null) {
                    ((e) cVar3).dL(str2);
                    ArrayList arrayList5 = new ArrayList();
                    arrayList5.add(cVar3);
                    arrayList = arrayList5;
                }
            }
            return new ReadCacheRespMsg(this.cmd, arrayList);
        }
        arrayList = null;
        return new ReadCacheRespMsg(this.cmd, arrayList);
    }
}
