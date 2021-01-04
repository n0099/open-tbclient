package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private int height;
    private int ibA;
    private String ibB;
    private String ibC;
    private String ibD;
    private String ibv;
    private int ibx;
    private int iby;
    private int ibz;
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
    private List<d> ibE = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.iby = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.ibA = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.ibz = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.ibC = jSONObject.optString("next_level_diff");
        this.ibB = jSONObject.optString("mark_dir_level");
        this.ibD = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.ibE.add(dVar);
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

    public List<d> cpQ() {
        if (this.ibE == null) {
            this.ibE = new ArrayList();
        }
        return this.ibE;
    }

    public boolean cpR() {
        return this.ibx == 1;
    }

    public void xO(int i) {
        this.ibx = i;
    }

    public String cpP() {
        return this.ibv;
    }

    public void IV(String str) {
        this.ibv = str;
    }

    public int cpS() {
        return this.iby;
    }

    public String cpT() {
        return this.mark_name;
    }

    public String cpU() {
        return this.mark_pic;
    }

    public int cpV() {
        return this.ibA;
    }

    public void xP(int i) {
        this.ibA = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String cpW() {
        return this.ibC;
    }

    public int cpX() {
        return this.ibz;
    }

    public String cpY() {
        return this.ibD;
    }

    public boolean cpZ() {
        return this.type == 10;
    }

    public boolean cqa() {
        return this.type == 9;
    }
}
