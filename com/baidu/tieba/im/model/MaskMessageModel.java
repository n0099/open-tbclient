package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.RequestGetMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class MaskMessageModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_ONLY_ATTENTION_SEND = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskMessageModel(TbPageContext<?> tbPageContext) {
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
    }

    private RequestGetMaskInfoMessage createMaskInfoMessage(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            RequestGetMaskInfoMessage requestGetMaskInfoMessage = new RequestGetMaskInfoMessage();
            requestGetMaskInfoMessage.setMaskType(i2);
            return requestGetMaskInfoMessage;
        }
        return (RequestGetMaskInfoMessage) invokeI.objValue;
    }

    private RequestUpdateMaskInfoMessage createUpdateMaskMessage(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMask(z);
            requestUpdateMaskInfoMessage.setMaskType(i2);
            requestUpdateMaskInfoMessage.setList("");
            return requestUpdateMaskInfoMessage;
        }
        return (RequestUpdateMaskInfoMessage) invokeCommon.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
        }
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void registerMaskListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, messageListener) == null) {
            MessageManager.getInstance().registerListener(104103, messageListener);
            MessageManager.getInstance().registerListener(104102, messageListener);
        }
    }

    public void saveInstance(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
        }
    }

    public void sendGetMaskInfoMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.sendMessage(createMaskInfoMessage(i2));
        }
    }

    public void sendUpdateMaskMessage(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.sendMessage(createUpdateMaskMessage(i2, z));
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, messageListener) == null) {
            MessageManager.getInstance().unRegisterListener(messageListener);
        }
    }
}
