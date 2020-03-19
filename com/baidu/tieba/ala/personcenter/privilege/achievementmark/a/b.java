package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public int buy_staus;
    private String description;
    private String end_time;
    private String fwH;
    private int fwJ;
    private int fwK;
    private int fwL;
    private int fwM;
    private String fwN;
    private String fwO;
    private String fwP;
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
    private List<d> fwQ = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.fwK = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.fwM = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.fwL = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.fwO = jSONObject.optString("next_level_diff");
        this.fwN = jSONObject.optString("mark_dir_level");
        this.fwP = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.fwQ.add(dVar);
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

    public List<d> bsv() {
        if (this.fwQ == null) {
            this.fwQ = new ArrayList();
        }
        return this.fwQ;
    }

    public boolean bsw() {
        return this.fwJ == 1;
    }

    public void qQ(int i) {
        this.fwJ = i;
    }

    public String bsu() {
        return this.fwH;
    }

    public void zH(String str) {
        this.fwH = str;
    }

    public int bsx() {
        return this.fwK;
    }

    public String bsy() {
        return this.mark_name;
    }

    public String bsz() {
        return this.mark_pic;
    }

    public int bsA() {
        return this.fwM;
    }

    public void qR(int i) {
        this.fwM = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bsB() {
        return this.fwO;
    }

    public int bsC() {
        return this.fwL;
    }

    public String bsD() {
        return this.fwP;
    }

    public boolean bsE() {
        return this.type == 10;
    }

    public boolean bsF() {
        return this.type == 9;
    }
}
