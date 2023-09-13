package com.baidu.tbadk.mutiprocess;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.IEvent;
import com.baidu.tieba.eq5;
import com.baidu.tieba.z9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class ResponsedEventListener<T extends IEvent> extends z9 implements eq5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mSelfListener;
    public BdUniqueId mTag;

    public abstract /* synthetic */ boolean onEvent(T t);

    public ResponsedEventListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSelfListener = false;
        this.mTag = null;
    }

    public BdUniqueId getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mTag;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean isSelfListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mSelfListener;
        }
        return invokeV.booleanValue;
    }

    public void setSelfListener(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mSelfListener = z;
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.mTag = bdUniqueId;
        }
    }
}
