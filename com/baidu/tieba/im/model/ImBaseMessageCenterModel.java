package com.baidu.tieba.im.model;

import android.text.TextUtils;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.b78;
import com.baidu.tieba.c78;
import com.baidu.tieba.e88;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.jb8;
import com.baidu.tieba.k9;
import com.baidu.tieba.z88;
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
/* loaded from: classes6.dex */
public abstract class ImBaseMessageCenterModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k9 mBdPageContext;
    public final LinkedList<ImMessageCenterShowItemData> mList;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract boolean isAccept(ImMessageCenterPojo imMessageCenterPojo);

    public abstract boolean isToShow(ImMessageCenterPojo imMessageCenterPojo);

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImBaseMessageCenterModel(k9 k9Var) {
        super(k9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mList = new LinkedList<>();
        this.mBdPageContext = k9Var;
    }

    public void queryMarkTopStatus(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && !ListUtils.isEmpty(this.mList) && !TextUtils.isEmpty(str)) {
            Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
            while (it.hasNext()) {
                ImMessageCenterShowItemData next = it.next();
                if (str.equals(next.getFriendId())) {
                    next.setMarkTopIndex(jb8.a(str));
                    return;
                }
            }
        }
    }

    public boolean removeItemInList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
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

    private void onComplete(b78 b78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, b78Var) == null) {
            sortList();
            if (b78Var != null) {
                b78Var.onComplete();
            }
        }
    }

    private ImMessageCenterShowItemData removeItem(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, imMessageCenterPojo)) == null) {
            int size = this.mList.size();
            for (int i = 0; i < size; i++) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.mList.get(i);
                if (imMessageCenterPojo.getGid().equals(imMessageCenterShowItemData.getFriendId()) && imMessageCenterPojo.getCustomGroupType() == getCustomGroupType(imMessageCenterShowItemData)) {
                    return this.mList.remove(i);
                }
            }
            return null;
        }
        return (ImMessageCenterShowItemData) invokeL.objValue;
    }

    public ImMessageCenterShowItemData getRemoveItemByRoomId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.mList)) {
                Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
                while (it.hasNext()) {
                    ImMessageCenterShowItemData next = it.next();
                    if (!TextUtils.isEmpty(next.getFriendId()) && str.equals(next.getFriendId())) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (ImMessageCenterShowItemData) invokeL.objValue;
    }

    public void asyncDeleteItem(ImMessageCenterShowItemData imMessageCenterShowItemData, c78 c78Var) {
        LinkedList<ImMessageCenterShowItemData> linkedList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, imMessageCenterShowItemData, c78Var) != null) || imMessageCenterShowItemData == null) {
            return;
        }
        String friendId = imMessageCenterShowItemData.getFriendId();
        if (!TextUtils.isEmpty(friendId) && (linkedList = this.mList) != null && linkedList.size() != 0) {
            ResponsePullMessage.addDeleteTempItem(ResponsePullMessage.DeleteTempItem.create(imMessageCenterShowItemData.getFriendId(), getCustomGroupType(imMessageCenterShowItemData)));
            e88.l().a(imMessageCenterShowItemData, getCustomGroupType(imMessageCenterShowItemData), new c78(this, c78Var, imMessageCenterShowItemData, friendId) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int mLastProgress;
                public final List<Pair<String, Integer>> mRemoveCache;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;
                public final /* synthetic */ ImMessageCenterShowItemData val$data;
                public final /* synthetic */ c78 val$iProcess;
                public final /* synthetic */ String val$id;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, c78Var, imMessageCenterShowItemData, friendId};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$iProcess = c78Var;
                    this.val$data = imMessageCenterShowItemData;
                    this.val$id = friendId;
                    this.mRemoveCache = new ArrayList();
                    this.mLastProgress = 0;
                }

                private boolean checkMergeGroupMemoryChanged(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(65537, this, i)) == null) {
                        if (i == -7) {
                            if (this.this$0.isEmpty()) {
                                this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                            } else {
                                z88.n().M();
                            }
                            return true;
                        } else if (i == -8) {
                            if (this.this$0.isEmpty()) {
                                this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                            } else {
                                z88.n().J();
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
                                e88.l().q(pair.first, pair.second.intValue());
                            }
                        }
                        this.mRemoveCache.clear();
                    }
                }

                @Override // com.baidu.tieba.c78
                public void onCanceled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        clearRemoveCache();
                        checkMergeGroupMemoryChanged(this.this$0.getCustomGroupType(this.val$data));
                        c78 c78Var2 = this.val$iProcess;
                        if (c78Var2 != null) {
                            c78Var2.onCanceled();
                        }
                    }
                }

                @Override // com.baidu.tieba.c78
                public void onPreExecute() {
                    c78 c78Var2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (c78Var2 = this.val$iProcess) != null) {
                        c78Var2.onPreExecute();
                    }
                }

                @Override // com.baidu.tieba.c78
                public void onPostExecute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        clearRemoveCache();
                        int customGroupType = this.this$0.getCustomGroupType(this.val$data);
                        if (!checkMergeGroupMemoryChanged(customGroupType)) {
                            this.this$0.removeByKeyMemoryChangedWithBroadcast(this.val$id, customGroupType);
                        }
                        if (customGroupType == 9) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921762, this.val$data));
                        }
                        c78 c78Var2 = this.val$iProcess;
                        if (c78Var2 != null) {
                            c78Var2.onPostExecute();
                        }
                    }
                }

                @Override // com.baidu.tieba.c78
                public void onProgressUpdate(int i, String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                        this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i2)));
                        if (this.mRemoveCache.size() >= 20 || i != this.mLastProgress) {
                            clearRemoveCache();
                            c78 c78Var2 = this.val$iProcess;
                            if (c78Var2 != null) {
                                c78Var2.onProgressUpdate(i, str, i2);
                            }
                        }
                        this.mLastProgress = i;
                    }
                }
            });
        }
    }

    public void insertOrUpdate(ImMessageCenterPojo imMessageCenterPojo, b78 b78Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, imMessageCenterPojo, b78Var) != null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid()) || !isAccept(imMessageCenterPojo)) {
            return;
        }
        ImMessageCenterShowItemData removeItem = removeItem(imMessageCenterPojo);
        if (!isToShow(imMessageCenterPojo)) {
            if (b78Var != null) {
                b78Var.onComplete();
                return;
            }
            return;
        }
        processMsg(imMessageCenterPojo, removeItem);
        onComplete(b78Var);
    }

    public void setData(List<ImMessageCenterPojo> list, b78 b78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, list, b78Var) == null) {
            LinkedList<ImMessageCenterShowItemData> linkedList = this.mList;
            if (linkedList != null) {
                linkedList.clear();
            }
            if (ListUtils.isEmpty(list)) {
                if (b78Var != null) {
                    b78Var.onComplete();
                    return;
                }
                return;
            }
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null && isToShow(imMessageCenterPojo)) {
                    processMsg(imMessageCenterPojo, null);
                }
            }
            onComplete(b78Var);
        }
    }

    public void asyncDeleteMsgList(List<ImMessageCenterShowItemData> list, int i, c78 c78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i, c78Var) == null) {
            e88.l().b(list, i, new c78(this, c78Var, i) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int mLastProgress;
                public final List<Pair<String, Integer>> mRemoveCache;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;
                public final /* synthetic */ int val$customGroupType;
                public final /* synthetic */ c78 val$iProcess;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, c78Var, Integer.valueOf(i)};
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
                    this.val$iProcess = c78Var;
                    this.val$customGroupType = i;
                    this.mRemoveCache = new ArrayList();
                    this.mLastProgress = 0;
                }

                @Override // com.baidu.tieba.c78
                public void onProgressUpdate(int i2, String str, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                        this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i3)));
                        if (this.mRemoveCache.size() >= 20 || i2 != this.mLastProgress) {
                            clearRemoveCache();
                            c78 c78Var2 = this.val$iProcess;
                            if (c78Var2 != null) {
                                c78Var2.onProgressUpdate(i2, str, i3);
                            }
                        }
                        this.mLastProgress = i2;
                    }
                }

                private void checkListMemoryChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(65537, this, i2) == null) {
                        if (i2 == 2) {
                            if (this.this$0.isEmpty()) {
                                this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                            } else {
                                z88.n().M();
                            }
                        } else if (i2 == 4) {
                            if (this.this$0.isEmpty()) {
                                this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                            } else {
                                z88.n().J();
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
                                e88.l().q(pair.first, pair.second.intValue());
                            }
                        }
                        this.mRemoveCache.clear();
                    }
                }

                @Override // com.baidu.tieba.c78
                public void onCanceled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        clearRemoveCache();
                        checkListMemoryChanged(this.val$customGroupType);
                        c78 c78Var2 = this.val$iProcess;
                        if (c78Var2 != null) {
                            c78Var2.onCanceled();
                        }
                    }
                }

                @Override // com.baidu.tieba.c78
                public void onPostExecute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        clearRemoveCache();
                        checkListMemoryChanged(this.val$customGroupType);
                        c78 c78Var2 = this.val$iProcess;
                        if (c78Var2 != null) {
                            c78Var2.onPostExecute();
                        }
                    }
                }

                @Override // com.baidu.tieba.c78
                public void onPreExecute() {
                    c78 c78Var2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (c78Var2 = this.val$iProcess) != null) {
                        c78Var2.onPreExecute();
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
            imMessageCenterShowItemData.setRelation(imMessageCenterPojo.getIsFriend());
            imMessageCenterShowItemData.setUserExtraData(imMessageCenterPojo.getImUserExtraData());
            return imMessageCenterShowItemData;
        }
        return (ImMessageCenterShowItemData) invokeLL.objValue;
    }

    public void clearData() {
        LinkedList<ImMessageCenterShowItemData> linkedList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (linkedList = this.mList) != null) {
            linkedList.clear();
        }
    }

    public List<ImMessageCenterShowItemData> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mList;
        }
        return (List) invokeV.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return ListUtils.isEmpty(this.mList);
        }
        return invokeV.booleanValue;
    }

    public void sortList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, imMessageCenterShowItemData, imMessageCenterShowItemData2)) == null) {
                        try {
                            if (!ListUtils.isEmpty(this.this$0.mList) && imMessageCenterShowItemData != null && imMessageCenterShowItemData2 != null) {
                                if (imMessageCenterShowItemData.getMarkTopIndex() > 0 && imMessageCenterShowItemData2.getMarkTopIndex() > 0) {
                                    if (imMessageCenterShowItemData.getMarkTopIndex() == imMessageCenterShowItemData2.getMarkTopIndex()) {
                                        return 0;
                                    }
                                    if (imMessageCenterShowItemData.getMarkTopIndex() <= imMessageCenterShowItemData2.getMarkTopIndex()) {
                                        return 1;
                                    }
                                    return -1;
                                } else if (imMessageCenterShowItemData.getMarkTopIndex() > 0) {
                                    return -1;
                                } else {
                                    if (imMessageCenterShowItemData2.getMarkTopIndex() > 0) {
                                        return 1;
                                    }
                                    if (imMessageCenterShowItemData.getServerTime() == imMessageCenterShowItemData2.getServerTime()) {
                                        return 0;
                                    }
                                    if (imMessageCenterShowItemData.getServerTime() <= imMessageCenterShowItemData2.getServerTime()) {
                                        return 1;
                                    }
                                    return -1;
                                }
                            }
                            return 0;
                        } catch (Exception unused) {
                            if (imMessageCenterShowItemData.getMarkTopIndex() > 0 && imMessageCenterShowItemData2.getMarkTopIndex() > 0) {
                                if (imMessageCenterShowItemData.getMarkTopIndex() < imMessageCenterShowItemData2.getMarkTopIndex()) {
                                    return 1;
                                }
                                return -1;
                            } else if (imMessageCenterShowItemData.getMarkTopIndex() > 0) {
                                return -1;
                            } else {
                                if (imMessageCenterShowItemData2.getMarkTopIndex() > 0 || imMessageCenterShowItemData.getServerTime() < imMessageCenterShowItemData2.getServerTime()) {
                                    return 1;
                                }
                                return -1;
                            }
                        }
                    }
                    return invokeLL.intValue;
                }
            });
        }
    }

    public List<String> getUids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (ListUtils.isEmpty(this.mList)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(this.mList.size());
            Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getFriendId());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void insertShowData(ImMessageCenterShowItemData imMessageCenterShowItemData, List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, imMessageCenterShowItemData, list) == null) && imMessageCenterShowItemData != null && list != null) {
            list.add(imMessageCenterShowItemData);
        }
    }

    public void remove(ImMessageCenterPojo imMessageCenterPojo, b78 b78Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, imMessageCenterPojo, b78Var) == null) && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            removeItem(imMessageCenterPojo);
            if (b78Var != null) {
                b78Var.onComplete();
            }
        }
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, str, i) == null) {
            e88.l().p(str, i);
        }
    }

    public boolean removeItemInList(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, imMessageCenterShowItemData)) == null) {
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

    public void updateGroupchatList(List<ImMessageCenterPojo> list, b78 b78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, list, b78Var) == null) {
            if (ListUtils.isEmpty(list)) {
                if (b78Var != null) {
                    b78Var.onComplete();
                    return;
                }
                return;
            }
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null && isToShow(imMessageCenterPojo)) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = new ImMessageCenterShowItemData();
                    imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
                    if (this.mList.contains(imMessageCenterShowItemData)) {
                        this.mList.remove(imMessageCenterShowItemData);
                    }
                    processMsg(imMessageCenterPojo, null);
                }
            }
            onComplete(b78Var);
        }
    }
}
