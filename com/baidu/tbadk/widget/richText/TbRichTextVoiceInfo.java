package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextVoiceInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f14331e;

    /* renamed from: f  reason: collision with root package name */
    public int f14332f;

    /* renamed from: g  reason: collision with root package name */
    public int f14333g;

    /* renamed from: h  reason: collision with root package name */
    public Object f14334h;

    public TbRichTextVoiceInfo() {
    }

    public int getDuration() {
        return this.f14332f;
    }

    public int s() {
        return this.f14333g;
    }

    public String t() {
        return this.f14331e;
    }

    public Object u() {
        return this.f14334h;
    }

    public void v(Object obj) {
        this.f14334h = obj;
    }

    public TbRichTextVoiceInfo(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f14331e = pbContent.voice_md5;
        this.f14332f = pbContent.during_time.intValue() / 1000;
        this.f14333g = pbContent.is_sub.intValue();
    }

    public TbRichTextVoiceInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f14331e = jSONObject.optString("voice_md5");
        this.f14332f = jSONObject.optInt("during_time") / 1000;
        this.f14333g = jSONObject.optInt("is_sub");
    }
}
