package com.baidu.tieba.ala.alasquare.special_forum.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.rb6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AlaSpecialConcernResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rb6> followList;
    public boolean hasMore;
    public int pn;
    public List<rb6> recommendList;
    public int totalFollowCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSpecialConcernResponse() {
        super(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
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
        this.hasMore = false;
        this.followList = new ArrayList();
        this.recommendList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject != null) {
                boolean z = true;
                if (jSONObject.optInt("has_more") != 1) {
                    z = false;
                }
                this.hasMore = z;
                this.pn = jSONObject.optInt("pn");
                this.totalFollowCount = jSONObject.optInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
                JSONArray optJSONArray = jSONObject.optJSONArray("follow_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i2);
                        JSONObject optJSONObject = jSONObject2.optJSONObject("user");
                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("ala_live_info");
                        if (optJSONObject != null && optJSONObject2 != null) {
                            rb6 rb6Var = new rb6();
                            rb6Var.a(optJSONObject, optJSONObject2);
                            this.followList.add(rb6Var);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("recommend_list");
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.get(i3);
                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("user");
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject("ala_live_info");
                        if (optJSONObject3 != null && optJSONObject4 != null) {
                            rb6 rb6Var2 = new rb6();
                            rb6Var2.a(optJSONObject3, optJSONObject4);
                            this.recommendList.add(rb6Var2);
                        }
                    }
                }
            }
        }
    }
}
