package com.baidu.tieba.discover.memberprivilege;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ MemberPrivilegeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MemberPrivilegeActivity memberPrivilegeActivity, int i) {
        super(i);
        this.a = memberPrivilegeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        f fVar;
        this.a.closeLoadingDialog();
        if ((httpResponsedMessage instanceof ResponseMemberPrivilegeMessage) && httpResponsedMessage.getCmd() == 1001531) {
            int error = httpResponsedMessage.getError();
            ResponseMemberPrivilegeMessage responseMemberPrivilegeMessage = (ResponseMemberPrivilegeMessage) httpResponsedMessage;
            if (error != 0) {
                this.a.showToast(responseMemberPrivilegeMessage.getErrorString());
            } else if (responseMemberPrivilegeMessage.mData != null) {
                h hVar = responseMemberPrivilegeMessage.mData;
                fVar = this.a.a;
                fVar.a().a(hVar);
            } else {
                this.a.showToast(x.neterror);
            }
        }
    }
}
