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
    private String fvO;
    private int fvQ;
    private int fvR;
    private int fvS;
    private int fvT;
    private String fvU;
    private String fvV;
    private String fvW;
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
    private List<d> fvX = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.fvR = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.fvT = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.fvS = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.fvV = jSONObject.optString("next_level_diff");
        this.fvU = jSONObject.optString("mark_dir_level");
        this.fvW = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.fvX.add(dVar);
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

    public List<d> bso() {
        if (this.fvX == null) {
            this.fvX = new ArrayList();
        }
        return this.fvX;
    }

    public boolean bsp() {
        return this.fvQ == 1;
    }

    public void qO(int i) {
        this.fvQ = i;
    }

    public String bsn() {
        return this.fvO;
    }

    public void zE(String str) {
        this.fvO = str;
    }

    public int bsq() {
        return this.fvR;
    }

    public String bsr() {
        return this.mark_name;
    }

    public String bss() {
        return this.mark_pic;
    }

    public int bst() {
        return this.fvT;
    }

    public void qP(int i) {
        this.fvT = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bsu() {
        return this.fvV;
    }

    public int bsv() {
        return this.fvS;
    }

    public String bsw() {
        return this.fvW;
    }

    public boolean bsx() {
        return this.type == 10;
    }

    public boolean bsy() {
        return this.type == 9;
    }
}
