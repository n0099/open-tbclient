package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.RichContentHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.AsyncPublishStatData;
import com.baidu.tieba.ui;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WriteData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALL_FROM_HOME = "8";
    public static final String CALL_FROM_ONE = "1";
    public static final String CALL_FROM_OTHER = "0";
    public static final String CALL_FROM_TWO = "2";
    public static final int DYNAMIC_THREAD = 15;
    public static final int EVALUATION_THREAD = 12;
    public static final int LOCAL_CHANNEL_THREAD = 13;
    public static final int MAX_ITEM_COUNT = 10;
    public static final int NEW_RECORD = 10;
    public static final int NEW_TEXT = 9;
    public static final int QUESTION_THREAD = 14;
    public static final int REPLY = 1;
    public static final int REPLY_FLOOR = 2;
    public static final int RICH_TEXT_THREAD = 11;
    public transient /* synthetic */ FieldHolder $fh;
    public String activeName;
    public String activeTaskName;
    public AsyncPublishStatData asyncPublishStatData;
    public String callFrom;
    public boolean canGoods;
    public boolean canNoForum;
    public String comment_head;
    public int entranceType;
    public boolean fromErrorDialog;
    public FrsTabInfoData frsTabInfoData;
    public String gameId;
    public String gameName;
    public String hintText;
    public ArrayList<AtSelectData> inputInsertAtList;
    public boolean interceptWriteResultDialog;
    public boolean isAd;
    public String isArticle;
    public boolean isBJHPost;
    public boolean isEvaluate;
    public boolean isForumBusinessAccount;
    public boolean isFromGameRank;
    public boolean isFromItemDetail;
    public int isGeneralTab;
    public boolean isLinkThread;
    public boolean isLocalChannelDynamic;
    public boolean isNewWritePage;
    public boolean isPrivacy;
    public boolean isPutStorageTid;
    public boolean isQuestionTagManualCreated;
    public boolean isQuestionThread;
    public boolean isReplyResultNotificationH5;
    public boolean isRichTextEditorMode;
    public boolean isSaveDraft;
    public boolean isShareThread;
    public boolean isToDynamic;
    public boolean isVoiceEnable;
    public boolean isWork;
    public boolean isWorkDraft;
    public ArrayList<Long> itemDataIds;
    public ArrayList<ItemData> itemDatas;
    public String item_id;
    public String linkUrl;
    public String linkUrlCode;
    public String mAtUidListString;
    public String mAuthSid;
    public BaijiahaoData mBaijiahaoData;
    public VideoCategoryClassData mClassAndTagData;
    public String mContent;
    public String mDisableAudioMessage;
    public int mDuringTime;
    public TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    public int mEvaluationStar;
    public String mFirstDir;
    public String mFloor;
    public int mFloorNum;
    public String mForumId;
    public String mForumName;
    public String mFrom;
    public String mFromForumId;
    public boolean mHasLocationData;
    public boolean mHaveDraft;
    public SerializableItemInfo mIntentItemInfo;
    public int mIntentStarCount;
    public boolean mIsAddition;
    public boolean mIsNoTitle;
    public String mLocalChannelTopic;
    public String mMemeContSign;
    public String mMemeText;
    public String mMoreForumImg;
    public String mMoreForumTitle;
    public String mMoreForumUrl;
    public String mName;
    public BaijiahaoData mOriBaijiahaoData;
    public String mPlainTextContent;
    public String mPortrait;
    public PostPrefixData mPrefixData;
    public int mPrivateThread;
    public String mQuestionTagId;
    public String mReSubPostId;
    public String mReplyUid;
    public String mRepostId;
    public String mReturnVoiceMd5;
    public String mSecondDir;
    public boolean mShowBless;
    public boolean mShowCustomFigure;
    public String mSubPbReplyPrefix;
    public int mTabId;
    public String mTabName;
    public int mTakePhotoNum;
    public String mThreadId;
    public String mTitle;
    public String mToServerContent;
    public String mTopicId;
    public int mType;
    public String mVcode;
    public VcodeExtra mVcodeExtra;
    public String mVcodeMD5;
    public String mVcodeType;
    public String mVcodeUrl;
    public String mVideoId;
    public VideoInfo mVideoInfo;
    public String mVoiceMd5;
    public VoiceData.VoiceModel mVoiceModel;
    public WriteVoteData mWriteVoteData;
    public String netImgUrl;
    public boolean notFakePost;
    public boolean notificationH5;
    public String originalThreadId;
    public String originalVideoCover;
    public String originalVideoTitle;
    public String postPrefix;
    public String rewardsType;
    public List<Object> richContentData;
    public List<Object> richServerContentData;
    public String sourceFrom;
    public long startPublishTime;
    public int statisticFrom;
    public String transmitForumData;
    public String vForumId;
    public String vForumName;
    public WriteImagesInfo writeImagesInfo;
    public String xiuxiuOriginalContent;
    public String xiuxiuOriginalFname;

    public WriteData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.item_id = "";
        this.itemDatas = new ArrayList<>();
        this.itemDataIds = new ArrayList<>();
        this.callFrom = "2";
        this.isLinkThread = false;
        this.mFrom = "write";
        this.interceptWriteResultDialog = false;
        this.isPutStorageTid = false;
        this.isReplyResultNotificationH5 = false;
        this.mType = 9;
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
        this.isLocalChannelDynamic = false;
        this.mLocalChannelTopic = null;
        setIsAd(false);
        this.isPrivacy = false;
        this.isToDynamic = false;
        this.isShareThread = false;
        this.originalThreadId = "";
        this.mTakePhotoNum = 0;
        this.entranceType = 0;
    }

    public String getImagesCodeForPost() {
        InterceptResult invokeV;
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (!isHasImages()) {
                return "";
            }
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
        return (String) invokeV.objValue;
    }

    public boolean hasContentToSave() {
        InterceptResult invokeV;
        List<Object> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if ((!this.isRichTextEditorMode && !ui.isEmpty(this.mContent)) || !ui.isEmpty(this.mTitle)) {
                return true;
            }
            WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                return true;
            }
            if (this.isRichTextEditorMode && (list = this.richContentData) != null) {
                if (list.size() > 1) {
                    return true;
                }
                if (this.richContentData.size() > 0 && (this.richContentData.get(0) instanceof String) && !TextUtils.isEmpty((CharSequence) this.richContentData.get(0))) {
                    return true;
                }
            }
            VideoInfo videoInfo = this.mVideoInfo;
            if (videoInfo != null && videoInfo.isAvaliable()) {
                return true;
            }
            VoiceData.VoiceModel voiceModel = this.mVoiceModel;
            if ((voiceModel != null && voiceModel.getVoiceId() != null && this.mVoiceModel.getDuration() != -1) || this.mWriteVoteData != null || !ListUtils.isEmpty(this.itemDatas)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public WriteData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.item_id = "";
        this.itemDatas = new ArrayList<>();
        this.itemDataIds = new ArrayList<>();
        this.callFrom = "2";
        this.isLinkThread = false;
        this.mFrom = "write";
        this.interceptWriteResultDialog = false;
        this.isPutStorageTid = false;
        this.isReplyResultNotificationH5 = false;
        this.mType = i;
        this.mTitle = null;
        this.mContent = null;
        this.mReplyUid = null;
    }

    public void onPostDataParse(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048705, this, spanGroupManager) != null) || spanGroupManager == null) {
            return;
        }
        if (ListUtils.isEmpty(spanGroupManager.y())) {
            this.mAtUidListString = "";
        } else {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : spanGroupManager.y()) {
                if (!z) {
                    sb.append(",");
                }
                sb.append(str);
                z = false;
            }
        }
        this.mToServerContent = spanGroupManager.G();
    }

    public static WriteData fromDraftString(String str) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (ui.isEmpty(str)) {
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
                writeData.isLocalChannelDynamic = jSONObject.optBoolean("isLocalChannelDynamic");
                writeData.mLocalChannelTopic = jSONObject.optString("mLocalChannelTopic");
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
                writeData.sourceFrom = jSONObject.optString("source_from");
                writeData.mTopicId = jSONObject.optString("topic_id");
                writeData.mSubPbReplyPrefix = jSONObject.optString("sub_pb_reply_prefix");
                String optString2 = jSONObject.optString(WriteActivityConfig.ITEM_INFO, "");
                if (!TextUtils.isEmpty(optString2)) {
                    writeData.mEvaluateItemInfo = (TbRichTextEvaluateItemInfo) new Gson().fromJson(optString2, (Class<Object>) TbRichTextEvaluateItemInfo.class);
                }
                writeData.mEvaluationStar = jSONObject.optInt("evaluation_star");
                writeData.isEvaluate = jSONObject.optBoolean(IntentConfig.IS_EVALUATE, false);
                writeData.isQuestionThread = jSONObject.optBoolean("isQuestionThread", false);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("vote_data");
                if (optJSONObject3 != null) {
                    WriteVoteData writeVoteData = new WriteVoteData();
                    writeVoteData.parseJson(optJSONObject3);
                    writeData.mWriteVoteData = writeVoteData;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("items");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        writeData.addItemData((ItemData) new Gson().fromJson(optJSONArray2.getString(i), (Class<Object>) ItemData.class));
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
                long j = itemData.itemId;
                if (j <= 0 || ListUtils.getPosition(this.itemDataIds, Long.valueOf(j)) >= 0) {
                    return false;
                }
                this.itemDatas.add(itemData);
                this.itemDataIds.add(Long.valueOf(itemData.itemId));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setInputInsertAtList(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, arrayList) == null) {
            if (this.inputInsertAtList == null) {
                this.inputInsertAtList = new ArrayList<>();
            }
            if (!ListUtils.isEmpty(this.inputInsertAtList)) {
                this.inputInsertAtList.clear();
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            this.inputInsertAtList.addAll(arrayList);
        }
    }

    public boolean canAddItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.getCount(this.itemDatas) < 10) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getActiveName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.activeName;
        }
        return (String) invokeV.objValue;
    }

    public String getActiveTaskName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.activeTaskName;
        }
        return (String) invokeV.objValue;
    }

    public AsyncPublishStatData getAsyncPublishStatData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.asyncPublishStatData;
        }
        return (AsyncPublishStatData) invokeV.objValue;
    }

    public String getAtUidListString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mAtUidListString;
        }
        return (String) invokeV.objValue;
    }

    public String getAuthSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mAuthSid;
        }
        return (String) invokeV.objValue;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mBaijiahaoData;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public String getCallFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String str = this.callFrom;
            if (str == null) {
                return "2";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public VideoCategoryClassData getClassAndTagData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mClassAndTagData;
        }
        return (VideoCategoryClassData) invokeV.objValue;
    }

    public String getComment_head() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.comment_head;
        }
        return (String) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mContent;
        }
        return (String) invokeV.objValue;
    }

    public String getDisableAudioMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mDisableAudioMessage;
        }
        return (String) invokeV.objValue;
    }

    public int getEntranceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.entranceType;
        }
        return invokeV.intValue;
    }

    public int getEvaluationStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mEvaluationStar;
        }
        return invokeV.intValue;
    }

    public String getFirstDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mFirstDir;
        }
        return (String) invokeV.objValue;
    }

    public String getFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mFloor;
        }
        return (String) invokeV.objValue;
    }

    public int getFloorNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mFloorNum;
        }
        return invokeV.intValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mForumId;
        }
        return (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mForumName;
        }
        return (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mFrom;
        }
        return (String) invokeV.objValue;
    }

    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mFromForumId;
        }
        return (String) invokeV.objValue;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.frsTabInfoData;
        }
        return (FrsTabInfoData) invokeV.objValue;
    }

    public String getGameId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.gameId;
        }
        return (String) invokeV.objValue;
    }

    public String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.gameName;
        }
        return (String) invokeV.objValue;
    }

    public boolean getHaveDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mHaveDraft;
        }
        return invokeV.booleanValue;
    }

    public String getHintText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.hintText;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<AtSelectData> getInputInsertAtList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.inputInsertAtList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public SerializableItemInfo getIntentItemInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mIntentItemInfo;
        }
        return (SerializableItemInfo) invokeV.objValue;
    }

    public int getIntentStarCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mIntentStarCount;
        }
        return invokeV.intValue;
    }

    public boolean getIsAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.isAd;
        }
        return invokeV.booleanValue;
    }

    public String getIsArticle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.isArticle;
        }
        return (String) invokeV.objValue;
    }

    public int getIsGeneralTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.isGeneralTab;
        }
        return invokeV.intValue;
    }

    public ArrayList<Long> getItemDataIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.itemDataIds;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<ItemData> getItemDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.itemDatas;
        }
        return (ArrayList) invokeV.objValue;
    }

    public TbRichTextEvaluateItemInfo getItemInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mEvaluateItemInfo;
        }
        return (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public String getItem_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.item_id;
        }
        return (String) invokeV.objValue;
    }

    public String getLinkUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.linkUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getLinkUrlCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.linkUrlCode;
        }
        return (String) invokeV.objValue;
    }

    public String getLocalChannelTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.mLocalChannelTopic;
        }
        return (String) invokeV.objValue;
    }

    public String getMemeContSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.mMemeContSign;
        }
        return (String) invokeV.objValue;
    }

    public String getMemeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.mMemeText;
        }
        return (String) invokeV.objValue;
    }

    public String getMoreForumImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.mMoreForumImg;
        }
        return (String) invokeV.objValue;
    }

    public String getMoreForumTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.mMoreForumTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getMoreForumUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mMoreForumUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mName;
        }
        return (String) invokeV.objValue;
    }

    public String getNetImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.netImgUrl;
        }
        return (String) invokeV.objValue;
    }

    public BaijiahaoData getOriBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mOriBaijiahaoData;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public String getOriginalThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.originalThreadId;
        }
        return (String) invokeV.objValue;
    }

    public String getOriginalVideoCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.originalVideoCover;
        }
        return (String) invokeV.objValue;
    }

    public String getOriginalVideoTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.originalVideoTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getPlainTextContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.mPlainTextContent;
        }
        return (String) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.mPortrait;
        }
        return (String) invokeV.objValue;
    }

    public String getPostPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.postPrefix;
        }
        return (String) invokeV.objValue;
    }

    public PostPrefixData getPrefixData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.mPrefixData;
        }
        return (PostPrefixData) invokeV.objValue;
    }

    public int getPrivateThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.mPrivateThread;
        }
        return invokeV.intValue;
    }

    @NonNull
    public String getQuestionTagId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            String str = this.mQuestionTagId;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getReSubPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.mReSubPostId;
        }
        return (String) invokeV.objValue;
    }

    public String getReplyId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.mReplyUid;
        }
        return (String) invokeV.objValue;
    }

    public String getRepostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.mRepostId;
        }
        return (String) invokeV.objValue;
    }

    public String getReturnVoiceMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.mReturnVoiceMd5;
        }
        return (String) invokeV.objValue;
    }

    public String getRewardsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.rewardsType;
        }
        return (String) invokeV.objValue;
    }

    public List<Object> getRichContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.richContentData;
        }
        return (List) invokeV.objValue;
    }

    public String getSecondDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.mSecondDir;
        }
        return (String) invokeV.objValue;
    }

    public List<Object> getServerRichContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.richServerContentData;
        }
        return (List) invokeV.objValue;
    }

    public int getStatisticFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.statisticFrom;
        }
        return invokeV.intValue;
    }

    public String getSubPbReplyPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.mSubPbReplyPrefix;
        }
        return (String) invokeV.objValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.mTabId;
        }
        return invokeV.intValue;
    }

    public String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.mTabName;
        }
        return (String) invokeV.objValue;
    }

    public int getTakePhotoNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.mTakePhotoNum;
        }
        return invokeV.intValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.mThreadId;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getToServerContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.mToServerContent;
        }
        return (String) invokeV.objValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.mTopicId;
        }
        return (String) invokeV.objValue;
    }

    public String getTransmitForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.transmitForumData;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    public String getVForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.vForumId;
        }
        return (String) invokeV.objValue;
    }

    public String getVForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.vForumName;
        }
        return (String) invokeV.objValue;
    }

    public String getVcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.mVcode;
        }
        return (String) invokeV.objValue;
    }

    public VcodeExtra getVcodeExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.mVcodeExtra;
        }
        return (VcodeExtra) invokeV.objValue;
    }

    public String getVcodeMD5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.mVcodeMD5;
        }
        return (String) invokeV.objValue;
    }

    public String getVcodeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.mVcodeType;
        }
        return (String) invokeV.objValue;
    }

    public String getVcodeUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.mVcodeUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.mVideoId;
        }
        return (String) invokeV.objValue;
    }

    public VideoInfo getVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.mVideoInfo;
        }
        return (VideoInfo) invokeV.objValue;
    }

    public String getVoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.mVoiceMd5;
        }
        return (String) invokeV.objValue;
    }

    public int getVoiceDuringTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.mDuringTime;
        }
        return invokeV.intValue;
    }

    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.mVoiceModel;
        }
        return (VoiceData.VoiceModel) invokeV.objValue;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.writeImagesInfo;
        }
        return (WriteImagesInfo) invokeV.objValue;
    }

    public WriteVoteData getWriteVoteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.mWriteVoteData;
        }
        return (WriteVoteData) invokeV.objValue;
    }

    public String getXiuxiuOriginalContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.xiuxiuOriginalContent;
        }
        return (String) invokeV.objValue;
    }

    public String getXiuxiuOriginalFname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.xiuxiuOriginalFname;
        }
        return (String) invokeV.objValue;
    }

    public boolean isAddThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            int i = this.mType;
            if (i != 9 && i != 11 && i != 13 && i != 14 && i != 12 && i != 15) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isAddition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.mIsAddition;
        }
        return invokeV.booleanValue;
    }

    public boolean isBJHPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.isBJHPost;
        }
        return invokeV.booleanValue;
    }

    public boolean isCanGoods() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.canGoods;
        }
        return invokeV.booleanValue;
    }

    public boolean isCanNoForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.canNoForum;
        }
        return invokeV.booleanValue;
    }

    public boolean isEvaluate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.isEvaluate;
        }
        return invokeV.booleanValue;
    }

    public boolean isFromErrorDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.fromErrorDialog;
        }
        return invokeV.booleanValue;
    }

    public boolean isFromGameRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.isFromGameRank;
        }
        return invokeV.booleanValue;
    }

    public boolean isFromItemDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.isFromItemDetail;
        }
        return invokeV.booleanValue;
    }

    public boolean isHasImages() {
        InterceptResult invokeV;
        boolean z;
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            if (isAddition()) {
                z = true;
            } else {
                z = !isSubFloor();
            }
            if (z && (writeImagesInfo = this.writeImagesInfo) != null && writeImagesInfo.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHasLocationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.mHasLocationData;
        }
        return invokeV.booleanValue;
    }

    public boolean isInterceptWriteResultDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.interceptWriteResultDialog;
        }
        return invokeV.booleanValue;
    }

    public boolean isLinkThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.isLinkThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isLocalChannelDynamic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.isLocalChannelDynamic;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewWritePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.isNewWritePage;
        }
        return invokeV.booleanValue;
    }

    public boolean isNoTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            return this.mIsNoTitle;
        }
        return invokeV.booleanValue;
    }

    public boolean isNotFakePost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.notFakePost;
        }
        return invokeV.booleanValue;
    }

    public boolean isNotificationH5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.notificationH5;
        }
        return invokeV.booleanValue;
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.isPrivacy;
        }
        return invokeV.booleanValue;
    }

    public boolean isPutStorageTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.isPutStorageTid;
        }
        return invokeV.booleanValue;
    }

    public boolean isQuestionTagManualCreated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.isQuestionTagManualCreated;
        }
        return invokeV.booleanValue;
    }

    public boolean isQuestionThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.isQuestionThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isRichTextEditorMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.isRichTextEditorMode;
        }
        return invokeV.booleanValue;
    }

    public boolean isSaveDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.isSaveDraft;
        }
        return invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.isShareThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowBless() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.mShowBless;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowCustomFigure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.mShowCustomFigure;
        }
        return invokeV.booleanValue;
    }

    public boolean isSubFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            if (this.mType == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isToDynamic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return this.isToDynamic;
        }
        return invokeV.booleanValue;
    }

    public boolean isVoiceEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.isVoiceEnable;
        }
        return invokeV.booleanValue;
    }

    public boolean isWork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.isWork;
        }
        return invokeV.booleanValue;
    }

    public boolean isWorkDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            return this.isWorkDraft;
        }
        return invokeV.booleanValue;
    }

    public void startPublish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048824, this) == null) {
            this.startPublishTime = System.currentTimeMillis();
        }
    }

    public long startPublishTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048825, this)) == null) {
            return this.startPublishTime;
        }
        return invokeV.longValue;
    }

    public void deleteUploadedTempImages() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (isHasImages()) {
                    LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
                    int i = 0;
                    while (i < chosedFiles.size()) {
                        ImageFileInfo imageFileInfo = chosedFiles.get(i);
                        if (imageFileInfo.isTempFile() && imageFileInfo.isAlreadyUploadedToServer() && !ui.isEmpty(imageFileInfo.getFilePath())) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getAssociatedItemsForPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<ItemData> arrayList = this.itemDatas;
            if (arrayList != null && arrayList.size() != 0) {
                StringBuilder sb = new StringBuilder();
                Iterator<ItemData> it = this.itemDatas.iterator();
                while (it.hasNext()) {
                    ItemData next = it.next();
                    sb.append(String.format(Locale.getDefault(), ItemData.ASSOCIATED_ITEM_DATA_FORMAT, Long.valueOf(next.itemId), next.mTitle));
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getVoteContentForPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            WriteVoteData writeVoteData = this.mWriteVoteData;
            if (writeVoteData == null) {
                return "";
            }
            String jsonString = writeVoteData.toJsonString();
            if (StringUtils.isNull(jsonString)) {
                return "";
            }
            return String.format(WriteVoteData.VOTE_CONTENT_PREFIX_FORMAT, URLEncoder.encode(jsonString));
        }
        return (String) invokeV.objValue;
    }

    public void onSaveDrafDataParse(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048706, this, spanGroupManager) != null) || spanGroupManager == null) {
            return;
        }
        this.mPlainTextContent = spanGroupManager.A();
    }

    public void removeItemData(ItemData itemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048707, this, itemData) != null) || itemData == null) {
            return;
        }
        this.itemDatas.remove(itemData);
        this.itemDataIds.remove(Long.valueOf(itemData.itemId));
    }

    public void setActiveName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, str) == null) {
            this.activeName = str;
        }
    }

    public void setActiveTaskName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            this.activeTaskName = str;
        }
    }

    public void setAsyncPublishStatData(AsyncPublishStatData asyncPublishStatData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, asyncPublishStatData) == null) {
            this.asyncPublishStatData = asyncPublishStatData;
        }
    }

    public void setAuthSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, str) == null) {
            this.mAuthSid = str;
        }
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, baijiahaoData) == null) {
            this.mBaijiahaoData = baijiahaoData;
        }
    }

    public void setCallFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, str) == null) {
            this.callFrom = str;
        }
    }

    public void setCanGoods(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048714, this, z) == null) {
            this.canGoods = z;
        }
    }

    public void setCanNoForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048715, this, z) == null) {
            this.canNoForum = z;
        }
    }

    public void setClassAndTagData(VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, videoCategoryClassData) == null) {
            this.mClassAndTagData = videoCategoryClassData;
        }
    }

    public void setComment_head(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            this.comment_head = str;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, str) == null) {
            this.mContent = str;
        }
    }

    public void setDisableAudioMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, str) == null) {
            this.mDisableAudioMessage = str;
        }
    }

    public void setEntranceType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i) == null) {
            this.entranceType = i;
        }
    }

    public void setEvaluationStar(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048721, this, i) == null) {
            this.mEvaluationStar = i;
        }
    }

    public void setFirstDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, str) == null) {
            this.mFirstDir = str;
        }
    }

    public void setFloor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, str) == null) {
            this.mFloor = str;
        }
    }

    public void setFloorNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048724, this, i) == null) {
            this.mFloorNum = i;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, str) == null) {
            this.mForumId = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, str) == null) {
            this.mForumName = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, str) == null) {
            this.mFrom = str;
        }
    }

    public void setFromErrorDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z) == null) {
            this.fromErrorDialog = z;
        }
    }

    public void setFromForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, str) == null) {
            this.mFromForumId = str;
        }
    }

    public void setFromGameRank(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z) == null) {
            this.isFromGameRank = z;
        }
    }

    public void setFromItemDetail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z) == null) {
            this.isFromItemDetail = z;
        }
    }

    public void setFrsTabInfoData(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, frsTabInfoData) == null) {
            this.frsTabInfoData = frsTabInfoData;
        }
    }

    public void setGameId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, str) == null) {
            this.gameId = str;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, str) == null) {
            this.gameName = str;
        }
    }

    public void setHasLocationData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z) == null) {
            this.mHasLocationData = z;
        }
    }

    public void setHaveDraft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z) == null) {
            this.mHaveDraft = z;
        }
    }

    public void setHintText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, str) == null) {
            this.hintText = str;
        }
    }

    public void setIntentItemInfo(SerializableItemInfo serializableItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, serializableItemInfo) == null) {
            this.mIntentItemInfo = serializableItemInfo;
        }
    }

    public void setIntentStarCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048740, this, i) == null) {
            this.mIntentStarCount = i;
        }
    }

    public void setInterceptWriteResultDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048741, this, z) == null) {
            this.interceptWriteResultDialog = z;
        }
    }

    public void setIsAd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z) == null) {
            this.isAd = z;
        }
    }

    public void setIsAddition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z) == null) {
            this.mIsAddition = z;
        }
    }

    public void setIsArticle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, str) == null) {
            this.isArticle = str;
        }
    }

    public void setIsBJHPost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z) == null) {
            this.isBJHPost = z;
        }
    }

    public void setIsEvaluate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z) == null) {
            this.isEvaluate = z;
        }
    }

    public void setIsForumBusinessAccount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048747, this, z) == null) {
            this.isForumBusinessAccount = z;
        }
    }

    public void setIsGeneralTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048748, this, i) == null) {
            this.isGeneralTab = i;
        }
    }

    public void setIsLinkThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z) == null) {
            this.isLinkThread = z;
        }
    }

    public void setIsNoTitle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z) == null) {
            this.mIsNoTitle = z;
        }
    }

    public void setIsShareThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z) == null) {
            this.isShareThread = z;
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, tbRichTextEvaluateItemInfo) == null) {
            this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
            if (tbRichTextEvaluateItemInfo != null) {
                this.item_id = tbRichTextEvaluateItemInfo.getItemID();
            }
        }
    }

    public void setItem_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.item_id = "";
            } else {
                this.item_id = str;
            }
        }
    }

    public void setLinkUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, str) == null) {
            this.linkUrl = str;
        }
    }

    public void setLinkUrlCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, str) == null) {
            this.linkUrlCode = str;
        }
    }

    public void setLocalChannelDynamic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z) == null) {
            this.isLocalChannelDynamic = z;
        }
    }

    public void setLocalChannelTopic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, str) == null) {
            this.mLocalChannelTopic = str;
        }
    }

    public void setMemeContSign(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            this.mMemeContSign = str;
        }
    }

    public void setMemeText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, str) == null) {
            this.mMemeText = str;
        }
    }

    public void setMoreForumImg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, str) == null) {
            this.mMoreForumImg = str;
        }
    }

    public void setMoreForumTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, str) == null) {
            this.mMoreForumTitle = str;
        }
    }

    public void setMoreForumUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, str) == null) {
            this.mMoreForumUrl = str;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, str) == null) {
            this.mName = str;
        }
    }

    public void setNetImgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, str) == null) {
            this.netImgUrl = str;
        }
    }

    public void setNewWritePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048765, this, z) == null) {
            this.isNewWritePage = z;
        }
    }

    public void setNotFakePost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048766, this, z) == null) {
            this.notFakePost = z;
        }
    }

    public void setNotificationH5(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048767, this, z) == null) {
            this.notificationH5 = z;
        }
    }

    public void setOriBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, baijiahaoData) == null) {
            this.mOriBaijiahaoData = baijiahaoData;
        }
    }

    public void setOriginalThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048769, this, str) == null) {
            this.originalThreadId = str;
        }
    }

    public void setOriginalVideoCover(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, str) == null) {
            this.originalVideoCover = str;
        }
    }

    public void setOriginalVideoTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048771, this, str) == null) {
            this.originalVideoTitle = str;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, str) == null) {
            this.mPortrait = str;
        }
    }

    public void setPostPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, str) == null) {
            this.postPrefix = str;
        }
    }

    public void setPrefixData(PostPrefixData postPrefixData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048774, this, postPrefixData) == null) {
            this.mPrefixData = postPrefixData;
        }
    }

    public void setPrivacy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048775, this, z) == null) {
            this.isPrivacy = z;
        }
    }

    public void setPrivateThread(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048776, this, i) == null) {
            this.mPrivateThread = i;
        }
    }

    public void setPutStorageTid(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048777, this, z) == null) {
            this.isPutStorageTid = z;
        }
    }

    public void setQuestionTagId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, str) == null) {
            this.mQuestionTagId = str;
        }
    }

    public void setQuestionTagManualCreated(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048779, this, z) == null) {
            this.isQuestionTagManualCreated = z;
        }
    }

    public void setQuestionThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048780, this, z) == null) {
            this.isQuestionThread = z;
        }
    }

    public void setReSubPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048781, this, str) == null) {
            this.mReSubPostId = str;
        }
    }

    public void setReplyId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048782, this, str) == null) {
            this.mReplyUid = str;
        }
    }

    public void setReplyResultNotificationH5(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048783, this, z) == null) {
            this.isReplyResultNotificationH5 = z;
        }
    }

    public void setRepostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048784, this, str) == null) {
            this.mRepostId = str;
        }
    }

    public void setReturnVoiceMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048785, this, str) == null) {
            this.mReturnVoiceMd5 = str;
        }
    }

    public void setRewardsType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048786, this, str) == null) {
            this.rewardsType = str;
        }
    }

    public void setRichContentData(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048787, this, list) == null) {
            this.richContentData = list;
        }
    }

    public void setRichTextEditorMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048788, this, z) == null) {
            this.isRichTextEditorMode = z;
        }
    }

    public void setSaveDraft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048789, this, z) == null) {
            this.isSaveDraft = z;
        }
    }

    public void setSecondDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048790, this, str) == null) {
            this.mSecondDir = str;
        }
    }

    public void setServerRichContent(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, list) == null) {
            this.richServerContentData = list;
        }
    }

    public void setShowBless(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048792, this, z) == null) {
            this.mShowBless = z;
        }
    }

    public void setShowCustomFigure(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048793, this, z) == null) {
            this.mShowCustomFigure = z;
        }
    }

    public void setStatisticFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048794, this, i) == null) {
            this.statisticFrom = i;
        }
    }

    public void setSubPbReplyPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048795, this, str) == null) {
            this.mSubPbReplyPrefix = str;
        }
    }

    public void setTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048796, this, i) == null) {
            this.mTabId = i;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048797, this, str) == null) {
            this.mTabName = str;
        }
    }

    public void setTakePhotoNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048798, this, i) == null) {
            this.mTakePhotoNum = i;
        }
    }

    public void setThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, str) == null) {
            this.mThreadId = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, str) == null) {
            this.mTitle = str;
        }
    }

    public void setToDynamic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048801, this, z) == null) {
            this.isToDynamic = z;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048802, this, str) == null) {
            this.mTopicId = str;
        }
    }

    public void setTransmitForumData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, str) == null) {
            this.transmitForumData = str;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048804, this, i) == null) {
            this.mType = i;
        }
    }

    public void setVForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048805, this, str) == null) {
            this.vForumId = str;
        }
    }

    public void setVForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, str) == null) {
            this.vForumName = str;
        }
    }

    public void setVcode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048807, this, str) == null) {
            this.mVcode = str;
        }
    }

    public void setVcodeExtra(VcodeExtra vcodeExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048808, this, vcodeExtra) == null) {
            this.mVcodeExtra = vcodeExtra;
        }
    }

    public void setVcodeMD5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048809, this, str) == null) {
            this.mVcodeMD5 = str;
        }
    }

    public void setVcodeType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048810, this, str) == null) {
            this.mVcodeType = str;
        }
    }

    public void setVcodeUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, str) == null) {
            this.mVcodeUrl = str;
        }
    }

    public void setVideoId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048812, this, str) == null) {
            this.mVideoId = str;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, videoInfo) == null) {
            this.mVideoInfo = videoInfo;
        }
    }

    public void setVoice(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048814, this, str) == null) {
            if (str != null && (str2 = this.mVoiceMd5) != null) {
                if (!str.equals(str2)) {
                    setReturnVoiceMd5(null);
                }
            } else if (str == null) {
                setReturnVoiceMd5(null);
            }
            this.mVoiceMd5 = str;
        }
    }

    public void setVoiceDuringTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048815, this, i) == null) {
            this.mDuringTime = i;
        }
    }

    public void setVoiceEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048816, this, z) == null) {
            this.isVoiceEnable = z;
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048817, this, voiceModel) == null) {
            this.mVoiceModel = voiceModel;
        }
    }

    public void setWork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048818, this, z) == null) {
            this.isWork = z;
        }
    }

    public void setWorkDraft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048819, this, z) == null) {
            this.isWorkDraft = z;
        }
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048820, this, writeImagesInfo) == null) {
            this.writeImagesInfo = writeImagesInfo;
        }
    }

    public void setWriteVoteData(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048821, this, writeVoteData) == null) {
            this.mWriteVoteData = writeVoteData;
        }
    }

    public void setXiuxiuOriginalContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048822, this, str) == null) {
            this.xiuxiuOriginalContent = str;
        }
    }

    public void setXiuxiuOriginalFname(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, str) == null) {
            this.xiuxiuOriginalFname = str;
        }
    }

    public String toDraftString() {
        InterceptResult invokeV;
        String plainTextContent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048826, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mType", this.mType);
                jSONObject.put("mTitle", this.mTitle);
                if (TextUtils.isEmpty(getPlainTextContent())) {
                    plainTextContent = this.mContent;
                } else {
                    plainTextContent = getPlainTextContent();
                }
                jSONObject.put("mContent", plainTextContent);
                jSONObject.put("mReplyUid", this.mReplyUid);
                jSONObject.put("mThreadId", this.mThreadId);
                jSONObject.put("isLocalChannelDynamic", this.isLocalChannelDynamic);
                jSONObject.put("mLocalChannelTopic", this.mLocalChannelTopic);
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
                jSONObject.put("source_from", this.sourceFrom);
                jSONObject.put("topic_id", this.mTopicId);
                jSONObject.put("sub_pb_reply_prefix", this.mSubPbReplyPrefix);
                if (this.mEvaluateItemInfo != null) {
                    jSONObject.put(WriteActivityConfig.ITEM_INFO, new Gson().toJson(this.mEvaluateItemInfo));
                    jSONObject.put("evaluation_star", this.mEvaluationStar);
                }
                jSONObject.put(IntentConfig.IS_EVALUATE, this.isEvaluate);
                jSONObject.put("isQuestionThread", this.isQuestionThread);
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
}
