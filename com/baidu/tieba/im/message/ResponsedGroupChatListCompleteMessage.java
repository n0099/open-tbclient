package com.baidu.tieba.im.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ResponsedGroupChatListCompleteMessage extends CustomResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_RESPONSE_DELETE = 3;
    public static final int TYPE_RESPONSE_ITEM_UPDATE = 2;
    public static final int TYPE_RESPONSE_LIST_UPDATE = 1;
    public static final int TYPE_RESPONSE_LOOP = 4;
    public static final int TYPE_RESPONSE_REFRESH = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public String gid;
    public boolean hasUnreadMsg;
    public ImMessageCenterPojo itemInfo;
    public List<ImMessageCenterPojo> listInfo;
    public int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsedGroupChatListCompleteMessage() {
        super(2921767);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasUnreadMsg = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsedGroupChatListCompleteMessage(int i) {
        super(2921767);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hasUnreadMsg = false;
        this.type = i;
    }

    public String getGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.gid;
        }
        return (String) invokeV.objValue;
    }

    public ImMessageCenterPojo getItemInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.itemInfo;
        }
        return (ImMessageCenterPojo) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> getListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.listInfo;
        }
        return (List) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public boolean isHasUnreadMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.hasUnreadMsg;
        }
        return invokeV.booleanValue;
    }

    public void setGid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.gid = str;
        }
    }

    public void setHasUnreadMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.hasUnreadMsg = z;
        }
    }

    public void setItemInfo(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, imMessageCenterPojo) == null) {
            this.itemInfo = imMessageCenterPojo;
        }
    }

    public void setListInfo(List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.listInfo = list;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.type = i;
        }
    }
}
