package com.baidu.tieba.frs.accelerator;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class PkgNameAndNodeInfoData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String gameId;
    public NodeInfo nodeInfo;
    public String packageName;

    public PkgNameAndNodeInfoData(String str, NodeInfo nodeInfo, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, nodeInfo, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.packageName = str;
        this.nodeInfo = nodeInfo;
        this.gameId = str2;
    }

    public boolean compare(PkgNameAndNodeInfoData pkgNameAndNodeInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pkgNameAndNodeInfoData)) == null) {
            if (pkgNameAndNodeInfoData == null || !this.packageName.equals(pkgNameAndNodeInfoData.packageName) || !this.nodeInfo.compare(pkgNameAndNodeInfoData.nodeInfo) || !this.gameId.equals(pkgNameAndNodeInfoData.gameId)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String getGameId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.gameId;
        }
        return (String) invokeV.objValue;
    }

    public NodeInfo getNodeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.nodeInfo;
        }
        return (NodeInfo) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.packageName;
        }
        return (String) invokeV.objValue;
    }

    public void setGameId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.gameId = str;
        }
    }

    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.packageName = str;
        }
    }
}
