package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.bg;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MarkData implements Serializable {
    private static final long serialVersionUID = 2647743141824773827L;
    private String mAccount;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;
    private String mId = null;
    private int mFloor = 0;
    private long mTime = 0;
    private String mTitle = null;
    private boolean mSequence = true;
    private boolean mHostMode = false;
    private String mAuthorName = null;
    private int mReplyNum = 0;
    private int mSubPost = 0;
    private int mNewCounts = 0;

    public String getAuthorName() {
        return this.mAuthorName;
    }

    public void setAuthorName(String str) {
        this.mAuthorName = str;
    }

    public int getReplyNum() {
        return this.mReplyNum;
    }

    public void setReplyNum(int i) {
        this.mReplyNum = i;
    }

    public void setSubPost(int i) {
        this.mSubPost = i;
    }

    public int getSubPost() {
        return this.mSubPost;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int getFloor() {
        return this.mFloor;
    }

    public void setFloor(int i) {
        this.mFloor = i;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setSequence(Boolean bool) {
        this.mSequence = bool.booleanValue();
    }

    public Boolean getSequence() {
        return Boolean.valueOf(this.mSequence);
    }

    public void setHostMode(boolean z) {
        this.mHostMode = z;
    }

    public boolean getHostMode() {
        return this.mHostMode;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public String getPostId() {
        return this.mPostId;
    }

    public void logPrint() {
        bg.d("MarkData", "logPrint", "mId = " + this.mId);
        bg.d("MarkData", "logPrint", "mAccount = " + this.mAccount);
        bg.d("MarkData", "logPrint", "mFloor = " + String.valueOf(this.mFloor));
        bg.d("MarkData", "logPrint", "mTime = " + String.valueOf(this.mTime));
        bg.d("MarkData", "logPrint", "mSequence = " + String.valueOf(this.mSequence));
        bg.d("MarkData", "logPrint", "mHostMode = " + String.valueOf(this.mHostMode));
        bg.d("MarkData", "logPrint", "mTitle = " + this.mTitle);
        bg.d("MarkData", "logPrint", "mPostId = " + this.mPostId);
        bg.d("MarkData", "logPrint", "mAuthorName = " + this.mAuthorName);
        bg.d("MarkData", "logPrint", "mFloorNum = " + String.valueOf(this.mReplyNum));
    }

    public void setAccount(String str) {
        this.mAccount = str;
    }

    public String getAccount() {
        return this.mAccount;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public int getNewCounts() {
        return this.mNewCounts;
    }

    public void setNewCounts(int i) {
        this.mNewCounts = i;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.mThreadId);
            jSONObject.put("pid", this.mPostId);
            if (this.mHostMode) {
                jSONObject.put("status", SocialConstants.TRUE);
            } else if (!this.mSequence) {
                jSONObject.put("status", "2");
            } else {
                jSONObject.put("status", SocialConstants.FALSE);
            }
            return jSONObject;
        } catch (Exception e) {
            bg.b(getClass().getName(), "toJson", e.toString());
            return null;
        }
    }

    public void paserJson(JSONObject jSONObject) {
        try {
            this.mThreadId = jSONObject.optString("thread_id");
            this.mPostId = jSONObject.optString("mark_pid");
            this.mForumName = jSONObject.optString("forum_name");
            this.mTitle = jSONObject.optString("title");
            this.mAuthorName = jSONObject.optJSONObject("author").optString("name_show");
            this.mId = this.mThreadId;
            this.mReplyNum = jSONObject.optInt("reply_num");
            this.mNewCounts = jSONObject.optInt("count");
            int optInt = jSONObject.optInt("mark_status");
            if (optInt == 1) {
                this.mHostMode = true;
            } else if (optInt == 2) {
                this.mSequence = false;
            }
        } catch (Exception e) {
            bg.b(getClass().getName(), "fromJson", e.toString());
        }
    }
}
