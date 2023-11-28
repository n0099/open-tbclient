package com.baidu.tieba.im.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.aw8;
import com.baidu.tieba.es8;
import com.baidu.tieba.fu8;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.LoadOfficialBarDraftMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.OfficialBarSaveDraftMessage;
import com.baidu.tieba.im.message.RequestOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.RequestOfficialBarMenuMessage;
import com.baidu.tieba.im.message.RequestSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.ju5;
import com.baidu.tieba.nu5;
import com.baidu.tieba.pt8;
import com.baidu.tieba.tw8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class OfficialBarMsglistModel extends CommonPersonalMsglistModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_COUNT_PER = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mCustomMessageListener;
    public int mUserType;
    public pt8 officialBarMenuDatas;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialBarMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MsglistActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCustomMessageListener = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OfficialBarMsglistModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
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
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2012123) {
                    this.this$0.processServerMsg(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001144) {
                    this.this$0.processDraft(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001147) {
                    this.this$0.processHistoryFake(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001151) {
                    String str = (String) customResponsedMessage.getData();
                    UserData userData = this.this$0.mUser;
                    if (userData != null && userData.getUserId().equals(str)) {
                        this.this$0.refreshAfterClearHistory();
                    }
                }
            }
        };
        registerListener();
        this.customGroupType = 4;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            SaveDraftMessage.a aVar = new SaveDraftMessage.a();
            UserData userData = this.mUser;
            if (userData == null) {
                return false;
            }
            aVar.b = String.valueOf(String.valueOf(userData.getUserId()));
            aVar.a = str;
            super.sendMessage(new OfficialBarSaveDraftMessage(aVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void sendGetMenuNetMessage(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, str, j) == null) {
            RequestOfficialBarMenuMessage requestOfficialBarMenuMessage = new RequestOfficialBarMenuMessage();
            requestOfficialBarMenuMessage.setForum_id(str);
            requestOfficialBarMenuMessage.setTimestamp(j);
            sendMessage(requestOfficialBarMenuMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHistoryFake(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            return;
        }
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
        if (loadHistoryResponsedMessage.getData() == null) {
            return;
        }
        List<ChatMessage> list = loadHistoryResponsedMessage.getData().b;
        if (list == null) {
            list = new LinkedList();
        }
        if (list.size() > 0) {
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null) {
                    StatisticItem statisticItem = new StatisticItem("official_message_open");
                    statisticItem.param("msg_id", chatMessage.getMsgId() / 100);
                    if (chatMessage.getUserInfo() != null) {
                        statisticItem.param("official_id", chatMessage.getUserInfo().getUserId());
                        statisticItem.param("official_type", chatMessage.getUserInfo().getUserType());
                    }
                    statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                    statisticItem.param("task_id", chatMessage.getStatTaskId());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
        processHistory(loadHistoryResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, customResponsedMessage) == null) && (customResponsedMessage instanceof GroupMsgData)) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (getUser() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof OfficialChatMessage) {
                        if (chatMessage.getToUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        }
                    }
                    StatisticItem statisticItem = new StatisticItem("official_message_open");
                    statisticItem.param("msg_id", chatMessage.getMsgId() / 100);
                    if (chatMessage.getUserInfo() != null) {
                        statisticItem.param("official_id", chatMessage.getUserInfo().getUserId());
                        statisticItem.param("official_type", chatMessage.getUserInfo().getUserType());
                    }
                    statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                    statisticItem.param("task_id", chatMessage.getStatTaskId());
                    TiebaStatic.log(statisticItem);
                }
                processMsgFromServerCommon(linkedList);
            }
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            MessageManager.getInstance().registerListener(2012123, this.mCustomMessageListener);
            MessageManager.getInstance().registerListener(2001144, this.mCustomMessageListener);
            MessageManager.getInstance().registerListener(2001147, this.mCustomMessageListener);
            MessageManager.getInstance().registerListener(2001151, this.mCustomMessageListener);
        }
    }

    private void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public MsglistModel.CacheInfo getCacheInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mUser == null) {
                return null;
            }
            MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
            cacheInfo.id = this.mUser.getUserId();
            cacheInfo.customGroupType = 4;
            return cacheInfo;
        }
        return (MsglistModel.CacheInfo) invokeV.objValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            UserData user = getUser();
            if (user != null) {
                return user.getUserId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return aw8.n().o(String.valueOf(tw8.k), -9);
        }
        return invokeV.longValue;
    }

    public pt8 getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.officialBarMenuDatas;
        }
        return (pt8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mUser == null) {
                return false;
            }
            LoadDraftMessage.a aVar = new LoadDraftMessage.a();
            aVar.a = this.mUser.getUserId();
            super.sendMessage(new LoadOfficialBarDraftMessage(aVar));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            unRegisterListener();
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void deleteMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) && this.mUser != null && chatMessage != null) {
            nu5.c(new ju5<Boolean>(this, chatMessage) { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OfficialBarMsglistModel this$0;
                public final /* synthetic */ ChatMessage val$msg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, chatMessage};
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
                    this.val$msg = chatMessage;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.ju5
                public Boolean doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return Boolean.valueOf(fu8.w().c(String.valueOf(this.this$0.mUser.getUserId()), String.valueOf(this.val$msg.getMsgId())));
                    }
                    return (Boolean) invokeV.objValue;
                }
            }, null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void markDeleteMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, chatMessage) == null) && this.mUser != null && chatMessage != null) {
            nu5.c(new ju5<Boolean>(this, chatMessage) { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OfficialBarMsglistModel this$0;
                public final /* synthetic */ ChatMessage val$msg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, chatMessage};
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
                    this.val$msg = chatMessage;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.ju5
                public Boolean doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return Boolean.valueOf(fu8.w().o(String.valueOf(this.this$0.mUser.getUserId()), String.valueOf(this.val$msg.getMsgId())));
                    }
                    return (Boolean) invokeV.objValue;
                }
            }, null);
        }
    }

    public void sendGetMenuLocalMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            RequestOfficialBarMenuLocalMessage requestOfficialBarMenuLocalMessage = new RequestOfficialBarMenuLocalMessage();
            requestOfficialBarMenuLocalMessage.setForumId(str);
            sendMessage(requestOfficialBarMenuLocalMessage);
        }
    }

    public void setOfficialBarMenuDatas(pt8 pt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pt8Var) == null) {
            this.officialBarMenuDatas = pt8Var;
        }
    }

    public void setUserType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mUserType = i;
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public ChatMessage genChatMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mUser == null) {
                return null;
            }
            OfficialChatMessage officialChatMessage = new OfficialChatMessage();
            officialChatMessage.setBornTime(System.currentTimeMillis());
            officialChatMessage.setToUserId(this.mUser.getUserIdLong());
            UserData userData = new UserData();
            userData.setUserId(String.valueOf(this.mUser.getUserId()));
            userData.setUserName(this.mUser.getUserName());
            userData.setPortrait(this.mUser.getPortrait());
            userData.setName_show(this.mUser.getName_show());
            userData.setUserType(this.mUserType);
            officialChatMessage.setToUserInfo(userData);
            return officialChatMessage;
        }
        return (ChatMessage) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(es8 es8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, es8Var)) == null) {
            if (this.mUser == null) {
                return false;
            }
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.c = 10;
            aVar.a = null;
            aVar.b = null;
            aVar.d = this.mUser.getUserIdLong() + "";
            super.sendMessage(new LoadOfficialHistoryMessage(aVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mUser == null) {
                return false;
            }
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.c = 10;
            MsgPageData msgPageData = this.mDatas;
            long j2 = 0;
            if (msgPageData != null && msgPageData.getChatMessages() != null && this.mDatas.size() > 0 && this.mDatas.getChatMessages().get(0) != null) {
                j2 = this.mDatas.getChatMessages().get(0).getMsgId();
                j = this.mDatas.getChatMessages().get(0).getRecordId();
            } else {
                j = 0;
            }
            aVar.a = String.valueOf(j2);
            aVar.b = String.valueOf(j);
            aVar.d = this.mUser.getUserIdLong() + "";
            super.sendMessage(new LoadOfficialHistoryMessage(aVar));
            return true;
        }
        return invokeV.booleanValue;
    }

    public void sendClickMenuMessage(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, str3) == null) {
            RequestSendOfficialBarMenuMessage requestSendOfficialBarMenuMessage = new RequestSendOfficialBarMenuMessage();
            requestSendOfficialBarMenuMessage.setRid(str);
            requestSendOfficialBarMenuMessage.setUserId(str2);
            requestSendOfficialBarMenuMessage.setForumId(str3);
            sendMessage(requestSendOfficialBarMenuMessage);
        }
    }
}
