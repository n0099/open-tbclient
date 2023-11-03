package com.baidu.tieba.im.lib.socket.msg;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.bt5;
import com.baidu.tieba.gs8;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityEffectItem;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BubbleInfo;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.im.lib.socket.msg.data.EnableDegradeUserData;
import com.baidu.tieba.im.lib.socket.msg.data.ExcellentInfo;
import com.baidu.tieba.im.lib.socket.msg.data.UserExtraInfo;
import com.baidu.tieba.immessagecenter.im.dispatcher.PersonalMsgSettingDispatcher;
import com.baidu.tieba.ms8;
import com.baidu.tieba.ns8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\n\b&\u0018\u0000 «\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0004«\u0001¬\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u0013J\u0016\u0010\u0096\u0001\u001a\u00030\u0097\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bJ\u0007\u0010\u0099\u0001\u001a\u000203J\u0015\u0010\u009a\u0001\u001a\u0002032\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010RH\u0096\u0002J\u0011\u0010\u009c\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0000J\u0007\u0010\u009e\u0001\u001a\u00020FJ\u0017\u0010\u009f\u0001\u001a\u0005\u0018\u0001H \u0001\"\u0005\b\u0000\u0010 \u0001¢\u0006\u0003\u0010¡\u0001J\n\u0010¢\u0001\u001a\u00030£\u0001H&J\t\u0010¤\u0001\u001a\u00020?H\u0016J\u0007\u0010¥\u0001\u001a\u000203J\u0007\u0010¦\u0001\u001a\u000203J\u0011\u0010§\u0001\u001a\u00030\u0097\u00012\u0007\u0010¨\u0001\u001a\u00020RJ\u000b\u0010©\u0001\u001a\u0004\u0018\u00010\u0000H\u0016J\u0010\u0010ª\u0001\u001a\u00030\u0097\u00012\u0006\u0010E\u001a\u00020FR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0012\u0010\u0016\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R&\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R \u0010&\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010,\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u001e\u00109\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R$\u0010<\u001a\u0002032\u0006\u0010;\u001a\u0002038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u00104\"\u0004\b=\u00106R\u0012\u0010>\u001a\u00020?8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020F8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010K\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010B\"\u0004\bM\u0010DR \u0010N\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010B\"\u0004\bP\u0010DR\u0014\u0010Q\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010B\"\u0004\bU\u0010DR \u0010V\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR&\u0010[\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010\u0010R \u0010^\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010d\u001a\u00020?8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\be\u0010\u0003\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR \u0010j\u001a\u00020?X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bk\u0010\u0003\u001a\u0004\bl\u0010g\"\u0004\bm\u0010iR$\u0010n\u001a\u00020?8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bo\u0010\u0003\u001a\u0004\bp\u0010g\"\u0004\bq\u0010iR&\u0010r\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u000e\"\u0004\bt\u0010\u0010R$\u0010u\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bv\u0010\u0003\u001a\u0004\bw\u0010B\"\u0004\bx\u0010DR\u001e\u0010y\u001a\u00020F8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010H\"\u0004\b{\u0010JR2\u0010|\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020R0}\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u000e\"\u0004\b\u007f\u0010\u0010R&\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R(\u0010\u0086\u0001\u001a\u00020?8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0000\u0012\u0005\b\u0087\u0001\u0010\u0003\u001a\u0005\b\u0088\u0001\u0010g\"\u0005\b\u0089\u0001\u0010iR&\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R'\u0010\u0090\u0001\u001a\u00020F2\u0006\u0010;\u001a\u00020F8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010H\"\u0005\b\u0092\u0001\u0010JR!\u0010\u0093\u0001\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010B\"\u0005\b\u0095\u0001\u0010D¨\u0006\u00ad\u0001"}, d2 = {"Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "Ljava/io/Serializable;", "Lcom/baidu/tieba/im/lib/socket/listener/ShallowClone;", "()V", "abilityEffectItem", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityEffectItem;", "getAbilityEffectItem", "()Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityEffectItem;", "setAbilityEffectItem", "(Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityEffectItem;)V", "abilityItems", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "getAbilityItems", "()Ljava/util/List;", "setAbilityItems", "(Ljava/util/List;)V", "<set-?>", "", "Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo;", "atUserInfoList", "getAtUserInfoList", "bdUk", "", "bubbleInfo", "Lcom/baidu/tieba/im/lib/socket/msg/data/BubbleInfo;", "getBubbleInfo", "()Lcom/baidu/tieba/im/lib/socket/msg/data/BubbleInfo;", "setBubbleInfo", "(Lcom/baidu/tieba/im/lib/socket/msg/data/BubbleInfo;)V", "emojiList", "Lcom/baidu/tieba/im/lib/socket/msg/data/EmojiData;", "getEmojiList", "setEmojiList", "enableDegradeUserDataList", "Lcom/baidu/tieba/im/lib/socket/msg/data/EnableDegradeUserData;", "getEnableDegradeUserDataList", "setEnableDegradeUserDataList", "excellentInfo", "Lcom/baidu/tieba/im/lib/socket/msg/data/ExcellentInfo;", "getExcellentInfo", "()Lcom/baidu/tieba/im/lib/socket/msg/data/ExcellentInfo;", "setExcellentInfo", "(Lcom/baidu/tieba/im/lib/socket/msg/data/ExcellentInfo;)V", "forumExt", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg$ForumExt;", "getForumExt", "()Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg$ForumExt;", "setForumExt", "(Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg$ForumExt;)V", "isLocalEmojiReply", "", "()Z", "setLocalEmojiReply", "(Z)V", "isLocalMsgId", "setLocalMsgId", "isMockSender", "setMockSender", "value", "isSysMsg", "setSysMsg", "isSysMsgInt", "", "limitVersion", "getLimitVersion", "()Ljava/lang/String;", "setLimitVersion", "(Ljava/lang/String;)V", "msgId", "", "getMsgId", "()J", "setMsgId", "(J)V", "msgKey", "getMsgKey", "setMsgKey", "originMsgKey", "getOriginMsgKey", "setOriginMsgKey", "originSdkMsg", "", "portrait", "getPortrait", "setPortrait", "preTimestampMsg", "getPreTimestampMsg", "()Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "setPreTimestampMsg", "(Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;)V", "quickOperate", "getQuickOperate", "setQuickOperate", "reMsgInfo", "Lcom/baidu/tieba/im/lib/socket/msg/TbReMsgInfo;", "getReMsgInfo", "()Lcom/baidu/tieba/im/lib/socket/msg/TbReMsgInfo;", "setReMsgInfo", "(Lcom/baidu/tieba/im/lib/socket/msg/TbReMsgInfo;)V", "robotRole", "getRobotRole$annotations", "getRobotRole", "()I", "setRobotRole", "(I)V", "role", "getRole$annotations", "getRole", "setRole", "sdkMsgStatus", "getSdkMsgStatus$annotations", "getSdkMsgStatus", "setSdkMsgStatus", "secondDegradeUserDataList", "getSecondDegradeUserDataList", "setSecondDegradeUserDataList", "sendClient", "getSendClient$annotations", "getSendClient", "setSendClient", "sessionId", "getSessionId", "setSessionId", "structData", "", "getStructData", "setStructData", NextActive.keyTaskInfo, "Lcom/baidu/tieba/im/lib/socket/msg/TbTaskInfo;", "getTaskInfo", "()Lcom/baidu/tieba/im/lib/socket/msg/TbTaskInfo;", "setTaskInfo", "(Lcom/baidu/tieba/im/lib/socket/msg/TbTaskInfo;)V", "type", "getType$annotations", "getType", "setType", "userExtraInfo", "Lcom/baidu/tieba/im/lib/socket/msg/data/UserExtraInfo;", "getUserExtraInfo", "()Lcom/baidu/tieba/im/lib/socket/msg/data/UserExtraInfo;", "setUserExtraInfo", "(Lcom/baidu/tieba/im/lib/socket/msg/data/UserExtraInfo;)V", "userId", "getUserId", "setUserId", TbEnum.SystemMessage.KEY_USER_NAME, "getUserName", "setUserName", "addAtUserInfo", "", "atUserInfo", "compareVersion", "equals", "other", "fillMsg4Base", "baseMsg", "getMsgTime", "getOriginSdkMsg", "SdkMsg", "()Ljava/lang/Object;", "getThumbnailText", "", "hashCode", "isMaster", "isRobot", "setOriginSdkMsg", "oriSdkMsg", "shallowClone", "syncServerMsgId", "Companion", "ForumExt", "im-lib-socket_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class TbBaseMsg implements Serializable, Object<TbBaseMsg> {
    public static /* synthetic */ Interceptable $ic = null;
    @JvmField
    public static final Comparator<TbBaseMsg> COMPARATOR;
    public static final b Companion;
    public static final String FIELD_FORUM_EXT = "mock_forum_ext";
    public static final String FIELD_FORUM_LEVEL = "level";
    public static final String FIELD_MSG_TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;
    @bt5(deserialize = false, serialize = false)
    public AbilityEffectItem abilityEffectItem;
    @bt5(serialize = false)
    @SerializedName("sug_list")
    public List<AbilityItem> abilityItems;
    @gs8
    @SerializedName("at_user_info_list")
    public List<TbAtUserInfo> atUserInfoList;
    @gs8
    @SerializedName("uk")
    public String bdUk;
    @SerializedName("bubble_info")
    public BubbleInfo bubbleInfo;
    @SerializedName("emoji_info")
    public List<EmojiData> emojiList;
    @SerializedName("main_data")
    public List<EnableDegradeUserData> enableDegradeUserDataList;
    @SerializedName("excellent_info")
    public ExcellentInfo excellentInfo;
    @SerializedName(FIELD_FORUM_EXT)
    public c forumExt;
    @bt5(deserialize = false, serialize = false)
    public boolean isLocalEmojiReply;
    @bt5(serialize = false)
    public boolean isLocalMsgId;
    @bt5(serialize = false)
    public boolean isMockSender;
    @SerializedName("is_sys_msg")
    public int isSysMsgInt;
    @SerializedName("version")
    public String limitVersion;
    @gs8
    @SerializedName("msg_id")
    public long msgId;
    @gs8
    @SerializedName("msg_key")
    public String msgKey;
    @SerializedName("origin_msg_key")
    public String originMsgKey;
    @bt5(serialize = false)
    public Object originSdkMsg;
    public String portrait;
    @bt5(serialize = false)
    public TbBaseMsg preTimestampMsg;
    @SerializedName("quick_operate")
    public List<AbilityItem> quickOperate;
    @gs8
    @SerializedName("re_msg_info")
    public TbReMsgInfo reMsgInfo;
    @SerializedName(PersonalMsgSettingDispatcher.PERSONAL_ROBOT_ROLE)
    public int robotRole;
    public int role;
    @SerializedName(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)
    public int sdkMsgStatus;
    @SerializedName("second_data")
    public List<EnableDegradeUserData> secondDegradeUserDataList;
    @SerializedName("from")
    public String sendClient;
    @SerializedName("session_id")
    public long sessionId;
    @SerializedName("struct_data")
    public List<? extends Map<String, ? extends Object>> structData;
    @gs8
    @SerializedName("task_info")
    public TbTaskInfo taskInfo;
    @SerializedName("type")
    public int type;
    @SerializedName("user_extra_info")
    public UserExtraInfo userExtraInfo;
    @SerializedName("user_name")
    public String userName;

    public static /* synthetic */ void getRobotRole$annotations() {
    }

    public static /* synthetic */ void getRole$annotations() {
    }

    public static /* synthetic */ void getSdkMsgStatus$annotations() {
    }

    public static /* synthetic */ void getSendClient$annotations() {
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public abstract CharSequence getThumbnailText();

    /* loaded from: classes6.dex */
    public static final class a implements Comparator<TbBaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TbBaseMsg o1, TbBaseMsg o2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, o1, o2)) == null) {
                Intrinsics.checkNotNullParameter(o1, "o1");
                Intrinsics.checkNotNullParameter(o2, "o2");
                if (TextUtils.equals(o1.getMsgKey(), o2.getMsgKey())) {
                    return 0;
                }
                if (o1.isLocalMsgId() || o1.getMsgId() == 0 || o1.getMsgId() - o2.getMsgId() >= 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public b() {
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

        public final long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
            }
            return invokeV.longValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("level")
        public int a;
        @SerializedName("forum_id")
        public long b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c() {
            this(0, 0L, 3, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), (DefaultConstructorMarker) objArr[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    return this.a == cVar.a && this.b == cVar.b;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.a * 31) + com.baidu.tieba.c.a(this.b) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "ForumExt(forumLevel=" + this.a + ", forumId=" + this.b + ')';
            }
            return (String) invokeV.objValue;
        }

        public c(int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = j;
        }

        public /* synthetic */ c(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j);
        }

        public final long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return invokeV.longValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public final void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a = i;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(3817724, "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(3817724, "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;");
                return;
            }
        }
        Companion = new b(null);
        COMPARATOR = new a();
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    public final boolean compareVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return TbConfig.compareVersion(this.limitVersion);
        }
        return invokeV.booleanValue;
    }

    public final AbilityEffectItem getAbilityEffectItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.abilityEffectItem;
        }
        return (AbilityEffectItem) invokeV.objValue;
    }

    public final List<AbilityItem> getAbilityItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.abilityItems;
        }
        return (List) invokeV.objValue;
    }

    public final List<TbAtUserInfo> getAtUserInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.atUserInfoList;
        }
        return (List) invokeV.objValue;
    }

    public final BubbleInfo getBubbleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.bubbleInfo;
        }
        return (BubbleInfo) invokeV.objValue;
    }

    public final List<EmojiData> getEmojiList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.emojiList;
        }
        return (List) invokeV.objValue;
    }

    public final List<EnableDegradeUserData> getEnableDegradeUserDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.enableDegradeUserDataList;
        }
        return (List) invokeV.objValue;
    }

    public final ExcellentInfo getExcellentInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.excellentInfo;
        }
        return (ExcellentInfo) invokeV.objValue;
    }

    public final c getForumExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.forumExt;
        }
        return (c) invokeV.objValue;
    }

    public final String getLimitVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.limitVersion;
        }
        return (String) invokeV.objValue;
    }

    public final long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.msgId;
        }
        return invokeV.longValue;
    }

    public final String getMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.msgKey;
        }
        return (String) invokeV.objValue;
    }

    public final long getMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return TimeUnit.MICROSECONDS.toMillis(this.msgId);
        }
        return invokeV.longValue;
    }

    public final String getOriginMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.originMsgKey;
        }
        return (String) invokeV.objValue;
    }

    public final <SdkMsg> SdkMsg getOriginSdkMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return (SdkMsg) this.originSdkMsg;
        }
        return (SdkMsg) invokeV.objValue;
    }

    public final String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.portrait;
        }
        return (String) invokeV.objValue;
    }

    public final TbBaseMsg getPreTimestampMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.preTimestampMsg;
        }
        return (TbBaseMsg) invokeV.objValue;
    }

    public final List<AbilityItem> getQuickOperate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.quickOperate;
        }
        return (List) invokeV.objValue;
    }

    public final TbReMsgInfo getReMsgInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.reMsgInfo;
        }
        return (TbReMsgInfo) invokeV.objValue;
    }

    public final int getRobotRole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.robotRole;
        }
        return invokeV.intValue;
    }

    public final int getRole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.role;
        }
        return invokeV.intValue;
    }

    public final int getSdkMsgStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.sdkMsgStatus;
        }
        return invokeV.intValue;
    }

    public final List<EnableDegradeUserData> getSecondDegradeUserDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.secondDegradeUserDataList;
        }
        return (List) invokeV.objValue;
    }

    public final String getSendClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.sendClient;
        }
        return (String) invokeV.objValue;
    }

    public final long getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.sessionId;
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>>, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> */
    public final List<Map<String, Object>> getStructData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.structData;
        }
        return (List) invokeV.objValue;
    }

    public final TbTaskInfo getTaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.taskInfo;
        }
        return (TbTaskInfo) invokeV.objValue;
    }

    public final int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public final UserExtraInfo getUserExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.userExtraInfo;
        }
        return (UserExtraInfo) invokeV.objValue;
    }

    public final long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return ns8.a(this.bdUk);
        }
        return invokeV.longValue;
    }

    public final String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.userName;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Object
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.msgKey.hashCode();
        }
        return invokeV.intValue;
    }

    public final boolean isLocalEmojiReply() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.isLocalEmojiReply;
        }
        return invokeV.booleanValue;
    }

    public final boolean isLocalMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.isLocalMsgId;
        }
        return invokeV.booleanValue;
    }

    public final boolean isMaster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return ms8.c(getUserId());
        }
        return invokeV.booleanValue;
    }

    public final boolean isMockSender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.isMockSender;
        }
        return invokeV.booleanValue;
    }

    public final boolean isRobot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.robotRole > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isSysMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.isSysMsgInt == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public TbBaseMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.msgKey = "";
        this.bdUk = "";
        this.userName = "";
        this.portrait = "";
        this.limitVersion = "";
        this.sendClient = "non";
    }

    public final void addAtUserInfo(TbAtUserInfo atUserInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, atUserInfo) == null) {
            Intrinsics.checkNotNullParameter(atUserInfo, "atUserInfo");
            if (this.atUserInfoList == null) {
                this.atUserInfoList = new ArrayList();
            }
            List<TbAtUserInfo> list = this.atUserInfoList;
            Intrinsics.checkNotNull(list);
            list.add(atUserInfo);
        }
    }

    public final void fillMsg4Base(TbBaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baseMsg) == null) {
            Intrinsics.checkNotNullParameter(baseMsg, "baseMsg");
            this.atUserInfoList = baseMsg.atUserInfoList;
            this.reMsgInfo = baseMsg.reMsgInfo;
            this.taskInfo = baseMsg.taskInfo;
        }
    }

    public final void setAbilityEffectItem(AbilityEffectItem abilityEffectItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, abilityEffectItem) == null) {
            this.abilityEffectItem = abilityEffectItem;
        }
    }

    public final void setAbilityItems(List<AbilityItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, list) == null) {
            this.abilityItems = list;
        }
    }

    public final void setBubbleInfo(BubbleInfo bubbleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bubbleInfo) == null) {
            this.bubbleInfo = bubbleInfo;
        }
    }

    public final void setEmojiList(List<EmojiData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, list) == null) {
            this.emojiList = list;
        }
    }

    public final void setEnableDegradeUserDataList(List<EnableDegradeUserData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, list) == null) {
            this.enableDegradeUserDataList = list;
        }
    }

    public final void setExcellentInfo(ExcellentInfo excellentInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, excellentInfo) == null) {
            this.excellentInfo = excellentInfo;
        }
    }

    public final void setForumExt(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, cVar) == null) {
            this.forumExt = cVar;
        }
    }

    public final void setLimitVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.limitVersion = str;
        }
    }

    public final void setLocalEmojiReply(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.isLocalEmojiReply = z;
        }
    }

    public final void setLocalMsgId(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.isLocalMsgId = z;
        }
    }

    public final void setMockSender(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.isMockSender = z;
        }
    }

    public final void setMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048631, this, j) == null) {
            this.msgId = j;
        }
    }

    public final void setMsgKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.msgKey = str;
        }
    }

    public final void setOriginMsgKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.originMsgKey = str;
        }
    }

    public final void setOriginSdkMsg(Object oriSdkMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, oriSdkMsg) == null) {
            Intrinsics.checkNotNullParameter(oriSdkMsg, "oriSdkMsg");
            this.originSdkMsg = oriSdkMsg;
        }
    }

    public final void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.portrait = str;
        }
    }

    public final void setPreTimestampMsg(TbBaseMsg tbBaseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, tbBaseMsg) == null) {
            this.preTimestampMsg = tbBaseMsg;
        }
    }

    public final void setQuickOperate(List<AbilityItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, list) == null) {
            this.quickOperate = list;
        }
    }

    public final void setReMsgInfo(TbReMsgInfo tbReMsgInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, tbReMsgInfo) == null) {
            this.reMsgInfo = tbReMsgInfo;
        }
    }

    public final void setRobotRole(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.robotRole = i;
        }
    }

    public final void setRole(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            this.role = i;
        }
    }

    public final void setSdkMsgStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            this.sdkMsgStatus = i;
        }
    }

    public final void setSecondDegradeUserDataList(List<EnableDegradeUserData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, list) == null) {
            this.secondDegradeUserDataList = list;
        }
    }

    public final void setSendClient(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sendClient = str;
        }
    }

    public final void setSessionId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048644, this, j) == null) {
            this.sessionId = j;
        }
    }

    public final void setStructData(List<? extends Map<String, ? extends Object>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, list) == null) {
            this.structData = list;
        }
    }

    public final void setSysMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.isSysMsgInt = z ? 1 : 0;
        }
    }

    public final void setTaskInfo(TbTaskInfo tbTaskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, tbTaskInfo) == null) {
            this.taskInfo = tbTaskInfo;
        }
    }

    public final void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            this.type = i;
        }
    }

    public final void setUserExtraInfo(UserExtraInfo userExtraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, userExtraInfo) == null) {
            this.userExtraInfo = userExtraInfo;
        }
    }

    public final void setUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048650, this, j) == null) {
            String b2 = ns8.b(j);
            Intrinsics.checkNotNullExpressionValue(b2, "value.toUk()");
            this.bdUk = b2;
        }
    }

    public final void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.userName = str;
        }
    }

    public final void syncServerMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048654, this, j) == null) {
            this.msgId = j;
            this.isLocalMsgId = false;
            TbBaseMsg tbBaseMsg = this.preTimestampMsg;
            if (tbBaseMsg != null) {
                tbBaseMsg.msgId = j - 1;
            }
        }
    }

    public final void addAtUserInfo(List<TbAtUserInfo> atUserInfoList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, atUserInfoList) == null) {
            Intrinsics.checkNotNullParameter(atUserInfoList, "atUserInfoList");
            if (this.atUserInfoList == null) {
                this.atUserInfoList = new ArrayList();
            }
            List<TbAtUserInfo> list = this.atUserInfoList;
            Intrinsics.checkNotNull(list);
            list.addAll(atUserInfoList);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            Class<?> cls2 = getClass();
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(cls2, cls)) {
                return false;
            }
            if (obj != null) {
                if (Intrinsics.areEqual(this.msgKey, ((TbBaseMsg) obj).msgKey)) {
                    return true;
                }
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.im.lib.socket.msg.TbBaseMsg");
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[Catch: CloneNotSupportedException -> 0x003f, TryCatch #0 {CloneNotSupportedException -> 0x003f, blocks: (B:4:0x0004, B:6:0x000e, B:12:0x001a, B:13:0x0028, B:15:0x002e, B:16:0x003c), top: B:25:0x0004 }] */
    /* renamed from: shallowClone */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TbBaseMsg m141shallowClone() {
        boolean z;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            try {
                TbBaseMsg tbBaseMsg = (TbBaseMsg) clone();
                List<EmojiData> list = tbBaseMsg.emojiList;
                if (list != null && !list.isEmpty()) {
                    z = false;
                    if (!z) {
                        ArrayList arrayList = new ArrayList();
                        List<EmojiData> list2 = tbBaseMsg.emojiList;
                        Intrinsics.checkNotNull(list2);
                        for (EmojiData emojiData : list2) {
                            arrayList.add(emojiData.shallowClone());
                        }
                        tbBaseMsg.emojiList = arrayList;
                    }
                    return tbBaseMsg;
                }
                z = true;
                if (!z) {
                }
                return tbBaseMsg;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (TbBaseMsg) invokeV.objValue;
    }
}
