package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.a88;
import com.baidu.tieba.b88;
import com.baidu.tieba.b98;
import com.baidu.tieba.c95;
import com.baidu.tieba.e88;
import com.baidu.tieba.gb8;
import com.baidu.tieba.h98;
import com.baidu.tieba.ib8;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.FilterUEGPersonMessage;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseFilterUEGPersonMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.j88;
import com.baidu.tieba.jb8;
import com.baidu.tieba.kb8;
import com.baidu.tieba.ks6;
import com.baidu.tieba.l88;
import com.baidu.tieba.lb;
import com.baidu.tieba.le5;
import com.baidu.tieba.me5;
import com.baidu.tieba.mf5;
import com.baidu.tieba.n78;
import com.baidu.tieba.n88;
import com.baidu.tieba.nb8;
import com.baidu.tieba.o78;
import com.baidu.tieba.o88;
import com.baidu.tieba.p78;
import com.baidu.tieba.q78;
import com.baidu.tieba.q98;
import com.baidu.tieba.r78;
import com.baidu.tieba.s78;
import com.baidu.tieba.t98;
import com.baidu.tieba.tg;
import com.baidu.tieba.vi;
import com.baidu.tieba.wg;
import com.baidu.tieba.x88;
import com.baidu.tieba.z78;
import com.baidu.tieba.z88;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class ImMemoryCacheRegister {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ImMemoryCacheRegister x;
    public transient /* synthetic */ FieldHolder $fh;
    public ResponseOnlineMessage a;
    public lb b;
    public CustomMessageListener c;
    public CustomMessageListener d;
    public lb e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageTask.CustomRunnable<Integer> l;
    public final CustomMessageTask.CustomRunnable m;
    public final CustomMessageTask.CustomRunnable<a88> n;
    public CustomMessageListener o;
    public lb p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public n78.b s;
    public n78.b t;
    public n78.b u;
    public n78.b v;
    public CustomMessageTask.CustomRunnable<List<CommonMsgPojo>> w;

    /* loaded from: classes6.dex */
    public class a extends lb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* renamed from: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0352a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;
            public final /* synthetic */ ChatMessage b;
            public final /* synthetic */ SocketResponsedMessage c;

            public C0352a(a aVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, imMessageCenterPojo, chatMessage, socketResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imMessageCenterPojo;
                this.b = chatMessage;
                this.c = socketResponsedMessage;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage != null && (customMessage instanceof CustomMessage)) {
                        try {
                            try {
                                j88.d().f();
                                l88.f().l(this.a, 3);
                                if (this.a.getCustomGroupType() == 2) {
                                    o88.w().v(this.b.getUserId(), this.b.getToUserId(), String.valueOf(this.b.getRecordId()), String.valueOf(this.b.getMsgId()), this.b.getLocalData().getStatus().shortValue(), this.b.getLocalData().getErrorString());
                                } else {
                                    n88.w().u(this.b.getUserId(), this.b.getToUserId(), String.valueOf(this.b.getRecordId()), String.valueOf(this.b.getMsgId()), this.b.getLocalData().getStatus().shortValue());
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                            j88.d().b();
                            return new CustomResponsedMessage<>(2016012, this.c);
                        } catch (Throwable th) {
                            j88.d().b();
                            throw th;
                        }
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
            this.a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ImMessageCenterPojo h;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) socketResponsedMessage;
                ChatMessage chatMessage = (ChatMessage) responseCommitPersonalMessage.getOrginalMessage();
                int toUserType = responseCommitPersonalMessage.getToUserType();
                if (socketResponsedMessage.hasError()) {
                    chatMessage.getLocalData().setErrorString(socketResponsedMessage.getErrorString());
                    chatMessage.getLocalData().setStatus(Short.valueOf(x88.b(socketResponsedMessage.getError())));
                    this.a.n(chatMessage, x88.a(socketResponsedMessage.getError(), socketResponsedMessage.getErrorString()), false);
                    this.a.j(socketResponsedMessage.getError());
                } else {
                    long msgId = responseCommitPersonalMessage.getMsgId();
                    long recordId = responseCommitPersonalMessage.getRecordId();
                    chatMessage.setMsgId(msgId);
                    chatMessage.setRecordId(recordId);
                    chatMessage.getLocalData().setStatus((short) 3);
                    if (responseCommitPersonalMessage.getToUserType() == 0) {
                        t98.y(tg.g(responseCommitPersonalMessage.getGroupId(), 0L));
                    } else {
                        t98.x(tg.g(responseCommitPersonalMessage.getGroupId(), 0L));
                    }
                    ib8.e(msgId, chatMessage.getMsgType(), chatMessage.getLogTime());
                    this.a.n(chatMessage, TbadkCoreApplication.getInst().getResources().getString(R.string.im_share_success_info), true);
                }
                long clientLogID = chatMessage.getClientLogID();
                int cmd = chatMessage.getCmd();
                int error = socketResponsedMessage.getError();
                String errorString = socketResponsedMessage.getErrorString();
                c95.a("im", clientLogID, cmd, "ack", error, errorString, "comment", "uType " + toUserType, "touid", Long.valueOf(chatMessage.getToUserId()), "content", chatMessage.getContent());
                boolean z = chatMessage instanceof PersonalChatMessage;
                if (z) {
                    b98.n().Q(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    b98.n().Q(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else {
                    return;
                }
                if (z) {
                    h = b98.n().h(String.valueOf(kb8.q(chatMessage)), 2);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    h = b98.n().h(String.valueOf(kb8.q(chatMessage)), 4);
                } else {
                    return;
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new C0352a(this, h, chatMessage, socketResponsedMessage));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage != null && customMessage.getData() != null) {
                        l88.f().k(this.a);
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyVisibilityMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016005 || !(customResponsedMessage instanceof MemoryModifyVisibilityMessage) || (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            ImMessageCenterPojo h = b98.n().h(data.a, data.b);
            int i = !data.c ? 1 : 0;
            if (h != null && i != h.getIs_hidden()) {
                int i2 = data.b;
                if (i2 == 2) {
                    le5.h0().r(data.a);
                } else if (i2 == 4) {
                    le5.h0().q(tg.e(data.a, 0));
                } else if (i2 == -4) {
                    le5.h0().f(1);
                } else {
                    le5.h0().d(data.a);
                }
                b98.n().y(data.a, data.b, data.c);
                h.setIs_hidden(i);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, h));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                    l88.f().a(data.a, data.b);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearUnreadCountMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016006 || !(customResponsedMessage instanceof MemoryClearUnreadCountMessage) || (data = ((MemoryClearUnreadCountMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            ImMessageCenterPojo h = b98.n().h(data.a, data.b);
            if (h == null) {
                BdLog.e("ClearUnreadCountMessage:  not find memery pojo");
            } else if (h.getUnread_count() == 0) {
            } else {
                b98.n().g(data.a, data.b);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements Comparator<ImMessageCenterPojo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, imMessageCenterPojo, imMessageCenterPojo2)) == null) {
                    return Long.compare(imMessageCenterPojo2.getLast_content_time(), imMessageCenterPojo.getLast_content_time());
                }
                return invokeLL.intValue;
            }
        }

        public e(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<z78> run(CustomMessage customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                z78 z78Var = new z78();
                if (b98.n().w()) {
                    List<ImMessageCenterPojo> j = b98.n().j();
                    Collections.sort(j, new a(this));
                    for (ImMessageCenterPojo imMessageCenterPojo : j) {
                        if (imMessageCenterPojo.getCustomGroupType() == 2 && !TextUtils.isEmpty(imMessageCenterPojo.getGid()) && (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow()))) {
                            if (imMessageCenterPojo.getShowOutOfStranger() != 0) {
                                MetaData metaData = new MetaData();
                                metaData.setUserId(imMessageCenterPojo.getGid());
                                metaData.setUserName(imMessageCenterPojo.getGroup_name());
                                metaData.setName_show(imMessageCenterPojo.getNameShow());
                                IMUserExtraData imUserExtraData = imMessageCenterPojo.getImUserExtraData();
                                if (imUserExtraData != null) {
                                    metaData.setIsBusinessAccount(imUserExtraData.isBusinessAccount);
                                    metaData.setAuthDesc(imUserExtraData.authDesc);
                                    metaData.setAuthType(imUserExtraData.authType);
                                    metaData.setIsOriginalAuthor(imUserExtraData.isOriginalAuthor);
                                    metaData.setGodStatus(imUserExtraData.godStatus);
                                    metaData.setIsGodUser(imUserExtraData.isGod);
                                    metaData.setBazhuDesc(imUserExtraData.bazhuDesc);
                                    metaData.setBazhuLevel(imUserExtraData.bazhuLevel);
                                    metaData.setBazhuShowOutside(imUserExtraData.bazhuShowOutSide);
                                    metaData.setIsBaZhu(imUserExtraData.isBazhu);
                                }
                                metaData.setPortrait(imMessageCenterPojo.getGroup_head());
                                metaData.setImBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                                metaData.lastUpdateTime = imMessageCenterPojo.getLast_content_time();
                                z78Var.a(metaData);
                            }
                        }
                    }
                }
                return new CustomResponsedMessage<>(2921689, z78Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements CustomMessageTask.CustomRunnable<a88> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements Comparator<GroupChatRoomPojo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(GroupChatRoomPojo groupChatRoomPojo, GroupChatRoomPojo groupChatRoomPojo2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, groupChatRoomPojo, groupChatRoomPojo2)) == null) {
                    return Long.compare(groupChatRoomPojo2.getTimestamp(), groupChatRoomPojo.getTimestamp());
                }
                return invokeLL.intValue;
            }
        }

        public f(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<a88> run(CustomMessage<a88> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                a88 a88Var = new a88();
                if (b98.n().w()) {
                    List<GroupChatRoomPojo> g = e88.f().g(TbadkCoreApplication.getCurrentAccount());
                    if (!ListUtils.isEmpty(g)) {
                        Collections.sort(g, new a(this));
                        for (GroupChatRoomPojo groupChatRoomPojo : g) {
                            GroupInfoData fromGroupChatRoomPojo = GroupInfoData.fromGroupChatRoomPojo(groupChatRoomPojo);
                            if (fromGroupChatRoomPojo != null) {
                                MetaData metaData = new MetaData();
                                metaData.groupData = fromGroupChatRoomPojo;
                                a88Var.a(metaData);
                            }
                        }
                    }
                }
                return new CustomResponsedMessage<>(2921765, a88Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(g gVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    l88.f().k(this.a);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            public b(g gVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    try {
                        try {
                            j88.d().f();
                            l88.f().c(String.valueOf(this.a), 2);
                            o88.w().e(String.valueOf(this.a));
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        j88.d().b();
                        return null;
                    } catch (Throwable th) {
                        j88.d().b();
                        throw th;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001174 || !(customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                return;
            }
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            long friendId = responseNewFriendUpdateUiMsg.getFriendId();
            int action = responseNewFriendUpdateUiMsg.getAction();
            if (action == 0) {
                ImMessageCenterPojo h = b98.n().h(String.valueOf(friendId), 2);
                if (h != null) {
                    h.setIsFriend(1);
                    h.setFollowStatus(1);
                    b98.n().S(h);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, h));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            } else if (action == 1) {
                b98.n().D(String.valueOf(friendId), 2);
                CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new b(this, friendId));
                customMessageTask2.setParallel(TiebaIMConfig.getParallel());
                customMessageTask2.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask2.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends lb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(h hVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    try {
                        l88.f().k(this.a);
                        return null;
                    } catch (Exception e) {
                        BdLog.detailException(e);
                        return null;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205006 && (socketResponsedMessage instanceof ResponsedPersonalMsgReadMessage)) {
                ResponsedPersonalMsgReadMessage responsedPersonalMsgReadMessage = (ResponsedPersonalMsgReadMessage) socketResponsedMessage;
                if (responsedPersonalMsgReadMessage.hasError() || responsedPersonalMsgReadMessage.getGroupId() != t98.j.longValue() || responsedPersonalMsgReadMessage.getToUserType() != 0) {
                    return;
                }
                ImMessageCenterPojo h = b98.n().h(String.valueOf(responsedPersonalMsgReadMessage.getToUid()), 2);
                if (h == null) {
                    return;
                }
                long a2 = jb8.a(responsedPersonalMsgReadMessage.getHasSentMsgId());
                if (a2 <= h.getSent_msgId()) {
                    return;
                }
                h.setSent_msgId(a2);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, h));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(i iVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (this.a != null) {
                        l88.f().l(this.a, 1);
                        return null;
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                ImMessageCenterPojo imMessageCenterPojo = null;
                if (customResponsedMessage.getData() instanceof PersonalChatMessage) {
                    b98.n().O(-1, ((PersonalChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(t98.j));
                    imMessageCenterPojo = b98.n().h(String.valueOf(t98.j), -1);
                } else if (customResponsedMessage.getData() instanceof OfficialChatMessage) {
                    b98.n().O(-9, ((OfficialChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(t98.k));
                    imMessageCenterPojo = b98.n().h(String.valueOf(t98.k), -9);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterPojo));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;

            public a(j jVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = list;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    for (ImMessageCenterPojo imMessageCenterPojo : this.a) {
                        l88.f().k(imMessageCenterPojo);
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<ImMessageCenterPojo> k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (k = b98.n().k()) != null && k.size() != 0) {
                for (ImMessageCenterPojo imMessageCenterPojo : k) {
                    imMessageCenterPojo.setTaskId("");
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, k));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MemoryClearStrangerItemsMessage a;

            public a(l lVar, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, memoryClearStrangerItemsMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = memoryClearStrangerItemsMessage;
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
                            j88.d().f();
                            l88.f().b();
                            if (this.a.isAllClear()) {
                                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                imMessageCenterPojo.setCustomGroupType(-7);
                                imMessageCenterPojo.setIs_hidden(1);
                                l88.f().k(imMessageCenterPojo);
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                        return null;
                    } finally {
                        j88.d().b();
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage;
            MemoryClearStrangerItemsMessage.a data;
            List<MemoryModifyVisibilityMessage.a> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof MemoryClearStrangerItemsMessage) && (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) != null && (list = data.a) != null) {
                for (MemoryModifyVisibilityMessage.a aVar : list) {
                    b98.n().E(aVar.a, aVar.b);
                }
                if (memoryClearStrangerItemsMessage.isAllClear()) {
                    b98.n().y(TbEnum.CustomGroupId.STRANGE_MERGE, -7, false);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, memoryClearStrangerItemsMessage));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements n78.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.n78.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
                }
            }
        }

        public o(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.n78.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                b98.n().N(imMessageCenterPojo);
                if (z) {
                    if (vi.E()) {
                        MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
                    } else {
                        wg.a().post(new a(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements CustomMessageTask.CustomRunnable<List<CommonMsgPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonMsgPojo a;
            public final /* synthetic */ CommonMsgPojo b;
            public final /* synthetic */ LinkedList c;
            public final /* synthetic */ long d;
            public final /* synthetic */ long e;

            public a(p pVar, CommonMsgPojo commonMsgPojo, CommonMsgPojo commonMsgPojo2, LinkedList linkedList, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, commonMsgPojo, commonMsgPojo2, linkedList, Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = commonMsgPojo;
                this.b = commonMsgPojo2;
                this.c = linkedList;
                this.d = j;
                this.e = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatMessage chatMessage;
                int i;
                CommonMsgPojo commonMsgPojo;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponseFilterUEGPersonMessage(this.a));
                    MemoryModifyLastMsgMessage.a aVar = new MemoryModifyLastMsgMessage.a();
                    aVar.b = 2;
                    aVar.a = this.a.getUid();
                    CommonMsgPojo commonMsgPojo2 = this.b;
                    if (commonMsgPojo2 != null) {
                        chatMessage = commonMsgPojo2.toChatMessage();
                    } else {
                        chatMessage = null;
                    }
                    aVar.c = chatMessage;
                    aVar.d = 2;
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(aVar));
                    ImMessageCenterPojo h = b98.n().h(this.a.getUid(), 2);
                    LinkedList linkedList = this.c;
                    int i2 = 0;
                    if (linkedList != null && !linkedList.isEmpty()) {
                        CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) this.c.get(0);
                        if (commonMsgPojo3.getMid() == this.d && commonMsgPojo3.getRead_flag() == 1 && commonMsgPojo3.getIs_delete() == 0) {
                            i = -1;
                            if (h == null && (commonMsgPojo = this.b) != null) {
                                String D = kb8.D(commonMsgPojo.getMsg_type(), this.b.getContent());
                                h.setLastContentRawData(this.b.getContent());
                                long rid = this.b.getRid();
                                long j = this.e;
                                if (rid > j) {
                                    j = this.b.getRid();
                                }
                                h.setLast_rid(j);
                                h.setSid(this.b.getSid());
                                h.setLastTaskId(this.b.getTaskId());
                                h.setLastServiceId(this.b.getServiceId());
                                h.setLast_content(D);
                                h.setLast_content_time(this.b.getCreate_time() * 1000);
                                h.setLast_user_name(this.b.getUser_infoObj().getUserName());
                                h.setPushIds(this.b.getPushIds());
                                int unread_count = h.getUnread_count();
                                if (unread_count > 0) {
                                    i2 = unread_count + i;
                                }
                                h.setUnread_count(i2);
                                b98.n().N(h);
                                return;
                            }
                        }
                    }
                    i = 0;
                    if (h == null) {
                    }
                }
            }
        }

        public p(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<List<CommonMsgPojo>> customMessage) {
            InterceptResult invokeL;
            boolean z;
            CommonMsgPojo commonMsgPojo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (!(customMessage instanceof FilterUEGPersonMessage)) {
                    return null;
                }
                for (CommonMsgPojo commonMsgPojo2 : ((FilterUEGPersonMessage) customMessage).getData()) {
                    long illegalMsgId = commonMsgPojo2.getIllegalMsgId();
                    long j = o88.w().j(commonMsgPojo2.getUid());
                    LinkedList<CommonMsgPojo> f = o88.w().f(Long.parseLong(commonMsgPojo2.getUid()), String.valueOf(1 + illegalMsgId), null, 1);
                    o88.w().o(commonMsgPojo2.getUid(), String.valueOf(illegalMsgId));
                    if (illegalMsgId == j) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        commonMsgPojo = o88.w().k(commonMsgPojo2.getUid());
                    } else {
                        commonMsgPojo = null;
                    }
                    wg.a().post(new a(this, commonMsgPojo2, commonMsgPojo, f, illegalMsgId, j));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GroupMsgData a;
            public final /* synthetic */ ImMessageCenterPojo b;
            public final /* synthetic */ q c;

            public a(q qVar, GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, groupMsgData, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = qVar;
                this.a = groupMsgData;
                this.b = imMessageCenterPojo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    q78.b(this.a, this.b, this.c.a.v);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements n78.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.n78.b
            public void a(String str, List<CommonMsgPojo> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                }
            }

            public b(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.n78.b
            public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                    return;
                }
                b98.n().O(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
            this.a = imMemoryCacheRegister;
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
                ImMessageCenterPojo h = b98.n().h(valueOf, customType);
                if (groupMsgData.getCmd() == 2012124) {
                    o78.a(groupMsgData, h, this.a.t);
                } else if (groupMsgData.getCmd() == 2012123) {
                    p78.a(groupMsgData, h, this.a.u);
                } else if (groupMsgData.getCmd() == 2012121) {
                    ks6.a(new a(this, groupMsgData, h), "processMsgFromServer", 3);
                } else if (groupMsgData.getCmd() == 2012120) {
                    r78.c(groupMsgData, h, this.a.s);
                } else if (groupMsgData.getCmd() == 2012128) {
                    if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                        b98.n().O(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(t98.j));
                    }
                } else if (groupMsgData.getCmd() == 2012129) {
                    if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                        ChatMessage chatMessage = groupMsgData.getListMessage().get(0);
                        if (!chatMessage.isPushForOperateAccount()) {
                            b98.n().O(-9, chatMessage.getMsgId(), String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
                        }
                    }
                } else if (groupMsgData.getCmd() == 2012126) {
                    if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                        s78.d(groupMsgData, h, new b(this));
                    } else {
                        long[] a2 = s78.b().a(groupMsgData);
                        if (a2 != null && a2.length == 2) {
                            if (a2[0] <= 0 && a2[1] > 0) {
                                if (a2[0] == 12) {
                                    b98.n().O(8, a2[1], String.valueOf(12));
                                } else if (a2[0] == 11) {
                                    b98.n().O(7, a2[1], String.valueOf(11));
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    s78.b().e(groupMsgData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;
            public final /* synthetic */ ImMessageCenterPojo b;

            public a(v vVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar, imMessageCenterPojo, imMessageCenterPojo2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imMessageCenterPojo;
                this.b = imMessageCenterPojo2;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    l88.f().l(this.a, 2);
                    if (this.b != null) {
                        l88.f().l(this.b, 2);
                        return null;
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyLastMsgMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016003 && (data = ((MemoryModifyLastMsgMessage) customResponsedMessage).getData()) != null) {
                b98.n().Q(data.b, data.c, data.a, data.d);
                ImMessageCenterPojo h = b98.n().h(data.a, data.b);
                if (h == null) {
                    return;
                }
                ImMessageCenterPojo imMessageCenterPojo = null;
                if (h.getCustomGroupType() == 4) {
                    imMessageCenterPojo = b98.n().h(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, h, imMessageCenterPojo));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public OnlineToDbCustomMessage(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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

    /* loaded from: classes6.dex */
    public class d implements CustomMessageTask.CustomRunnable<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    list = b98.n().l();
                } else if (intValue == 2) {
                    list = b98.n().k();
                } else if (intValue == 1) {
                    list = b98.n().j();
                } else if (intValue == 4) {
                    list = b98.n().t();
                }
                return new ResponsedMemoryListMessage(list, intValue);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements n78.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.n78.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        public k(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.n78.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                b98.n().O(-2, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements n78.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.n78.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) && list != null && list.size() != 0) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 10) {
                        n78.c(commonMsgPojo.getContent());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.n78.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                b98.n().O(5, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
                if (z) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(2));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements n78.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.n78.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                        RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                        b88 n = kb8.n(commonMsgPojo);
                        if (n != null) {
                            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "message_receive", StatConstants.VALUE_TYPE_RECEIVE, 1, "task_type", n.a, "task_id", n.b);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.n78.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                b98.n().N(imMessageCenterPojo);
                if (z) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends lb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
            this.a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                this.a.a = (ResponseOnlineMessage) socketResponsedMessage;
                if (!b98.n().a.get()) {
                    return;
                }
                this.a.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s(ImMemoryCacheRegister imMemoryCacheRegister) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                        j88.d().f();
                        if (onlineToDbCustomMessage.needCreateGroupList != null) {
                            for (ImMessageCenterPojo imMessageCenterPojo : onlineToDbCustomMessage.needCreateGroupList) {
                                l88.f().k(imMessageCenterPojo);
                            }
                        }
                        if (onlineToDbCustomMessage.systemGroup != null) {
                            l88.f().k(onlineToDbCustomMessage.systemGroup);
                        }
                        if (onlineToDbCustomMessage.privateChatGroup != null) {
                            l88.f().k(onlineToDbCustomMessage.privateChatGroup);
                        }
                        if (onlineToDbCustomMessage.officialChatGroup != null) {
                            l88.f().k(onlineToDbCustomMessage.officialChatGroup);
                        }
                        if (onlineToDbCustomMessage.notifyGroup != null) {
                            l88.f().k(onlineToDbCustomMessage.notifyGroup);
                        }
                        if (onlineToDbCustomMessage.yyGroupList != null) {
                            for (ImMessageCenterPojo imMessageCenterPojo2 : onlineToDbCustomMessage.yyGroupList) {
                                if (imMessageCenterPojo2.getCustomGroupType() == 6) {
                                    l88.f().k(imMessageCenterPojo2);
                                } else {
                                    s78.b().f(imMessageCenterPojo2.getGid(), jb8.c(imMessageCenterPojo2.getPulled_msgId()));
                                }
                            }
                        }
                        if (onlineToDbCustomMessage.needDeleteGroupList != null) {
                            for (ImMessageCenterPojo imMessageCenterPojo3 : onlineToDbCustomMessage.needDeleteGroupList) {
                                if (imMessageCenterPojo3 != null) {
                                    l88.f().c(imMessageCenterPojo3.getGid(), imMessageCenterPojo3.getCustomGroupType());
                                }
                            }
                        }
                    } catch (Exception e) {
                        c95.a("im", -1L, 0, "im_check: BASE_CUSTOM_CMD error: " + e.getMessage(), -1, "", new Object[0]);
                        BdLog.e(e.getMessage());
                    }
                    return null;
                } finally {
                    j88.d().b();
                }
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
            this.a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016002 || !(customResponsedMessage instanceof MemoryInitCompleteMessage)) {
                return;
            }
            this.a.l();
        }
    }

    /* loaded from: classes6.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
            this.a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005018) {
                gb8.a("onMessage METHOD_ACCOUNT_CHANGE");
                this.a.a = null;
                t98.y(0L);
                t98.x(0L);
                b98.n().v();
                me5.l().r();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2008016) {
                b98.n().F();
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
        this.b = new a(this, 0);
        this.c = new l(this, 0);
        this.d = new q(this, 0);
        this.e = new r(this, 0);
        this.f = new t(this, 0);
        this.g = new u(this, 0);
        this.h = new v(this, 0);
        this.i = new w(this, 0);
        this.j = new b(this, 0);
        this.k = new c(this, 0);
        this.l = new d(this);
        this.m = new e(this);
        this.n = new f(this);
        this.o = new g(this, 0);
        this.p = new h(this, 0);
        this.q = new i(this, 2016020);
        this.r = new j(this, 2001382);
        this.s = new k(this);
        this.t = new m(this);
        this.u = new n(this);
        this.v = new o(this);
        this.w = new p(this);
        m();
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 3160014) {
            k();
        }
    }

    public static ImMemoryCacheRegister i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            vi.c();
            if (x == null) {
                synchronized (ImMemoryCacheRegister.class) {
                    if (x == null) {
                        x = new ImMemoryCacheRegister();
                    }
                }
            }
            return x;
        }
        return (ImMemoryCacheRegister) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            z88.e();
        }
    }

    public final void l() {
        ResponseOnlineMessage responseOnlineMessage;
        int i2;
        String sb;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (responseOnlineMessage = this.a) == null) {
            return;
        }
        Iterator<GroupUpdateMessage> it = responseOnlineMessage.getGroupInfos().iterator();
        StringBuilder sb2 = null;
        while (true) {
            i2 = -2;
            if (!it.hasNext()) {
                break;
            }
            GroupUpdateMessage next = it.next();
            if (next != null) {
                if (sb2 == null) {
                    sb2 = new StringBuilder(50);
                } else {
                    sb2.append("|");
                }
                sb2.append(next.getGroupId());
                sb2.append("-");
                sb2.append(next.getLastMsgId());
                BdLog.i("gid-serverMaxMid:" + next.getGroupId() + "-" + next.getLastMsgId());
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(String.valueOf(next.getGroupId()));
                imMessageCenterPojo.setCustomGroupType(h98.a(next.getGroupType()));
                imMessageCenterPojo.setGroup_head(next.getPortrait());
                imMessageCenterPojo.setGroup_name(next.getName());
                imMessageCenterPojo.setNameShow(next.getNameShow());
                imMessageCenterPojo.setPulled_msgId(jb8.a(next.getLastMsgId()));
                if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                    imMessageCenterPojo.setIs_hidden(1);
                }
                b98.n().P(imMessageCenterPojo);
                b98.n().R(imMessageCenterPojo);
            }
        }
        long j2 = -1;
        if (this.a.getOrginalMessage() != null) {
            j2 = this.a.getOrginalMessage().getClientLogID();
        }
        long j3 = j2;
        int cmd = this.a.getCmd();
        int error = this.a.getError();
        String errorString = this.a.getErrorString();
        Object[] objArr = new Object[2];
        objArr[0] = "comment";
        if (sb2 == null) {
            sb = "";
        } else {
            sb = sb2.toString();
        }
        objArr[1] = sb;
        c95.a("im", j3, cmd, "ack", error, errorString, objArr);
        ImMessageCenterPojo imMessageCenterPojo2 = null;
        ImMessageCenterPojo imMessageCenterPojo3 = null;
        ImMessageCenterPojo imMessageCenterPojo4 = null;
        ImMessageCenterPojo imMessageCenterPojo5 = null;
        ArrayList arrayList = null;
        for (ImMessageCenterPojo imMessageCenterPojo6 : b98.n().i()) {
            if (imMessageCenterPojo6.getCustomGroupType() == i2) {
                q98.b().f(imMessageCenterPojo6.getGid());
                imMessageCenterPojo2 = imMessageCenterPojo6;
            } else {
                ImMessageCenterPojo imMessageCenterPojo7 = imMessageCenterPojo4;
                if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                    t98.y(tg.g(imMessageCenterPojo6.getGid(), 0L));
                    imMessageCenterPojo4 = imMessageCenterPojo6;
                } else {
                    if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                        t98.x(tg.g(imMessageCenterPojo6.getGid(), 0L));
                        imMessageCenterPojo5 = imMessageCenterPojo6;
                    } else if (imMessageCenterPojo6.getCustomGroupType() != 6 && imMessageCenterPojo6.getCustomGroupType() != 7 && imMessageCenterPojo6.getCustomGroupType() != 8) {
                        if (imMessageCenterPojo6.getCustomGroupType() == 5) {
                            imMessageCenterPojo3 = imMessageCenterPojo6;
                        }
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(imMessageCenterPojo6);
                    }
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                }
            }
            i2 = -2;
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new s(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        OnlineToDbCustomMessage onlineToDbCustomMessage = new OnlineToDbCustomMessage(this, 2001000);
        onlineToDbCustomMessage.needCreateGroupList = null;
        onlineToDbCustomMessage.systemGroup = imMessageCenterPojo2;
        onlineToDbCustomMessage.notifyGroup = imMessageCenterPojo3;
        onlineToDbCustomMessage.privateChatGroup = imMessageCenterPojo4;
        onlineToDbCustomMessage.officialChatGroup = imMessageCenterPojo5;
        onlineToDbCustomMessage.yyGroupList = arrayList;
        if (this.a.isUserAvailable()) {
            onlineToDbCustomMessage.needDeleteGroupList = null;
        }
        MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
        this.a = null;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gb8.a("ImMemoryCacheRegister register");
            MessageManager.getInstance().registerListener(2012124, this.d);
            MessageManager.getInstance().registerListener(2012123, this.d);
            MessageManager.getInstance().registerListener(2012121, this.d);
            MessageManager.getInstance().registerListener(2012120, this.d);
            MessageManager.getInstance().registerListener(2012126, this.d);
            MessageManager.getInstance().registerListener(2012128, this.d);
            MessageManager.getInstance().registerListener(2012129, this.d);
            MessageManager.getInstance().registerListener(1001, this.e);
            MessageManager.getInstance().registerListener(2005018, this.g);
            MessageManager.getInstance().registerStickyMode(2016002);
            MessageManager.getInstance().registerListener(2016002, this.f);
            MessageManager.getInstance().registerListener(2016003, this.h);
            MessageManager.getInstance().registerListener(2008016, this.i);
            MessageManager.getInstance().registerListener(2016005, this.j);
            MessageManager.getInstance().registerListener(2016006, this.k);
            CustomMessageTask customMessageTask = new CustomMessageTask(2016007, this.l);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(2921689, this.m);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            MessageManager.getInstance().registerListener(205001, this.b);
            MessageManager.getInstance().registerListener(2016009, this.c);
            MessageManager.getInstance().registerListener(2001174, this.o);
            MessageManager.getInstance().registerListener(205006, this.p);
            MessageManager.getInstance().registerListener(this.q);
            MessageManager.getInstance().registerListener(this.r);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(2921692, this.w);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(2921765, this.n);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }

    public final void n(ChatMessage chatMessage, String str, boolean z) {
        boolean z2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, chatMessage, str, z) == null) {
            boolean z3 = false;
            if (chatMessage.getMsgType() == 37) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (chatMessage.getMsgType() == 32 || chatMessage.getMsgType() == 33 || z2) {
                int msgType = chatMessage.getMsgType();
                if (msgType != 32) {
                    if (msgType != 33) {
                        if (msgType != 37) {
                            i2 = Integer.MAX_VALUE;
                        } else {
                            i2 = 3;
                        }
                    } else {
                        i2 = 2;
                    }
                } else {
                    i2 = 1;
                }
                if (mf5.c() == chatMessage.getToUserId()) {
                    z3 = true;
                }
                nb8.a(str, z, i2, 1, z3);
            }
        }
    }
}
