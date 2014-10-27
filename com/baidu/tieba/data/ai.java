package com.baidu.tieba.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.mvc.b.e {
    private String threadId = "";
    private String alS = "";
    private String forumName = "";
    private long time = System.currentTimeMillis();
    private String alT = "";
    private boolean alU = false;
    private boolean alV = false;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ai)) {
            return false;
        }
        ai aiVar = (ai) obj;
        return (this.threadId == null || aiVar.threadId == null || !this.threadId.equals(aiVar.threadId)) ? false : true;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        if (TextUtils.isEmpty(this.threadId)) {
            hashCode = 120;
        } else {
            hashCode = this.threadId.hashCode() + 119;
        }
        if (TextUtils.isEmpty(this.alS)) {
            hashCode2 = (hashCode * 7) + 1;
        } else {
            hashCode2 = (hashCode * 7) + this.alS.hashCode();
        }
        if (TextUtils.isEmpty(this.forumName)) {
            hashCode3 = (hashCode2 * 7) + 1;
        } else {
            hashCode3 = (hashCode2 * 7) + this.forumName.hashCode();
        }
        int i = (hashCode3 * 7) + ((int) this.time);
        if (TextUtils.isEmpty(this.alT)) {
            hashCode4 = (i * 7) + 1;
        } else {
            hashCode4 = (i * 7) + this.alT.hashCode();
        }
        return (((this.alU ? 1 : 0) + (hashCode4 * 7)) * 7) + (this.alV ? 1 : 0);
    }

    public boolean f(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("forum_name");
            String string2 = jSONObject.getString("thread_id");
            String string3 = jSONObject.getString("thread_name");
            long j = jSONObject.getLong(PbActivityConfig.KEY_THREAD_TIME);
            this.alT = jSONObject.optString("post_id");
            this.alU = jSONObject.optBoolean(PbActivityConfig.KEY_HOST_ONLY);
            this.alV = jSONObject.optBoolean(PbActivityConfig.KEY_SQUENCE);
            if (!TextUtils.isEmpty(string)) {
                this.forumName = string;
            }
            if (!TextUtils.isEmpty(string2)) {
                this.threadId = string2;
            }
            if (!TextUtils.isEmpty(string3)) {
                this.alS = string3;
            }
            if (j > 2000) {
                this.time = j;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public JSONObject zT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("thread_id", this.threadId);
            jSONObject.put(PbActivityConfig.KEY_THREAD_TIME, this.time);
            jSONObject.put("thread_name", this.alS);
            jSONObject.put("post_id", this.alT);
            jSONObject.put(PbActivityConfig.KEY_HOST_ONLY, this.alU);
            jSONObject.put(PbActivityConfig.KEY_SQUENCE, this.alV);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public String zU() {
        return this.alS;
    }

    public String getForumName() {
        return this.forumName;
    }

    public long getTime() {
        return this.time;
    }

    public void setThreadId(String str) {
        this.threadId = str;
    }

    public void ex(String str) {
        this.alS = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String zV() {
        return this.alT;
    }

    public void ey(String str) {
        this.alT = str;
    }

    public boolean zW() {
        return this.alU;
    }

    public void bt(boolean z) {
        this.alU = z;
    }

    public boolean zX() {
        return this.alV;
    }

    public void bu(boolean z) {
        this.alV = z;
    }

    @Override // com.baidu.tbadk.mvc.b.c
    public String getCacheKey() {
        return this.threadId;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String tn() {
        return zT().toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean dL(String str) {
        if (str != null) {
            try {
                return f(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
