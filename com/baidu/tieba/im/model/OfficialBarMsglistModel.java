package com.baidu.tieba.im.model;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.p0.u1.g.c;
import c.a.p0.u1.h.l;
import c.a.p0.u1.k.b;
import c.a.p0.u1.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class OfficialBarMsglistModel extends CommonPersonalMsglistModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_COUNT_PER = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasFake;
    public CustomMessageListener mCustomMessageListener;
    public int mUserType;
    public c officialBarMenuDatas;

    /* loaded from: classes5.dex */
    public static class MsgContent extends OrmObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String eventId;
        public String userMsg;

        public MsgContent() {
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
        this.hasFake = false;
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
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
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
                    if (userData == null || !userData.getUserId().equals(str)) {
                        return;
                    }
                    this.this$0.refreshAfterClearHistory();
                }
            }
        };
        registerListener();
        this.customGroupType = 4;
    }

    private ChatMessage createFakeMessage() {
        InterceptResult invokeV;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mUser == null) {
                return null;
            }
            int i = this.mUserType;
            if (i == 1) {
                format = String.format(this.mActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ca3), this.mUser.getUserName());
            } else {
                format = i == 4 ? String.format(this.mActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ca2), this.mUser.getUserName()) : "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TbEnum.SystemMessage.KEY_EVENT_ID, TbEnum.SystemMessage.EVENT_ID_FAKE);
            hashMap.put(TbEnum.SystemMessage.KEY_USER_MSG, format);
            return createMessage((short) 11, OrmObject.jsonStrWithObject((MsgContent) OrmObject.objectWithMap(hashMap, MsgContent.class)));
        }
        return (ChatMessage) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHistoryFake(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() == null) {
                return;
            }
            List<ChatMessage> list = loadHistoryResponsedMessage.getData().f33855b;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, customResponsedMessage) == null) && (customResponsedMessage instanceof GroupMsgData)) {
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
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            MessageManager.getInstance().registerListener(2012123, this.mCustomMessageListener);
            MessageManager.getInstance().registerListener(2001144, this.mCustomMessageListener);
            MessageManager.getInstance().registerListener(2001147, this.mCustomMessageListener);
            MessageManager.getInstance().registerListener(2001151, this.mCustomMessageListener);
        }
    }

    private void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void deleteMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) || this.mUser == null || chatMessage == null) {
            return;
        }
        n0.c(new k0<Boolean>(this, chatMessage) { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.1
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
            @Override // c.a.o0.c1.k0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(l.t().c(String.valueOf(this.this$0.mUser.getUserId()), String.valueOf(this.val$msg.getMsgId()))) : (Boolean) invokeV.objValue;
            }
        }, null);
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
            return user != null ? user.getUserId() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b.o().p(String.valueOf(a.j), -9) : invokeV.longValue;
    }

    public c getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.officialBarMenuDatas : (c) invokeV.objValue;
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

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(c.a.p0.u1.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            if (this.mUser == null) {
                return false;
            }
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.f33853c = 10;
            aVar.a = null;
            aVar.f33852b = null;
            aVar.f33854d = this.mUser.getUserIdLong() + "";
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
            aVar.f33853c = 10;
            MsgPageData msgPageData = this.mDatas;
            long j2 = 0;
            if (msgPageData == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j2 = this.mDatas.getChatMessages().get(0).getMsgId();
                j = this.mDatas.getChatMessages().get(0).getRecordId();
            }
            aVar.a = String.valueOf(j2);
            aVar.f33852b = String.valueOf(j);
            aVar.f33854d = this.mUser.getUserIdLong() + "";
            super.sendMessage(new LoadOfficialHistoryMessage(aVar));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void markDeleteMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, chatMessage) == null) || this.mUser == null || chatMessage == null) {
            return;
        }
        n0.c(new k0<Boolean>(this, chatMessage) { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.2
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
            @Override // c.a.o0.c1.k0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(l.t().n(String.valueOf(this.this$0.mUser.getUserId()), String.valueOf(this.val$msg.getMsgId()))) : (Boolean) invokeV.objValue;
            }
        }, null);
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
    public boolean saveDraftContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            SaveDraftMessage.a aVar = new SaveDraftMessage.a();
            UserData userData = this.mUser;
            if (userData == null) {
                return false;
            }
            aVar.f33867b = String.valueOf(String.valueOf(userData.getUserId()));
            aVar.a = str;
            super.sendMessage(new OfficialBarSaveDraftMessage(aVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void sendClickMenuMessage(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, str3) == null) {
            RequestSendOfficialBarMenuMessage requestSendOfficialBarMenuMessage = new RequestSendOfficialBarMenuMessage();
            requestSendOfficialBarMenuMessage.setRid(str);
            requestSendOfficialBarMenuMessage.setUser_id(str2);
            requestSendOfficialBarMenuMessage.setForum_id(str3);
            sendMessage(requestSendOfficialBarMenuMessage);
        }
    }

    public void sendGetMenuLocalMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            RequestOfficialBarMenuLocalMessage requestOfficialBarMenuLocalMessage = new RequestOfficialBarMenuLocalMessage();
            requestOfficialBarMenuLocalMessage.setForum_id(str);
            sendMessage(requestOfficialBarMenuLocalMessage);
        }
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

    public void setOfficialBarMenuDatas(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.officialBarMenuDatas = cVar;
        }
    }

    public void setUserType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mUserType = i;
        }
    }
}
