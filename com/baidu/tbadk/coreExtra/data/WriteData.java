package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.google.gson.Gson;
import d.b.c.e.p.k;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public String callFrom;
    public boolean canNoForum;
    public String comment_head;
    public String contentString;
    public int entranceType;
    public FrsTabInfoData frsTabInfoData;
    public boolean isAd;
    public boolean isBJHPost;
    public boolean isBabaoPosted;
    public boolean isEvaluate;
    public boolean isForumBusinessAccount;
    public int isGeneralTab;
    public boolean isLinkThread;
    public boolean isPrivacy;
    public boolean isShareThread;
    public boolean isToDynamic;
    public boolean isUserFeedback;
    public String item_id;
    public String linkUrl;
    public String linkUrlCode;
    public String mAuthSid;
    public BaijiahaoData mBaijiahaoData;
    public long mBarrageTime;
    public int mBigEmtionCount;
    public int mCategoryFrom;
    public int mCategoryTo;
    public String mContent;
    public int mDuringTime;
    public TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    public int mEvaluationStar;
    public String mFirstDir;
    public String mFloor;
    public int mFloorNum;
    public String mForumId;
    public String mForumName;
    public String mFromForumId;
    public boolean mHasLocationData;
    public boolean mHaveDraft;
    public boolean mIsAddition;
    public boolean mIsBarrage;
    public boolean mIsFrsReply;
    public boolean mIsGiftPost;
    public boolean mIsInterviewLivew;
    public boolean mIsNoTitle;
    public String mLat;
    public String mLng;
    public String mMemeContSign;
    public String mMemeText;
    public BaijiahaoData mOriBaijiahaoData;
    public String mOtherComment;
    public int mOtherGrade;
    public boolean mPostLatLng;
    public String mRecommendExt;
    public String mReplyUid;
    public String mRepostId;
    public String mReturnVoiceMd5;
    public String mSecondDir;
    public String mShareApiKey;
    public String mShareAppName;
    public int mShareImageType;
    public byte[] mShareLocalImageData;
    public String mShareLocalImageUri;
    public String mShareReferUrl;
    public String mShareSignKey;
    public String mShareSummaryContent;
    public String mShareSummaryImg;
    public int mShareSummaryImgHeight;
    public String mShareSummaryImgType;
    public int mShareSummaryImgWidth;
    public String mShareSummaryTitle;
    public transient SpanGroupManager mSpanGroupManager;
    public String mSpanGroupString;
    public String mSubPbReplyPrefix;
    public int mTabId;
    public String mTabName;
    public int mTakePhotoNum;
    public String mTaskId;
    public String mThreadId;
    public String mTitle;
    public String mTopicId;
    public int mType;
    public String mUniversityComment;
    public String mUniversityGrade;
    public String mUniversitySubjectComment;
    public String mUniversitySubjectContent;
    public String mUniversitySubjectGrade;
    public String mVcode;
    public VcodeExtra mVcodeExtra;
    public String mVcodeMD5;
    public String mVcodeType;
    public String mVcodeUrl;
    public String mVideoId;
    public VideoInfo mVideoInfo;
    public int mVideoReviewType;
    public String mVoiceMd5;
    public VoiceData$VoiceModel mVoiceModel;
    public WriteVoteData mWriteVoteData;
    public String mZhongcePrefix;
    public String originalThreadId;
    public String originalVideoCover;
    public String originalVideoTitle;
    public String postPrefix;
    public int proZone;
    public String sourceFrom;
    public transient long startPublishTime;
    public int statisticFrom;
    public String transmitForumData;
    public String vForumId;
    public String vForumName;
    public WriteImagesInfo writeImagesInfo;

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

    public static WriteData fromDraftString(String str) {
        if (k.isEmpty(str)) {
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
                writeData.mVideoInfo = (VideoInfo) OrmObject.objectWithJson(optJSONObject, VideoInfo.class);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mVoiceModel");
            if (optJSONObject2 != null) {
                writeData.mVoiceModel = (VoiceData$VoiceModel) OrmObject.objectWithJson(optJSONObject2, VoiceData$VoiceModel.class);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("writeImagesInfo");
            if (optJSONObject3 != null) {
                WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                writeData.writeImagesInfo = writeImagesInfo;
                writeImagesInfo.parseJson(optJSONObject3);
            }
            writeData.mIsBarrage = jSONObject.optBoolean("is_barrage");
            writeData.mBarrageTime = jSONObject.optLong("barrage_time");
            writeData.mBigEmtionCount = jSONObject.optInt("big_count");
            writeData.sourceFrom = jSONObject.optString("source_from");
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
            JSONObject optJSONObject4 = jSONObject.optJSONObject("vote_data");
            if (optJSONObject4 != null) {
                WriteVoteData writeVoteData = new WriteVoteData();
                writeVoteData.parseJson(optJSONObject4);
                writeData.mWriteVoteData = writeVoteData;
            }
            return writeData;
        } catch (Exception unused) {
            return null;
        }
    }

    public void deleteUploadedTempImages() {
        try {
            if (isHasImages()) {
                LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
                int i = 0;
                while (i < chosedFiles.size()) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i);
                    if (imageFileInfo.isTempFile() && imageFileInfo.isAlreadyUploadedToServer() && !k.isEmpty(imageFileInfo.getFilePath())) {
                        File file = new File(imageFileInfo.getFilePath());
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    if (imageFileInfo.isAlreadyUploadedToServer()) {
                        chosedFiles.remove(i);
                        i--;
                    }
                    i++;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String getAuthSid() {
        return this.mAuthSid;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahaoData;
    }

    public long getBarrageTime() {
        return this.mBarrageTime;
    }

    public String getCallFrom() {
        String str = this.callFrom;
        return str == null ? "2" : str;
    }

    public int getCategoryFrom() {
        return this.mCategoryFrom;
    }

    public int getCategoryTo() {
        return this.mCategoryTo;
    }

    public String getComment_head() {
        return this.comment_head;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getContentString() {
        return this.contentString;
    }

    public int getEntranceType() {
        return this.entranceType;
    }

    public int getEvaluationStar() {
        return this.mEvaluationStar;
    }

    public String getFirstDir() {
        return this.mFirstDir;
    }

    public String getFloor() {
        return this.mFloor;
    }

    public int getFloorNum() {
        return this.mFloorNum;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        return this.frsTabInfoData;
    }

    public boolean getHaveDraft() {
        return this.mHaveDraft;
    }

    public String getImagesCodeForPost() {
        WriteImagesInfo writeImagesInfo;
        if (isHasImages()) {
            LinkedList linkedList = new LinkedList();
            if (isHasImages() && (writeImagesInfo = this.writeImagesInfo) != null && writeImagesInfo.getChosedFiles() != null) {
                linkedList.addAll(this.writeImagesInfo.getChosedFiles());
            }
            StringBuilder sb = new StringBuilder(linkedList.size() * 50);
            for (int i = 0; i < linkedList.size(); i++) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList.get(i);
                if (imageFileInfo.isAlreadyUploadedToServer()) {
                    sb.append("\n");
                    sb.append(imageFileInfo.getServerImageCode());
                }
            }
            return sb.toString();
        }
        return "";
    }

    public boolean getIsAd() {
        return this.isAd;
    }

    public int getIsGeneralTab() {
        return this.isGeneralTab;
    }

    public TbRichTextEvaluateItemInfo getItemInfo() {
        return this.mEvaluateItemInfo;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public String getLat() {
        return this.mLat;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String getLinkUrlCode() {
        return this.linkUrlCode;
    }

    public String getLng() {
        return this.mLng;
    }

    public String getMemeContSign() {
        return this.mMemeContSign;
    }

    public String getMemeText() {
        return this.mMemeText;
    }

    public BaijiahaoData getOriBaijiahaoData() {
        return this.mOriBaijiahaoData;
    }

    public String getOriginalThreadId() {
        return this.originalThreadId;
    }

    public String getOriginalVideoCover() {
        return this.originalVideoCover;
    }

    public String getOriginalVideoTitle() {
        return this.originalVideoTitle;
    }

    public String getOtherComment() {
        return this.mOtherComment;
    }

    public int getOtherGrade() {
        return this.mOtherGrade;
    }

    public String getPostPrefix() {
        return this.postPrefix;
    }

    public int getProZone() {
        return this.proZone;
    }

    public String getRecommendExt() {
        return this.mRecommendExt;
    }

    public String getReplyId() {
        return this.mReplyUid;
    }

    public String getRepostId() {
        return this.mRepostId;
    }

    public String getReturnVoiceMd5() {
        return this.mReturnVoiceMd5;
    }

    public String getSecondDir() {
        return this.mSecondDir;
    }

    public String getShareApiKey() {
        return this.mShareApiKey;
    }

    public String getShareAppName() {
        return this.mShareAppName;
    }

    public int getShareImageType() {
        return this.mShareImageType;
    }

    public byte[] getShareLocalImageData() {
        return this.mShareLocalImageData;
    }

    public String getShareLocalImageUri() {
        return this.mShareLocalImageUri;
    }

    public String getShareReferUrl() {
        return this.mShareReferUrl;
    }

    public String getShareSignKey() {
        return this.mShareSignKey;
    }

    public String getShareSummaryContent() {
        return this.mShareSummaryContent;
    }

    public String getShareSummaryImg() {
        return this.mShareSummaryImg;
    }

    public int getShareSummaryImgHeight() {
        return this.mShareSummaryImgHeight;
    }

    public String getShareSummaryImgType() {
        return this.mShareSummaryImgType;
    }

    public int getShareSummaryImgWidth() {
        return this.mShareSummaryImgWidth;
    }

    public String getShareSummaryTitle() {
        return this.mShareSummaryTitle;
    }

    public String getSpanGroupString() {
        return this.mSpanGroupString;
    }

    public int getStatisticFrom() {
        return this.statisticFrom;
    }

    public String getSubPbReplyPrefix() {
        return this.mSubPbReplyPrefix;
    }

    public int getTabId() {
        return this.mTabId;
    }

    public String getTabName() {
        return this.mTabName;
    }

    public int getTakePhotoNum() {
        return this.mTakePhotoNum;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getTopicId() {
        return this.mTopicId;
    }

    public String getTransmitForumData() {
        return this.transmitForumData;
    }

    public int getType() {
        return this.mType;
    }

    public String getVForumId() {
        return this.vForumId;
    }

    public String getVForumName() {
        return this.vForumName;
    }

    public String getVcode() {
        return this.mVcode;
    }

    public VcodeExtra getVcodeExtra() {
        return this.mVcodeExtra;
    }

    public String getVcodeMD5() {
        return this.mVcodeMD5;
    }

    public String getVcodeType() {
        return this.mVcodeType;
    }

    public String getVcodeUrl() {
        return this.mVcodeUrl;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public int getVideoReviewType() {
        return this.mVideoReviewType;
    }

    public String getVoice() {
        return this.mVoiceMd5;
    }

    public int getVoiceDuringTime() {
        return this.mDuringTime;
    }

    public VoiceData$VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public String getVoteContentForPost() {
        WriteVoteData writeVoteData = this.mWriteVoteData;
        if (writeVoteData == null) {
            return "";
        }
        String jsonString = writeVoteData.toJsonString();
        return StringUtils.isNull(jsonString) ? "" : String.format(WriteVoteData.VOTE_CONTENT_PREFIX_FORMAT, URLEncoder.encode(jsonString));
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public WriteVoteData getWriteVoteData() {
        return this.mWriteVoteData;
    }

    public String getZhongcePrefix() {
        return this.mZhongcePrefix;
    }

    public int getmBigEmtionCount() {
        return this.mBigEmtionCount;
    }

    public String getmTaskId() {
        return this.mTaskId;
    }

    public String getmUniversityComment() {
        return this.mUniversityComment;
    }

    public String getmUniversityGrade() {
        return this.mUniversityGrade;
    }

    public String getmUniversitySubjectComment() {
        return this.mUniversitySubjectComment;
    }

    public String getmUniversitySubjectContent() {
        return this.mUniversitySubjectContent;
    }

    public String getmUniversitySubjectGrade() {
        return this.mUniversitySubjectGrade;
    }

    public boolean hasContentToSave() {
        if (k.isEmpty(this.mContent) && k.isEmpty(this.mTitle)) {
            WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
            if (writeImagesInfo == null || writeImagesInfo.size() <= 0) {
                VideoInfo videoInfo = this.mVideoInfo;
                if (videoInfo == null || !videoInfo.isAvaliable()) {
                    VoiceData$VoiceModel voiceData$VoiceModel = this.mVoiceModel;
                    return ((voiceData$VoiceModel == null || voiceData$VoiceModel.voiceId == null || voiceData$VoiceModel.duration == -1) && this.mCategoryTo < 0 && this.mWriteVoteData == null) ? false : true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean isAddition() {
        return this.mIsAddition;
    }

    public boolean isBJHPost() {
        return this.isBJHPost;
    }

    public boolean isBabaoPosted() {
        return this.isBabaoPosted;
    }

    public boolean isBarrage() {
        return this.mIsBarrage;
    }

    public boolean isCanNoForum() {
        return this.canNoForum;
    }

    public boolean isEvaluate() {
        return this.isEvaluate;
    }

    public boolean isFrsReply() {
        return this.mIsFrsReply;
    }

    public boolean isGiftPost() {
        return this.mIsGiftPost;
    }

    public boolean isHasImages() {
        WriteImagesInfo writeImagesInfo;
        return (isAddition() ? true : isSubFloor() ^ true) && (writeImagesInfo = this.writeImagesInfo) != null && writeImagesInfo.size() > 0;
    }

    public boolean isHasLocationData() {
        return this.mHasLocationData;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean isNoTitle() {
        return this.mIsNoTitle;
    }

    public boolean isPostLatLng() {
        return this.mPostLatLng;
    }

    public boolean isPrivacy() {
        return this.isPrivacy;
    }

    public boolean isShareThread() {
        return this.isShareThread;
    }

    public boolean isSubFloor() {
        return this.mType == 2;
    }

    public boolean isToDynamic() {
        return this.isToDynamic;
    }

    public boolean isUserFeedback() {
        return this.isUserFeedback;
    }

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public void setBabaoPosted(boolean z) {
        this.isBabaoPosted = z;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setBarrageTime(long j) {
        this.mBarrageTime = j;
    }

    public void setCallFrom(String str) {
        this.callFrom = str;
    }

    public void setCanNoForum(boolean z) {
        this.canNoForum = z;
    }

    public void setCategoryFrom(int i) {
        this.mCategoryFrom = i;
    }

    public void setCategoryTo(int i) {
        this.mCategoryTo = i;
    }

    public void setComment_head(String str) {
        this.comment_head = str;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setEntranceType(int i) {
        this.entranceType = i;
    }

    public void setEvaluationStar(int i) {
        this.mEvaluationStar = i;
    }

    public void setFirstDir(String str) {
        this.mFirstDir = str;
    }

    public void setFloor(String str) {
        this.mFloor = str;
    }

    public void setFloorNum(int i) {
        this.mFloorNum = i;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setFromForumId(String str) {
        this.mFromForumId = str;
    }

    public void setFrsTabInfoData(FrsTabInfoData frsTabInfoData) {
        this.frsTabInfoData = frsTabInfoData;
    }

    public void setHasLocationData(boolean z) {
        this.mHasLocationData = z;
    }

    public void setHaveDraft(boolean z) {
        this.mHaveDraft = z;
    }

    public void setIsAd(boolean z) {
        this.isAd = z;
    }

    public void setIsAddition(boolean z) {
        this.mIsAddition = z;
    }

    public void setIsBJHPost(boolean z) {
        this.isBJHPost = z;
    }

    public void setIsBarrage(boolean z) {
        this.mIsBarrage = z;
    }

    public void setIsEvaluate(boolean z) {
        this.isEvaluate = z;
    }

    public void setIsForumBusinessAccount(boolean z) {
        this.isForumBusinessAccount = z;
    }

    public void setIsFrsReply(boolean z) {
        this.mIsFrsReply = z;
    }

    public void setIsGeneralTab(int i) {
        this.isGeneralTab = i;
    }

    public void setIsGiftPost(boolean z) {
        this.mIsGiftPost = z;
    }

    public void setIsLinkThread(boolean z) {
        this.isLinkThread = z;
    }

    public void setIsNoTitle(boolean z) {
        this.mIsNoTitle = z;
    }

    public void setIsShareThread(boolean z) {
        this.isShareThread = z;
    }

    public void setIsUserFeedback(boolean z) {
        this.isUserFeedback = z;
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (tbRichTextEvaluateItemInfo != null) {
            this.item_id = tbRichTextEvaluateItemInfo.getItemID();
        }
    }

    public void setItem_id(String str) {
        if (TextUtils.isEmpty(str)) {
            this.item_id = "";
        } else {
            this.item_id = str;
        }
    }

    public void setLat(String str) {
        this.mLat = str;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public void setLinkUrlCode(String str) {
        this.linkUrlCode = str;
    }

    public void setLng(String str) {
        this.mLng = str;
    }

    public void setMemeContSign(String str) {
        this.mMemeContSign = str;
    }

    public void setMemeText(String str) {
        this.mMemeText = str;
    }

    public void setOriBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mOriBaijiahaoData = baijiahaoData;
    }

    public void setOriginalThreadId(String str) {
        this.originalThreadId = str;
    }

    public void setOriginalVideoCover(String str) {
        this.originalVideoCover = str;
    }

    public void setOriginalVideoTitle(String str) {
        this.originalVideoTitle = str;
    }

    public void setOtherComment(String str) {
        this.mOtherComment = str;
    }

    public void setOtherGrade(int i) {
        this.mOtherGrade = i;
    }

    public void setPostLatLng(boolean z) {
        this.mPostLatLng = z;
    }

    public void setPostPrefix(String str) {
        this.postPrefix = str;
    }

    public void setPrivacy(boolean z) {
        this.isPrivacy = z;
    }

    public void setProZone(int i) {
        this.proZone = i;
    }

    public void setRecommendExt(String str) {
        this.mRecommendExt = str;
    }

    public void setReplyId(String str) {
        this.mReplyUid = str;
    }

    public void setRepostId(String str) {
        this.mRepostId = str;
    }

    public void setReturnVoiceMd5(String str) {
        this.mReturnVoiceMd5 = str;
    }

    public void setSecondDir(String str) {
        this.mSecondDir = str;
    }

    public void setShareApiKey(String str) {
        this.mShareApiKey = str;
    }

    public void setShareAppName(String str) {
        this.mShareAppName = str;
    }

    public void setShareImageType(int i) {
        this.mShareImageType = i;
    }

    public void setShareLocalImageData(byte[] bArr) {
        this.mShareLocalImageData = bArr;
    }

    public void setShareLocalImageUri(String str) {
        this.mShareLocalImageUri = str;
    }

    public void setShareReferUrl(String str) {
        this.mShareReferUrl = str;
    }

    public void setShareSignKey(String str) {
        this.mShareSignKey = str;
    }

    public void setShareSummaryContent(String str) {
        this.mShareSummaryContent = str;
    }

    public void setShareSummaryImg(String str) {
        this.mShareSummaryImg = str;
    }

    public void setShareSummaryImgHeight(int i) {
        this.mShareSummaryImgHeight = i;
    }

    public void setShareSummaryImgType(String str) {
        this.mShareSummaryImgType = str;
    }

    public void setShareSummaryImgWidth(int i) {
        this.mShareSummaryImgWidth = i;
    }

    public void setShareSummaryTitle(String str) {
        this.mShareSummaryTitle = str;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void setSpanGroupString(String str) {
        this.mSpanGroupString = str;
    }

    public void setStatisticFrom(int i) {
        this.statisticFrom = i;
    }

    public void setSubPbReplyPrefix(String str) {
        this.mSubPbReplyPrefix = str;
    }

    public void setTabId(int i) {
        this.mTabId = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setTakePhotoNum(int i) {
        this.mTakePhotoNum = i;
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setToDynamic(boolean z) {
        this.isToDynamic = z;
    }

    public void setTopicId(String str) {
        this.mTopicId = str;
    }

    public void setTransmitForumData(String str) {
        this.transmitForumData = str;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setVForumId(String str) {
        this.vForumId = str;
    }

    public void setVForumName(String str) {
        this.vForumName = str;
    }

    public void setVcode(String str) {
        this.mVcode = str;
    }

    public void setVcodeExtra(VcodeExtra vcodeExtra) {
        this.mVcodeExtra = vcodeExtra;
    }

    public void setVcodeMD5(String str) {
        this.mVcodeMD5 = str;
    }

    public void setVcodeType(String str) {
        this.mVcodeType = str;
    }

    public void setVcodeUrl(String str) {
        this.mVcodeUrl = str;
    }

    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.mVideoInfo = videoInfo;
    }

    public void setVideoReviewType(int i) {
        this.mVideoReviewType = i;
    }

    public void setVoice(String str) {
        String str2;
        if (str == null || (str2 = this.mVoiceMd5) == null) {
            if (str == null) {
                setReturnVoiceMd5(null);
            }
        } else if (!str.equals(str2)) {
            setReturnVoiceMd5(null);
        }
        this.mVoiceMd5 = str;
    }

    public void setVoiceDuringTime(int i) {
        this.mDuringTime = i;
    }

    public void setVoiceModel(VoiceData$VoiceModel voiceData$VoiceModel) {
        this.mVoiceModel = voiceData$VoiceModel;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.writeImagesInfo = writeImagesInfo;
    }

    public void setWriteVoteData(WriteVoteData writeVoteData) {
        this.mWriteVoteData = writeVoteData;
    }

    public void setZhongcePrefix(String str) {
        this.mZhongcePrefix = str;
    }

    public void setmBigEmtionCount(int i) {
        this.mBigEmtionCount = i;
    }

    public void setmUniversityComment(String str) {
        this.mUniversityComment = str;
    }

    public void setmUniversityGrade(String str) {
        this.mUniversityGrade = str;
    }

    public void setmUniversitySubjectComment(String str) {
        this.mUniversitySubjectComment = str;
    }

    public void setmUniversitySubjectContent(String str) {
        this.mUniversitySubjectContent = str;
    }

    public void setmUniversitySubjectGrade(String str) {
        this.mUniversitySubjectGrade = str;
    }

    public void startPublish() {
        this.startPublishTime = System.currentTimeMillis();
    }

    public long startPublishTime() {
        return this.startPublishTime;
    }

    public String toDraftString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mType", this.mType);
            jSONObject.put("mTitle", this.mTitle);
            String p = this.mSpanGroupManager == null ? this.mContent : this.mSpanGroupManager.p();
            this.contentString = p;
            jSONObject.put("mContent", p);
            jSONObject.put("mReplyUid", this.mReplyUid);
            jSONObject.put("mThreadId", this.mThreadId);
            jSONObject.put("mIsInterviewLive", this.mIsInterviewLivew);
            jSONObject.put("mCategoryTo", this.mCategoryTo);
            if (this.mVideoInfo != null) {
                jSONObject.put(VideoInfo.DRAFT_JSON_NAME, OrmObject.jsonWithObject(this.mVideoInfo));
            } else if (this.writeImagesInfo != null) {
                jSONObject.put("writeImagesInfo", this.writeImagesInfo.toJson());
            }
            if (this.mVoiceModel != null) {
                jSONObject.put("mVoiceModel", OrmObject.jsonWithObject(this.mVoiceModel));
            }
            if (this.mTaskId != null) {
                jSONObject.put("mTaskId", this.mTaskId);
            }
            jSONObject.put("is_barrage", this.mIsBarrage);
            jSONObject.put("barrage_time", this.mBarrageTime);
            jSONObject.put("big_count", this.mBigEmtionCount);
            jSONObject.put("source_from", this.sourceFrom);
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
            jSONObject.put("vote_data", this.mWriteVoteData.toJsonObject());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
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
}
