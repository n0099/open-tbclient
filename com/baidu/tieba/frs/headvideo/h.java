package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.frs.headvideo.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ g cbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i, int i2) {
        super(i, i2);
        this.cbF = gVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String Lp;
        g.a aVar;
        g.a aVar2;
        this.cbF.aAl = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                Lp = this.cbF.Lp();
                if (!StringUtils.isNull(errorString)) {
                    Lp = errorString;
                }
                aVar = this.cbF.cbD;
                if (aVar != null) {
                    aVar2 = this.cbF.cbD;
                    aVar2.fG(Lp);
                }
            } else if (responsedMessage instanceof ForumHeadVideoListHttpResponseMessage) {
                this.cbF.a(((ForumHeadVideoListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof ForumHeadVideoListSocketResponseMessage) {
                this.cbF.a(((ForumHeadVideoListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
