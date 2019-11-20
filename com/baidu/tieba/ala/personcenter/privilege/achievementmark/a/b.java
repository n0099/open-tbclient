package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String eyB;
    private int eyD;
    private int eyE;
    private int eyF;
    private int eyG;
    private String eyH;
    private String eyI;
    private String eyJ;
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
    private List<d> eyK = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.eyE = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.eyG = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.eyF = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.eyI = jSONObject.optString("next_level_diff");
        this.eyH = jSONObject.optString("mark_dir_level");
        this.eyJ = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.eyK.add(dVar);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("props_info");
        if (optJSONObject != null) {
            this.propId = com.baidu.adp.lib.g.b.toInt(optJSONObject.optString("props_id"), -1);
            this.price = com.baidu.adp.lib.g.b.toLong(optJSONObject.optString("price"), 0L);
            this.time = optJSONObject.optString("buy_cycle");
            this.buy_staus = optJSONObject.optInt("buy_staus");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("nobility_info");
        if (optJSONObject2 != null) {
            this.nobilityType = optJSONObject2.optInt("nobility_type");
            this.nobilityName = optJSONObject2.optString("nobility_type_name");
        }
    }

    public List<d> aXK() {
        if (this.eyK == null) {
            this.eyK = new ArrayList();
        }
        return this.eyK;
    }

    public boolean aXL() {
        return this.eyD == 1;
    }

    public void oj(int i) {
        this.eyD = i;
    }

    public String aXJ() {
        return this.eyB;
    }

    public void ul(String str) {
        this.eyB = str;
    }

    public int aXM() {
        return this.eyE;
    }

    public String aXN() {
        return this.mark_name;
    }

    public String aXO() {
        return this.mark_pic;
    }

    public int aXP() {
        return this.eyG;
    }

    public void ok(int i) {
        this.eyG = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String aXQ() {
        return this.eyI;
    }

    public int aXR() {
        return this.eyF;
    }

    public String aXS() {
        return this.eyJ;
    }

    public boolean aXT() {
        return this.type == 10;
    }

    public boolean aXU() {
        return this.type == 9;
    }
}
