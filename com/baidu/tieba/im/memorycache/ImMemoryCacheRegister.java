package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FieldBuilder;
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
import d.a.n0.f1.f.l.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ImMemoryCacheRegister {
    public static volatile ImMemoryCacheRegister D;

    /* renamed from: a  reason: collision with root package name */
    public ResponseOnlineMessage f17234a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.c.g.c f17235b = new a(this, 0);

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.c f17236c = new l(this, 0);

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f17237d = new y(0);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f17238e = new z(0);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f17239f = new a0(this, 0);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f17240g = new b0(0);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17241h = new c0(0);

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.c f17242i = new d0(0);
    public CustomMessageListener j = new b(0);
    public CustomMessageListener k = new c(0);
    public CustomMessageListener l = new d(this, 0);
    public CustomMessageListener m = new e(this, 0);
    public CustomMessageListener n = new f(this, 0);
    public CustomMessageListener o = new g(this, 0);
    public CustomMessageListener p = new h(this, 2016016);
    public CustomMessageTask.CustomRunnable<Integer> q = new i(this);
    public CustomMessageListener r = new j(0);
    public CustomMessageListener s = new k(this, 0);
    public d.a.c.c.g.c t = new m(this, 0);
    public CustomMessageListener u = new n(this, 0);
    public CustomMessageListener v = new o(this, 2016017);
    public CustomMessageListener w = new p(this, 2016020);
    public CustomMessageListener x = new q(this, 2001382);
    public a.b y = new r(this);
    public a.b z = new s(this);
    public a.b A = new t(this);
    public a.b B = new u(this);
    public a.b C = new v(this);

    /* loaded from: classes4.dex */
    public class OnlineToDbCustomMessage extends CustomMessage<String> {
        public List<ImMessageCenterPojo> needCreateGroupList;
        public List<ImMessageCenterPojo> needDeleteGroupList;
        public ImMessageCenterPojo notifyGroup;
        public ImMessageCenterPojo officialChatGroup;
        public ImMessageCenterPojo privateChatGroup;
        public ImMessageCenterPojo systemGroup;
        public List<ImMessageCenterPojo> yyGroupList;

        public OnlineToDbCustomMessage(int i2) {
            super(i2);
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
    public class a extends d.a.c.c.g.c {

        /* renamed from: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0186a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17243e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ChatMessage f17244f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SocketResponsedMessage f17245g;

            public C0186a(a aVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
                this.f17243e = imMessageCenterPojo;
                this.f17244f = chatMessage;
                this.f17245g = socketResponsedMessage;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                    return null;
                }
                try {
                    try {
                        d.a.n0.f1.h.h.e().i();
                        d.a.n0.f1.h.j.f().k(this.f17243e, 3);
                        d.a.n0.f1.h.c.h().o(this.f17244f.getGroupId(), String.valueOf(this.f17244f.getRecordId()), String.valueOf(this.f17244f.getMsgId()), this.f17244f.getLocalData().getStatus().shortValue());
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    d.a.n0.f1.h.h.e().c();
                    return new CustomResponsedMessage<>(2016012, this.f17245g);
                } catch (Throwable th) {
                    d.a.n0.f1.h.h.e().c();
                    throw th;
                }
            }
        }

        public a(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
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
            d.a.m0.r.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), IMTrackDatabase.AckEnum.TABLE_NAME, socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), new Object[0]);
            d.a.n0.f1.k.b.o().X(chatMessage.getCustomGroupType(), chatMessage, chatMessage.getGroupId(), 3);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new C0186a(this, d.a.n0.f1.k.b.o().i(chatMessage.getGroupId(), chatMessage.getCustomGroupType()), chatMessage, socketResponsedMessage));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ MemoryClearStrangerItemsMessage f17246e;

            public a(a0 a0Var, MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage) {
                this.f17246e = memoryClearStrangerItemsMessage;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                    return null;
                }
                try {
                    try {
                        d.a.n0.f1.h.h.e().i();
                        d.a.n0.f1.h.j.f().b();
                        if (this.f17246e.isAllClear()) {
                            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                            imMessageCenterPojo.setCustomGroupType(-7);
                            imMessageCenterPojo.setIs_hidden(1);
                            d.a.n0.f1.h.j.f().j(imMessageCenterPojo);
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    return null;
                } finally {
                    d.a.n0.f1.h.h.e().c();
                }
            }
        }

        public a0(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage;
            MemoryClearStrangerItemsMessage.a data;
            List<MemoryModifyVisibilityMessage.a> list;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof MemoryClearStrangerItemsMessage) || (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) == null || (list = data.f17283a) == null) {
                return;
            }
            for (MemoryModifyVisibilityMessage.a aVar : list) {
                d.a.n0.f1.k.b.o().H(aVar.f17290a, aVar.f17291b);
            }
            if (memoryClearStrangerItemsMessage.isAllClear()) {
                d.a.n0.f1.k.b.o().B(TbEnum.CustomGroupId.STRANGE_MERGE, -7, false);
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
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002 && (customResponsedMessage instanceof MemoryInitCompleteMessage)) {
                ImMemoryCacheRegister.this.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {
        public b0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof MemoryItemRemoveMessage.a)) {
                return;
            }
            MemoryItemRemoveMessage.a aVar = (MemoryItemRemoveMessage.a) customResponsedMessage.getData();
            if (aVar.f17284a == 1) {
                ImMemoryCacheRegister.this.l(aVar.f17285b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005018) {
                return;
            }
            ImMemoryCacheRegister.this.f17234a = null;
            d.a.n0.f1.s.a.x(0L);
            d.a.n0.f1.s.a.w(0L);
            d.a.n0.f1.k.b.o().w();
            d.a.m0.s.d.c.k().l();
        }
    }

    /* loaded from: classes4.dex */
    public class c0 extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements a.b {
            public a(c0 c0Var) {
            }

            @Override // d.a.n0.f1.f.l.a.b
            public void a(String str, List<CommonMsgPojo> list) {
            }

            @Override // d.a.n0.f1.f.l.a.b
            public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
                if (imMessageCenterPojo == null) {
                    return;
                }
                d.a.n0.f1.k.b.o().V(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
            }
        }

        public c0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof GroupMsgData)) {
                return;
            }
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
            ImMessageCenterPojo i2 = d.a.n0.f1.k.b.o().i(valueOf, customType);
            if (groupMsgData.getCmd() == 2012125) {
                d.a.n0.f1.f.l.b.a(groupMsgData, i2, ImMemoryCacheRegister.this.y);
            } else if (groupMsgData.getCmd() == 2012124) {
                d.a.n0.f1.f.l.c.a(groupMsgData, i2, ImMemoryCacheRegister.this.A);
            } else if (groupMsgData.getCmd() == 2012123) {
                d.a.n0.f1.f.l.d.a(groupMsgData, i2, ImMemoryCacheRegister.this.B);
            } else if (groupMsgData.getCmd() == 2012121) {
                d.a.n0.f1.f.l.e.b(groupMsgData, i2, ImMemoryCacheRegister.this.C);
            } else if (groupMsgData.getCmd() == 2012120) {
                d.a.n0.f1.f.l.f.f(groupMsgData, i2, ImMemoryCacheRegister.this.z);
            } else if (groupMsgData.getCmd() == 2012128) {
                if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().size() <= 0) {
                    return;
                }
                d.a.n0.f1.k.b.o().V(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(d.a.n0.f1.s.a.f54696i));
            } else if (groupMsgData.getCmd() == 2012129) {
                if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().size() <= 0) {
                    return;
                }
                ChatMessage chatMessage = groupMsgData.getListMessage().get(0);
                if (chatMessage.isPushForOperateAccount()) {
                    return;
                }
                d.a.n0.f1.k.b.o().V(-9, chatMessage.getMsgId(), String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
            } else if (groupMsgData.getCmd() == 2012126) {
                if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                    d.a.n0.f1.f.l.g.d(groupMsgData, i2, new a(this));
                } else {
                    long[] a2 = d.a.n0.f1.f.l.g.b().a(groupMsgData);
                    if (a2 != null && a2.length == 2) {
                        if (a2[0] > 0 || a2[1] <= 0) {
                            return;
                        }
                        if (a2[0] == 12) {
                            d.a.n0.f1.k.b.o().V(8, a2[1], String.valueOf(12));
                        } else if (a2[0] == 11) {
                            d.a.n0.f1.k.b.o().V(7, a2[1], String.valueOf(11));
                        }
                    }
                }
                d.a.n0.f1.f.l.g.b().e(groupMsgData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17251e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17252f;

            public a(d dVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
                this.f17251e = imMessageCenterPojo;
                this.f17252f = imMessageCenterPojo2;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                d.a.n0.f1.h.j.f().k(this.f17251e, 2);
                if (this.f17252f != null) {
                    d.a.n0.f1.h.j.f().k(this.f17252f, 2);
                    return null;
                }
                return null;
            }
        }

        public d(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyLastMsgMessage.a data;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016003 || (data = ((MemoryModifyLastMsgMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            d.a.n0.f1.k.b.o().X(data.f17287b, data.f17288c, data.f17286a, data.f17289d);
            ImMessageCenterPojo i2 = d.a.n0.f1.k.b.o().i(data.f17286a, data.f17287b);
            if (i2 == null) {
                return;
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2, i2.getCustomGroupType() == 4 ? d.a.n0.f1.k.b.o().i(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8) : null));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class d0 extends d.a.c.c.g.c {
        public d0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ImMemoryCacheRegister.this.f17234a = (ResponseOnlineMessage) socketResponsedMessage;
                if (d.a.n0.f1.k.b.o().f54584a.get()) {
                    ImMemoryCacheRegister.this.k();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2008016) {
                return;
            }
            d.a.n0.f1.k.b.o().J();
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements CustomMessageTask.CustomRunnable<String> {
        public e0(ImMemoryCacheRegister imMemoryCacheRegister) {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            if (customMessage == null || !(customMessage instanceof OnlineToDbCustomMessage)) {
                return null;
            }
            OnlineToDbCustomMessage onlineToDbCustomMessage = (OnlineToDbCustomMessage) customMessage;
            try {
                try {
                    d.a.n0.f1.h.h.e().i();
                    if (onlineToDbCustomMessage.needCreateGroupList != null) {
                        d.a.n0.f1.h.c.h().b(onlineToDbCustomMessage.needCreateGroupList);
                        for (ImMessageCenterPojo imMessageCenterPojo : onlineToDbCustomMessage.needCreateGroupList) {
                            d.a.n0.f1.h.j.f().j(imMessageCenterPojo);
                        }
                    }
                    if (onlineToDbCustomMessage.systemGroup != null) {
                        d.a.n0.f1.h.j.f().j(onlineToDbCustomMessage.systemGroup);
                    }
                    if (onlineToDbCustomMessage.privateChatGroup != null) {
                        d.a.n0.f1.h.j.f().j(onlineToDbCustomMessage.privateChatGroup);
                    }
                    if (onlineToDbCustomMessage.officialChatGroup != null) {
                        d.a.n0.f1.h.j.f().j(onlineToDbCustomMessage.officialChatGroup);
                    }
                    if (onlineToDbCustomMessage.notifyGroup != null) {
                        d.a.n0.f1.h.j.f().j(onlineToDbCustomMessage.notifyGroup);
                    }
                    if (onlineToDbCustomMessage.yyGroupList != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo2 : onlineToDbCustomMessage.yyGroupList) {
                            if (imMessageCenterPojo2.getCustomGroupType() == 6) {
                                d.a.n0.f1.h.j.f().j(imMessageCenterPojo2);
                            } else {
                                d.a.n0.f1.f.l.g.b().f(imMessageCenterPojo2.getGid(), d.a.n0.f1.w.b.c(imMessageCenterPojo2.getPulled_msgId()));
                            }
                        }
                    }
                    if (onlineToDbCustomMessage.needDeleteGroupList != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo3 : onlineToDbCustomMessage.needDeleteGroupList) {
                            if (imMessageCenterPojo3 != null) {
                                d.a.n0.f1.h.j.f().c(imMessageCenterPojo3.getGid(), imMessageCenterPojo3.getCustomGroupType());
                            }
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return null;
            } finally {
                d.a.n0.f1.h.h.e().c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17254e;

            public a(f fVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17254e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    d.a.n0.f1.h.j.f().j(this.f17254e);
                }
                return null;
            }
        }

        public f(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyVisibilityMessage.a data;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016005 || !(customResponsedMessage instanceof MemoryModifyVisibilityMessage) || (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            ImMessageCenterPojo i2 = d.a.n0.f1.k.b.o().i(data.f17290a, data.f17291b);
            int i3 = !data.f17292c ? 1 : 0;
            if (i2 == null || i3 == i2.getIs_hidden()) {
                return;
            }
            int i4 = data.f17291b;
            if (i4 == 2) {
                d.a.m0.s.d.b.g0().s(data.f17290a);
            } else if (i4 == 4) {
                d.a.m0.s.d.b.g0().r(d.a.c.e.m.b.d(data.f17290a, 0));
            } else if (i4 == -3) {
                d.a.m0.s.d.b.g0().f(2);
            } else if (i4 == -4) {
                d.a.m0.s.d.b.g0().f(1);
            } else {
                d.a.m0.s.d.b.g0().d(data.f17290a);
            }
            d.a.n0.f1.k.b.o().B(data.f17290a, data.f17291b, data.f17292c);
            i2.setIs_hidden(i3);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a> {
            public a(g gVar) {
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<MemoryClearUnreadCountMessage.a> customMessage) {
                MemoryClearUnreadCountMessage.a data = customMessage.getData();
                d.a.n0.f1.h.j.f().a(data.f12855a, data.f12856b);
                return null;
            }
        }

        public g(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearUnreadCountMessage.a data;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016006 || !(customResponsedMessage instanceof MemoryClearUnreadCountMessage) || (data = ((MemoryClearUnreadCountMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            ImMessageCenterPojo i2 = d.a.n0.f1.k.b.o().i(data.f12855a, data.f12856b);
            if (i2 == null) {
                BdLog.e("ClearUnreadCountMessage:  not find memery pojo");
            } else if (i2.getUnread_count() == 0) {
            } else {
                d.a.n0.f1.k.b.o().h(data.f12855a, data.f12856b);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17255e;

            public a(h hVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17255e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                try {
                    try {
                        d.a.n0.f1.h.h.e().i();
                        d.a.n0.f1.h.j.f().j(this.f17255e);
                        d.a.n0.f1.h.c.h().a(this.f17255e.getGid());
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    d.a.n0.f1.h.h.e().c();
                    return null;
                } catch (Throwable th) {
                    d.a.n0.f1.h.h.e().c();
                    throw th;
                }
            }
        }

        public h(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ImMessageCenterPojo)) {
                return;
            }
            ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData();
            d.a.n0.f1.k.b.o().a0(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements CustomMessageTask.CustomRunnable<Integer> {
        public i(ImMemoryCacheRegister imMemoryCacheRegister) {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
            List<ImMessageCenterPojo> list = null;
            if (customMessage == null || !(customMessage instanceof RequestMemoryListMessage)) {
                return null;
            }
            int intValue = ((RequestMemoryListMessage) customMessage).getData().intValue();
            if (intValue == 3) {
                list = d.a.n0.f1.k.b.o().m();
            } else if (intValue == 2) {
                list = d.a.n0.f1.k.b.o().l();
            } else if (intValue == 1) {
                list = d.a.n0.f1.k.b.o().k();
            } else if (intValue == 4) {
                list = d.a.n0.f1.k.b.o().u();
            }
            return new ResponsedMemoryListMessage(list, intValue);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17257e;

            public a(j jVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17257e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                d.a.n0.f1.h.j.f().j(this.f17257e);
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17258e;

            public b(j jVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17258e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                d.a.n0.f1.h.j.f().j(this.f17258e);
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class c implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17259e;

            public c(j jVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17259e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                try {
                    try {
                        d.a.n0.f1.h.h.e().i();
                        d.a.n0.f1.h.c.h().a(this.f17259e.getGid());
                        d.a.n0.f1.h.j.f().j(this.f17259e);
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    d.a.n0.f1.h.h.e().c();
                    return new CustomResponsedMessage<>(2001214);
                } catch (Throwable th) {
                    d.a.n0.f1.h.h.e().c();
                    throw th;
                }
            }
        }

        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            UpdatesItemData convertToUpdatesItem;
            ImMessageCenterPojo i2;
            UpdatesItemData convertToUpdatesItem2;
            ImMessageCenterPojo i3;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null) {
                return;
            }
            String cmd = p.getCmd();
            if (TextUtils.isEmpty(cmd)) {
                return;
            }
            if (d.a.n0.f1.f.l.f.d(cmd)) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.GROUP_UPDATE);
                imMessageCenterPojo.setCustomGroupType(-3);
                imMessageCenterPojo.setLast_content(d.a.n0.f1.f.l.f.c(cmd, p.getContent()));
                imMessageCenterPojo.setLast_content_time(p.getTime());
                imMessageCenterPojo.setLast_rid(d.a.c.e.m.b.f(p.getNotice_id(), 0L));
                d.a.n0.f1.k.b.o().U(imMessageCenterPojo, !ChatStatusManager.getInst().getIsOpen(6));
            } else if (d.a.n0.f1.f.l.f.e(cmd)) {
                ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
                imMessageCenterPojo2.setCustomGroupType(-4);
                imMessageCenterPojo2.setLast_content(d.a.n0.f1.f.l.f.c(cmd, p.getContent()));
                imMessageCenterPojo2.setLast_content_time(p.getTime());
                imMessageCenterPojo2.setLast_rid(d.a.c.e.m.b.f(p.getNotice_id(), 0L));
                d.a.n0.f1.k.b.o().U(imMessageCenterPojo2, !ChatStatusManager.getInst().getIsOpen(7));
            }
            if (cmd.equals("group_head_change")) {
                if (ModelHelper.getInstance().getUpdatasModel() == null || (convertToUpdatesItem2 = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) == null) {
                    return;
                }
                String groupId = convertToUpdatesItem2.getGroupId();
                if (TextUtils.isEmpty(groupId) || TextUtils.isEmpty(convertToUpdatesItem2.getGroupHeadUrl()) || (i3 = d.a.n0.f1.k.b.o().i(groupId, 1)) == null) {
                    return;
                }
                if (i3.getGroup_head() == null || !i3.getGroup_head().equals(convertToUpdatesItem2.getGroupHeadUrl())) {
                    d.a.n0.f1.k.b.o().R(groupId, convertToUpdatesItem2.getGroupHeadUrl());
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
                if (TextUtils.isEmpty(groupId2) || TextUtils.isEmpty(convertToUpdatesItem.getGroupName()) || (i2 = d.a.n0.f1.k.b.o().i(groupId2, 1)) == null) {
                    return;
                }
                if (i2.getGroup_name() == null || !i2.getGroup_name().equals(convertToUpdatesItem.getGroupName())) {
                    d.a.n0.f1.k.b.o().S(groupId2, convertToUpdatesItem.getGroupName());
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
                    d.a.n0.f1.t.b.k().p(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                    d.a.n0.f1.t.b.k().o(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                    imMessageCenterPojo3.setGroup_name(optString3);
                    imMessageCenterPojo3.setCustomGroupType(1);
                    imMessageCenterPojo3.setGid(optString);
                    imMessageCenterPojo3.setGroup_head(optString2);
                    imMessageCenterPojo3.setLast_content_time(p.getTime());
                    imMessageCenterPojo3.setIs_hidden(0);
                    imMessageCenterPojo3.setUnread_count(0);
                    imMessageCenterPojo3.setLast_content(" ");
                    imMessageCenterPojo3.setLast_rid(d.a.n0.f1.w.b.a(optLong));
                    imMessageCenterPojo3.setPulled_msgId(d.a.n0.f1.w.b.a(optLong));
                    d.a.n0.f1.k.b.o().Z(imMessageCenterPojo3);
                    d.a.n0.f1.k.b.o().V(1, d.a.n0.f1.w.b.a(optLong), optString);
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
                ImMemoryCacheRegister.this.l(gid);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17260e;

            public a(k kVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17260e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                d.a.n0.f1.h.j.f().j(this.f17260e);
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f17261e;

            public b(k kVar, long j) {
                this.f17261e = j;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                try {
                    try {
                        d.a.n0.f1.h.h.e().i();
                        d.a.n0.f1.h.j.f().c(String.valueOf(this.f17261e), 2);
                        d.a.n0.f1.h.m.t().e(String.valueOf(this.f17261e));
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    d.a.n0.f1.h.h.e().c();
                    return null;
                } catch (Throwable th) {
                    d.a.n0.f1.h.h.e().c();
                    throw th;
                }
            }
        }

        public k(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                int action = responseNewFriendUpdateUiMsg.getAction();
                if (action != 0) {
                    if (action == 1) {
                        d.a.n0.f1.k.b.o().G(String.valueOf(friendId), 2);
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new b(this, friendId));
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                        return;
                    }
                    return;
                }
                ImMessageCenterPojo i2 = d.a.n0.f1.k.b.o().i(String.valueOf(friendId), 2);
                if (i2 != null) {
                    i2.setIsFriend(1);
                    i2.setFollowStatus(1);
                    d.a.n0.f1.k.b.o().Z(i2);
                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new a(this, i2));
                    customMessageTask2.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask2.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask2.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends d.a.c.c.g.c {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17262e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ChatMessage f17263f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SocketResponsedMessage f17264g;

            public a(l lVar, ImMessageCenterPojo imMessageCenterPojo, ChatMessage chatMessage, SocketResponsedMessage socketResponsedMessage) {
                this.f17262e = imMessageCenterPojo;
                this.f17263f = chatMessage;
                this.f17264g = socketResponsedMessage;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                    return null;
                }
                try {
                    try {
                        d.a.n0.f1.h.h.e().i();
                        d.a.n0.f1.h.j.f().k(this.f17262e, 3);
                        if (this.f17262e.getCustomGroupType() == 2) {
                            d.a.n0.f1.h.m.t().s(this.f17263f.getUserId(), this.f17263f.getToUserId(), String.valueOf(this.f17263f.getRecordId()), String.valueOf(this.f17263f.getMsgId()), this.f17263f.getLocalData().getStatus().shortValue());
                        } else {
                            d.a.n0.f1.h.l.t().s(this.f17263f.getUserId(), this.f17263f.getToUserId(), String.valueOf(this.f17263f.getRecordId()), String.valueOf(this.f17263f.getMsgId()), this.f17263f.getLocalData().getStatus().shortValue());
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    d.a.n0.f1.h.h.e().c();
                    return new CustomResponsedMessage<>(2016012, this.f17264g);
                } catch (Throwable th) {
                    d.a.n0.f1.h.h.e().c();
                    throw th;
                }
            }
        }

        public l(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ImMessageCenterPojo i2;
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
                    d.a.n0.f1.s.a.x(d.a.c.e.m.b.f(responseCommitPersonalMessage.getGroupId(), 0L));
                } else {
                    d.a.n0.f1.s.a.w(d.a.c.e.m.b.f(responseCommitPersonalMessage.getGroupId(), 0L));
                }
            }
            long clientLogID = chatMessage.getClientLogID();
            int cmd = chatMessage.getCmd();
            int error = socketResponsedMessage.getError();
            String errorString = socketResponsedMessage.getErrorString();
            d.a.m0.r.z.a.a("im", clientLogID, cmd, IMTrackDatabase.AckEnum.TABLE_NAME, error, errorString, "comment", "uType " + toUserType, "touid", Long.valueOf(chatMessage.getToUserId()), "content", chatMessage.getContent());
            boolean z = chatMessage instanceof PersonalChatMessage;
            if (z) {
                d.a.n0.f1.k.b.o().X(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
            } else if (!(chatMessage instanceof OfficialChatMessage)) {
                return;
            } else {
                d.a.n0.f1.k.b.o().X(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
            }
            if (z) {
                i2 = d.a.n0.f1.k.b.o().i(String.valueOf(d.a.n0.f1.w.c.m(chatMessage)), 2);
            } else if (!(chatMessage instanceof OfficialChatMessage)) {
                return;
            } else {
                i2 = d.a.n0.f1.k.b.o().i(String.valueOf(d.a.n0.f1.w.c.m(chatMessage)), 4);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2, chatMessage, socketResponsedMessage));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class m extends d.a.c.c.g.c {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17265e;

            public a(m mVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17265e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                try {
                    d.a.n0.f1.h.j.f().j(this.f17265e);
                    return null;
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                    return null;
                }
            }
        }

        public m(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205006 && (socketResponsedMessage instanceof ResponsedPersonalMsgReadMessage)) {
                ResponsedPersonalMsgReadMessage responsedPersonalMsgReadMessage = (ResponsedPersonalMsgReadMessage) socketResponsedMessage;
                if (!responsedPersonalMsgReadMessage.hasError() && responsedPersonalMsgReadMessage.getGroupId() == d.a.n0.f1.s.a.f54696i.longValue() && responsedPersonalMsgReadMessage.getToUserType() == 0) {
                    ImMessageCenterPojo i2 = d.a.n0.f1.k.b.o().i(String.valueOf(responsedPersonalMsgReadMessage.getToUid()), 2);
                    if (i2 == null) {
                        return;
                    }
                    long a2 = d.a.n0.f1.w.b.a(responsedPersonalMsgReadMessage.getHasSentMsgId());
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

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17266e;

            public a(n nVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17266e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                try {
                    try {
                        d.a.n0.f1.h.h.e().i();
                        d.a.n0.f1.h.j.f().j(this.f17266e);
                        if (this.f17266e.getCustomGroupType() == 1) {
                            d.a.n0.f1.h.c.h().a(this.f17266e.getGid());
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    d.a.n0.f1.h.h.e().c();
                    return new ResponseMemoryNotifyUpdataGroupMessage(this.f17266e);
                } catch (Throwable th) {
                    d.a.n0.f1.h.h.e().c();
                    throw th;
                }
            }
        }

        public n(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo imMessageCenterPojo;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016013 || (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) == null) {
                return;
            }
            d.a.n0.f1.k.b.o().W(imMessageCenterPojo);
            d.a.n0.f1.k.b.o().Y(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17267e;

            public a(o oVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17267e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                d.a.n0.f1.h.j.f().k(this.f17267e, 2);
                return null;
            }
        }

        public o(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo i2;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof MemoryUpdateHeadNameMessage.a)) {
                return;
            }
            MemoryUpdateHeadNameMessage.a aVar = (MemoryUpdateHeadNameMessage.a) customResponsedMessage.getData();
            if (TextUtils.isEmpty(aVar.f17295c)) {
                return;
            }
            if ((TextUtils.isEmpty(aVar.f17293a) && TextUtils.isEmpty(aVar.f17294b)) || (i2 = d.a.n0.f1.k.b.o().i(aVar.f17295c, aVar.f17296d)) == null) {
                return;
            }
            String str = aVar.f17294b;
            String str2 = aVar.f17293a;
            if (!TextUtils.isEmpty(str)) {
                d.a.n0.f1.k.b.o().S(aVar.f17295c, str);
            }
            if (!TextUtils.isEmpty(aVar.f17293a)) {
                d.a.n0.f1.k.b.o().R(aVar.f17295c, str2);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterPojo f17268e;

            public a(p pVar, ImMessageCenterPojo imMessageCenterPojo) {
                this.f17268e = imMessageCenterPojo;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                d.a.n0.f1.h.j.f().k(this.f17268e, 1);
                return null;
            }
        }

        public p(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo i2;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof PersonalChatMessage) {
                d.a.n0.f1.k.b.o().V(-1, ((PersonalChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(d.a.n0.f1.s.a.f54696i));
                i2 = d.a.n0.f1.k.b.o().i(String.valueOf(d.a.n0.f1.s.a.f54696i), -1);
            } else if (customResponsedMessage.getData() instanceof OfficialChatMessage) {
                d.a.n0.f1.k.b.o().V(-9, ((OfficialChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(d.a.n0.f1.s.a.j));
                i2 = d.a.n0.f1.k.b.o().i(String.valueOf(d.a.n0.f1.s.a.j), -9);
            } else {
                ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                d.a.n0.f1.k.b.o().V(1, chatMessage.getMsgId(), chatMessage.getGroupId());
                i2 = d.a.n0.f1.k.b.o().i(chatMessage.getGroupId(), 1);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, i2));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f17269e;

            public a(q qVar, List list) {
                this.f17269e = list;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                for (ImMessageCenterPojo imMessageCenterPojo : this.f17269e) {
                    d.a.n0.f1.h.j.f().j(imMessageCenterPojo);
                }
                return null;
            }
        }

        public q(ImMemoryCacheRegister imMemoryCacheRegister, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<ImMessageCenterPojo> l = d.a.n0.f1.k.b.o().l();
            if (l == null || l.size() == 0) {
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
    public class r implements a.b {
        public r(ImMemoryCacheRegister imMemoryCacheRegister) {
        }

        @Override // d.a.n0.f1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            if (list == null || list.size() == 0) {
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

        @Override // d.a.n0.f1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            d.a.n0.f1.k.b.o().T(imMessageCenterPojo);
            d.a.n0.f1.k.b.o().V(1, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements a.b {
        public s(ImMemoryCacheRegister imMemoryCacheRegister) {
        }

        @Override // d.a.n0.f1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
        }

        @Override // d.a.n0.f1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            d.a.n0.f1.k.b.o().V(-2, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
        }
    }

    /* loaded from: classes4.dex */
    public class t implements a.b {
        public t(ImMemoryCacheRegister imMemoryCacheRegister) {
        }

        @Override // d.a.n0.f1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            if (list == null || list.size() == 0) {
                return;
            }
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 10) {
                    d.a.n0.f1.f.l.a.b(commonMsgPojo.getContent());
                }
            }
        }

        @Override // d.a.n0.f1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            d.a.n0.f1.k.b.o().V(5, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements a.b {
        public u(ImMemoryCacheRegister imMemoryCacheRegister) {
        }

        @Override // d.a.n0.f1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                    RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                    d.a.n0.f1.g.d i2 = d.a.n0.f1.w.c.i(commonMsgPojo);
                    if (i2 != null) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "message_receive", "receive", 1, "task_type", i2.f54466a, "task_id", i2.f54467b);
                    }
                }
            }
        }

        @Override // d.a.n0.f1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            d.a.n0.f1.k.b.o().T(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements a.b {
        public v(ImMemoryCacheRegister imMemoryCacheRegister) {
        }

        @Override // d.a.n0.f1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
        }

        @Override // d.a.n0.f1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            d.a.n0.f1.k.b.o().T(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements CustomMessageTask.CustomRunnable<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17270e;

        public w(ImMemoryCacheRegister imMemoryCacheRegister, String str) {
            this.f17270e = str;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            if (customMessage != null) {
                try {
                    if (customMessage instanceof CustomMessage) {
                        try {
                            d.a.n0.f1.h.h.e().i();
                            d.a.n0.f1.h.j.f().c(this.f17270e, 1);
                            d.a.n0.f1.h.c.h().e(this.f17270e);
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                        return null;
                    }
                } finally {
                    d.a.n0.f1.h.h.e().c();
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class x implements CustomMessageTask.CustomRunnable<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterPojo f17271e;

        public x(ImMemoryCacheRegister imMemoryCacheRegister, ImMessageCenterPojo imMessageCenterPojo) {
            this.f17271e = imMessageCenterPojo;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            if (customMessage == null) {
                return null;
            }
            d.a.n0.f1.h.j.f().k(this.f17271e, 2);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class y extends CustomMessageListener {
        public y(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo i2;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof CustomResponsedMessage) || customResponsedMessage.hasError() || (i2 = d.a.n0.f1.k.b.o().i(TbEnum.CustomGroupId.GROUP_UPDATE, -3)) == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data == null) {
                i2.setUnread_count(0);
                i2.setIs_hidden(1);
                ImMemoryCacheRegister.this.n(i2);
            } else if (data instanceof ImMessageCenterPojo) {
                ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                i2.setLast_content(imMessageCenterPojo.getLast_content());
                i2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                i2.setUnread_count(0);
                i2.setIs_hidden(0);
                ImMemoryCacheRegister.this.n(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z extends CustomMessageListener {
        public z(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo i2;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof CustomResponsedMessage) || customResponsedMessage.hasError() || (i2 = d.a.n0.f1.k.b.o().i(TbEnum.CustomGroupId.GROUP_VALIDATION, -4)) == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data == null) {
                i2.setUnread_count(0);
                i2.setIs_hidden(1);
                ImMemoryCacheRegister.this.n(i2);
            } else if (data instanceof ImMessageCenterPojo) {
                ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                i2.setLast_content(imMessageCenterPojo.getLast_content());
                i2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                i2.setUnread_count(0);
                i2.setIs_hidden(0);
                ImMemoryCacheRegister.this.n(i2);
            }
        }
    }

    public ImMemoryCacheRegister() {
        m();
    }

    public static ImMemoryCacheRegister j() {
        d.a.c.e.p.l.d();
        if (D == null) {
            synchronized (ImMemoryCacheRegister.class) {
                if (D == null) {
                    D = new ImMemoryCacheRegister();
                }
            }
        }
        return D;
    }

    public final void k() {
        int i2;
        int i3;
        ResponseOnlineMessage responseOnlineMessage = this.f17234a;
        if (responseOnlineMessage == null) {
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
                    sb.append(FieldBuilder.SE);
                }
                sb.append(next.getGroupId());
                sb.append("-");
                sb.append(next.getLastMsgId());
                BdLog.i("gid-serverMaxMid:" + next.getGroupId() + "-" + next.getLastMsgId());
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(String.valueOf(next.getGroupId()));
                imMessageCenterPojo.setCustomGroupType(d.a.n0.f1.m.a.a(next.getGroupType()));
                imMessageCenterPojo.setGroup_head(next.getPortrait());
                imMessageCenterPojo.setGroup_name(next.getName());
                imMessageCenterPojo.setNameShow(next.getNameShow());
                imMessageCenterPojo.setPulled_msgId(d.a.n0.f1.w.b.a(next.getLastMsgId()));
                if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                    imMessageCenterPojo.setIs_hidden(1);
                }
                d.a.n0.f1.k.b.o().W(imMessageCenterPojo);
                d.a.n0.f1.k.b.o().Y(imMessageCenterPojo);
            }
        }
        long clientLogID = this.f17234a.getOrginalMessage() != null ? this.f17234a.getOrginalMessage().getClientLogID() : -1L;
        int cmd = this.f17234a.getCmd();
        int error = this.f17234a.getError();
        String errorString = this.f17234a.getErrorString();
        Object[] objArr = new Object[2];
        objArr[0] = "comment";
        objArr[1] = sb == null ? "" : sb.toString();
        d.a.m0.r.z.a.a("im", clientLogID, cmd, IMTrackDatabase.AckEnum.TABLE_NAME, error, errorString, objArr);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ImMessageCenterPojo imMessageCenterPojo2 = null;
        ImMessageCenterPojo imMessageCenterPojo3 = null;
        ImMessageCenterPojo imMessageCenterPojo4 = null;
        ImMessageCenterPojo imMessageCenterPojo5 = null;
        for (ImMessageCenterPojo imMessageCenterPojo6 : d.a.n0.f1.k.b.o().j()) {
            if (imMessageCenterPojo6.getCustomGroupType() == i3) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(imMessageCenterPojo6);
                boolean z2 = true;
                for (GroupUpdateMessage groupUpdateMessage : this.f17234a.getGroupInfos()) {
                    if (d.a.n0.f1.m.a.a(groupUpdateMessage.getGroupType()) == i3 && imMessageCenterPojo6.getGid().equals(String.valueOf(groupUpdateMessage.getGroupId()))) {
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
                d.a.n0.f1.p.b.b().g(imMessageCenterPojo6.getGid());
                imMessageCenterPojo2 = imMessageCenterPojo6;
            } else if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                d.a.n0.f1.s.a.x(d.a.c.e.m.b.f(imMessageCenterPojo6.getGid(), 0L));
                imMessageCenterPojo4 = imMessageCenterPojo6;
            } else if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                d.a.n0.f1.s.a.w(d.a.c.e.m.b.f(imMessageCenterPojo6.getGid(), 0L));
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
            d.a.n0.f1.k.b.o().I(arrayList);
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new e0(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        OnlineToDbCustomMessage onlineToDbCustomMessage = new OnlineToDbCustomMessage(2001000);
        onlineToDbCustomMessage.needCreateGroupList = arrayList2;
        onlineToDbCustomMessage.systemGroup = imMessageCenterPojo2;
        onlineToDbCustomMessage.notifyGroup = imMessageCenterPojo3;
        onlineToDbCustomMessage.privateChatGroup = imMessageCenterPojo4;
        onlineToDbCustomMessage.officialChatGroup = imMessageCenterPojo5;
        onlineToDbCustomMessage.yyGroupList = arrayList3;
        if (this.f17234a.isUserAvailable()) {
            onlineToDbCustomMessage.needDeleteGroupList = arrayList;
        }
        MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
        this.f17234a = null;
    }

    public final void l(String str) {
        HashMap<String, String> a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.n0.f1.k.b.o().G(str, 1);
        if (d.a.m0.s.d.b.g0().F() != null && (a2 = d.a.m0.s.d.b.g0().F().a()) != null && a2.size() == 1 && a2.containsKey(str)) {
            d.a.m0.s.d.b.g0().d(str);
        }
        d.a.n0.f1.t.b.k().j(TbadkCoreApplication.getCurrentAccount(), str, null);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new w(this, str));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    public final void m() {
        MessageManager.getInstance().registerListener(2012125, this.f17241h);
        MessageManager.getInstance().registerListener(2012124, this.f17241h);
        MessageManager.getInstance().registerListener(2012123, this.f17241h);
        MessageManager.getInstance().registerListener(2012121, this.f17241h);
        MessageManager.getInstance().registerListener(2012120, this.f17241h);
        MessageManager.getInstance().registerListener(2012126, this.f17241h);
        MessageManager.getInstance().registerListener(2012128, this.f17241h);
        MessageManager.getInstance().registerListener(2012129, this.f17241h);
        MessageManager.getInstance().registerListener(1001, this.f17242i);
        MessageManager.getInstance().registerListener(2005018, this.k);
        MessageManager.getInstance().registerStickyMode(2016002);
        MessageManager.getInstance().registerListener(2016002, this.j);
        MessageManager.getInstance().registerListener(2016003, this.l);
        MessageManager.getInstance().registerListener(2008016, this.m);
        MessageManager.getInstance().registerListener(2016005, this.n);
        MessageManager.getInstance().registerListener(2016006, this.o);
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(2016015, this.f17240g);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016007, this.q);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001210, this.f17237d);
        MessageManager.getInstance().registerListener(2001211, this.f17238e);
        MessageManager.getInstance().registerListener(202001, this.f17235b);
        MessageManager.getInstance().registerListener(205001, this.f17236c);
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
        MessageManager.getInstance().registerListener(2016009, this.f17239f);
        MessageManager.getInstance().registerListener(2001174, this.s);
        MessageManager.getInstance().registerListener(205006, this.t);
        MessageManager.getInstance().registerListener(2016013, this.u);
        MessageManager.getInstance().registerListener(this.v);
        MessageManager.getInstance().registerListener(this.w);
        MessageManager.getInstance().registerListener(this.x);
    }

    public final void n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return;
        }
        d.a.n0.f1.k.b.o().Z(imMessageCenterPojo);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new x(this, imMessageCenterPojo));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }
}
