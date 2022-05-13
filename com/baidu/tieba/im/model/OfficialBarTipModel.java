package com.baidu.tieba.im.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.s47;
import com.repackage.s77;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
/* loaded from: classes3.dex */
public class OfficialBarTipModel extends ImBaseMessageCenterModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MASK_TYPE = 12;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialBarTipModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean isNeed(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, imMessageCenterPojo)) == null) ? imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && (imMessageCenterPojo.getUserType() == 1 || imMessageCenterPojo.getUserType() == 3) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void deleteSelectedDatas(s47 s47Var) {
        LinkedList<ImMessageCenterShowItemData> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s47Var) == null) || (linkedList = this.mList) == null) {
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
        asyncDeleteMsgList(arrayList, 4, s47Var);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterShowItemData)) == null) {
            return 4;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, imMessageCenterPojo)) == null) ? isNeed(imMessageCenterPojo) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imMessageCenterPojo)) == null) ? isNeed(imMessageCenterPojo) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    public void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, imMessageCenterPojo, imMessageCenterShowItemData) == null) || (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) == null) {
            return;
        }
        buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
        OfficialSettingItemData a = s77.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        if (a != null) {
            buildNormalItem.setGroupSetting(a);
        }
        insertShowData(buildNormalItem, this.mList);
    }

    public void subscribeBar(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, str) == null) {
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
    }

    public void updateEditStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            for (int i = 0; i != this.mList.size(); i++) {
                this.mList.get(i).setSelected(z);
            }
        }
    }
}
