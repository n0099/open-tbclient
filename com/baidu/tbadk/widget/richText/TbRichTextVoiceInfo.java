package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextVoiceInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f13366e;

    /* renamed from: f  reason: collision with root package name */
    public int f13367f;

    /* renamed from: g  reason: collision with root package name */
    public int f13368g;

    /* renamed from: h  reason: collision with root package name */
    public Object f13369h;

    public TbRichTextVoiceInfo() {
    }

    public int getDuration() {
        return this.f13367f;
    }

    public int w() {
        return this.f13368g;
    }

    public String x() {
        return this.f13366e;
    }

    public Object y() {
        return this.f13369h;
    }

    public void z(Object obj) {
        this.f13369h = obj;
    }

    public TbRichTextVoiceInfo(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f13366e = pbContent.voice_md5;
        this.f13367f = pbContent.during_time.intValue() / 1000;
        this.f13368g = pbContent.is_sub.intValue();
    }

    public TbRichTextVoiceInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13366e = jSONObject.optString("voice_md5");
        this.f13367f = jSONObject.optInt("during_time") / 1000;
        this.f13368g = jSONObject.optInt("is_sub");
    }
}
