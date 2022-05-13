package com.baidu.tieba.ala.alasquare.special_forum.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uq5;
import com.repackage.vq5;
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
    public vq5 mSpecialActivityListData;

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
        this.mSpecialActivityListData = new vq5();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject != null) {
                this.hasMore = jSONObject.optInt("has_more") == 1;
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
                vq5 vq5Var = this.mSpecialActivityListData;
                if (vq5Var != null && vq5Var.a == null) {
                    vq5Var.a = new ArrayList();
                }
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject3 != null) {
                            uq5 uq5Var = new uq5();
                            uq5Var.e(optJSONObject3);
                            this.mSpecialActivityListData.a.add(uq5Var);
                        }
                    }
                }
            }
        }
    }
}
