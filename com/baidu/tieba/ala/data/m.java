package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m extends BaseData {
    private long eeP;
    private ArrayList<g> efp;
    private String euD;
    private long euE;
    private long euF = 5000;
    private long euG = 15;
    private long euH;
    private n euI;

    public long bbL() {
        return this.euF;
    }

    public long bbM() {
        return this.euG;
    }

    public long bbN() {
        return this.euE;
    }

    public String yp() {
        return this.euD;
    }

    public long bbO() {
        return this.euH;
    }

    public ArrayList<g> getList() {
        return this.efp;
    }

    public n bbP() {
        return this.euI;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.eeP = optJSONObject.optLong("current_time", 0L);
                this.euD = optJSONObject.optString("current_hour", "");
                this.euE = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.euF = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.euG = optJSONObject.optLong("verify_notice_interval", 15L);
                this.euH = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.efp = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.efp.add(gVar);
                }
            }
            this.euI = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.euI.parserJson(optJSONObject4);
                if (this.efp != null && this.efp.size() > 0) {
                    this.euI.euO = JavaTypesHelper.toLong(this.efp.get(this.efp.size() - 1).aao, 0L);
                }
            }
        }
    }
}
