package com.baidu.tieba.discover.memberprivilege;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class g extends HttpMessageListener {
    final /* synthetic */ MemberPrivilegeActivity apy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(MemberPrivilegeActivity memberPrivilegeActivity, int i) {
        super(i);
        this.apy = memberPrivilegeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        n nVar;
        this.apy.closeLoadingDialog();
        if ((httpResponsedMessage instanceof ResponseMemberPrivilegeMessage) && httpResponsedMessage.getCmd() == 1001531) {
            int error = httpResponsedMessage.getError();
            ResponseMemberPrivilegeMessage responseMemberPrivilegeMessage = (ResponseMemberPrivilegeMessage) httpResponsedMessage;
            if (error != 0) {
                this.apy.showToast(responseMemberPrivilegeMessage.getErrorString());
            } else if (responseMemberPrivilegeMessage.mData != null) {
                a aVar = responseMemberPrivilegeMessage.mData;
                nVar = this.apy.apw;
                nVar.AY().a(aVar);
            } else {
                this.apy.showToast(y.neterror);
            }
        }
    }
}
