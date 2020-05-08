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
    private int eoS;
    private String eoT;
    private String eoU;
    private int eoV;
    private String mLink;
    private String mText;
    private int mType;

    public TbRichTextCommInfo() {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.eoV = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.eoV = 0;
        if (jSONObject != null) {
            this.mText = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.eoV = jSONObject.optInt(ConstantData.Logo.LOGO_JUMP_URL_TPYE, 0);
            this.eoS = jSONObject.optInt("is_native_app", 0);
            if (this.eoS == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.eoS = 0;
                    return;
                }
                this.eoT = jSONObject.optString("jump_and");
                this.eoU = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.eoT) || TextUtils.isEmpty(this.eoU)) {
                    this.eoS = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.eoT += ";download_url:" + this.eoU + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.eoT += ";download_url:" + this.eoU + ";web_play_url:" + this.mText;
                }
                this.eoT += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.eoV = 0;
        if (pbContent != null) {
            this.mText = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.eoV = pbContent.url_type.intValue();
            this.eoS = pbContent.is_native_app.intValue();
            if (this.eoS == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.eoS = 0;
                    return;
                }
                this.eoT = nativeApp.jump_and;
                this.eoU = nativeApp.download_and;
                if (TextUtils.isEmpty(this.eoT) || TextUtils.isEmpty(this.eoU)) {
                    this.eoS = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.eoT += ";download_url:" + this.eoU + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.eoT += ";download_url:" + this.eoU + ";web_play_url:" + this.mText;
                }
                this.eoT += ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.mText = null;
        this.mLink = null;
        this.mType = 0;
        this.eoV = 0;
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

    public int bch() {
        return this.eoS;
    }

    public String bci() {
        return this.eoT;
    }

    public int bcj() {
        return this.eoV;
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
