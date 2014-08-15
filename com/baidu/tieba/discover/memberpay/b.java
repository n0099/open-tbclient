package com.baidu.tieba.discover.memberpay;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class b extends HttpMessageListener {
    final /* synthetic */ MemberPayActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MemberPayActivity memberPayActivity, int i) {
        super(i);
        this.a = memberPayActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        l lVar7;
        l lVar8;
        if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
            ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
            if (responseMemberPayMessage.getError() != 0) {
                this.a.closeLoadingDialog();
                this.a.showToast(responseMemberPayMessage.getErrorString());
            } else if (responseMemberPayMessage.getMemberPayResult() != null) {
                this.a.a(responseMemberPayMessage.getMemberPayResult());
                lVar = this.a.d;
                if (lVar != null) {
                    lVar2 = this.a.d;
                    lVar2.a();
                    lVar3 = this.a.d;
                    lVar3.b();
                    lVar4 = this.a.d;
                    lVar4.e();
                    lVar5 = this.a.d;
                    lVar5.f();
                    lVar6 = this.a.d;
                    lVar6.c();
                    lVar7 = this.a.d;
                    lVar7.d();
                    this.a.closeLoadingDialog();
                    lVar8 = this.a.d;
                    lVar8.e.setVisibility(0);
                }
            } else {
                this.a.closeLoadingDialog();
                this.a.showToast(x.neterror);
            }
        }
    }
}
