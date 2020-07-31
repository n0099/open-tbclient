package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String gID;
    private int gIF;
    private int gIG;
    private int gIH;
    private int gII;
    private String gIJ;
    private String gIK;
    private String gIL;
    private int height;
    private String mark_name;
    private String mark_pic;
    public String nobilityName;
    public int nobilityType;
    public long price;
    private String start_time;
    public String time;
    private int type;
    private int weight;
    private int width;
    public int propId = -1;
    private List<d> gIM = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.gIG = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.gII = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.gIH = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.gIK = jSONObject.optString("next_level_diff");
        this.gIJ = jSONObject.optString("mark_dir_level");
        this.gIL = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.gIM.add(dVar);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("props_info");
        if (optJSONObject != null) {
            this.propId = com.baidu.adp.lib.f.b.toInt(optJSONObject.optString("props_id"), -1);
            this.price = com.baidu.adp.lib.f.b.toLong(optJSONObject.optString("price"), 0L);
            this.time = optJSONObject.optString("buy_cycle");
            this.buy_staus = optJSONObject.optInt("buy_staus");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("nobility_info");
        if (optJSONObject2 != null) {
            this.nobilityType = optJSONObject2.optInt("nobility_type");
            this.nobilityName = optJSONObject2.optString("nobility_type_name");
        }
    }

    public List<d> bOL() {
        if (this.gIM == null) {
            this.gIM = new ArrayList();
        }
        return this.gIM;
    }

    public boolean bOM() {
        return this.gIF == 1;
    }

    public void sE(int i) {
        this.gIF = i;
    }

    public String bOK() {
        return this.gID;
    }

    public void Ek(String str) {
        this.gID = str;
    }

    public int bON() {
        return this.gIG;
    }

    public String bOO() {
        return this.mark_name;
    }

    public String bOP() {
        return this.mark_pic;
    }

    public int bOQ() {
        return this.gII;
    }

    public void sF(int i) {
        this.gII = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bOR() {
        return this.gIK;
    }

    public int bOS() {
        return this.gIH;
    }

    public String bOT() {
        return this.gIL;
    }

    public boolean bOU() {
        return this.type == 10;
    }

    public boolean bOV() {
        return this.type == 9;
    }
}
