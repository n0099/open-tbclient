package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.b.a.a.i {
    private String YZ;
    private String aBg;
    private int aBh;
    private String aBi;
    private String aBj;
    private int mType;

    public b() {
        this.YZ = null;
        this.aBg = null;
        this.mType = 0;
    }

    public b(JSONObject jSONObject) {
        this.YZ = null;
        this.aBg = null;
        this.mType = 0;
        if (jSONObject != null) {
            this.YZ = jSONObject.optString("text");
            this.aBg = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aBh = jSONObject.optInt("is_native_app", 0);
            if (this.aBh == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aBh = 0;
                    return;
                }
                this.aBi = jSONObject.optString("jump_and");
                this.aBj = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aBi) || TextUtils.isEmpty(this.aBj)) {
                    this.aBh = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aBi = String.valueOf(this.aBi) + ";download_url:" + this.aBj + ";web_play_url:" + this.aBg;
                } else if (this.mType == 5) {
                    this.aBi = String.valueOf(this.aBi) + ";download_url:" + this.aBj + ";web_play_url:" + this.YZ;
                }
                this.aBi = String.valueOf(this.aBi) + ";is_native_app=1";
            }
        }
    }

    public b(PbContent pbContent) {
        this.YZ = null;
        this.aBg = null;
        this.mType = 0;
        if (pbContent != null) {
            this.YZ = pbContent.text;
            this.aBg = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aBh = pbContent.is_native_app.intValue();
            if (this.aBh == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aBh = 0;
                    return;
                }
                this.aBi = nativeApp.jump_and;
                this.aBj = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aBi) || TextUtils.isEmpty(this.aBj)) {
                    this.aBh = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aBi = String.valueOf(this.aBi) + ";download_url:" + this.aBj + ";web_play_url:" + this.aBg;
                } else if (this.mType == 5) {
                    this.aBi = String.valueOf(this.aBi) + ";download_url:" + this.aBj + ";web_play_url:" + this.YZ;
                }
                this.aBi = String.valueOf(this.aBi) + ";is_native_app=1";
            }
        }
    }

    public b(String str, String str2) {
        this.YZ = null;
        this.aBg = null;
        this.mType = 0;
        this.YZ = str;
        this.aBg = str2;
    }

    public void setText(String str) {
        this.YZ = str;
    }

    public void setLink(String str) {
        this.aBg = str;
    }

    public String getText() {
        return this.YZ;
    }

    public String getLink() {
        return this.aBg;
    }

    public int EU() {
        return this.aBh;
    }

    public String EV() {
        return this.aBi;
    }

    public void EW() {
        if (this.YZ != null) {
            this.YZ = this.YZ.replaceAll("\n", "");
        }
        if (this.aBg != null) {
            this.aBg = this.aBg.replaceAll("\n", "");
        }
    }
}
