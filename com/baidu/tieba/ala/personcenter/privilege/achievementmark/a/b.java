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
    private String hFr;
    private int hFt;
    private int hFu;
    private int hFv;
    private int hFw;
    private String hFx;
    private String hFy;
    private String hFz;
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
    private List<d> hFA = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.hFu = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.hFw = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.hFv = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.hFy = jSONObject.optString("next_level_diff");
        this.hFx = jSONObject.optString("mark_dir_level");
        this.hFz = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.hFA.add(dVar);
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

    public List<d> cjd() {
        if (this.hFA == null) {
            this.hFA = new ArrayList();
        }
        return this.hFA;
    }

    public boolean cje() {
        return this.hFt == 1;
    }

    public void wW(int i) {
        this.hFt = i;
    }

    public String cjc() {
        return this.hFr;
    }

    public void Ii(String str) {
        this.hFr = str;
    }

    public int cjf() {
        return this.hFu;
    }

    public String cjg() {
        return this.mark_name;
    }

    public String cjh() {
        return this.mark_pic;
    }

    public int cji() {
        return this.hFw;
    }

    public void wX(int i) {
        this.hFw = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cjj() {
        return this.hFy;
    }

    public int cjk() {
        return this.hFv;
    }

    public String cjl() {
        return this.hFz;
    }

    public boolean cjm() {
        return this.type == 10;
    }

    public boolean cjn() {
        return this.type == 9;
    }
}
