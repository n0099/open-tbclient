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
        com.baidu.tieba.im.model.m mVar;
        if (bool == null) {
            bool = false;
        }
        groupInfoActivity = this.a.a;
        rVar = groupInfoActivity.f;
        rVar.a(this.b.getData(), bool.booleanValue());
        groupInfoActivity2 = this.a.a;
        mVar = groupInfoActivity2.g;
        mVar.a(bool.booleanValue() ? false : true);
    }
}
