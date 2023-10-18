package com.baidu.tieba.frs.accelerator;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class NodeInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String nodeName;
    public String nodeTag;

    public NodeInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nodeName = str;
        this.nodeTag = str2;
    }

    public static NodeInfo parseJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("node_name");
            String optString2 = jSONObject.optString("node_tag");
            if (StringUtils.isNull(optString) || StringUtils.isNull(optString2)) {
                return null;
            }
            return new NodeInfo(optString, optString2);
        }
        return (NodeInfo) invokeL.objValue;
    }

    public boolean compare(NodeInfo nodeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nodeInfo)) == null) {
            if (nodeInfo == null || !this.nodeName.equals(nodeInfo.nodeName) || !this.nodeTag.equals(nodeInfo.nodeTag)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String getNodeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.nodeName;
        }
        return (String) invokeV.objValue;
    }

    public String getNodeTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.nodeTag;
        }
        return (String) invokeV.objValue;
    }
}
