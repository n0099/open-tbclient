package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.DiskCodeCacheManager;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f3b {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947714612, "Lcom/baidu/tieba/f3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947714612, "Lcom/baidu/tieba/f3b;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final JSONObject a(ImageFileInfo info, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, info, i)) == null) {
                Intrinsics.checkNotNullParameter(info, "info");
                String b = jza.b(info);
                String a = jza.a(info);
                JSONObject jSONObject = new JSONObject();
                rq6.a(jSONObject, DiskCodeCacheManager.DISK_CODE_CACHE_INDEX_SUFFIX, Integer.valueOf(i));
                rq6.a(jSONObject, "name", b);
                rq6.a(jSONObject, "type", Integer.valueOf(info.getImageType()));
                rq6.a(jSONObject, "isGif", Boolean.valueOf(info.isGif()));
                rq6.a(jSONObject, "tag", a);
                rq6.a(jSONObject, "serverImageCode", info.getServerImageCode());
                return jSONObject;
            }
            return (JSONObject) invokeLI.objValue;
        }

        public final void b(Bundle savedInstanceState, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, savedInstanceState, writeData) == null) {
                Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
                Intrinsics.checkNotNullParameter(writeData, "writeData");
                writeData.setType(savedInstanceState.getInt("type", 9));
                writeData.setForumId(savedInstanceState.getString("forum_id"));
                writeData.setForumName(savedInstanceState.getString("forum_name"));
                writeData.setFirstDir(savedInstanceState.getString(IntentConfig.FORUM_FIRST_DIR));
                writeData.setSecondDir(savedInstanceState.getString(IntentConfig.FORUM_SECOND_DIR));
                writeData.setThreadId(savedInstanceState.getString("thread_id"));
                writeData.setTitle(savedInstanceState.getString(BaseWriteConfig.TITLE));
                writeData.setContent(savedInstanceState.getString(BaseWriteConfig.CONTENT));
                writeData.setCallFrom(savedInstanceState.getString(BaseWriteConfig.KEY_CALL_FROM));
                if (Intrinsics.areEqual("1", savedInstanceState.getString(WriteActivityConfig.NO_SUCCESS_TOAST))) {
                    writeData.setInterceptWriteResultDialog(true);
                }
                if (savedInstanceState.getBoolean(WriteActivityConfig.KEY_PUT_STORAGE_TID, false)) {
                    writeData.setPutStorageTid(true);
                }
                String string = savedInstanceState.getString(BaseWriteConfig.PREFIX_DATA);
                PostPrefixData postPrefixData = null;
                if (!StringUtils.isNull(string)) {
                    postPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string, PostPrefixData.class);
                }
                writeData.setPrefixData(postPrefixData);
                writeData.setFrom(savedInstanceState.getString("from"));
                writeData.setTopicId(savedInstanceState.getString(WriteActivityConfig.HOT_TOPIC_ID));
                writeData.setStatisticFrom(savedInstanceState.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                writeData.setPrivateThread(savedInstanceState.getInt(BaseWriteConfig.PRIVATE_THREAD));
                writeData.setFrsTabInfoData((FrsTabInfoData) savedInstanceState.getSerializable("tab_list"));
                writeData.setCanGoods(savedInstanceState.getBoolean(WriteActivityConfig.CAN_GOODS));
                writeData.setNotificationH5(savedInstanceState.getBoolean(WriteActivityConfig.KEY_NOTIFICATION_H5, false));
                writeData.setNotFakePost(savedInstanceState.getBoolean(WriteActivityConfig.KEY_NOT_FAKE_POST, false));
                writeData.setActiveName(savedInstanceState.getString(WriteActivityConfig.KEY_ACTIVE_NAME));
                writeData.setActiveTaskName(savedInstanceState.getString(WriteActivityConfig.KEY_ACTIVE_TASK_NAME));
                writeData.setHintText(savedInstanceState.getString(WriteActivityConfig.KEY_WRITE_HINT_TEXT));
                writeData.setInputInsertAtList(savedInstanceState.getParcelableArrayList(WriteActivityConfig.KEY_WRITE_AT_LIST));
                if (writeData.getType() == 10) {
                    writeData.setEntranceType(2);
                    writeData.setType(9);
                } else {
                    writeData.setEntranceType(1);
                }
                ForumTagInfo forumTagInfo = (ForumTagInfo) savedInstanceState.getSerializable(WriteActivityConfig.FORUM_TAG_INFO);
                if (Intrinsics.areEqual("2", writeData.getCallFrom()) && forumTagInfo != null && forumTagInfo.isValid()) {
                    writeData.setQuestionTagId(forumTagInfo.id);
                    writeData.setQuestionTagManualCreated(false);
                }
                writeData.setFirstClass(savedInstanceState.getString(WriteActivityConfig.FORUM_FIRST_CATEGORY));
            }
        }

        public final void c(Intent intent, WriteData writeData) {
            FrsTabInfoData frsTabInfoData;
            PostPrefixData postPrefixData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, intent, writeData) == null) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(writeData, "writeData");
                if (writeData.isFromErrorDialog() && tja.f != null) {
                    return;
                }
                writeData.setType(intent.getIntExtra("type", 9));
                writeData.setForumId(intent.getStringExtra("forum_id"));
                writeData.setForumName(intent.getStringExtra("forum_name"));
                writeData.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
                writeData.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
                writeData.setThreadId(intent.getStringExtra("thread_id"));
                writeData.setTitle(intent.getStringExtra(BaseWriteConfig.TITLE));
                writeData.setContent(intent.getStringExtra(BaseWriteConfig.CONTENT));
                writeData.setCallFrom(intent.getStringExtra(BaseWriteConfig.KEY_CALL_FROM));
                writeData.setFrom(intent.getStringExtra("from"));
                writeData.setTopicId(intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID));
                writeData.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
                writeData.setPrivateThread(intent.getIntExtra(BaseWriteConfig.PRIVATE_THREAD, 0));
                Serializable serializableExtra = intent.getSerializableExtra("tab_list");
                WriteVoteData writeVoteData = null;
                if (serializableExtra instanceof FrsTabInfoData) {
                    frsTabInfoData = (FrsTabInfoData) serializableExtra;
                } else {
                    frsTabInfoData = null;
                }
                writeData.setFrsTabInfoData(frsTabInfoData);
                writeData.setVoiceEnable(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
                writeData.setDisableAudioMessage(intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE));
                writeData.setCanGoods(intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false));
                Serializable serializableExtra2 = intent.getSerializableExtra(BaseWriteConfig.PREFIX_DATA);
                if (serializableExtra2 instanceof PostPrefixData) {
                    postPrefixData = (PostPrefixData) serializableExtra2;
                } else {
                    postPrefixData = null;
                }
                if (Intrinsics.areEqual("1", intent.getStringExtra(WriteActivityConfig.NO_SUCCESS_TOAST))) {
                    writeData.setInterceptWriteResultDialog(true);
                }
                if (intent.getBooleanExtra(WriteActivityConfig.KEY_PUT_STORAGE_TID, false)) {
                    writeData.setPutStorageTid(true);
                }
                if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                    postPrefixData.getPrefixs().add(UtilHelper.getString(R.string.write_no_prefix));
                }
                writeData.setPrefixData(postPrefixData);
                Serializable serializableExtra3 = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                if (serializableExtra3 instanceof WriteVoteData) {
                    writeVoteData = (WriteVoteData) serializableExtra3;
                }
                writeData.setWriteVoteData(writeVoteData);
                writeData.setFromItemDetail(intent.getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false));
                writeData.setIntentStarCount(intent.getIntExtra(WriteActivityConfig.STAR_COUNT, 0));
                Serializable serializableExtra4 = intent.getSerializableExtra(WriteActivityConfig.ITEM_INFO);
                if (serializableExtra4 instanceof SerializableItemInfo) {
                    SerializableItemInfo serializableItemInfo = (SerializableItemInfo) serializableExtra4;
                    writeData.setIntentItemInfo(serializableItemInfo);
                    writeData.setItem_id(String.valueOf(serializableItemInfo.id));
                }
                writeData.setSaveDraft(intent.getBooleanExtra(BaseWriteConfig.IS_SAVE_DRAFTE, true));
                writeData.setMoreForumImg(intent.getStringExtra("more_forum_img"));
                writeData.setMoreForumTitle(intent.getStringExtra("more_forum_title"));
                writeData.setMoreForumUrl(intent.getStringExtra("more_forum_url"));
                writeData.setNetImgUrl(intent.getStringExtra(WriteActivityConfig.KEY_GAME_RANK_IMG_URL));
                writeData.setFromGameRank(intent.getBooleanExtra(WriteActivityConfig.KEY_IS_FROM_GAME_RANK, false));
                writeData.setGameId(intent.getStringExtra(WriteActivityConfig.KEY_GAME_ID));
                writeData.setGameName(intent.getStringExtra(WriteActivityConfig.KEY_GAME_NAME));
                writeData.setRewardsType(intent.getStringExtra(WriteActivityConfig.KEY_REWARDS_TYPE));
                writeData.setXiuxiuOriginalContent(intent.getStringExtra(WriteActivityConfig.KEY_XIUXIU_ORIGINAL_CONTENT));
                writeData.setXiuxiuOriginalFname(intent.getStringExtra(WriteActivityConfig.KEY_XIUXIU_ORIGINAL_FNAME));
                writeData.setIsArticle(intent.getStringExtra(WriteActivityConfig.IS_ARTICLE));
                writeData.setNotificationH5(intent.getBooleanExtra(WriteActivityConfig.KEY_NOTIFICATION_H5, false));
                writeData.setNotFakePost(intent.getBooleanExtra(WriteActivityConfig.KEY_NOT_FAKE_POST, false));
                writeData.setHintText(intent.getStringExtra(WriteActivityConfig.KEY_WRITE_HINT_TEXT));
                writeData.setInputInsertAtList(intent.getParcelableArrayListExtra(WriteActivityConfig.KEY_WRITE_AT_LIST));
                writeData.setActiveName(intent.getStringExtra(WriteActivityConfig.KEY_ACTIVE_NAME));
                writeData.setActiveTaskName(intent.getStringExtra(WriteActivityConfig.KEY_ACTIVE_TASK_NAME));
                if (writeData.getType() == 10) {
                    writeData.setEntranceType(2);
                    writeData.setType(9);
                } else {
                    writeData.setEntranceType(1);
                }
                ForumTagInfo forumTagInfo = (ForumTagInfo) intent.getSerializableExtra(WriteActivityConfig.FORUM_TAG_INFO);
                if (Intrinsics.areEqual("2", writeData.getCallFrom()) && forumTagInfo != null && forumTagInfo.isValid()) {
                    writeData.setQuestionTagId(forumTagInfo.id);
                    writeData.setQuestionTagManualCreated(false);
                }
                writeData.setFirstClass(intent.getStringExtra(WriteActivityConfig.FORUM_FIRST_CATEGORY));
            }
        }

        public final void d(WriteData writeData, WriteData draftData) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, writeData, draftData) == null) {
                Intrinsics.checkNotNullParameter(writeData, "writeData");
                Intrinsics.checkNotNullParameter(draftData, "draftData");
                if (writeData.isFromErrorDialog() && tja.f != null) {
                    return;
                }
                writeData.setTitle(draftData.getTitle());
                writeData.setContent(draftData.getContent());
                writeData.setReplyId(draftData.getReplyId());
                writeData.setThreadId(draftData.getThreadId());
                writeData.setLocalChannelDynamic(draftData.isLocalChannelDynamic());
                writeData.setLocalChannelTopic(draftData.getLocalChannelTopic());
                writeData.setVideoInfo(draftData.getVideoInfo());
                VoiceData.VoiceModel voiceModel = draftData.getVoiceModel();
                if (voiceModel != null) {
                    str = voiceModel.voiceId;
                } else {
                    str = null;
                }
                writeData.setVoice(str);
                VoiceData.VoiceModel voiceModel2 = draftData.getVoiceModel();
                if (voiceModel2 != null) {
                    i = voiceModel2.duration;
                } else {
                    i = 0;
                }
                writeData.setVoiceDuringTime(i);
                writeData.setVoiceModel(draftData.getVoiceModel());
                writeData.setWriteImagesInfo(draftData.getWriteImagesInfo());
                writeData.setRichTextEditorMode(draftData.isRichTextEditorMode());
                writeData.setRichContentData(draftData.getRichContentData());
                writeData.sourceFrom = draftData.sourceFrom;
                writeData.setTopicId(draftData.getTopicId());
                writeData.setSubPbReplyPrefix(draftData.getSubPbReplyPrefix());
                writeData.setItemInfo(draftData.getItemInfo());
                writeData.setEvaluationStar(draftData.getEvaluationStar());
                writeData.setIsEvaluate(draftData.isEvaluate());
                writeData.setQuestionThread(draftData.isQuestionThread());
                writeData.setWriteVoteData(draftData.getWriteVoteData());
                writeData.setItemInfo(draftData.getItemInfo());
                ArrayList<ItemData> itemDatas = draftData.getItemDatas();
                if (itemDatas != null) {
                    for (ItemData itemData : itemDatas) {
                        writeData.addItemData(itemData);
                    }
                }
                writeData.setSelectForumInfo(draftData.getSelectForumInfo());
            }
        }
    }
}
