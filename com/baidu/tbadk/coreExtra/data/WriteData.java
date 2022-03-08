package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.RichContentHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.tbadkCore.writeModel.AsyncPublishStatData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class WriteData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALL_FROM_ONE = "1";
    public static final String CALL_FROM_OTHER = "0";
    public static final String CALL_FROM_TWO = "2";
    public static final int MAX_ITEM_COUNT = 10;
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
    public transient /* synthetic */ FieldHolder $fh;
    public AsyncPublishStatData asyncPublishStatData;
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
    public boolean isLocalChannelDynamic;
    public boolean isPrivacy;
    public boolean isRichTextEditorMode;
    public boolean isShareThread;
    public boolean isToDynamic;
    public boolean isUserFeedback;
    public boolean isWork;
    public boolean isWorkDraft;
    public ArrayList<Long> itemDataIds;
    public ArrayList<ItemData> itemDatas;
    public String item_id;
    public String linkUrl;
    public String linkUrlCode;
    public String mAuthSid;
    public BaijiahaoData mBaijiahaoData;
    public long mBarrageTime;
    public int mBigEmtionCount;
    public int mCategoryFrom;
    public int mCategoryTo;
    public VideoCategoryClassData mClassAndTagData;
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
    public String mLocalChannelTopic;
    public String mMemeContSign;
    public String mMemeText;
    public String mName;
    public BaijiahaoData mOriBaijiahaoData;
    public String mOtherComment;
    public int mOtherGrade;
    public String mPortrait;
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
    public VoiceData.VoiceModel mVoiceModel;
    public WriteVoteData mWriteVoteData;
    public String mZhongcePrefix;
    public String originalThreadId;
    public String originalVideoCover;
    public String originalVideoTitle;
    public String postPrefix;
    public int proZone;
    public List<Object> richContentData;
    public List<Object> richServerContentData;
    public String sourceFrom;
    public long startPublishTime;
    public int statisticFrom;
    public String transmitForumData;
    public String vForumId;
    public String vForumName;
    public WriteImagesInfo writeImagesInfo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(859004758, "Lcom/baidu/tbadk/coreExtra/data/WriteData;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(859004758, "Lcom/baidu/tbadk/coreExtra/data/WriteData;");
        }
    }

    public WriteData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mShareImageType = SHARE_SDK_NET_IMAGE;
        this.item_id = "";
        this.proZone = -1;
        this.isUserFeedback = false;
        this.mCategoryFrom = -1;
        this.mCategoryTo = -1;
        this.mVideoReviewType = 0;
        this.itemDatas = new ArrayList<>();
        this.itemDataIds = new ArrayList<>();
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
        this.isLocalChannelDynamic = false;
        this.mLocalChannelTopic = null;
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
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (m.isEmpty(str)) {
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
                writeData.isLocalChannelDynamic = jSONObject.optBoolean("isLocalChannelDynamic");
                writeData.mLocalChannelTopic = jSONObject.optString("mLocalChannelTopic");
                writeData.mCategoryTo = jSONObject.optInt("mCategoryTo", -1);
                String optString = jSONObject.optString("new_video_info");
                if (!TextUtils.isEmpty(optString)) {
                    writeData.mVideoInfo = (VideoInfo) new Gson().fromJson(optString, (Class<Object>) VideoInfo.class);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("mVoiceModel");
                if (optJSONObject != null) {
                    writeData.mVoiceModel = (VoiceData.VoiceModel) OrmObject.objectWithJson(optJSONObject, VoiceData.VoiceModel.class);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("writeImagesInfo");
                if (optJSONObject2 != null) {
                    WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                    writeData.writeImagesInfo = writeImagesInfo;
                    writeImagesInfo.parseJson(optJSONObject2);
                }
                boolean optBoolean = jSONObject.optBoolean("isRichTextEditorMode", false);
                writeData.isRichTextEditorMode = optBoolean;
                if (optBoolean && (optJSONArray = jSONObject.optJSONArray("richContentData")) != null) {
                    writeData.richContentData = RichContentHelper.toData(optJSONArray);
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
                String optString2 = jSONObject.optString("item_info", "");
                if (!TextUtils.isEmpty(optString2)) {
                    writeData.mEvaluateItemInfo = (TbRichTextEvaluateItemInfo) new Gson().fromJson(optString2, (Class<Object>) TbRichTextEvaluateItemInfo.class);
                }
                writeData.mEvaluationStar = jSONObject.optInt("evaluation_star");
                writeData.isEvaluate = jSONObject.optBoolean(IntentConfig.IS_EVALUATE, false);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("vote_data");
                if (optJSONObject3 != null) {
                    WriteVoteData writeVoteData = new WriteVoteData();
                    writeVoteData.parseJson(optJSONObject3);
                    writeData.mWriteVoteData = writeVoteData;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("items");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        writeData.addItemData((ItemData) new Gson().fromJson(optJSONArray2.getString(i2), (Class<Object>) ItemData.class));
                    }
                }
                return writeData;
            } catch (Exception unused) {
                return null;
            }
        }
        return (WriteData) invokeL.objValue;
    }

    public boolean addItemData(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, itemData)) == null) {
            if (canAddItem() && itemData != null) {
                long j2 = itemData.itemId;
                if (j2 > 0 && ListUtils.getPosition(this.itemDataIds, Long.valueOf(j2)) < 0) {
                    this.itemDatas.add(itemData);
                    this.itemDataIds.add(Long.valueOf(itemData.itemId));
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean canAddItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ListUtils.getCount(this.itemDatas) < 10 : invokeV.booleanValue;
    }

    public void deleteUploadedTempImages() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (isHasImages()) {
                    LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
                    int i2 = 0;
                    while (i2 < chosedFiles.size()) {
                        ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                        if (imageFileInfo.isTempFile() && imageFileInfo.isAlreadyUploadedToServer() && !m.isEmpty(imageFileInfo.getFilePath())) {
                            File file = new File(imageFileInfo.getFilePath());
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                        if (imageFileInfo.isAlreadyUploadedToServer()) {
                            chosedFiles.remove(i2);
                            i2--;
                        }
                        i2++;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public String getAssociatedItemsForPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<ItemData> arrayList = this.itemDatas;
            if (arrayList == null || arrayList.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<ItemData> it = this.itemDatas.iterator();
            while (it.hasNext()) {
                ItemData next = it.next();
                sb.append(String.format(Locale.getDefault(), ItemData.ASSOCIATED_ITEM_DATA_FORMAT, Long.valueOf(next.itemId), next.mTitle));
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public AsyncPublishStatData getAsyncPublishStatData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.asyncPublishStatData : (AsyncPublishStatData) invokeV.objValue;
    }

    public String getAtUidListString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SpanGroupManager spanGroupManager = this.mSpanGroupManager;
            if (spanGroupManager == null || ListUtils.isEmpty(spanGroupManager.w())) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : this.mSpanGroupManager.w()) {
                if (!z) {
                    sb.append(",");
                }
                sb.append(str);
                z = false;
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String getAuthSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAuthSid : (String) invokeV.objValue;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBaijiahaoData : (BaijiahaoData) invokeV.objValue;
    }

    public long getBarrageTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mBarrageTime : invokeV.longValue;
    }

    public String getCallFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.callFrom;
            return str == null ? "2" : str;
        }
        return (String) invokeV.objValue;
    }

    public int getCategoryFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mCategoryFrom : invokeV.intValue;
    }

    public int getCategoryTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mCategoryTo : invokeV.intValue;
    }

    public VideoCategoryClassData getClassAndTagData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mClassAndTagData : (VideoCategoryClassData) invokeV.objValue;
    }

    public String getComment_head() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.comment_head : (String) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mContent : (String) invokeV.objValue;
    }

    public String getContentString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.contentString : (String) invokeV.objValue;
    }

    public int getEntranceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.entranceType : invokeV.intValue;
    }

    public int getEvaluationStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mEvaluationStar : invokeV.intValue;
    }

    public String getFirstDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mFirstDir : (String) invokeV.objValue;
    }

    public String getFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mFloor : (String) invokeV.objValue;
    }

    public int getFloorNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mFloorNum : invokeV.intValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mForumId : (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mForumName : (String) invokeV.objValue;
    }

    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mFromForumId : (String) invokeV.objValue;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.frsTabInfoData : (FrsTabInfoData) invokeV.objValue;
    }

    public boolean getHaveDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mHaveDraft : invokeV.booleanValue;
    }

    public String getImagesCodeForPost() {
        InterceptResult invokeV;
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (isHasImages()) {
                LinkedList linkedList = new LinkedList();
                if (isHasImages() && (writeImagesInfo = this.writeImagesInfo) != null && writeImagesInfo.getChosedFiles() != null) {
                    linkedList.addAll(this.writeImagesInfo.getChosedFiles());
                }
                StringBuilder sb = new StringBuilder(linkedList.size() * 50);
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList.get(i2);
                    if (imageFileInfo.isAlreadyUploadedToServer()) {
                        sb.append(StringUtils.LF);
                        sb.append(imageFileInfo.getServerImageCode());
                    }
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean getIsAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.isAd : invokeV.booleanValue;
    }

    public int getIsGeneralTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.isGeneralTab : invokeV.intValue;
    }

    public ArrayList<Long> getItemDataIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.itemDataIds : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ItemData> getItemDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.itemDatas : (ArrayList) invokeV.objValue;
    }

    public TbRichTextEvaluateItemInfo getItemInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mEvaluateItemInfo : (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public String getItem_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.item_id : (String) invokeV.objValue;
    }

    public String getLat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mLat : (String) invokeV.objValue;
    }

    public String getLinkUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.linkUrl : (String) invokeV.objValue;
    }

    public String getLinkUrlCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.linkUrlCode : (String) invokeV.objValue;
    }

    public String getLng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mLng : (String) invokeV.objValue;
    }

    public String getLocalChannelTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mLocalChannelTopic : (String) invokeV.objValue;
    }

    public String getMemeContSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mMemeContSign : (String) invokeV.objValue;
    }

    public String getMemeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mMemeText : (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public BaijiahaoData getOriBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mOriBaijiahaoData : (BaijiahaoData) invokeV.objValue;
    }

    public String getOriginalThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.originalThreadId : (String) invokeV.objValue;
    }

    public String getOriginalVideoCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.originalVideoCover : (String) invokeV.objValue;
    }

    public String getOriginalVideoTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.originalVideoTitle : (String) invokeV.objValue;
    }

    public String getOtherComment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mOtherComment : (String) invokeV.objValue;
    }

    public int getOtherGrade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mOtherGrade : invokeV.intValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mPortrait : (String) invokeV.objValue;
    }

    public String getPostPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.postPrefix : (String) invokeV.objValue;
    }

    public int getProZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.proZone : invokeV.intValue;
    }

    public String getRecommendExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mRecommendExt : (String) invokeV.objValue;
    }

    public String getReplyId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mReplyUid : (String) invokeV.objValue;
    }

    public String getRepostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mRepostId : (String) invokeV.objValue;
    }

    public String getReturnVoiceMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mReturnVoiceMd5 : (String) invokeV.objValue;
    }

    public List<Object> getRichContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.richContentData : (List) invokeV.objValue;
    }

    public String getSecondDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mSecondDir : (String) invokeV.objValue;
    }

    public List<Object> getServerRichContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.richServerContentData : (List) invokeV.objValue;
    }

    public String getShareApiKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mShareApiKey : (String) invokeV.objValue;
    }

    public String getShareAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mShareAppName : (String) invokeV.objValue;
    }

    public int getShareImageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mShareImageType : invokeV.intValue;
    }

    public byte[] getShareLocalImageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mShareLocalImageData : (byte[]) invokeV.objValue;
    }

    public String getShareLocalImageUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mShareLocalImageUri : (String) invokeV.objValue;
    }

    public String getShareReferUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.mShareReferUrl : (String) invokeV.objValue;
    }

    public String getShareSignKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mShareSignKey : (String) invokeV.objValue;
    }

    public String getShareSummaryContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mShareSummaryContent : (String) invokeV.objValue;
    }

    public String getShareSummaryImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mShareSummaryImg : (String) invokeV.objValue;
    }

    public int getShareSummaryImgHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.mShareSummaryImgHeight : invokeV.intValue;
    }

    public String getShareSummaryImgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.mShareSummaryImgType : (String) invokeV.objValue;
    }

    public int getShareSummaryImgWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.mShareSummaryImgWidth : invokeV.intValue;
    }

    public String getShareSummaryTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mShareSummaryTitle : (String) invokeV.objValue;
    }

    public String getSpanGroupString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.mSpanGroupString : (String) invokeV.objValue;
    }

    public int getStatisticFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.statisticFrom : invokeV.intValue;
    }

    public String getSubPbReplyPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mSubPbReplyPrefix : (String) invokeV.objValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.mTabId : invokeV.intValue;
    }

    public String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mTabName : (String) invokeV.objValue;
    }

    public int getTakePhotoNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.mTakePhotoNum : invokeV.intValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.mThreadId : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.mTopicId : (String) invokeV.objValue;
    }

    public String getTransmitForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.transmitForumData : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.mType : invokeV.intValue;
    }

    public String getVForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.vForumId : (String) invokeV.objValue;
    }

    public String getVForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.vForumName : (String) invokeV.objValue;
    }

    public String getVcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.mVcode : (String) invokeV.objValue;
    }

    public VcodeExtra getVcodeExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.mVcodeExtra : (VcodeExtra) invokeV.objValue;
    }

    public String getVcodeMD5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.mVcodeMD5 : (String) invokeV.objValue;
    }

    public String getVcodeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.mVcodeType : (String) invokeV.objValue;
    }

    public String getVcodeUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.mVcodeUrl : (String) invokeV.objValue;
    }

    public String getVideoId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.mVideoId : (String) invokeV.objValue;
    }

    public VideoInfo getVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.mVideoInfo : (VideoInfo) invokeV.objValue;
    }

    public int getVideoReviewType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.mVideoReviewType : invokeV.intValue;
    }

    public String getVoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.mVoiceMd5 : (String) invokeV.objValue;
    }

    public int getVoiceDuringTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.mDuringTime : invokeV.intValue;
    }

    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.mVoiceModel : (VoiceData.VoiceModel) invokeV.objValue;
    }

    public String getVoteContentForPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            WriteVoteData writeVoteData = this.mWriteVoteData;
            if (writeVoteData == null) {
                return "";
            }
            String jsonString = writeVoteData.toJsonString();
            return com.baidu.adp.lib.util.StringUtils.isNull(jsonString) ? "" : String.format(WriteVoteData.VOTE_CONTENT_PREFIX_FORMAT, URLEncoder.encode(jsonString));
        }
        return (String) invokeV.objValue;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.writeImagesInfo : (WriteImagesInfo) invokeV.objValue;
    }

    public WriteVoteData getWriteVoteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.mWriteVoteData : (WriteVoteData) invokeV.objValue;
    }

    public String getZhongcePrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.mZhongcePrefix : (String) invokeV.objValue;
    }

    public int getmBigEmtionCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.mBigEmtionCount : invokeV.intValue;
    }

    public String getmTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.mTaskId : (String) invokeV.objValue;
    }

    public String getmUniversityComment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.mUniversityComment : (String) invokeV.objValue;
    }

    public String getmUniversityGrade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.mUniversityGrade : (String) invokeV.objValue;
    }

    public String getmUniversitySubjectComment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.mUniversitySubjectComment : (String) invokeV.objValue;
    }

    public String getmUniversitySubjectContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.mUniversitySubjectContent : (String) invokeV.objValue;
    }

    public String getmUniversitySubjectGrade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.mUniversitySubjectGrade : (String) invokeV.objValue;
    }

    public boolean hasContentToSave() {
        InterceptResult invokeV;
        List<Object> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            if ((this.isRichTextEditorMode || m.isEmpty(this.mContent)) && m.isEmpty(this.mTitle)) {
                WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
                if (writeImagesInfo == null || writeImagesInfo.size() <= 0) {
                    if (this.isRichTextEditorMode && (list = this.richContentData) != null) {
                        if (list.size() > 1) {
                            return true;
                        }
                        if (this.richContentData.size() > 0 && (this.richContentData.get(0) instanceof String) && !TextUtils.isEmpty((CharSequence) this.richContentData.get(0))) {
                            return true;
                        }
                    }
                    VideoInfo videoInfo = this.mVideoInfo;
                    if (videoInfo == null || !videoInfo.isAvaliable()) {
                        VoiceData.VoiceModel voiceModel = this.mVoiceModel;
                        return ((voiceModel == null || voiceModel.voiceId == null || voiceModel.duration == -1) && this.mCategoryTo < 0 && this.mWriteVoteData == null && ListUtils.isEmpty(this.itemDatas)) ? false : true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isAddition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.mIsAddition : invokeV.booleanValue;
    }

    public boolean isBJHPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.isBJHPost : invokeV.booleanValue;
    }

    public boolean isBarrage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.mIsBarrage : invokeV.booleanValue;
    }

    public boolean isCanNoForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.canNoForum : invokeV.booleanValue;
    }

    public boolean isEvaluate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.isEvaluate : invokeV.booleanValue;
    }

    public boolean isFrsReply() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.mIsFrsReply : invokeV.booleanValue;
    }

    public boolean isGiftPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.mIsGiftPost : invokeV.booleanValue;
    }

    public boolean isHasImages() {
        InterceptResult invokeV;
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return (isAddition() ? true : isSubFloor() ^ true) && (writeImagesInfo = this.writeImagesInfo) != null && writeImagesInfo.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isHasLocationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.mHasLocationData : invokeV.booleanValue;
    }

    public boolean isLinkThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.isLinkThread : invokeV.booleanValue;
    }

    public boolean isLocalChannelDynamic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.isLocalChannelDynamic : invokeV.booleanValue;
    }

    public boolean isNoTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? this.mIsNoTitle : invokeV.booleanValue;
    }

    public boolean isPostLatLng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) ? this.mPostLatLng : invokeV.booleanValue;
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.isPrivacy : invokeV.booleanValue;
    }

    public boolean isRichTextEditorMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.isRichTextEditorMode : invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.isShareThread : invokeV.booleanValue;
    }

    public boolean isSubFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? this.mType == 2 : invokeV.booleanValue;
    }

    public boolean isToDynamic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.isToDynamic : invokeV.booleanValue;
    }

    public boolean isUserFeedback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.isUserFeedback : invokeV.booleanValue;
    }

    public boolean isWork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.isWork : invokeV.booleanValue;
    }

    public boolean isWorkDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.isWorkDraft : invokeV.booleanValue;
    }

    public void removeItemData(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048703, this, itemData) == null) || itemData == null) {
            return;
        }
        this.itemDatas.remove(itemData);
        this.itemDataIds.remove(Long.valueOf(itemData.itemId));
    }

    public void setAsyncPublishStatData(AsyncPublishStatData asyncPublishStatData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, asyncPublishStatData) == null) {
            this.asyncPublishStatData = asyncPublishStatData;
        }
    }

    public void setAuthSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, str) == null) {
            this.mAuthSid = str;
        }
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, baijiahaoData) == null) {
            this.mBaijiahaoData = baijiahaoData;
        }
    }

    public void setBarrageTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048707, this, j2) == null) {
            this.mBarrageTime = j2;
        }
    }

    public void setCallFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, str) == null) {
            this.callFrom = str;
        }
    }

    public void setCanNoForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048709, this, z) == null) {
            this.canNoForum = z;
        }
    }

    public void setCategoryFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048710, this, i2) == null) {
            this.mCategoryFrom = i2;
        }
    }

    public void setCategoryTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i2) == null) {
            this.mCategoryTo = i2;
        }
    }

    public void setClassAndTagData(VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, videoCategoryClassData) == null) {
            this.mClassAndTagData = videoCategoryClassData;
        }
    }

    public void setComment_head(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, str) == null) {
            this.comment_head = str;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, str) == null) {
            this.mContent = str;
        }
    }

    public void setEntranceType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i2) == null) {
            this.entranceType = i2;
        }
    }

    public void setEvaluationStar(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048716, this, i2) == null) {
            this.mEvaluationStar = i2;
        }
    }

    public void setFirstDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            this.mFirstDir = str;
        }
    }

    public void setFloor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, str) == null) {
            this.mFloor = str;
        }
    }

    public void setFloorNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048719, this, i2) == null) {
            this.mFloorNum = i2;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, str) == null) {
            this.mForumId = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, str) == null) {
            this.mForumName = str;
        }
    }

    public void setFromForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, str) == null) {
            this.mFromForumId = str;
        }
    }

    public void setFrsTabInfoData(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, frsTabInfoData) == null) {
            this.frsTabInfoData = frsTabInfoData;
        }
    }

    public void setHasLocationData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048724, this, z) == null) {
            this.mHasLocationData = z;
        }
    }

    public void setHaveDraft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z) == null) {
            this.mHaveDraft = z;
        }
    }

    public void setIsAd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z) == null) {
            this.isAd = z;
        }
    }

    public void setIsAddition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z) == null) {
            this.mIsAddition = z;
        }
    }

    public void setIsBJHPost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z) == null) {
            this.isBJHPost = z;
        }
    }

    public void setIsBarrage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048729, this, z) == null) {
            this.mIsBarrage = z;
        }
    }

    public void setIsEvaluate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z) == null) {
            this.isEvaluate = z;
        }
    }

    public void setIsForumBusinessAccount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z) == null) {
            this.isForumBusinessAccount = z;
        }
    }

    public void setIsFrsReply(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z) == null) {
            this.mIsFrsReply = z;
        }
    }

    public void setIsGeneralTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048733, this, i2) == null) {
            this.isGeneralTab = i2;
        }
    }

    public void setIsGiftPost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z) == null) {
            this.mIsGiftPost = z;
        }
    }

    public void setIsLinkThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z) == null) {
            this.isLinkThread = z;
        }
    }

    public void setIsNoTitle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z) == null) {
            this.mIsNoTitle = z;
        }
    }

    public void setIsShareThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z) == null) {
            this.isShareThread = z;
        }
    }

    public void setIsUserFeedback(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048738, this, z) == null) {
            this.isUserFeedback = z;
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, tbRichTextEvaluateItemInfo) == null) {
            this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
            if (tbRichTextEvaluateItemInfo != null) {
                this.item_id = tbRichTextEvaluateItemInfo.getItemID();
            }
        }
    }

    public void setItem_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.item_id = "";
            } else {
                this.item_id = str;
            }
        }
    }

    public void setLat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, str) == null) {
            this.mLat = str;
        }
    }

    public void setLinkUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, str) == null) {
            this.linkUrl = str;
        }
    }

    public void setLinkUrlCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            this.linkUrlCode = str;
        }
    }

    public void setLng(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, str) == null) {
            this.mLng = str;
        }
    }

    public void setLocalChannelDynamic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z) == null) {
            this.isLocalChannelDynamic = z;
        }
    }

    public void setLocalChannelTopic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, str) == null) {
            this.mLocalChannelTopic = str;
        }
    }

    public void setMemeContSign(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, str) == null) {
            this.mMemeContSign = str;
        }
    }

    public void setMemeText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, str) == null) {
            this.mMemeText = str;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, str) == null) {
            this.mName = str;
        }
    }

    public void setOriBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, baijiahaoData) == null) {
            this.mOriBaijiahaoData = baijiahaoData;
        }
    }

    public void setOriginalThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, str) == null) {
            this.originalThreadId = str;
        }
    }

    public void setOriginalVideoCover(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, str) == null) {
            this.originalVideoCover = str;
        }
    }

    public void setOriginalVideoTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, str) == null) {
            this.originalVideoTitle = str;
        }
    }

    public void setOtherComment(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, str) == null) {
            this.mOtherComment = str;
        }
    }

    public void setOtherGrade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048755, this, i2) == null) {
            this.mOtherGrade = i2;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, str) == null) {
            this.mPortrait = str;
        }
    }

    public void setPostLatLng(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048757, this, z) == null) {
            this.mPostLatLng = z;
        }
    }

    public void setPostPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            this.postPrefix = str;
        }
    }

    public void setPrivacy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048759, this, z) == null) {
            this.isPrivacy = z;
        }
    }

    public void setProZone(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048760, this, i2) == null) {
            this.proZone = i2;
        }
    }

    public void setRecommendExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, str) == null) {
            this.mRecommendExt = str;
        }
    }

    public void setReplyId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, str) == null) {
            this.mReplyUid = str;
        }
    }

    public void setRepostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, str) == null) {
            this.mRepostId = str;
        }
    }

    public void setReturnVoiceMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, str) == null) {
            this.mReturnVoiceMd5 = str;
        }
    }

    public void setRichContentData(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048765, this, list) == null) {
            this.richContentData = list;
        }
    }

    public void setRichTextEditorMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048766, this, z) == null) {
            this.isRichTextEditorMode = z;
        }
    }

    public void setSecondDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048767, this, str) == null) {
            this.mSecondDir = str;
        }
    }

    public void setServerRichContent(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, list) == null) {
            this.richServerContentData = list;
        }
    }

    public void setShareApiKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048769, this, str) == null) {
            this.mShareApiKey = str;
        }
    }

    public void setShareAppName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, str) == null) {
            this.mShareAppName = str;
        }
    }

    public void setShareImageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048771, this, i2) == null) {
            this.mShareImageType = i2;
        }
    }

    public void setShareLocalImageData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, bArr) == null) {
            this.mShareLocalImageData = bArr;
        }
    }

    public void setShareLocalImageUri(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, str) == null) {
            this.mShareLocalImageUri = str;
        }
    }

    public void setShareReferUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048774, this, str) == null) {
            this.mShareReferUrl = str;
        }
    }

    public void setShareSignKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, str) == null) {
            this.mShareSignKey = str;
        }
    }

    public void setShareSummaryContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048776, this, str) == null) {
            this.mShareSummaryContent = str;
        }
    }

    public void setShareSummaryImg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048777, this, str) == null) {
            this.mShareSummaryImg = str;
        }
    }

    public void setShareSummaryImgHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048778, this, i2) == null) {
            this.mShareSummaryImgHeight = i2;
        }
    }

    public void setShareSummaryImgType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048779, this, str) == null) {
            this.mShareSummaryImgType = str;
        }
    }

    public void setShareSummaryImgWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048780, this, i2) == null) {
            this.mShareSummaryImgWidth = i2;
        }
    }

    public void setShareSummaryTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048781, this, str) == null) {
            this.mShareSummaryTitle = str;
        }
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048782, this, spanGroupManager) == null) {
            this.mSpanGroupManager = spanGroupManager;
        }
    }

    public void setSpanGroupString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048783, this, str) == null) {
            this.mSpanGroupString = str;
        }
    }

    public void setStatisticFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048784, this, i2) == null) {
            this.statisticFrom = i2;
        }
    }

    public void setSubPbReplyPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048785, this, str) == null) {
            this.mSubPbReplyPrefix = str;
        }
    }

    public void setTabId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048786, this, i2) == null) {
            this.mTabId = i2;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048787, this, str) == null) {
            this.mTabName = str;
        }
    }

    public void setTakePhotoNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048788, this, i2) == null) {
            this.mTakePhotoNum = i2;
        }
    }

    public void setTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048789, this, str) == null) {
            this.mTaskId = str;
        }
    }

    public void setThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048790, this, str) == null) {
            this.mThreadId = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, str) == null) {
            this.mTitle = str;
        }
    }

    public void setToDynamic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048792, this, z) == null) {
            this.isToDynamic = z;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, str) == null) {
            this.mTopicId = str;
        }
    }

    public void setTransmitForumData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048794, this, str) == null) {
            this.transmitForumData = str;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048795, this, i2) == null) {
            this.mType = i2;
        }
    }

    public void setVForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048796, this, str) == null) {
            this.vForumId = str;
        }
    }

    public void setVForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048797, this, str) == null) {
            this.vForumName = str;
        }
    }

    public void setVcode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048798, this, str) == null) {
            this.mVcode = str;
        }
    }

    public void setVcodeExtra(VcodeExtra vcodeExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, vcodeExtra) == null) {
            this.mVcodeExtra = vcodeExtra;
        }
    }

    public void setVcodeMD5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, str) == null) {
            this.mVcodeMD5 = str;
        }
    }

    public void setVcodeType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048801, this, str) == null) {
            this.mVcodeType = str;
        }
    }

    public void setVcodeUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048802, this, str) == null) {
            this.mVcodeUrl = str;
        }
    }

    public void setVideoId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, str) == null) {
            this.mVideoId = str;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048804, this, videoInfo) == null) {
            this.mVideoInfo = videoInfo;
        }
    }

    public void setVideoReviewType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048805, this, i2) == null) {
            this.mVideoReviewType = i2;
        }
    }

    public void setVoice(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, str) == null) {
            if (str == null || (str2 = this.mVoiceMd5) == null) {
                if (str == null) {
                    setReturnVoiceMd5(null);
                }
            } else if (!str.equals(str2)) {
                setReturnVoiceMd5(null);
            }
            this.mVoiceMd5 = str;
        }
    }

    public void setVoiceDuringTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048807, this, i2) == null) {
            this.mDuringTime = i2;
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048808, this, voiceModel) == null) {
            this.mVoiceModel = voiceModel;
        }
    }

    public void setWork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048809, this, z) == null) {
            this.isWork = z;
        }
    }

    public void setWorkDraft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048810, this, z) == null) {
            this.isWorkDraft = z;
        }
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, writeImagesInfo) == null) {
            this.writeImagesInfo = writeImagesInfo;
        }
    }

    public void setWriteVoteData(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048812, this, writeVoteData) == null) {
            this.mWriteVoteData = writeVoteData;
        }
    }

    public void setZhongcePrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, str) == null) {
            this.mZhongcePrefix = str;
        }
    }

    public void setmBigEmtionCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048814, this, i2) == null) {
            this.mBigEmtionCount = i2;
        }
    }

    public void setmUniversityComment(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048815, this, str) == null) {
            this.mUniversityComment = str;
        }
    }

    public void setmUniversityGrade(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048816, this, str) == null) {
            this.mUniversityGrade = str;
        }
    }

    public void setmUniversitySubjectComment(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048817, this, str) == null) {
            this.mUniversitySubjectComment = str;
        }
    }

    public void setmUniversitySubjectContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048818, this, str) == null) {
            this.mUniversitySubjectContent = str;
        }
    }

    public void setmUniversitySubjectGrade(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048819, this, str) == null) {
            this.mUniversitySubjectGrade = str;
        }
    }

    public void startPublish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048820, this) == null) {
            this.startPublishTime = System.currentTimeMillis();
        }
    }

    public long startPublishTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048821, this)) == null) ? this.startPublishTime : invokeV.longValue;
    }

    public String toDraftString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048822, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mType", this.mType);
                jSONObject.put("mTitle", this.mTitle);
                String y = this.mSpanGroupManager == null ? this.mContent : this.mSpanGroupManager.y();
                this.contentString = y;
                jSONObject.put("mContent", y);
                jSONObject.put("mReplyUid", this.mReplyUid);
                jSONObject.put("mThreadId", this.mThreadId);
                jSONObject.put("mIsInterviewLive", this.mIsInterviewLivew);
                jSONObject.put("isLocalChannelDynamic", this.isLocalChannelDynamic);
                jSONObject.put("mLocalChannelTopic", this.mLocalChannelTopic);
                jSONObject.put("mCategoryTo", this.mCategoryTo);
                if (this.mVideoInfo != null) {
                    jSONObject.put("new_video_info", new Gson().toJson(this.mVideoInfo));
                } else if (this.writeImagesInfo != null) {
                    jSONObject.put("writeImagesInfo", this.writeImagesInfo.toJson());
                }
                if (this.isRichTextEditorMode) {
                    jSONObject.put("isRichTextEditorMode", true);
                    jSONObject.put("richContentData", RichContentHelper.toJson(this.richContentData));
                } else {
                    jSONObject.put("isRichTextEditorMode", false);
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
                if (this.mWriteVoteData != null) {
                    jSONObject.put("vote_data", this.mWriteVoteData.toJsonObject());
                }
                if (!ListUtils.isEmpty(this.itemDatas)) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<ItemData> it = this.itemDatas.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(new Gson().toJson(it.next()));
                    }
                    jSONObject.put("items", jSONArray);
                }
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public WriteData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mShareImageType = SHARE_SDK_NET_IMAGE;
        this.item_id = "";
        this.proZone = -1;
        this.isUserFeedback = false;
        this.mCategoryFrom = -1;
        this.mCategoryTo = -1;
        this.mVideoReviewType = 0;
        this.itemDatas = new ArrayList<>();
        this.itemDataIds = new ArrayList<>();
        this.callFrom = "2";
        this.mBigEmtionCount = 0;
        this.isLinkThread = false;
        this.mPostLatLng = false;
        this.mType = i2;
        this.mTitle = null;
        this.mContent = null;
        this.mReplyUid = null;
    }
}
