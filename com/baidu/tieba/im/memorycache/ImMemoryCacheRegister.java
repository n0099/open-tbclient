package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import c.a.r0.l1.f.l.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.GroupMemberChangeResponsedMessage;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.MemoryItemRemoveMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import com.baidu.tieba.im.message.MemoryUpdateHeadNameMessage;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseMemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.model.ModelHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ImMemoryCacheRegister {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ImMemoryCacheRegister D;
    public transient /* synthetic */ FieldHolder $fh;
    public a.b A;
    public a.b B;
    public a.b C;

    /* renamed from: a  reason: collision with root package name */
    public ResponseOnlineMessage f53186a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.c.g.c f53187b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e.c.g.c f53188c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f53189d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f53190e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f53191f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f53192g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f53193h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.e.c.g.c f53194i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f53195j;
    public CustomMessageListener k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageTask.CustomRunnable<Integer> q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public c.a.e.c.g.c t;
    public CustomMessageListener u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public a.b y;
    public a.b z;

    /* loaded from: classes7.dex */
    public class OnlineToDbCustomMessage extends CustomMessage<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ImMessageCenterPojo> needCreateGroupList;
        public List<ImMessageCenterPojo> needDeleteGroupList;
        public ImMessageCenterPojo notifyGroup;
        public ImMessageCenterPojo officialChatGroup;
        public ImMessageCenterPojo privateChatGroup;
        public ImMessageCenterPojo systemGroup;
        public final /* synthetic */ ImMemoryCacheRegister this$0;
        public List<ImMessageCenterPojo> yyGroupList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnlineToDbCustomMessage(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = imMemoryCacheRegister;
            this.needCreateGroupList = null;
            this.systemGroup = null;
            this.notifyGroup = null;
            this.privateChatGroup = null;
            this.officialChatGroup = null;
            this.yyGroupList = null;
            this.needDeleteGroupList = null;
        }
    }

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1773a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53196e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ChatMessage f53197f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SocketResponsedMessage f53198g;

            public C1773a(a aVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, imMessageCenterPojo, chatMessage, socketResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53196e = imMessageCenterPojo;
                this.f53197f = chatMessage;
                this.f53198g = socketResponsedMessage;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                        return null;
                    }
                    try {
                        try {
                            c.a.r0.l1.h.h.e().i();
                            c.a.r0.l1.h.j.f().k(this.f53196e, 3);
                            c.a.r0.l1.h.c.h().o(this.f53197f.getGroupId(), String.valueOf(this.f53197f.getRecordId()), String.valueOf(this.f53197f.getMsgId()), this.f53197f.getLocalData().getStatus().shortValue());
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                        c.a.r0.l1.h.h.e().c();
                        return new CustomResponsedMessage<>(2016012, this.f53198g);
                    } catch (Throwable th) {
                        c.a.r0.l1.h.h.e().c();
                        throw th;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseCommitGroupMessage)) {
                    return;
                }
                ChatMessage chatMessage = (ChatMessage) socketResponsedMessage.getOrginalMessage();
                if (chatMessage.getLocalData() == null) {
                    chatMessage.setLocalData(new MsgLocalData());
                }
                if (socketResponsedMessage.hasError()) {
                    chatMessage.getLocalData().setStatus((short) 2);
                } else {
                    chatMessage.getLocalData().setStatus((short) 3);
                    ResponseCommitGroupMessage responseCommitGroupMessage = (ResponseCommitGroupMessage) socketResponsedMessage;
                    long msgId = responseCommitGroupMessage.getMsgId();
                    long recordId = responseCommitGroupMessage.getRecordId();
                    chatMessage.setMsgId(msgId);
                    chatMessage.setRecordId(recordId);
                }
                c.a.q0.s.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), IMTrackDatabase.AckEnum.TABLE_NAME, socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), new Object[0]);
                c.a.r0.l1.k.b.o().X(chatMessage.getCustomGroupType(), chatMessage, chatMessage.getGroupId(), 3);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new C1773a(this, c.a.r0.l1.k.b.o().i(chatMessage.getGroupId(), chatMessage.getCustomGroupType()), chatMessage, socketResponsedMessage));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ MemoryClearStrangerItemsMessage f53199e;

            public a(a0 a0Var, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a0Var, memoryClearStrangerItemsMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53199e = memoryClearStrangerItemsMessage;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                        return null;
                    }
                    try {
                        try {
                            c.a.r0.l1.h.h.e().i();
                            c.a.r0.l1.h.j.f().b();
                            if (this.f53199e.isAllClear()) {
                                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                imMessageCenterPojo.setCustomGroupType(-7);
                                imMessageCenterPojo.setIs_hidden(1);
                                c.a.r0.l1.h.j.f().j(imMessageCenterPojo);
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                        return null;
                    } finally {
                        c.a.r0.l1.h.h.e().c();
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage;
            MemoryClearStrangerItemsMessage.a data;
            List<MemoryModifyVisibilityMessage.a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof MemoryClearStrangerItemsMessage) || (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) == null || (list = data.f53236a) == null) {
                return;
            }
            for (MemoryModifyVisibilityMessage.a aVar : list) {
                c.a.r0.l1.k.b.o().H(aVar.f53243a, aVar.f53244b);
            }
            if (memoryClearStrangerItemsMessage.isAllClear()) {
                c.a.r0.l1.k.b.o().B(TbEnum.CustomGroupId.STRANGE_MERGE, -7, false);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, memoryClearStrangerItemsMessage));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMemoryCacheRegister f53200a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53200a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002 && (customResponsedMessage instanceof MemoryInitCompleteMessage)) {
                this.f53200a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMemoryCacheRegister f53201a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53201a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof MemoryItemRemoveMessage.a)) {
                return;
            }
            MemoryItemRemoveMessage.a aVar = (MemoryItemRemoveMessage.a) customResponsedMessage.getData();
            if (aVar.f53237a == 1) {
                this.f53201a.l(aVar.f53238b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMemoryCacheRegister f53202a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53202a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005018) {
                this.f53202a.f53186a = null;
                c.a.r0.l1.s.a.x(0L);
                c.a.r0.l1.s.a.w(0L);
                c.a.r0.l1.k.b.o().w();
                c.a.q0.t.d.c.k().l();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMemoryCacheRegister f53203a;

        /* loaded from: classes7.dex */
        public class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c0 c0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.r0.l1.f.l.a.b
            public void a(String str, List<CommonMsgPojo> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                }
            }

            @Override // c.a.r0.l1.f.l.a.b
            public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                    return;
                }
                c.a.r0.l1.k.b.o().V(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53203a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof GroupMsgData)) {
                GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
                if (groupMsgData.getGroupInfo() == null) {
                    return;
                }
                if (groupMsgData.getGroupInfo().getGroupId() == 0) {
                    BdLog.e("groupMsgData.getGroupInfo().getGroupId() == 0");
                }
                String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
                int customType = groupMsgData.getGroupInfo().getCustomType();
                if (TextUtils.isEmpty(valueOf)) {
                    return;
                }
                ImMessageCenterPojo i2 = c.a.r0.l1.k.b.o().i(valueOf, customType);
                if (groupMsgData.getCmd() == 2012125) {
                    c.a.r0.l1.f.l.b.a(groupMsgData, i2, this.f53203a.y);
                } else if (groupMsgData.getCmd() == 2012124) {
                    c.a.r0.l1.f.l.c.a(groupMsgData, i2, this.f53203a.A);
                } else if (groupMsgData.getCmd() == 2012123) {
                    c.a.r0.l1.f.l.d.a(groupMsgData, i2, this.f53203a.B);
                } else if (groupMsgData.getCmd() == 2012121) {
                    c.a.r0.l1.f.l.e.b(groupMsgData, i2, this.f53203a.C);
                } else if (groupMsgData.getCmd() == 2012120) {
                    c.a.r0.l1.f.l.f.f(groupMsgData, i2, this.f53203a.z);
                } else if (groupMsgData.getCmd() == 2012128) {
                    if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().size() <= 0) {
                        return;
                    }
                    c.a.r0.l1.k.b.o().V(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(c.a.r0.l1.s.a.f21765i));
                } else if (groupMsgData.getCmd() == 2012129) {
                    if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().size() <= 0) {
                        return;
                    }
                    ChatMessage chatMessage = groupMsgData.getListMessage().get(0);
                    if (chatMessage.isPushForOperateAccount()) {
                        return;
                    }
                    c.a.r0.l1.k.b.o().V(-9, chatMessage.getMsgId(), String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
                } else if (groupMsgData.getCmd() == 2012126) {
                    if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                        c.a.r0.l1.f.l.g.d(groupMsgData, i2, new a(this));
                    } else {
                        long[] a2 = c.a.r0.l1.f.l.g.b().a(groupMsgData);
                        if (a2 != null && a2.length == 2) {
                            if (a2[0] > 0 || a2[1] <= 0) {
                                return;
                            }
                            if (a2[0] == 12) {
                                c.a.r0.l1.k.b.o().V(8, a2[1], String.valueOf(12));
                            } else if (a2[0] == 11) {
                                c.a.r0.l1.k.b.o().V(7, a2[1], String.valueOf(11));
                            }
                        }
                    }
                    c.a.r0.l1.f.l.g.b().e(groupMsgData);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53204e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53205f;

            public a(d dVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, imMessageCenterPojo, imMessageCenterPojo2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53204e = imMessageCenterPojo;
                this.f53205f = imMessageCenterPojo2;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    c.a.r0.l1.h.j.f().k(this.f53204e, 2);
                    if (this.f53205f != null) {
                        c.a.r0.l1.h.j.f().k(this.f53205f, 2);
                        return null;
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyLastMsgMessage.a data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016003 || (data = ((MemoryModifyLastMsgMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            c.a.r0.l1.k.b.o().X(data.f53240b, data.f53241c, data.f53239a, data.f53242d);
            ImMessageCenterPojo i2 = c.a.r0.l1.k.b.o().i(data.f53239a, data.f53240b);
            if (i2 == null) {
                return;
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2, i2.getCustomGroupType() == 4 ? c.a.r0.l1.k.b.o().i(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8) : null));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes7.dex */
    public class d0 extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMemoryCacheRegister f53206a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53206a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                this.f53206a.f53186a = (ResponseOnlineMessage) socketResponsedMessage;
                if (c.a.r0.l1.k.b.o().f21649a.get()) {
                    this.f53206a.k();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2008016) {
                c.a.r0.l1.k.b.o().J();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e0(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage instanceof OnlineToDbCustomMessage)) {
                    return null;
                }
                OnlineToDbCustomMessage onlineToDbCustomMessage = (OnlineToDbCustomMessage) customMessage;
                try {
                    try {
                        c.a.r0.l1.h.h.e().i();
                        if (onlineToDbCustomMessage.needCreateGroupList != null) {
                            c.a.r0.l1.h.c.h().b(onlineToDbCustomMessage.needCreateGroupList);
                            for (ImMessageCenterPojo imMessageCenterPojo : onlineToDbCustomMessage.needCreateGroupList) {
                                c.a.r0.l1.h.j.f().j(imMessageCenterPojo);
                            }
                        }
                        if (onlineToDbCustomMessage.systemGroup != null) {
                            c.a.r0.l1.h.j.f().j(onlineToDbCustomMessage.systemGroup);
                        }
                        if (onlineToDbCustomMessage.privateChatGroup != null) {
                            c.a.r0.l1.h.j.f().j(onlineToDbCustomMessage.privateChatGroup);
                        }
                        if (onlineToDbCustomMessage.officialChatGroup != null) {
                            c.a.r0.l1.h.j.f().j(onlineToDbCustomMessage.officialChatGroup);
                        }
                        if (onlineToDbCustomMessage.notifyGroup != null) {
                            c.a.r0.l1.h.j.f().j(onlineToDbCustomMessage.notifyGroup);
                        }
                        if (onlineToDbCustomMessage.yyGroupList != null) {
                            for (ImMessageCenterPojo imMessageCenterPojo2 : onlineToDbCustomMessage.yyGroupList) {
                                if (imMessageCenterPojo2.getCustomGroupType() == 6) {
                                    c.a.r0.l1.h.j.f().j(imMessageCenterPojo2);
                                } else {
                                    c.a.r0.l1.f.l.g.b().f(imMessageCenterPojo2.getGid(), c.a.r0.l1.w.b.c(imMessageCenterPojo2.getPulled_msgId()));
                                }
                            }
                        }
                        if (onlineToDbCustomMessage.needDeleteGroupList != null) {
                            for (ImMessageCenterPojo imMessageCenterPojo3 : onlineToDbCustomMessage.needDeleteGroupList) {
                                if (imMessageCenterPojo3 != null) {
                                    c.a.r0.l1.h.j.f().c(imMessageCenterPojo3.getGid(), imMessageCenterPojo3.getCustomGroupType());
                                }
                            }
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    return null;
                } finally {
                    c.a.r0.l1.h.h.e().c();
                }
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53207e;

            public a(f fVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53207e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage != null && customMessage.getData() != null) {
                        c.a.r0.l1.h.j.f().j(this.f53207e);
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyVisibilityMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016005 && (customResponsedMessage instanceof MemoryModifyVisibilityMessage) && (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) != null) {
                ImMessageCenterPojo i2 = c.a.r0.l1.k.b.o().i(data.f53243a, data.f53244b);
                int i3 = !data.f53245c ? 1 : 0;
                if (i2 == null || i3 == i2.getIs_hidden()) {
                    return;
                }
                int i4 = data.f53244b;
                if (i4 == 2) {
                    c.a.q0.t.d.b.g0().s(data.f53243a);
                } else if (i4 == 4) {
                    c.a.q0.t.d.b.g0().r(c.a.e.e.m.b.e(data.f53243a, 0));
                } else if (i4 == -3) {
                    c.a.q0.t.d.b.g0().f(2);
                } else if (i4 == -4) {
                    c.a.q0.t.d.b.g0().f(1);
                } else {
                    c.a.q0.t.d.b.g0().d(data.f53243a);
                }
                c.a.r0.l1.k.b.o().B(data.f53243a, data.f53244b, data.f53245c);
                i2.setIs_hidden(i3);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<MemoryClearUnreadCountMessage.a> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    MemoryClearUnreadCountMessage.a data = customMessage.getData();
                    c.a.r0.l1.h.j.f().a(data.f48426a, data.f48427b);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearUnreadCountMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016006 && (customResponsedMessage instanceof MemoryClearUnreadCountMessage) && (data = ((MemoryClearUnreadCountMessage) customResponsedMessage).getData()) != null) {
                ImMessageCenterPojo i2 = c.a.r0.l1.k.b.o().i(data.f48426a, data.f48427b);
                if (i2 == null) {
                    BdLog.e("ClearUnreadCountMessage:  not find memery pojo");
                } else if (i2.getUnread_count() == 0) {
                } else {
                    c.a.r0.l1.k.b.o().h(data.f48426a, data.f48427b);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53208e;

            public a(h hVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53208e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    try {
                        try {
                            c.a.r0.l1.h.h.e().i();
                            c.a.r0.l1.h.j.f().j(this.f53208e);
                            c.a.r0.l1.h.c.h().a(this.f53208e.getGid());
                        } catch (Exception e2) {
                            BdLog.detailException(e2);
                        }
                        c.a.r0.l1.h.h.e().c();
                        return null;
                    } catch (Throwable th) {
                        c.a.r0.l1.h.h.e().c();
                        throw th;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ImMessageCenterPojo)) {
                return;
            }
            ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData();
            c.a.r0.l1.k.b.o().a0(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes7.dex */
    public class i implements CustomMessageTask.CustomRunnable<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                List<ImMessageCenterPojo> list = null;
                if (customMessage == null || !(customMessage instanceof RequestMemoryListMessage)) {
                    return null;
                }
                int intValue = ((RequestMemoryListMessage) customMessage).getData().intValue();
                if (intValue == 3) {
                    list = c.a.r0.l1.k.b.o().m();
                } else if (intValue == 2) {
                    list = c.a.r0.l1.k.b.o().l();
                } else if (intValue == 1) {
                    list = c.a.r0.l1.k.b.o().k();
                } else if (intValue == 4) {
                    list = c.a.r0.l1.k.b.o().u();
                }
                return new ResponsedMemoryListMessage(list, intValue);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMemoryCacheRegister f53209a;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53210e;

            public a(j jVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53210e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    c.a.r0.l1.h.j.f().j(this.f53210e);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53211e;

            public b(j jVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53211e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    c.a.r0.l1.h.j.f().j(this.f53211e);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class c implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53212e;

            public c(j jVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53212e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    try {
                        try {
                            c.a.r0.l1.h.h.e().i();
                            c.a.r0.l1.h.c.h().a(this.f53212e.getGid());
                            c.a.r0.l1.h.j.f().j(this.f53212e);
                        } catch (Exception e2) {
                            BdLog.detailException(e2);
                        }
                        c.a.r0.l1.h.h.e().c();
                        return new CustomResponsedMessage<>(2001214);
                    } catch (Throwable th) {
                        c.a.r0.l1.h.h.e().c();
                        throw th;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53209a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            UpdatesItemData convertToUpdatesItem;
            ImMessageCenterPojo i2;
            UpdatesItemData convertToUpdatesItem2;
            ImMessageCenterPojo i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null) {
                return;
            }
            String cmd = p.getCmd();
            if (TextUtils.isEmpty(cmd)) {
                return;
            }
            if (c.a.r0.l1.f.l.f.d(cmd)) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.GROUP_UPDATE);
                imMessageCenterPojo.setCustomGroupType(-3);
                imMessageCenterPojo.setLast_content(c.a.r0.l1.f.l.f.c(cmd, p.getContent()));
                imMessageCenterPojo.setLast_content_time(p.getTime());
                imMessageCenterPojo.setLast_rid(c.a.e.e.m.b.g(p.getNotice_id(), 0L));
                c.a.r0.l1.k.b.o().U(imMessageCenterPojo, !ChatStatusManager.getInst().getIsOpen(6));
            } else if (c.a.r0.l1.f.l.f.e(cmd)) {
                ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
                imMessageCenterPojo2.setCustomGroupType(-4);
                imMessageCenterPojo2.setLast_content(c.a.r0.l1.f.l.f.c(cmd, p.getContent()));
                imMessageCenterPojo2.setLast_content_time(p.getTime());
                imMessageCenterPojo2.setLast_rid(c.a.e.e.m.b.g(p.getNotice_id(), 0L));
                c.a.r0.l1.k.b.o().U(imMessageCenterPojo2, !ChatStatusManager.getInst().getIsOpen(7));
            }
            if (cmd.equals("group_head_change")) {
                if (ModelHelper.getInstance().getUpdatasModel() == null || (convertToUpdatesItem2 = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) == null) {
                    return;
                }
                String groupId = convertToUpdatesItem2.getGroupId();
                if (TextUtils.isEmpty(groupId) || TextUtils.isEmpty(convertToUpdatesItem2.getGroupHeadUrl()) || (i3 = c.a.r0.l1.k.b.o().i(groupId, 1)) == null) {
                    return;
                }
                if (i3.getGroup_head() == null || !i3.getGroup_head().equals(convertToUpdatesItem2.getGroupHeadUrl())) {
                    c.a.r0.l1.k.b.o().R(groupId, convertToUpdatesItem2.getGroupHeadUrl());
                    i3.setGroup_head(convertToUpdatesItem2.getGroupHeadUrl());
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i3));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            } else if (cmd.equals("group_name_change")) {
                if (ModelHelper.getInstance().getUpdatasModel() == null || (convertToUpdatesItem = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) == null) {
                    return;
                }
                String groupId2 = convertToUpdatesItem.getGroupId();
                if (TextUtils.isEmpty(groupId2) || TextUtils.isEmpty(convertToUpdatesItem.getGroupName()) || (i2 = c.a.r0.l1.k.b.o().i(groupId2, 1)) == null) {
                    return;
                }
                if (i2.getGroup_name() == null || !i2.getGroup_name().equals(convertToUpdatesItem.getGroupName())) {
                    c.a.r0.l1.k.b.o().S(groupId2, convertToUpdatesItem.getGroupName());
                    i2.setGroup_name(convertToUpdatesItem.getGroupName());
                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new b(this, i2));
                    customMessageTask2.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask2.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask2.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask2);
                }
            } else if (cmd.equals("apply_join_success")) {
                String content = p.getContent();
                if (TextUtils.isEmpty(content)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(content);
                    jSONObject.put("notice_id", p.getNotice_id());
                    JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                    String optString2 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_IMAGE);
                    String optString3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                    long optLong = optJSONObject.optLong(TbEnum.SystemMessage.KEY_LAST_MSG_ID);
                    c.a.r0.l1.t.b.k().p(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                    c.a.r0.l1.t.b.k().o(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                    imMessageCenterPojo3.setGroup_name(optString3);
                    imMessageCenterPojo3.setCustomGroupType(1);
                    imMessageCenterPojo3.setGid(optString);
                    imMessageCenterPojo3.setGroup_head(optString2);
                    imMessageCenterPojo3.setLast_content_time(p.getTime());
                    imMessageCenterPojo3.setIs_hidden(0);
                    imMessageCenterPojo3.setUnread_count(0);
                    imMessageCenterPojo3.setLast_content(" ");
                    imMessageCenterPojo3.setLast_rid(c.a.r0.l1.w.b.a(optLong));
                    imMessageCenterPojo3.setPulled_msgId(c.a.r0.l1.w.b.a(optLong));
                    c.a.r0.l1.k.b.o().Z(imMessageCenterPojo3);
                    c.a.r0.l1.k.b.o().V(1, c.a.r0.l1.w.b.a(optLong), optString);
                    CustomMessageTask customMessageTask3 = new CustomMessageTask(2001000, new c(this, imMessageCenterPojo3));
                    customMessageTask3.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask3.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask3.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001213), customMessageTask3);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            } else if (cmd.equals("dismiss_group") || cmd.equals("kick_out")) {
                String gid = p.getGid();
                if (TextUtils.isEmpty(gid)) {
                    return;
                }
                this.f53209a.l(gid);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53213e;

            public a(k kVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53213e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    c.a.r0.l1.h.j.f().j(this.f53213e);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f53214e;

            public b(k kVar, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53214e = j2;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    try {
                        try {
                            c.a.r0.l1.h.h.e().i();
                            c.a.r0.l1.h.j.f().c(String.valueOf(this.f53214e), 2);
                            c.a.r0.l1.h.m.t().e(String.valueOf(this.f53214e));
                        } catch (Exception e2) {
                            BdLog.detailException(e2);
                        }
                        c.a.r0.l1.h.h.e().c();
                        return null;
                    } catch (Throwable th) {
                        c.a.r0.l1.h.h.e().c();
                        throw th;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                int action = responseNewFriendUpdateUiMsg.getAction();
                if (action != 0) {
                    if (action == 1) {
                        c.a.r0.l1.k.b.o().G(String.valueOf(friendId), 2);
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new b(this, friendId));
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                        return;
                    }
                    return;
                }
                ImMessageCenterPojo i2 = c.a.r0.l1.k.b.o().i(String.valueOf(friendId), 2);
                if (i2 != null) {
                    i2.setIsFriend(1);
                    i2.setFollowStatus(1);
                    c.a.r0.l1.k.b.o().Z(i2);
                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new a(this, i2));
                    customMessageTask2.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask2.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask2.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53215e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ChatMessage f53216f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SocketResponsedMessage f53217g;

            public a(l lVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, imMessageCenterPojo, chatMessage, socketResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53215e = imMessageCenterPojo;
                this.f53216f = chatMessage;
                this.f53217g = socketResponsedMessage;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage != null) {
                        try {
                            if (customMessage instanceof CustomMessage) {
                                try {
                                    c.a.r0.l1.h.h.e().i();
                                    c.a.r0.l1.h.j.f().k(this.f53215e, 3);
                                    if (this.f53215e.getCustomGroupType() == 2) {
                                        c.a.r0.l1.h.m.t().s(this.f53216f.getUserId(), this.f53216f.getToUserId(), String.valueOf(this.f53216f.getRecordId()), String.valueOf(this.f53216f.getMsgId()), this.f53216f.getLocalData().getStatus().shortValue());
                                    } else {
                                        c.a.r0.l1.h.l.t().s(this.f53216f.getUserId(), this.f53216f.getToUserId(), String.valueOf(this.f53216f.getRecordId()), String.valueOf(this.f53216f.getMsgId()), this.f53216f.getLocalData().getStatus().shortValue());
                                    }
                                } catch (Exception e2) {
                                    BdLog.e(e2.getMessage());
                                }
                                c.a.r0.l1.h.h.e().c();
                                return new CustomResponsedMessage<>(2016012, this.f53217g);
                            }
                            return null;
                        } catch (Throwable th) {
                            c.a.r0.l1.h.h.e().c();
                            throw th;
                        }
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            ImMessageCenterPojo i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                    return;
                }
                ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) socketResponsedMessage;
                ChatMessage chatMessage = (ChatMessage) responseCommitPersonalMessage.getOrginalMessage();
                int toUserType = responseCommitPersonalMessage.getToUserType();
                if (socketResponsedMessage.hasError()) {
                    chatMessage.getLocalData().setStatus((short) 2);
                } else {
                    long msgId = responseCommitPersonalMessage.getMsgId();
                    long recordId = responseCommitPersonalMessage.getRecordId();
                    chatMessage.setMsgId(msgId);
                    chatMessage.setRecordId(recordId);
                    chatMessage.getLocalData().setStatus((short) 3);
                    if (responseCommitPersonalMessage.getToUserType() == 0) {
                        c.a.r0.l1.s.a.x(c.a.e.e.m.b.g(responseCommitPersonalMessage.getGroupId(), 0L));
                    } else {
                        c.a.r0.l1.s.a.w(c.a.e.e.m.b.g(responseCommitPersonalMessage.getGroupId(), 0L));
                    }
                }
                long clientLogID = chatMessage.getClientLogID();
                int cmd = chatMessage.getCmd();
                int error = socketResponsedMessage.getError();
                String errorString = socketResponsedMessage.getErrorString();
                c.a.q0.s.z.a.a("im", clientLogID, cmd, IMTrackDatabase.AckEnum.TABLE_NAME, error, errorString, "comment", "uType " + toUserType, "touid", Long.valueOf(chatMessage.getToUserId()), "content", chatMessage.getContent());
                boolean z = chatMessage instanceof PersonalChatMessage;
                if (z) {
                    c.a.r0.l1.k.b.o().X(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else if (!(chatMessage instanceof OfficialChatMessage)) {
                    return;
                } else {
                    c.a.r0.l1.k.b.o().X(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                }
                if (z) {
                    i2 = c.a.r0.l1.k.b.o().i(String.valueOf(c.a.r0.l1.w.c.m(chatMessage)), 2);
                } else if (!(chatMessage instanceof OfficialChatMessage)) {
                    return;
                } else {
                    i2 = c.a.r0.l1.k.b.o().i(String.valueOf(c.a.r0.l1.w.c.m(chatMessage)), 4);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2, chatMessage, socketResponsedMessage));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53218e;

            public a(m mVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53218e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    try {
                        c.a.r0.l1.h.j.f().j(this.f53218e);
                        return null;
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                        return null;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205006 && (socketResponsedMessage instanceof ResponsedPersonalMsgReadMessage)) {
                ResponsedPersonalMsgReadMessage responsedPersonalMsgReadMessage = (ResponsedPersonalMsgReadMessage) socketResponsedMessage;
                if (!responsedPersonalMsgReadMessage.hasError() && responsedPersonalMsgReadMessage.getGroupId() == c.a.r0.l1.s.a.f21765i.longValue() && responsedPersonalMsgReadMessage.getToUserType() == 0) {
                    ImMessageCenterPojo i2 = c.a.r0.l1.k.b.o().i(String.valueOf(responsedPersonalMsgReadMessage.getToUid()), 2);
                    if (i2 == null) {
                        return;
                    }
                    long a2 = c.a.r0.l1.w.b.a(responsedPersonalMsgReadMessage.getHasSentMsgId());
                    if (a2 <= i2.getSent_msgId()) {
                        return;
                    }
                    i2.setSent_msgId(a2);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53219e;

            public a(n nVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53219e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    try {
                        try {
                            c.a.r0.l1.h.h.e().i();
                            c.a.r0.l1.h.j.f().j(this.f53219e);
                            if (this.f53219e.getCustomGroupType() == 1) {
                                c.a.r0.l1.h.c.h().a(this.f53219e.getGid());
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                        c.a.r0.l1.h.h.e().c();
                        return new ResponseMemoryNotifyUpdataGroupMessage(this.f53219e);
                    } catch (Throwable th) {
                        c.a.r0.l1.h.h.e().c();
                        throw th;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016013 || (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) == null) {
                return;
            }
            c.a.r0.l1.k.b.o().W(imMessageCenterPojo);
            c.a.r0.l1.k.b.o().Y(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes7.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53220e;

            public a(o oVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53220e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage == null) {
                        return null;
                    }
                    c.a.r0.l1.h.j.f().k(this.f53220e, 2);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof MemoryUpdateHeadNameMessage.a)) {
                return;
            }
            MemoryUpdateHeadNameMessage.a aVar = (MemoryUpdateHeadNameMessage.a) customResponsedMessage.getData();
            if (TextUtils.isEmpty(aVar.f53248c)) {
                return;
            }
            if ((TextUtils.isEmpty(aVar.f53246a) && TextUtils.isEmpty(aVar.f53247b)) || (i2 = c.a.r0.l1.k.b.o().i(aVar.f53248c, aVar.f53249d)) == null) {
                return;
            }
            String str = aVar.f53247b;
            String str2 = aVar.f53246a;
            if (!TextUtils.isEmpty(str)) {
                c.a.r0.l1.k.b.o().S(aVar.f53248c, str);
            }
            if (!TextUtils.isEmpty(aVar.f53246a)) {
                c.a.r0.l1.k.b.o().R(aVar.f53248c, str2);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes7.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f53221e;

            public a(p pVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53221e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    c.a.r0.l1.h.j.f().k(this.f53221e, 1);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof PersonalChatMessage) {
                c.a.r0.l1.k.b.o().V(-1, ((PersonalChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(c.a.r0.l1.s.a.f21765i));
                i2 = c.a.r0.l1.k.b.o().i(String.valueOf(c.a.r0.l1.s.a.f21765i), -1);
            } else if (customResponsedMessage.getData() instanceof OfficialChatMessage) {
                c.a.r0.l1.k.b.o().V(-9, ((OfficialChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(c.a.r0.l1.s.a.f21766j));
                i2 = c.a.r0.l1.k.b.o().i(String.valueOf(c.a.r0.l1.s.a.f21766j), -9);
            } else {
                ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                c.a.r0.l1.k.b.o().V(1, chatMessage.getMsgId(), chatMessage.getGroupId());
                i2 = c.a.r0.l1.k.b.o().i(chatMessage.getGroupId(), 1);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes7.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f53222e;

            public a(q qVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53222e = list;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    for (ImMessageCenterPojo imMessageCenterPojo : this.f53222e) {
                        c.a.r0.l1.h.j.f().j(imMessageCenterPojo);
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<ImMessageCenterPojo> l;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (l = c.a.r0.l1.k.b.o().l()) == null || l.size() == 0) {
                return;
            }
            for (ImMessageCenterPojo imMessageCenterPojo : l) {
                imMessageCenterPojo.setTaskId("");
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, l));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes7.dex */
    public class r implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) || list == null || list.size() == 0) {
                return;
            }
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo.getMsg_type() == 11) {
                    try {
                        String optString = new JSONObject(commonMsgPojo.getContent()).optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                        if (TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN.equals(optString) || TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT.equals(optString)) {
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new GroupMemberChangeResponsedMessage(str));
                        }
                    } catch (JSONException e2) {
                        BdLog.detailException(e2);
                    }
                }
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                c.a.r0.l1.k.b.o().T(imMessageCenterPojo);
                c.a.r0.l1.k.b.o().V(1, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
                if (z) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                c.a.r0.l1.k.b.o().V(-2, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) || list == null || list.size() == 0) {
                return;
            }
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 10) {
                    c.a.r0.l1.f.l.a.b(commonMsgPojo.getContent());
                }
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                c.a.r0.l1.k.b.o().V(5, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
                if (z) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(2));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public u(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                        RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                        c.a.r0.l1.g.d i2 = c.a.r0.l1.w.c.i(commonMsgPojo);
                        if (i2 != null) {
                            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "message_receive", "receive", 1, "task_type", i2.f21526a, "task_id", i2.f21527b);
                        }
                    }
                }
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                c.a.r0.l1.k.b.o().T(imMessageCenterPojo);
                if (z) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public v(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // c.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                c.a.r0.l1.k.b.o().T(imMessageCenterPojo);
                if (z) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53223e;

        public w(ImMemoryCacheRegister imMemoryCacheRegister, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53223e = str;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                    return null;
                }
                try {
                    try {
                        c.a.r0.l1.h.h.e().i();
                        c.a.r0.l1.h.j.f().c(this.f53223e, 1);
                        c.a.r0.l1.h.c.h().e(this.f53223e);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    return null;
                } finally {
                    c.a.r0.l1.h.h.e().c();
                }
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class x implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterPojo f53224e;

        public x(ImMemoryCacheRegister imMemoryCacheRegister, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53224e = imMessageCenterPojo;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                c.a.r0.l1.h.j.f().k(this.f53224e, 2);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMemoryCacheRegister f53225a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53225a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof CustomResponsedMessage) || customResponsedMessage.hasError() || (i2 = c.a.r0.l1.k.b.o().i(TbEnum.CustomGroupId.GROUP_UPDATE, -3)) == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data == null) {
                i2.setUnread_count(0);
                i2.setIs_hidden(1);
                this.f53225a.n(i2);
            } else if (data instanceof ImMessageCenterPojo) {
                ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                i2.setLast_content(imMessageCenterPojo.getLast_content());
                i2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                i2.setUnread_count(0);
                i2.setIs_hidden(0);
                this.f53225a.n(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMemoryCacheRegister f53226a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53226a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof CustomResponsedMessage) || customResponsedMessage.hasError() || (i2 = c.a.r0.l1.k.b.o().i(TbEnum.CustomGroupId.GROUP_VALIDATION, -4)) == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data == null) {
                i2.setUnread_count(0);
                i2.setIs_hidden(1);
                this.f53226a.n(i2);
            } else if (data instanceof ImMessageCenterPojo) {
                ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                i2.setLast_content(imMessageCenterPojo.getLast_content());
                i2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                i2.setUnread_count(0);
                i2.setIs_hidden(0);
                this.f53226a.n(i2);
            }
        }
    }

    public ImMemoryCacheRegister() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53187b = new a(this, 0);
        this.f53188c = new l(this, 0);
        this.f53189d = new y(this, 0);
        this.f53190e = new z(this, 0);
        this.f53191f = new a0(this, 0);
        this.f53192g = new b0(this, 0);
        this.f53193h = new c0(this, 0);
        this.f53194i = new d0(this, 0);
        this.f53195j = new b(this, 0);
        this.k = new c(this, 0);
        this.l = new d(this, 0);
        this.m = new e(this, 0);
        this.n = new f(this, 0);
        this.o = new g(this, 0);
        this.p = new h(this, 2016016);
        this.q = new i(this);
        this.r = new j(this, 0);
        this.s = new k(this, 0);
        this.t = new m(this, 0);
        this.u = new n(this, 0);
        this.v = new o(this, 2016017);
        this.w = new p(this, 2016020);
        this.x = new q(this, 2001382);
        this.y = new r(this);
        this.z = new s(this);
        this.A = new t(this);
        this.B = new u(this);
        this.C = new v(this);
        m();
    }

    public static ImMemoryCacheRegister j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            c.a.e.e.p.l.d();
            if (D == null) {
                synchronized (ImMemoryCacheRegister.class) {
                    if (D == null) {
                        D = new ImMemoryCacheRegister();
                    }
                }
            }
            return D;
        }
        return (ImMemoryCacheRegister) invokeV.objValue;
    }

    public final void k() {
        ResponseOnlineMessage responseOnlineMessage;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (responseOnlineMessage = this.f53186a) == null) {
            return;
        }
        Iterator<GroupUpdateMessage> it = responseOnlineMessage.getGroupInfos().iterator();
        StringBuilder sb = null;
        while (true) {
            i2 = -2;
            i3 = 1;
            if (!it.hasNext()) {
                break;
            }
            GroupUpdateMessage next = it.next();
            if (next != null) {
                if (sb == null) {
                    sb = new StringBuilder(50);
                } else {
                    sb.append("|");
                }
                sb.append(next.getGroupId());
                sb.append("-");
                sb.append(next.getLastMsgId());
                BdLog.i("gid-serverMaxMid:" + next.getGroupId() + "-" + next.getLastMsgId());
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(String.valueOf(next.getGroupId()));
                imMessageCenterPojo.setCustomGroupType(c.a.r0.l1.m.a.a(next.getGroupType()));
                imMessageCenterPojo.setGroup_head(next.getPortrait());
                imMessageCenterPojo.setGroup_name(next.getName());
                imMessageCenterPojo.setNameShow(next.getNameShow());
                imMessageCenterPojo.setPulled_msgId(c.a.r0.l1.w.b.a(next.getLastMsgId()));
                if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                    imMessageCenterPojo.setIs_hidden(1);
                }
                c.a.r0.l1.k.b.o().W(imMessageCenterPojo);
                c.a.r0.l1.k.b.o().Y(imMessageCenterPojo);
            }
        }
        long clientLogID = this.f53186a.getOrginalMessage() != null ? this.f53186a.getOrginalMessage().getClientLogID() : -1L;
        int cmd = this.f53186a.getCmd();
        int error = this.f53186a.getError();
        String errorString = this.f53186a.getErrorString();
        Object[] objArr = new Object[2];
        objArr[0] = "comment";
        objArr[1] = sb == null ? "" : sb.toString();
        c.a.q0.s.z.a.a("im", clientLogID, cmd, IMTrackDatabase.AckEnum.TABLE_NAME, error, errorString, objArr);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ImMessageCenterPojo imMessageCenterPojo2 = null;
        ImMessageCenterPojo imMessageCenterPojo3 = null;
        ImMessageCenterPojo imMessageCenterPojo4 = null;
        ImMessageCenterPojo imMessageCenterPojo5 = null;
        for (ImMessageCenterPojo imMessageCenterPojo6 : c.a.r0.l1.k.b.o().j()) {
            if (imMessageCenterPojo6.getCustomGroupType() == i3) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(imMessageCenterPojo6);
                boolean z2 = true;
                for (GroupUpdateMessage groupUpdateMessage : this.f53186a.getGroupInfos()) {
                    if (c.a.r0.l1.m.a.a(groupUpdateMessage.getGroupType()) == i3 && imMessageCenterPojo6.getGid().equals(String.valueOf(groupUpdateMessage.getGroupId()))) {
                        z2 = false;
                    }
                    i3 = 1;
                }
                if (z2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo6);
                }
            } else if (imMessageCenterPojo6.getCustomGroupType() == i2) {
                c.a.r0.l1.p.b.b().g(imMessageCenterPojo6.getGid());
                imMessageCenterPojo2 = imMessageCenterPojo6;
            } else if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                c.a.r0.l1.s.a.x(c.a.e.e.m.b.g(imMessageCenterPojo6.getGid(), 0L));
                imMessageCenterPojo4 = imMessageCenterPojo6;
            } else if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                c.a.r0.l1.s.a.w(c.a.e.e.m.b.g(imMessageCenterPojo6.getGid(), 0L));
                imMessageCenterPojo5 = imMessageCenterPojo6;
            } else {
                if (imMessageCenterPojo6.getCustomGroupType() != 6 && imMessageCenterPojo6.getCustomGroupType() != 7 && imMessageCenterPojo6.getCustomGroupType() != 8) {
                    if (imMessageCenterPojo6.getCustomGroupType() == 5) {
                        imMessageCenterPojo3 = imMessageCenterPojo6;
                    }
                } else {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(imMessageCenterPojo6);
                }
                i2 = -2;
                i3 = 1;
            }
            i2 = -2;
            i3 = 1;
        }
        if (arrayList != null) {
            c.a.r0.l1.k.b.o().I(arrayList);
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new e0(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        OnlineToDbCustomMessage onlineToDbCustomMessage = new OnlineToDbCustomMessage(this, 2001000);
        onlineToDbCustomMessage.needCreateGroupList = arrayList2;
        onlineToDbCustomMessage.systemGroup = imMessageCenterPojo2;
        onlineToDbCustomMessage.notifyGroup = imMessageCenterPojo3;
        onlineToDbCustomMessage.privateChatGroup = imMessageCenterPojo4;
        onlineToDbCustomMessage.officialChatGroup = imMessageCenterPojo5;
        onlineToDbCustomMessage.yyGroupList = arrayList3;
        if (this.f53186a.isUserAvailable()) {
            onlineToDbCustomMessage.needDeleteGroupList = arrayList;
        }
        MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
        this.f53186a = null;
    }

    public final void l(String str) {
        HashMap<String, String> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.r0.l1.k.b.o().G(str, 1);
        if (c.a.q0.t.d.b.g0().F() != null && (a2 = c.a.q0.t.d.b.g0().F().a()) != null && a2.size() == 1 && a2.containsKey(str)) {
            c.a.q0.t.d.b.g0().d(str);
        }
        c.a.r0.l1.t.b.k().j(TbadkCoreApplication.getCurrentAccount(), str, null);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new w(this, str));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(2012125, this.f53193h);
            MessageManager.getInstance().registerListener(2012124, this.f53193h);
            MessageManager.getInstance().registerListener(2012123, this.f53193h);
            MessageManager.getInstance().registerListener(2012121, this.f53193h);
            MessageManager.getInstance().registerListener(2012120, this.f53193h);
            MessageManager.getInstance().registerListener(2012126, this.f53193h);
            MessageManager.getInstance().registerListener(2012128, this.f53193h);
            MessageManager.getInstance().registerListener(2012129, this.f53193h);
            MessageManager.getInstance().registerListener(1001, this.f53194i);
            MessageManager.getInstance().registerListener(2005018, this.k);
            MessageManager.getInstance().registerStickyMode(2016002);
            MessageManager.getInstance().registerListener(2016002, this.f53195j);
            MessageManager.getInstance().registerListener(2016003, this.l);
            MessageManager.getInstance().registerListener(2008016, this.m);
            MessageManager.getInstance().registerListener(2016005, this.n);
            MessageManager.getInstance().registerListener(2016006, this.o);
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(2016015, this.f53192g);
            CustomMessageTask customMessageTask = new CustomMessageTask(2016007, this.q);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            MessageManager.getInstance().registerListener(2001210, this.f53189d);
            MessageManager.getInstance().registerListener(2001211, this.f53190e);
            MessageManager.getInstance().registerListener(202001, this.f53187b);
            MessageManager.getInstance().registerListener(205001, this.f53188c);
            MessageManager.getInstance().registerListener(2001126, this.r);
            MessageManager.getInstance().registerListener(2001125, this.r);
            MessageManager.getInstance().registerListener(2001128, this.r);
            MessageManager.getInstance().registerListener(2001129, this.r);
            MessageManager.getInstance().registerListener(2001130, this.r);
            MessageManager.getInstance().registerListener(2001131, this.r);
            MessageManager.getInstance().registerListener(2001132, this.r);
            MessageManager.getInstance().registerListener(2001133, this.r);
            MessageManager.getInstance().registerListener(2001134, this.r);
            MessageManager.getInstance().registerListener(2001135, this.r);
            MessageManager.getInstance().registerListener(2001137, this.r);
            MessageManager.getInstance().registerListener(2001138, this.r);
            MessageManager.getInstance().registerListener(2001139, this.r);
            MessageManager.getInstance().registerListener(2016009, this.f53191f);
            MessageManager.getInstance().registerListener(2001174, this.s);
            MessageManager.getInstance().registerListener(205006, this.t);
            MessageManager.getInstance().registerListener(2016013, this.u);
            MessageManager.getInstance().registerListener(this.v);
            MessageManager.getInstance().registerListener(this.w);
            MessageManager.getInstance().registerListener(this.x);
        }
    }

    public final void n(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, imMessageCenterPojo) == null) || imMessageCenterPojo == null) {
            return;
        }
        c.a.r0.l1.k.b.o().Z(imMessageCenterPojo);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new x(this, imMessageCenterPojo));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }
}
