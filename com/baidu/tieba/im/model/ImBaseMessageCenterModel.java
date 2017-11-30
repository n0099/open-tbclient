package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.chat.a.a;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ImBaseMessageCenterModel extends BdBaseModel<Object> {
    protected final LinkedList<ImMessageCenterShowItemData> mList;

    protected abstract int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean isAccept(ImMessageCenterPojo imMessageCenterPojo);

    protected abstract boolean isToShow(ImMessageCenterPojo imMessageCenterPojo);

    protected abstract void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData);

    /* JADX INFO: Access modifiers changed from: protected */
    public ImBaseMessageCenterModel(e eVar) {
        super(eVar);
        this.mList = new LinkedList<>();
    }

    public void insertOrUpdate(ImMessageCenterPojo imMessageCenterPojo, a aVar) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid()) && isAccept(imMessageCenterPojo)) {
            ImMessageCenterShowItemData removeItem = removeItem(imMessageCenterPojo);
            if (!isToShow(imMessageCenterPojo)) {
                if (aVar != null) {
                    aVar.axp();
                    return;
                }
                return;
            }
            processMsg(imMessageCenterPojo, removeItem);
            onComplete(aVar);
        }
    }

    private ImMessageCenterShowItemData removeItem(ImMessageCenterPojo imMessageCenterPojo) {
        int size = this.mList.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = this.mList.get(i);
            if (imMessageCenterPojo.getGid().equals(imMessageCenterShowItemData.getFriendId()) && imMessageCenterPojo.getCustomGroupType() == getCustomGroupType(imMessageCenterShowItemData)) {
                return this.mList.remove(i);
            }
        }
        return null;
    }

    public void remove(ImMessageCenterPojo imMessageCenterPojo, a aVar) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            removeItem(imMessageCenterPojo);
            if (aVar != null) {
                aVar.axp();
            }
        }
    }

    public void setData(List<ImMessageCenterPojo> list, a aVar) {
        this.mList.clear();
        if (list == null) {
            if (aVar != null) {
                aVar.axp();
                return;
            }
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : list) {
            if (imMessageCenterPojo != null && isToShow(imMessageCenterPojo)) {
                processMsg(imMessageCenterPojo, null);
            }
        }
        onComplete(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImMessageCenterShowItemData buildNormalItem(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterPojo == null) {
            return null;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() == 0) {
            return null;
        }
        if (imMessageCenterShowItemData == null) {
            imMessageCenterShowItemData = new ImMessageCenterShowItemData();
        }
        imMessageCenterShowItemData.setUserType(imMessageCenterPojo.getUserType());
        imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
        imMessageCenterShowItemData.setOwnerId(TbadkCoreApplication.getCurrentAccount());
        imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
        imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
        imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
        imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
        if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
            imMessageCenterPojo.setLast_content("");
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
        return imMessageCenterShowItemData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void insertShowData(ImMessageCenterShowItemData imMessageCenterShowItemData, List<ImMessageCenterShowItemData> list) {
        if (imMessageCenterShowItemData != null && list != null) {
            list.add(imMessageCenterShowItemData);
        }
    }

    public void deleteItem(ImMessageCenterShowItemData imMessageCenterShowItemData, a aVar) {
        if (imMessageCenterShowItemData != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (!TextUtils.isEmpty(friendId) && this.mList != null && this.mList.size() != 0) {
                String ownerName = imMessageCenterShowItemData.getOwnerName();
                Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ImMessageCenterShowItemData next = it.next();
                    if (next != null && friendId.equals(next.getFriendId())) {
                        if (TextUtils.isEmpty(ownerName) && TextUtils.isEmpty(next.getOwnerName())) {
                            this.mList.remove(next);
                        } else if (!TextUtils.isEmpty(ownerName) && !TextUtils.isEmpty(next.getOwnerName()) && ownerName.equals(next.getOwnerName())) {
                            this.mList.remove(next);
                        }
                    }
                }
                if (aVar != null) {
                    aVar.axp();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyVisibilityMessage(new MemoryModifyVisibilityMessage.a(friendId, getCustomGroupType(imMessageCenterShowItemData), false)));
            }
        }
    }

    public List<ImMessageCenterShowItemData> getData() {
        return this.mList;
    }

    public void clearData() {
        if (this.mList != null) {
            this.mList.clear();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private void onComplete(a aVar) {
        Collections.sort(this.mList, new Comparator<ImMessageCenterShowItemData>() { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ImMessageCenterShowItemData imMessageCenterShowItemData, ImMessageCenterShowItemData imMessageCenterShowItemData2) {
                return imMessageCenterShowItemData.getServerTime() < imMessageCenterShowItemData2.getServerTime() ? 1 : -1;
            }
        });
        if (aVar != null) {
            aVar.axp();
        }
    }
}
