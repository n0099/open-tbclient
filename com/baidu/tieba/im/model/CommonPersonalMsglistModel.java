package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a97;
/* loaded from: classes3.dex */
public abstract class CommonPersonalMsglistModel extends MsglistModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener mCustomListener;
    public UserData mUser;

    public CommonPersonalMsglistModel() {
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
        this.mUser = null;
        this.mCustomListener = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.CommonPersonalMsglistModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonPersonalMsglistModel this$0;

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
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2016012) {
                    if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                        return;
                    }
                    SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                    if (socketResponsedMessage.getCmd() == 205001 && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                        this.this$0.processMsgACK((ResponseCommitPersonalMessage) socketResponsedMessage);
                    }
                } else if (customResponsedMessage.getCmd() == 2001215 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    UserData userData = this.this$0.mUser;
                    if (userData == null || userData.getUserId() == null) {
                        return;
                    }
                    if (this.this$0.mUser.getUserId().equals(String.valueOf(a97.o(chatMessage)))) {
                        this.this$0.sendMsgFail(chatMessage);
                    }
                }
            }
        };
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            MessageManager.getInstance().registerListener(2016012, this.mCustomListener);
            MessageManager.getInstance().registerListener(2001215, this.mCustomListener);
        }
    }

    private void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mCustomListener);
        }
    }

    public UserData getUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mUser : (UserData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            unRegisterListener();
        }
    }

    public void setUser(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, userData) == null) {
            this.mUser = userData;
            if (userData != null) {
                this.mId = userData.getUserIdLong();
            } else {
                this.mId = 0L;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonPersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MsglistActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUser = null;
        this.mCustomListener = new CustomMessageListener(this, 0) { // from class: com.baidu.tieba.im.model.CommonPersonalMsglistModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonPersonalMsglistModel this$0;

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
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2016012) {
                    if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                        return;
                    }
                    SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                    if (socketResponsedMessage.getCmd() == 205001 && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                        this.this$0.processMsgACK((ResponseCommitPersonalMessage) socketResponsedMessage);
                    }
                } else if (customResponsedMessage.getCmd() == 2001215 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    UserData userData = this.this$0.mUser;
                    if (userData == null || userData.getUserId() == null) {
                        return;
                    }
                    if (this.this$0.mUser.getUserId().equals(String.valueOf(a97.o(chatMessage)))) {
                        this.this$0.sendMsgFail(chatMessage);
                    }
                }
            }
        };
        registerListener();
    }
}
