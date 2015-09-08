package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.lib.a.b.a.a.i {
    private int aDY;
    private Object aDZ;
    private int duration;
    private String md5;

    public r() {
    }

    public r(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.aDY = pbContent.is_sub.intValue();
        }
    }

    public r(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.aDY = jSONObject.optInt("is_sub");
        }
    }

    public String wu() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int FG() {
        return this.aDY;
    }

    public Object FH() {
        return this.aDZ;
    }

    public void C(Object obj) {
        this.aDZ = obj;
    }
}
