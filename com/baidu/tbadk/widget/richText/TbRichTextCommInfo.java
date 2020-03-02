package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.data.ConstantData;
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
    private int dOp;
    private String dOq;
    private String dOr;
    private int dOs;
    private String mLink;
    private String mText;
    private int mType;

    public TbRichTextCommInfo() {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.dOs = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.dOs = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.dOs = jSONObject.optInt(ConstantData.Logo.LOGO_JUMP_URL_TPYE, 0);
            this.dOp = jSONObject.optInt("is_native_app", 0);
            if (this.dOp == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.dOp = 0;
                    return;
                }
                this.dOq = jSONObject.optString("jump_and");
                this.dOr = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.dOq) || TextUtils.isEmpty(this.dOr)) {
                    this.dOp = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.dOq += ";download_url:" + this.dOr + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.dOq += ";download_url:" + this.dOr + ";web_play_url:" + this.mText;
                }
                this.dOq += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.dOs = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.dOs = pbContent.url_type.intValue();
            this.dOp = pbContent.is_native_app.intValue();
            if (this.dOp == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.dOp = 0;
                    return;
                }
                this.dOq = nativeApp.jump_and;
                this.dOr = nativeApp.download_and;
                if (TextUtils.isEmpty(this.dOq) || TextUtils.isEmpty(this.dOr)) {
                    this.dOp = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.dOq += ";download_url:" + this.dOr + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.dOq += ";download_url:" + this.dOr + ";web_play_url:" + this.mText;
                }
                this.dOq += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.dOs = 0;
        this.mText = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.mText;
    }

    public String getLink() {
        return this.mLink;
    }

    public int aTU() {
        return this.dOp;
    }

    public String aTV() {
        return this.dOq;
    }

    public int aTW() {
        return this.dOs;
    }

    public void trim() {
        if (this.mText != null) {
            this.mText = this.mText.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
