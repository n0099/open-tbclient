package com.baidu.tieba.im.model;

import android.text.TextUtils;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.r0.l1.f.i.a;
import b.a.r0.l1.f.i.b;
import b.a.r0.l1.h.e;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class ImBaseMessageCenterModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f mBdPageContext;
    public final LinkedList<ImMessageCenterShowItemData> mList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImBaseMessageCenterModel(f fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mList = new LinkedList<>();
        this.mBdPageContext = fVar;
    }

    private void onComplete(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            Collections.sort(this.mList, new Comparator<ImMessageCenterShowItemData>(this) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(ImMessageCenterShowItemData imMessageCenterShowItemData, ImMessageCenterShowItemData imMessageCenterShowItemData2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, imMessageCenterShowItemData, imMessageCenterShowItemData2)) == null) ? imMessageCenterShowItemData.getServerTime() < imMessageCenterShowItemData2.getServerTime() ? 1 : -1 : invokeLL.intValue;
                }
            });
            if (aVar != null) {
                aVar.onComplete();
            }
        }
    }

    private ImMessageCenterShowItemData removeItem(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, imMessageCenterPojo)) == null) {
            int size = this.mList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.mList.get(i2);
                if (imMessageCenterPojo.getGid().equals(imMessageCenterShowItemData.getFriendId()) && imMessageCenterPojo.getCustomGroupType() == getCustomGroupType(imMessageCenterShowItemData)) {
                    return this.mList.remove(i2);
                }
            }
            return null;
        }
        return (ImMessageCenterShowItemData) invokeL.objValue;
    }

    public void asyncDeleteItem(ImMessageCenterShowItemData imMessageCenterShowItemData, b bVar) {
        LinkedList<ImMessageCenterShowItemData> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imMessageCenterShowItemData, bVar) == null) || imMessageCenterShowItemData == null) {
            return;
        }
        String friendId = imMessageCenterShowItemData.getFriendId();
        if (TextUtils.isEmpty(friendId) || (linkedList = this.mList) == null || linkedList.size() == 0) {
            return;
        }
        e.m().a(imMessageCenterShowItemData, getCustomGroupType(imMessageCenterShowItemData), new b(this, bVar, imMessageCenterShowItemData, friendId) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int mLastProgress;
            public final List<Pair<String, Integer>> mRemoveCache;
            public final /* synthetic */ ImBaseMessageCenterModel this$0;
            public final /* synthetic */ ImMessageCenterShowItemData val$data;
            public final /* synthetic */ b val$iProcess;
            public final /* synthetic */ String val$id;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bVar, imMessageCenterShowItemData, friendId};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$iProcess = bVar;
                this.val$data = imMessageCenterShowItemData;
                this.val$id = friendId;
                this.mRemoveCache = new ArrayList();
                this.mLastProgress = 0;
            }

            private boolean checkMergeGroupMemoryChanged(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(65537, this, i2)) == null) {
                    if (i2 == -7) {
                        if (this.this$0.isEmpty()) {
                            this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                        } else {
                            b.a.r0.l1.k.b.o().Q();
                        }
                        return true;
                    } else if (i2 == -8) {
                        if (this.this$0.isEmpty()) {
                            this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                        } else {
                            b.a.r0.l1.k.b.o().N();
                        }
                        return true;
                    } else {
                        return false;
                    }
                }
                return invokeI.booleanValue;
            }

            private void clearRemoveCache() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(65538, this) == null) {
                    for (Pair<String, Integer> pair : this.mRemoveCache) {
                        if (pair != null && !TextUtils.isEmpty(pair.first)) {
                            e.m().r(pair.first, pair.second.intValue());
                        }
                    }
                    this.mRemoveCache.clear();
                }
            }

            @Override // b.a.r0.l1.f.i.b
            public void onCanceled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    clearRemoveCache();
                    checkMergeGroupMemoryChanged(this.this$0.getCustomGroupType(this.val$data));
                    b bVar2 = this.val$iProcess;
                    if (bVar2 != null) {
                        bVar2.onCanceled();
                    }
                }
            }

            @Override // b.a.r0.l1.f.i.b
            public void onPostExecute() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    clearRemoveCache();
                    int customGroupType = this.this$0.getCustomGroupType(this.val$data);
                    if (!checkMergeGroupMemoryChanged(customGroupType)) {
                        this.this$0.removeByKeyMemoryChangedWithBroadcast(this.val$id, customGroupType);
                    }
                    b bVar2 = this.val$iProcess;
                    if (bVar2 != null) {
                        bVar2.onPostExecute();
                    }
                }
            }

            @Override // b.a.r0.l1.f.i.b
            public void onPreExecute() {
                b bVar2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar2 = this.val$iProcess) == null) {
                    return;
                }
                bVar2.onPreExecute();
            }

            @Override // b.a.r0.l1.f.i.b
            public void onProgressUpdate(int i2, String str, int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                    this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i3)));
                    if (this.mRemoveCache.size() >= 20 || i2 != this.mLastProgress) {
                        clearRemoveCache();
                        b bVar2 = this.val$iProcess;
                        if (bVar2 != null) {
                            bVar2.onProgressUpdate(i2, str, i3);
                        }
                    }
                    this.mLastProgress = i2;
                }
            }
        });
    }

    public void asyncDeleteMsgList(List<ImMessageCenterShowItemData> list, int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2, bVar) == null) {
            e.m().b(list, i2, new b(this, bVar, i2) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int mLastProgress;
                public final List<Pair<String, Integer>> mRemoveCache;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;
                public final /* synthetic */ int val$customGroupType;
                public final /* synthetic */ b val$iProcess;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$iProcess = bVar;
                    this.val$customGroupType = i2;
                    this.mRemoveCache = new ArrayList();
                    this.mLastProgress = 0;
                }

                private void checkListMemoryChanged(int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(65537, this, i3) == null) {
                        if (i3 == 2) {
                            if (this.this$0.isEmpty()) {
                                this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                            } else {
                                b.a.r0.l1.k.b.o().Q();
                            }
                        } else if (i3 == 4) {
                            if (this.this$0.isEmpty()) {
                                this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                            } else {
                                b.a.r0.l1.k.b.o().N();
                            }
                        }
                    }
                }

                private void clearRemoveCache() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65538, this) == null) {
                        for (Pair<String, Integer> pair : this.mRemoveCache) {
                            if (pair != null && !TextUtils.isEmpty(pair.first)) {
                                this.this$0.removeItemInList(pair.first);
                                e.m().r(pair.first, pair.second.intValue());
                            }
                        }
                        this.mRemoveCache.clear();
                    }
                }

                @Override // b.a.r0.l1.f.i.b
                public void onCanceled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        clearRemoveCache();
                        checkListMemoryChanged(this.val$customGroupType);
                        b bVar2 = this.val$iProcess;
                        if (bVar2 != null) {
                            bVar2.onCanceled();
                        }
                    }
                }

                @Override // b.a.r0.l1.f.i.b
                public void onPostExecute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        clearRemoveCache();
                        checkListMemoryChanged(this.val$customGroupType);
                        b bVar2 = this.val$iProcess;
                        if (bVar2 != null) {
                            bVar2.onPostExecute();
                        }
                    }
                }

                @Override // b.a.r0.l1.f.i.b
                public void onPreExecute() {
                    b bVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar2 = this.val$iProcess) == null) {
                        return;
                    }
                    bVar2.onPreExecute();
                }

                @Override // b.a.r0.l1.f.i.b
                public void onProgressUpdate(int i3, String str, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4)}) == null) {
                        this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i4)));
                        if (this.mRemoveCache.size() >= 20 || i3 != this.mLastProgress) {
                            clearRemoveCache();
                            b bVar2 = this.val$iProcess;
                            if (bVar2 != null) {
                                bVar2.onProgressUpdate(i3, str, i4);
                            }
                        }
                        this.mLastProgress = i3;
                    }
                }
            });
        }
    }

    public ImMessageCenterShowItemData buildNormalItem(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
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
        return (ImMessageCenterShowItemData) invokeLL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void clearData() {
        LinkedList<ImMessageCenterShowItemData> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linkedList = this.mList) == null) {
            return;
        }
        linkedList.clear();
    }

    public abstract int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public List<ImMessageCenterShowItemData> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mList : (List) invokeV.objValue;
    }

    public void insertOrUpdate(ImMessageCenterPojo imMessageCenterPojo, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, imMessageCenterPojo, aVar) == null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid()) || !isAccept(imMessageCenterPojo)) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterShowItemData, list) == null) || imMessageCenterShowItemData == null || list == null) {
            return;
        }
        list.add(imMessageCenterShowItemData);
    }

    public abstract boolean isAccept(ImMessageCenterPojo imMessageCenterPojo);

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ListUtils.isEmpty(this.mList) : invokeV.booleanValue;
    }

    public abstract boolean isToShow(ImMessageCenterPojo imMessageCenterPojo);

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public void remove(ImMessageCenterPojo imMessageCenterPojo, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, imMessageCenterPojo, aVar) == null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            return;
        }
        removeItem(imMessageCenterPojo);
        if (aVar != null) {
            aVar.onComplete();
        }
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, str, i2) == null) {
            e.m().q(str, i2);
        }
    }

    public boolean removeItemInList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public void setData(List<ImMessageCenterPojo> list, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, list, aVar) == null) {
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
    }

    public boolean removeItemInList(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, imMessageCenterShowItemData)) == null) {
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
        return invokeL.booleanValue;
    }
}
