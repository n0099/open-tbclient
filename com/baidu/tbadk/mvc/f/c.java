package com.baidu.tbadk.mvc.f;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.v;
import com.baidu.adp.lib.util.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.b.d;
import com.baidu.tbadk.mvc.b.f;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c<T extends com.baidu.tbadk.mvc.b.d> extends a<T> {
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
        com.baidu.tbadk.mvc.b.d dVar;
        byte[] bArr;
        com.baidu.tbadk.mvc.b.d dVar2;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        com.baidu.tbadk.mvc.b.d dVar3 = (com.baidu.tbadk.mvc.b.d) xM();
        if (readCacheMessage.isNeedUid()) {
            str = TbadkCoreApplication.getCurrentAccount();
            if (str == null) {
                str = "";
            }
        } else {
            str = null;
        }
        if (dVar3 != null) {
            if (readCacheMessage.getRequestData() == null) {
                if (dVar3 instanceof com.baidu.tbadk.mvc.b.b) {
                    List<v<byte[]>> c = x.c(com.baidu.tbadk.core.a.a.nS().N(this.hl, str));
                    if (c != null) {
                        ArrayList arrayList2 = new ArrayList(c.size());
                        for (v<byte[]> vVar : c) {
                            if (vVar != null && (bArr = vVar.gJ) != null && (dVar2 = (com.baidu.tbadk.mvc.b.d) xM()) != null) {
                                ((com.baidu.tbadk.mvc.b.b) dVar2).z(bArr);
                                arrayList2.add(dVar2);
                            }
                        }
                        arrayList = arrayList2;
                    }
                } else if ((dVar3 instanceof f) && (b = x.b(com.baidu.tbadk.core.a.a.nS().O(this.hl, str))) != null) {
                    ArrayList arrayList3 = new ArrayList(b.size());
                    for (v<String> vVar2 : b) {
                        if (vVar2 != null && (str3 = vVar2.gJ) != null && (dVar = (com.baidu.tbadk.mvc.b.d) xM()) != null) {
                            ((f) dVar).bH(str3);
                            arrayList3.add(dVar);
                        }
                    }
                    arrayList = arrayList3;
                }
            } else {
                String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                String lq = readCacheMessage.getRequestData().lq();
                if (dVar3 instanceof com.baidu.tbadk.mvc.b.b) {
                    byte[] bArr2 = com.baidu.tbadk.core.a.a.nS().N(lq, str).get(cacheKey);
                    if (bArr2 != null) {
                        ((com.baidu.tbadk.mvc.b.b) dVar3).z(bArr2);
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(dVar3);
                        arrayList = arrayList4;
                    }
                } else if ((dVar3 instanceof f) && (str2 = com.baidu.tbadk.core.a.a.nS().O(lq, str).get(cacheKey)) != null) {
                    ((f) dVar3).bH(str2);
                    ArrayList arrayList5 = new ArrayList();
                    arrayList5.add(dVar3);
                    arrayList = arrayList5;
                }
            }
            return new ReadCacheRespMsg(this.cmd, arrayList);
        }
        arrayList = null;
        return new ReadCacheRespMsg(this.cmd, arrayList);
    }
}
