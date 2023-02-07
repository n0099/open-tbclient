package com.baidu.tieba.ala.alasquare.live_tab.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.b26;
import com.baidu.tieba.dj;
import com.baidu.tieba.e26;
import com.baidu.tieba.f26;
import com.baidu.tieba.g26;
import com.baidu.tieba.z16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaTabLiveResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z16 hotLiveInfo;
    public b26 officialRecommendLiveInfo;
    public e26 stageLiveInfo;
    public f26 superEntranceInfo;
    public g26 tabAllLiveInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaTabLiveResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
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

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject == null) {
                return;
            }
            String string = jSONObject.getString("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("goldspace");
            if (optJSONObject2 != null) {
                f26 f26Var = new f26();
                this.superEntranceInfo = f26Var;
                f26Var.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("stage_live");
            if (optJSONObject3 != null) {
                e26 e26Var = new e26();
                this.stageLiveInfo = e26Var;
                e26Var.a(optJSONObject3, string);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("hot_live");
            if (optJSONObject4 != null) {
                z16 z16Var = new z16();
                this.hotLiveInfo = z16Var;
                z16Var.a(optJSONObject4, string);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("official_recommend");
            if (optJSONObject5 != null) {
                b26 b26Var = new b26();
                this.officialRecommendLiveInfo = b26Var;
                b26Var.a(optJSONObject5, string);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("all_lives");
            if (optJSONObject6 != null) {
                g26 g26Var = new g26();
                this.tabAllLiveInfo = g26Var;
                g26Var.a(optJSONObject6, string);
            }
            String optString = optJSONObject.optString("show_switch", null);
            if (!dj.isEmpty(optString)) {
                TbSingleton.getInstance().setYyCloudSwitch(optString);
            }
        }
    }
}
