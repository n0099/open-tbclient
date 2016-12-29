package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WriteData implements Serializable {
    public static final int NEW = 0;
    public static final int NEW_PHOTO_LIVE = 4;
    public static final int NEW_VOTE = 6;
    public static final int REPLY = 1;
    public static final int REPLY_FLOOR = 2;
    public static final int SHARE_SDK = 3;
    public static int SHARE_SDK_LOCAL_IMAGE = 1;
    public static int SHARE_SDK_NET_IMAGE = 0;
    public static final int UPDATE_PHOTO_LIVE = 5;
    public static final int VIDEO_REVIEW_TYPE_DEFAULT = 0;
    public static final int VIDEO_REVIEW_TYPE_NEED = 1;
    public static final int VIDEO_REVIEW_TYPE_NOT_NEED = 2;
    private boolean isAd;
    private boolean isBabaoPosted;
    private long mBarrageTime;
    private int mCategoryFrom;
    private int mCategoryTo;
    private String mContent;
    private int mDuringTime;
    private String mFloor;
    private int mFloorNum;
    private String mForumId;
    private String mForumName;
    private String mGraffitiFileName;
    private String mGraffitiImageId;
    private String mGraffitiWriteCode;
    private boolean mHasLocationData;
    private boolean mHaveDraft;
    private boolean mIsAddition;
    private boolean mIsBarrage;
    private boolean mIsFrsReply;
    private boolean mIsGiftPost;
    private boolean mIsInterviewLivew;
    private boolean mIsNoTitle;
    private String mReplyUid;
    private String mRepostId;
    private String mReturnVoiceMd5;
    private String mShareApiKey;
    private String mShareAppName;
    private int mShareImageType;
    private byte[] mShareLocalImageData;
    private String mShareLocalImageUri;
    private String mShareReferUrl;
    private String mShareSignKey;
    private String mShareSummaryContent;
    private String mShareSummaryImg;
    private int mShareSummaryImgHeight;
    private String mShareSummaryImgType;
    private int mShareSummaryImgWidth;
    private String mShareSummaryTitle;
    private String mTaskId;
    private String mThreadId;
    private String mTitle;
    private int mType;
    private String mVcode;
    private VcodeExtra mVcodeExtra;
    private String mVcodeMD5;
    private String mVcodeType;
    private String mVcodeUrl;
    private VideoInfo mVideoInfo;
    private int mVideoReviewType;
    private String mVoiceMd5;
    private VoteInfo mVoteInfo;
    private WriteImagesInfo writeImagesInfo;

    public boolean isBabaoPosted() {
        return this.isBabaoPosted;
    }

    public void setBabaoPosted(boolean z) {
        this.isBabaoPosted = z;
    }

    public boolean isBarrage() {
        return this.mIsBarrage;
    }

    public void setIsBarrage(boolean z) {
        this.mIsBarrage = z;
    }

    public long getBarrageTime() {
        return this.mBarrageTime;
    }

    public void setBarrageTime(long j) {
        this.mBarrageTime = j;
    }

    public WriteData() {
        this.mShareImageType = SHARE_SDK_NET_IMAGE;
        this.mCategoryFrom = -1;
        this.mCategoryTo = -1;
        this.mVideoReviewType = 0;
        this.mType = 0;
        this.mForumId = null;
        this.mForumName = null;
        this.mThreadId = null;
        this.mFloor = null;
        this.mFloorNum = 0;
        this.mTitle = null;
        this.mContent = null;
        this.mReplyUid = null;
        this.mVcode = null;
        this.mVcodeMD5 = null;
        this.mVcodeUrl = null;
        this.mVoiceMd5 = null;
        this.mHaveDraft = false;
        this.mIsInterviewLivew = false;
        setIsAd(false);
        this.mShareApiKey = null;
        this.mShareAppName = null;
        this.mShareSignKey = null;
        this.mShareSummaryTitle = null;
        this.mShareSummaryContent = null;
        this.mShareSummaryImg = null;
        this.mShareSummaryImgWidth = 0;
        this.mShareSummaryImgHeight = 0;
        this.mShareSummaryImgType = null;
        this.mShareReferUrl = null;
        this.mShareLocalImageData = null;
        this.mIsGiftPost = false;
        this.mIsBarrage = false;
        this.mBarrageTime = 0L;
    }

    public WriteData(int i) {
        this.mShareImageType = SHARE_SDK_NET_IMAGE;
        this.mCategoryFrom = -1;
        this.mCategoryTo = -1;
        this.mVideoReviewType = 0;
        this.mType = i;
        this.mTitle = null;
        this.mContent = null;
        this.mReplyUid = null;
    }

    public boolean hasContentToSave() {
        if (com.baidu.adp.lib.util.j.isEmpty(this.mContent) && com.baidu.adp.lib.util.j.isEmpty(this.mTitle)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mCategoryTo >= 0 || !TextUtils.isEmpty(this.mGraffitiFileName);
            }
            return true;
        }
        return true;
    }

    public String toDraftString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mType", this.mType);
            jSONObject.put("mTitle", this.mTitle);
            jSONObject.put("mContent", this.mContent);
            jSONObject.put("mReplyUid", this.mReplyUid);
            jSONObject.put("mThreadId", this.mThreadId);
            jSONObject.put("mIsInterviewLive", this.mIsInterviewLivew);
            jSONObject.put("mCategoryTo", this.mCategoryTo);
            if (this.writeImagesInfo != null) {
                jSONObject.put("writeImagesInfo", this.writeImagesInfo.toJson());
            }
            if (this.mVideoInfo != null) {
                jSONObject.put(VideoInfo.DRAFT_JSON_NAME, VideoInfo.jsonWithObject(this.mVideoInfo));
            }
            if (this.mTaskId != null) {
                jSONObject.put("mTaskId", this.mTaskId);
            }
            jSONObject.put("mGraffitiFileName", this.mGraffitiFileName);
            jSONObject.put("is_barrage", this.mIsBarrage);
            jSONObject.put("barrage_time", this.mBarrageTime);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    public static WriteData fromDraftString(String str) {
        if (com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            WriteData writeData = new WriteData();
            writeData.mType = jSONObject.optInt("mType");
            writeData.mTitle = jSONObject.optString("mTitle", null);
            writeData.mContent = jSONObject.optString("mContent", null);
            writeData.mReplyUid = jSONObject.optString("mReplyUid", null);
            writeData.mThreadId = jSONObject.optString("mThreadId", null);
            writeData.mIsInterviewLivew = jSONObject.optBoolean("mIsInterviewLive");
            writeData.mCategoryTo = jSONObject.optInt("mCategoryTo", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject(VideoInfo.DRAFT_JSON_NAME);
            if (optJSONObject != null) {
                writeData.mVideoInfo = (VideoInfo) VideoInfo.objectWithJson(optJSONObject, VideoInfo.class);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("writeImagesInfo");
            if (optJSONObject2 != null) {
                writeData.writeImagesInfo = new WriteImagesInfo();
                writeData.writeImagesInfo.parseJson(optJSONObject2);
            }
            writeData.mGraffitiFileName = jSONObject.optString("mGraffitiFileName");
            writeData.mIsBarrage = jSONObject.optBoolean("is_barrage");
            writeData.mBarrageTime = jSONObject.getLong("barrage_time");
            return writeData;
        } catch (Exception e) {
            return null;
        }
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public String getReplyId() {
        return this.mReplyUid;
    }

    public void setReplyId(String str) {
        this.mReplyUid = str;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }

    public String getmTaskId() {
        return this.mTaskId;
    }

    public void setFloor(String str) {
        this.mFloor = str;
    }

    public String getFloor() {
        return this.mFloor;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setFloorNum(int i) {
        this.mFloorNum = i;
    }

    public int getFloorNum() {
        return this.mFloorNum;
    }

    public void setVcode(String str) {
        this.mVcode = str;
    }

    public String getVcode() {
        return this.mVcode;
    }

    public void setVcodeMD5(String str) {
        this.mVcodeMD5 = str;
    }

    public String getVcodeMD5() {
        return this.mVcodeMD5;
    }

    public String getVcodeUrl() {
        return this.mVcodeUrl;
    }

    public void setVcodeUrl(String str) {
        this.mVcodeUrl = str;
    }

    public String getRepostId() {
        return this.mRepostId;
    }

    public void setRepostId(String str) {
        this.mRepostId = str;
    }

    public void setHaveDraft(boolean z) {
        this.mHaveDraft = z;
    }

    public boolean getHaveDraft() {
        return this.mHaveDraft;
    }

    public boolean getIsAd() {
        return this.isAd;
    }

    public void setIsAd(boolean z) {
        this.isAd = z;
    }

    public void setIsInterviewLive(boolean z) {
        this.mIsInterviewLivew = z;
    }

    public boolean getIsInterviewLive() {
        return this.mIsInterviewLivew;
    }

    public void setVoice(String str) {
        if (str != null && this.mVoiceMd5 != null) {
            if (!str.equals(this.mVoiceMd5)) {
                setReturnVoiceMd5(null);
            }
        } else if (str == null) {
            setReturnVoiceMd5(null);
        }
        this.mVoiceMd5 = str;
    }

    public String getVoice() {
        return this.mVoiceMd5;
    }

    public void setVoiceDuringTime(int i) {
        this.mDuringTime = i;
    }

    public int getVoiceDuringTime() {
        return this.mDuringTime;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.writeImagesInfo = writeImagesInfo;
    }

    public String getGraffitiWriteCode() {
        return this.mGraffitiWriteCode;
    }

    public void setGraffitiWriteCode(String str) {
        this.mGraffitiWriteCode = str;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.mVideoInfo = videoInfo;
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public boolean isSubFloor() {
        return this.mType == 2;
    }

    public boolean isHasImages() {
        boolean z;
        if (isAddition()) {
            z = true;
        } else {
            z = !isSubFloor();
        }
        return z && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0;
    }

    public void deleteUploadedTempImages() {
        int i;
        try {
            if (isHasImages()) {
                LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
                int i2 = 0;
                while (i2 < chosedFiles.size()) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (imageFileInfo.isTempFile() && imageFileInfo.isAlreadyUploadedToServer() && !com.baidu.adp.lib.util.j.isEmpty(imageFileInfo.getFilePath())) {
                        File file = new File(imageFileInfo.getFilePath());
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    if (imageFileInfo.isAlreadyUploadedToServer()) {
                        chosedFiles.remove(i2);
                        i = i2 - 1;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getImagesCodeForPost() {
        if (!isHasImages()) {
            return "";
        }
        LinkedList linkedList = new LinkedList();
        if (isHasImages() && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null) {
            linkedList.addAll(this.writeImagesInfo.getChosedFiles());
        }
        StringBuilder sb = new StringBuilder(linkedList.size() * 50);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList.get(i2);
                if (imageFileInfo.isAlreadyUploadedToServer()) {
                    sb.append("\n");
                    sb.append(imageFileInfo.getServerImageCode());
                }
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }

    public boolean isAddition() {
        return this.mIsAddition;
    }

    public void setIsAddition(boolean z) {
        this.mIsAddition = z;
    }

    public boolean isNoTitle() {
        return this.mIsNoTitle;
    }

    public void setIsNoTitle(boolean z) {
        this.mIsNoTitle = z;
    }

    public boolean isFrsReply() {
        return this.mIsFrsReply;
    }

    public void setIsFrsReply(boolean z) {
        this.mIsFrsReply = z;
    }

    public String getReturnVoiceMd5() {
        return this.mReturnVoiceMd5;
    }

    public void setReturnVoiceMd5(String str) {
        this.mReturnVoiceMd5 = str;
    }

    public boolean isHasLocationData() {
        return this.mHasLocationData;
    }

    public void setHasLocationData(boolean z) {
        this.mHasLocationData = z;
    }

    public String getShareApiKey() {
        return this.mShareApiKey;
    }

    public void setShareApiKey(String str) {
        this.mShareApiKey = str;
    }

    public String getShareAppName() {
        return this.mShareAppName;
    }

    public void setShareAppName(String str) {
        this.mShareAppName = str;
    }

    public String getShareSignKey() {
        return this.mShareSignKey;
    }

    public void setShareSignKey(String str) {
        this.mShareSignKey = str;
    }

    public String getShareSummaryTitle() {
        return this.mShareSummaryTitle;
    }

    public void setShareSummaryTitle(String str) {
        this.mShareSummaryTitle = str;
    }

    public String getShareSummaryContent() {
        return this.mShareSummaryContent;
    }

    public void setShareSummaryContent(String str) {
        this.mShareSummaryContent = str;
    }

    public String getShareSummaryImg() {
        return this.mShareSummaryImg;
    }

    public void setShareSummaryImg(String str) {
        this.mShareSummaryImg = str;
    }

    public String getShareReferUrl() {
        return this.mShareReferUrl;
    }

    public void setShareReferUrl(String str) {
        this.mShareReferUrl = str;
    }

    public int getShareSummaryImgWidth() {
        return this.mShareSummaryImgWidth;
    }

    public void setShareSummaryImgWidth(int i) {
        this.mShareSummaryImgWidth = i;
    }

    public int getShareSummaryImgHeight() {
        return this.mShareSummaryImgHeight;
    }

    public void setShareSummaryImgHeight(int i) {
        this.mShareSummaryImgHeight = i;
    }

    public String getShareSummaryImgType() {
        return this.mShareSummaryImgType;
    }

    public void setShareSummaryImgType(String str) {
        this.mShareSummaryImgType = str;
    }

    public void setShareImageType(int i) {
        this.mShareImageType = i;
    }

    public int getShareImageType() {
        return this.mShareImageType;
    }

    public void setShareLocalImageData(byte[] bArr) {
        this.mShareLocalImageData = bArr;
    }

    public byte[] getShareLocalImageData() {
        return this.mShareLocalImageData;
    }

    public void setShareLocalImageUri(String str) {
        this.mShareLocalImageUri = str;
    }

    public String getShareLocalImageUri() {
        return this.mShareLocalImageUri;
    }

    public boolean isGiftPost() {
        return this.mIsGiftPost;
    }

    public void setIsGiftPost(boolean z) {
        this.mIsGiftPost = z;
    }

    public void setVoteInfo(VoteInfo voteInfo) {
        this.mVoteInfo = voteInfo;
    }

    public VoteInfo getVoteInfo() {
        return this.mVoteInfo;
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }

    public String getGraffitiFileName() {
        return this.mGraffitiFileName;
    }

    public int getCategoryFrom() {
        return this.mCategoryFrom;
    }

    public void setCategoryFrom(int i) {
        this.mCategoryFrom = i;
    }

    public int getCategoryTo() {
        return this.mCategoryTo;
    }

    public void setCategoryTo(int i) {
        this.mCategoryTo = i;
    }

    public void setVideoReviewType(int i) {
        this.mVideoReviewType = i;
    }

    public int getVideoReviewType() {
        return this.mVideoReviewType;
    }

    public void setGraffitiImageId(String str) {
        this.mGraffitiImageId = str;
    }

    public String getGraffitiImageId() {
        return this.mGraffitiImageId;
    }

    public VcodeExtra getVcodeExtra() {
        return this.mVcodeExtra;
    }

    public void setVcodeExtra(VcodeExtra vcodeExtra) {
        this.mVcodeExtra = vcodeExtra;
    }

    public void setVcodeType(String str) {
        this.mVcodeType = str;
    }

    public String getVcodeType() {
        return this.mVcodeType;
    }
}
