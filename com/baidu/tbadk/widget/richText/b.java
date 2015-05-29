package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String atS;
    private int atT;
    private String atU;
    private String atV;
    private String mText;
    private int mType;

    public b() {
        this.mText = null;
        this.atS = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.mText = null;
        this.atS = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.atS = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.atT = jSONObject.optInt("is_native_app", 0);
            if (this.atT == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.atT = 0;
                    return;
                }
                this.atU = jSONObject.optString("jump_and");
                this.atV = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.atU) || TextUtils.isEmpty(this.atV)) {
                    this.atT = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.atU = String.valueOf(this.atU) + ";download_url:" + this.atV + ";web_play_url:" + this.atS;
                } else if (this.mType == 5) {
                    this.atU = String.valueOf(this.atU) + ";download_url:" + this.atV + ";web_play_url:" + this.mText;
                }
                this.atU = String.valueOf(this.atU) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.mText = null;
        this.atS = null;
        this.mType = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.atS = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.atT = pbContent.is_native_app.intValue();
            if (this.atT == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.atT = 0;
                    return;
                }
                this.atU = nativeApp.jump_and;
                this.atV = nativeApp.download_and;
                if (TextUtils.isEmpty(this.atU) || TextUtils.isEmpty(this.atV)) {
                    this.atT = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.atU = String.valueOf(this.atU) + ";download_url:" + this.atV + ";web_play_url:" + this.atS;
                } else if (this.mType == 5) {
                    this.atU = String.valueOf(this.atU) + ";download_url:" + this.atV + ";web_play_url:" + this.mText;
                }
                this.atU = String.valueOf(this.atU) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.mText = null;
        this.atS = null;
        this.mType = 0;
        this.mText = str;
        this.atS = str2;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setLink(String str) {
        this.atS = str;
    }

    public String getText() {
        return this.mText;
    }

    public String getLink() {
        return this.atS;
    }

    public int Em() {
        return this.atT;
    }

    public String En() {
        return this.atU;
    }

    public void Eo() {
        if (this.mText != null) {
            this.mText = this.mText.replaceAll("\n", "");
        }
        if (this.atS != null) {
            this.atS = this.atS.replaceAll("\n", "");
        }
    }
}
