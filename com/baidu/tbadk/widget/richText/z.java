package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.a.b.a.a.i {
    private int aKD;
    private Object aKE;
    private int duration;
    private String md5;

    public z() {
    }

    public z(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.aKD = pbContent.is_sub.intValue();
        }
    }

    public z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.aKD = jSONObject.optInt("is_sub");
        }
    }

    public String getMd5() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int IV() {
        return this.aKD;
    }

    public Object IW() {
        return this.aKE;
    }

    public void G(Object obj) {
        this.aKE = obj;
    }
}
