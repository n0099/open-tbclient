package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextVoiceInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f13448e;

    /* renamed from: f  reason: collision with root package name */
    public int f13449f;

    /* renamed from: g  reason: collision with root package name */
    public int f13450g;

    /* renamed from: h  reason: collision with root package name */
    public Object f13451h;

    public TbRichTextVoiceInfo() {
    }

    public int getDuration() {
        return this.f13449f;
    }

    public int w() {
        return this.f13450g;
    }

    public String x() {
        return this.f13448e;
    }

    public Object y() {
        return this.f13451h;
    }

    public void z(Object obj) {
        this.f13451h = obj;
    }

    public TbRichTextVoiceInfo(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f13448e = pbContent.voice_md5;
        this.f13449f = pbContent.during_time.intValue() / 1000;
        this.f13450g = pbContent.is_sub.intValue();
    }

    public TbRichTextVoiceInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13448e = jSONObject.optString("voice_md5");
        this.f13449f = jSONObject.optInt("during_time") / 1000;
        this.f13450g = jSONObject.optInt("is_sub");
    }
}
