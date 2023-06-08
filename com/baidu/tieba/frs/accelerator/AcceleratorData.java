package com.baidu.tieba.frs.accelerator;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tieba.jq7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AcceleratorData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final int AVAILABLE_NODES_NUM_DEFAULT_TAG = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int availableNodesNum;
    public List<TornadoNodeInfo> availableTornadoNodeInfoList;
    public ItemData itemData;
    public TokenInfo tokenInfo;
    public List<TornadoNodeInfo> tornadoNodeInfoList;

    public AcceleratorData(TokenInfo tokenInfo, ItemData itemData, List<TornadoNodeInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tokenInfo, itemData, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.availableNodesNum = 0;
        this.tokenInfo = tokenInfo;
        this.itemData = itemData;
        this.tornadoNodeInfoList = list;
    }

    public static AcceleratorData parseJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        TokenInfo tokenInfo;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("token_info");
            ArrayList arrayList = null;
            if (optJSONObject != null) {
                tokenInfo = TokenInfo.parseJson(optJSONObject);
            } else {
                tokenInfo = null;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(WriteActivityConfig.ITEM_INFO);
            if (optJSONObject2 != null) {
                itemData = new ItemData();
                itemData.parseJson(optJSONObject2.toString(), false);
            } else {
                itemData = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("tornado_node_info");
            if (optJSONArray != null) {
                arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(TornadoNodeInfo.parseJson(optJSONArray.optJSONObject(i)));
                }
            }
            return new AcceleratorData(tokenInfo, itemData, arrayList);
        }
        return (AcceleratorData) invokeL.objValue;
    }

    public int getAvailableNodesNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.availableNodesNum;
        }
        return invokeV.intValue;
    }

    public ItemData getItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.itemData;
        }
        return (ItemData) invokeV.objValue;
    }

    public TokenInfo getTokenInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.tokenInfo;
        }
        return (TokenInfo) invokeV.objValue;
    }

    public List<TornadoNodeInfo> getAvailableTornadoNodeInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<TornadoNodeInfo> list = this.tornadoNodeInfoList;
            if (list != null && !list.isEmpty()) {
                if (this.availableNodesNum != 0) {
                    return this.availableTornadoNodeInfoList;
                }
                this.availableTornadoNodeInfoList = new ArrayList();
                for (int i = 0; i < this.tornadoNodeInfoList.size(); i++) {
                    if (jq7.a(this.tornadoNodeInfoList.get(i).getPackageName()) != null) {
                        this.availableTornadoNodeInfoList.add(this.tornadoNodeInfoList.get(i));
                        this.availableNodesNum += this.tornadoNodeInfoList.get(i).getNodeInfoList().size();
                    }
                }
                if (this.availableTornadoNodeInfoList.isEmpty()) {
                    this.availableTornadoNodeInfoList.add(this.tornadoNodeInfoList.get(0));
                    this.availableNodesNum += this.tornadoNodeInfoList.get(0).getNodeInfoList().size();
                }
                return this.availableTornadoNodeInfoList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void setItemData(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, itemData) == null) {
            this.itemData = itemData;
        }
    }
}
