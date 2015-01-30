package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.lib.a.b.a.a.i {
    private int akO;
    private Object akP;
    private int duration;
    private String md5;

    public u() {
    }

    public u(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.akO = pbContent.is_sub.intValue();
        }
    }

    public u(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.akO = jSONObject.optInt("is_sub");
        }
    }

    public String rG() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Az() {
        return this.akO;
    }

    public Object AA() {
        return this.akP;
    }

    public void z(Object obj) {
        this.akP = obj;
    }
}
