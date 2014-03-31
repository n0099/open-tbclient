package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class bp extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ bo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.b = boVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        GroupSettingActivity groupSettingActivity;
        bs bsVar;
        com.baidu.tieba.im.db.c a = com.baidu.tieba.im.db.c.a();
        groupSettingActivity = this.b.a;
        bsVar = groupSettingActivity.b;
        return Boolean.valueOf(a.e(bsVar.b()));
    }
}
