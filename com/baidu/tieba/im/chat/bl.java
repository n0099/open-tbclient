package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class bl extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ bk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.b = bkVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        GroupSettingActivity groupSettingActivity;
        bo boVar;
        com.baidu.tieba.im.db.c a = com.baidu.tieba.im.db.c.a();
        groupSettingActivity = this.b.a;
        boVar = groupSettingActivity.b;
        return Boolean.valueOf(a.e(boVar.b()));
    }
}
