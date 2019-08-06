package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.d;
import java.util.ArrayList;
import java.util.ListIterator;
/* loaded from: classes3.dex */
public class OfficialBarTipModel extends ImBaseMessageCenterModel {
    public static final int MASK_TYPE = 12;

    public OfficialBarTipModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            OfficialSettingItemData mo22do = d.bGG().mo22do(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (mo22do != null) {
                buildNormalItem.setGroupSetting(mo22do);
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return 4;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        return isNeed(imMessageCenterPojo);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        return isNeed(imMessageCenterPojo);
    }

    private boolean isNeed(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4) {
            return (imMessageCenterPojo.getUserType() == 1 || imMessageCenterPojo.getUserType() == 3) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name());
        }
        return false;
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
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.mList.size()) {
                this.mList.get(i2).setSelected(z);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void deleteSelectedDatas(b bVar) {
        if (this.mList != null) {
            ListIterator<ImMessageCenterShowItemData> listIterator = this.mList.listIterator();
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasNext()) {
                ImMessageCenterShowItemData next = listIterator.next();
                if (next != null && next.isSelected()) {
                    arrayList.add(next);
                }
            }
            asyncDeleteMsgList(arrayList, 4, bVar);
        }
    }
}
