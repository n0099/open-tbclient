package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String Dn;
    private String abu;
    private int abv;
    private String abw;
    private String abx;
    private int mType;

    public b() {
        this.Dn = null;
        this.abu = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.Dn = null;
        this.abu = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.Dn = jSONObject.optString("text");
            this.abu = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.abv = jSONObject.optInt("is_native_app", 0);
            if (this.abv == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.abv = 0;
                    return;
                }
                this.abw = jSONObject.optString("jump_and");
                this.abx = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.abw) || TextUtils.isEmpty(this.abx)) {
                    this.abv = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.abw = String.valueOf(this.abw) + ";download_url:" + this.abx + ";web_play_url:" + this.abu;
                } else if (this.mType == 5) {
                    this.abw = String.valueOf(this.abw) + ";download_url:" + this.abx + ";web_play_url:" + this.Dn;
                }
                this.abw = String.valueOf(this.abw) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.Dn = null;
        this.abu = null;
        this.mType = 0;
        if (pbContent != null) {
            this.Dn = pbContent.text;
            this.abu = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.abv = pbContent.is_native_app.intValue();
            if (this.abv == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.abv = 0;
                    return;
                }
                this.abw = nativeApp.jump_and;
                this.abx = nativeApp.download_and;
                if (TextUtils.isEmpty(this.abw) || TextUtils.isEmpty(this.abx)) {
                    this.abv = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.abw = String.valueOf(this.abw) + ";download_url:" + this.abx + ";web_play_url:" + this.abu;
                } else if (this.mType == 5) {
                    this.abw = String.valueOf(this.abw) + ";download_url:" + this.abx + ";web_play_url:" + this.Dn;
                }
                this.abw = String.valueOf(this.abw) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.Dn = null;
        this.abu = null;
        this.mType = 0;
        this.Dn = str;
        this.abu = str2;
    }

    public void setText(String str) {
        this.Dn = str;
    }

    public void setLink(String str) {
        this.abu = str;
    }

    public String getText() {
        return this.Dn;
    }

    public String getLink() {
        return this.abu;
    }

    public int vB() {
        return this.abv;
    }

    public String vC() {
        return this.abw;
    }

    public void vD() {
        if (this.Dn != null) {
            this.Dn = this.Dn.replaceAll("\n", "");
        }
        if (this.abu != null) {
            this.abu = this.abu.replaceAll("\n", "");
        }
    }
}
