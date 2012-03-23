package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import java.io.Serializable;
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

    public String getAuthorName() {
        return this.mAuthorName;
    }

    public void setAuthorName(String authorName) {
        this.mAuthorName = authorName;
    }

    public int getReplyNum() {
        return this.mReplyNum;
    }

    public void setReplyNum(int replyNum) {
        this.mReplyNum = replyNum;
    }

    public void setSubPost(int subPost) {
        this.mSubPost = subPost;
    }

    public int getSubPost() {
        return this.mSubPost;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public int getFloor() {
        return this.mFloor;
    }

    public void setFloor(int floor) {
        this.mFloor = floor;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setTime(long time) {
        this.mTime = time;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setSequence(Boolean sequence) {
        this.mSequence = sequence.booleanValue();
    }

    public Boolean getSequence() {
        return Boolean.valueOf(this.mSequence);
    }

    public void setHostMode(boolean hostMode) {
        this.mHostMode = hostMode;
    }

    public boolean getHostMode() {
        return this.mHostMode;
    }

    public void setPostId(String postId) {
        this.mPostId = postId;
    }

    public String getPostId() {
        return this.mPostId;
    }

    public void logPrint() {
        TiebaLog.v("MarkData", "logPrint", "mId = " + this.mId);
        TiebaLog.v("MarkData", "logPrint", "mAccount = " + this.mAccount);
        TiebaLog.v("MarkData", "logPrint", "mFloor = " + String.valueOf(this.mFloor));
        TiebaLog.v("MarkData", "logPrint", "mTime = " + String.valueOf(this.mTime));
        TiebaLog.v("MarkData", "logPrint", "mSequence = " + String.valueOf(this.mSequence));
        TiebaLog.v("MarkData", "logPrint", "mHostMode = " + String.valueOf(this.mHostMode));
        TiebaLog.v("MarkData", "logPrint", "mTitle = " + this.mTitle);
        TiebaLog.v("MarkData", "logPrint", "mPostId = " + this.mPostId);
        TiebaLog.v("MarkData", "logPrint", "mAuthorName = " + this.mAuthorName);
        TiebaLog.v("MarkData", "logPrint", "mFloorNum = " + String.valueOf(this.mReplyNum));
    }

    public void setAccount(String account) {
        this.mAccount = account;
    }

    public String getAccount() {
        return this.mAccount;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumId(String forumId) {
        this.mForumId = forumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setForumName(String forumName) {
        this.mForumName = forumName;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public void setThreadId(String threadId) {
        this.mThreadId = threadId;
    }
}
