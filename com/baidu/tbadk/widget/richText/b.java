package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String VS;
    private int aEx;
    private String aEy;
    private String aEz;
    private String mLink;
    private int mType;

    public b() {
        this.VS = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.VS = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.VS = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aEx = jSONObject.optInt("is_native_app", 0);
            if (this.aEx == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aEx = 0;
                    return;
                }
                this.aEy = jSONObject.optString("jump_and");
                this.aEz = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aEy) || TextUtils.isEmpty(this.aEz)) {
                    this.aEx = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aEy = String.valueOf(this.aEy) + ";download_url:" + this.aEz + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aEy = String.valueOf(this.aEy) + ";download_url:" + this.aEz + ";web_play_url:" + this.VS;
                }
                this.aEy = String.valueOf(this.aEy) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.VS = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.VS = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aEx = pbContent.is_native_app.intValue();
            if (this.aEx == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aEx = 0;
                    return;
                }
                this.aEy = nativeApp.jump_and;
                this.aEz = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aEy) || TextUtils.isEmpty(this.aEz)) {
                    this.aEx = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aEy = String.valueOf(this.aEy) + ";download_url:" + this.aEz + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aEy = String.valueOf(this.aEy) + ";download_url:" + this.aEz + ";web_play_url:" + this.VS;
                }
                this.aEy = String.valueOf(this.aEy) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.VS = null;
        this.mLink = null;
        this.mType = 0;
        this.VS = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.VS = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.VS;
    }

    public String getLink() {
        return this.mLink;
    }

    public int GG() {
        return this.aEx;
    }

    public String GH() {
        return this.aEy;
    }

    public void GI() {
        if (this.VS != null) {
            this.VS = this.VS.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
