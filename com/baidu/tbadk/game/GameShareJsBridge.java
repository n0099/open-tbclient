package com.baidu.tbadk.game;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GameShareJsBridge {
    private static GameShareJsBridge g_instance = null;
    private String mGameId;
    private String mIconUrl;
    private String mShareContent;
    private String mShareContentUrl;
    private String mShareImage;
    private String mShareName;
    private String mShareTitle;

    public static GameShareJsBridge getInstance() {
        if (g_instance == null) {
            g_instance = new GameShareJsBridge();
        }
        return g_instance;
    }

    public String getGameId() {
        return this.mGameId;
    }

    public String getShareName() {
        return this.mShareName;
    }

    public String getShareImage() {
        return this.mShareImage;
    }

    public String getShareContent() {
        return this.mShareContent;
    }

    public String getShareTitle() {
        return this.mShareTitle;
    }

    public String getShareContentUrl() {
        return this.mShareContentUrl;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void set_share_info(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mShareTitle = String.valueOf(jSONObject.opt("title"));
            this.mShareContent = String.valueOf(jSONObject.opt("content"));
            this.mIconUrl = String.valueOf(jSONObject.opt("app_icon"));
            this.mShareContentUrl = String.valueOf(jSONObject.opt("app_link"));
            this.mShareImage = String.valueOf(jSONObject.opt("img"));
            this.mShareName = String.valueOf(jSONObject.opt("app_name"));
            this.mGameId = String.valueOf(jSONObject.opt("app_key"));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void startShare() {
        this.mShareContent = null;
        this.mShareTitle = null;
        this.mShareContentUrl = null;
        this.mIconUrl = null;
        this.mGameId = null;
        this.mShareImage = null;
        this.mShareName = null;
    }
}
