package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import d.a.o0.f1.f.i.b;
import d.a.o0.f1.t.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
/* loaded from: classes4.dex */
public class OfficialBarTipModel extends ImBaseMessageCenterModel {
    public static final int MASK_TYPE = 12;

    public OfficialBarTipModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    private boolean isNeed(ImMessageCenterPojo imMessageCenterPojo) {
        return imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && (imMessageCenterPojo.getUserType() == 1 || imMessageCenterPojo.getUserType() == 3) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name());
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void deleteSelectedDatas(b bVar) {
        LinkedList<ImMessageCenterShowItemData> linkedList = this.mList;
        if (linkedList == null) {
            return;
        }
        ListIterator<ImMessageCenterShowItemData> listIterator = linkedList.listIterator();
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasNext()) {
            ImMessageCenterShowItemData next = listIterator.next();
            if (next != null && next.isSelected()) {
                arrayList.add(next);
            }
        }
        asyncDeleteMsgList(arrayList, 4, bVar);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return 4;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        return isNeed(imMessageCenterPojo);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        return isNeed(imMessageCenterPojo);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem == null) {
            return;
        }
        buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
        OfficialSettingItemData a2 = d.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        if (a2 != null) {
            buildNormalItem.setGroupSetting(a2);
        }
        insertShowData(buildNormalItem, this.mList);
    }

    public void subscribeBar(boolean z, String str) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setMaskType(12);
        requestUpdateMaskInfoMessage.setList(str);
        sendMessage(requestUpdateMaskInfoMessage);
    }

    public void updateEditStatus(boolean z) {
        for (int i2 = 0; i2 != this.mList.size(); i2++) {
            this.mList.get(i2).setSelected(z);
        }
    }
}
