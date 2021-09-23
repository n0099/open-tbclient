package com.baidu.tieba.ala.alasquare.special_forum.message;

import c.a.q0.s.q.d2;
import c.a.r0.v.f.g.c.b;
import c.a.r0.v.f.g.c.c;
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
public class AlaSpecialRecommendResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<d2> livesList;
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
                                d2 d2Var = new d2();
                                d2Var.X2(optJSONObject2);
                                this.livesList.add(d2Var);
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
                if (cVar != null && cVar.f25813e == null) {
                    cVar.f25813e = new ArrayList();
                }
                if (optJSONArray2 != null) {
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                        if (optJSONObject3 != null) {
                            b bVar = new b();
                            bVar.g(optJSONObject3);
                            this.mSpecialActivityListData.f25813e.add(bVar);
                        }
                    }
                }
            }
        }
    }
}
