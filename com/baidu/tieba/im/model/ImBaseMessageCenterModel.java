package com.baidu.tieba.im.model;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.gs5;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.ks5;
import com.baidu.tieba.lr5;
import com.baidu.tieba.mj8;
import com.baidu.tieba.pc8;
import com.baidu.tieba.qc8;
import com.baidu.tieba.sd8;
import com.baidu.tieba.uf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class ImBaseMessageCenterModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ImMessageCenterShowItemData> mList;

    /* loaded from: classes6.dex */
    public interface AsyncCallback {
        void doInsert(@Nullable ImMessageCenterShowItemData imMessageCenterShowItemData);
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

    public abstract void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData, @Nullable AsyncCallback asyncCallback);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImBaseMessageCenterModel(BdPageContext bdPageContext) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mList = Collections.synchronizedList(new LinkedList());
    }

    public void queryMarkTopStatus(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && !ListUtils.isEmpty(this.mList) && !TextUtils.isEmpty(str)) {
            for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.mList) {
                if (str.equals(imMessageCenterShowItemData.getFriendId())) {
                    imMessageCenterShowItemData.setMarkTopIndex(mj8.a(str));
                    return;
                }
            }
        }
    }

    public boolean removeItemInList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (this.mList != null && !TextUtils.isEmpty(str)) {
                for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.mList) {
                    if (imMessageCenterShowItemData != null && str.equals(imMessageCenterShowItemData.getFriendId())) {
                        this.mList.remove(imMessageCenterShowItemData);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void insertShowData(ImMessageCenterShowItemData imMessageCenterShowItemData, List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, imMessageCenterShowItemData, list) == null) && imMessageCenterShowItemData != null && list != null && !list.contains(imMessageCenterShowItemData)) {
            list.add(imMessageCenterShowItemData);
        }
    }

    public void remove(ImMessageCenterPojo imMessageCenterPojo, pc8 pc8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, imMessageCenterPojo, pc8Var) == null) && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            removeItem(imMessageCenterPojo);
            if (pc8Var != null) {
                pc8Var.onComplete();
            }
        }
    }

    public void removeByKeyMemoryChangedWithBroadcast(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, str, i) == null) {
            sd8.l().p(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void insertShowDataList(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, list) == null) && list != null && !list.isEmpty()) {
            for (ImMessageCenterShowItemData imMessageCenterShowItemData : list) {
                insertShowData(imMessageCenterShowItemData, this.mList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onComplete(pc8 pc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, pc8Var) == null) {
            sortList();
            if (pc8Var != null) {
                pc8Var.onComplete();
            }
        }
    }

    private ImMessageCenterShowItemData removeItem(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, imMessageCenterPojo)) == null) {
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
                for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.mList) {
                    if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId()) && str.equals(imMessageCenterShowItemData.getFriendId())) {
                        return imMessageCenterShowItemData;
                    }
                }
            }
            return null;
        }
        return (ImMessageCenterShowItemData) invokeL.objValue;
    }

    public void asyncDeleteItem(ImMessageCenterShowItemData imMessageCenterShowItemData, qc8 qc8Var) {
        List<ImMessageCenterShowItemData> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, imMessageCenterShowItemData, qc8Var) != null) || imMessageCenterShowItemData == null) {
            return;
        }
        String friendId = imMessageCenterShowItemData.getFriendId();
        if (!TextUtils.isEmpty(friendId) && (list = this.mList) != null && list.size() != 0) {
            if (!imMessageCenterShowItemData.isAiBot()) {
                ResponsePullMessage.addDeleteTempItem(ResponsePullMessage.DeleteTempItem.create(imMessageCenterShowItemData.getFriendId(), getCustomGroupType(imMessageCenterShowItemData)));
            }
            sd8.l().a(imMessageCenterShowItemData, getCustomGroupType(imMessageCenterShowItemData), new qc8(this, qc8Var, imMessageCenterShowItemData, friendId) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int mLastProgress;
                public final List<Pair<String, Integer>> mRemoveCache;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;
                public final /* synthetic */ ImMessageCenterShowItemData val$data;
                public final /* synthetic */ qc8 val$iProcess;
                public final /* synthetic */ String val$id;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, qc8Var, imMessageCenterShowItemData, friendId};
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
                    this.val$iProcess = qc8Var;
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
                                uf8.n().M();
                            }
                            return true;
                        } else if (i == -8) {
                            if (this.this$0.isEmpty()) {
                                this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                            } else {
                                uf8.n().J();
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
                                sd8.l().q(pair.first, pair.second.intValue());
                            }
                        }
                        this.mRemoveCache.clear();
                    }
                }

                @Override // com.baidu.tieba.qc8
                public void onCanceled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        clearRemoveCache();
                        checkMergeGroupMemoryChanged(this.this$0.getCustomGroupType(this.val$data));
                        qc8 qc8Var2 = this.val$iProcess;
                        if (qc8Var2 != null) {
                            qc8Var2.onCanceled();
                        }
                    }
                }

                @Override // com.baidu.tieba.qc8
                public void onPreExecute() {
                    qc8 qc8Var2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (qc8Var2 = this.val$iProcess) != null) {
                        qc8Var2.onPreExecute();
                    }
                }

                @Override // com.baidu.tieba.qc8
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
                        qc8 qc8Var2 = this.val$iProcess;
                        if (qc8Var2 != null) {
                            qc8Var2.onPostExecute();
                        }
                    }
                }

                @Override // com.baidu.tieba.qc8
                public void onProgressUpdate(int i, String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                        this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i2)));
                        if (this.mRemoveCache.size() >= 20 || i != this.mLastProgress) {
                            clearRemoveCache();
                            qc8 qc8Var2 = this.val$iProcess;
                            if (qc8Var2 != null) {
                                qc8Var2.onProgressUpdate(i, str, i2);
                            }
                        }
                        this.mLastProgress = i;
                    }
                }
            });
        }
    }

    public void updateGroupchatList(List<ImMessageCenterPojo> list, pc8 pc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, list, pc8Var) == null) {
            if (ListUtils.isEmpty(list)) {
                if (pc8Var != null) {
                    pc8Var.onComplete();
                    return;
                }
                return;
            }
            List synchronizedList = Collections.synchronizedList(new ArrayList());
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null && isToShow(imMessageCenterPojo)) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = new ImMessageCenterShowItemData();
                    imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
                    this.mList.remove(imMessageCenterShowItemData);
                    synchronizedList.add(imMessageCenterPojo);
                }
            }
            ks5.c(new gs5<List<ImMessageCenterShowItemData>>(this, synchronizedList) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;
                public final /* synthetic */ List val$safeList;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, synchronizedList};
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
                    this.val$safeList = synchronizedList;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.gs5
                public List<ImMessageCenterShowItemData> doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (ImMessageCenterPojo imMessageCenterPojo2 : this.val$safeList) {
                            if (imMessageCenterPojo2 != null && this.this$0.isToShow(imMessageCenterPojo2)) {
                                this.this$0.processMsg(imMessageCenterPojo2, null, new AsyncCallback(this, arrayList) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass3 this$1;
                                    public final /* synthetic */ List val$resultList;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, arrayList};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$resultList = arrayList;
                                    }

                                    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel.AsyncCallback
                                    public void doInsert(@Nullable ImMessageCenterShowItemData imMessageCenterShowItemData2) {
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeL(1048576, this, imMessageCenterShowItemData2) == null) && imMessageCenterShowItemData2 != null) {
                                            this.val$resultList.add(imMessageCenterShowItemData2);
                                        }
                                    }
                                });
                            }
                        }
                        return arrayList;
                    }
                    return (List) invokeV.objValue;
                }
            }, new lr5<List<ImMessageCenterShowItemData>>(this, pc8Var) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;
                public final /* synthetic */ pc8 val$iCompleteProcess;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pc8Var};
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
                    this.val$iCompleteProcess = pc8Var;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.lr5
                public void onReturnDataInUI(List<ImMessageCenterShowItemData> list2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list2) == null) {
                        this.this$0.insertShowDataList(list2);
                        this.this$0.onComplete(this.val$iCompleteProcess);
                    }
                }
            });
        }
    }

    public void asyncDeleteMsgList(List<ImMessageCenterShowItemData> list, int i, qc8 qc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i, qc8Var) == null) {
            sd8.l().b(list, i, new qc8(this, qc8Var, i) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int mLastProgress;
                public final List<Pair<String, Integer>> mRemoveCache;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;
                public final /* synthetic */ int val$customGroupType;
                public final /* synthetic */ qc8 val$iProcess;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, qc8Var, Integer.valueOf(i)};
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
                    this.val$iProcess = qc8Var;
                    this.val$customGroupType = i;
                    this.mRemoveCache = new ArrayList();
                    this.mLastProgress = 0;
                }

                @Override // com.baidu.tieba.qc8
                public void onProgressUpdate(int i2, String str, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                        this.mRemoveCache.add(new Pair<>(str, Integer.valueOf(i3)));
                        if (this.mRemoveCache.size() >= 20 || i2 != this.mLastProgress) {
                            clearRemoveCache();
                            qc8 qc8Var2 = this.val$iProcess;
                            if (qc8Var2 != null) {
                                qc8Var2.onProgressUpdate(i2, str, i3);
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
                                uf8.n().M();
                            }
                        } else if (i2 == 4) {
                            if (this.this$0.isEmpty()) {
                                this.this$0.removeByKeyMemoryChangedWithBroadcast(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                            } else {
                                uf8.n().J();
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
                                sd8.l().q(pair.first, pair.second.intValue());
                            }
                        }
                        this.mRemoveCache.clear();
                    }
                }

                @Override // com.baidu.tieba.qc8
                public void onCanceled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        clearRemoveCache();
                        checkListMemoryChanged(this.val$customGroupType);
                        qc8 qc8Var2 = this.val$iProcess;
                        if (qc8Var2 != null) {
                            qc8Var2.onCanceled();
                        }
                    }
                }

                @Override // com.baidu.tieba.qc8
                public void onPostExecute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        clearRemoveCache();
                        checkListMemoryChanged(this.val$customGroupType);
                        qc8 qc8Var2 = this.val$iProcess;
                        if (qc8Var2 != null) {
                            qc8Var2.onPostExecute();
                        }
                    }
                }

                @Override // com.baidu.tieba.qc8
                public void onPreExecute() {
                    qc8 qc8Var2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (qc8Var2 = this.val$iProcess) != null) {
                        qc8Var2.onPreExecute();
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
        List<ImMessageCenterShowItemData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.mList) != null) {
            list.clear();
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
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Collections.sort(this.mList, new Comparator<ImMessageCenterShowItemData>(this) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.9
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
            for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.mList) {
                arrayList.add(imMessageCenterShowItemData.getFriendId());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void insertOrUpdate(ImMessageCenterPojo imMessageCenterPojo, pc8 pc8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, imMessageCenterPojo, pc8Var) != null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid()) || !isAccept(imMessageCenterPojo)) {
            return;
        }
        ImMessageCenterShowItemData removeItem = removeItem(imMessageCenterPojo);
        if (!isToShow(imMessageCenterPojo)) {
            if (pc8Var != null) {
                pc8Var.onComplete();
                return;
            }
            return;
        }
        ks5.c(new gs5<List<ImMessageCenterShowItemData>>(this, imMessageCenterPojo, removeItem) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImBaseMessageCenterModel this$0;
            public final /* synthetic */ ImMessageCenterShowItemData val$data;
            public final /* synthetic */ ImMessageCenterPojo val$pojo;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, imMessageCenterPojo, removeItem};
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
                this.val$pojo = imMessageCenterPojo;
                this.val$data = removeItem;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.gs5
            public List<ImMessageCenterShowItemData> doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    ArrayList arrayList = new ArrayList();
                    this.this$0.processMsg(this.val$pojo, this.val$data, new AsyncCallback(this, arrayList) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ List val$resultList;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$resultList = arrayList;
                        }

                        @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel.AsyncCallback
                        public void doInsert(@Nullable ImMessageCenterShowItemData imMessageCenterShowItemData) {
                            Interceptable interceptable3 = $ic;
                            if ((interceptable3 == null || interceptable3.invokeL(1048576, this, imMessageCenterShowItemData) == null) && imMessageCenterShowItemData != null) {
                                this.val$resultList.add(imMessageCenterShowItemData);
                            }
                        }
                    });
                    return arrayList;
                }
                return (List) invokeV.objValue;
            }
        }, new lr5<List<ImMessageCenterShowItemData>>(this, pc8Var) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImBaseMessageCenterModel this$0;
            public final /* synthetic */ pc8 val$mCompleteProcess;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, pc8Var};
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
                this.val$mCompleteProcess = pc8Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.lr5
            public void onReturnDataInUI(List<ImMessageCenterShowItemData> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                    this.this$0.insertShowDataList(list);
                    if (list != null && list.size() != 0) {
                        this.this$0.onComplete(this.val$mCompleteProcess);
                    }
                }
            }
        });
    }

    public void setData(List<ImMessageCenterPojo> list, pc8 pc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, list, pc8Var) == null) {
            List<ImMessageCenterShowItemData> list2 = this.mList;
            if (list2 != null) {
                list2.clear();
            }
            if (ListUtils.isEmpty(list)) {
                if (pc8Var != null) {
                    pc8Var.onComplete();
                    return;
                }
                return;
            }
            ks5.c(new gs5<List<ImMessageCenterShowItemData>>(this, Collections.synchronizedList(new ArrayList(list))) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;
                public final /* synthetic */ List val$safeList;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
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
                    this.val$safeList = r7;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.gs5
                public List<ImMessageCenterShowItemData> doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (ImMessageCenterPojo imMessageCenterPojo : this.val$safeList) {
                            if (imMessageCenterPojo != null && this.this$0.isToShow(imMessageCenterPojo)) {
                                this.this$0.processMsg(imMessageCenterPojo, null, new AsyncCallback(this, arrayList) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.5.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass5 this$1;
                                    public final /* synthetic */ List val$resultList;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, arrayList};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$resultList = arrayList;
                                    }

                                    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel.AsyncCallback
                                    public void doInsert(@Nullable ImMessageCenterShowItemData imMessageCenterShowItemData) {
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeL(1048576, this, imMessageCenterShowItemData) == null) && imMessageCenterShowItemData != null) {
                                            this.val$resultList.add(imMessageCenterShowItemData);
                                        }
                                    }
                                });
                            }
                        }
                        return arrayList;
                    }
                    return (List) invokeV.objValue;
                }
            }, new lr5<List<ImMessageCenterShowItemData>>(this, pc8Var) { // from class: com.baidu.tieba.im.model.ImBaseMessageCenterModel.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImBaseMessageCenterModel this$0;
                public final /* synthetic */ pc8 val$iCompleteProcess;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pc8Var};
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
                    this.val$iCompleteProcess = pc8Var;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.lr5
                public void onReturnDataInUI(List<ImMessageCenterShowItemData> list3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list3) == null) {
                        this.this$0.insertShowDataList(list3);
                        this.this$0.onComplete(this.val$iCompleteProcess);
                    }
                }
            });
        }
    }
}
