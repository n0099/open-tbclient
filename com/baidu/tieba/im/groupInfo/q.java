package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ p a;
    private final /* synthetic */ ResponseGroupInfoMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, ResponseGroupInfoMessage responseGroupInfoMessage) {
        this.a = pVar;
        this.b = responseGroupInfoMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        GroupInfoActivity groupInfoActivity;
        r rVar;
        GroupInfoActivity groupInfoActivity2;
        r rVar2;
        GroupInfoActivity groupInfoActivity3;
        com.baidu.tieba.im.model.k kVar;
        if (bool == null) {
            bool = false;
        }
        groupInfoActivity = this.a.a;
        rVar = groupInfoActivity.f;
        rVar.p();
        groupInfoActivity2 = this.a.a;
        rVar2 = groupInfoActivity2.f;
        rVar2.a(this.b.getData(), bool.booleanValue());
        groupInfoActivity3 = this.a.a;
        kVar = groupInfoActivity3.g;
        kVar.a(bool.booleanValue() ? false : true);
    }
}
