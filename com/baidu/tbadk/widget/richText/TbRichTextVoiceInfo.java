package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextVoiceInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f13393e;

    /* renamed from: f  reason: collision with root package name */
    public int f13394f;

    /* renamed from: g  reason: collision with root package name */
    public int f13395g;

    /* renamed from: h  reason: collision with root package name */
    public Object f13396h;

    public TbRichTextVoiceInfo() {
    }

    public int getDuration() {
        return this.f13394f;
    }

    public int s() {
        return this.f13395g;
    }

    public String t() {
        return this.f13393e;
    }

    public Object u() {
        return this.f13396h;
    }

    public void v(Object obj) {
        this.f13396h = obj;
    }

    public TbRichTextVoiceInfo(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f13393e = pbContent.voice_md5;
        this.f13394f = pbContent.during_time.intValue() / 1000;
        this.f13395g = pbContent.is_sub.intValue();
    }

    public TbRichTextVoiceInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13393e = jSONObject.optString("voice_md5");
        this.f13394f = jSONObject.optInt("during_time") / 1000;
        this.f13395g = jSONObject.optInt("is_sub");
    }
}
