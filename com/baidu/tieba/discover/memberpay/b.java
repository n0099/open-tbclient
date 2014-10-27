package com.baidu.tieba.discover.memberpay;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b extends HttpMessageListener {
    final /* synthetic */ MemberPayActivity aoq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MemberPayActivity memberPayActivity, int i) {
        super(i);
        this.aoq = memberPayActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        l lVar7;
        l lVar8;
        this.aoq.closeLoadingDialog();
        if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
            ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
            if (responseMemberPayMessage.getError() != 0) {
                this.aoq.showToast(responseMemberPayMessage.getErrorString());
            } else if (responseMemberPayMessage.getMemberPayResult() != null) {
                this.aoq.a(responseMemberPayMessage.getMemberPayResult());
                lVar = this.aoq.aol;
                if (lVar != null) {
                    lVar2 = this.aoq.aol;
                    lVar2.initData();
                    lVar3 = this.aoq.aol;
                    lVar3.AR();
                    lVar4 = this.aoq.aol;
                    lVar4.AU();
                    lVar5 = this.aoq.aol;
                    lVar5.AV();
                    lVar6 = this.aoq.aol;
                    lVar6.AS();
                    lVar7 = this.aoq.aol;
                    lVar7.AT();
                    lVar8 = this.aoq.aol;
                    lVar8.aoV.setVisibility(0);
                }
            } else {
                this.aoq.showToast(y.neterror);
            }
        }
    }
}
