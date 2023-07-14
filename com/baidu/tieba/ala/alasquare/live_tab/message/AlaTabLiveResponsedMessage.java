package com.baidu.tieba.ala.alasquare.live_tab.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.kc6;
import com.baidu.tieba.mc6;
import com.baidu.tieba.pc6;
import com.baidu.tieba.qc6;
import com.baidu.tieba.rc6;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AlaTabLiveResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kc6 hotLiveInfo;
    public mc6 officialRecommendLiveInfo;
    public pc6 stageLiveInfo;
    public qc6 superEntranceInfo;
    public rc6 tabAllLiveInfo;

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
                qc6 qc6Var = new qc6();
                this.superEntranceInfo = qc6Var;
                qc6Var.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("stage_live");
            if (optJSONObject3 != null) {
                pc6 pc6Var = new pc6();
                this.stageLiveInfo = pc6Var;
                pc6Var.a(optJSONObject3, string);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("hot_live");
            if (optJSONObject4 != null) {
                kc6 kc6Var = new kc6();
                this.hotLiveInfo = kc6Var;
                kc6Var.a(optJSONObject4, string);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("official_recommend");
            if (optJSONObject5 != null) {
                mc6 mc6Var = new mc6();
                this.officialRecommendLiveInfo = mc6Var;
                mc6Var.a(optJSONObject5, string);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("all_lives");
            if (optJSONObject6 != null) {
                rc6 rc6Var = new rc6();
                this.tabAllLiveInfo = rc6Var;
                rc6Var.a(optJSONObject6, string);
            }
            String optString = optJSONObject.optString("show_switch", null);
            if (!xi.isEmpty(optString)) {
                TbSingleton.getInstance().setYyCloudSwitch(optString);
            }
        }
    }
}
