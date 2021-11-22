package com.baidu.tieba.im.model;

import b.a.r0.l1.f.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.GroupData;
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
/* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                c callback;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2012125) {
                    this.this$0.processServerMsg(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001142) {
                    this.this$0.processDraft(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001145) {
                    boolean processHistory = this.this$0.processHistory(customResponsedMessage);
                    if ((customResponsedMessage.getOrginalMessage() instanceof LoadGroupHistoryMessage) && processHistory && (callback = ((LoadGroupHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                        callback.onFirstHistoryPageLoaded();
                    }
                }
            }
        };
        registerListener();
        this.customGroupType = 1;
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

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mGroup == null) {
                return false;
            }
            LoadDraftMessage.a aVar = new LoadDraftMessage.a();
            aVar.f51392a = this.mGroup.getGroupId() + "";
            super.sendMessage(new LoadGroupDraftMessage(aVar));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            if (this.mGroup == null) {
                return false;
            }
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.f51396c = 20;
            aVar.f51394a = null;
            aVar.f51395b = null;
            aVar.f51397d = this.mGroup.getGroupId() + "";
            LoadGroupHistoryMessage loadGroupHistoryMessage = new LoadGroupHistoryMessage(aVar);
            loadGroupHistoryMessage.setCallback(cVar);
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
            aVar.f51396c = 20;
            MsgPageData msgPageData = this.mDatas;
            long j2 = 0;
            if (msgPageData == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j2 = this.mDatas.getChatMessages().get(0).getMsgId();
                j = this.mDatas.getChatMessages().get(0).getRecordId();
            }
            aVar.f51394a = String.valueOf(j2);
            aVar.f51395b = String.valueOf(j);
            aVar.f51397d = this.mGroup.getGroupId() + "";
            super.sendMessage(new LoadGroupHistoryMessage(aVar));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            unRegisterListener();
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            SaveDraftMessage.a aVar = new SaveDraftMessage.a();
            GroupData groupData = this.mGroup;
            if (groupData == null || groupData.getGroupId() == 0) {
                return false;
            }
            aVar.f51420b = String.valueOf(this.mGroup.getGroupId());
            aVar.f51419a = str;
            super.sendMessage(new GroupSaveDraftMessage(aVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
        }
    }
}
