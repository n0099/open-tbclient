package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.tieba.ala.alaar.makeup.d;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.tieba.ala.alaar.makeup.b.a {
    public String aFj;
    public BdUniqueId aFr;
    private boolean ePc;
    protected boolean gua;
    private boolean guk;
    private boolean gul;
    protected b gum;
    private File mFolder;

    public c() {
    }

    public c(File file) {
        this.mFolder = file;
    }

    public String getSign() {
        return this.gum.getSign();
    }

    public int getPosition() {
        return this.gum.getPosition();
    }

    public void setPosition(int i) {
        this.gum.setPosition(i);
    }

    public void setData(List<d> list) {
        this.gum.setData(list);
    }

    public b bSI() {
        return this.gum;
    }

    public boolean bSJ() {
        return this.guk;
    }

    public boolean CJ() {
        return this.ePc;
    }

    public int size() {
        if (this.gum == null) {
            return 0;
        }
        return this.gum.size();
    }

    public boolean bSK() {
        return this.gul;
    }

    public void ml(boolean z) {
        this.gul = z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dD(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        this.ePc = jSONObject.optInt("switch", 0) == 1;
        this.guk = jSONObject.optInt("red_dot_switch", 0) == 1;
        this.gul = jSONObject.optInt("is_user_clicked", 0) == 1;
        this.gua = jSONObject.optInt("is_male", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("beauty_conf");
        this.gum = new b();
        this.gum.Z(this.mFolder);
        return optJSONObject != null && this.gum.dD(optJSONObject);
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.ePc ? 1 : 0);
            jSONObject.put("red_dot_switch", this.guk ? 1 : 0);
            jSONObject.put("is_user_clicked", this.gul ? 1 : 0);
            jSONObject.put("is_male", this.gua ? 1 : 0);
            jSONObject.put("beauty_conf", this.gum != null ? this.gum.toJson() : null);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
