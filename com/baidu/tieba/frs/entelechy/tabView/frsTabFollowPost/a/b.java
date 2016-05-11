package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model.GetFrsTabFollowPostNumHttpResponsedMsg;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model.GetFrsTabFollowPostNumSocketResponsedMsg;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bpE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bpE = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof GetFrsTabFollowPostNumHttpResponsedMsg) {
            this.bpE.bpC = ((GetFrsTabFollowPostNumHttpResponsedMsg) responsedMessage).getThreadNum();
        } else if (responsedMessage instanceof GetFrsTabFollowPostNumSocketResponsedMsg) {
            this.bpE.bpC = ((GetFrsTabFollowPostNumSocketResponsedMsg) responsedMessage).getThreadNum();
        }
    }
}
