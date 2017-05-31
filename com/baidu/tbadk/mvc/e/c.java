package com.baidu.tbadk.mvc.e;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
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
        Exception exc;
        String str;
        String str2;
        List<o.c<String>> b;
        String str3;
        com.baidu.tbadk.mvc.b.d dVar;
        byte[] bArr;
        com.baidu.tbadk.mvc.b.d dVar2;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        com.baidu.tbadk.mvc.b.d dVar3 = (com.baidu.tbadk.mvc.b.d) EN();
        try {
            if (readCacheMessage.isNeedUid()) {
                str = TbadkCoreApplication.getCurrentAccount();
                if (str == null) {
                    str = "";
                }
            } else {
                str = null;
            }
        } catch (Exception e) {
            exc = e;
            arrayList = null;
        } catch (Throwable th) {
            arrayList = null;
        }
        if (dVar3 != null) {
            if (readCacheMessage.getRequestData() == null) {
                if (dVar3 instanceof com.baidu.tbadk.mvc.b.b) {
                    List<o.c<byte[]>> c = s.c(com.baidu.tbadk.core.c.a.sY().L(this.tj, str));
                    if (c != null) {
                        ArrayList arrayList2 = new ArrayList(c.size());
                        try {
                            for (o.c<byte[]> cVar : c) {
                                if (cVar != null && (bArr = cVar.sH) != null && (dVar2 = (com.baidu.tbadk.mvc.b.d) EN()) != null) {
                                    ((com.baidu.tbadk.mvc.b.b) dVar2).z(bArr);
                                    arrayList2.add(dVar2);
                                }
                            }
                            arrayList = arrayList2;
                        } catch (Exception e2) {
                            exc = e2;
                            arrayList = arrayList2;
                            try {
                                exc.printStackTrace();
                            } catch (Throwable th2) {
                            }
                        } catch (Throwable th3) {
                            arrayList = arrayList2;
                        }
                        return new ReadCacheRespMsg(this.cmd, arrayList);
                    }
                } else if ((dVar3 instanceof f) && (b = s.b(com.baidu.tbadk.core.c.a.sY().M(this.tj, str))) != null) {
                    ArrayList arrayList3 = new ArrayList(b.size());
                    try {
                        for (o.c<String> cVar2 : b) {
                            if (cVar2 != null && (str3 = cVar2.sH) != null && (dVar = (com.baidu.tbadk.mvc.b.d) EN()) != null) {
                                ((f) dVar).fS(str3);
                                arrayList3.add(dVar);
                            }
                        }
                        arrayList = arrayList3;
                    } catch (Exception e3) {
                        exc = e3;
                        arrayList = arrayList3;
                        exc.printStackTrace();
                    } catch (Throwable th4) {
                        arrayList = arrayList3;
                    }
                    return new ReadCacheRespMsg(this.cmd, arrayList);
                }
            } else {
                String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                String Ee = readCacheMessage.getRequestData().Ee();
                if (dVar3 instanceof com.baidu.tbadk.mvc.b.b) {
                    byte[] bArr2 = com.baidu.tbadk.core.c.a.sY().L(Ee, str).get(cacheKey);
                    if (bArr2 != null) {
                        ((com.baidu.tbadk.mvc.b.b) dVar3).z(bArr2);
                        ArrayList arrayList4 = new ArrayList();
                        try {
                            arrayList4.add(dVar3);
                            arrayList = arrayList4;
                        } catch (Exception e4) {
                            arrayList = arrayList4;
                            exc = e4;
                            exc.printStackTrace();
                        } catch (Throwable th5) {
                            arrayList = arrayList4;
                        }
                        return new ReadCacheRespMsg(this.cmd, arrayList);
                    }
                } else if ((dVar3 instanceof f) && (str2 = com.baidu.tbadk.core.c.a.sY().M(Ee, str).get(cacheKey)) != null) {
                    ((f) dVar3).fS(str2);
                    ArrayList arrayList5 = new ArrayList();
                    try {
                        arrayList5.add(dVar3);
                        arrayList = arrayList5;
                    } catch (Exception e5) {
                        arrayList = arrayList5;
                        exc = e5;
                        exc.printStackTrace();
                    } catch (Throwable th6) {
                        arrayList = arrayList5;
                    }
                    return new ReadCacheRespMsg(this.cmd, arrayList);
                }
            }
        }
        arrayList = null;
        return new ReadCacheRespMsg(this.cmd, arrayList);
    }
}
