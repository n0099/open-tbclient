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
    public String f13312e;

    /* renamed from: f  reason: collision with root package name */
    public String f13313f;

    /* renamed from: g  reason: collision with root package name */
    public String f13314g;

    /* renamed from: h  reason: collision with root package name */
    public int f13315h;

    /* renamed from: i  reason: collision with root package name */
    public int f13316i;
    public String j;
    public String k;
    public int l;

    public TbRichTextCommInfo() {
        this.f13312e = null;
        this.f13313f = null;
        this.f13314g = null;
        this.f13315h = 0;
        this.l = 0;
    }

    public void A() {
        String str = this.f13312e;
        if (str != null) {
            this.f13312e = str.replaceAll("\n", "");
        }
        String str2 = this.f13313f;
        if (str2 != null) {
            this.f13313f = str2.replaceAll("\n", "");
        }
    }

    public String getLink() {
        return this.f13313f;
    }

    public String getText() {
        return this.f13312e;
    }

    public void setLink(String str) {
        this.f13313f = str;
    }

    public void setText(String str) {
        this.f13312e = str;
    }

    public int w() {
        return this.f13316i;
    }

    public String x() {
        return this.f13314g;
    }

    public String y() {
        return this.j;
    }

    public int z() {
        return this.l;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.f13312e = null;
        this.f13313f = null;
        this.f13314g = null;
        this.f13315h = 0;
        this.l = 0;
        if (jSONObject == null) {
            return;
        }
        this.f13312e = jSONObject.optString("text");
        this.f13313f = jSONObject.optString("link");
        this.f13314g = jSONObject.optString(LegoListActivityConfig.ITEM_ID);
        this.f13315h = jSONObject.optInt("type", 0);
        this.l = jSONObject.optInt("url_type", 0);
        int optInt = jSONObject.optInt("is_native_app", 0);
        this.f13316i = optInt;
        if (optInt != 1) {
            return;
        }
        if (jSONObject.optJSONObject("native_app") == null) {
            this.f13316i = 0;
            return;
        }
        this.j = jSONObject.optString("jump_and");
        this.k = jSONObject.optString("download_and");
        if (!TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.k)) {
            int i2 = this.f13315h;
            if (i2 == 1) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f13313f;
            } else if (i2 == 5) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f13312e;
            }
            this.j += ";is_native_app=1";
            return;
        }
        this.f13316i = 0;
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.f13312e = null;
        this.f13313f = null;
        this.f13314g = null;
        this.f13315h = 0;
        this.l = 0;
        if (pbContent == null) {
            return;
        }
        this.f13312e = pbContent.text;
        this.f13313f = pbContent.link;
        this.f13315h = pbContent.type.intValue();
        this.f13314g = pbContent.item_id + "";
        this.l = pbContent.url_type.intValue();
        int intValue = pbContent.is_native_app.intValue();
        this.f13316i = intValue;
        if (intValue != 1) {
            return;
        }
        NativeApp nativeApp = pbContent.native_app;
        if (nativeApp == null) {
            this.f13316i = 0;
            return;
        }
        String str = nativeApp.jump_and;
        this.j = str;
        this.k = nativeApp.download_and;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.k)) {
            int i2 = this.f13315h;
            if (i2 == 1) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f13313f;
            } else if (i2 == 5) {
                this.j += ";download_url:" + this.k + ";web_play_url:" + this.f13312e;
            }
            this.j += ";is_native_app=1";
            return;
        }
        this.f13316i = 0;
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.f13312e = null;
        this.f13313f = null;
        this.f13314g = null;
        this.f13315h = 0;
        this.l = 0;
        this.f13312e = str;
        this.f13313f = str2;
    }
}
