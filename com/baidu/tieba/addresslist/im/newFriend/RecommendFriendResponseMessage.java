package com.baidu.tieba.addresslist.im.newFriend;

import c.a.r0.r1.g.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class RecommendFriendResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> mDatas;
    public int mErrCode;
    public String mErrMsg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendFriendResponseMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0) {
                this.mErrCode = jSONObject.optInt("errno");
                this.mErrMsg = jSONObject.optString("errmsg");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("recommend_list")) == null) {
                    return;
                }
                this.mDatas = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    a aVar = new a();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    aVar.h(jSONObject2.optLong("user_id"));
                    aVar.j(jSONObject2.optString("user_name"));
                    aVar.k(jSONObject2.optString("portrait"));
                    aVar.g(jSONObject2.optString("message"));
                    if (jSONObject2.optInt("type") == 0) {
                        aVar.l(0);
                    } else {
                        aVar.l(1);
                    }
                    aVar.i(1);
                    this.mDatas.add(aVar);
                }
            }
        }
    }

    public List<a> getDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDatas : (List) invokeV.objValue;
    }

    public int getErrCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mErrCode : invokeV.intValue;
    }

    public String getErrMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mErrMsg : (String) invokeV.objValue;
    }
}
