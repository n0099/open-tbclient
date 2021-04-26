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
    public String f14003e;

    /* renamed from: f  reason: collision with root package name */
    public String f14004f;

    /* renamed from: g  reason: collision with root package name */
    public String f14005g;

    /* renamed from: h  reason: collision with root package name */
    public int f14006h;

    /* renamed from: i  reason: collision with root package name */
    public int f14007i;
    public String j;
    public String k;
    public int l;

    public TbRichTextCommInfo() {
        this.f14003e = null;
        this.f14004f = null;
        this.f14005g = null;
        this.f14006h = 0;
        this.l = 0;
    }

    public String getLink() {
        return this.f14004f;
    }

    public String getText() {
        return this.f14003e;
    }

    public int s() {
        return this.f14007i;
    }

    public void setLink(String str) {
        this.f14004f = str;
    }

    public void setText(String str) {
        this.f14003e = str;
    }

    public String t() {
        return this.f14005g;
    }

    public String u() {
        return this.j;
    }

    public int v() {
        return this.l;
    }

    public void w() {
        String str = this.f14003e;
        if (str != null) {
            this.f14003e = str.replaceAll("\n", "");
        }
        String str2 = this.f14004f;
        if (str2 != null) {
            this.f14004f = str2.replaceAll("\n", "");
        }
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.f14003e = null;
        this.f14004f = null;
        this.f14005g = null;
        this.f14006h = 0;
        this.l = 0;
        if (jSONObject == null) {
            return;
        }
        this.f14003e = jSONObject.optString("text");
        this.f14004f = jSONObject.optString("link");
        this.f14005g = jSONObject.optString(LegoListActivityConfig.ITEM_ID);
        this.f14006h = jSONObject.optInt("type", 0);
        this.l = jSONObject.optInt("url_type", 0);
        int optInt = jSONObject.optInt("is_native_app", 0);
        this.f14007i = optInt;
        if (optInt != 1) {
            return;
        }
        if (jSONObject.optJSONObject("native_app") == null) {
            this.f14007i = 0;
            return;
        }
        this.j = jSONObject.optString("jump_and");
        this.k = jSONObject.optString("download_and");
        if (!TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.k)) {
            int i2 = this.f14006h;
            if (i2 == 1) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f14004f;
            } else if (i2 == 5) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f14003e;
            }
            this.j += ";is_native_app=1";
            return;
        }
        this.f14007i = 0;
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.f14003e = null;
        this.f14004f = null;
        this.f14005g = null;
        this.f14006h = 0;
        this.l = 0;
        if (pbContent == null) {
            return;
        }
        this.f14003e = pbContent.text;
        this.f14004f = pbContent.link;
        this.f14006h = pbContent.type.intValue();
        this.f14005g = pbContent.item_id + "";
        this.l = pbContent.url_type.intValue();
        int intValue = pbContent.is_native_app.intValue();
        this.f14007i = intValue;
        if (intValue != 1) {
            return;
        }
        NativeApp nativeApp = pbContent.native_app;
        if (nativeApp == null) {
            this.f14007i = 0;
            return;
        }
        String str = nativeApp.jump_and;
        this.j = str;
        this.k = nativeApp.download_and;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.k)) {
            int i2 = this.f14006h;
            if (i2 == 1) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f14004f;
            } else if (i2 == 5) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f14003e;
            }
            this.j += ";is_native_app=1";
            return;
        }
        this.f14007i = 0;
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.f14003e = null;
        this.f14004f = null;
        this.f14005g = null;
        this.f14006h = 0;
        this.l = 0;
        this.f14003e = str;
        this.f14004f = str2;
    }
}
