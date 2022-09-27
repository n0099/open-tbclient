package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryItemRemoveMessage;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.rb;
import com.baidu.tieba.sa7;
import com.baidu.tieba.sc7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Static {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDismissGroupMessage) && socketResponsedMessage.getError() == 0) {
                String valueOf = String.valueOf(((ResponseDismissGroupMessage) socketResponsedMessage).getGroupId());
                MemoryItemRemoveMessage.a aVar = new MemoryItemRemoveMessage.a();
                aVar.a = 1;
                aVar.b = valueOf;
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryItemRemoveMessage(aVar));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddGroupMessage) && socketResponsedMessage.getError() == 0) {
                ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
                RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGroup_name(requestAddGroupMessage.getName());
                imMessageCenterPojo.setCustomGroupType(sa7.a(requestAddGroupMessage.getGroupType()));
                AddGroupInfoData addGroupInfo = responseAddGroupMessage.getAddGroupInfo();
                if (addGroupInfo == null) {
                    return;
                }
                imMessageCenterPojo.setGroup_head(addGroupInfo.getPortrait());
                imMessageCenterPojo.setGid(String.valueOf(addGroupInfo.getGroupId()));
                imMessageCenterPojo.setPulled_msgId(sc7.a(1L));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016016, imMessageCenterPojo));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String userIds;
            String[] split;
            String id;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103112 && (socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
                if (responseRemoveMembersMessage.getError() != 0 || responseRemoveMembersMessage.getOrginalMessage() == null || !(responseRemoveMembersMessage.getOrginalMessage() instanceof RequestRemoveMembersMessage) || (userIds = ((RequestRemoveMembersMessage) responseRemoveMembersMessage.getOrginalMessage()).getUserIds()) == null || userIds.length() == 0 || (split = userIds.split(",")) == null || split.length == 0 || (id = TbadkCoreApplication.getCurrentAccountObj().getID()) == null || id.length() == 0) {
                    return;
                }
                for (String str : split) {
                    if (id.equals(str)) {
                        MemoryItemRemoveMessage.a aVar = new MemoryItemRemoveMessage.a();
                        aVar.a = 1;
                        aVar.b = responseRemoveMembersMessage.getGroupId();
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryItemRemoveMessage(aVar));
                        return;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1318012368, "Lcom/baidu/tieba/im/Static;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1318012368, "Lcom/baidu/tieba/im/Static;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(103104, new a(0));
        MessageManager.getInstance().registerListener(new b(103101));
        MessageManager.getInstance().registerListener(103112, new c(0));
    }

    public Static() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
