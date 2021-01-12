package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class p extends BaseData {
    private String gQm;
    private long gQn;
    private long gQo = 5000;
    private long gQp = 15;
    private long gQq;
    private r gQr;
    private ArrayList<h> goH;
    private long goc;

    public long bTR() {
        return this.gQo;
    }

    public long bTS() {
        return this.gQp;
    }

    public long bTT() {
        return this.gQn;
    }

    public String TG() {
        return this.gQm;
    }

    public long bTU() {
        return this.gQq;
    }

    public ArrayList<h> getList() {
        return this.goH;
    }

    public r bTV() {
        return this.gQr;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.goc = optJSONObject.optLong("current_time", 0L);
                this.gQm = optJSONObject.optString("current_hour", "");
                this.gQn = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gQo = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gQp = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gQq = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.goH = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.goH.add(hVar);
                }
            }
            this.gQr = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gQr.parserJson(optJSONObject4);
                if (this.goH != null && this.goH.size() > 0) {
                    this.gQr.aEQ = JavaTypesHelper.toLong(this.goH.get(this.goH.size() - 1).gPU, 0L);
                }
            }
        }
    }
}
