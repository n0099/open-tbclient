package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.UpdatesModel;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ UpdatesActivity biO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UpdatesActivity updatesActivity) {
        this.biO = updatesActivity;
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
        sVar = this.biO.biL;
        sVar.setData(convertToUpdatesItemData);
        updatesModel = this.biO.biN;
        updatesModel.calculateSelects(convertToUpdatesItemData);
        sVar2 = this.biO.biL;
        sVar2.setLoadProgressBarVisable(false);
        sVar3 = this.biO.biL;
        updatesModel2 = this.biO.biN;
        sVar3.setDelCount(updatesModel2.getDeleteSize());
        this.biO.loadImage();
        ImMessageCenterPojo imMessageCenterPojo = null;
        if (convertToUpdatesItemData != null && convertToUpdatesItemData.size() > 0) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setLast_content(convertToUpdatesItemData.get(0).getContent());
            imMessageCenterPojo2.setLast_content_time(convertToUpdatesItemData.get(0).getTime());
            imMessageCenterPojo = imMessageCenterPojo2;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001216, imMessageCenterPojo));
        if (convertToUpdatesItemData != null && convertToUpdatesItemData.size() == 0) {
            this.biO.finish();
        }
    }
}
