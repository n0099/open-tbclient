package com.baidu.tieba.data;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ay;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private String ala;
    private String tid = null;
    private String Lh = null;
    private String title = null;
    private boolean amr = false;
    private long time = 0;
    private final UserData amq = new UserData();
    private String content = null;
    private boolean ams = true;

    public boolean Ap() {
        return this.ams;
    }

    public String getPid() {
        return this.Lh;
    }

    public String getTid() {
        return this.tid;
    }

    public String Aq() {
        return this.ala;
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
                this.Lh = jSONObject.optString("pid");
                this.amr = jSONObject.optInt("is_floor", 0) != 0;
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.amq.parserJson(jSONObject.optJSONObject("author"));
                this.content = jSONObject.optString("content");
                this.ala = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.title = ay.a(this.title, (Color) null);
                String a = ay.a(this.content, (Color) null);
                if (!a.equals(this.content)) {
                    this.content = a;
                    this.ams = false;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
