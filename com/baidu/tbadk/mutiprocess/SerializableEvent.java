package com.baidu.tbadk.mutiprocess;

import android.os.Process;
import c.a.s0.k0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes11.dex */
public abstract class SerializableEvent implements Serializable, a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 286737332558666966L;
    public transient /* synthetic */ FieldHolder $fh;
    public int mPid;
    public int mTag;
    public int mType;

    public SerializableEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTag = 0;
        this.mType = 0;
        this.mPid = Process.myPid();
    }

    @Override // c.a.s0.k0.a
    public int getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPid : invokeV.intValue;
    }

    @Override // c.a.s0.k0.a
    public int getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTag : invokeV.intValue;
    }

    @Override // c.a.s0.k0.a
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mType : invokeV.intValue;
    }

    @Override // c.a.s0.k0.a
    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.mTag = bdUniqueId.getId();
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mType = i2;
        }
    }

    public SerializableEvent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTag = 0;
        this.mType = 0;
        this.mPid = Process.myPid();
        this.mType = i2;
    }
}
