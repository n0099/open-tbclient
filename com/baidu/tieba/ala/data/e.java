package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends BaseData {
    private f dGA;
    private long dGu;
    private String dGv;
    private long dGw;
    private long dGx = 5000;
    private long dGy = 15;
    private long dGz;
    private ArrayList<c> dun;

    public long aKz() {
        return this.dGx;
    }

    public long aKA() {
        return this.dGy;
    }

    public long aKB() {
        return this.dGw;
    }

    public String wr() {
        return this.dGv;
    }

    public long aKC() {
        return this.dGz;
    }

    public ArrayList<c> getList() {
        return this.dun;
    }

    public f aKD() {
        return this.dGA;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.dGu = optJSONObject.optLong("current_time", 0L);
                this.dGv = optJSONObject.optString("current_hour", "");
                this.dGw = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.dGx = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.dGy = optJSONObject.optLong("verify_notice_interval", 15L);
                this.dGz = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.dun = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    c cVar = new c();
                    cVar.parserJson(optJSONObject3);
                    this.dun.add(cVar);
                }
            }
            this.dGA = new f();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.dGA.parserJson(optJSONObject4);
                if (this.dun != null && this.dun.size() > 0) {
                    this.dGA.dGG = JavaTypesHelper.toLong(this.dun.get(this.dun.size() - 1).Tx, 0L);
                }
            }
        }
    }
}
