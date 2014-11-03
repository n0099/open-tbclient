package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bj extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ bi aOD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.aOD = biVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        GroupSettingActivity groupSettingActivity;
        bm bmVar;
        com.baidu.tieba.im.db.c MA = com.baidu.tieba.im.db.c.MA();
        groupSettingActivity = this.aOD.aOC;
        bmVar = groupSettingActivity.aOw;
        return Boolean.valueOf(MA.fV(bmVar.getGroupId()));
    }
}
