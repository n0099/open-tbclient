package com.baidu.tbadk.live;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ a Vw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.Vw = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        t sv;
        if (socketResponsedMessage instanceof ResponseGetAccessTokenMessage) {
            ResponseGetAccessTokenMessage responseGetAccessTokenMessage = (ResponseGetAccessTokenMessage) socketResponsedMessage;
            RequestGetAccessTokenMessage requestGetAccessTokenMessage = (RequestGetAccessTokenMessage) responseGetAccessTokenMessage.getOrginalMessage();
            this.Vw.X(requestGetAccessTokenMessage.getBduss(), responseGetAccessTokenMessage.getAccessToken());
            if (!responseGetAccessTokenMessage.hasError() && responseGetAccessTokenMessage.getAccessToken() != null) {
                long min = Math.min(responseGetAccessTokenMessage.getLeftExpiredTimeInSeconds() * 1000, 432000000L);
                if (min <= 1000) {
                    min = 86400000;
                }
                sv = this.Vw.sv();
                sv.b(requestGetAccessTokenMessage.getBduss(), responseGetAccessTokenMessage.getAccessToken(), min);
            }
        }
    }
}
