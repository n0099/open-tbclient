package com.baidu.tieba.forbidden.fans;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ba7;
import com.baidu.tieba.mx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetForbiddenFansResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ba7> fansList;
    public mx4 pageData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetForbiddenFansResponse(int i) {
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
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error != 0 || jSONObject == null) {
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("block_user_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                this.fansList = new ArrayList<>();
                for (int i2 = 0; i2 < length; i2++) {
                    ba7 ba7Var = new ba7();
                    ba7Var.a(optJSONArray.getJSONObject(i2));
                    if (ba7Var.a != 0) {
                        this.fansList.add(ba7Var);
                    }
                }
            }
            mx4 mx4Var = new mx4();
            this.pageData = mx4Var;
            mx4Var.i(jSONObject.optJSONObject("page"));
        }
    }

    public ArrayList<ba7> getFansList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.fansList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public mx4 getPageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.pageData;
        }
        return (mx4) invokeV.objValue;
    }
}
