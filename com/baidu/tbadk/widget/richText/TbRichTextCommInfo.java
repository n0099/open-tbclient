package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextCommInfo extends OrmObject {
    public static final int NATIVE_APP_TYPE = 1;
    public static final int TYPE_LINK = 1;
    public static final int TYPE_VIDEO = 5;
    public static final int URL_VALIDITY_INVALID = 1;
    public static final int URL_VALIDITY_NORMAL = 0;
    public static final int URL_VALIDITY_VALID = 2;

    /* renamed from: e  reason: collision with root package name */
    public String f13961e;

    /* renamed from: f  reason: collision with root package name */
    public String f13962f;

    /* renamed from: g  reason: collision with root package name */
    public String f13963g;

    /* renamed from: h  reason: collision with root package name */
    public int f13964h;
    public int i;
    public String j;
    public String k;
    public int l;

    public TbRichTextCommInfo() {
        this.f13961e = null;
        this.f13962f = null;
        this.f13963g = null;
        this.f13964h = 0;
        this.l = 0;
    }

    public String getLink() {
        return this.f13962f;
    }

    public String getText() {
        return this.f13961e;
    }

    public int s() {
        return this.i;
    }

    public void setLink(String str) {
        this.f13962f = str;
    }

    public void setText(String str) {
        this.f13961e = str;
    }

    public String t() {
        return this.f13963g;
    }

    public String u() {
        return this.j;
    }

    public int v() {
        return this.l;
    }

    public void w() {
        String str = this.f13961e;
        if (str != null) {
            this.f13961e = str.replaceAll("\n", "");
        }
        String str2 = this.f13962f;
        if (str2 != null) {
            this.f13962f = str2.replaceAll("\n", "");
        }
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.f13961e = null;
        this.f13962f = null;
        this.f13963g = null;
        this.f13964h = 0;
        this.l = 0;
        if (jSONObject == null) {
            return;
        }
        this.f13961e = jSONObject.optString("text");
        this.f13962f = jSONObject.optString("link");
        this.f13963g = jSONObject.optString(LegoListActivityConfig.ITEM_ID);
        this.f13964h = jSONObject.optInt("type", 0);
        this.l = jSONObject.optInt("url_type", 0);
        int optInt = jSONObject.optInt("is_native_app", 0);
        this.i = optInt;
        if (optInt != 1) {
            return;
        }
        if (jSONObject.optJSONObject("native_app") == null) {
            this.i = 0;
            return;
        }
        this.j = jSONObject.optString("jump_and");
        this.k = jSONObject.optString("download_and");
        if (!TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.k)) {
            int i = this.f13964h;
            if (i == 1) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f13962f;
            } else if (i == 5) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f13961e;
            }
            this.j += ";is_native_app=1";
            return;
        }
        this.i = 0;
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.f13961e = null;
        this.f13962f = null;
        this.f13963g = null;
        this.f13964h = 0;
        this.l = 0;
        if (pbContent == null) {
            return;
        }
        this.f13961e = pbContent.text;
        this.f13962f = pbContent.link;
        this.f13964h = pbContent.type.intValue();
        this.f13963g = pbContent.item_id + "";
        this.l = pbContent.url_type.intValue();
        int intValue = pbContent.is_native_app.intValue();
        this.i = intValue;
        if (intValue != 1) {
            return;
        }
        NativeApp nativeApp = pbContent.native_app;
        if (nativeApp == null) {
            this.i = 0;
            return;
        }
        String str = nativeApp.jump_and;
        this.j = str;
        this.k = nativeApp.download_and;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.k)) {
            int i = this.f13964h;
            if (i == 1) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f13962f;
            } else if (i == 5) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f13961e;
            }
            this.j += ";is_native_app=1";
            return;
        }
        this.i = 0;
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.f13961e = null;
        this.f13962f = null;
        this.f13963g = null;
        this.f13964h = 0;
        this.l = 0;
        this.f13961e = str;
        this.f13962f = str2;
    }
}
