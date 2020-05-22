package com.baidu.tieba.ala.alasquare.live_tab.my_concern.data;

import com.baidu.adp.BdUniqueId;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdX = BdUniqueId.gen();
    public String fdY;
    public String portrait;
    public String remark;
    public long start_time;
    public String user_id;
    public String user_name;
    public String user_nickname;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return fdX;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.user_name = jSONObject.optString("user_name");
            this.user_nickname = jSONObject.optString("user_nickname");
            this.portrait = jSONObject.optString("portrait");
            this.fdY = jSONObject.optString("user_brief");
            this.start_time = jSONObject.optLong("start_time");
            this.remark = jSONObject.optString("remark");
        }
    }
}
