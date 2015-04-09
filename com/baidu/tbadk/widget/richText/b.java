package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String asm;
    private int asn;
    private String aso;
    private String asp;
    private String mText;
    private int mType;

    public b() {
        this.mText = null;
        this.asm = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.mText = null;
        this.asm = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.asm = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.asn = jSONObject.optInt("is_native_app", 0);
            if (this.asn == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.asn = 0;
                    return;
                }
                this.aso = jSONObject.optString("jump_and");
                this.asp = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aso) || TextUtils.isEmpty(this.asp)) {
                    this.asn = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aso = String.valueOf(this.aso) + ";download_url:" + this.asp + ";web_play_url:" + this.asm;
                } else if (this.mType == 5) {
                    this.aso = String.valueOf(this.aso) + ";download_url:" + this.asp + ";web_play_url:" + this.mText;
                }
                this.aso = String.valueOf(this.aso) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.mText = null;
        this.asm = null;
        this.mType = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.asm = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.asn = pbContent.is_native_app.intValue();
            if (this.asn == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.asn = 0;
                    return;
                }
                this.aso = nativeApp.jump_and;
                this.asp = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aso) || TextUtils.isEmpty(this.asp)) {
                    this.asn = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aso = String.valueOf(this.aso) + ";download_url:" + this.asp + ";web_play_url:" + this.asm;
                } else if (this.mType == 5) {
                    this.aso = String.valueOf(this.aso) + ";download_url:" + this.asp + ";web_play_url:" + this.mText;
                }
                this.aso = String.valueOf(this.aso) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.mText = null;
        this.asm = null;
        this.mType = 0;
        this.mText = str;
        this.asm = str2;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setLink(String str) {
        this.asm = str;
    }

    public String getText() {
        return this.mText;
    }

    public String getLink() {
        return this.asm;
    }

    public int DC() {
        return this.asn;
    }

    public String DD() {
        return this.aso;
    }

    public void DE() {
        if (this.mText != null) {
            this.mText = this.mText.replaceAll("\n", "");
        }
        if (this.asm != null) {
            this.asm = this.asm.replaceAll("\n", "");
        }
    }
}
