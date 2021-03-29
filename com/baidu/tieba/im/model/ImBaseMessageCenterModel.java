package com.baidu.tieba.im.model;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import d.b.b.a.f;
import d.b.i0.d1.f.i.a;
import d.b.i0.d1.f.i.b;
import d.b.i0.d1.h.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class ImBaseMessageCenterModel extends BdBaseModel<Object> {
    public f mBdPageContext;
    public final LinkedList<ImMessageCenterShowItemData> mList;

    public ImBaseMessageCenterModel(f fVar) {
        super(fVar);
        this.mList = new LinkedList<>();
        this.mBdPageContext = fVar;
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void asyncDeleteItem(final ImMessageCenterShowItemData imMessageCenterShowItemData, final b bVar) {
        LinkedList<ImMessageCenterShowItemData> linkedList;
        if (imMessageCenterShowItemData == null) {
            return;
        }
        final String friendId = imMessageCenterShowItemData.getFriendId();
        if (TextUtils.isEmpty(friendId) || (linkedList = this.mList) == null || linkedList.size() == 0) {
            return;
        }
        e.m().a(imMessageCenterShowItemData, getCustomGroupType(imMessageCenterShowItemData), new b() { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.1
            public final List<Pair<String, Integer>> mRemoveCache = new ArrayList();
            public int mLastProgress = 0;

            private boolean checkMergeGroupMemoryChanged(int i) {
                if (i == -7) {
                    if (ImBaseMessageCenterModel.this.isEmpty()) {
                        ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                    } else {
                        d.b.i0.d1.k.b.o().Q();
                    }
                    return true;
                } else if (i == -8) {
                    if (ImBaseMessageCenterModel.this.isEmpty()) {
                        ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                    } else {
                        d.b.i0.d1.k.b.o().N();
                    }
                    return true;
                } else {
                    return false;
                }
            }

            private void clearRemoveCache() {
                for (Pair<String, Integer> pair : this.mRemoveCache) {
                    if (pair != null && !TextUtils.isEmpty(pair.first)) {
                        e.m().r(pair.first, pair.second.intValue());
                    }
                }
                this.mRemoveCache.clear();
            }

            @Override // d.b.i0.d1.f.i.b
            public void onCanceled() {
                clearRemoveCache();
                checkMergeGroupMemoryChanged(ImBaseMessageCenterModel.this.getCustomGroupType(imMessageCenterShowItemData));
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.onCanceled();
                }
            }

            @Override // d.b.i0.d1.f.i.b
            public void onPostExecute() {
                clearRemoveCache();
                int customGroupType = ImBaseMessageCenterModel.this.getCustomGroupType(imMessageCenterShowItemData);
                if (!checkMergeGroupMemoryChanged(customGroupType)) {
                    ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(friendId, customGroupType);
                }
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.onPostExecute();
                }
            }

            @Override // d.b.i0.d1.f.i.b
            public void onPreExecute() {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.onPreExecute();
                }
            }

            @Override // d.b.i0.d1.f.i.b
            public void onProgressUpdate(int i, String str, int i2) {
                this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i2)));
                if (this.mRemoveCache.size() >= 20 || i != this.mLastProgress) {
                    clearRemoveCache();
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onProgressUpdate(i, str, i2);
                    }
                }
                this.mLastProgress = i;
            }
        });
    }

    public void asyncDeleteMsgList(List<ImMessageCenterShowItemData> list, final int i, final b bVar) {
        e.m().b(list, i, new b() { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.2
            public final List<Pair<String, Integer>> mRemoveCache = new ArrayList();
            public int mLastProgress = 0;

            private void checkListMemoryChanged(int i2) {
                if (i2 == 2) {
                    if (ImBaseMessageCenterModel.this.isEmpty()) {
                        ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                    } else {
                        d.b.i0.d1.k.b.o().Q();
                    }
                } else if (i2 == 4) {
                    if (ImBaseMessageCenterModel.this.isEmpty()) {
                        ImBaseMessageCenterModel.this.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                    } else {
                        d.b.i0.d1.k.b.o().N();
                    }
                }
            }

            private void clearRemoveCache() {
                for (Pair<String, Integer> pair : this.mRemoveCache) {
                    if (pair != null && !TextUtils.isEmpty(pair.first)) {
                        ImBaseMessageCenterModel.this.removeItemInList(pair.first);
                        e.m().r(pair.first, pair.second.intValue());
                    }
                }
                this.mRemoveCache.clear();
            }

            @Override // d.b.i0.d1.f.i.b
            public void onCanceled() {
                clearRemoveCache();
                checkListMemoryChanged(i);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.onCanceled();
                }
            }

            @Override // d.b.i0.d1.f.i.b
            public void onPostExecute() {
                clearRemoveCache();
                checkListMemoryChanged(i);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.onPostExecute();
                }
            }

            @Override // d.b.i0.d1.f.i.b
            public void onPreExecute() {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.onPreExecute();
                }
            }

            @Override // d.b.i0.d1.f.i.b
            public void onProgressUpdate(int i2, String str, int i3) {
                this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i3)));
                if (this.mRemoveCache.size() >= 20 || i2 != this.mLastProgress) {
                    clearRemoveCache();
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onProgressUpdate(i2, str, i3);
                    }
                }
                this.mLastProgress = i2;
            }
        });
    }

    public ImMessageCenterShowItemData buildNormalItem(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getIs_hidden() == 1 || ((TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) || imMessageCenterPojo.getLast_content_time() == 0)) {
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void clearData() {
        LinkedList<ImMessageCenterShowItemData> linkedList = this.mList;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    public abstract int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public List<ImMessageCenterShowItemData> getData() {
        return this.mList;
    }

    public void insertOrUpdate(ImMessageCenterPojo imMessageCenterPojo, a aVar) {
        if (imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid()) || !isAccept(imMessageCenterPojo)) {
            return;
        }
        ImMessageCenterShowItemData removeItem = removeItem(imMessageCenterPojo);
        if (isToShow(imMessageCenterPojo)) {
            processMsg(imMessageCenterPojo, removeItem);
            onComplete(aVar);
        } else if (aVar != null) {
            aVar.onComplete();
        }
    }

    public void insertShowData(ImMessageCenterShowItemData imMessageCenterShowItemData, List<ImMessageCenterShowItemData> list) {
        if (imMessageCenterShowItemData == null || list == null) {
            return;
        }
        list.add(imMessageCenterShowItemData);
    }

    public abstract boolean isAccept(ImMessageCenterPojo imMessageCenterPojo);

    public boolean isEmpty() {
        return ListUtils.isEmpty(this.mList);
    }

    public abstract boolean isToShow(ImMessageCenterPojo imMessageCenterPojo);

    public abstract void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public void remove(ImMessageCenterPojo imMessageCenterPojo, a aVar) {
        if (imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            return;
        }
        removeItem(imMessageCenterPojo);
        if (aVar != null) {
            aVar.onComplete();
        }
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        e.m().q(str, i);
    }

    public boolean removeItemInList(String str) {
        if (this.mList != null && !TextUtils.isEmpty(str)) {
            Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
            while (it.hasNext()) {
                ImMessageCenterShowItemData next = it.next();
                if (next != null && str.equals(next.getFriendId())) {
                    this.mList.remove(next);
                    return true;
                }
            }
        }
        return false;
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

    public boolean removeItemInList(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (!ListUtils.isEmpty(this.mList) && imMessageCenterShowItemData != null) {
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
        }
        return false;
    }
}
