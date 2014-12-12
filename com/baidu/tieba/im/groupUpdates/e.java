package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.model.UpdatesModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ UpdatesActivity bfR;
    private final /* synthetic */ com.baidu.tieba.im.g val$getDataCallBackWithBroadcast;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(UpdatesActivity updatesActivity, com.baidu.tieba.im.g gVar) {
        this.bfR = updatesActivity;
        this.val$getDataCallBackWithBroadcast = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        UpdatesModel updatesModel;
        p pVar;
        updatesModel = this.bfR.bfQ;
        updatesModel.clearSelect();
        pVar = this.bfR.bfO;
        pVar.cancelEditMode();
        this.bfR.setEditMode(false);
        UpdatesModel.requestUpdatesDataFromDB(this.val$getDataCallBackWithBroadcast);
    }
}
