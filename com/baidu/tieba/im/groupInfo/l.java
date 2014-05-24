package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(GroupInfoActivity groupInfoActivity, int i) {
        super(i);
        this.a = groupInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.model.m mVar;
        r rVar;
        com.baidu.tieba.im.model.m mVar2;
        com.baidu.tieba.im.model.m mVar3;
        com.baidu.tieba.im.model.m mVar4;
        com.baidu.tieba.im.model.m mVar5;
        com.baidu.tieba.im.model.m mVar6;
        com.baidu.tieba.im.model.m mVar7;
        com.baidu.tieba.im.model.m mVar8;
        com.baidu.tieba.im.model.m mVar9;
        com.baidu.tieba.im.model.m mVar10;
        com.baidu.tieba.im.model.m mVar11;
        r rVar2;
        if (customResponsedMessage == null) {
            rVar2 = this.a.f;
            rVar2.p();
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (customResponsedMessage.getCmd() == 2003102) {
            if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                mVar9 = this.a.g;
                mVar10 = this.a.g;
                long d = mVar10.d();
                mVar11 = this.a.g;
                mVar9.a(d, mVar11.e());
                return;
            }
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
            if (responseGroupInfoLocalMessage.getOrginalMessage() != null) {
                long groupId = ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId();
                mVar8 = this.a.g;
                if (groupId != mVar8.d()) {
                    return;
                }
            }
            if (responseGroupInfoLocalMessage.getError() != 0) {
                mVar5 = this.a.g;
                mVar6 = this.a.g;
                long d2 = mVar6.d();
                mVar7 = this.a.g;
                mVar5.a(d2, mVar7.e());
                return;
            }
            this.a.f();
            mVar = this.a.g;
            mVar.a(responseGroupInfoLocalMessage.getData());
            rVar = this.a.f;
            rVar.a(responseGroupInfoLocalMessage.getData());
            mVar2 = this.a.g;
            mVar3 = this.a.g;
            long d3 = mVar3.d();
            mVar4 = this.a.g;
            mVar2.a(d3, mVar4.e());
        }
    }
}
