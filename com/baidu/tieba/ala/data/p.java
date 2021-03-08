package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class p extends BaseData {
    private String gUT;
    private long gUU;
    private long gUV = 5000;
    private long gUW = 15;
    private long gUX;
    private r gUY;
    private ArrayList<h> gtn;
    private long mCurrentTime;

    public long bUJ() {
        return this.gUV;
    }

    public long bUK() {
        return this.gUW;
    }

    public long bUL() {
        return this.gUU;
    }

    public String Vq() {
        return this.gUT;
    }

    public long bUM() {
        return this.gUX;
    }

    public ArrayList<h> getList() {
        return this.gtn;
    }

    public r bUN() {
        return this.gUY;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.mCurrentTime = optJSONObject.optLong("current_time", 0L);
                this.gUT = optJSONObject.optString("current_hour", "");
                this.gUU = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gUV = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gUW = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gUX = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.gtn = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.gtn.add(hVar);
                }
            }
            this.gUY = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gUY.parserJson(optJSONObject4);
                if (this.gtn != null && this.gtn.size() > 0) {
                    this.gUY.aId = JavaTypesHelper.toLong(this.gtn.get(this.gtn.size() - 1).gUB, 0L);
                }
            }
        }
    }
}
