package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.lib.a.b.a.a.i {
    private int akk;
    private Object akl;
    private int duration;
    private String md5;

    public u() {
    }

    public u(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.akk = pbContent.is_sub.intValue();
        }
    }

    public u(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.akk = jSONObject.optInt("is_sub");
        }
    }

    public String ru() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Af() {
        return this.akk;
    }

    public Object Ag() {
        return this.akl;
    }

    public void z(Object obj) {
        this.akl = obj;
    }
}
