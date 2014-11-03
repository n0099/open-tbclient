package com.baidu.tieba.discover.memberprivilege;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class g extends HttpMessageListener {
    final /* synthetic */ MemberPrivilegeActivity apH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(MemberPrivilegeActivity memberPrivilegeActivity, int i) {
        super(i);
        this.apH = memberPrivilegeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        n nVar;
        this.apH.closeLoadingDialog();
        if ((httpResponsedMessage instanceof ResponseMemberPrivilegeMessage) && httpResponsedMessage.getCmd() == 1001531) {
            int error = httpResponsedMessage.getError();
            ResponseMemberPrivilegeMessage responseMemberPrivilegeMessage = (ResponseMemberPrivilegeMessage) httpResponsedMessage;
            if (error != 0) {
                this.apH.showToast(responseMemberPrivilegeMessage.getErrorString());
            } else if (responseMemberPrivilegeMessage.mData != null) {
                a aVar = responseMemberPrivilegeMessage.mData;
                nVar = this.apH.apF;
                nVar.Ba().a(aVar);
            } else {
                this.apH.showToast(y.neterror);
            }
        }
    }
}
