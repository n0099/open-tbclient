package com.baidu.tieba.ala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaRecommendLiveData extends AlaLiveInfoData implements IAdapterData {
    public static BdUniqueId ALA_RECOMMEND_LIVE = BdUniqueId.gen();
    public String distance;
    public int type;

    @Override // com.baidu.live.data.AlaLiveInfoData
    public void parserJson(JSONObject jSONObject) {
        super.parserJson(jSONObject);
        if (jSONObject != null) {
            this.distance = jSONObject.optString("distance");
        }
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return ALA_RECOMMEND_LIVE;
    }
}
