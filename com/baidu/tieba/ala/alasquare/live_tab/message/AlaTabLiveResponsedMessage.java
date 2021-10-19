package com.baidu.tieba.ala.alasquare.live_tab.message;

import c.a.e.e.p.k;
import c.a.r0.w.f.c.e.a;
import c.a.r0.w.f.c.e.d;
import c.a.r0.w.f.c.e.g;
import c.a.r0.w.f.c.e.h;
import c.a.r0.w.f.c.e.j;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaTabLiveResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a hotLiveInfo;
    public d officialRecommendLiveInfo;
    public g stageLiveInfo;
    public h superEntranceInfo;
    public j tabAllLiveInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaTabLiveResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
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
                h hVar = new h();
                this.superEntranceInfo = hVar;
                hVar.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("stage_live");
            if (optJSONObject3 != null) {
                g gVar = new g();
                this.stageLiveInfo = gVar;
                gVar.b(optJSONObject3, string);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("hot_live");
            if (optJSONObject4 != null) {
                a aVar = new a();
                this.hotLiveInfo = aVar;
                aVar.a(optJSONObject4, string);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("official_recommend");
            if (optJSONObject5 != null) {
                d dVar = new d();
                this.officialRecommendLiveInfo = dVar;
                dVar.a(optJSONObject5, string);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("all_lives");
            if (optJSONObject6 != null) {
                j jVar = new j();
                this.tabAllLiveInfo = jVar;
                jVar.a(optJSONObject6, string);
            }
            String optString = optJSONObject.optString("show_switch", null);
            if (k.isEmpty(optString)) {
                return;
            }
            TbSingleton.getInstance().setYyCloudSwitch(optString);
        }
    }
}
