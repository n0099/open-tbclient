package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.tieba.ala.alaar.makeup.d;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.ala.alaar.makeup.b.a {
    public String aDB;
    public BdUniqueId aDJ;
    private boolean eOe;
    protected boolean gtZ;
    private boolean guj;
    private boolean guk;
    protected b gul;
    private File mFolder;

    public c() {
    }

    public c(File file) {
        this.mFolder = file;
    }

    public String getSign() {
        return this.gul.getSign();
    }

    public int getPosition() {
        return this.gul.getPosition();
    }

    public void setPosition(int i) {
        this.gul.setPosition(i);
    }

    public void setData(List<d> list) {
        this.gul.setData(list);
    }

    public b bPH() {
        return this.gul;
    }

    public boolean bPI() {
        return this.guj;
    }

    public boolean zy() {
        return this.eOe;
    }

    public int size() {
        if (this.gul == null) {
            return 0;
        }
        return this.gul.size();
    }

    public boolean bPJ() {
        return this.guk;
    }

    public void ml(boolean z) {
        this.guk = z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dG(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        this.eOe = jSONObject.optInt("switch", 0) == 1;
        this.guj = jSONObject.optInt("red_dot_switch", 0) == 1;
        this.guk = jSONObject.optInt("is_user_clicked", 0) == 1;
        this.gtZ = jSONObject.optInt("is_male", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("beauty_conf");
        this.gul = new b();
        this.gul.V(this.mFolder);
        return optJSONObject != null && this.gul.dG(optJSONObject);
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.eOe ? 1 : 0);
            jSONObject.put("red_dot_switch", this.guj ? 1 : 0);
            jSONObject.put("is_user_clicked", this.guk ? 1 : 0);
            jSONObject.put("is_male", this.gtZ ? 1 : 0);
            jSONObject.put("beauty_conf", this.gul != null ? this.gul.toJson() : null);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
