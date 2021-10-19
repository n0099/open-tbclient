package com.baidu.tieba.ala.alasquare.live_tab.my_concern.data;

import c.a.q0.s.q.d2;
import c.a.r0.w.f.c.f.b.b;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.searchbox.live.interfaces.DI;
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
public class AlaLiveTabMyConcernResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> followCloseList;
    public int followCloseNum;
    public List<d2> followList;
    public int followStatus;
    public boolean hasMore;
    public int pn;
    public List<d2> recommendList;
    public int totalFollowCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveTabMyConcernResponse() {
        super(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
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
        this.followCloseList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            this.hasMore = optJSONObject.optInt("has_more") == 1;
            this.followStatus = optJSONObject.optInt(DI.FOLLOW_STATUS);
            this.followCloseNum = optJSONObject.optInt("follow_close_num");
            this.pn = optJSONObject.optInt("pn");
            this.totalFollowCount = optJSONObject.optInt("total_follow_num");
            JSONArray optJSONArray = optJSONObject.optJSONArray("follow_list");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        d2 d2Var = new d2();
                        d2Var.X2(optJSONObject2);
                        this.followList.add(d2Var);
                    }
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("follow_close_list");
            if (optJSONArray2 != null) {
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                    if (optJSONObject3 != null) {
                        b bVar = new b();
                        bVar.g(optJSONObject3);
                        this.followCloseList.add(bVar);
                    }
                }
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("recommend_list");
            if (optJSONArray3 != null) {
                this.recommendList.clear();
                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                    JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i5);
                    if (optJSONObject4 != null) {
                        d2 d2Var2 = new d2();
                        d2Var2.X2(optJSONObject4);
                        this.recommendList.add(d2Var2);
                    }
                }
            }
        }
    }
}
