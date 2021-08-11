package com.baidu.tieba.ala.alasquare.special_forum.message;

import c.a.p0.v.d.g.c.d;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaSpecialConcernResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<d> followList;
    public boolean hasMore;
    public int pn;
    public List<d> recommendList;
    public int totalFollowCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSpecialConcernResponse() {
        super(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
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
        this.hasMore = false;
        this.followList = new ArrayList();
        this.recommendList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (jSONObject != null) {
                this.hasMore = jSONObject.optInt("has_more") == 1;
                this.pn = jSONObject.optInt("pn");
                this.totalFollowCount = jSONObject.optInt("total_follow_num");
                JSONArray optJSONArray = jSONObject.optJSONArray("follow_list");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                        JSONObject optJSONObject = jSONObject2.optJSONObject("user");
                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("ala_live_info");
                        if (optJSONObject != null && optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.a(optJSONObject, optJSONObject2);
                            this.followList.add(dVar);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("recommend_list");
                if (optJSONArray2 != null) {
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.get(i4);
                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("user");
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject("ala_live_info");
                        if (optJSONObject3 != null && optJSONObject4 != null) {
                            d dVar2 = new d();
                            dVar2.a(optJSONObject3, optJSONObject4);
                            this.recommendList.add(dVar2);
                        }
                    }
                }
            }
        }
    }
}
