package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p extends BaseData {
    private String gTk;
    private long gTl;
    private long gTm = 5000;
    private long gTn = 15;
    private long gTo;
    private r gTp;
    private ArrayList<h> grE;
    private long mCurrentTime;

    public long bUD() {
        return this.gTm;
    }

    public long bUE() {
        return this.gTn;
    }

    public long bUF() {
        return this.gTl;
    }

    public String Vn() {
        return this.gTk;
    }

    public long bUG() {
        return this.gTo;
    }

    public ArrayList<h> getList() {
        return this.grE;
    }

    public r bUH() {
        return this.gTp;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.mCurrentTime = optJSONObject.optLong("current_time", 0L);
                this.gTk = optJSONObject.optString("current_hour", "");
                this.gTl = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.gTm = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.gTn = optJSONObject.optLong("verify_notice_interval", 15L);
                this.gTo = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.grE = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject3);
                    this.grE.add(hVar);
                }
            }
            this.gTp = new r();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.gTp.parserJson(optJSONObject4);
                if (this.grE != null && this.grE.size() > 0) {
                    this.gTp.aGD = JavaTypesHelper.toLong(this.grE.get(this.grE.size() - 1).gSS, 0L);
                }
            }
        }
    }
}
