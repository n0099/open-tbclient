package com.baidu.tbadk.mvc.e;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
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
        com.baidu.tbadk.mvc.b.d dVar = (com.baidu.tbadk.mvc.b.d) FR();
        if (dVar != null) {
            if (dVar instanceof com.baidu.tbadk.mvc.b.b) {
                o<byte[]> N = com.baidu.tbadk.core.b.a.um().N(this.tk, str);
                if (writeCacheMessage.isClear()) {
                    com.baidu.tbadk.mvc.b.d dVar2 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar2 == null) {
                        BdCacheService.gs().a(N);
                    } else {
                        N.remove(dVar2.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    com.baidu.tbadk.mvc.b.d dVar3 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar3 == null) {
                        return writeCacheRespMsg;
                    }
                    N.e(dVar3.getCacheKey(), ((com.baidu.tbadk.mvc.b.b) dVar3).Fn());
                    writeCacheRespMsg.setSuccess(true);
                }
            } else if (dVar instanceof f) {
                o<String> O = com.baidu.tbadk.core.b.a.um().O(this.tk, str);
                if (writeCacheMessage.isClear()) {
                    com.baidu.tbadk.mvc.b.d dVar4 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar4 == null) {
                        BdCacheService.gs().a(O);
                    } else {
                        O.remove(dVar4.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    com.baidu.tbadk.mvc.b.d dVar5 = (com.baidu.tbadk.mvc.b.d) writeCacheMessage.getData();
                    if (dVar5 == null) {
                        return writeCacheRespMsg;
                    }
                    String Fq = ((f) dVar5).Fq();
                    if (Fq != null) {
                        O.e(dVar5.getCacheKey(), Fq);
                        writeCacheRespMsg.setSuccess(true);
                    }
                }
            }
        }
        return writeCacheRespMsg;
    }
}
