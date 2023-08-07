package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.ImShareCardCommonData;
import com.baidu.tieba.R;
import com.baidu.tieba.ca8;
import com.baidu.tieba.ed8;
import com.baidu.tieba.h9;
import com.baidu.tieba.hc8;
import com.baidu.tieba.hd8;
import com.baidu.tieba.hm5;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GamePlayOrderMsgData;
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
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.jw5;
import com.baidu.tieba.m45;
import com.baidu.tieba.nc5;
import com.baidu.tieba.nw5;
import com.baidu.tieba.ov5;
import com.baidu.tieba.pv5;
import com.baidu.tieba.sl5;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.te8;
import com.baidu.tieba.ue8;
import com.baidu.tieba.w98;
import com.baidu.tieba.xb8;
import com.baidu.tieba.yb8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class MsglistModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GAME_SHARE_COUNT_OVER = 3100001;
    public static final int MODE_TYPE_CHAT_ROOM_RULE = 14;
    public static final int MODE_TYPE_CLEAR_HISTORY = 13;
    public static final int MODE_TYPE_DELETE_MSG = 8;
    public static final int MODE_TYPE_FIRST_GET_MSGS = 1;
    public static final int MODE_TYPE_INSERT_REPLY_CARD = 15;
    public static final int MODE_TYPE_LOAD_DRAFT = 9;
    public static final int MODE_TYPE_NAME_UPDATE = 11;
    public static final int MODE_TYPE_PRE = 2;
    public static final int MODE_TYPE_PUSH = 3;
    public static final int MODE_TYPE_QUIT_GROUP = 10;
    public static final int MODE_TYPE_RESEND = 7;
    public static final int MODE_TYPE_SENDING = 4;
    public static final int MODE_TYPE_SEND_FAIL = 6;
    public static final int MODE_TYPE_SEND_SUCCESS = 5;
    public static final int MODE_TYPE_UNLOGIN = 12;
    public static final int NOT_FRIEND_ERROR = 3160008;
    public static final int TYPE_DELETE_FAIL_MSG = 1;
    public static final int TYPE_DELETE_SUC_MSG = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int DURATION_TIME_OUT;
    public int customGroupType;
    public boolean isAcceptNotify;
    public MsglistActivity<?> mActivity;
    public m45 mAntiDialog;
    public final CustomMessageListener mCustomListenerInMessageCenter;
    public MsgPageData mDatas;
    public String mDraft;
    public long mId;
    public AntiHelper.k mInjectListener;
    public CustomMessageListener mListenerUnLogin;
    public hd8 mSendCallback;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void deleteMsg(ChatMessage chatMessage);

    public abstract ChatMessage genChatMessage();

    public abstract CacheInfo getCacheInfo();

    public abstract long getMaxMid();

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean loadDraft();

    public abstract boolean loadFirst(w98 w98Var);

    public abstract boolean loadPrepage();

    public abstract void markDeleteMsg(ChatMessage chatMessage);

    public boolean onAfterLoadFromDb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean onAfterProcessMsgFromServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean saveDraftContent(String str);

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            public void onNavigationButtonClick(m45 m45Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, m45Var) == null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onPositiveButtonClick(m45 m45Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m45Var) == null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                }
            }
        };
        this.mCustomListenerInMessageCenter = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.MsglistModel.10
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
                    } else if (customResponsedMessage.getCmd() == 501126) {
                        if (!(customResponsedMessage instanceof ResponsedMessage)) {
                            return;
                        }
                        this.this$0.mDatas.getChatMessages().add((ChatMessage) customResponsedMessage.getOrginalMessage());
                        if (this.this$0.mLoadDataCallBack != null) {
                            this.this$0.mLoadDataCallBack.c(this.this$0.mDatas);
                        }
                    } else if (customResponsedMessage.getCmd() == 2921693) {
                        int findUEGPersonMsg = this.this$0.findUEGPersonMsg((CommonMsgPojo) customResponsedMessage.getData());
                        if (findUEGPersonMsg >= 0) {
                            this.this$0.mDatas.getChatMessages().remove(findUEGPersonMsg);
                            this.this$0.mLoadDataMode = 8;
                            if (this.this$0.mLoadDataCallBack != null) {
                                this.this$0.mLoadDataCallBack.c(null);
                            }
                        }
                    }
                }
            }
        };
        this.mListenerUnLogin = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.MsglistModel.11
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
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponseUnLoginMessage)) {
                    return;
                }
                this.this$0.mLoadDataMode = 12;
                if (this.this$0.mLoadDataCallBack != null) {
                    this.this$0.mLoadDataCallBack.c(null);
                }
            }
        };
    }

    public long getLastMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
            if (chatMessages != null && chatMessages.size() > 0) {
                return chatMessages.get(chatMessages.size() - 1).getMsgId();
            }
            return getMaxMid();
        }
        return invokeV.longValue;
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
                super((BdPageContext) newInitContext.callArgs[0]);
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
            public void onNavigationButtonClick(m45 m45Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, m45Var) == null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onPositiveButtonClick(m45 m45Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m45Var) == null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                }
            }
        };
        this.mCustomListenerInMessageCenter = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.MsglistModel.10
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
                    } else if (customResponsedMessage.getCmd() == 501126) {
                        if (!(customResponsedMessage instanceof ResponsedMessage)) {
                            return;
                        }
                        this.this$0.mDatas.getChatMessages().add((ChatMessage) customResponsedMessage.getOrginalMessage());
                        if (this.this$0.mLoadDataCallBack != null) {
                            this.this$0.mLoadDataCallBack.c(this.this$0.mDatas);
                        }
                    } else if (customResponsedMessage.getCmd() == 2921693) {
                        int findUEGPersonMsg = this.this$0.findUEGPersonMsg((CommonMsgPojo) customResponsedMessage.getData());
                        if (findUEGPersonMsg >= 0) {
                            this.this$0.mDatas.getChatMessages().remove(findUEGPersonMsg);
                            this.this$0.mLoadDataMode = 8;
                            if (this.this$0.mLoadDataCallBack != null) {
                                this.this$0.mLoadDataCallBack.c(null);
                            }
                        }
                    }
                }
            }
        };
        this.mListenerUnLogin = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.MsglistModel.11
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
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponseUnLoginMessage)) {
                    return;
                }
                this.this$0.mLoadDataMode = 12;
                if (this.this$0.mLoadDataCallBack != null) {
                    this.this$0.mLoadDataCallBack.c(null);
                }
            }
        };
        this.mActivity = msglistActivity;
        this.mDatas = new MsgPageData();
        registerListener();
    }

    private void sendMsgSuc(ResponseCommitMessage responseCommitMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65559, this, responseCommitMessage) != null) || responseCommitMessage == null) {
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
        h9 h9Var = this.mLoadDataCallBack;
        if (h9Var != null) {
            h9Var.c(this.mDatas);
        }
        hd8 hd8Var = this.mSendCallback;
        if (hd8Var != null) {
            hd8Var.a(0);
        }
    }

    public List<ChatMessage> processMsgFromServerCommon(List<ChatMessage> list) {
        InterceptResult invokeL;
        boolean z;
        ChatMessage chatMessage;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, list)) == null) {
            updatePortraintAndNetWork(list);
            updateGamePlayMsgCardBtn(list);
            delRepeatMsg(this.mDatas.getChatMessages(), list);
            Collections.sort(list, new CompareChatMessage());
            if (list != null && !list.isEmpty() && (chatMessage = list.get(list.size() - 1)) != null && (valueOf = String.valueOf(chatMessage.getUserId())) != null && valueOf.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            } else {
                z = false;
            }
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
                h9 h9Var = this.mLoadDataCallBack;
                if (h9Var != null) {
                    h9Var.c(this.mDatas);
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public void sendPicMessage(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, bitmap) == null) {
            sendPicMessage(str, bitmap, null);
        }
    }

    public void updateMsgResend(int i, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048625, this, i, chatMessage) == null) {
            List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
            int size = chatMessages.size();
            if (i >= 0 && i < size) {
                chatMessages.remove(i);
                chatMessages.add(i, chatMessage);
                this.mDatas.setIsNewAdd(false);
                this.mDatas.setNewAddNum(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendVoice(ChatMessage chatMessage) {
        VoiceMsgData r;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, this, chatMessage) != null) || (r = ue8.r(chatMessage)) == null) {
            return;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        ed8.n(chatMessage);
        ed8.k().A(r, chatMessage);
    }

    public void deleteMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            processDeleteMsg(1, i);
        }
    }

    public void doSendCommonShareCard(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatMessage) == null) {
            ed8.k().t(chatMessage);
        }
    }

    public void doSendShareChatroom(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, chatMessage) == null) {
            ed8.k().t(chatMessage);
        }
    }

    public void doSendShareForum(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, chatMessage) == null) {
            ed8.k().t(chatMessage);
        }
    }

    public void doSendShareThread(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, chatMessage) == null) {
            ed8.k().t(chatMessage);
        }
    }

    public void doSendText(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMessage) == null) {
            ed8.k().t(chatMessage);
        }
    }

    public void markDeleteMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            processDeleteMsg(2, i);
        }
    }

    public void processDraft(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, customResponsedMessage) == null) && (customResponsedMessage instanceof LoadDraftResponsedMessage)) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = (LoadDraftResponsedMessage) customResponsedMessage;
            if (loadDraftResponsedMessage.getData() == null) {
                return;
            }
            String str = loadDraftResponsedMessage.getData().a;
            this.mLoadDataMode = 9;
            h9 h9Var = this.mLoadDataCallBack;
            if (h9Var != null) {
                h9Var.c(str);
            }
        }
    }

    public boolean saveDraft(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            String str2 = this.mDraft;
            if (str2 != null && str2.equals(str)) {
                return false;
            }
            return saveDraftContent(str);
        }
        return invokeL.booleanValue;
    }

    public void sendExtraMessage(String str) {
        ChatMessage createMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048613, this, str) != null) || (createMessage = createMessage((short) 9, str)) == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        h9 h9Var = this.mLoadDataCallBack;
        if (h9Var != null) {
            h9Var.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void sendReplyCardMessage(String str) {
        ChatMessage createMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, str) != null) || (createMessage = createMessage((short) 23, str)) == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        h9 h9Var = this.mLoadDataCallBack;
        if (h9Var != null) {
            h9Var.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void sendTextMessage(String str) {
        ChatMessage createMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, str) != null) || (createMessage = createMessage((short) 1, str)) == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        h9 h9Var = this.mLoadDataCallBack;
        if (h9Var != null) {
            h9Var.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void setDraft(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.mDraft = str;
        }
    }

    public void setImageUploadUIProgressCallback(sl5.b<ChatMessage> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bVar) == null) {
            ed8.k().u(bVar);
        }
    }

    public void setIsAcceptNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.isAcceptNotify = z;
        }
    }

    public void setSendCallback(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, hd8Var) == null) {
            this.mSendCallback = hd8Var;
            ed8.k().v(hd8Var);
        }
    }

    private String buildBigEmotionContent(nc5 nc5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, nc5Var)) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pid", nc5Var.e());
                jSONObject.put("packet_name", nc5Var.f());
                jSONObject.put("face_name", nc5Var.d());
                jSONObject.put("size_width", nc5Var.h());
                jSONObject.put("size_height", nc5Var.b());
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, chatMessage)) == null) {
            if (chatMessage == null) {
                return "";
            }
            int msgType = chatMessage.getMsgType();
            String string = TbadkCoreApplication.getInst().getApp().getString(R.string.websocket_type);
            if (msgType != 1) {
                if (msgType != 2) {
                    if (msgType != 3) {
                        if (msgType != 9) {
                            if (msgType != 32) {
                                if (msgType != 33) {
                                    if (msgType != 37) {
                                        if (msgType != 38) {
                                            return "";
                                        }
                                        ImShareCardCommonData c = ue8.c(chatMessage);
                                        if (c != null) {
                                            if (c.getType() == 1) {
                                                return string + TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_topic_share);
                                            } else if (c.getType() == 2) {
                                                return string + TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_compilation_share);
                                            }
                                        }
                                        return string;
                                    }
                                    return string + TbadkCoreApplication.getInst().getApp().getString(R.string.msglist_share_chatroom);
                                }
                                return string + TbadkCoreApplication.getInst().getApp().getString(R.string.msglist_share_forum);
                            }
                            return string + TbadkCoreApplication.getInst().getApp().getString(R.string.msglist_share_thread);
                        }
                        return string + TbadkCoreApplication.getInst().getApp().getString(R.string.log_msg_extra);
                    }
                    return string + TbadkCoreApplication.getInst().getApp().getString(R.string.msglist_voice);
                }
                return string + TbadkCoreApplication.getInst().getApp().getString(R.string.editor_image);
            }
            return string + TbadkCoreApplication.getInst().getApp().getString(R.string.log_msg_text);
        }
        return (String) invokeL.objValue;
    }

    private void delRepeatMsg(List<ChatMessage> list, List<ChatMessage> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, this, list, list2) == null) && list != null && list2 != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendPic(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65552, this, chatMessage, str) != null) || chatMessage == null) {
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
            ed8.k().t(chatMessage);
        } else {
            ed8.k().z(chatMessage, str);
        }
    }

    private ChatMessage findMaxMsgIdMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            MsgPageData msgPageData = this.mDatas;
            ChatMessage chatMessage = null;
            if (msgPageData != null && msgPageData.getChatMessages() != null && this.mDatas.size() != 0) {
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

    public ChatMessage findIceBreakMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            MsgPageData msgPageData = this.mDatas;
            if (msgPageData != null && msgPageData.getChatMessages() != null && this.mDatas.size() != 0) {
                for (ChatMessage chatMessage : this.mDatas.getChatMessages()) {
                    if (chatMessage != null && chatMessage.getType() == ChatMessage.TYPE_MSG_ICE_BREAK) {
                        return chatMessage;
                    }
                }
            }
            return null;
        }
        return (ChatMessage) invokeV.objValue;
    }

    public void refreshAfterClearHistory() {
        MsgPageData msgPageData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (msgPageData = this.mDatas) != null && msgPageData.getChatMessages() != null && this.mDatas.size() != 0) {
            ChatMessage findMaxMsgIdMessage = findMaxMsgIdMessage();
            if (findMaxMsgIdMessage != null && ue8.y(findMaxMsgIdMessage)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016020, findMaxMsgIdMessage));
            }
            this.mDatas.clear();
            this.mLoadDataMode = 13;
            h9 h9Var = this.mLoadDataCallBack;
            if (h9Var != null) {
                h9Var.c(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findUEGPersonMsg(CommonMsgPojo commonMsgPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, commonMsgPojo)) == null) {
            List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
            if (chatMessages != null) {
                for (int i = 0; i < chatMessages.size(); i++) {
                    if (chatMessages.get(i).getMsgId() == commonMsgPojo.getIllegalMsgId()) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public ChatMessage getMsg(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            MsgPageData msgPageData = this.mDatas;
            if (msgPageData == null || msgPageData.getChatMessages() == null || i < 0 || i >= this.mDatas.size()) {
                return null;
            }
            return this.mDatas.getChatMessages().get(i);
        }
        return (ChatMessage) invokeI.objValue;
    }

    public void sendBigEmotionMessage(nc5 nc5Var) {
        String buildBigEmotionContent;
        ChatMessage createMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, nc5Var) != null) || (buildBigEmotionContent = buildBigEmotionContent(nc5Var)) == null || (createMessage = createMessage((short) 4, buildBigEmotionContent)) == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        h9 h9Var = this.mLoadDataCallBack;
        if (h9Var != null) {
            h9Var.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    private int mergeList(List<ChatMessage> list, List<ChatMessage> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, this, list, list2)) == null) {
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
        ChatMessage chatMessage;
        CacheInfo cacheInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65557, this, i, i2) == null) {
            int size = this.mDatas.size();
            if (i2 >= 0 && i2 < size) {
                ChatMessage chatMessage2 = this.mDatas.getChatMessages().get(i2);
                if (i != 1) {
                    if (i == 2) {
                        markDeleteMsg(chatMessage2);
                    }
                } else {
                    deleteMsg(chatMessage2);
                }
                int i3 = i2 - 1;
                if (i3 >= 0) {
                    chatMessage = this.mDatas.getChatMessages().get(i3);
                } else {
                    chatMessage = null;
                }
                markDeleteMsg(chatMessage2);
                this.mDatas.getChatMessages().remove(i2);
                if (i2 == size - 1 && (cacheInfo = getCacheInfo()) != null) {
                    MemoryModifyLastMsgMessage.ModifyData modifyData = new MemoryModifyLastMsgMessage.ModifyData();
                    modifyData.customGroupType = cacheInfo.customGroupType;
                    modifyData.id = cacheInfo.id;
                    modifyData.message = chatMessage;
                    modifyData.type = 2;
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryModifyLastMsgMessage(modifyData));
                }
            }
            this.mLoadDataMode = 8;
            h9 h9Var = this.mLoadDataCallBack;
            if (h9Var != null) {
                h9Var.c(null);
            }
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            registerListener(2001153, this.mListenerUnLogin);
            registerListener(2001110, this.mCustomListenerInMessageCenter);
            registerListener(501126, this.mCustomListenerInMessageCenter);
            registerListener(2921693, this.mCustomListenerInMessageCenter);
        }
    }

    private void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mListenerUnLogin);
            MessageManager.getInstance().unRegisterListener(this.mCustomListenerInMessageCenter);
        }
    }

    public MsgPageData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mDatas;
        }
        return (MsgPageData) invokeV.objValue;
    }

    public String getDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mDraft;
        }
        return (String) invokeV.objValue;
    }

    public boolean getIsAcceptNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.isAcceptNotify;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.mAntiDialog = null;
            ed8.k().v(null);
            unRegisterListener();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.mDatas.reset();
        }
    }

    private void updateGamePlayMsgCardBtn(List<ChatMessage> list) {
        MsglistActivity<?> msglistActivity;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65561, this, list) != null) || list == null || (msglistActivity = this.mActivity) == null) {
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
        Iterator<ChatMessage> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().getMsgType() == 34) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (i2 >= 0 && i < size && z) {
            while (i2 <= i) {
                ChatMessage chatMessage = chatMessages.get(i2);
                if (chatMessage != null && chatMessage.getMsgType() == 34) {
                    GamePlayOrderMsgData gamePlayOrderMsgData = (GamePlayOrderMsgData) chatMessage.getObjContent();
                    if (gamePlayOrderMsgData != null) {
                        gamePlayOrderMsgData.setLast(false);
                        yb8.w().y(gamePlayOrderMsgData.getGid(), gamePlayOrderMsgData.getMid(), OrmObject.jsonStrWithObject(gamePlayOrderMsgData));
                    } else {
                        GamePlayOrderMsgData parseFromJsonStr = GamePlayOrderMsgData.parseFromJsonStr(chatMessage.getContent());
                        if (parseFromJsonStr != null) {
                            parseFromJsonStr.setLast(false);
                            String jsonStrWithObject = OrmObject.jsonStrWithObject(parseFromJsonStr);
                            chatMessage.setContent(jsonStrWithObject);
                            yb8.w().y(parseFromJsonStr.getGid(), parseFromJsonStr.getMid(), jsonStrWithObject);
                        }
                    }
                }
                i2++;
            }
        }
    }

    private void updateMsgStatusTimeOut(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65562, this, list) == null) && list != null && list.size() != 0) {
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 1) {
                    chatMessage.setCustomGroupType(this.customGroupType);
                    if ((System.currentTimeMillis() / 1000) - chatMessage.getTime() > DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) {
                        chatMessage.getLocalData().setStatus((short) 2);
                    } else {
                        boolean z = false;
                        if (MessageManager.getInstance().getSocketClient() != null) {
                            z = MessageManager.getInstance().getSocketClient().n(chatMessage);
                        }
                        if (!z && (chatMessage.getMsgType() != 2 || !ed8.k().h(chatMessage))) {
                            if (chatMessage.getMsgType() != 3 || !ed8.k().i(chatMessage)) {
                                chatMessage.getLocalData().setStatus((short) 2);
                            }
                        }
                    }
                }
            }
        }
    }

    private void updatePortraintAndNetWork(List<ChatMessage> list) {
        MsglistActivity<?> msglistActivity;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65563, this, list) != null) || list == null || (msglistActivity = this.mActivity) == null) {
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
        if (i2 >= 0 && i < size) {
            for (ChatMessage chatMessage : list) {
                if (chatMessage.getMsgType() == 4) {
                    ca8.a = pv5.b();
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
    }

    public boolean processHistory(CustomResponsedMessage<?> customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, customResponsedMessage)) == null) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
                return false;
            }
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() == null) {
                return true;
            }
            long j = this.mId;
            if (j != 0 && j != JavaTypesHelper.toLong(loadHistoryResponsedMessage.getData().a, 0L)) {
                return false;
            }
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
                    h9 h9Var = this.mLoadDataCallBack;
                    if (h9Var != null) {
                        h9Var.c(null);
                    }
                }
                return true;
            }
            if (this.mDatas.getIsNewAdd()) {
                this.mLoadDataMode = 2;
                h9 h9Var2 = this.mLoadDataCallBack;
                if (h9Var2 != null) {
                    h9Var2.c(null);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void reSendMsg(int i) {
        ChatMessage msg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048607, this, i) == null) && (msg = getMsg(i)) != null && msg.getLocalData() != null && msg.getLocalData().getStatus() != null) {
            short shortValue = msg.getLocalData().getStatus().shortValue();
            if (shortValue != 2 && shortValue != 4 && shortValue != 5 && shortValue != 6 && shortValue != 7 && shortValue != 8 && shortValue != 9) {
                return;
            }
            msg.setRecordId(msg.getMsgId());
            msg.getLocalData().setStatus((short) 1);
            msg.setTime(System.currentTimeMillis() / 1000);
            msg.setCustomGroupType(this.customGroupType);
            int msgType = msg.getMsgType();
            if (msgType != 1) {
                if (msgType != 2) {
                    if (msgType != 3) {
                        if (msgType != 4) {
                            if (msgType != 9) {
                                if (msgType != 32) {
                                    if (msgType != 33) {
                                        if (msgType != 37) {
                                            if (msgType == 38) {
                                                doSendCommonShareCard(msg);
                                            }
                                        } else {
                                            doSendShareChatroom(msg);
                                        }
                                    } else {
                                        doSendShareForum(msg);
                                    }
                                } else {
                                    doSendShareThread(msg);
                                }
                            } else {
                                doSendText(msg);
                            }
                        } else {
                            doSendText(msg);
                        }
                    } else {
                        doSendVoice(msg);
                    }
                } else {
                    doSendPic(msg, null);
                }
            } else {
                doSendText(msg);
            }
            this.mLoadDataMode = 7;
            h9 h9Var = this.mLoadDataCallBack;
            if (h9Var != null) {
                h9Var.c(this.mDatas);
            }
            updateMsgResend(i, msg);
        }
    }

    public void sendMsgFail(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, chatMessage) != null) || chatMessage == null) {
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
        chatMessage.getLocalData().setErrorString(chatMessage.getErrorString());
        chatMessage.getLocalData().setStatus(Short.valueOf(hc8.b(chatMessage.getError())));
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        if (chatMessages != null && chatMessages.size() != 0) {
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
                this.mLoadDataMode = 6;
                h9 h9Var = this.mLoadDataCallBack;
                if (h9Var != null) {
                    h9Var.c(this.mDatas);
                }
            }
        }
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
            long b = te8.b(getLastMid());
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
                j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
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

    public void sendMsgVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048616, this, str, i) == null) {
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
            h9 h9Var = this.mLoadDataCallBack;
            if (h9Var != null) {
                h9Var.c(this.mDatas);
            }
            if (createMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) createMessage;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(personalChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                nw5.c(new jw5<Boolean>(this, personalChatMessage, linkedList) { // from class: com.baidu.tieba.im.model.MsglistModel.2
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
                            Object[] objArr = {this, personalChatMessage, linkedList};
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
                        this.val$list = linkedList;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tieba.jw5
                    public Boolean doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return Boolean.valueOf(yb8.w().n(ue8.q(this.val$personalMsg), this.val$list, false));
                        }
                        return (Boolean) invokeV.objValue;
                    }
                }, new ov5<Boolean>(this, personalChatMessage) { // from class: com.baidu.tieba.im.model.MsglistModel.3
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
                    @Override // com.baidu.tieba.ov5
                    public void onReturnDataInUI(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(1048576, this, bool) != null) {
                            return;
                        }
                        this.this$0.doSendVoice(this.val$personalMsg);
                    }
                });
            } else if (createMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) createMessage;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(officialChatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                nw5.c(new jw5<Boolean>(this, officialChatMessage, linkedList2) { // from class: com.baidu.tieba.im.model.MsglistModel.4
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
                            Object[] objArr = {this, officialChatMessage, linkedList2};
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
                        this.val$list = linkedList2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tieba.jw5
                    public Boolean doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return Boolean.valueOf(xb8.w().n(ue8.q(this.val$personalMsg), this.val$list, false));
                        }
                        return (Boolean) invokeV.objValue;
                    }
                }, new ov5<Boolean>(this, officialChatMessage) { // from class: com.baidu.tieba.im.model.MsglistModel.5
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
                    @Override // com.baidu.tieba.ov5
                    public void onReturnDataInUI(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(1048576, this, bool) != null) {
                            return;
                        }
                        this.this$0.doSendVoice(this.val$personalMsg);
                    }
                });
            }
        }
    }

    public void processMsgACK(ResponseCommitMessage responseCommitMessage) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, responseCommitMessage) == null) && responseCommitMessage != null && responseCommitMessage.getOrginalMessage() != null && (responseCommitMessage.getOrginalMessage() instanceof ChatMessage)) {
            ChatMessage chatMessage = (ChatMessage) responseCommitMessage.getOrginalMessage();
            if (responseCommitMessage.getError() != 0) {
                if (MessageManager.getInstance().getSocketClient().u()) {
                    i = 1;
                } else {
                    i = 2;
                }
                hm5.c(responseCommitMessage.getCmd(), 0, 0, 0, 13, i);
                long recordId = chatMessage.getRecordId();
                String createMsgLog = createMsgLog(chatMessage);
                long clientLogID = chatMessage.getClientLogID();
                int cmd = responseCommitMessage.getCmd();
                int error = responseCommitMessage.getError();
                String errorString = responseCommitMessage.getErrorString();
                Logger.addLog("im", clientLogID, cmd, "ack", error, errorString, "comment", createMsgLog + "rid" + recordId);
                if (responseCommitMessage.getError() > 0) {
                    if (AntiHelper.m(responseCommitMessage.getError(), responseCommitMessage.getErrorString())) {
                        m45 m45Var = this.mAntiDialog;
                        if (m45Var != null) {
                            if (!m45Var.isShowing()) {
                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                                this.mAntiDialog.show();
                            }
                        } else {
                            m45 t = AntiHelper.t(this.mActivity.getActivity(), responseCommitMessage.getBlockPopInfoData(), this.mInjectListener);
                            this.mAntiDialog = t;
                            if (t != null) {
                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                            }
                        }
                    } else if (responseCommitMessage.getError() != 3160008 && responseCommitMessage.getError() != 3100001 && chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
                        responseCommitMessage.setRecordId(chatMessage.getRecordId());
                        Logger.addLog("im", chatMessage.getClientLogID(), responseCommitMessage.getCmd(), "ack", responseCommitMessage.getError(), responseCommitMessage.getErrorString(), "comment", "orgRId != sRId");
                    }
                    if (responseCommitMessage.getError() == 3160013) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_IM_CYBER_VIOLENCE_MESSAGE_SENDER_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                }
                chatMessage.setErrorString(responseCommitMessage.getErrorString());
                chatMessage.setError(responseCommitMessage.getError());
                sendMsgFail(chatMessage);
                return;
            }
            if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
                responseCommitMessage.setRecordId(chatMessage.getRecordId());
                Logger.addLog("im", chatMessage.getClientLogID(), responseCommitMessage.getCmd(), "ack", responseCommitMessage.getError(), responseCommitMessage.getErrorString(), "comment", "orgRId != sRId");
            }
            sendMsgSuc(responseCommitMessage);
        }
    }

    public void sendIceBreakEmotion(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048614, this, str, str2, i, i2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(EmotionUbcHelper.MEME_ID, str);
            hashMap.put("meme_type", "4");
            ChatMessage createMessage = createMessage((short) 2, ed8.g(str2, str2, i, i2, hashMap));
            if (createMessage == null) {
                return;
            }
            createMessage.setIsUploading(true);
            this.mDatas.getChatMessages().add(createMessage);
            this.mLoadDataMode = 4;
            h9 h9Var = this.mLoadDataCallBack;
            if (h9Var != null) {
                h9Var.c(this.mDatas);
            }
            ed8.k().t(createMessage);
        }
    }

    public void sendPicMessage(String str, Bitmap bitmap, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048618, this, str, bitmap, map) != null) || bitmap == null) {
            return;
        }
        String g = ed8.g(str, str, bitmap.getWidth(), bitmap.getHeight(), map);
        ed8.k().w(str, map);
        ChatMessage createMessage = createMessage((short) 2, g);
        if (createMessage == null) {
            return;
        }
        createMessage.setIsUploading(true);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        createMessage.setWidth(width);
        createMessage.setHeight(height);
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        h9 h9Var = this.mLoadDataCallBack;
        if (h9Var != null) {
            h9Var.c(this.mDatas);
        }
        if (createMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) createMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(personalChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            nw5.c(new jw5<Boolean>(this, personalChatMessage, linkedList) { // from class: com.baidu.tieba.im.model.MsglistModel.6
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
                        Object[] objArr = {this, personalChatMessage, linkedList};
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
                    this.val$list = linkedList;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.jw5
                public Boolean doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return Boolean.valueOf(yb8.w().n(ue8.q(this.val$groupMsg), this.val$list, false));
                    }
                    return (Boolean) invokeV.objValue;
                }
            }, new ov5<Boolean>(this, personalChatMessage, str) { // from class: com.baidu.tieba.im.model.MsglistModel.7
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
                @Override // com.baidu.tieba.ov5
                public void onReturnDataInUI(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, bool) != null) {
                        return;
                    }
                    this.this$0.doSendPic(this.val$groupMsg, this.val$localFilePath);
                }
            });
        } else if (createMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) createMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(officialChatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            nw5.c(new jw5<Boolean>(this, officialChatMessage, linkedList2) { // from class: com.baidu.tieba.im.model.MsglistModel.8
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
                        Object[] objArr = {this, officialChatMessage, linkedList2};
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
                    this.val$list = linkedList2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.jw5
                public Boolean doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return Boolean.valueOf(xb8.w().n(ue8.q(this.val$groupMsg), this.val$list, false));
                    }
                    return (Boolean) invokeV.objValue;
                }
            }, new ov5<Boolean>(this, officialChatMessage, str) { // from class: com.baidu.tieba.im.model.MsglistModel.9
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
                @Override // com.baidu.tieba.ov5
                public void onReturnDataInUI(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, bool) != null) {
                        return;
                    }
                    this.this$0.doSendPic(this.val$groupMsg, this.val$localFilePath);
                }
            });
        }
    }
}
