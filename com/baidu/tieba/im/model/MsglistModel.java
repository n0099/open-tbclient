package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a9;
import com.repackage.ad5;
import com.repackage.ax4;
import com.repackage.b9;
import com.repackage.c67;
import com.repackage.d57;
import com.repackage.dd5;
import com.repackage.dr4;
import com.repackage.ic5;
import com.repackage.j35;
import com.repackage.jc5;
import com.repackage.l67;
import com.repackage.lt4;
import com.repackage.m67;
import com.repackage.mg;
import com.repackage.s77;
import com.repackage.v77;
import com.repackage.w87;
import com.repackage.x87;
import com.repackage.y47;
import com.repackage.z35;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class MsglistModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GAME_SHARE_COUNT_OVER = 3100001;
    public static final int MODE_TYPE_CHAT_ROOM_RULE = 13;
    public static final int MODE_TYPE_CLEAR_HISTORY = 12;
    public static final int MODE_TYPE_DELETE_MSG = 7;
    public static final int MODE_TYPE_FIRST_GET_MSGS = 1;
    public static final int MODE_TYPE_INSERT_REPLY_CARD = 14;
    public static final int MODE_TYPE_LOAD_DRAFT = 8;
    public static final int MODE_TYPE_NAME_UPDATE = 10;
    public static final int MODE_TYPE_PRE = 2;
    public static final int MODE_TYPE_PUSH = 3;
    public static final int MODE_TYPE_QUIT_GROUP = 9;
    public static final int MODE_TYPE_RESEND = 6;
    public static final int MODE_TYPE_SEND = 5;
    public static final int MODE_TYPE_SENDING = 4;
    public static final int MODE_TYPE_UNLOGIN = 11;
    public static final int NOT_FRIEND_ERROR = 3160008;
    public static final int TYPE_DELETE_FAIL_MSG = 1;
    public static final int TYPE_DELETE_SUC_MSG = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int DURATION_TIME_OUT;
    public int customGroupType;
    public boolean isAcceptNotify;
    public MsglistActivity<?> mActivity;
    public dr4 mAntiDialog;
    public final CustomMessageListener mCustomListenerInMessageCenter;
    public MsgPageData mDatas;
    public String mDraft;
    public long mId;
    public AntiHelper.k mInjectListener;
    public CustomMessageListener mListenerUnLogin;
    public v77 mSendCallback;

    /* loaded from: classes3.dex */
    public static class CacheInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int customGroupType;
        public String id;

        public CacheInfo() {
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
    }

    /* loaded from: classes3.dex */
    public class CompareChatMessage implements Comparator<ChatMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsglistModel this$0;

        public CompareChatMessage(MsglistModel msglistModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msglistModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = msglistModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(ChatMessage chatMessage, ChatMessage chatMessage2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, chatMessage, chatMessage2)) == null) {
                if (chatMessage != null && chatMessage2 != null) {
                    if (chatMessage.getRecordId() > chatMessage2.getRecordId()) {
                        return 1;
                    }
                    if (chatMessage.getRecordId() < chatMessage2.getRecordId()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    public MsglistModel() {
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
        this.DURATION_TIME_OUT = 1800;
        this.isAcceptNotify = true;
        this.mDatas = null;
        this.mInjectListener = new AntiHelper.k(this) { // from class: com.baidu.tieba.im.model.MsglistModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsglistModel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onNavigationButtonClick(dr4 dr4Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dr4Var) == null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onPositiveButtonClick(dr4 dr4Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dr4Var) == null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                }
            }
        };
        this.mCustomListenerInMessageCenter = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.MsglistModel.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsglistModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    if (customResponsedMessage.getCmd() == 2001110) {
                        this.this$0.refreshAfterClearHistory();
                    } else if (customResponsedMessage.getCmd() == 501126 && (customResponsedMessage instanceof ResponsedMessage)) {
                        this.this$0.mDatas.getChatMessages().add((ChatMessage) customResponsedMessage.getOrginalMessage());
                        if (this.this$0.mLoadDataCallBack != null) {
                            this.this$0.mLoadDataCallBack.c(this.this$0.mDatas);
                        }
                    }
                }
            }
        };
        this.mListenerUnLogin = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.MsglistModel.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsglistModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseUnLoginMessage)) {
                    this.this$0.mLoadDataMode = 11;
                    if (this.this$0.mLoadDataCallBack != null) {
                        this.this$0.mLoadDataCallBack.c(null);
                    }
                }
            }
        };
    }

    private String buildBigEmotionContent(ax4 ax4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, ax4Var)) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pid", ax4Var.d());
                jSONObject.put("packet_name", ax4Var.e());
                jSONObject.put("face_name", ax4Var.c());
                jSONObject.put("size_width", ax4Var.g());
                jSONObject.put("size_height", ax4Var.b());
                jSONArray.put(jSONObject);
                return jSONArray.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String createMsgLog(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, chatMessage)) == null) {
            if (chatMessage == null) {
                return "";
            }
            int msgType = chatMessage.getMsgType();
            String string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1553);
            if (msgType == 1) {
                return string + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0a4c);
            } else if (msgType == 2) {
                return string + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0522);
            } else if (msgType == 3) {
                return string + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0ae2);
            } else if (msgType != 9) {
                return "";
            } else {
                return string + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0a4b);
            }
        }
        return (String) invokeL.objValue;
    }

    private void delRepeatMsg(List<ChatMessage> list, List<ChatMessage> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, this, list, list2) == null) || list == null || list2 == null) {
            return;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size2 == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = size - 1; i >= 0 && i >= 0; i--) {
            ChatMessage chatMessage = list.get(i);
            if (chatMessage != null && chatMessage.getUserInfo() != null && !TextUtils.isEmpty(chatMessage.getUserInfo().getUserId()) && chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) && chatMessage.getLocalData() != null && (chatMessage.getLocalData().getStatus().shortValue() != 3 || chatMessage.getMsgType() == 4)) {
                int i2 = size2 - 1;
                while (true) {
                    if (i2 >= 0 && i2 >= 0) {
                        ChatMessage chatMessage2 = list2.get(i2);
                        if (chatMessage2 != null && chatMessage2.getUserInfo() != null && !TextUtils.isEmpty(chatMessage2.getUserInfo().getUserId()) && chatMessage2.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) && chatMessage2.getRecordId() == chatMessage.getRecordId()) {
                            arrayList.add(chatMessage);
                            break;
                        }
                        i2--;
                    }
                }
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            list.remove(arrayList.get(i3));
        }
        arrayList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendPic(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, this, chatMessage, str) == null) || chatMessage == null) {
            return;
        }
        if (chatMessage.getContent() == null) {
            sendMsgFail(chatMessage);
        }
        if (str == null) {
            try {
                str = new JSONArray(chatMessage.getContent()).getJSONObject(0).optString("src");
            } catch (Exception e) {
                e.printStackTrace();
                sendMsgFail(chatMessage);
                return;
            }
        }
        if (str == null) {
            sendMsgFail(chatMessage);
            return;
        }
        chatMessage.setProgressValue(0);
        chatMessage.setIsUploading(true);
        if (str.startsWith("http")) {
            s77.j().t(chatMessage);
        } else {
            s77.j().y(chatMessage, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendVoice(ChatMessage chatMessage) {
        VoiceMsgData n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, chatMessage) == null) || (n = x87.n(chatMessage)) == null) {
            return;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        s77.m(chatMessage);
        s77.j().z(n, chatMessage);
    }

    private ChatMessage findMaxMsgIdMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            MsgPageData msgPageData = this.mDatas;
            ChatMessage chatMessage = null;
            if (msgPageData != null && msgPageData.getChatMessages() != null && this.mDatas.getChatMessages().size() != 0) {
                for (ChatMessage chatMessage2 : this.mDatas.getChatMessages()) {
                    if (chatMessage == null || chatMessage2.getMsgId() > chatMessage.getMsgId()) {
                        chatMessage = chatMessage2;
                    }
                }
            }
            return chatMessage;
        }
        return (ChatMessage) invokeV.objValue;
    }

    private int mergeList(List<ChatMessage> list, List<ChatMessage> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, list, list2)) == null) {
            if (list == null || list2 == null) {
                return 0;
            }
            int size = list.size();
            int size2 = list2.size();
            if (size2 == 0) {
                return 0;
            }
            if (size == 0) {
                list.addAll(list2);
                return size2;
            }
            int i = size - 1;
            int i2 = size2 - 1;
            int i3 = 0;
            while (i >= 0 && i2 >= 0) {
                long recordId = list.get(i).getRecordId();
                ChatMessage chatMessage = list2.get(i2);
                int i4 = (recordId > chatMessage.getRecordId() ? 1 : (recordId == chatMessage.getRecordId() ? 0 : -1));
                if (i4 > 0) {
                    i--;
                } else if (i4 < 0) {
                    list.add(i + 1, chatMessage);
                    i2--;
                    i3++;
                } else {
                    i--;
                    i2--;
                }
            }
            if (i2 >= 0) {
                while (i2 >= 0) {
                    list.add(0, list2.get(i2));
                    i3++;
                    i2--;
                }
            }
            return i3;
        }
        return invokeLL.intValue;
    }

    private void processDeleteMsg(int i, int i2) {
        CacheInfo cacheInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65552, this, i, i2) == null) {
            int size = this.mDatas.getChatMessages().size();
            if (i2 >= 0 && i2 < size) {
                ChatMessage chatMessage = this.mDatas.getChatMessages().get(i2);
                if (i == 1) {
                    deleteMsg(chatMessage);
                } else if (i == 2) {
                    markDeleteMsg(chatMessage);
                }
                int i3 = i2 - 1;
                ChatMessage chatMessage2 = i3 >= 0 ? this.mDatas.getChatMessages().get(i3) : null;
                markDeleteMsg(chatMessage);
                this.mDatas.getChatMessages().remove(i2);
                if (i2 == size - 1 && (cacheInfo = getCacheInfo()) != null) {
                    MemoryModifyLastMsgMessage.a aVar = new MemoryModifyLastMsgMessage.a();
                    aVar.b = cacheInfo.customGroupType;
                    aVar.a = cacheInfo.id;
                    aVar.c = chatMessage2;
                    aVar.d = 2;
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryModifyLastMsgMessage(aVar));
                }
            }
            this.mLoadDataMode = 7;
            a9 a9Var = this.mLoadDataCallBack;
            if (a9Var != null) {
                a9Var.c(null);
            }
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            registerListener(2001153, this.mListenerUnLogin);
            registerListener(2001110, this.mCustomListenerInMessageCenter);
            registerListener(501126, this.mCustomListenerInMessageCenter);
        }
    }

    private void sendMsgSuc(ResponseCommitMessage responseCommitMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, responseCommitMessage) == null) || responseCommitMessage == null) {
            return;
        }
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        long recordId = responseCommitMessage.getRecordId();
        long msgId = responseCommitMessage.getMsgId();
        this.mDatas.setNewAddNum(0);
        this.mDatas.setIsNewAdd(false);
        int size = chatMessages.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (recordId == chatMessages.get(size).getRecordId()) {
                ChatMessage chatMessage = chatMessages.get(size);
                if (chatMessage.getLocalData() == null) {
                    MsgLocalData msgLocalData = new MsgLocalData();
                    msgLocalData.setStatus((short) 1);
                    msgLocalData.setErrno(0L);
                    msgLocalData.setRetry(0L);
                    msgLocalData.setUpload_offset(null);
                    chatMessage.setLocalData(msgLocalData);
                }
                chatMessage.setMsgId(msgId);
                chatMessage.getLocalData().setStatus((short) 3);
            } else {
                size--;
            }
        }
        this.mLoadDataMode = 5;
        a9 a9Var = this.mLoadDataCallBack;
        if (a9Var != null) {
            a9Var.c(this.mDatas);
        }
        v77 v77Var = this.mSendCallback;
        if (v77Var != null) {
            v77Var.a(0);
        }
    }

    private void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mListenerUnLogin);
            MessageManager.getInstance().unRegisterListener(this.mCustomListenerInMessageCenter);
        }
    }

    private void updateMsgStatusTimeOut(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        for (ChatMessage chatMessage : list) {
            if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 1) {
                chatMessage.setCustomGroupType(this.customGroupType);
                if ((System.currentTimeMillis() / 1000) - chatMessage.getTime() > DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) {
                    chatMessage.getLocalData().setStatus((short) 2);
                } else if (!(MessageManager.getInstance().getSocketClient() != null ? MessageManager.getInstance().getSocketClient().n(chatMessage) : false) && (chatMessage.getMsgType() != 2 || !s77.j().g(chatMessage))) {
                    if (chatMessage.getMsgType() != 3 || !s77.j().h(chatMessage)) {
                        chatMessage.getLocalData().setStatus((short) 2);
                    }
                }
            }
        }
    }

    private void updatePortraintAndNetWork(List<ChatMessage> list) {
        MsglistActivity<?> msglistActivity;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, list) == null) || list == null || (msglistActivity = this.mActivity) == null) {
            return;
        }
        int i2 = -1;
        if (msglistActivity.getListView() != null) {
            i2 = this.mActivity.getListView().getFirstVisiblePosition();
            i = this.mActivity.getListView().getLastVisiblePosition();
        } else {
            i = -1;
        }
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        int size = chatMessages.size();
        if (i2 < 0 || i >= size) {
            return;
        }
        for (ChatMessage chatMessage : list) {
            if (chatMessage.getMsgType() == 4) {
                d57.a = jc5.e();
            }
            long userId = chatMessage.getUserId();
            String portrait = chatMessage.getUserInfo().getPortrait();
            for (int i3 = i2; i3 <= i; i3++) {
                ChatMessage chatMessage2 = chatMessages.get(i3);
                if (chatMessage2 == null) {
                    return;
                }
                if (userId == chatMessage2.getUserId()) {
                    if (chatMessage2.getUserInfo() == null) {
                        return;
                    }
                    String portrait2 = chatMessage2.getUserInfo().getPortrait();
                    if (portrait != null && !portrait.equals(portrait2)) {
                        chatMessage2.getUserInfo().setPortrait(portrait);
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public ChatMessage createMessage(short s, String str) {
        InterceptResult invokeCommon;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Short.valueOf(s), str})) == null) {
            ChatMessage genChatMessage = genChatMessage();
            if (genChatMessage == null) {
                return null;
            }
            genChatMessage.setCustomGroupType(this.customGroupType);
            genChatMessage.setMsgType(s);
            genChatMessage.setContent(str);
            long b = w87.b(getLastMid());
            genChatMessage.setMsgId(b);
            genChatMessage.setRecordId(b);
            genChatMessage.setTime(System.currentTimeMillis() / 1000);
            UserData userData = new UserData();
            userData.setUserName(TbadkCoreApplication.getCurrentAccountName());
            userData.setUserId(TbadkCoreApplication.getCurrentAccount());
            userData.setName_show(TbadkCoreApplication.getCurrentAccountNameShow());
            userData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            genChatMessage.setUserInfo(userData);
            try {
                j = mg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            } catch (Exception unused) {
                j = 0;
            }
            genChatMessage.setUserId(j);
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            genChatMessage.setLocalData(msgLocalData);
            return genChatMessage;
        }
        return (ChatMessage) invokeCommon.objValue;
    }

    public void deleteMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            processDeleteMsg(1, i);
        }
    }

    public abstract void deleteMsg(ChatMessage chatMessage);

    public void doSendText(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatMessage) == null) {
            s77.j().t(chatMessage);
        }
    }

    public abstract ChatMessage genChatMessage();

    public abstract CacheInfo getCacheInfo();

    public MsgPageData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mDatas : (MsgPageData) invokeV.objValue;
    }

    public String getDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mDraft : (String) invokeV.objValue;
    }

    public boolean getIsAcceptNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isAcceptNotify : invokeV.booleanValue;
    }

    public long getLastMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
            if (chatMessages != null && chatMessages.size() > 0) {
                return chatMessages.get(chatMessages.size() - 1).getMsgId();
            }
            return getMaxMid();
        }
        return invokeV.longValue;
    }

    public abstract long getMaxMid();

    public ChatMessage getMsg(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            MsgPageData msgPageData = this.mDatas;
            if (msgPageData == null || msgPageData.getChatMessages() == null || i < 0 || i >= this.mDatas.getChatMessages().size()) {
                return null;
            }
            return this.mDatas.getChatMessages().get(i);
        }
        return (ChatMessage) invokeI.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean loadDraft();

    public abstract boolean loadFirst(y47 y47Var);

    public abstract boolean loadPrepage();

    public void markDeleteMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            processDeleteMsg(2, i);
        }
    }

    public abstract void markDeleteMsg(ChatMessage chatMessage);

    public boolean onAfterLoadFromDb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean onAfterProcessMsgFromServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.mAntiDialog = null;
            s77.j().v(null);
            unRegisterListener();
        }
    }

    public void processDraft(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, customResponsedMessage) == null) && (customResponsedMessage instanceof LoadDraftResponsedMessage)) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = (LoadDraftResponsedMessage) customResponsedMessage;
            if (loadDraftResponsedMessage.getData() == null) {
                return;
            }
            String str = loadDraftResponsedMessage.getData().a;
            this.mLoadDataMode = 8;
            a9 a9Var = this.mLoadDataCallBack;
            if (a9Var != null) {
                a9Var.c(str);
            }
        }
    }

    public boolean processHistory(CustomResponsedMessage<?> customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, customResponsedMessage)) == null) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
                LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
                if (loadHistoryResponsedMessage.getData() == null) {
                    return true;
                }
                long j = this.mId;
                if (j == 0 || j == mg.g(loadHistoryResponsedMessage.getData().a, 0L)) {
                    List<ChatMessage> list = loadHistoryResponsedMessage.getData().b;
                    boolean z = loadHistoryResponsedMessage.getData().c;
                    int mergeList = mergeList(this.mDatas.getChatMessages(), list);
                    if (mergeList > 0) {
                        this.mDatas.setIsNewAdd(true);
                        this.mDatas.setNewAddNum(mergeList);
                    } else {
                        this.mDatas.setIsNewAdd(false);
                        this.mDatas.setNewAddNum(0);
                    }
                    updateMsgStatusTimeOut(this.mDatas.getChatMessages());
                    onAfterLoadFromDb();
                    if (z) {
                        if (this.mDatas.getIsNewAdd()) {
                            this.mLoadDataMode = 1;
                            a9 a9Var = this.mLoadDataCallBack;
                            if (a9Var != null) {
                                a9Var.c(null);
                            }
                        }
                        return true;
                    }
                    if (this.mDatas.getIsNewAdd()) {
                        this.mLoadDataMode = 2;
                        a9 a9Var2 = this.mLoadDataCallBack;
                        if (a9Var2 != null) {
                            a9Var2.c(null);
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void processMsgACK(ResponseCommitMessage responseCommitMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, responseCommitMessage) == null) || responseCommitMessage == null || responseCommitMessage.getOrginalMessage() == null || !(responseCommitMessage.getOrginalMessage() instanceof ChatMessage)) {
            return;
        }
        ChatMessage chatMessage = (ChatMessage) responseCommitMessage.getOrginalMessage();
        if (responseCommitMessage.getError() != 0) {
            z35.c(responseCommitMessage.getCmd(), 0, 0, 0, 13, MessageManager.getInstance().getSocketClient().u() ? 1 : 2);
            long recordId = chatMessage.getRecordId();
            String createMsgLog = createMsgLog(chatMessage);
            long clientLogID = chatMessage.getClientLogID();
            int cmd = responseCommitMessage.getCmd();
            int error = responseCommitMessage.getError();
            String errorString = responseCommitMessage.getErrorString();
            lt4.a("im", clientLogID, cmd, IMTrackDatabase.AckEnum.TABLE_NAME, error, errorString, "comment", createMsgLog + "rid" + recordId);
            if (responseCommitMessage.getError() > 0) {
                if (AntiHelper.m(responseCommitMessage.getError(), responseCommitMessage.getErrorString())) {
                    dr4 dr4Var = this.mAntiDialog;
                    if (dr4Var != null) {
                        if (!dr4Var.isShowing()) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                            this.mAntiDialog.show();
                        }
                    } else {
                        dr4 t = AntiHelper.t(this.mActivity.getActivity(), responseCommitMessage.getBlockPopInfoData(), this.mInjectListener);
                        this.mAntiDialog = t;
                        if (t != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                        }
                    }
                } else if (responseCommitMessage.getError() != 3160008 && responseCommitMessage.getError() != 3100001) {
                    this.mActivity.showToast(responseCommitMessage.getErrorString());
                    if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
                        responseCommitMessage.setRecordId(chatMessage.getRecordId());
                        lt4.a("im", chatMessage.getClientLogID(), responseCommitMessage.getCmd(), IMTrackDatabase.AckEnum.TABLE_NAME, responseCommitMessage.getError(), responseCommitMessage.getErrorString(), "comment", "orgRId != sRId");
                    }
                }
            }
            sendMsgFail(chatMessage);
            return;
        }
        if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
            responseCommitMessage.setRecordId(chatMessage.getRecordId());
            lt4.a("im", chatMessage.getClientLogID(), responseCommitMessage.getCmd(), IMTrackDatabase.AckEnum.TABLE_NAME, responseCommitMessage.getError(), responseCommitMessage.getErrorString(), "comment", "orgRId != sRId");
        }
        sendMsgSuc(responseCommitMessage);
    }

    public List<ChatMessage> processMsgFromServerCommon(List<ChatMessage> list) {
        InterceptResult invokeL;
        ChatMessage chatMessage;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, list)) == null) {
            updatePortraintAndNetWork(list);
            delRepeatMsg(this.mDatas.getChatMessages(), list);
            Collections.sort(list, new CompareChatMessage());
            boolean z = (list == null || list.isEmpty() || (chatMessage = list.get(list.size() - 1)) == null || (valueOf = String.valueOf(chatMessage.getUserId())) == null || !valueOf.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            int mergeList = mergeList(this.mDatas.getChatMessages(), list);
            boolean onAfterProcessMsgFromServer = onAfterProcessMsgFromServer();
            if (mergeList <= 0 && !onAfterProcessMsgFromServer) {
                this.mDatas.setIsNewAdd(false);
                this.mDatas.setNewAddNum(0);
            } else {
                this.mDatas.setIsNewAdd(true);
                this.mDatas.setNewAddNum(mergeList);
                if (!z) {
                    this.mLoadDataMode = 3;
                }
                a9 a9Var = this.mLoadDataCallBack;
                if (a9Var != null) {
                    a9Var.c(this.mDatas);
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public void reSendMsg(int i) {
        ChatMessage msg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i) == null) || (msg = getMsg(i)) == null || msg.getLocalData() == null || msg.getLocalData().getStatus() == null || msg.getLocalData().getStatus().shortValue() != 2) {
            return;
        }
        msg.setRecordId(msg.getMsgId());
        msg.getLocalData().setStatus((short) 1);
        msg.setTime(System.currentTimeMillis() / 1000);
        msg.setCustomGroupType(this.customGroupType);
        int msgType = msg.getMsgType();
        if (msgType == 1) {
            doSendText(msg);
        } else if (msgType == 2) {
            doSendPic(msg, null);
        } else if (msgType == 3) {
            doSendVoice(msg);
        } else if (msgType == 4) {
            doSendText(msg);
        } else if (msgType == 9) {
            doSendText(msg);
        }
        this.mLoadDataMode = 6;
        a9 a9Var = this.mLoadDataCallBack;
        if (a9Var != null) {
            a9Var.c(this.mDatas);
        }
        updateMsgResend(i, msg);
    }

    public void refreshAfterClearHistory() {
        MsgPageData msgPageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (msgPageData = this.mDatas) == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0) {
            return;
        }
        ChatMessage findMaxMsgIdMessage = findMaxMsgIdMessage();
        if (findMaxMsgIdMessage != null && x87.p(findMaxMsgIdMessage)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016020, findMaxMsgIdMessage));
        }
        this.mDatas.getChatMessages().clear();
        this.mLoadDataMode = 12;
        a9 a9Var = this.mLoadDataCallBack;
        if (a9Var != null) {
            a9Var.c(null);
        }
    }

    public boolean saveDraft(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            String str2 = this.mDraft;
            if (str2 == null || !str2.equals(str)) {
                return saveDraftContent(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract boolean saveDraftContent(String str);

    public void sendBigEmotionMessage(ax4 ax4Var) {
        String buildBigEmotionContent;
        ChatMessage createMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, ax4Var) == null) || (buildBigEmotionContent = buildBigEmotionContent(ax4Var)) == null || (createMessage = createMessage((short) 4, buildBigEmotionContent)) == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        a9 a9Var = this.mLoadDataCallBack;
        if (a9Var != null) {
            a9Var.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void sendExtraMessage(String str) {
        ChatMessage createMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || (createMessage = createMessage((short) 9, str)) == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        a9 a9Var = this.mLoadDataCallBack;
        if (a9Var != null) {
            a9Var.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void sendMsgFail(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, chatMessage) == null) || chatMessage == null) {
            return;
        }
        chatMessage.setIsUploading(false);
        if (chatMessage.getLocalData() == null) {
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            chatMessage.setLocalData(msgLocalData);
        }
        chatMessage.getLocalData().setStatus((short) 2);
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        if (chatMessages == null || chatMessages.size() == 0) {
            return;
        }
        long recordId = chatMessage.getRecordId();
        int size = chatMessages.size() - 1;
        while (size >= 0 && chatMessages.get(size).getMsgId() != recordId) {
            size--;
        }
        if (size >= 0) {
            chatMessages.remove(size);
            chatMessages.add(size, chatMessage);
            this.mDatas.setNewAddNum(0);
            this.mDatas.setIsNewAdd(false);
            this.mLoadDataMode = 5;
            a9 a9Var = this.mLoadDataCallBack;
            if (a9Var != null) {
                a9Var.c(this.mDatas);
            }
        }
    }

    public void sendMsgVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, str, i) == null) {
            VoiceMsgData voiceMsgData = new VoiceMsgData();
            voiceMsgData.setDuring_time(i);
            voiceMsgData.setVoice_md5(str);
            voiceMsgData.setHas_read(0);
            String jsonStrWithObject = OrmObject.jsonStrWithObject(voiceMsgData);
            ChatMessage createMessage = createMessage((short) 3, PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
            if (createMessage == null) {
                return;
            }
            createMessage.setCacheData(null);
            this.mDatas.getChatMessages().add(createMessage);
            this.mLoadDataMode = 4;
            a9 a9Var = this.mLoadDataCallBack;
            if (a9Var != null) {
                a9Var.c(this.mDatas);
            }
            if (createMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) createMessage;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                dd5.c(new ad5<Boolean>(this, commonGroupChatMessage, linkedList) { // from class: com.baidu.tieba.im.model.MsglistModel.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MsglistModel this$0;
                    public final /* synthetic */ CommonGroupChatMessage val$groupMsg;
                    public final /* synthetic */ LinkedList val$list;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, commonGroupChatMessage, linkedList};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$groupMsg = commonGroupChatMessage;
                        this.val$list = linkedList;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.repackage.ad5
                    public Boolean doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(c67.h().l(this.val$groupMsg.getGroupId(), this.val$list, false)) : (Boolean) invokeV.objValue;
                    }
                }, new ic5<Boolean>(this, commonGroupChatMessage) { // from class: com.baidu.tieba.im.model.MsglistModel.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MsglistModel this$0;
                    public final /* synthetic */ CommonGroupChatMessage val$groupMsg;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, commonGroupChatMessage};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$groupMsg = commonGroupChatMessage;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.repackage.ic5
                    public void onReturnDataInUI(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            this.this$0.doSendVoice(this.val$groupMsg);
                        }
                    }
                });
            } else if (createMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) createMessage;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(personalChatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                dd5.c(new ad5<Boolean>(this, personalChatMessage, linkedList2) { // from class: com.baidu.tieba.im.model.MsglistModel.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MsglistModel this$0;
                    public final /* synthetic */ LinkedList val$list;
                    public final /* synthetic */ PersonalChatMessage val$personalMsg;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, personalChatMessage, linkedList2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$personalMsg = personalChatMessage;
                        this.val$list = linkedList2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.repackage.ad5
                    public Boolean doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(m67.t().m(x87.m(this.val$personalMsg), this.val$list, false)) : (Boolean) invokeV.objValue;
                    }
                }, new ic5<Boolean>(this, personalChatMessage) { // from class: com.baidu.tieba.im.model.MsglistModel.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MsglistModel this$0;
                    public final /* synthetic */ PersonalChatMessage val$personalMsg;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, personalChatMessage};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$personalMsg = personalChatMessage;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.repackage.ic5
                    public void onReturnDataInUI(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            this.this$0.doSendVoice(this.val$personalMsg);
                        }
                    }
                });
            } else if (createMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) createMessage;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(officialChatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                dd5.c(new ad5<Boolean>(this, officialChatMessage, linkedList3) { // from class: com.baidu.tieba.im.model.MsglistModel.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MsglistModel this$0;
                    public final /* synthetic */ LinkedList val$list;
                    public final /* synthetic */ OfficialChatMessage val$personalMsg;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, officialChatMessage, linkedList3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$personalMsg = officialChatMessage;
                        this.val$list = linkedList3;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.repackage.ad5
                    public Boolean doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(l67.t().m(x87.m(this.val$personalMsg), this.val$list, false)) : (Boolean) invokeV.objValue;
                    }
                }, new ic5<Boolean>(this, officialChatMessage) { // from class: com.baidu.tieba.im.model.MsglistModel.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MsglistModel this$0;
                    public final /* synthetic */ OfficialChatMessage val$personalMsg;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, officialChatMessage};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$personalMsg = officialChatMessage;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.repackage.ic5
                    public void onReturnDataInUI(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            this.this$0.doSendVoice(this.val$personalMsg);
                        }
                    }
                });
            }
        }
    }

    public void sendPicMessage(String str, Bitmap bitmap) {
        ChatMessage createMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048610, this, str, bitmap) == null) || bitmap == null || (createMessage = createMessage((short) 2, s77.f(str, str, bitmap.getWidth(), bitmap.getHeight()))) == null) {
            return;
        }
        createMessage.setIsUploading(true);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        createMessage.setWidth(width);
        createMessage.setHeight(height);
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        a9 a9Var = this.mLoadDataCallBack;
        if (a9Var != null) {
            a9Var.c(this.mDatas);
        }
        if (createMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) createMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            dd5.c(new ad5<Boolean>(this, commonGroupChatMessage, linkedList) { // from class: com.baidu.tieba.im.model.MsglistModel.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MsglistModel this$0;
                public final /* synthetic */ CommonGroupChatMessage val$groupMsg;
                public final /* synthetic */ LinkedList val$list;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, commonGroupChatMessage, linkedList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$groupMsg = commonGroupChatMessage;
                    this.val$list = linkedList;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.repackage.ad5
                public Boolean doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(c67.h().l(this.val$groupMsg.getGroupId(), this.val$list, false)) : (Boolean) invokeV.objValue;
                }
            }, new ic5<Boolean>(this, commonGroupChatMessage, str) { // from class: com.baidu.tieba.im.model.MsglistModel.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MsglistModel this$0;
                public final /* synthetic */ CommonGroupChatMessage val$groupMsg;
                public final /* synthetic */ String val$localFilePath;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, commonGroupChatMessage, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$groupMsg = commonGroupChatMessage;
                    this.val$localFilePath = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.repackage.ic5
                public void onReturnDataInUI(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        this.this$0.doSendPic(this.val$groupMsg, this.val$localFilePath);
                    }
                }
            });
        } else if (createMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) createMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(personalChatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            dd5.c(new ad5<Boolean>(this, personalChatMessage, linkedList2) { // from class: com.baidu.tieba.im.model.MsglistModel.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MsglistModel this$0;
                public final /* synthetic */ PersonalChatMessage val$groupMsg;
                public final /* synthetic */ LinkedList val$list;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, personalChatMessage, linkedList2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$groupMsg = personalChatMessage;
                    this.val$list = linkedList2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.repackage.ad5
                public Boolean doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(m67.t().m(x87.m(this.val$groupMsg), this.val$list, false)) : (Boolean) invokeV.objValue;
                }
            }, new ic5<Boolean>(this, personalChatMessage, str) { // from class: com.baidu.tieba.im.model.MsglistModel.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MsglistModel this$0;
                public final /* synthetic */ PersonalChatMessage val$groupMsg;
                public final /* synthetic */ String val$localFilePath;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, personalChatMessage, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$groupMsg = personalChatMessage;
                    this.val$localFilePath = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.repackage.ic5
                public void onReturnDataInUI(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        this.this$0.doSendPic(this.val$groupMsg, this.val$localFilePath);
                    }
                }
            });
        } else if (createMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) createMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(officialChatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            dd5.c(new ad5<Boolean>(this, officialChatMessage, linkedList3) { // from class: com.baidu.tieba.im.model.MsglistModel.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MsglistModel this$0;
                public final /* synthetic */ OfficialChatMessage val$groupMsg;
                public final /* synthetic */ LinkedList val$list;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, officialChatMessage, linkedList3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$groupMsg = officialChatMessage;
                    this.val$list = linkedList3;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.repackage.ad5
                public Boolean doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(l67.t().m(x87.m(this.val$groupMsg), this.val$list, false)) : (Boolean) invokeV.objValue;
                }
            }, new ic5<Boolean>(this, officialChatMessage, str) { // from class: com.baidu.tieba.im.model.MsglistModel.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MsglistModel this$0;
                public final /* synthetic */ OfficialChatMessage val$groupMsg;
                public final /* synthetic */ String val$localFilePath;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, officialChatMessage, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$groupMsg = officialChatMessage;
                    this.val$localFilePath = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.repackage.ic5
                public void onReturnDataInUI(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        this.this$0.doSendPic(this.val$groupMsg, this.val$localFilePath);
                    }
                }
            });
        }
    }

    public void sendReplyCardMessage(String str) {
        ChatMessage createMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, str) == null) || (createMessage = createMessage((short) 23, str)) == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        a9 a9Var = this.mLoadDataCallBack;
        if (a9Var != null) {
            a9Var.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void sendTextMessage(String str) {
        ChatMessage createMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || (createMessage = createMessage((short) 1, str)) == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        a9 a9Var = this.mLoadDataCallBack;
        if (a9Var != null) {
            a9Var.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void setDraft(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.mDraft = str;
        }
    }

    public void setImageUploadUIProgressCallback(j35.b<ChatMessage> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bVar) == null) {
            s77.j().u(bVar);
        }
    }

    public void setIsAcceptNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.isAcceptNotify = z;
        }
    }

    public void setSendCallback(v77 v77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, v77Var) == null) {
            this.mSendCallback = v77Var;
            s77.j().v(v77Var);
        }
    }

    public void updateMsgResend(int i, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048617, this, i, chatMessage) == null) {
            List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
            int size = chatMessages.size();
            if (i < 0 || i >= size) {
                return;
            }
            chatMessages.remove(i);
            chatMessages.add(i, chatMessage);
            this.mDatas.setIsNewAdd(false);
            this.mDatas.setNewAddNum(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsglistModel(MsglistActivity<Object> msglistActivity) {
        super(msglistActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.DURATION_TIME_OUT = 1800;
        this.isAcceptNotify = true;
        this.mDatas = null;
        this.mInjectListener = new AntiHelper.k(this) { // from class: com.baidu.tieba.im.model.MsglistModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsglistModel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onNavigationButtonClick(dr4 dr4Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dr4Var) == null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onPositiveButtonClick(dr4 dr4Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dr4Var) == null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                }
            }
        };
        this.mCustomListenerInMessageCenter = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.MsglistModel.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsglistModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    if (customResponsedMessage.getCmd() == 2001110) {
                        this.this$0.refreshAfterClearHistory();
                    } else if (customResponsedMessage.getCmd() == 501126 && (customResponsedMessage instanceof ResponsedMessage)) {
                        this.this$0.mDatas.getChatMessages().add((ChatMessage) customResponsedMessage.getOrginalMessage());
                        if (this.this$0.mLoadDataCallBack != null) {
                            this.this$0.mLoadDataCallBack.c(this.this$0.mDatas);
                        }
                    }
                }
            }
        };
        this.mListenerUnLogin = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.MsglistModel.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsglistModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseUnLoginMessage)) {
                    this.this$0.mLoadDataMode = 11;
                    if (this.this$0.mLoadDataCallBack != null) {
                        this.this$0.mLoadDataCallBack.c(null);
                    }
                }
            }
        };
        this.mActivity = msglistActivity;
        this.mDatas = new MsgPageData();
        registerListener();
    }
}
