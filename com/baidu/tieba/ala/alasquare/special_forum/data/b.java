package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long end_time;
    public int id;
    public String name;
    public String pic;
    public long start_time;
    public String url;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.url = jSONObject.optString("url");
            this.pic = jSONObject.optString("pic");
            this.start_time = jSONObject.optLong("start_time", 0L);
            this.end_time = jSONObject.optLong("end_time", 0L);
            this.name = jSONObject.optString("name");
            this.id = jSONObject.optInt("id");
        }
    }
}
