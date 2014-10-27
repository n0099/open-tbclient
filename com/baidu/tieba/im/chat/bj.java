package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bj extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ bi aOp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.aOp = biVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        GroupSettingActivity groupSettingActivity;
        bm bmVar;
        com.baidu.tieba.im.db.c Mw = com.baidu.tieba.im.db.c.Mw();
        groupSettingActivity = this.aOp.aOo;
        bmVar = groupSettingActivity.aOi;
        return Boolean.valueOf(Mw.fV(bmVar.getGroupId()));
    }
}
