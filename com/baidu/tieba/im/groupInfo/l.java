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
        com.baidu.tieba.im.model.k kVar;
        r rVar;
        com.baidu.tieba.im.model.k kVar2;
        com.baidu.tieba.im.model.k kVar3;
        com.baidu.tieba.im.model.k kVar4;
        com.baidu.tieba.im.model.k kVar5;
        com.baidu.tieba.im.model.k kVar6;
        com.baidu.tieba.im.model.k kVar7;
        com.baidu.tieba.im.model.k kVar8;
        r rVar2;
        if (customResponsedMessage == null) {
            rVar2 = this.a.b;
            rVar2.p();
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if (customResponsedMessage.getCmd() == 2001102) {
            if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                kVar6 = this.a.c;
                kVar7 = this.a.c;
                long d = kVar7.d();
                kVar8 = this.a.c;
                kVar6.a(d, kVar8.e());
                return;
            }
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
            if (responseGroupInfoLocalMessage.getOrginalMessage() != null) {
                long groupId = ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId();
                kVar5 = this.a.c;
                if (groupId != kVar5.d()) {
                    return;
                }
            }
            if (responseGroupInfoLocalMessage.getError() != 0) {
                kVar2 = this.a.c;
                kVar3 = this.a.c;
                long d2 = kVar3.d();
                kVar4 = this.a.c;
                kVar2.a(d2, kVar4.e());
                return;
            }
            this.a.f();
            kVar = this.a.c;
            kVar.a(responseGroupInfoLocalMessage.getData());
            rVar = this.a.b;
            rVar.a(responseGroupInfoLocalMessage.getData());
        }
    }
}
