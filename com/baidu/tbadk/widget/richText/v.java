package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.lib.a.b.a.a.i {
    private int aFL;
    private Object aFM;
    private int duration;
    private String md5;

    public v() {
    }

    public v(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.aFL = pbContent.is_sub.intValue();
        }
    }

    public v(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.aFL = jSONObject.optInt("is_sub");
        }
    }

    public String wK() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Gh() {
        return this.aFL;
    }

    public Object Gi() {
        return this.aFM;
    }

    public void C(Object obj) {
        this.aFM = obj;
    }
}
