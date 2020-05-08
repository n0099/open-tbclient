package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends BaseData {
    private ArrayList<g> eJV;
    private long eJv;
    private String ffh;
    private long ffi;
    private long ffj = 5000;
    private long ffk = 15;
    private long ffl;
    private n ffm;

    public long bnR() {
        return this.ffj;
    }

    public long bnS() {
        return this.ffk;
    }

    public long bnT() {
        return this.ffi;
    }

    public String Gc() {
        return this.ffh;
    }

    public long bnU() {
        return this.ffl;
    }

    public ArrayList<g> getList() {
        return this.eJV;
    }

    public n bnV() {
        return this.ffm;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.eJv = optJSONObject.optLong("current_time", 0L);
                this.ffh = optJSONObject.optString("current_hour", "");
                this.ffi = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.ffj = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.ffk = optJSONObject.optLong("verify_notice_interval", 15L);
                this.ffl = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.eJV = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.eJV.add(gVar);
                }
            }
            this.ffm = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.ffm.parserJson(optJSONObject4);
                if (this.eJV != null && this.eJV.size() > 0) {
                    this.ffm.ffs = JavaTypesHelper.toLong(this.eJV.get(this.eJV.size() - 1).point, 0L);
                }
            }
        }
    }
}
