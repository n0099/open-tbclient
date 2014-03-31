package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class d extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ CommonGroupMsglistModel b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonGroupMsglistModel commonGroupMsglistModel, com.baidu.tieba.im.message.a.a aVar) {
        this.b = commonGroupMsglistModel;
        this.c = aVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().b(String.valueOf(this.b.a.getGroupId()), String.valueOf(this.c.w())));
    }
}
