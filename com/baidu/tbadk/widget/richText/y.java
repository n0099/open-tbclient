package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.lib.a.b.a.a.i {
    private int aJU;
    private Object aJV;
    private int duration;
    private String md5;

    public y() {
    }

    public y(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.aJU = pbContent.is_sub.intValue();
        }
    }

    public y(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.aJU = jSONObject.optInt("is_sub");
        }
    }

    public String getMd5() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Iq() {
        return this.aJU;
    }

    public Object Ir() {
        return this.aJV;
    }

    public void G(Object obj) {
        this.aJV = obj;
    }
}
