package com.baidu.tieba.data;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.az;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private String alj;
    private String tid = null;
    private String Li = null;
    private String title = null;
    private boolean amA = false;
    private long time = 0;
    private final UserData amz = new UserData();
    private String content = null;
    private boolean amB = true;

    public boolean Ar() {
        return this.amB;
    }

    public String getPid() {
        return this.Li;
    }

    public String getTid() {
        return this.tid;
    }

    public String As() {
        return this.alj;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public long getTime() {
        return this.time;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.tid = jSONObject.optString("tid");
                this.title = jSONObject.optString("title");
                this.Li = jSONObject.optString("pid");
                this.amA = jSONObject.optInt("is_floor", 0) != 0;
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.amz.parserJson(jSONObject.optJSONObject("author"));
                this.content = jSONObject.optString("content");
                this.alj = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.title = az.a(this.title, (Color) null);
                String a = az.a(this.content, (Color) null);
                if (!a.equals(this.content)) {
                    this.content = a;
                    this.amB = false;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
