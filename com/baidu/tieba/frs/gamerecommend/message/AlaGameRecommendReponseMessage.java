package com.baidu.tieba.frs.gamerecommend.message;

import c.a.q0.s.q.d2;
import c.a.r0.x0.u1.c.a;
import c.a.r0.x0.u1.c.b;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGameRecommendReponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaGameRecommendReponseMessage() {
        super(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
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
            if (jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            a aVar = new a();
            this.mData = aVar;
            aVar.f28046a = jSONObject.optInt("recom_has_more") == 1;
            this.mData.f28047b = jSONObject.optInt("card_max_floor");
            JSONArray optJSONArray = jSONObject.optJSONArray("recom_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        d2 d2Var = new d2();
                        d2Var.X2(optJSONObject);
                        this.mData.f28048c.add(d2Var);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("score_card");
            if (optJSONObject2 != null) {
                this.mData.f28049d = (ScoreCardInfo) OrmObject.objectWithJson(optJSONObject2, ScoreCardInfo.class);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(ThreadAchievementShareDialogView.HOT_LIST_VIEW_TYPE);
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                    if (optJSONObject3 != null) {
                        this.mData.f28050e.add((FeatureCardHot) OrmObject.objectWithJson(optJSONObject3, FeatureCardHot.class));
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("topic");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                    JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i5);
                    if (optJSONObject4 != null) {
                        this.mData.f28051f.add((FeatureCardTopic) OrmObject.objectWithJson(optJSONObject4, FeatureCardTopic.class));
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("toutiao");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                for (int i6 = 0; i6 < optJSONArray4.length(); i6++) {
                    JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i6);
                    if (optJSONObject5 != null) {
                        b bVar = new b();
                        bVar.f28057b = optJSONObject5.optString("title");
                        optJSONObject5.optInt("type");
                        bVar.f28058c = Integer.valueOf(optJSONObject5.optInt("floor"));
                        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("sub_nodes");
                        if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                            for (int i7 = 0; i7 < optJSONArray5.length(); i7++) {
                                JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i7);
                                if (optJSONObject6 != null) {
                                    d2 d2Var2 = new d2();
                                    d2Var2.X2(optJSONObject6);
                                    bVar.f28056a.add(d2Var2);
                                }
                            }
                        }
                        this.mData.f28052g.add(bVar);
                    }
                }
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("competition");
            if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                for (int i8 = 0; i8 < optJSONArray6.length(); i8++) {
                    JSONObject optJSONObject7 = optJSONArray6.optJSONObject(i8);
                    if (optJSONObject7 != null) {
                        this.mData.f28053h.add((FeatureCardCompetition) OrmObject.objectWithJson(optJSONObject7, FeatureCardCompetition.class));
                    }
                }
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("god");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                for (int i9 = 0; i9 < optJSONArray7.length(); i9++) {
                    JSONObject optJSONObject8 = optJSONArray7.optJSONObject(i9);
                    if (optJSONObject8 != null) {
                        this.mData.f28054i.add((FeatureCardGod) OrmObject.objectWithJson(optJSONObject8, FeatureCardGod.class));
                    }
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray("game");
            if (optJSONArray8 == null || optJSONArray8.length() <= 0) {
                return;
            }
            for (int i10 = 0; i10 < optJSONArray8.length(); i10++) {
                JSONObject optJSONObject9 = optJSONArray8.optJSONObject(i10);
                if (optJSONObject9 != null) {
                    this.mData.f28055j.add((FeatureCardGame) OrmObject.objectWithJson(optJSONObject9, FeatureCardGame.class));
                }
            }
        }
    }

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (a) invokeV.objValue;
    }
}
