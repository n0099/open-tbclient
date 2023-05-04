package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.b76;
import com.baidu.tieba.h76;
import com.baidu.tieba.i76;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SpecialLiveResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h76 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecialLiveResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
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

    public h76 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mData;
        }
        return (h76) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject == null) {
                return;
            }
            this.mData = new h76();
            jSONObject.optInt("concern_live_show");
            boolean z = true;
            JSONObject optJSONObject = jSONObject.optJSONObject("head_live");
            if (optJSONObject != null) {
                b76 b76Var = new b76();
                b76Var.a(optJSONObject);
                this.mData.a = b76Var;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("tab_info");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                    if (jSONObject2 != null) {
                        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
                        specialLiveTabInfo.parse(jSONObject2);
                        arrayList.add(specialLiveTabInfo);
                    }
                }
                this.mData.b = arrayList;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
                alaUserInfoData.parserJson(optJSONObject2);
                this.mData.d = alaUserInfoData;
            }
            h76 h76Var = this.mData;
            if (jSONObject.optInt("is_like") != 1) {
                z = false;
            }
            h76Var.c = z;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user_sign_info");
            if (optJSONObject2 != null) {
                i76 i76Var = new i76();
                i76Var.a(optJSONObject3);
                this.mData.e = i76Var;
            }
        }
    }
}
