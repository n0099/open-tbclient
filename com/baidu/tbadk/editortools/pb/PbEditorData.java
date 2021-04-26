package com.baidu.tbadk.editortools.pb;

import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class PbEditorData implements Serializable {
    public static final int TYPE_PB = 0;
    public static final int TYPE_SUB_PB = 1;
    public String mContent;
    public String mDisableVoiceMessage;
    public int mEditorType = 0;
    public String mSubPbReplyPrefix;
    public ThreadData mThreadData;
    public VoiceData$VoiceModel mVoiceModel;
    public WriteImagesInfo mWriteImagesInfo;
    public boolean openVoiceRecordButton;

    /* loaded from: classes3.dex */
    public static class ThreadData implements Serializable {
        public long authorId;
        public String authorName;
        public String authorNameShow;
        public String firstDir;
        public String forumId;
        public String forumName;
        public boolean isBJH;
        public String mThreadId;
        public String postId;
        public String secondDir;

        public long getAuthorId() {
            return this.authorId;
        }

        public String getAuthorName() {
            return this.authorName;
        }

        public String getAuthorNameShow() {
            return this.authorNameShow;
        }

        public String getFirstDir() {
            return this.firstDir;
        }

        public String getForumId() {
            return this.forumId;
        }

        public String getForumName() {
            return this.forumName;
        }

        public String getPostId() {
            return this.postId;
        }

        public String getSecondDir() {
            return this.secondDir;
        }

        public String getThreadId() {
            return this.mThreadId;
        }

        public void setAuthorId(long j) {
            this.authorId = j;
        }

        public void setAuthorName(String str) {
            this.authorName = str;
        }

        public void setAuthorNameShow(String str) {
            this.authorNameShow = str;
        }

        public void setFirstDir(String str) {
            this.firstDir = str;
        }

        public void setForumId(String str) {
            this.forumId = str;
        }

        public void setForumName(String str) {
            this.forumName = str;
        }

        public void setPostId(String str) {
            this.postId = str;
        }

        public void setSecondDir(String str) {
            this.secondDir = str;
        }

        public void setThreadId(String str) {
            this.mThreadId = str;
        }
    }

    public String getContent() {
        return this.mContent;
    }

    public String getDisableVoiceMessage() {
        return this.mDisableVoiceMessage;
    }

    public int getEditorType() {
        return this.mEditorType;
    }

    public String getSubPbReplyPrefix() {
        return this.mSubPbReplyPrefix;
    }

    public ThreadData getThreadData() {
        return this.mThreadData;
    }

    public VoiceData$VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.mWriteImagesInfo;
    }

    public boolean isOpenVoiceRecordButton() {
        return this.openVoiceRecordButton;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setDisableVoiceMessage(String str) {
        this.mDisableVoiceMessage = str;
    }

    public void setEditorType(int i2) {
        this.mEditorType = i2;
    }

    public void setOpenVoiceRecordButton(boolean z) {
        this.openVoiceRecordButton = z;
    }

    public void setSubPbReplyPrefix(String str) {
        this.mSubPbReplyPrefix = str;
    }

    public void setThreadData(ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void setVoiceModel(VoiceData$VoiceModel voiceData$VoiceModel) {
        this.mVoiceModel = voiceData$VoiceModel;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.mWriteImagesInfo = writeImagesInfo;
    }
}
