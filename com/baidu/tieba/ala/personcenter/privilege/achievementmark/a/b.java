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
    private String hnS;
    private int hnU;
    private int hnV;
    private int hnW;
    private int hnX;
    private String hnY;
    private String hnZ;
    private String hoa;
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
    private List<d> hob = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.hnV = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.hnX = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.hnW = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.hnZ = jSONObject.optString("next_level_diff");
        this.hnY = jSONObject.optString("mark_dir_level");
        this.hoa = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.hob.add(dVar);
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

    public List<d> ceg() {
        if (this.hob == null) {
            this.hob = new ArrayList();
        }
        return this.hob;
    }

    public boolean ceh() {
        return this.hnU == 1;
    }

    public void vR(int i) {
        this.hnU = i;
    }

    public String cef() {
        return this.hnS;
    }

    public void HR(String str) {
        this.hnS = str;
    }

    public int cei() {
        return this.hnV;
    }

    public String cej() {
        return this.mark_name;
    }

    public String cek() {
        return this.mark_pic;
    }

    public int cel() {
        return this.hnX;
    }

    public void vS(int i) {
        this.hnX = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cem() {
        return this.hnZ;
    }

    public int cen() {
        return this.hnW;
    }

    public String ceo() {
        return this.hoa;
    }

    public boolean cep() {
        return this.type == 10;
    }

    public boolean ceq() {
        return this.type == 9;
    }
}
