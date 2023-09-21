package com.baidu.tieba.frs.gamerecommend.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
import com.baidu.tieba.tp7;
import com.baidu.tieba.up7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AlaGameRecommendReponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tp7 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaGameRecommendReponseMessage() {
        super(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
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

    public tp7 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mData;
        }
        return (tp7) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject != null && jSONObject.length() > 0) {
                tp7 tp7Var = new tp7();
                this.mData = tp7Var;
                boolean z = true;
                if (jSONObject.optInt("recom_has_more") != 1) {
                    z = false;
                }
                tp7Var.a = z;
                this.mData.b = jSONObject.optInt("card_max_floor");
                JSONArray optJSONArray = jSONObject.optJSONArray("recom_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            ThreadData threadData = new ThreadData();
                            threadData.parserJson(optJSONObject);
                            this.mData.c.add(threadData);
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("score_card");
                if (optJSONObject2 != null) {
                    this.mData.d = (ScoreCardInfo) OrmObject.objectWithJson(optJSONObject2, ScoreCardInfo.class);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("hot");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject3 != null) {
                            this.mData.e.add((FeatureCardHot) OrmObject.objectWithJson(optJSONObject3, FeatureCardHot.class));
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("topic");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i4);
                        if (optJSONObject4 != null) {
                            this.mData.f.add((FeatureCardTopic) OrmObject.objectWithJson(optJSONObject4, FeatureCardTopic.class));
                        }
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("toutiao");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i5);
                        if (optJSONObject5 != null) {
                            up7 up7Var = new up7();
                            up7Var.b = optJSONObject5.optString("title");
                            optJSONObject5.optInt("type");
                            up7Var.c = Integer.valueOf(optJSONObject5.optInt("floor"));
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("sub_nodes");
                            if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                                for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                                    JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i6);
                                    if (optJSONObject6 != null) {
                                        ThreadData threadData2 = new ThreadData();
                                        threadData2.parserJson(optJSONObject6);
                                        up7Var.a.add(threadData2);
                                    }
                                }
                            }
                            this.mData.g.add(up7Var);
                        }
                    }
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("competition");
                if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                    for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                        JSONObject optJSONObject7 = optJSONArray6.optJSONObject(i7);
                        if (optJSONObject7 != null) {
                            this.mData.h.add((FeatureCardCompetition) OrmObject.objectWithJson(optJSONObject7, FeatureCardCompetition.class));
                        }
                    }
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("god");
                if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                    for (int i8 = 0; i8 < optJSONArray7.length(); i8++) {
                        JSONObject optJSONObject8 = optJSONArray7.optJSONObject(i8);
                        if (optJSONObject8 != null) {
                            this.mData.i.add((FeatureCardGod) OrmObject.objectWithJson(optJSONObject8, FeatureCardGod.class));
                        }
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("game");
                if (optJSONArray8 != null && optJSONArray8.length() > 0) {
                    for (int i9 = 0; i9 < optJSONArray8.length(); i9++) {
                        JSONObject optJSONObject9 = optJSONArray8.optJSONObject(i9);
                        if (optJSONObject9 != null) {
                            this.mData.j.add((FeatureCardGame) OrmObject.objectWithJson(optJSONObject9, FeatureCardGame.class));
                        }
                    }
                }
            }
        }
    }
}
