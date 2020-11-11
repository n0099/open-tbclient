package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.tieba.ala.alaar.makeup.d;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.ala.alaar.makeup.b.a {
    public String aDW;
    public BdUniqueId aEe;
    private boolean ezW;
    protected boolean gbH;
    private boolean gbR;
    private boolean gbS;
    protected b gbT;
    private File mFolder;

    public c() {
    }

    public c(File file) {
        this.mFolder = file;
    }

    public String getSign() {
        return this.gbT.getSign();
    }

    public int getPosition() {
        return this.gbT.getPosition();
    }

    public void setPosition(int i) {
        this.gbT.setPosition(i);
    }

    public void setData(List<d> list) {
        this.gbT.setData(list);
    }

    public b bNc() {
        return this.gbT;
    }

    public boolean bNd() {
        return this.gbR;
    }

    public boolean Cs() {
        return this.ezW;
    }

    public int size() {
        if (this.gbT == null) {
            return 0;
        }
        return this.gbT.size();
    }

    public boolean bNe() {
        return this.gbS;
    }

    public void ls(boolean z) {
        this.gbS = z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dz(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        this.ezW = jSONObject.optInt("switch", 0) == 1;
        this.gbR = jSONObject.optInt("red_dot_switch", 0) == 1;
        this.gbS = jSONObject.optInt("is_user_clicked", 0) == 1;
        this.gbH = jSONObject.optInt("is_male", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("beauty_conf");
        this.gbT = new b();
        this.gbT.X(this.mFolder);
        return optJSONObject != null && this.gbT.dz(optJSONObject);
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.ezW ? 1 : 0);
            jSONObject.put("red_dot_switch", this.gbR ? 1 : 0);
            jSONObject.put("is_user_clicked", this.gbS ? 1 : 0);
            jSONObject.put("is_male", this.gbH ? 1 : 0);
            jSONObject.put("beauty_conf", this.gbT != null ? this.gbT.toJson() : null);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
