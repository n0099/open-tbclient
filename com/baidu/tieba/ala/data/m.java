package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m extends BaseData {
    private long eeX;
    private ArrayList<g> efx;
    private String evO;
    private long evP;
    private long evQ = 5000;
    private long evR = 15;
    private long evS;
    private n evT;

    public long bcg() {
        return this.evQ;
    }

    public long bch() {
        return this.evR;
    }

    public long bci() {
        return this.evP;
    }

    public String yF() {
        return this.evO;
    }

    public long bcj() {
        return this.evS;
    }

    public ArrayList<g> getList() {
        return this.efx;
    }

    public n bck() {
        return this.evT;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank_conf");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("hour")) != null) {
                this.eeX = optJSONObject.optLong("current_time", 0L);
                this.evO = optJSONObject.optString("current_hour", "");
                this.evP = optJSONObject.optLong("hour_rank_left_time", 0L);
                this.evQ = optJSONObject.optLong("pull_interval", 5L) * 1000;
                this.evR = optJSONObject.optLong("verify_notice_interval", 15L);
                this.evS = optJSONObject.optLong("show_champion_time", 0L);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.efx = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    g gVar = new g();
                    gVar.parserJson(optJSONObject3);
                    this.efx.add(gVar);
                }
            }
            this.evT = new n();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject4 != null) {
                this.evT.parserJson(optJSONObject4);
                if (this.efx != null && this.efx.size() > 0) {
                    this.evT.evZ = JavaTypesHelper.toLong(this.efx.get(this.efx.size() - 1).point, 0L);
                }
            }
        }
    }
}
