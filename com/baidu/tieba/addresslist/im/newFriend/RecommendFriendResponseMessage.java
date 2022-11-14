package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.kb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RecommendFriendResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<kb7> mDatas;
    public int mErrCode;
    public String mErrMsg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendFriendResponseMessage(int i) {
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
        this.mErrCode = 0;
        this.mErrMsg = "";
        this.mDatas = null;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0) {
                this.mErrCode = jSONObject.optInt("errno");
                this.mErrMsg = jSONObject.optString("errmsg");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("recommend_list")) != null) {
                    this.mDatas = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        kb7 kb7Var = new kb7();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        kb7Var.h(jSONObject2.optLong("user_id"));
                        kb7Var.j(jSONObject2.optString("user_name"));
                        kb7Var.k(jSONObject2.optString("portrait"));
                        kb7Var.g(jSONObject2.optString("message"));
                        if (jSONObject2.optInt("type") == 0) {
                            kb7Var.l(0);
                        } else {
                            kb7Var.l(1);
                        }
                        kb7Var.i(1);
                        this.mDatas.add(kb7Var);
                    }
                }
            }
        }
    }

    public List<kb7> getDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDatas;
        }
        return (List) invokeV.objValue;
    }

    public String getErrMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mErrMsg;
        }
        return (String) invokeV.objValue;
    }
}
