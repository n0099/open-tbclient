package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String ase;
    private int asf;
    private String asg;
    private String ash;
    private String mText;
    private int mType;

    public b() {
        this.mText = null;
        this.ase = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.mText = null;
        this.ase = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.ase = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.asf = jSONObject.optInt("is_native_app", 0);
            if (this.asf == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.asf = 0;
                    return;
                }
                this.asg = jSONObject.optString("jump_and");
                this.ash = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.asg) || TextUtils.isEmpty(this.ash)) {
                    this.asf = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.asg = String.valueOf(this.asg) + ";download_url:" + this.ash + ";web_play_url:" + this.ase;
                } else if (this.mType == 5) {
                    this.asg = String.valueOf(this.asg) + ";download_url:" + this.ash + ";web_play_url:" + this.mText;
                }
                this.asg = String.valueOf(this.asg) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.mText = null;
        this.ase = null;
        this.mType = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.ase = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.asf = pbContent.is_native_app.intValue();
            if (this.asf == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.asf = 0;
                    return;
                }
                this.asg = nativeApp.jump_and;
                this.ash = nativeApp.download_and;
                if (TextUtils.isEmpty(this.asg) || TextUtils.isEmpty(this.ash)) {
                    this.asf = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.asg = String.valueOf(this.asg) + ";download_url:" + this.ash + ";web_play_url:" + this.ase;
                } else if (this.mType == 5) {
                    this.asg = String.valueOf(this.asg) + ";download_url:" + this.ash + ";web_play_url:" + this.mText;
                }
                this.asg = String.valueOf(this.asg) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.mText = null;
        this.ase = null;
        this.mType = 0;
        this.mText = str;
        this.ase = str2;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setLink(String str) {
        this.ase = str;
    }

    public String getText() {
        return this.mText;
    }

    public String getLink() {
        return this.ase;
    }

    public int Dw() {
        return this.asf;
    }

    public String Dx() {
        return this.asg;
    }

    public void Dy() {
        if (this.mText != null) {
            this.mText = this.mText.replaceAll("\n", "");
        }
        if (this.ase != null) {
            this.ase = this.ase.replaceAll("\n", "");
        }
    }
}
