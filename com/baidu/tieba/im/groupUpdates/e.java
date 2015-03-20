package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.UpdatesModel;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ UpdatesActivity biy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(UpdatesActivity updatesActivity) {
        this.biy = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
        s sVar;
        UpdatesModel updatesModel;
        s sVar2;
        s sVar3;
        UpdatesModel updatesModel2;
        List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
        sVar = this.biy.biv;
        sVar.setData(convertToUpdatesItemData);
        updatesModel = this.biy.bix;
        updatesModel.calculateSelects(convertToUpdatesItemData);
        sVar2 = this.biy.biv;
        sVar2.setLoadProgressBarVisable(false);
        sVar3 = this.biy.biv;
        updatesModel2 = this.biy.bix;
        sVar3.setDelCount(updatesModel2.getDeleteSize());
        this.biy.loadImage();
    }
}
