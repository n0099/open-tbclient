package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.frs.headvideo.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ g bOL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i, int i2) {
        super(i, i2);
        this.bOL = gVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String Zh;
        g.a aVar;
        g.a aVar2;
        this.bOL.awp = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                Zh = this.bOL.Zh();
                if (!StringUtils.isNull(errorString)) {
                    Zh = errorString;
                }
                aVar = this.bOL.bOJ;
                if (aVar != null) {
                    aVar2 = this.bOL.bOJ;
                    aVar2.fF(Zh);
                }
            } else if (responsedMessage instanceof ForumHeadVideoListHttpResponseMessage) {
                this.bOL.a(((ForumHeadVideoListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof ForumHeadVideoListSocketResponseMessage) {
                this.bOL.a(((ForumHeadVideoListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
