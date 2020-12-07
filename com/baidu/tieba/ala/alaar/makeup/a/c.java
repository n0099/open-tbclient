package com.baidu.tieba.ala.alaar.makeup.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.tieba.ala.alaar.makeup.d;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.ala.alaar.makeup.b.a {
    public String aER;
    public BdUniqueId aEZ;
    private boolean eFm;
    private boolean gjJ;
    private boolean gjK;
    protected b gjL;
    protected boolean gjz;
    private File mFolder;

    public c() {
    }

    public c(File file) {
        this.mFolder = file;
    }

    public String getSign() {
        return this.gjL.getSign();
    }

    public int getPosition() {
        return this.gjL.getPosition();
    }

    public void setPosition(int i) {
        this.gjL.setPosition(i);
    }

    public void setData(List<d> list) {
        this.gjL.setData(list);
    }

    public b bQg() {
        return this.gjL;
    }

    public boolean bQh() {
        return this.gjJ;
    }

    public boolean Dt() {
        return this.eFm;
    }

    public int size() {
        if (this.gjL == null) {
            return 0;
        }
        return this.gjL.size();
    }

    public boolean bQi() {
        return this.gjK;
    }

    public void lO(boolean z) {
        this.gjK = z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.b.b
    public boolean du(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        this.eFm = jSONObject.optInt("switch", 0) == 1;
        this.gjJ = jSONObject.optInt("red_dot_switch", 0) == 1;
        this.gjK = jSONObject.optInt("is_user_clicked", 0) == 1;
        this.gjz = jSONObject.optInt("is_male", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("beauty_conf");
        this.gjL = new b();
        this.gjL.W(this.mFolder);
        return optJSONObject != null && this.gjL.du(optJSONObject);
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("switch", this.eFm ? 1 : 0);
            jSONObject.put("red_dot_switch", this.gjJ ? 1 : 0);
            jSONObject.put("is_user_clicked", this.gjK ? 1 : 0);
            jSONObject.put("is_male", this.gjz ? 1 : 0);
            jSONObject.put("beauty_conf", this.gjL != null ? this.gjL.toJson() : null);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
