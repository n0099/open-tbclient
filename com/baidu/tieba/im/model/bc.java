package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class bc extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ OfficialBarMsglistModel b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(OfficialBarMsglistModel officialBarMsglistModel, com.baidu.tieba.im.message.a.a aVar) {
        this.b = officialBarMsglistModel;
        this.c = aVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.d().a(String.valueOf(this.b.a.getUserId()), String.valueOf(this.c.w())));
    }
}
