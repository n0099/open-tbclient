package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String WB;
    private int aFo;
    private String aFp;
    private String aFq;
    private String mLink;
    private int mType;

    public b() {
        this.WB = null;
        this.mLink = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.WB = null;
        this.mLink = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.WB = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aFo = jSONObject.optInt("is_native_app", 0);
            if (this.aFo == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aFo = 0;
                    return;
                }
                this.aFp = jSONObject.optString("jump_and");
                this.aFq = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aFp) || TextUtils.isEmpty(this.aFq)) {
                    this.aFo = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aFp = String.valueOf(this.aFp) + ";download_url:" + this.aFq + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aFp = String.valueOf(this.aFp) + ";download_url:" + this.aFq + ";web_play_url:" + this.WB;
                }
                this.aFp = String.valueOf(this.aFp) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.WB = null;
        this.mLink = null;
        this.mType = 0;
        if (pbContent != null) {
            this.WB = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aFo = pbContent.is_native_app.intValue();
            if (this.aFo == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aFo = 0;
                    return;
                }
                this.aFp = nativeApp.jump_and;
                this.aFq = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aFp) || TextUtils.isEmpty(this.aFq)) {
                    this.aFo = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aFp = String.valueOf(this.aFp) + ";download_url:" + this.aFq + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aFp = String.valueOf(this.aFp) + ";download_url:" + this.aFq + ";web_play_url:" + this.WB;
                }
                this.aFp = String.valueOf(this.aFp) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.WB = null;
        this.mLink = null;
        this.mType = 0;
        this.WB = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.WB = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.WB;
    }

    public String getLink() {
        return this.mLink;
    }

    public int GE() {
        return this.aFo;
    }

    public String GF() {
        return this.aFp;
    }

    public void GG() {
        if (this.WB != null) {
            this.WB = this.WB.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
