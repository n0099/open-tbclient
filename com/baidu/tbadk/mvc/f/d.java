package com.baidu.tbadk.mvc.f;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.mvc.b.c;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
/* loaded from: classes.dex */
public class d<T extends com.baidu.tbadk.mvc.b.c> extends a<T> {
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
        String currentAccount = TbadkApplication.getCurrentAccount();
        String str = currentAccount == null ? "" : currentAccount;
        com.baidu.tbadk.mvc.b.c cVar = (com.baidu.tbadk.mvc.b.c) ua();
        if (cVar != null) {
            if (cVar instanceof com.baidu.tbadk.mvc.b.b) {
                t<byte[]> C = com.baidu.tbadk.core.a.a.kS().C(this.fj, str);
                if (writeCacheMessage.isClear()) {
                    com.baidu.tbadk.mvc.b.c cVar2 = (com.baidu.tbadk.mvc.b.c) writeCacheMessage.getData();
                    if (cVar2 == null) {
                        BdCacheService.cr().a(C);
                    } else {
                        C.remove(cVar2.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    com.baidu.tbadk.mvc.b.c cVar3 = (com.baidu.tbadk.mvc.b.c) writeCacheMessage.getData();
                    if (cVar3 == null) {
                        return writeCacheRespMsg;
                    }
                    C.b(cVar3.getCacheKey(), ((com.baidu.tbadk.mvc.b.b) cVar3).tn());
                    writeCacheRespMsg.setSuccess(true);
                }
            } else if (cVar instanceof e) {
                t<String> D = com.baidu.tbadk.core.a.a.kS().D(this.fj, str);
                if (writeCacheMessage.isClear()) {
                    com.baidu.tbadk.mvc.b.c cVar4 = (com.baidu.tbadk.mvc.b.c) writeCacheMessage.getData();
                    if (cVar4 == null) {
                        BdCacheService.cr().a(D);
                    } else {
                        D.remove(cVar4.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    com.baidu.tbadk.mvc.b.c cVar5 = (com.baidu.tbadk.mvc.b.c) writeCacheMessage.getData();
                    if (cVar5 == null) {
                        return writeCacheRespMsg;
                    }
                    String tp = ((e) cVar5).tp();
                    if (tp != null) {
                        D.b(cVar5.getCacheKey(), tp);
                        writeCacheRespMsg.setSuccess(true);
                    }
                }
            }
        }
        return writeCacheRespMsg;
    }
}
