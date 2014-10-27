package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private ak akV;
    private ArrayList<g> akW;
    private Context mContext;
    private String akU = null;
    private String imageUrl = null;
    private String abG = null;
    private String abH = null;
    private int width = 0;
    private int height = 0;
    private String akX = null;
    private String akY = null;
    private String userName = null;
    private String akZ = null;
    private int index = -1;

    public v(Context context) {
        this.akV = null;
        this.akW = null;
        this.mContext = null;
        this.mContext = context;
        this.akV = new ak();
        this.akW = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String zq() {
        return this.akU;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIndex() {
        return this.index;
    }

    public String vJ() {
        return this.abH;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.akX = jSONObject.optString("post_id");
            this.userName = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
            this.akZ = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_ID);
            this.akY = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.akU = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString(ImageViewerConfig.URL);
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.abG = optJSONObject.optString("cdn_src", "");
                if (this.abG == null || this.abG.length() == 0) {
                    this.abG = this.imageUrl;
                }
                this.abH = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    g gVar = new g();
                    gVar.parserJson(optJSONArray.optJSONObject(i));
                    this.akW.add(gVar);
                }
            }
            this.akV.setContent(this.akW);
            if (this.mContext != null) {
                this.akV.P(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
