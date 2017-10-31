package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextCommInfo extends OrmObject {
    public static final int NATIVE_APP_TYPE = 1;
    public static final int TYPE_LINK = 1;
    public static final int TYPE_VIDEO = 5;
    public static final int URL_VALIDITY_INVALID = 1;
    public static final int URL_VALIDITY_NORMAL = 0;
    public static final int URL_VALIDITY_VALID = 2;
    private int aRE;
    private String aRF;
    private String aRG;
    private int aRH;
    private String aeM;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.aeM = null;
        this.mLink = null;
        this.mType = 0;
        this.aRH = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.aeM = null;
        this.mLink = null;
        this.mType = 0;
        this.aRH = 0;
        if (jSONObject != null) {
            this.aeM = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aRH = jSONObject.optInt("url_type", 0);
            this.aRE = jSONObject.optInt("is_native_app", 0);
            if (this.aRE == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aRE = 0;
                    return;
                }
                this.aRF = jSONObject.optString("jump_and");
                this.aRG = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aRF) || TextUtils.isEmpty(this.aRG)) {
                    this.aRE = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aRF += ";download_url:" + this.aRG + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aRF += ";download_url:" + this.aRG + ";web_play_url:" + this.aeM;
                }
                this.aRF += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.aeM = null;
        this.mLink = null;
        this.mType = 0;
        this.aRH = 0;
        if (pbContent != null) {
            this.aeM = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aRH = pbContent.url_type.intValue();
            this.aRE = pbContent.is_native_app.intValue();
            if (this.aRE == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aRE = 0;
                    return;
                }
                this.aRF = nativeApp.jump_and;
                this.aRG = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aRF) || TextUtils.isEmpty(this.aRG)) {
                    this.aRE = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aRF += ";download_url:" + this.aRG + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aRF += ";download_url:" + this.aRG + ";web_play_url:" + this.aeM;
                }
                this.aRF += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.aeM = null;
        this.mLink = null;
        this.mType = 0;
        this.aRH = 0;
        this.aeM = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.aeM = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.aeM;
    }

    public String getLink() {
        return this.mLink;
    }

    public int IJ() {
        return this.aRE;
    }

    public String IK() {
        return this.aRF;
    }

    public int IL() {
        return this.aRH;
    }

    public void IM() {
        if (this.aeM != null) {
            this.aeM = this.aeM.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
