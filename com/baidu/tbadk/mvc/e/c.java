package com.baidu.tbadk.mvc.e;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
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
        ArrayList arrayList;
        ArrayList arrayList2;
        String str;
        String str2;
        List<l.b<String>> b;
        String str3;
        com.baidu.tbadk.mvc.b.d dVar;
        ArrayList arrayList3;
        byte[] bArr;
        com.baidu.tbadk.mvc.b.d dVar2;
        ArrayList arrayList4 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        com.baidu.tbadk.mvc.b.d dVar3 = (com.baidu.tbadk.mvc.b.d) aoE();
        try {
            try {
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
                        try {
                            if (dVar3 instanceof com.baidu.tbadk.mvc.b.b) {
                                List<l.b<byte[]>> c = r.c(com.baidu.tbadk.core.c.a.aaW().bu(this.Av, str));
                                if (c != null) {
                                    ArrayList arrayList5 = new ArrayList(c.size());
                                    for (l.b<byte[]> bVar : c) {
                                        if (bVar != null && (bArr = bVar.value) != null && (dVar2 = (com.baidu.tbadk.mvc.b.d) aoE()) != null) {
                                            ((com.baidu.tbadk.mvc.b.b) dVar2).initByByteArray(bArr);
                                            arrayList5.add(dVar2);
                                        }
                                    }
                                    arrayList3 = arrayList5;
                                } else {
                                    arrayList3 = null;
                                }
                                arrayList4 = arrayList3;
                            } else if ((dVar3 instanceof f) && (b = r.b(com.baidu.tbadk.core.c.a.aaW().bv(this.Av, str))) != null) {
                                ArrayList arrayList6 = new ArrayList(b.size());
                                for (l.b<String> bVar2 : b) {
                                    if (bVar2 != null && (str3 = bVar2.value) != null && (dVar = (com.baidu.tbadk.mvc.b.d) aoE()) != null) {
                                        ((f) dVar).ps(str3);
                                        arrayList6.add(dVar);
                                    }
                                }
                                arrayList4 = arrayList6;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.cmd, arrayList2);
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String anV = readCacheMessage.getRequestData().anV();
                        if (dVar3 instanceof com.baidu.tbadk.mvc.b.b) {
                            byte[] bArr2 = com.baidu.tbadk.core.c.a.aaW().bu(anV, str).get(cacheKey);
                            if (bArr2 != null) {
                                ((com.baidu.tbadk.mvc.b.b) dVar3).initByByteArray(bArr2);
                                ArrayList arrayList7 = new ArrayList();
                                try {
                                    arrayList7.add(dVar3);
                                    arrayList4 = arrayList7;
                                } catch (Exception e2) {
                                    e = e2;
                                    arrayList2 = arrayList7;
                                    e.printStackTrace();
                                    return new ReadCacheRespMsg(this.cmd, arrayList2);
                                } catch (Throwable th) {
                                    arrayList = arrayList7;
                                    return new ReadCacheRespMsg(this.cmd, arrayList);
                                }
                            }
                        } else if ((dVar3 instanceof f) && (str2 = com.baidu.tbadk.core.c.a.aaW().bv(anV, str).get(cacheKey)) != null) {
                            ((f) dVar3).ps(str2);
                            ArrayList arrayList8 = new ArrayList();
                            try {
                                arrayList8.add(dVar3);
                                arrayList4 = arrayList8;
                            } catch (Exception e3) {
                                e = e3;
                                arrayList2 = arrayList8;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.cmd, arrayList2);
                            } catch (Throwable th2) {
                                arrayList = arrayList8;
                                return new ReadCacheRespMsg(this.cmd, arrayList);
                            }
                        }
                    }
                }
                return new ReadCacheRespMsg(this.cmd, arrayList4);
            } catch (Throwable th3) {
            }
        } catch (Exception e4) {
            e = e4;
            arrayList2 = null;
        } catch (Throwable th4) {
            arrayList = null;
        }
    }
}
