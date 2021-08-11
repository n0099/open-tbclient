package com.baidu.tieba.im.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.c.g.c;
import c.a.o0.b1.h0;
import c.a.o0.b1.k0;
import c.a.p0.j1.k.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class CommonGroupMsglistModel extends MsglistModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener mCustomListener;
    public GroupData mGroup;
    public final c mSocketListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonGroupMsglistModel(MsglistActivity msglistActivity) {
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
        this.mGroup = null;
        this.mSocketListener = new c(this, 0) { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonGroupMsglistModel this$0;

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
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                    return;
                }
                if (socketResponsedMessage.getCmd() == 103112) {
                    this.this$0.removeMemeber(socketResponsedMessage);
                } else if (socketResponsedMessage.getCmd() == 103102) {
                    this.this$0.updataGroupInfo(socketResponsedMessage);
                }
            }
        };
        this.mCustomListener = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonGroupMsglistModel this$0;

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
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2016012) {
                    if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                        return;
                    }
                    SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                    if (socketResponsedMessage.getCmd() == 202001 && (socketResponsedMessage instanceof ResponseCommitGroupMessage)) {
                        ResponseCommitGroupMessage responseCommitGroupMessage = (ResponseCommitGroupMessage) socketResponsedMessage;
                        if (this.this$0.checkAckMsg(responseCommitGroupMessage)) {
                            this.this$0.processMsgACK(responseCommitGroupMessage);
                        }
                    }
                } else if (customResponsedMessage.getCmd() == 2001215 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    GroupData groupData = this.this$0.mGroup;
                    if (groupData == null || groupData.getGroupId() == 0 || chatMessage.getGroupId() == null || !chatMessage.getGroupId().equals(String.valueOf(this.this$0.mGroup.getGroupId()))) {
                        return;
                    }
                    this.this$0.sendMsgFail(chatMessage);
                }
            }
        };
        registerListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkAckMsg(ResponseCommitGroupMessage responseCommitGroupMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, responseCommitGroupMessage)) == null) {
            if (responseCommitGroupMessage == null || this.mGroup == null) {
                return false;
            }
            if (responseCommitGroupMessage.getError() == 0) {
                return responseCommitGroupMessage.getGroupId() != null && responseCommitGroupMessage.getGroupId().equals(String.valueOf(this.mGroup.getGroupId()));
            }
            if (responseCommitGroupMessage.getOrginalMessage() != null && (responseCommitGroupMessage.getOrginalMessage() instanceof CommonGroupChatMessage)) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) responseCommitGroupMessage.getOrginalMessage();
                if (commonGroupChatMessage.getGroupId() != null && commonGroupChatMessage.getGroupId().equals(String.valueOf(this.mGroup.getGroupId()))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            MessageManager.getInstance().registerListener(103112, this.mSocketListener);
            MessageManager.getInstance().registerListener(103102, this.mSocketListener);
            MessageManager.getInstance().registerListener(2016012, this.mCustomListener);
            MessageManager.getInstance().registerListener(2001215, this.mCustomListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMemeber(ResponsedMessage<?> responsedMessage) {
        Message<?> orginalMessage;
        String[] split;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, responsedMessage) == null) && (responsedMessage instanceof ResponseRemoveMembersMessage)) {
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) responsedMessage;
            if (responseRemoveMembersMessage.getError() == 0 && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                RequestRemoveMembersMessage requestRemoveMembersMessage = (RequestRemoveMembersMessage) orginalMessage;
                if (requestRemoveMembersMessage.getGroupId() != this.mGroup.getGroupId()) {
                    return;
                }
                String userIds = requestRemoveMembersMessage.getUserIds();
                if (TextUtils.isEmpty(userIds) || (split = userIds.split(",")) == null || split.length == 0) {
                    return;
                }
                String id = TbadkCoreApplication.getCurrentAccountObj().getID();
                if (TextUtils.isEmpty(id)) {
                    return;
                }
                for (String str : split) {
                    if (id.equals(str)) {
                        this.mLoadDataMode = 9;
                        this.mLoadDataCallBack.c(null);
                        return;
                    }
                }
            }
        }
    }

    private void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mSocketListener);
            MessageManager.getInstance().unRegisterListener(this.mCustomListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataGroupInfo(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, responsedMessage) == null) && (responsedMessage instanceof ResponseUpdateGroupMessage)) {
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) responsedMessage;
            if (responseUpdateGroupMessage.getError() == 0 && responseUpdateGroupMessage.getUpdateGroupInfo() != null) {
                this.mLoadDataMode = 10;
                this.mLoadDataCallBack.c(responseUpdateGroupMessage.getUpdateGroupInfo().getName());
            }
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void deleteMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) || this.mGroup == null || chatMessage == null) {
            return;
        }
        k0.c(new h0<Boolean>(this, chatMessage) { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonGroupMsglistModel this$0;
            public final /* synthetic */ ChatMessage val$msg;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, chatMessage};
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
                this.val$msg = chatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.o0.b1.h0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.p0.j1.h.c.h().c(String.valueOf(this.this$0.mGroup.getGroupId()), String.valueOf(this.val$msg.getMsgId()))) : (Boolean) invokeV.objValue;
            }
        }, null);
    }

    public GroupData getGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mGroup : (GroupData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getGroup() != null) {
                return b.o().p(String.valueOf(getGroup().getGroupId()), this.customGroupType);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void markDeleteMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) || this.mGroup == null || chatMessage == null) {
            return;
        }
        k0.c(new h0<Boolean>(this, chatMessage) { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonGroupMsglistModel this$0;
            public final /* synthetic */ ChatMessage val$msg;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, chatMessage};
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
                this.val$msg = chatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.o0.b1.h0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.p0.j1.h.c.h().m(String.valueOf(this.this$0.mGroup.getGroupId()), String.valueOf(this.val$msg.getMsgId()))) : (Boolean) invokeV.objValue;
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            unRegisterListener();
        }
    }

    public List<ChatMessage> processServerMsg(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        LinkedList<ChatMessage> listMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, responsedMessage)) == null) {
            if (responsedMessage instanceof GroupMsgData) {
                GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
                if (getGroup() != null && groupMsgData.getGroupInfo() != null && groupMsgData.getGroupInfo().getGroupId() == getGroup().getGroupId() && (listMessage = groupMsgData.getListMessage()) != null) {
                    return processMsgFromServerCommon(listMessage);
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void setGroup(GroupData groupData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, groupData) == null) {
            this.mGroup = groupData;
            if (groupData != null) {
                this.mId = groupData.getGroupId();
            } else {
                this.mId = 0L;
            }
        }
    }
}
