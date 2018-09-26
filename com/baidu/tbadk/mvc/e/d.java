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
        com.baidu.tbadk.mvc.b.d dVar = (com.baidu.tbadk.mvc.b.d) Lv();
        if (dVar != null) {
            if (dVar instanceof com.baidu.tbadk.mvc.b.b) {
                l<byte[]> W = com.baidu.tbadk.core.c.a.yh().W(this.zJ, str);
                if (writeCacheMessage.isClear()) {
                    com.baidu.tbadk.mvc.b.d dVar2 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar2 == null) {
                        BdCacheService.ij().a(W);
                    } else {
                        W.remove(dVar2.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    com.baidu.tbadk.mvc.b.d dVar3 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar3 == null) {
                        return writeCacheRespMsg;
                    }
                    W.e(dVar3.getCacheKey(), ((com.baidu.tbadk.mvc.b.b) dVar3).KM());
                    writeCacheRespMsg.setSuccess(true);
                }
            } else if (dVar instanceof f) {
                l<String> X = com.baidu.tbadk.core.c.a.yh().X(this.zJ, str);
                if (writeCacheMessage.isClear()) {
                    com.baidu.tbadk.mvc.b.d dVar4 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar4 == null) {
                        BdCacheService.ij().a(X);
                    } else {
                        X.remove(dVar4.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    com.baidu.tbadk.mvc.b.d dVar5 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar5 == null) {
                        return writeCacheRespMsg;
                    }
                    String KP = ((f) dVar5).KP();
                    if (KP != null) {
                        X.e(dVar5.getCacheKey(), KP);
                        writeCacheRespMsg.setSuccess(true);
                    }
                }
            }
        }
        return writeCacheRespMsg;
    }
}
