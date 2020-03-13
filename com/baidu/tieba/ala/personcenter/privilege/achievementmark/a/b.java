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
    private String fwb;
    private int fwd;
    private int fwe;
    private int fwf;
    private int fwg;
    private String fwh;
    private String fwi;
    private String fwj;
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
    private List<d> fwk = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type");
        this.fwe = jSONObject.optInt("mark_id");
        this.mark_name = jSONObject.optString("mark_name");
        this.description = jSONObject.optString("description");
        this.fwg = jSONObject.optInt("wear_status");
        this.mark_pic = jSONObject.optString("mark_pic");
        this.fwf = jSONObject.optInt("mark_rank");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.fwi = jSONObject.optString("next_level_diff");
        this.fwh = jSONObject.optString("mark_dir_level");
        this.fwj = jSONObject.optString("expire_text");
        this.start_time = jSONObject.optString("begin_time");
        this.end_time = jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parseJson(optJSONArray.optJSONObject(i));
                this.fwk.add(dVar);
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

    public List<d> bsp() {
        if (this.fwk == null) {
            this.fwk = new ArrayList();
        }
        return this.fwk;
    }

    public boolean bsq() {
        return this.fwd == 1;
    }

    public void qO(int i) {
        this.fwd = i;
    }

    public String bso() {
        return this.fwb;
    }

    public void zF(String str) {
        this.fwb = str;
    }

    public int bsr() {
        return this.fwe;
    }

    public String bss() {
        return this.mark_name;
    }

    public String bst() {
        return this.mark_pic;
    }

    public int bsu() {
        return this.fwg;
    }

    public void qP(int i) {
        this.fwg = i;
    }

    public String getDescription() {
        return this.description;
    }

    public String bsv() {
        return this.fwi;
    }

    public int bsw() {
        return this.fwf;
    }

    public String bsx() {
        return this.fwj;
    }

    public boolean bsy() {
        return this.type == 10;
    }

    public boolean bsz() {
        return this.type == 9;
    }
}
