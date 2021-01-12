package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.tieba.ala.alaar.makeup.d;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.ala.alaar.makeup.b.a {
    public BdUniqueId aAE;
    public String aAw;
    private boolean eKr;
    private boolean gpD;
    private boolean gpE;
    protected b gpF;
    protected boolean gpt;
    private File mFolder;

    public c() {
    }

    public c(File file) {
        this.mFolder = file;
    }

    public String getSign() {
        return this.gpF.getSign();
    }

    public int getPosition() {
        return this.gpF.getPosition();
    }

    public void setPosition(int i) {
        this.gpF.setPosition(i);
    }

    public void setData(List<d> list) {
        this.gpF.setData(list);
    }

    public b bOQ() {
        return this.gpF;
    }

    public boolean bOR() {
        return this.gpD;
    }

    public boolean yO() {
        return this.eKr;
    }

    public int size() {
        if (this.gpF == null) {
            return 0;
        }
        return this.gpF.size();
    }

    public boolean bOS() {
        return this.gpE;
    }

    public void mh(boolean z) {
        this.gpE = z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean dD(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        this.eKr = jSONObject.optInt("switch", 0) == 1;
        this.gpD = jSONObject.optInt("red_dot_switch", 0) == 1;
        this.gpE = jSONObject.optInt("is_user_clicked", 0) == 1;
        this.gpt = jSONObject.optInt("is_male", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("beauty_conf");
        this.gpF = new b();
        this.gpF.Y(this.mFolder);
        return optJSONObject != null && this.gpF.dD(optJSONObject);
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.eKr ? 1 : 0);
            jSONObject.put("red_dot_switch", this.gpD ? 1 : 0);
            jSONObject.put("is_user_clicked", this.gpE ? 1 : 0);
            jSONObject.put("is_male", this.gpt ? 1 : 0);
            jSONObject.put("beauty_conf", this.gpF != null ? this.gpF.toJson() : null);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
