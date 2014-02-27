package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class as extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.a = arVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        GroupSettingActivity groupSettingActivity;
        aw awVar;
        com.baidu.tieba.im.db.b a = com.baidu.tieba.im.db.b.a();
        groupSettingActivity = this.a.a;
        awVar = groupSettingActivity.b;
        return Boolean.valueOf(a.e(awVar.c()));
    }
}
