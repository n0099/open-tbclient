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
    private int aMV;
    private String aMW;
    private String aMX;
    private int aMY;
    private String adw;
    private String mLink;
    private int mType;

    public TbRichTextCommInfo() {
        this.adw = null;
        this.mLink = null;
        this.mType = 0;
        this.aMY = 0;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        this.adw = null;
        this.mLink = null;
        this.mType = 0;
        this.aMY = 0;
        if (jSONObject != null) {
            this.adw = jSONObject.optString("text");
            this.mLink = jSONObject.optString("link");
            this.mType = jSONObject.optInt("type", 0);
            this.aMY = jSONObject.optInt("url_type", 0);
            this.aMV = jSONObject.optInt("is_native_app", 0);
            if (this.aMV == 1) {
                if (jSONObject.optJSONObject("native_app") == null) {
                    this.aMV = 0;
                    return;
                }
                this.aMW = jSONObject.optString("jump_and");
                this.aMX = jSONObject.optString("download_and");
                if (TextUtils.isEmpty(this.aMW) || TextUtils.isEmpty(this.aMX)) {
                    this.aMV = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aMW = String.valueOf(this.aMW) + ";download_url:" + this.aMX + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aMW = String.valueOf(this.aMW) + ";download_url:" + this.aMX + ";web_play_url:" + this.adw;
                }
                this.aMW = String.valueOf(this.aMW) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        this.adw = null;
        this.mLink = null;
        this.mType = 0;
        this.aMY = 0;
        if (pbContent != null) {
            this.adw = pbContent.text;
            this.mLink = pbContent.link;
            this.mType = pbContent.type.intValue();
            this.aMY = pbContent.url_type.intValue();
            this.aMV = pbContent.is_native_app.intValue();
            if (this.aMV == 1) {
                NativeApp nativeApp = pbContent.native_app;
                if (nativeApp == null) {
                    this.aMV = 0;
                    return;
                }
                this.aMW = nativeApp.jump_and;
                this.aMX = nativeApp.download_and;
                if (TextUtils.isEmpty(this.aMW) || TextUtils.isEmpty(this.aMX)) {
                    this.aMV = 0;
                    return;
                }
                if (this.mType == 1) {
                    this.aMW = String.valueOf(this.aMW) + ";download_url:" + this.aMX + ";web_play_url:" + this.mLink;
                } else if (this.mType == 5) {
                    this.aMW = String.valueOf(this.aMW) + ";download_url:" + this.aMX + ";web_play_url:" + this.adw;
                }
                this.aMW = String.valueOf(this.aMW) + ";is_native_app=1";
            }
        }
    }

    public TbRichTextCommInfo(String str, String str2) {
        this.adw = null;
        this.mLink = null;
        this.mType = 0;
        this.aMY = 0;
        this.adw = str;
        this.mLink = str2;
    }

    public void setText(String str) {
        this.adw = str;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getText() {
        return this.adw;
    }

    public String getLink() {
        return this.mLink;
    }

    public int Hy() {
        return this.aMV;
    }

    public String Hz() {
        return this.aMW;
    }

    public int HA() {
        return this.aMY;
    }

    public void HB() {
        if (this.adw != null) {
            this.adw = this.adw.replaceAll("\n", "");
        }
        if (this.mLink != null) {
            this.mLink = this.mLink.replaceAll("\n", "");
        }
    }
}
