package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private int aFg;
    private String aFh;
    private String aFi;
    private String aaR;
    private String mLink;
    private int mType;

    public b() {
        this.aaR = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.aaR = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.aaR = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aFg = jSONObject.optInt("is_native_app", 0);
            if (this.aFg == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aFg = 0;
                    return;
                }
                this.aFh = jSONObject.optString("jump_and");
                this.aFi = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aFh) || TextUtils.isEmpty(this.aFi)) {
                    this.aFg = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aFh = String.valueOf(this.aFh) + ";download_url:" + this.aFi + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aFh = String.valueOf(this.aFh) + ";download_url:" + this.aFi + ";web_play_url:" + this.aaR;
                }
                this.aFh = String.valueOf(this.aFh) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.aaR = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.aaR = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aFg = pbContent.is_native_app.intValue();
            if (this.aFg == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aFg = 0;
                    return;
                }
                this.aFh = nativeApp.jump_and;
                this.aFi = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aFh) || TextUtils.isEmpty(this.aFi)) {
                    this.aFg = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aFh = String.valueOf(this.aFh) + ";download_url:" + this.aFi + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aFh = String.valueOf(this.aFh) + ";download_url:" + this.aFi + ";web_play_url:" + this.aaR;
                }
                this.aFh = String.valueOf(this.aFh) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.aaR = null;
        this.mLink = null;
        this.mType = 0;
        this.aaR = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aaR = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aaR;
    }

    public String getLink() {
        return this.mLink;
    }

    public int GT() {
        return this.aFg;
    }

    public String GU() {
        return this.aFh;
    }

    public void GV() {
        if (this.aaR != null) {
            this.aaR = this.aaR.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
