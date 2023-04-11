package com.baidu.tieba.ala.alasquare.live_tab.my_concern.data;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.t46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveTabMyConcernResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<t46> followCloseList;
    public int followCloseNum;
    public List<ThreadData> followList;
    public int followStatus;
    public boolean hasMore;
    public int pn;
    public List<ThreadData> recommendList;
    public int totalFollowCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveTabMyConcernResponse() {
        super(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
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
        this.followCloseList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                boolean z = true;
                if (optJSONObject.optInt("has_more") != 1) {
                    z = false;
                }
                this.hasMore = z;
                this.followStatus = optJSONObject.optInt(DI.FOLLOW_STATUS);
                this.followCloseNum = optJSONObject.optInt("follow_close_num");
                this.pn = optJSONObject.optInt("pn");
                this.totalFollowCount = optJSONObject.optInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
                JSONArray optJSONArray = optJSONObject.optJSONArray("follow_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            ThreadData threadData = new ThreadData();
                            threadData.parserJson(optJSONObject2);
                            this.followList.add(threadData);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("follow_close_list");
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject3 != null) {
                            t46 t46Var = new t46();
                            t46Var.c(optJSONObject3);
                            this.followCloseList.add(t46Var);
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("recommend_list");
                if (optJSONArray3 != null) {
                    this.recommendList.clear();
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i4);
                        if (optJSONObject4 != null) {
                            ThreadData threadData2 = new ThreadData();
                            threadData2.parserJson(optJSONObject4);
                            this.recommendList.add(threadData2);
                        }
                    }
                }
            }
        }
    }
}
