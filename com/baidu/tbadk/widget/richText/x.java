package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.lib.a.b.a.a.i {
    private Object aJA;
    private int aJz;
    private int duration;
    private String md5;

    public x() {
    }

    public x(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.aJz = pbContent.is_sub.intValue();
        }
    }

    public x(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.aJz = jSONObject.optInt("is_sub");
        }
    }

    public String getMd5() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Jc() {
        return this.aJz;
    }

    public Object Jd() {
        return this.aJA;
    }

    public void D(Object obj) {
        this.aJA = obj;
    }
}
