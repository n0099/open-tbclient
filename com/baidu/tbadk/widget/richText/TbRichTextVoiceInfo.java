package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextVoiceInfo extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f13301e;

    /* renamed from: f  reason: collision with root package name */
    public int f13302f;

    /* renamed from: g  reason: collision with root package name */
    public int f13303g;

    /* renamed from: h  reason: collision with root package name */
    public Object f13304h;

    public TbRichTextVoiceInfo() {
    }

    public int getDuration() {
        return this.f13302f;
    }

    public int s() {
        return this.f13303g;
    }

    public String t() {
        return this.f13301e;
    }

    public Object u() {
        return this.f13304h;
    }

    public void v(Object obj) {
        this.f13304h = obj;
    }

    public TbRichTextVoiceInfo(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.f13301e = pbContent.voice_md5;
        this.f13302f = pbContent.during_time.intValue() / 1000;
        this.f13303g = pbContent.is_sub.intValue();
    }

    public TbRichTextVoiceInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13301e = jSONObject.optString("voice_md5");
        this.f13302f = jSONObject.optInt("during_time") / 1000;
        this.f13303g = jSONObject.optInt("is_sub");
    }
}
