package com.baidu.tieba.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.mvc.b.e {
    private String threadId = "";
    private String amb = "";
    private String forumName = "";
    private long time = System.currentTimeMillis();
    private String amc = "";
    private boolean amd = false;
    private boolean ame = false;

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
        if (TextUtils.isEmpty(this.amb)) {
            hashCode2 = (hashCode * 7) + 1;
        } else {
            hashCode2 = (hashCode * 7) + this.amb.hashCode();
        }
        if (TextUtils.isEmpty(this.forumName)) {
            hashCode3 = (hashCode2 * 7) + 1;
        } else {
            hashCode3 = (hashCode2 * 7) + this.forumName.hashCode();
        }
        int i = (hashCode3 * 7) + ((int) this.time);
        if (TextUtils.isEmpty(this.amc)) {
            hashCode4 = (i * 7) + 1;
        } else {
            hashCode4 = (i * 7) + this.amc.hashCode();
        }
        return (((this.amd ? 1 : 0) + (hashCode4 * 7)) * 7) + (this.ame ? 1 : 0);
    }

    public boolean f(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("forum_name");
            String string2 = jSONObject.getString("thread_id");
            String string3 = jSONObject.getString("thread_name");
            long j = jSONObject.getLong(PbActivityConfig.KEY_THREAD_TIME);
            this.amc = jSONObject.optString("post_id");
            this.amd = jSONObject.optBoolean(PbActivityConfig.KEY_HOST_ONLY);
            this.ame = jSONObject.optBoolean(PbActivityConfig.KEY_SQUENCE);
            if (!TextUtils.isEmpty(string)) {
                this.forumName = string;
            }
            if (!TextUtils.isEmpty(string2)) {
                this.threadId = string2;
            }
            if (!TextUtils.isEmpty(string3)) {
                this.amb = string3;
            }
            if (j > 2000) {
                this.time = j;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public JSONObject zV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("thread_id", this.threadId);
            jSONObject.put(PbActivityConfig.KEY_THREAD_TIME, this.time);
            jSONObject.put("thread_name", this.amb);
            jSONObject.put("post_id", this.amc);
            jSONObject.put(PbActivityConfig.KEY_HOST_ONLY, this.amd);
            jSONObject.put(PbActivityConfig.KEY_SQUENCE, this.ame);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public String zW() {
        return this.amb;
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
        this.amb = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String zX() {
        return this.amc;
    }

    public void ey(String str) {
        this.amc = str;
    }

    public boolean zY() {
        return this.amd;
    }

    public void bt(boolean z) {
        this.amd = z;
    }

    public boolean zZ() {
        return this.ame;
    }

    public void bu(boolean z) {
        this.ame = z;
    }

    @Override // com.baidu.tbadk.mvc.b.c
    public String getCacheKey() {
        return this.threadId;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String tp() {
        return zV().toString();
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
