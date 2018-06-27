package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextVoiceInfo extends OrmObject {
    private int bgt;
    private Object bgu;
    private int duration;
    private String md5;

    public TbRichTextVoiceInfo() {
    }

    public TbRichTextVoiceInfo(PbContent pbContent) {
        if (pbContent != null) {
            this.md5 = pbContent.voice_md5;
            this.duration = pbContent.during_time.intValue() / 1000;
            this.bgt = pbContent.is_sub.intValue();
        }
    }

    public TbRichTextVoiceInfo(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.md5 = jSONObject.optString("voice_md5");
            this.duration = jSONObject.optInt("during_time") / 1000;
            this.bgt = jSONObject.optInt("is_sub");
        }
    }

    public String Cn() {
        return this.md5;
    }

    public int getDuration() {
        return this.duration;
    }

    public int Ot() {
        return this.bgt;
    }

    public Object Ou() {
        return this.bgu;
    }

    public void H(Object obj) {
        this.bgu = obj;
    }
}
