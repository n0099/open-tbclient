package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.a.b.a.a.i {
    private int aJK;
    private Object aJL;
    private int duration;
    private String md5;

    public z() {
    }

    public z(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.aJK = pbContent.is_sub.intValue();
        }
    }

    public z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.aJK = jSONObject.optInt("is_sub");
        }
    }

    public String getMd5() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int IS() {
        return this.aJK;
    }

    public Object IT() {
        return this.aJL;
    }

    public void G(Object obj) {
        this.aJL = obj;
    }
}
