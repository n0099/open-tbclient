package com.baidu.tieba.history;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.mvc.model.d<com.baidu.tbadk.b.b> {
    final /* synthetic */ PbHistoryActivity aNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbHistoryActivity pbHistoryActivity) {
        this.aNU = pbHistoryActivity;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<com.baidu.tbadk.b.b>> readCacheRespMsg, ReadCacheMessage<com.baidu.tbadk.b.b> readCacheMessage) {
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
            return;
        }
        this.aNU.aj(readCacheRespMsg.getData());
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<com.baidu.tbadk.b.b>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tbadk.b.b> writeCacheMessage) {
        if (writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
            if (!writeCacheMessage.isClear()) {
                this.aNU.IX();
            } else {
                this.aNU.aj(new ArrayList());
            }
        }
    }
}
