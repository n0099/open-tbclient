package com.baidu.tieba.im.memorycache;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.switchs.AsyncParseMessageSwitch;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a97;
import com.baidu.tieba.ac7;
import com.baidu.tieba.as4;
import com.baidu.tieba.bx4;
import com.baidu.tieba.cc7;
import com.baidu.tieba.dh;
import com.baidu.tieba.ea7;
import com.baidu.tieba.ec7;
import com.baidu.tieba.ej;
import com.baidu.tieba.f97;
import com.baidu.tieba.fc7;
import com.baidu.tieba.gh;
import com.baidu.tieba.h97;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.ImMemoryCacheRegister;
import com.baidu.tieba.im.message.FilterUEGPersonMessage;
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
import com.baidu.tieba.im.message.ResponseFilterUEGPersonMessage;
import com.baidu.tieba.im.message.ResponseMemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.model.ModelHelper;
import com.baidu.tieba.j87;
import com.baidu.tieba.j97;
import com.baidu.tieba.k87;
import com.baidu.tieba.k97;
import com.baidu.tieba.l87;
import com.baidu.tieba.m87;
import com.baidu.tieba.n87;
import com.baidu.tieba.o87;
import com.baidu.tieba.oa7;
import com.baidu.tieba.p87;
import com.baidu.tieba.q25;
import com.baidu.tieba.qw4;
import com.baidu.tieba.ra7;
import com.baidu.tieba.rb;
import com.baidu.tieba.t97;
import com.baidu.tieba.v15;
import com.baidu.tieba.v97;
import com.baidu.tieba.w15;
import com.baidu.tieba.w87;
import com.baidu.tieba.wa7;
import com.baidu.tieba.x87;
import com.baidu.tieba.y97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ImMemoryCacheRegister {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ImMemoryCacheRegister E;
    public transient /* synthetic */ FieldHolder $fh;
    public j87.b A;
    public j87.b B;
    public j87.b C;
    public CustomMessageTask.CustomRunnable<List<CommonMsgPojo>> D;
    public ResponseOnlineMessage a;
    public rb b;
    public rb c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public rb h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageTask.CustomRunnable<Integer> p;
    public final CustomMessageTask.CustomRunnable q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public rb t;
    public CustomMessageListener u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public j87.b y;
    public j87.b z;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0295a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;
            public final /* synthetic */ ChatMessage b;
            public final /* synthetic */ SocketResponsedMessage c;

            public C0295a(a aVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
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
                    if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                        return null;
                    }
                    try {
                        try {
                            f97.d().f();
                            h97.f().l(this.a, 3);
                            a97.h().o(this.b.getGroupId(), String.valueOf(this.b.getRecordId()), String.valueOf(this.b.getMsgId()), this.b.getLocalData().getStatus().shortValue());
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                        f97.d().b();
                        return new CustomResponsedMessage<>(2016012, this.c);
                    } catch (Throwable th) {
                        f97.d().b();
                        throw th;
                    }
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
                qw4.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), IMTrackDatabase.AckEnum.TABLE_NAME, socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), new Object[0]);
                y97.o().W(chatMessage.getCustomGroupType(), chatMessage, chatMessage.getGroupId(), 3);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new C0295a(this, y97.o().i(chatMessage.getGroupId(), chatMessage.getCustomGroupType()), chatMessage, socketResponsedMessage));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MemoryClearStrangerItemsMessage a;

            public a(a0 a0Var, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a0Var, memoryClearStrangerItemsMessage};
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
                            f97.d().f();
                            h97.f().b();
                            if (this.a.isAllClear()) {
                                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                imMessageCenterPojo.setCustomGroupType(-7);
                                imMessageCenterPojo.setIs_hidden(1);
                                h97.f().k(imMessageCenterPojo);
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                        return null;
                    } finally {
                        f97.d().b();
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof MemoryClearStrangerItemsMessage) || (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) == null || (list = data.a) == null) {
                return;
            }
            for (MemoryModifyVisibilityMessage.a aVar : list) {
                y97.o().G(aVar.a, aVar.b);
            }
            if (memoryClearStrangerItemsMessage.isAllClear()) {
                y97.o().A(TbEnum.CustomGroupId.STRANGE_MERGE, -7, false);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, memoryClearStrangerItemsMessage));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

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
            this.a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005018) {
                ac7.a("onMessage METHOD_ACCOUNT_CHANGE");
                this.a.a = null;
                ra7.z(0L);
                ra7.y(0L);
                y97.o().w();
                w15.l().m();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof MemoryItemRemoveMessage.a)) {
                return;
            }
            MemoryItemRemoveMessage.a aVar = (MemoryItemRemoveMessage.a) customResponsedMessage.getData();
            if (aVar.a == 1) {
                this.a.q(aVar.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;
            public final /* synthetic */ ImMessageCenterPojo b;

            public a(c cVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, imMessageCenterPojo, imMessageCenterPojo2};
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
                    h97.f().l(this.a, 2);
                    if (this.b != null) {
                        h97.f().l(this.b, 2);
                        return null;
                    }
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
            MemoryModifyLastMsgMessage.a data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016003 || (data = ((MemoryModifyLastMsgMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            y97.o().W(data.b, data.c, data.a, data.d);
            ImMessageCenterPojo i = y97.o().i(data.a, data.b);
            if (i == null) {
                return;
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i, i.getCustomGroupType() == 4 ? y97.o().i(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8) : null));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GroupMsgData a;
            public final /* synthetic */ ImMessageCenterPojo b;
            public final /* synthetic */ c0 c;

            public a(c0 c0Var, GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0Var, groupMsgData, imMessageCenterPojo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = c0Var;
                this.a = groupMsgData;
                this.b = imMessageCenterPojo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    n87.b(this.a, this.b, this.c.a.C);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements j87.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c0 c0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.j87.b
            public void a(String str, List<CommonMsgPojo> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                }
            }

            @Override // com.baidu.tieba.j87.b
            public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                    return;
                }
                y97.o().U(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
                ImMessageCenterPojo i = y97.o().i(valueOf, customType);
                if (groupMsgData.getCmd() == 2012125) {
                    k87.a(groupMsgData, i, this.a.y);
                } else if (groupMsgData.getCmd() == 2012124) {
                    l87.a(groupMsgData, i, this.a.A);
                } else if (groupMsgData.getCmd() == 2012123) {
                    m87.a(groupMsgData, i, this.a.B);
                } else if (groupMsgData.getCmd() == 2012121) {
                    if (AsyncParseMessageSwitch.isOn()) {
                        new Thread(new a(this, groupMsgData, i)).start();
                    } else {
                        n87.b(groupMsgData, i, this.a.C);
                    }
                } else if (groupMsgData.getCmd() == 2012120) {
                    o87.f(groupMsgData, i, this.a.z);
                } else if (groupMsgData.getCmd() == 2012128) {
                    if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().size() <= 0) {
                        return;
                    }
                    y97.o().U(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(ra7.j));
                } else if (groupMsgData.getCmd() == 2012129) {
                    if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().size() <= 0) {
                        return;
                    }
                    ChatMessage chatMessage = groupMsgData.getListMessage().get(0);
                    if (chatMessage.isPushForOperateAccount()) {
                        return;
                    }
                    y97.o().U(-9, chatMessage.getMsgId(), String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
                } else if (groupMsgData.getCmd() == 2012126) {
                    if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                        p87.d(groupMsgData, i, new b(this));
                    } else {
                        long[] a2 = p87.b().a(groupMsgData);
                        if (a2 != null && a2.length == 2) {
                            if (a2[0] > 0 || a2[1] <= 0) {
                                return;
                            }
                            if (a2[0] == 12) {
                                y97.o().U(8, a2[1], String.valueOf(12));
                            } else if (a2[0] == 11) {
                                y97.o().U(7, a2[1], String.valueOf(11));
                            }
                        }
                    }
                    p87.b().e(groupMsgData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
                y97.o().I();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                this.a.a = (ResponseOnlineMessage) socketResponsedMessage;
                if (y97.o().a.get()) {
                    this.a.p();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(e eVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, imMessageCenterPojo};
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
                        h97.f().k(this.a);
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016005 && (customResponsedMessage instanceof MemoryModifyVisibilityMessage) && (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) != null) {
                ImMessageCenterPojo i = y97.o().i(data.a, data.b);
                int i2 = !data.c ? 1 : 0;
                if (i == null || i2 == i.getIs_hidden()) {
                    return;
                }
                int i3 = data.b;
                if (i3 == 2) {
                    v15.h0().r(data.a);
                } else if (i3 == 4) {
                    v15.h0().q(dh.e(data.a, 0));
                } else if (i3 == -4) {
                    v15.h0().f(1);
                } else {
                    v15.h0().d(data.a);
                }
                y97.o().A(data.a, data.b, data.c);
                i.setIs_hidden(i2);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                        f97.d().f();
                        if (onlineToDbCustomMessage.needCreateGroupList != null) {
                            a97.h().b(onlineToDbCustomMessage.needCreateGroupList);
                            for (ImMessageCenterPojo imMessageCenterPojo : onlineToDbCustomMessage.needCreateGroupList) {
                                h97.f().k(imMessageCenterPojo);
                            }
                        }
                        if (onlineToDbCustomMessage.systemGroup != null) {
                            h97.f().k(onlineToDbCustomMessage.systemGroup);
                        }
                        if (onlineToDbCustomMessage.privateChatGroup != null) {
                            h97.f().k(onlineToDbCustomMessage.privateChatGroup);
                        }
                        if (onlineToDbCustomMessage.officialChatGroup != null) {
                            h97.f().k(onlineToDbCustomMessage.officialChatGroup);
                        }
                        if (onlineToDbCustomMessage.notifyGroup != null) {
                            h97.f().k(onlineToDbCustomMessage.notifyGroup);
                        }
                        if (onlineToDbCustomMessage.yyGroupList != null) {
                            for (ImMessageCenterPojo imMessageCenterPojo2 : onlineToDbCustomMessage.yyGroupList) {
                                if (imMessageCenterPojo2.getCustomGroupType() == 6) {
                                    h97.f().k(imMessageCenterPojo2);
                                } else {
                                    p87.b().f(imMessageCenterPojo2.getGid(), ec7.c(imMessageCenterPojo2.getPulled_msgId()));
                                }
                            }
                        }
                        if (onlineToDbCustomMessage.needDeleteGroupList != null) {
                            for (ImMessageCenterPojo imMessageCenterPojo3 : onlineToDbCustomMessage.needDeleteGroupList) {
                                if (imMessageCenterPojo3 != null) {
                                    h97.f().c(imMessageCenterPojo3.getGid(), imMessageCenterPojo3.getCustomGroupType());
                                }
                            }
                        }
                    } catch (Exception e) {
                        qw4.a("im", -1L, 0, "im_check: BASE_CUSTOM_CMD error: " + e.getMessage(), -1, "", new Object[0]);
                        BdLog.e(e.getMessage());
                    }
                    return null;
                } finally {
                    f97.d().b();
                }
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a> {
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

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<MemoryClearUnreadCountMessage.a> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    MemoryClearUnreadCountMessage.a data = customMessage.getData();
                    h97.f().a(data.a, data.b);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016006 && (customResponsedMessage instanceof MemoryClearUnreadCountMessage) && (data = ((MemoryClearUnreadCountMessage) customResponsedMessage).getData()) != null) {
                ImMessageCenterPojo i = y97.o().i(data.a, data.b);
                if (i == null) {
                    BdLog.e("ClearUnreadCountMessage:  not find memery pojo");
                } else if (i.getUnread_count() == 0) {
                } else {
                    y97.o().h(data.a, data.b);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002 && (customResponsedMessage instanceof MemoryInitCompleteMessage)) {
                this.a.p();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
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
                    try {
                        try {
                            f97.d().f();
                            h97.f().k(this.a);
                            a97.h().a(this.a.getGid());
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        f97.d().b();
                        return null;
                    } catch (Throwable th) {
                        f97.d().b();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ImMessageCenterPojo)) {
                return;
            }
            ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData();
            y97.o().Z(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements CustomMessageTask.CustomRunnable<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(ImMemoryCacheRegister imMemoryCacheRegister) {
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
                    list = y97.o().m();
                } else if (intValue == 2) {
                    list = y97.o().l();
                } else if (intValue == 1) {
                    list = y97.o().k();
                } else if (intValue == 4) {
                    list = y97.o().u();
                }
                return new ResponsedMemoryListMessage(list, intValue);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements Comparator<ImMessageCenterPojo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
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
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, imMessageCenterPojo, imMessageCenterPojo2)) == null) ? Long.compare(imMessageCenterPojo2.getLast_content_time(), imMessageCenterPojo.getLast_content_time()) : invokeLL.intValue;
            }
        }

        public i(ImMemoryCacheRegister imMemoryCacheRegister) {
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
        public CustomResponsedMessage<w87> run(CustomMessage customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                w87 w87Var = new w87();
                if (y97.o().y()) {
                    List<ImMessageCenterPojo> k = y97.o().k();
                    Collections.sort(k, new a(this));
                    for (ImMessageCenterPojo imMessageCenterPojo : k) {
                        if (imMessageCenterPojo.getCustomGroupType() == 2 && !TextUtils.isEmpty(imMessageCenterPojo.getGid()) && (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow()))) {
                            if (imMessageCenterPojo.getShowOutOfStranger() != 0) {
                                MetaData metaData = new MetaData();
                                metaData.setUserId(imMessageCenterPojo.getGid());
                                metaData.setUserName(imMessageCenterPojo.getGroup_name());
                                metaData.setName_show(imMessageCenterPojo.getNameShow());
                                as4 imUserExtraData = imMessageCenterPojo.getImUserExtraData();
                                if (imUserExtraData != null) {
                                    metaData.setIsBusinessAccount(imUserExtraData.a);
                                    metaData.setAuthDesc(imUserExtraData.b);
                                    metaData.setAuthType(imUserExtraData.c);
                                    metaData.setIsOriginalAuthor(imUserExtraData.d);
                                    metaData.setGodStatus(imUserExtraData.e);
                                    metaData.setIsGodUser(imUserExtraData.f);
                                    metaData.setBazhuDesc(imUserExtraData.g);
                                    metaData.setBazhuLevel(imUserExtraData.h);
                                    metaData.setBazhuShowOutside(imUserExtraData.i);
                                    metaData.setIsBaZhu(imUserExtraData.j);
                                }
                                metaData.setPortrait(imMessageCenterPojo.getGroup_head());
                                metaData.setImBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                                w87Var.a(metaData);
                            }
                        }
                    }
                }
                return new CustomResponsedMessage<>(2921689, w87Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(j jVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, imMessageCenterPojo};
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
                    h97.f().k(this.a);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public b(j jVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, imMessageCenterPojo};
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
                    h97.f().k(this.a);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class c implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public c(j jVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, imMessageCenterPojo};
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
                        try {
                            f97.d().f();
                            a97.h().a(this.a.getGid());
                            h97.f().k(this.a);
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        f97.d().b();
                        return new CustomResponsedMessage<>(2001214);
                    } catch (Throwable th) {
                        f97.d().b();
                        throw th;
                    }
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
            this.a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            UpdatesItemData convertToUpdatesItem;
            ImMessageCenterPojo i;
            UpdatesItemData convertToUpdatesItem2;
            ImMessageCenterPojo i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null) {
                return;
            }
            String cmd = p.getCmd();
            if (TextUtils.isEmpty(cmd)) {
                return;
            }
            if (o87.e(cmd)) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
                imMessageCenterPojo.setCustomGroupType(-4);
                imMessageCenterPojo.setLast_content(o87.c(cmd, p.getContent()));
                imMessageCenterPojo.setLast_content_time(p.getTime());
                imMessageCenterPojo.setLast_rid(dh.g(p.getNotice_id(), 0L));
                y97.o().T(imMessageCenterPojo, !ChatStatusManager.getInst().getIsOpen(7));
            }
            if (cmd.equals("group_head_change")) {
                if (ModelHelper.getInstance().getUpdatasModel() == null || (convertToUpdatesItem2 = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) == null) {
                    return;
                }
                String groupId = convertToUpdatesItem2.getGroupId();
                if (TextUtils.isEmpty(groupId) || TextUtils.isEmpty(convertToUpdatesItem2.getGroupHeadUrl()) || (i2 = y97.o().i(groupId, 1)) == null) {
                    return;
                }
                if (i2.getGroup_head() == null || !i2.getGroup_head().equals(convertToUpdatesItem2.getGroupHeadUrl())) {
                    y97.o().Q(groupId, convertToUpdatesItem2.getGroupHeadUrl());
                    i2.setGroup_head(convertToUpdatesItem2.getGroupHeadUrl());
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2));
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
                if (TextUtils.isEmpty(groupId2) || TextUtils.isEmpty(convertToUpdatesItem.getGroupName()) || (i = y97.o().i(groupId2, 1)) == null) {
                    return;
                }
                if (i.getGroup_name() == null || !i.getGroup_name().equals(convertToUpdatesItem.getGroupName())) {
                    y97.o().R(groupId2, convertToUpdatesItem.getGroupName());
                    i.setGroup_name(convertToUpdatesItem.getGroupName());
                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new b(this, i));
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
                    wa7.k().p(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                    wa7.k().o(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    imMessageCenterPojo2.setGroup_name(optString3);
                    imMessageCenterPojo2.setCustomGroupType(1);
                    imMessageCenterPojo2.setGid(optString);
                    imMessageCenterPojo2.setGroup_head(optString2);
                    imMessageCenterPojo2.setLast_content_time(p.getTime());
                    imMessageCenterPojo2.setIs_hidden(0);
                    imMessageCenterPojo2.setUnread_count(0);
                    imMessageCenterPojo2.setLast_content(" ");
                    imMessageCenterPojo2.setLast_rid(ec7.a(optLong));
                    imMessageCenterPojo2.setPulled_msgId(ec7.a(optLong));
                    y97.o().Y(imMessageCenterPojo2);
                    y97.o().U(1, ec7.a(optLong), optString);
                    CustomMessageTask customMessageTask3 = new CustomMessageTask(2001000, new c(this, imMessageCenterPojo2));
                    customMessageTask3.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask3.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask3.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001213), customMessageTask3);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            } else if (cmd.equals("dismiss_group") || cmd.equals("kick_out")) {
                String gid = p.getGid();
                if (TextUtils.isEmpty(gid)) {
                    return;
                }
                this.a.q(gid);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(k kVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, imMessageCenterPojo};
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
                    h97.f().k(this.a);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            public b(k kVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Long.valueOf(j)};
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
                            f97.d().f();
                            h97.f().c(String.valueOf(this.a), 2);
                            k97.w().e(String.valueOf(this.a));
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        f97.d().b();
                        return null;
                    } catch (Throwable th) {
                        f97.d().b();
                        throw th;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                int action = responseNewFriendUpdateUiMsg.getAction();
                if (action != 0) {
                    if (action == 1) {
                        y97.o().F(String.valueOf(friendId), 2);
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new b(this, friendId));
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                        return;
                    }
                    return;
                }
                ImMessageCenterPojo i = y97.o().i(String.valueOf(friendId), 2);
                if (i != null) {
                    i.setIsFriend(1);
                    i.setFollowStatus(1);
                    y97.o().Y(i);
                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new a(this, i));
                    customMessageTask2.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask2.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask2.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;
            public final /* synthetic */ ChatMessage b;
            public final /* synthetic */ SocketResponsedMessage c;

            public a(l lVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, imMessageCenterPojo, chatMessage, socketResponsedMessage};
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
                    if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                        return null;
                    }
                    try {
                        try {
                            f97.d().f();
                            h97.f().l(this.a, 3);
                            if (this.a.getCustomGroupType() == 2) {
                                k97.w().v(this.b.getUserId(), this.b.getToUserId(), String.valueOf(this.b.getRecordId()), String.valueOf(this.b.getMsgId()), this.b.getLocalData().getStatus().shortValue(), this.b.getLocalData().getErrorString());
                            } else {
                                j97.w().u(this.b.getUserId(), this.b.getToUserId(), String.valueOf(this.b.getRecordId()), String.valueOf(this.b.getMsgId()), this.b.getLocalData().getStatus().shortValue());
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                        f97.d().b();
                        return new CustomResponsedMessage<>(2016012, this.c);
                    } catch (Throwable th) {
                        f97.d().b();
                        throw th;
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
            this.a = imMemoryCacheRegister;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ImMessageCenterPojo i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) socketResponsedMessage;
                ChatMessage chatMessage = (ChatMessage) responseCommitPersonalMessage.getOrginalMessage();
                int toUserType = responseCommitPersonalMessage.getToUserType();
                if (socketResponsedMessage.hasError()) {
                    chatMessage.getLocalData().setErrorString(socketResponsedMessage.getErrorString());
                    chatMessage.getLocalData().setStatus(Short.valueOf(t97.b(socketResponsedMessage.getError())));
                    this.a.s(chatMessage, t97.a(socketResponsedMessage.getError(), socketResponsedMessage.getErrorString()), false);
                    this.a.m(socketResponsedMessage.getError());
                } else {
                    long msgId = responseCommitPersonalMessage.getMsgId();
                    long recordId = responseCommitPersonalMessage.getRecordId();
                    chatMessage.setMsgId(msgId);
                    chatMessage.setRecordId(recordId);
                    chatMessage.getLocalData().setStatus((short) 3);
                    if (responseCommitPersonalMessage.getToUserType() == 0) {
                        ra7.z(dh.g(responseCommitPersonalMessage.getGroupId(), 0L));
                    } else {
                        ra7.y(dh.g(responseCommitPersonalMessage.getGroupId(), 0L));
                    }
                    cc7.e(msgId, chatMessage.getMsgType(), chatMessage.getLogTime());
                    this.a.s(chatMessage, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f08de), true);
                }
                long clientLogID = chatMessage.getClientLogID();
                int cmd = chatMessage.getCmd();
                int error = socketResponsedMessage.getError();
                String errorString = socketResponsedMessage.getErrorString();
                qw4.a("im", clientLogID, cmd, IMTrackDatabase.AckEnum.TABLE_NAME, error, errorString, "comment", "uType " + toUserType, "touid", Long.valueOf(chatMessage.getToUserId()), "content", chatMessage.getContent());
                boolean z = chatMessage instanceof PersonalChatMessage;
                if (z) {
                    y97.o().W(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else if (!(chatMessage instanceof OfficialChatMessage)) {
                    return;
                } else {
                    y97.o().W(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                }
                if (z) {
                    i = y97.o().i(String.valueOf(fc7.p(chatMessage)), 2);
                } else if (!(chatMessage instanceof OfficialChatMessage)) {
                    return;
                } else {
                    i = y97.o().i(String.valueOf(fc7.p(chatMessage)), 4);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i, chatMessage, socketResponsedMessage));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(m mVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, imMessageCenterPojo};
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
                        h97.f().k(this.a);
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
        public m(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205006 && (socketResponsedMessage instanceof ResponsedPersonalMsgReadMessage)) {
                ResponsedPersonalMsgReadMessage responsedPersonalMsgReadMessage = (ResponsedPersonalMsgReadMessage) socketResponsedMessage;
                if (!responsedPersonalMsgReadMessage.hasError() && responsedPersonalMsgReadMessage.getGroupId() == ra7.j.longValue() && responsedPersonalMsgReadMessage.getToUserType() == 0) {
                    ImMessageCenterPojo i = y97.o().i(String.valueOf(responsedPersonalMsgReadMessage.getToUid()), 2);
                    if (i == null) {
                        return;
                    }
                    long a2 = ec7.a(responsedPersonalMsgReadMessage.getHasSentMsgId());
                    if (a2 <= i.getSent_msgId()) {
                        return;
                    }
                    i.setSent_msgId(a2);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(n nVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, imMessageCenterPojo};
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
                        try {
                            f97.d().f();
                            h97.f().k(this.a);
                            if (this.a.getCustomGroupType() == 1) {
                                a97.h().a(this.a.getGid());
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                        f97.d().b();
                        return new ResponseMemoryNotifyUpdataGroupMessage(this.a);
                    } catch (Throwable th) {
                        f97.d().b();
                        throw th;
                    }
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016013 || (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) == null) {
                return;
            }
            y97.o().V(imMessageCenterPojo);
            y97.o().X(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(o oVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, imMessageCenterPojo};
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
                    if (customMessage == null) {
                        return null;
                    }
                    h97.f().l(this.a, 2);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            ImMessageCenterPojo i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof MemoryUpdateHeadNameMessage.a)) {
                return;
            }
            MemoryUpdateHeadNameMessage.a aVar = (MemoryUpdateHeadNameMessage.a) customResponsedMessage.getData();
            if (TextUtils.isEmpty(aVar.c)) {
                return;
            }
            if ((TextUtils.isEmpty(aVar.a) && TextUtils.isEmpty(aVar.b)) || (i = y97.o().i(aVar.c, aVar.d)) == null) {
                return;
            }
            String str = aVar.b;
            String str2 = aVar.a;
            if (!TextUtils.isEmpty(str)) {
                y97.o().R(aVar.c, str);
            }
            if (!TextUtils.isEmpty(aVar.a)) {
                y97.o().Q(aVar.c, str2);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterPojo a;

            public a(p pVar, ImMessageCenterPojo imMessageCenterPojo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, imMessageCenterPojo};
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
                    h97.f().l(this.a, 1);
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            ImMessageCenterPojo i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof PersonalChatMessage) {
                y97.o().U(-1, ((PersonalChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(ra7.j));
                i = y97.o().i(String.valueOf(ra7.j), -1);
            } else if (customResponsedMessage.getData() instanceof OfficialChatMessage) {
                y97.o().U(-9, ((OfficialChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(ra7.k));
                i = y97.o().i(String.valueOf(ra7.k), -9);
            } else {
                ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                y97.o().U(1, chatMessage.getMsgId(), chatMessage.getGroupId());
                i = y97.o().i(chatMessage.getGroupId(), 1);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;

            public a(q qVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, list};
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
                        h97.f().k(imMessageCenterPojo);
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<ImMessageCenterPojo> l;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (l = y97.o().l()) == null || l.size() == 0) {
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

    /* loaded from: classes4.dex */
    public class r implements j87.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(ImMemoryCacheRegister imMemoryCacheRegister) {
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

        @Override // com.baidu.tieba.j87.b
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
                    } catch (JSONException e) {
                        BdLog.detailException(e);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.j87.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                y97.o().S(imMessageCenterPojo);
                y97.o().U(1, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
                if (z) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(1));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements j87.b {
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

        @Override // com.baidu.tieba.j87.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // com.baidu.tieba.j87.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                y97.o().U(-2, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements j87.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t(ImMemoryCacheRegister imMemoryCacheRegister) {
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

        @Override // com.baidu.tieba.j87.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) || list == null || list.size() == 0) {
                return;
            }
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 10) {
                    j87.c(commonMsgPojo.getContent());
                }
            }
        }

        @Override // com.baidu.tieba.j87.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                y97.o().U(5, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
                if (z) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements j87.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public u(ImMemoryCacheRegister imMemoryCacheRegister) {
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

        @Override // com.baidu.tieba.j87.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                        RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                        x87 l = fc7.l(commonMsgPojo);
                        if (l != null) {
                            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "message_receive", StatConstants.VALUE_TYPE_RECEIVE, 1, "task_type", l.a, "task_id", l.b);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.j87.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                y97.o().S(imMessageCenterPojo);
                if (z) {
                    MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements j87.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(v vVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar};
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

        public v(ImMemoryCacheRegister imMemoryCacheRegister) {
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

        @Override // com.baidu.tieba.j87.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // com.baidu.tieba.j87.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                y97.o().S(imMessageCenterPojo);
                if (z) {
                    if (ej.C()) {
                        MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
                    } else {
                        gh.a().post(new a(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements CustomMessageTask.CustomRunnable<List<CommonMsgPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonMsgPojo a;
            public final /* synthetic */ CommonMsgPojo b;
            public final /* synthetic */ LinkedList c;
            public final /* synthetic */ long d;
            public final /* synthetic */ long e;

            public a(w wVar, CommonMsgPojo commonMsgPojo, CommonMsgPojo commonMsgPojo2, LinkedList linkedList, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {wVar, commonMsgPojo, commonMsgPojo2, linkedList, Long.valueOf(j), Long.valueOf(j2)};
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
                int i;
                CommonMsgPojo commonMsgPojo;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponseFilterUEGPersonMessage(this.a));
                    MemoryModifyLastMsgMessage.a aVar = new MemoryModifyLastMsgMessage.a();
                    aVar.b = 2;
                    aVar.a = this.a.getUid();
                    CommonMsgPojo commonMsgPojo2 = this.b;
                    aVar.c = commonMsgPojo2 != null ? commonMsgPojo2.toChatMessage() : null;
                    aVar.d = 2;
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(aVar));
                    ImMessageCenterPojo i2 = y97.o().i(this.a.getUid(), 2);
                    LinkedList linkedList = this.c;
                    if (linkedList != null && !linkedList.isEmpty()) {
                        CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) this.c.get(0);
                        if (commonMsgPojo3.getMid() == this.d && commonMsgPojo3.getRead_flag() == 1 && commonMsgPojo3.getIs_delete() == 0) {
                            i = -1;
                            if (i2 != null || (commonMsgPojo = this.b) == null) {
                            }
                            String A = fc7.A(commonMsgPojo.getMsg_type(), this.b.getContent());
                            i2.setLastContentRawData(this.b.getContent());
                            long rid = this.b.getRid();
                            long j = this.e;
                            if (rid > j) {
                                j = this.b.getRid();
                            }
                            i2.setLast_rid(j);
                            i2.setSid(this.b.getSid());
                            i2.setLastTaskId(this.b.getTaskId());
                            i2.setLastServiceId(this.b.getServiceId());
                            i2.setLast_content(A);
                            i2.setLast_content_time(this.b.getCreate_time() * 1000);
                            i2.setLast_user_name(this.b.getUser_infoObj().getUserName());
                            i2.setPushIds(this.b.getPushIds());
                            int unread_count = i2.getUnread_count();
                            i2.setUnread_count(unread_count > 0 ? unread_count + i : 0);
                            y97.o().S(i2);
                            return;
                        }
                    }
                    i = 0;
                    if (i2 != null) {
                    }
                }
            }
        }

        public w(ImMemoryCacheRegister imMemoryCacheRegister) {
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage instanceof FilterUEGPersonMessage) {
                    for (CommonMsgPojo commonMsgPojo : ((FilterUEGPersonMessage) customMessage).getData()) {
                        long illegalMsgId = commonMsgPojo.getIllegalMsgId();
                        long j = k97.w().j(commonMsgPojo.getUid());
                        LinkedList<CommonMsgPojo> f = k97.w().f(Long.parseLong(commonMsgPojo.getUid()), String.valueOf(1 + illegalMsgId), null, 1);
                        k97.w().o(commonMsgPojo.getUid(), String.valueOf(illegalMsgId));
                        gh.a().post(new a(this, commonMsgPojo, (illegalMsgId > j ? 1 : (illegalMsgId == j ? 0 : -1)) == 0 ? k97.w().k(commonMsgPojo.getUid()) : null, f, illegalMsgId, j));
                    }
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class x implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public x(ImMemoryCacheRegister imMemoryCacheRegister, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
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
                        f97.d().f();
                        h97.f().c(this.a, 1);
                        a97.h().e(this.a);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    return null;
                } finally {
                    f97.d().b();
                }
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class y implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public y(ImMemoryCacheRegister imMemoryCacheRegister, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMemoryCacheRegister, imMessageCenterPojo};
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
                if (customMessage == null) {
                    return null;
                }
                h97.f().l(this.a, 2);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMemoryCacheRegister a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(ImMemoryCacheRegister imMemoryCacheRegister, int i) {
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
            ImMessageCenterPojo i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof CustomResponsedMessage) || customResponsedMessage.hasError() || (i = y97.o().i(TbEnum.CustomGroupId.GROUP_VALIDATION, -4)) == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data == null) {
                i.setUnread_count(0);
                i.setIs_hidden(1);
                this.a.t(i);
            } else if (data instanceof ImMessageCenterPojo) {
                ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                i.setLast_content(imMessageCenterPojo.getLast_content());
                i.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                i.setUnread_count(0);
                i.setIs_hidden(0);
                this.a.t(i);
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
        this.d = new z(this, 0);
        this.e = new a0(this, 0);
        this.f = new b0(this, 0);
        this.g = new c0(this, 0);
        this.h = new d0(this, 0);
        this.i = new f0(this, 0);
        this.j = new b(this, 0);
        this.k = new c(this, 0);
        this.l = new d(this, 0);
        this.m = new e(this, 0);
        this.n = new f(this, 0);
        this.o = new g(this, 2016016);
        this.p = new h(this);
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
        this.D = new w(this);
        r();
    }

    public static ImMemoryCacheRegister l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            ej.c();
            if (E == null) {
                synchronized (ImMemoryCacheRegister.class) {
                    if (E == null) {
                        E = new ImMemoryCacheRegister();
                    }
                }
            }
            return E;
        }
        return (ImMemoryCacheRegister) invokeV.objValue;
    }

    public static /* synthetic */ void o(Activity activity, boolean z2, ChatMessage chatMessage, String str) {
        if (activity != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (z2) {
                boolean z3 = q25.c() == chatMessage.getToUserId();
                boolean h2 = bx4.k().h("key_person_growth_share_switch", false);
                if (z3 && !TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SHARE_THREAD) && !h2) {
                    bx4.k().u("key_person_growth_share_switch", true);
                    BdToastData bdToastData = new BdToastData();
                    if (TbadkCoreApplication.getCurrentMemberType() > 0) {
                        bdToastData.setIconType(5);
                    } else {
                        bdToastData.setIconType(4);
                    }
                    ArrayList arrayList = new ArrayList(1);
                    BdToastData.ContentBean contentBean = new BdToastData.ContentBean();
                    contentBean.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f08df));
                    arrayList.add(contentBean);
                    String userGrowthWeight = TbSingleton.getInstance().getUserGrowthWeight(UserGrowthTaskRequestMessage.SHARE_THREAD);
                    if (userGrowthWeight != null) {
                        if (TbadkCoreApplication.getCurrentMemberType() > 0) {
                            try {
                                userGrowthWeight = (Integer.parseInt(userGrowthWeight) * 2) + "";
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                        }
                        spannableStringBuilder.append((CharSequence) BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX).append((CharSequence) userGrowthWeight);
                        BdToastData.ContentBean contentBean2 = new BdToastData.ContentBean();
                        contentBean2.setHasColor(1);
                        contentBean2.setText(spannableStringBuilder.toString());
                        arrayList.add(contentBean2);
                    }
                    bdToastData.setContent(arrayList);
                    BdToastHelper.toast(bdToastData);
                    MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SHARE_THREAD));
                    return;
                }
                spannableStringBuilder.append((CharSequence) str);
            } else {
                spannableStringBuilder.append((CharSequence) str);
            }
            BdToast.b(TbadkCoreApplication.getInst().getContext(), spannableStringBuilder).i();
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 3160014) {
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v97.e();
        }
    }

    public final void p() {
        ResponseOnlineMessage responseOnlineMessage;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (responseOnlineMessage = this.a) == null) {
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
                imMessageCenterPojo.setCustomGroupType(ea7.a(next.getGroupType()));
                imMessageCenterPojo.setGroup_head(next.getPortrait());
                imMessageCenterPojo.setGroup_name(next.getName());
                imMessageCenterPojo.setNameShow(next.getNameShow());
                imMessageCenterPojo.setPulled_msgId(ec7.a(next.getLastMsgId()));
                if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                    imMessageCenterPojo.setIs_hidden(1);
                }
                y97.o().V(imMessageCenterPojo);
                y97.o().X(imMessageCenterPojo);
            }
        }
        long clientLogID = this.a.getOrginalMessage() != null ? this.a.getOrginalMessage().getClientLogID() : -1L;
        int cmd = this.a.getCmd();
        int error = this.a.getError();
        String errorString = this.a.getErrorString();
        Object[] objArr = new Object[2];
        objArr[0] = "comment";
        objArr[1] = sb == null ? "" : sb.toString();
        qw4.a("im", clientLogID, cmd, IMTrackDatabase.AckEnum.TABLE_NAME, error, errorString, objArr);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ImMessageCenterPojo imMessageCenterPojo2 = null;
        ImMessageCenterPojo imMessageCenterPojo3 = null;
        ImMessageCenterPojo imMessageCenterPojo4 = null;
        ImMessageCenterPojo imMessageCenterPojo5 = null;
        for (ImMessageCenterPojo imMessageCenterPojo6 : y97.o().j()) {
            if (imMessageCenterPojo6.getCustomGroupType() == i3) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(imMessageCenterPojo6);
                boolean z2 = true;
                for (GroupUpdateMessage groupUpdateMessage : this.a.getGroupInfos()) {
                    if (ea7.a(groupUpdateMessage.getGroupType()) == i3 && imMessageCenterPojo6.getGid().equals(String.valueOf(groupUpdateMessage.getGroupId()))) {
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
                oa7.b().f(imMessageCenterPojo6.getGid());
                imMessageCenterPojo2 = imMessageCenterPojo6;
            } else if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                ra7.z(dh.g(imMessageCenterPojo6.getGid(), 0L));
                imMessageCenterPojo4 = imMessageCenterPojo6;
            } else if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                ra7.y(dh.g(imMessageCenterPojo6.getGid(), 0L));
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
            y97.o().H(arrayList);
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
        if (this.a.isUserAvailable()) {
            onlineToDbCustomMessage.needDeleteGroupList = arrayList;
        }
        MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
        this.a = null;
    }

    public final void q(String str) {
        HashMap<String, String> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        y97.o().F(str, 1);
        if (v15.h0().E() != null && (a2 = v15.h0().E().a()) != null && a2.size() == 1 && a2.containsKey(str)) {
            v15.h0().d(str);
        }
        wa7.k().j(TbadkCoreApplication.getCurrentAccount(), str, null);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new x(this, str));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ac7.a("ImMemoryCacheRegister register");
            MessageManager.getInstance().registerListener(2012125, this.g);
            MessageManager.getInstance().registerListener(2012124, this.g);
            MessageManager.getInstance().registerListener(2012123, this.g);
            MessageManager.getInstance().registerListener(2012121, this.g);
            MessageManager.getInstance().registerListener(2012120, this.g);
            MessageManager.getInstance().registerListener(2012126, this.g);
            MessageManager.getInstance().registerListener(2012128, this.g);
            MessageManager.getInstance().registerListener(2012129, this.g);
            MessageManager.getInstance().registerListener(1001, this.h);
            MessageManager.getInstance().registerListener(2005018, this.j);
            MessageManager.getInstance().registerStickyMode(2016002);
            MessageManager.getInstance().registerListener(2016002, this.i);
            MessageManager.getInstance().registerListener(2016003, this.k);
            MessageManager.getInstance().registerListener(2008016, this.l);
            MessageManager.getInstance().registerListener(2016005, this.m);
            MessageManager.getInstance().registerListener(2016006, this.n);
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(2016015, this.f);
            CustomMessageTask customMessageTask = new CustomMessageTask(2016007, this.p);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(2921689, this.q);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            MessageManager.getInstance().registerListener(2001211, this.d);
            MessageManager.getInstance().registerListener(202001, this.b);
            MessageManager.getInstance().registerListener(205001, this.c);
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
            MessageManager.getInstance().registerListener(2016009, this.e);
            MessageManager.getInstance().registerListener(2001174, this.s);
            MessageManager.getInstance().registerListener(205006, this.t);
            MessageManager.getInstance().registerListener(2016013, this.u);
            MessageManager.getInstance().registerListener(this.v);
            MessageManager.getInstance().registerListener(this.w);
            MessageManager.getInstance().registerListener(this.x);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(2921692, this.D);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
        }
    }

    public final void s(final ChatMessage chatMessage, final String str, final boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, chatMessage, str, z2) == null) {
            if (chatMessage.getMsgType() == 32 || chatMessage.getMsgType() == 33) {
                final Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                gh.a().post(new Runnable() { // from class: com.baidu.tieba.w97
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ImMemoryCacheRegister.o(currentActivity, z2, chatMessage, str);
                        }
                    }
                });
            }
        }
    }

    public final void t(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, imMessageCenterPojo) == null) || imMessageCenterPojo == null) {
            return;
        }
        y97.o().Y(imMessageCenterPojo);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new y(this, imMessageCenterPojo));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }
}
