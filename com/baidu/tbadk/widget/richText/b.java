package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String VC;
    private int aDW;
    private String aDX;
    private String aDY;
    private String mLink;
    private int mType;

    public b() {
        this.VC = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.VC = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.VC = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aDW = jSONObject.optInt("is_native_app", 0);
            if (this.aDW == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aDW = 0;
                    return;
                }
                this.aDX = jSONObject.optString("jump_and");
                this.aDY = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aDX) || TextUtils.isEmpty(this.aDY)) {
                    this.aDW = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aDX = String.valueOf(this.aDX) + ";download_url:" + this.aDY + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aDX = String.valueOf(this.aDX) + ";download_url:" + this.aDY + ";web_play_url:" + this.VC;
                }
                this.aDX = String.valueOf(this.aDX) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.VC = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.VC = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aDW = pbContent.is_native_app.intValue();
            if (this.aDW == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aDW = 0;
                    return;
                }
                this.aDX = nativeApp.jump_and;
                this.aDY = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aDX) || TextUtils.isEmpty(this.aDY)) {
                    this.aDW = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aDX = String.valueOf(this.aDX) + ";download_url:" + this.aDY + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aDX = String.valueOf(this.aDX) + ";download_url:" + this.aDY + ";web_play_url:" + this.VC;
                }
                this.aDX = String.valueOf(this.aDX) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.VC = null;
        this.mLink = null;
        this.mType = 0;
        this.VC = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.VC = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.VC;
    }

    public String getLink() {
        return this.mLink;
    }

    public int GF() {
        return this.aDW;
    }

    public String GG() {
        return this.aDX;
    }

    public void GH() {
        if (this.VC != null) {
            this.VC = this.VC.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
