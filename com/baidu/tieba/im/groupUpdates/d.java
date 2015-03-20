package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.model.UpdatesModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ UpdatesActivity biy;
    private final /* synthetic */ com.baidu.tieba.im.g val$getDataCallBackWithBroadcast;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UpdatesActivity updatesActivity, com.baidu.tieba.im.g gVar) {
        this.biy = updatesActivity;
        this.val$getDataCallBackWithBroadcast = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        UpdatesModel updatesModel;
        s sVar;
        updatesModel = this.biy.bix;
        updatesModel.clearSelect();
        sVar = this.biy.biv;
        sVar.cancelEditMode();
        this.biy.setEditMode(false);
        UpdatesModel.requestUpdatesDataFromDB(this.val$getDataCallBackWithBroadcast);
    }
}
