package com.baidu.tbadk.editortools.pb;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PbEditorData implements Serializable {
    public static final int TYPE_PB = 0;
    public static final int TYPE_SUB_PB = 1;
    private String mContent;
    private String mDisableVoiceMessage;
    private int mEditorType = 0;
    private String mSubPbReplyPrefix;
    private ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;
    private WriteImagesInfo mWriteImagesInfo;
    private boolean openVoiceRecordButton;

    public WriteImagesInfo getWriteImagesInfo() {
        return this.mWriteImagesInfo;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.mWriteImagesInfo = writeImagesInfo;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public String getSubPbReplyPrefix() {
        return this.mSubPbReplyPrefix;
    }

    public void setSubPbReplyPrefix(String str) {
        this.mSubPbReplyPrefix = str;
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public ThreadData getThreadData() {
        return this.mThreadData;
    }

    public void setThreadData(ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public boolean isOpenVoiceRecordButton() {
        return this.openVoiceRecordButton;
    }

    public void setOpenVoiceRecordButton(boolean z) {
        this.openVoiceRecordButton = z;
    }

    public int getEditorType() {
        return this.mEditorType;
    }

    public void setEditorType(int i) {
        this.mEditorType = i;
    }

    public String getDisableVoiceMessage() {
        return this.mDisableVoiceMessage;
    }

    public void setDisableVoiceMessage(String str) {
        this.mDisableVoiceMessage = str;
    }

    /* loaded from: classes.dex */
    public static class ThreadData implements Serializable {
        private long authorId;
        private String authorName;
        private String authorNameShow;
        private String firstDir;
        private String forumId;
        private String forumName;
        public boolean isBJH;
        private String mThreadId;
        private String postId;
        private String secondDir;

        public String getAuthorName() {
            return this.authorName;
        }

        public void setAuthorName(String str) {
            this.authorName = str;
        }

        public String getAuthorNameShow() {
            return this.authorNameShow;
        }

        public void setAuthorNameShow(String str) {
            this.authorNameShow = str;
        }

        public long getAuthorId() {
            return this.authorId;
        }

        public void setAuthorId(long j) {
            this.authorId = j;
        }

        public String getPostId() {
            return this.postId;
        }

        public void setPostId(String str) {
            this.postId = str;
        }

        public String getForumId() {
            return this.forumId;
        }

        public void setForumId(String str) {
            this.forumId = str;
        }

        public String getForumName() {
            return this.forumName;
        }

        public void setForumName(String str) {
            this.forumName = str;
        }

        public String getThreadId() {
            return this.mThreadId;
        }

        public void setThreadId(String str) {
            this.mThreadId = str;
        }

        public String getFirstDir() {
            return this.firstDir;
        }

        public void setFirstDir(String str) {
            this.firstDir = str;
        }

        public String getSecondDir() {
            return this.secondDir;
        }

        public void setSecondDir(String str) {
            this.secondDir = str;
        }
    }
}
