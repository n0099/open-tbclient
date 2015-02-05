package com.baidu.tieba.data;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bf;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private String atA;
    private String tid = null;
    private String Rf = null;
    private String title = null;
    private boolean atC = false;
    private long time = 0;
    private final UserData atB = new UserData();
    private String content = null;
    private boolean atD = true;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.tid = jSONObject.optString("tid");
                this.title = jSONObject.optString("title");
                this.Rf = jSONObject.optString("pid");
                this.atC = jSONObject.optInt("is_floor", 0) != 0;
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.atB.parserJson(jSONObject.optJSONObject("author"));
                this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                this.atA = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.title = bf.a(this.title, (Color) null);
                String a = bf.a(this.content, (Color) null);
                if (!a.equals(this.content)) {
                    this.content = a;
                    this.atD = false;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
