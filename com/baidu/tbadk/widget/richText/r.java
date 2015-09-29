package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.lib.a.b.a.a.i {
    private int aCu;
    private Object aCv;
    private int duration;
    private String md5;

    public r() {
    }

    public r(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.aCu = pbContent.is_sub.intValue();
        }
    }

    public r(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.aCu = jSONObject.optInt("is_sub");
        }
    }

    public String wf() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Fu() {
        return this.aCu;
    }

    public Object Fv() {
        return this.aCv;
    }

    public void C(Object obj) {
        this.aCv = obj;
    }
}
