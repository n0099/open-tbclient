package com.baidu.tbadk.game;

import com.alipay.sdk.cons.b;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GameShareJsBridge {
    public static GameShareJsBridge g_instance;
    public String mGameId;
    public String mIconUrl;
    public String mShareContent;
    public String mShareContentUrl;
    public String mShareImage;
    public String mShareName;
    public String mShareTitle;

    public static GameShareJsBridge getInstance() {
        if (g_instance == null) {
            g_instance = new GameShareJsBridge();
        }
        return g_instance;
    }

    public String getGameId() {
        return this.mGameId;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getShareContent() {
        return this.mShareContent;
    }

    public String getShareContentUrl() {
        return this.mShareContentUrl;
    }

    public String getShareImage() {
        return this.mShareImage;
    }

    public String getShareName() {
        return this.mShareName;
    }

    public String getShareTitle() {
        return this.mShareTitle;
    }

    public void set_share_info(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mShareTitle = String.valueOf(jSONObject.opt("title"));
            this.mShareContent = String.valueOf(jSONObject.opt("content"));
            this.mIconUrl = String.valueOf(jSONObject.opt("app_icon"));
            this.mShareContentUrl = String.valueOf(jSONObject.opt("app_link"));
            this.mShareImage = String.valueOf(jSONObject.opt("img"));
            this.mShareName = String.valueOf(jSONObject.opt(DpStatConstants.KEY_APP_NAME));
            this.mGameId = String.valueOf(jSONObject.opt(b.f1883h));
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
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
