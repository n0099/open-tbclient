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
    private String gqr;
    private int gqt;
    private int gqu;
    private int gqv;
    private int gqw;
    private String gqx;
    private String gqy;
    private String gqz;
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
    private List<d> gqA = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.gqu = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.gqw = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.gqv = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt("weight");
        this.gqy = jSONObject.optString("next_level_diff");
        this.gqx = jSONObject.optString("mark_dir_level");
        this.gqz = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.gqA.add(dVar);
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

    public List<d> bIx() {
        if (this.gqA == null) {
            this.gqA = new ArrayList();
        }
        return this.gqA;
    }

    public boolean bIy() {
        return this.gqt == 1;
    }

    public void rO(int i) {
        this.gqt = i;
    }

    public String bIw() {
        return this.gqr;
    }

    public void CY(String str) {
        this.gqr = str;
    }

    public int bIz() {
        return this.gqu;
    }

    public String bIA() {
        return this.mark_name;
    }

    public String bIB() {
        return this.mark_pic;
    }

    public int bIC() {
        return this.gqw;
    }

    public void rP(int i) {
        this.gqw = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bID() {
        return this.gqy;
    }

    public int bIE() {
        return this.gqv;
    }

    public String bIF() {
        return this.gqz;
    }

    public boolean bIG() {
        return this.type == 10;
    }

    public boolean bIH() {
        return this.type == 9;
    }
}
