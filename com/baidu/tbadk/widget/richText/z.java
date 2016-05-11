package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.a.b.a.a.i {
    private int aFG;
    private Object aFH;
    private int duration;
    private String md5;

    public z() {
    }

    public z(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.aFG = pbContent.is_sub.intValue();
        }
    }

    public z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.aFG = jSONObject.optInt("is_sub");
        }
    }

    public String getMd5() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Hs() {
        return this.aFG;
    }

    public Object Ht() {
        return this.aFH;
    }

    public void D(Object obj) {
        this.aFH = obj;
    }
}
