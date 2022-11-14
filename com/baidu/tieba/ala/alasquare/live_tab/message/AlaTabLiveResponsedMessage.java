package com.baidu.tieba.ala.alasquare.live_tab.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.cw5;
import com.baidu.tieba.dw5;
import com.baidu.tieba.ew5;
import com.baidu.tieba.xi;
import com.baidu.tieba.xv5;
import com.baidu.tieba.zv5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaTabLiveResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xv5 hotLiveInfo;
    public zv5 officialRecommendLiveInfo;
    public cw5 stageLiveInfo;
    public dw5 superEntranceInfo;
    public ew5 tabAllLiveInfo;

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
                dw5 dw5Var = new dw5();
                this.superEntranceInfo = dw5Var;
                dw5Var.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("stage_live");
            if (optJSONObject3 != null) {
                cw5 cw5Var = new cw5();
                this.stageLiveInfo = cw5Var;
                cw5Var.a(optJSONObject3, string);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("hot_live");
            if (optJSONObject4 != null) {
                xv5 xv5Var = new xv5();
                this.hotLiveInfo = xv5Var;
                xv5Var.a(optJSONObject4, string);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("official_recommend");
            if (optJSONObject5 != null) {
                zv5 zv5Var = new zv5();
                this.officialRecommendLiveInfo = zv5Var;
                zv5Var.a(optJSONObject5, string);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("all_lives");
            if (optJSONObject6 != null) {
                ew5 ew5Var = new ew5();
                this.tabAllLiveInfo = ew5Var;
                ew5Var.a(optJSONObject6, string);
            }
            String optString = optJSONObject.optString("show_switch", null);
            if (!xi.isEmpty(optString)) {
                TbSingleton.getInstance().setYyCloudSwitch(optString);
            }
        }
    }
}
