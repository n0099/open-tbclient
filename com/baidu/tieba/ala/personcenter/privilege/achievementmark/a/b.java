package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String gDg;
    private int gDi;
    private int gDj;
    private int gDk;
    private int gDl;
    private String gDm;
    private String gDn;
    private String gDo;
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
    private List<d> gDp = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.gDj = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.gDl = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.gDk = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.gDn = jSONObject.optString("next_level_diff");
        this.gDm = jSONObject.optString("mark_dir_level");
        this.gDo = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.gDp.add(dVar);
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

    public List<d> bLD() {
        if (this.gDp == null) {
            this.gDp = new ArrayList();
        }
        return this.gDp;
    }

    public boolean bLE() {
        return this.gDi == 1;
    }

    public void sm(int i) {
        this.gDi = i;
    }

    public String bLC() {
        return this.gDg;
    }

    public void Dz(String str) {
        this.gDg = str;
    }

    public int bLF() {
        return this.gDj;
    }

    public String bLG() {
        return this.mark_name;
    }

    public String bLH() {
        return this.mark_pic;
    }

    public int bLI() {
        return this.gDl;
    }

    public void sn(int i) {
        this.gDl = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bLJ() {
        return this.gDn;
    }

    public int bLK() {
        return this.gDk;
    }

    public String bLL() {
        return this.gDo;
    }

    public boolean bLM() {
        return this.type == 10;
    }

    public boolean bLN() {
        return this.type == 9;
    }
}
