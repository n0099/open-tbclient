package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
/* loaded from: classes.dex */
final class l extends com.baidu.adp.framework.c.a {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(GroupInfoActivity groupInfoActivity, int i) {
        super(0);
        this.a = groupInfoActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.model.l lVar;
        r rVar;
        com.baidu.tieba.im.model.l lVar2;
        com.baidu.tieba.im.model.l lVar3;
        com.baidu.tieba.im.model.l lVar4;
        com.baidu.tieba.im.model.l lVar5;
        com.baidu.tieba.im.model.l lVar6;
        com.baidu.tieba.im.model.l lVar7;
        com.baidu.tieba.im.model.l lVar8;
        com.baidu.tieba.im.model.l lVar9;
        com.baidu.tieba.im.model.l lVar10;
        com.baidu.tieba.im.model.l lVar11;
        r rVar2;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null) {
            rVar2 = this.a.f;
            rVar2.r();
            this.a.showToast(com.baidu.tieba.im.j.neterror);
        } else if (customResponsedMessage2.g() == 2001102) {
            if (!(customResponsedMessage2 instanceof ResponseGroupInfoLocalMessage)) {
                lVar9 = this.a.g;
                lVar10 = this.a.g;
                long d = lVar10.d();
                lVar11 = this.a.g;
                lVar9.a(d, lVar11.e());
                return;
            }
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage2;
            if (responseGroupInfoLocalMessage.h() != null) {
                long b = ((com.baidu.tieba.im.message.aj) responseGroupInfoLocalMessage.h()).b();
                lVar8 = this.a.g;
                if (b != lVar8.d()) {
                    return;
                }
            }
            if (responseGroupInfoLocalMessage.e() != 0) {
                lVar5 = this.a.g;
                lVar6 = this.a.g;
                long d2 = lVar6.d();
                lVar7 = this.a.g;
                lVar5.a(d2, lVar7.e());
                return;
            }
            GroupInfoActivity.c(this.a);
            lVar = this.a.g;
            lVar.a(responseGroupInfoLocalMessage.b());
            rVar = this.a.f;
            rVar.a(responseGroupInfoLocalMessage.b());
            lVar2 = this.a.g;
            lVar3 = this.a.g;
            long d3 = lVar3.d();
            lVar4 = this.a.g;
            lVar2.a(d3, lVar4.e());
        }
    }
}
