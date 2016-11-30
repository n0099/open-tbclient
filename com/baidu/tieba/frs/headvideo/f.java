package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.frs.headvideo.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e cfd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.cfd = eVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String MC;
        e.a aVar;
        e.a aVar2;
        this.cfd.aAG = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                MC = this.cfd.MC();
                if (!StringUtils.isNull(errorString)) {
                    MC = errorString;
                }
                aVar = this.cfd.cfb;
                if (aVar != null) {
                    aVar2 = this.cfd.cfb;
                    aVar2.fN(MC);
                }
            } else if (responsedMessage instanceof ForumHeadVideoListHttpResponseMessage) {
                this.cfd.a(((ForumHeadVideoListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof ForumHeadVideoListSocketResponseMessage) {
                this.cfd.a(((ForumHeadVideoListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
