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
    private int height;
    private String hzN;
    private int hzP;
    private int hzQ;
    private int hzR;
    private int hzS;
    private String hzT;
    private String hzU;
    private String hzV;
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
    private List<d> hzW = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.hzQ = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.hzS = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.hzR = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.hzU = jSONObject.optString("next_level_diff");
        this.hzT = jSONObject.optString("mark_dir_level");
        this.hzV = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.hzW.add(dVar);
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

    public List<d> chi() {
        if (this.hzW == null) {
            this.hzW = new ArrayList();
        }
        return this.hzW;
    }

    public boolean chj() {
        return this.hzP == 1;
    }

    public void wl(int i) {
        this.hzP = i;
    }

    public String chh() {
        return this.hzN;
    }

    public void Iq(String str) {
        this.hzN = str;
    }

    public int chk() {
        return this.hzQ;
    }

    public String chl() {
        return this.mark_name;
    }

    public String chm() {
        return this.mark_pic;
    }

    public int chn() {
        return this.hzS;
    }

    public void wm(int i) {
        this.hzS = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cho() {
        return this.hzU;
    }

    public int chp() {
        return this.hzR;
    }

    public String chq() {
        return this.hzV;
    }

    public boolean chr() {
        return this.type == 10;
    }

    public boolean chs() {
        return this.type == 9;
    }
}
