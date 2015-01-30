package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.model.UpdatesModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ UpdatesActivity bhj;
    private final /* synthetic */ com.baidu.tieba.im.g val$getDataCallBackWithBroadcast;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(UpdatesActivity updatesActivity, com.baidu.tieba.im.g gVar) {
        this.bhj = updatesActivity;
        this.val$getDataCallBackWithBroadcast = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        UpdatesModel updatesModel;
        p pVar;
        updatesModel = this.bhj.bhi;
        updatesModel.clearSelect();
        pVar = this.bhj.bhg;
        pVar.cancelEditMode();
        this.bhj.setEditMode(false);
        UpdatesModel.requestUpdatesDataFromDB(this.val$getDataCallBackWithBroadcast);
    }
}
