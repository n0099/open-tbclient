package com.baidu.tieba.im.model;

import c.a.e.a.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.RequestCheckUserMaskMessage;
import com.baidu.tbadk.core.message.RequestGetMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BlackListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ISMASK_FALSE_FROM_SERVER = 0;
    public static final int ISMASK_TRUE_FROM_SERVER = 1;
    public static final int MASK_TYPE = 10;
    public static final int MASK_TYPE_NOT_FROM_SERVER = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public RequestCheckUserMaskMessage mCheckMessage;
    public RequestGetMaskInfoMessage mGetMessage;
    public int mMaskType;
    public RequestUpdateMaskInfoMessage mUpdateMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.mMaskType = 2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void addToBlackList(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            this.mUpdateMessage = requestUpdateMaskInfoMessage;
            requestUpdateMaskInfoMessage.setIsMask(1);
            this.mUpdateMessage.setMaskType(10);
            this.mUpdateMessage.setList(String.valueOf(j2));
            super.sendMessage(this.mUpdateMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            super.cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void checkUserMask(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            RequestCheckUserMaskMessage requestCheckUserMaskMessage = new RequestCheckUserMaskMessage();
            this.mCheckMessage = requestCheckUserMaskMessage;
            requestCheckUserMaskMessage.setUserId(j2);
            super.sendMessage(this.mCheckMessage);
        }
    }

    public int getMaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mMaskType : invokeV.intValue;
    }

    public void loadBlackList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RequestGetMaskInfoMessage requestGetMaskInfoMessage = new RequestGetMaskInfoMessage();
            this.mGetMessage = requestGetMaskInfoMessage;
            requestGetMaskInfoMessage.setMaskType(10);
            super.sendMessage(this.mGetMessage);
        }
    }

    public void removeFromBlackList(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            this.mUpdateMessage = requestUpdateMaskInfoMessage;
            requestUpdateMaskInfoMessage.setIsMask(0);
            this.mUpdateMessage.setMaskType(10);
            this.mUpdateMessage.setList(String.valueOf(j2));
            super.sendMessage(this.mUpdateMessage);
        }
    }

    public void setMaskType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mMaskType = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMaskType = 2;
        setUniqueId(bdUniqueId);
    }
}
