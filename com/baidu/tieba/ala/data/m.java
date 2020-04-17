package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends BaseData {
    private ArrayList<g> eJQ;
    private long eJq;
    private String ffc;
    private long ffd;
    private long ffe = 5000;
    private long fff = 15;
    private long ffg;
    private n ffh;

    public long bnT() {
        return this.ffe;
    }

    public long bnU() {
        return this.fff;
    }

    public long bnV() {
        return this.ffd;
    }

    public String Gd() {
        return this.ffc;
    }

    public long bnW() {
        return this.ffg;
    }

    public ArrayList<g> getList() {
        return this.eJQ;
    }

    public n bnX() {
        return this.ffh;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.eJq = optJSONObject.optLong("current_time", 0L);
                this.ffc = optJSONObject.optString("current_hour", "");
                this.ffd = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.ffe = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.fff = optJSONObject.optLong("verify_notice_interval", 15L);
                this.ffg = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.eJQ = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.eJQ.add(gVar);
                }
            }
            this.ffh = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.ffh.parserJson(optJSONObject4);
                if (this.eJQ != null && this.eJQ.size() > 0) {
                    this.ffh.ffn = JavaTypesHelper.toLong(this.eJQ.get(this.eJQ.size() - 1).point, 0L);
                }
            }
        }
    }
}
