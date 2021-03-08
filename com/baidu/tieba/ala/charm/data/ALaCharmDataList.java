package com.baidu.tieba.ala.charm.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ALaCharmDataList extends BaseData implements Serializable {
    private static final long serialVersionUID = 2776535828072028776L;
    public boolean hasMore;
    public int pn;
    public long userTotalPrice;
    public String flowerCount = "";
    public ArrayList<ALaCharmData> data = new ArrayList<>();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.flowerCount = jSONObject.optString("flower_count");
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME, 0);
            this.hasMore = jSONObject.optInt("has_more", 0) == 1;
            this.userTotalPrice = jSONObject.optLong("user_total_price");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    ALaCharmData aLaCharmData = new ALaCharmData();
                    aLaCharmData.parserJson(optJSONObject);
                    this.data.add(aLaCharmData);
                }
            }
        }
    }
}
