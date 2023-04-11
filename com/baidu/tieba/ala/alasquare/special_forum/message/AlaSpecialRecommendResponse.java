package com.baidu.tieba.ala.alasquare.special_forum.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.a66;
import com.baidu.tieba.b66;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaSpecialRecommendResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<ThreadData> livesList;
    public b66 mSpecialActivityListData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSpecialRecommendResponse() {
        super(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
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
        this.livesList = new ArrayList();
        this.mSpecialActivityListData = new b66();
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
                JSONObject optJSONObject = jSONObject.optJSONObject("live_info");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("lives");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                ThreadData threadData = new ThreadData();
                                threadData.parserJson(optJSONObject2);
                                this.livesList.add(threadData);
                            }
                        }
                    } else {
                        this.hasMore = false;
                    }
                } else {
                    this.hasMore = false;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_detail");
                b66 b66Var = this.mSpecialActivityListData;
                if (b66Var != null && b66Var.a == null) {
                    b66Var.a = new ArrayList();
                }
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject3 != null) {
                            a66 a66Var = new a66();
                            a66Var.c(optJSONObject3);
                            this.mSpecialActivityListData.a.add(a66Var);
                        }
                    }
                }
            }
        }
    }
}
