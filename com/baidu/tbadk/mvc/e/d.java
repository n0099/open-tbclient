package com.baidu.tbadk.mvc.e;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.b.d;
import com.baidu.tbadk.mvc.b.f;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
/* loaded from: classes.dex */
public class d<T extends com.baidu.tbadk.mvc.b.d> extends a<T> {
    public d(int i, String str, Class<T> cls) {
        super(i, str, cls);
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        if (customMessage == null || !(customMessage instanceof WriteCacheMessage)) {
            return null;
        }
        WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.cmd);
        WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = currentAccount == null ? "" : currentAccount;
        com.baidu.tbadk.mvc.b.d dVar = (com.baidu.tbadk.mvc.b.d) FI();
        if (dVar != null) {
            if (dVar instanceof com.baidu.tbadk.mvc.b.b) {
                l<byte[]> L = com.baidu.tbadk.core.c.a.to().L(this.uR, str);
                if (writeCacheMessage.isClear()) {
                    com.baidu.tbadk.mvc.b.d dVar2 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar2 == null) {
                        BdCacheService.eQ().a(L);
                    } else {
                        L.remove(dVar2.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    com.baidu.tbadk.mvc.b.d dVar3 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar3 == null) {
                        return writeCacheRespMsg;
                    }
                    L.k(dVar3.getCacheKey(), ((com.baidu.tbadk.mvc.b.b) dVar3).EZ());
                    writeCacheRespMsg.setSuccess(true);
                }
            } else if (dVar instanceof f) {
                l<String> M = com.baidu.tbadk.core.c.a.to().M(this.uR, str);
                if (writeCacheMessage.isClear()) {
                    com.baidu.tbadk.mvc.b.d dVar4 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar4 == null) {
                        BdCacheService.eQ().a(M);
                    } else {
                        M.remove(dVar4.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    com.baidu.tbadk.mvc.b.d dVar5 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar5 == null) {
                        return writeCacheRespMsg;
                    }
                    String Fc = ((f) dVar5).Fc();
                    if (Fc != null) {
                        M.k(dVar5.getCacheKey(), Fc);
                        writeCacheRespMsg.setSuccess(true);
                    }
                }
            }
        }
        return writeCacheRespMsg;
    }
}
