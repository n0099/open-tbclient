package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends BaseData {
    private ArrayList<g> eWD;
    private long eWd;
    private String fsX;
    private long fsY;
    private long fsZ = 5000;
    private long fta = 15;
    private long ftb;
    private n ftc;

    public long btL() {
        return this.fsZ;
    }

    public long btM() {
        return this.fta;
    }

    public long btN() {
        return this.fsY;
    }

    public String HV() {
        return this.fsX;
    }

    public long btO() {
        return this.ftb;
    }

    public ArrayList<g> getList() {
        return this.eWD;
    }

    public n btP() {
        return this.ftc;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.eWd = optJSONObject.optLong("current_time", 0L);
                this.fsX = optJSONObject.optString("current_hour", "");
                this.fsY = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.fsZ = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.fta = optJSONObject.optLong("verify_notice_interval", 15L);
                this.ftb = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.eWD = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.eWD.add(gVar);
                }
            }
            this.ftc = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.ftc.parserJson(optJSONObject4);
                if (this.eWD != null && this.eWD.size() > 0) {
                    this.ftc.fti = JavaTypesHelper.toLong(this.eWD.get(this.eWD.size() - 1).point, 0L);
                }
            }
        }
    }
}
