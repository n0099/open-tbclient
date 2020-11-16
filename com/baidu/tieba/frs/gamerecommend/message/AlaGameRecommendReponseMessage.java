package com.baidu.tieba.frs.gamerecommend.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.a;
import com.baidu.tieba.frs.gamerecommend.data.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class AlaGameRecommendReponseMessage extends JsonHttpResponsedMessage {
    private a mData;

    public AlaGameRecommendReponseMessage() {
        super(1003401);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.length() > 0) {
            this.mData = new a();
            this.mData.hasMore = jSONObject.optInt("recom_has_more") == 1;
            this.mData.iYD = jSONObject.optInt("card_max_floor");
            JSONArray optJSONArray = jSONObject.optJSONArray("recom_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        bx bxVar = new bx();
                        bxVar.parserJson(optJSONObject);
                        this.mData.iYE.add(bxVar);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("score_card");
            if (optJSONObject2 != null) {
                this.mData.iYF = (ScoreCardInfo) OrmObject.objectWithJson(optJSONObject2, ScoreCardInfo.class);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("hot");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject3 != null) {
                        this.mData.iYG.add((FeatureCardHot) OrmObject.objectWithJson(optJSONObject3, FeatureCardHot.class));
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("topic");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i4);
                    if (optJSONObject4 != null) {
                        this.mData.iYH.add((FeatureCardTopic) OrmObject.objectWithJson(optJSONObject4, FeatureCardTopic.class));
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("toutiao");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                    JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i5);
                    if (optJSONObject5 != null) {
                        b bVar = new b();
                        bVar.title = optJSONObject5.optString("title");
                        bVar.type = Integer.valueOf(optJSONObject5.optInt("type"));
                        bVar.floor = Integer.valueOf(optJSONObject5.optInt("floor"));
                        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("sub_nodes");
                        if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                            for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                                JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i6);
                                if (optJSONObject6 != null) {
                                    bx bxVar2 = new bx();
                                    bxVar2.parserJson(optJSONObject6);
                                    bVar.sub_nodes.add(bxVar2);
                                }
                            }
                        }
                        this.mData.iYI.add(bVar);
                    }
                }
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("competition");
            if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                    JSONObject optJSONObject7 = optJSONArray6.optJSONObject(i7);
                    if (optJSONObject7 != null) {
                        this.mData.iYJ.add((FeatureCardCompetition) OrmObject.objectWithJson(optJSONObject7, FeatureCardCompetition.class));
                    }
                }
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("god");
            if (optJSONArray7 != null && optJSONArray7.length() > 0) {
                for (int i8 = 0; i8 < optJSONArray7.length(); i8++) {
                    JSONObject optJSONObject8 = optJSONArray7.optJSONObject(i8);
                    if (optJSONObject8 != null) {
                        this.mData.iYK.add((FeatureCardGod) OrmObject.objectWithJson(optJSONObject8, FeatureCardGod.class));
                    }
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray(ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
            if (optJSONArray8 != null && optJSONArray8.length() > 0) {
                for (int i9 = 0; i9 < optJSONArray8.length(); i9++) {
                    JSONObject optJSONObject9 = optJSONArray8.optJSONObject(i9);
                    if (optJSONObject9 != null) {
                        this.mData.iYL.add((FeatureCardGame) OrmObject.objectWithJson(optJSONObject9, FeatureCardGame.class));
                    }
                }
            }
        }
    }

    public a getData() {
        return this.mData;
    }
}
