package com.baidu.tieba.discover.memberpay;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b extends HttpMessageListener {
    final /* synthetic */ MemberPayActivity aoz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MemberPayActivity memberPayActivity, int i) {
        super(i);
        this.aoz = memberPayActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        l lVar7;
        l lVar8;
        this.aoz.closeLoadingDialog();
        if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
            ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
            if (responseMemberPayMessage.getError() != 0) {
                this.aoz.showToast(responseMemberPayMessage.getErrorString());
            } else if (responseMemberPayMessage.getMemberPayResult() != null) {
                this.aoz.a(responseMemberPayMessage.getMemberPayResult());
                lVar = this.aoz.aou;
                if (lVar != null) {
                    lVar2 = this.aoz.aou;
                    lVar2.initData();
                    lVar3 = this.aoz.aou;
                    lVar3.AT();
                    lVar4 = this.aoz.aou;
                    lVar4.AW();
                    lVar5 = this.aoz.aou;
                    lVar5.AX();
                    lVar6 = this.aoz.aou;
                    lVar6.AU();
                    lVar7 = this.aoz.aou;
                    lVar7.AV();
                    lVar8 = this.aoz.aou;
                    lVar8.ape.setVisibility(0);
                }
            } else {
                this.aoz.showToast(y.neterror);
            }
        }
    }
}
