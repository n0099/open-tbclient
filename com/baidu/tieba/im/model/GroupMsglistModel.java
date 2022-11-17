package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.ba7;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.GroupSaveDraftMessage;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadGroupDraftMessage;
import com.baidu.tieba.im.message.LoadGroupHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GroupMsglistModel extends CommonGroupMsglistModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_COUNT_PER = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mCustomMessageListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupMsglistModel(MsglistActivity msglistActivity) {
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
        this.mCustomMessageListener = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.GroupMsglistModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GroupMsglistModel this$0;

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
                ba7 callback;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2012125) {
                    this.this$0.processServerMsg(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001142) {
                    this.this$0.processDraft(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001145) {
                    boolean processHistory = this.this$0.processHistory(customResponsedMessage);
                    if ((customResponsedMessage.getOrginalMessage() instanceof LoadGroupHistoryMessage) && processHistory && (callback = ((LoadGroupHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                        callback.E0();
                    }
                }
            }
        };
        registerListener();
        this.customGroupType = 1;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            SaveDraftMessage.a aVar = new SaveDraftMessage.a();
            GroupData groupData = this.mGroup;
            if (groupData != null && groupData.getGroupId() != 0) {
                aVar.b = String.valueOf(this.mGroup.getGroupId());
                aVar.a = str;
                super.sendMessage(new GroupSaveDraftMessage(aVar));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            MessageManager.getInstance().registerListener(2012125, this.mCustomMessageListener);
            MessageManager.getInstance().registerListener(2001142, this.mCustomMessageListener);
            MessageManager.getInstance().registerListener(2001145, this.mCustomMessageListener);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public ChatMessage genChatMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GroupChatMessage groupChatMessage = new GroupChatMessage();
            groupChatMessage.setBornTime(System.currentTimeMillis());
            if (getGroup() == null) {
                return null;
            }
            groupChatMessage.setGroupId(String.valueOf(getGroup().getGroupId()));
            return groupChatMessage;
        }
        return (ChatMessage) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mGroup == null) {
                return false;
            }
            LoadDraftMessage.a aVar = new LoadDraftMessage.a();
            aVar.a = this.mGroup.getGroupId() + "";
            super.sendMessage(new LoadGroupDraftMessage(aVar));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public MsglistModel.CacheInfo getCacheInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mGroup == null) {
                return null;
            }
            MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
            cacheInfo.customGroupType = 1;
            cacheInfo.id = String.valueOf(this.mGroup.getGroupId());
            return cacheInfo;
        }
        return (MsglistModel.CacheInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            unRegisterListener();
        }
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(ba7 ba7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ba7Var)) == null) {
            if (this.mGroup == null) {
                return false;
            }
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.c = 20;
            aVar.a = null;
            aVar.b = null;
            aVar.d = this.mGroup.getGroupId() + "";
            LoadGroupHistoryMessage loadGroupHistoryMessage = new LoadGroupHistoryMessage(aVar);
            loadGroupHistoryMessage.setCallback(ba7Var);
            super.sendMessage(loadGroupHistoryMessage);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mGroup == null) {
                return false;
            }
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.c = 20;
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
            aVar.d = this.mGroup.getGroupId() + "";
            super.sendMessage(new LoadGroupHistoryMessage(aVar));
            return false;
        }
        return invokeV.booleanValue;
    }
}
