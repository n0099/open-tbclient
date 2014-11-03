package com.baidu.tieba.im.groupUpdates;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ UpdatesItemData bcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(UpdatesItemData updatesItemData) {
        this.bcw = updatesItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.d.MB().ga(this.bcw.getNotice_id()));
    }
}
