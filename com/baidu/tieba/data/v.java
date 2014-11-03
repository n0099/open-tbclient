package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private ak ale;
    private ArrayList<g> alf;
    private Context mContext;
    private String ald = null;
    private String imageUrl = null;
    private String abL = null;
    private String abM = null;
    private int width = 0;
    private int height = 0;
    private String alg = null;
    private String alh = null;
    private String userName = null;
    private String ali = null;
    private int index = -1;

    public v(Context context) {
        this.ale = null;
        this.alf = null;
        this.mContext = null;
        this.mContext = context;
        this.ale = new ak();
        this.alf = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String zs() {
        return this.ald;
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

    public String vL() {
        return this.abM;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.alg = jSONObject.optString("post_id");
            this.userName = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
            this.ali = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_ID);
            this.alh = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.ald = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString(ImageViewerConfig.URL);
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.abL = optJSONObject.optString("cdn_src", "");
                if (this.abL == null || this.abL.length() == 0) {
                    this.abL = this.imageUrl;
                }
                this.abM = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    g gVar = new g();
                    gVar.parserJson(optJSONArray.optJSONObject(i));
                    this.alf.add(gVar);
                }
            }
            this.ale.setContent(this.alf);
            if (this.mContext != null) {
                this.ale.P(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
