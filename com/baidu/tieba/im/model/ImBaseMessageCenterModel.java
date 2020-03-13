package com.baidu.tieba.im.model;

import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.im.chat.a.a;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ImBaseMessageCenterModel extends BdBaseModel<Object> {
    private e mBdPageContext;
    protected final LinkedList<ImMessageCenterShowItemData> mList;

    protected abstract int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean isAccept(ImMessageCenterPojo imMessageCenterPojo);

    protected abstract boolean isToShow(ImMessageCenterPojo imMessageCenterPojo);

    protected abstract void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData);

    /* JADX INFO: Access modifiers changed from: protected */
    public ImBaseMessageCenterModel(e eVar) {
        super(eVar);
        this.mList = new LinkedList<>();
        this.mBdPageContext = eVar;
    }

    public void insertOrUpdate(ImMessageCenterPojo imMessageCenterPojo, a aVar) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid()) && isAccept(imMessageCenterPojo)) {
            ImMessageCenterShowItemData removeItem = removeItem(imMessageCenterPojo);
            if (!isToShow(imMessageCenterPojo)) {
                if (aVar != null) {
                    aVar.onComplete();
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
                aVar.onComplete();
            }
        }
    }

    public void setData(List<ImMessageCenterPojo> list, a aVar) {
        this.mList.clear();
        if (list == null) {
            if (aVar != null) {
                aVar.onComplete();
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
        if (imMessageCenterPojo.getIs_hidden() == 1 || ((TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) || imMessageCenterPojo.getLast_content_time() == 0)) {
            return null;
        }
        if (imMessageCenterShowItemData == null) {
            imMessageCenterShowItemData = new ImMessageCenterShowItemData();
        }
        imMessageCenterShowItemData.setUserType(imMessageCenterPojo.getUserType());
        imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
        imMessageCenterShowItemData.setOwnerId(TbadkCoreApplication.getCurrentAccount());
        imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
        imMessageCenterShowItemData.setFriendNameShow(imMessageCenterPojo.getNameShow());
        imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
        imMessageCenterShowItemData.setFriendBjhAvatar(imMessageCenterPojo.getBjhAvatar());
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

    public void asyncDeleteItem(final ImMessageCenterShowItemData imMessageCenterShowItemData, final b bVar) {
        if (imMessageCenterShowItemData != null) {
            final String friendId = imMessageCenterShowItemData.getFriendId();
            if (!TextUtils.isEmpty(friendId) && this.mList != null && this.mList.size() != 0) {
                com.baidu.tieba.im.db.e.bUo().a(imMessageCenterShowItemData, getCustomGroupType(imMessageCenterShowItemData), new b() { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.1
                    private final List<Pair<String, Integer>> mRemoveCache = new ArrayList();
                    private int mLastProgress = 0;

                    @Override // com.baidu.tieba.im.chat.a.b
                    public void onPreExecute() {
                        if (bVar != null) {
                            bVar.onPreExecute();
                        }
                    }

                    private void clearRemoveCache() {
                        for (Pair<String, Integer> pair : this.mRemoveCache) {
                            if (pair != null && !TextUtils.isEmpty(pair.first)) {
                                com.baidu.tieba.im.db.e.bUo().aP(pair.first, pair.second.intValue());
                            }
                        }
                        this.mRemoveCache.clear();
                    }

                    @Override // com.baidu.tieba.im.chat.a.b
                    public void onProgressUpdate(int i, String str, int i2) {
                        this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i2)));
                        if (this.mRemoveCache.size() >= 20 || i != this.mLastProgress) {
                            clearRemoveCache();
                            if (bVar != null) {
                                bVar.onProgressUpdate(i, str, i2);
                            }
                        }
                        this.mLastProgress = i;
                    }

                    @Override // com.baidu.tieba.im.chat.a.b
                    public void onPostExecute() {
                        clearRemoveCache();
                        int customGroupType = ImBaseMessageCenterModel.this.getCustomGroupType(imMessageCenterShowItemData);
                        if (!checkMergeGroupMemoryChanged(customGroupType)) {
                            ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(friendId, customGroupType);
                        }
                        if (bVar != null) {
                            bVar.onPostExecute();
                        }
                    }

                    @Override // com.baidu.tieba.im.chat.a.b
                    public void onCanceled() {
                        clearRemoveCache();
                        checkMergeGroupMemoryChanged(ImBaseMessageCenterModel.this.getCustomGroupType(imMessageCenterShowItemData));
                        if (bVar != null) {
                            bVar.onCanceled();
                        }
                    }

                    private boolean checkMergeGroupMemoryChanged(int i) {
                        if (i == -7) {
                            if (ImBaseMessageCenterModel.this.isEmpty()) {
                                ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                                return true;
                            }
                            com.baidu.tieba.im.memorycache.b.bWJ().bWT();
                            return true;
                        } else if (i == -8) {
                            if (ImBaseMessageCenterModel.this.isEmpty()) {
                                ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                                return true;
                            }
                            com.baidu.tieba.im.memorycache.b.bWJ().bWS();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
            }
        }
    }

    public void asyncDeleteMsgList(List<ImMessageCenterShowItemData> list, final int i, final b bVar) {
        com.baidu.tieba.im.db.e.bUo().a(list, i, new b() { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.2
            private final List<Pair<String, Integer>> mRemoveCache = new ArrayList();
            private int mLastProgress = 0;

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                if (bVar != null) {
                    bVar.onPreExecute();
                }
            }

            private void clearRemoveCache() {
                for (Pair<String, Integer> pair : this.mRemoveCache) {
                    if (pair != null && !TextUtils.isEmpty(pair.first)) {
                        ImBaseMessageCenterModel.this.removeItemInList(pair.first);
                        com.baidu.tieba.im.db.e.bUo().aP(pair.first, pair.second.intValue());
                    }
                }
                this.mRemoveCache.clear();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i2, String str, int i3) {
                this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i3)));
                if (this.mRemoveCache.size() >= 20 || i2 != this.mLastProgress) {
                    clearRemoveCache();
                    if (bVar != null) {
                        bVar.onProgressUpdate(i2, str, i3);
                    }
                }
                this.mLastProgress = i2;
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                clearRemoveCache();
                checkListMemoryChanged(i);
                if (bVar != null) {
                    bVar.onPostExecute();
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                clearRemoveCache();
                checkListMemoryChanged(i);
                if (bVar != null) {
                    bVar.onCanceled();
                }
            }

            private void checkListMemoryChanged(int i2) {
                if (i2 == 2) {
                    if (ImBaseMessageCenterModel.this.isEmpty()) {
                        ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                    } else {
                        com.baidu.tieba.im.memorycache.b.bWJ().bWT();
                    }
                } else if (i2 == 4) {
                    if (ImBaseMessageCenterModel.this.isEmpty()) {
                        ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                    } else {
                        com.baidu.tieba.im.memorycache.b.bWJ().bWS();
                    }
                }
            }
        });
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        com.baidu.tieba.im.db.e.bUo().removeByKeyMemoryChangedWithBroadcast(str, i);
    }

    public boolean removeItemInList(String str) {
        if (this.mList == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
        while (it.hasNext()) {
            ImMessageCenterShowItemData next = it.next();
            if (next != null && str.equals(next.getFriendId())) {
                this.mList.remove(next);
                return true;
            }
        }
        return false;
    }

    public boolean removeItemInList(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (v.isEmpty(this.mList) || imMessageCenterShowItemData == null) {
            return false;
        }
        String friendId = imMessageCenterShowItemData.getFriendId();
        if (TextUtils.isEmpty(friendId)) {
            return false;
        }
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
                    return true;
                } else if (!TextUtils.isEmpty(ownerName) && !TextUtils.isEmpty(next.getOwnerName()) && ownerName.equals(next.getOwnerName())) {
                    this.mList.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    public List<ImMessageCenterShowItemData> getData() {
        return this.mList;
    }

    public void clearData() {
        if (this.mList != null) {
            this.mList.clear();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.mList);
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
        Collections.sort(this.mList, new Comparator<ImMessageCenterShowItemData>() { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ImMessageCenterShowItemData imMessageCenterShowItemData, ImMessageCenterShowItemData imMessageCenterShowItemData2) {
                return imMessageCenterShowItemData.getServerTime() < imMessageCenterShowItemData2.getServerTime() ? 1 : -1;
            }
        });
        if (aVar != null) {
            aVar.onComplete();
        }
    }
}
