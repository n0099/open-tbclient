package com.baidu.tieba.ala.alasquare.live_tab.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mo5;
import com.repackage.ni;
import com.repackage.po5;
import com.repackage.so5;
import com.repackage.to5;
import com.repackage.vo5;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaTabLiveResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mo5 hotLiveInfo;
    public po5 officialRecommendLiveInfo;
    public so5 stageLiveInfo;
    public to5 superEntranceInfo;
    public vo5 tabAllLiveInfo;

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
                to5 to5Var = new to5();
                this.superEntranceInfo = to5Var;
                to5Var.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("stage_live");
            if (optJSONObject3 != null) {
                so5 so5Var = new so5();
                this.stageLiveInfo = so5Var;
                so5Var.b(optJSONObject3, string);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("hot_live");
            if (optJSONObject4 != null) {
                mo5 mo5Var = new mo5();
                this.hotLiveInfo = mo5Var;
                mo5Var.a(optJSONObject4, string);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("official_recommend");
            if (optJSONObject5 != null) {
                po5 po5Var = new po5();
                this.officialRecommendLiveInfo = po5Var;
                po5Var.a(optJSONObject5, string);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("all_lives");
            if (optJSONObject6 != null) {
                vo5 vo5Var = new vo5();
                this.tabAllLiveInfo = vo5Var;
                vo5Var.a(optJSONObject6, string);
            }
            String optString = optJSONObject.optString("show_switch", null);
            if (ni.isEmpty(optString)) {
                return;
            }
            TbSingleton.getInstance().setYyCloudSwitch(optString);
        }
    }
}
