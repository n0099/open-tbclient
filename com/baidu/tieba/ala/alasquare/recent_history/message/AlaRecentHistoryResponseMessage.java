package com.baidu.tieba.ala.alasquare.recent_history.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.sx5;
import com.baidu.tieba.tx5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaRecentHistoryResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sx5 mHistoryData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaRecentHistoryResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
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
    }

    public sx5 getRecentHistoryData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mHistoryData;
        }
        return (sx5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject == null) {
                return;
            }
            sx5 sx5Var = new sx5();
            this.mHistoryData = sx5Var;
            boolean z = true;
            if (jSONObject.optInt("has_more") != 1) {
                z = false;
            }
            sx5Var.a = z;
            ArrayList arrayList = null;
            JSONArray optJSONArray = jSONObject.optJSONArray("host_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ArrayList arrayList2 = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    tx5 tx5Var = new tx5();
                    tx5Var.a(optJSONArray.optJSONObject(i2));
                    arrayList2.add(tx5Var);
                }
                arrayList = arrayList2;
            }
            this.mHistoryData.b = arrayList;
        }
    }
}
