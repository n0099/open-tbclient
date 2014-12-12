package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String ajf;
    private int ajg;
    private String ajh;
    private String aji;
    private String mText;
    private int mType;

    public b() {
        this.mText = null;
        this.ajf = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.mText = null;
        this.ajf = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.ajf = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.ajg = jSONObject.optInt("is_native_app", 0);
            if (this.ajg == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.ajg = 0;
                    return;
                }
                this.ajh = jSONObject.optString("jump_and");
                this.aji = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.ajh) || TextUtils.isEmpty(this.aji)) {
                    this.ajg = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.ajh = String.valueOf(this.ajh) + ";download_url:" + this.aji + ";web_play_url:" + this.ajf;
                } else if (this.mType == 5) {
                    this.ajh = String.valueOf(this.ajh) + ";download_url:" + this.aji + ";web_play_url:" + this.mText;
                }
                this.ajh = String.valueOf(this.ajh) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.mText = null;
        this.ajf = null;
        this.mType = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.ajf = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.ajg = pbContent.is_native_app.intValue();
            if (this.ajg == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.ajg = 0;
                    return;
                }
                this.ajh = nativeApp.jump_and;
                this.aji = nativeApp.download_and;
                if (TextUtils.isEmpty(this.ajh) || TextUtils.isEmpty(this.aji)) {
                    this.ajg = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.ajh = String.valueOf(this.ajh) + ";download_url:" + this.aji + ";web_play_url:" + this.ajf;
                } else if (this.mType == 5) {
                    this.ajh = String.valueOf(this.ajh) + ";download_url:" + this.aji + ";web_play_url:" + this.mText;
                }
                this.ajh = String.valueOf(this.ajh) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.mText = null;
        this.ajf = null;
        this.mType = 0;
        this.mText = str;
        this.ajf = str2;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setLink(String str) {
        this.ajf = str;
    }

    public String getText() {
        return this.mText;
    }

    public String getLink() {
        return this.ajf;
    }

    public int zM() {
        return this.ajg;
    }

    public String zN() {
        return this.ajh;
    }

    public void zO() {
        if (this.mText != null) {
            this.mText = this.mText.replaceAll("\n", "");
        }
        if (this.ajf != null) {
            this.ajf = this.ajf.replaceAll("\n", "");
        }
    }
}
