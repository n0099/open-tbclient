package com.baidu.tieba.ala.alasquare.special_forum.message;

import c.a.t0.s.r.e2;
import c.a.u0.a0.f.g.c.b;
import c.a.u0.a0.f.g.c.c;
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
/* loaded from: classes12.dex */
public class AlaSpecialRecommendResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<e2> livesList;
    public c mSpecialActivityListData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSpecialRecommendResponse() {
        super(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
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
        this.livesList = new ArrayList();
        this.mSpecialActivityListData = new c();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (jSONObject != null) {
                this.hasMore = jSONObject.optInt("has_more") == 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("live_info");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("lives");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                            if (optJSONObject2 != null) {
                                e2 e2Var = new e2();
                                e2Var.c3(optJSONObject2);
                                this.livesList.add(e2Var);
                            }
                        }
                    } else {
                        this.hasMore = false;
                    }
                } else {
                    this.hasMore = false;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_detail");
                c cVar = this.mSpecialActivityListData;
                if (cVar != null && cVar.f15023e == null) {
                    cVar.f15023e = new ArrayList();
                }
                if (optJSONArray2 != null) {
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                        if (optJSONObject3 != null) {
                            b bVar = new b();
                            bVar.g(optJSONObject3);
                            this.mSpecialActivityListData.f15023e.add(bVar);
                        }
                    }
                }
            }
        }
    }
}
