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
        com.baidu.tieba.im.model.k kVar9;
        com.baidu.tieba.im.model.k kVar10;
        com.baidu.tieba.im.model.k kVar11;
        r rVar2;
        if (customResponsedMessage == null) {
            rVar2 = this.a.f;
            rVar2.p();
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (customResponsedMessage.getCmd() == 2001102) {
            if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                kVar9 = this.a.g;
                kVar10 = this.a.g;
                long d = kVar10.d();
                kVar11 = this.a.g;
                kVar9.a(d, kVar11.e());
                return;
            }
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
            if (responseGroupInfoLocalMessage.getOrginalMessage() != null) {
                long groupId = ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId();
                kVar8 = this.a.g;
                if (groupId != kVar8.d()) {
                    return;
                }
            }
            if (responseGroupInfoLocalMessage.getError() != 0) {
                kVar5 = this.a.g;
                kVar6 = this.a.g;
                long d2 = kVar6.d();
                kVar7 = this.a.g;
                kVar5.a(d2, kVar7.e());
                return;
            }
            this.a.f();
            kVar = this.a.g;
            kVar.a(responseGroupInfoLocalMessage.getData());
            rVar = this.a.f;
            rVar.a(responseGroupInfoLocalMessage.getData());
            kVar2 = this.a.g;
            kVar3 = this.a.g;
            long d3 = kVar3.d();
            kVar4 = this.a.g;
            kVar2.a(d3, kVar4.e());
        }
    }
}
