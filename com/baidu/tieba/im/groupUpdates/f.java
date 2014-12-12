package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.UpdatesModel;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ UpdatesActivity bfR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UpdatesActivity updatesActivity) {
        this.bfR = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
        p pVar;
        UpdatesModel updatesModel;
        p pVar2;
        p pVar3;
        UpdatesModel updatesModel2;
        List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
        pVar = this.bfR.bfO;
        pVar.setData(convertToUpdatesItemData);
        updatesModel = this.bfR.bfQ;
        updatesModel.calculateSelects(convertToUpdatesItemData);
        pVar2 = this.bfR.bfO;
        pVar2.setLoadProgressBarVisable(false);
        pVar3 = this.bfR.bfO;
        updatesModel2 = this.bfR.bfQ;
        pVar3.setDelCount(updatesModel2.getDeleteSize());
        this.bfR.loadImage();
    }
}
