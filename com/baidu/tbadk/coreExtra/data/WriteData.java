package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.google.gson.Gson;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WriteData extends OrmObject implements Serializable {
    public static final String CALL_FROM_ONE = "1";
    public static final String CALL_FROM_OTHER = "0";
    public static final String CALL_FROM_TWO = "2";
    public static final int NEW = 0;
    public static final int NEW_DRUFTING_BOTTLE = 7;
    public static final int NEW_EVALUATION = 11;
    public static final int NEW_PHOTO_LIVE = 4;
    public static final int NEW_RECORD = 10;
    public static final int NEW_TEXT = 9;
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
    private String callFrom;
    private boolean canNoForum;
    private String comment_head;
    private String contentString;
    private int entranceType;
    private FrsTabInfoData frsTabInfoData;
    private boolean isAd;
    private boolean isBJHPost;
    private boolean isBabaoPosted;
    private boolean isEvaluate;
    public boolean isForumBusinessAccount;
    private int isGeneralTab;
    private boolean isLinkThread;
    private boolean isPrivacy;
    private boolean isShareThread;
    private boolean isToDynamic;
    private boolean isUserFeedback;
    private String item_id;
    private String linkUrl;
    private String linkUrlCode;
    private String mAuthSid;
    private BaijiahaoData mBaijiahaoData;
    private long mBarrageTime;
    private int mBigEmtionCount;
    private int mCategoryFrom;
    private int mCategoryTo;
    private String mContent;
    private int mDuringTime;
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mEvaluationStar;
    private String mFirstDir;
    private String mFloor;
    private int mFloorNum;
    private String mForumId;
    private String mForumName;
    private String mFromForumId;
    private boolean mHasLocationData;
    private boolean mHaveDraft;
    private boolean mIsAddition;
    private boolean mIsBarrage;
    private boolean mIsFrsReply;
    private boolean mIsGiftPost;
    private boolean mIsInterviewLivew;
    private boolean mIsNoTitle;
    private String mLat;
    private String mLng;
    private String mMemeContSign;
    private String mMemeText;
    private BaijiahaoData mOriBaijiahaoData;
    private String mOtherComment;
    private int mOtherGrade;
    private boolean mPostLatLng;
    private String mRecommendExt;
    private String mReplyUid;
    private String mRepostId;
    private String mReturnVoiceMd5;
    private String mSecondDir;
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
    private transient SpanGroupManager mSpanGroupManager;
    private String mSpanGroupString;
    private String mSubPbReplyPrefix;
    private int mTabId;
    private String mTabName;
    private int mTakePhotoNum;
    private String mTaskId;
    private String mThreadId;
    private String mTitle;
    private String mTopicId;
    private int mType;
    private String mUniversityComment;
    private String mUniversityGrade;
    private String mUniversitySubjectComment;
    private String mUniversitySubjectContent;
    private String mUniversitySubjectGrade;
    private String mVcode;
    private VcodeExtra mVcodeExtra;
    private String mVcodeMD5;
    private String mVcodeType;
    private String mVcodeUrl;
    private String mVideoId;
    private VideoInfo mVideoInfo;
    private int mVideoReviewType;
    private String mVoiceMd5;
    private VoiceData.VoiceModel mVoiceModel;
    WriteVoteData mWriteVoteData;
    private String mZhongcePrefix;
    private String originalThreadId;
    private String originalVideoCover;
    private String originalVideoTitle;
    private String postPrefix;
    private int proZone;
    public String sourceFrom;
    private long startPublishTime;
    private int statisticFrom;
    private String transmitForumData;
    private String vForumId;
    private String vForumName;
    private WriteImagesInfo writeImagesInfo;

    public boolean isBabaoPosted() {
        return this.isBabaoPosted;
    }

    public void setBabaoPosted(boolean z) {
        this.isBabaoPosted = z;
    }

    public void startPublish() {
        this.startPublishTime = System.currentTimeMillis();
    }

    public long startPublishTime() {
        return this.startPublishTime;
    }

    public void setFrsTabInfoData(FrsTabInfoData frsTabInfoData) {
        this.frsTabInfoData = frsTabInfoData;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        return this.frsTabInfoData;
    }

    public void setIsEvaluate(boolean z) {
        this.isEvaluate = z;
    }

    public boolean isEvaluate() {
        return this.isEvaluate;
    }

    public void setIsBJHPost(boolean z) {
        this.isBJHPost = z;
    }

    public boolean isBJHPost() {
        return this.isBJHPost;
    }

    public void setPostPrefix(String str) {
        this.postPrefix = str;
    }

    public String getPostPrefix() {
        return this.postPrefix;
    }

    public void setMemeContSign(String str) {
        this.mMemeContSign = str;
    }

    public String getMemeContSign() {
        return this.mMemeContSign;
    }

    public void setMemeText(String str) {
        this.mMemeText = str;
    }

    public String getMemeText() {
        return this.mMemeText;
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
        this.item_id = "";
        this.proZone = -1;
        this.isUserFeedback = false;
        this.mCategoryFrom = -1;
        this.mCategoryTo = -1;
        this.mVideoReviewType = 0;
        this.callFrom = "2";
        this.mBigEmtionCount = 0;
        this.isLinkThread = false;
        this.mPostLatLng = false;
        this.mType = 0;
        this.mForumId = null;
        this.mForumName = null;
        this.mFirstDir = "";
        this.mSecondDir = "";
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
        this.isPrivacy = false;
        this.isToDynamic = false;
        this.isShareThread = false;
        this.originalThreadId = "";
        this.mTakePhotoNum = 0;
        this.entranceType = 0;
        this.mUniversityGrade = "";
        this.mUniversitySubjectContent = "";
        this.mUniversitySubjectGrade = "";
        this.mUniversityComment = "";
        this.mUniversitySubjectComment = "";
        this.mOtherGrade = 0;
        this.mOtherComment = "";
    }

    public WriteData(int i) {
        this.mShareImageType = SHARE_SDK_NET_IMAGE;
        this.item_id = "";
        this.proZone = -1;
        this.isUserFeedback = false;
        this.mCategoryFrom = -1;
        this.mCategoryTo = -1;
        this.mVideoReviewType = 0;
        this.callFrom = "2";
        this.mBigEmtionCount = 0;
        this.isLinkThread = false;
        this.mPostLatLng = false;
        this.mType = i;
        this.mTitle = null;
        this.mContent = null;
        this.mReplyUid = null;
    }

    public boolean hasContentToSave() {
        if (com.baidu.adp.lib.util.k.isEmpty(this.mContent) && com.baidu.adp.lib.util.k.isEmpty(this.mTitle)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.mVideoInfo == null || !this.mVideoInfo.isAvaliable()) {
                    return !(this.mVoiceModel == null || this.mVoiceModel.voiceId == null || this.mVoiceModel.duration == -1) || this.mCategoryTo >= 0;
                }
                return true;
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
            this.contentString = this.mSpanGroupManager == null ? this.mContent : this.mSpanGroupManager.byD();
            jSONObject.put("mContent", this.contentString);
            jSONObject.put("mReplyUid", this.mReplyUid);
            jSONObject.put("mThreadId", this.mThreadId);
            jSONObject.put("mIsInterviewLive", this.mIsInterviewLivew);
            jSONObject.put("mCategoryTo", this.mCategoryTo);
            if (this.mVideoInfo != null) {
                jSONObject.put("new_video_info", VideoInfo.jsonWithObject(this.mVideoInfo));
            } else if (this.writeImagesInfo != null) {
                jSONObject.put("writeImagesInfo", this.writeImagesInfo.toJson());
            }
            if (this.mVoiceModel != null) {
                jSONObject.put("mVoiceModel", VoiceData.VoiceModel.jsonWithObject(this.mVoiceModel));
            }
            if (this.mTaskId != null) {
                jSONObject.put("mTaskId", this.mTaskId);
            }
            jSONObject.put("is_barrage", this.mIsBarrage);
            jSONObject.put("barrage_time", this.mBarrageTime);
            jSONObject.put("big_count", this.mBigEmtionCount);
            jSONObject.put(VideoPlayActivityConfig.SOURCE_FROM, this.sourceFrom);
            jSONObject.put(EditVideoActivityConfig.KEY_PRO_ZONE, this.proZone);
            jSONObject.put("topic_id", this.mTopicId);
            jSONObject.put("sub_pb_reply_prefix", this.mSubPbReplyPrefix);
            jSONObject.put("mUniversityGrade", this.mUniversityGrade);
            jSONObject.put("mUniversitySubjectContent", this.mUniversitySubjectContent);
            jSONObject.put("mUniversitySubjectGrade", this.mUniversitySubjectGrade);
            jSONObject.put("mUniversityComment", this.mUniversityComment);
            jSONObject.put("mUniversitySubjectComment", this.mUniversitySubjectComment);
            jSONObject.put("other_grade", this.mOtherGrade);
            jSONObject.put("other_comment", this.mOtherComment);
            if (this.mEvaluateItemInfo != null) {
                jSONObject.put("item_info", new Gson().toJson(this.mEvaluateItemInfo));
                jSONObject.put("evaluation_star", this.mEvaluationStar);
            }
            jSONObject.put(IntentConfig.IS_EVALUATE, this.isEvaluate);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    public static WriteData fromDraftString(String str) {
        if (com.baidu.adp.lib.util.k.isEmpty(str)) {
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
            JSONObject optJSONObject = jSONObject.optJSONObject("new_video_info");
            if (optJSONObject != null) {
                writeData.mVideoInfo = (VideoInfo) VideoInfo.objectWithJson(optJSONObject, VideoInfo.class);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mVoiceModel");
            if (optJSONObject2 != null) {
                writeData.mVoiceModel = (VoiceData.VoiceModel) VoiceData.VoiceModel.objectWithJson(optJSONObject2, VoiceData.VoiceModel.class);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("writeImagesInfo");
            if (optJSONObject3 != null) {
                writeData.writeImagesInfo = new WriteImagesInfo();
                writeData.writeImagesInfo.parseJson(optJSONObject3);
            }
            writeData.mIsBarrage = jSONObject.optBoolean("is_barrage");
            writeData.mBarrageTime = jSONObject.optLong("barrage_time");
            writeData.mBigEmtionCount = jSONObject.optInt("big_count");
            writeData.sourceFrom = jSONObject.optString(VideoPlayActivityConfig.SOURCE_FROM);
            writeData.proZone = jSONObject.optInt(EditVideoActivityConfig.KEY_PRO_ZONE);
            writeData.mTopicId = jSONObject.optString("topic_id");
            writeData.mSubPbReplyPrefix = jSONObject.optString("sub_pb_reply_prefix");
            writeData.mUniversityGrade = jSONObject.optString("mUniversityGrade", "");
            writeData.mUniversitySubjectContent = jSONObject.optString("mUniversitySubjectContent", "");
            writeData.mUniversitySubjectGrade = jSONObject.optString("mUniversitySubjectGrade", "");
            writeData.mUniversityComment = jSONObject.optString("mUniversityComment", "");
            writeData.mUniversitySubjectComment = jSONObject.optString("mUniversitySubjectComment", "");
            writeData.mOtherGrade = jSONObject.optInt("other_grade", 0);
            writeData.mOtherComment = jSONObject.optString("other_comment", "");
            String optString = jSONObject.optString("item_info", "");
            if (!TextUtils.isEmpty(optString)) {
                writeData.mEvaluateItemInfo = (TbRichTextEvaluateItemInfo) new Gson().fromJson(optString, (Class<Object>) TbRichTextEvaluateItemInfo.class);
            }
            writeData.mEvaluationStar = jSONObject.optInt("evaluation_star");
            writeData.isEvaluate = jSONObject.optBoolean(IntentConfig.IS_EVALUATE, false);
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

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public String getFromForumId() {
        return this.mFromForumId;
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

    public void setVideoInfo(VideoInfo videoInfo) {
        this.mVideoInfo = videoInfo;
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int getProZone() {
        return this.proZone;
    }

    public void setProZone(int i) {
        this.proZone = i;
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
                    if (imageFileInfo.isTempFile() && imageFileInfo.isAlreadyUploadedToServer() && !com.baidu.adp.lib.util.k.isEmpty(imageFileInfo.getFilePath())) {
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

    public String getVoteContentForPost() {
        if (this.mWriteVoteData == null) {
            return "";
        }
        String jsonString = this.mWriteVoteData.toJsonString();
        if (StringUtils.isNull(jsonString)) {
            return "";
        }
        return String.format(WriteVoteData.VOTE_CONTENT_PREFIX_FORMAT, URLEncoder.encode(jsonString));
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

    public boolean isUserFeedback() {
        return this.isUserFeedback;
    }

    public void setIsUserFeedback(boolean z) {
        this.isUserFeedback = z;
    }

    public String getTransmitForumData() {
        return this.transmitForumData;
    }

    public void setTransmitForumData(String str) {
        this.transmitForumData = str;
    }

    public boolean isCanNoForum() {
        return this.canNoForum;
    }

    public void setCanNoForum(boolean z) {
        this.canNoForum = z;
    }

    public String getCallFrom() {
        return this.callFrom == null ? "2" : this.callFrom;
    }

    public void setCallFrom(String str) {
        this.callFrom = str;
    }

    public String getVForumId() {
        return this.vForumId;
    }

    public void setVForumId(String str) {
        this.vForumId = str;
    }

    public String getVForumName() {
        return this.vForumName;
    }

    public void setVForumName(String str) {
        this.vForumName = str;
    }

    public void setRecommendExt(String str) {
        this.mRecommendExt = str;
    }

    public String getRecommendExt() {
        return this.mRecommendExt;
    }

    public int getmBigEmtionCount() {
        return this.mBigEmtionCount;
    }

    public void setmBigEmtionCount(int i) {
        this.mBigEmtionCount = i;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public String getLinkUrlCode() {
        return this.linkUrlCode;
    }

    public void setLinkUrlCode(String str) {
        this.linkUrlCode = str;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void setIsLinkThread(boolean z) {
        this.isLinkThread = z;
    }

    public String getLat() {
        return this.mLat;
    }

    public void setLat(String str) {
        this.mLat = str;
    }

    public String getLng() {
        return this.mLng;
    }

    public void setLng(String str) {
        this.mLng = str;
    }

    public boolean isPostLatLng() {
        return this.mPostLatLng;
    }

    public void setPostLatLng(boolean z) {
        this.mPostLatLng = z;
    }

    public void setPrivacy(boolean z) {
        this.isPrivacy = z;
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }

    public void setToDynamic(boolean z) {
        this.isToDynamic = z;
    }

    public boolean isToDynamic() {
        return this.isToDynamic;
    }

    public void setIsShareThread(boolean z) {
        this.isShareThread = z;
    }

    public boolean isShareThread() {
        return this.isShareThread;
    }

    public void setOriginalThreadId(String str) {
        this.originalThreadId = str;
    }

    public String getOriginalThreadId() {
        return this.originalThreadId;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    public String getOriginalVideoTitle() {
        return this.originalVideoTitle;
    }

    public void setOriginalVideoTitle(String str) {
        this.originalVideoTitle = str;
    }

    public String getOriginalVideoCover() {
        return this.originalVideoCover;
    }

    public void setOriginalVideoCover(String str) {
        this.originalVideoCover = str;
    }

    public void setTakePhotoNum(int i) {
        this.mTakePhotoNum = i;
    }

    public int getTakePhotoNum() {
        return this.mTakePhotoNum;
    }

    public void setEntranceType(int i) {
        this.entranceType = i;
    }

    public int getEntranceType() {
        return this.entranceType;
    }

    public String getFirstDir() {
        return this.mFirstDir;
    }

    public void setFirstDir(String str) {
        this.mFirstDir = str;
    }

    public String getSecondDir() {
        return this.mSecondDir;
    }

    public void setSecondDir(String str) {
        this.mSecondDir = str;
    }

    public String getAuthSid() {
        return this.mAuthSid;
    }

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String getTopicId() {
        return this.mTopicId;
    }

    public void setTopicId(String str) {
        this.mTopicId = str;
    }

    public String getSubPbReplyPrefix() {
        return this.mSubPbReplyPrefix;
    }

    public void setSubPbReplyPrefix(String str) {
        this.mSubPbReplyPrefix = str;
    }

    public String getZhongcePrefix() {
        return this.mZhongcePrefix;
    }

    public void setZhongcePrefix(String str) {
        this.mZhongcePrefix = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahaoData;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public BaijiahaoData getOriBaijiahaoData() {
        return this.mOriBaijiahaoData;
    }

    public void setOriBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mOriBaijiahaoData = baijiahaoData;
    }

    public int getTabId() {
        return this.mTabId;
    }

    public void setTabId(int i) {
        this.mTabId = i;
    }

    public String getTabName() {
        return this.mTabName;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public int getIsGeneralTab() {
        return this.isGeneralTab;
    }

    public void setIsGeneralTab(int i) {
        this.isGeneralTab = i;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String str) {
        if (TextUtils.isEmpty(str)) {
            this.item_id = "";
        } else {
            this.item_id = str;
        }
    }

    public String getComment_head() {
        return this.comment_head;
    }

    public void setComment_head(String str) {
        this.comment_head = str;
    }

    public WriteVoteData getWriteVoteData() {
        return this.mWriteVoteData;
    }

    public void setWriteVoteData(WriteVoteData writeVoteData) {
        this.mWriteVoteData = writeVoteData;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void setmUniversityGrade(String str) {
        this.mUniversityGrade = str;
    }

    public void setmUniversitySubjectContent(String str) {
        this.mUniversitySubjectContent = str;
    }

    public void setmUniversitySubjectGrade(String str) {
        this.mUniversitySubjectGrade = str;
    }

    public void setmUniversityComment(String str) {
        this.mUniversityComment = str;
    }

    public void setmUniversitySubjectComment(String str) {
        this.mUniversitySubjectComment = str;
    }

    public void setOtherGrade(int i) {
        this.mOtherGrade = i;
    }

    public void setOtherComment(String str) {
        this.mOtherComment = str;
    }

    public String getmUniversityGrade() {
        return this.mUniversityGrade;
    }

    public String getmUniversitySubjectContent() {
        return this.mUniversitySubjectContent;
    }

    public String getmUniversitySubjectGrade() {
        return this.mUniversitySubjectGrade;
    }

    public String getmUniversityComment() {
        return this.mUniversityComment;
    }

    public String getmUniversitySubjectComment() {
        return this.mUniversitySubjectComment;
    }

    public int getOtherGrade() {
        return this.mOtherGrade;
    }

    public String getOtherComment() {
        return this.mOtherComment;
    }

    public String getSpanGroupString() {
        return this.mSpanGroupString;
    }

    public void setSpanGroupString(String str) {
        this.mSpanGroupString = str;
    }

    public void setIsForumBusinessAccount(boolean z) {
        this.isForumBusinessAccount = z;
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (tbRichTextEvaluateItemInfo != null) {
            this.item_id = tbRichTextEvaluateItemInfo.getItemID();
        }
    }

    public TbRichTextEvaluateItemInfo getItemInfo() {
        return this.mEvaluateItemInfo;
    }

    public void setEvaluationStar(int i) {
        this.mEvaluationStar = i;
    }

    public int getEvaluationStar() {
        return this.mEvaluationStar;
    }

    public void setStatisticFrom(int i) {
        this.statisticFrom = i;
    }

    public int getStatisticFrom() {
        return this.statisticFrom;
    }

    public String getContentString() {
        return this.contentString;
    }
}
