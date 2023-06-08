package com.baidu.tieba.consumptionRecords;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.er6;
import com.baidu.tieba.fr6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetUserOrderHttpResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public ArrayList<er6> orderList;
    public fr6 recommendData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUserOrderHttpResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasMore = false;
        this.orderList = new ArrayList<>();
    }

    private void parseOrderListData(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, jSONArray) != null) || jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            er6 er6Var = new er6();
            er6Var.n(optJSONObject);
            this.orderList.add(er6Var);
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                if (jSONObject.optInt("hasmore") == 0) {
                    z = false;
                } else {
                    z = true;
                }
                this.hasMore = z;
                JSONArray optJSONArray = jSONObject.optJSONArray("order_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    parseOrderListData(optJSONArray);
                }
            }
        }
    }

    public boolean getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.hasMore;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<er6> getOrderList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.orderList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public fr6 getRecommendInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.recommendData;
        }
        return (fr6) invokeV.objValue;
    }
}
