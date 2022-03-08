package com.baidu.tieba.frs.accelerator;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AcceleratorActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TornadoNodeInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String gameId;
    public List<NodeInfo> nodeInfoList;
    public String packageName;

    public TornadoNodeInfo(String str, List<NodeInfo> list, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.packageName = str;
        this.nodeInfoList = list;
        this.gameId = str2;
    }

    public static TornadoNodeInfo parseJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            ArrayList arrayList = null;
            if (jSONObject == null) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(AcceleratorActivityConfig.NODE_INFO);
            if (optJSONArray != null) {
                arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        arrayList.add(NodeInfo.parseJson(optJSONArray.getJSONObject(i2)));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return new TornadoNodeInfo(jSONObject.optString("package_name"), arrayList, jSONObject.optString("game_id"));
        }
        return (TornadoNodeInfo) invokeL.objValue;
    }

    public String getGameId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.gameId : (String) invokeV.objValue;
    }

    public List<NodeInfo> getNodeInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.nodeInfoList : (List) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.packageName : (String) invokeV.objValue;
    }

    public void setGameId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.gameId = str;
        }
    }

    public void setNodeInfoList(List<NodeInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.nodeInfoList = list;
        }
    }

    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.packageName = str;
        }
    }
}
