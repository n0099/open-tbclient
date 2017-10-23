package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.h;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.util.d;
import com.baidu.tieba.im.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static volatile b dzH;
    private CustomMessage<String> dzN;
    private BdUniqueId mId;
    private final String dzG = "0";
    final AtomicBoolean dzI = new AtomicBoolean(false);
    private final a dzJ = new a();
    private final a dzK = new a();
    private final a dzL = new a();
    private final int dzM = 10;
    private CustomMessageListener dzO = new CustomMessageListener(CmdConfigCustom.MEMORY_GET_FROM_DB) { // from class: com.baidu.tieba.im.memorycache.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                com.baidu.tieba.im.push.c.ayC().clear();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                    if (data != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo : data) {
                            if (imMessageCenterPojo != null && c.mP(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                                b.this.e(imMessageCenterPojo);
                            }
                        }
                    }
                    b.this.dzI.set(true);
                    b.this.axL();
                    return;
                }
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                        if (!b.this.l(imMessageCenterPojo2) || imMessageCenterPojo2.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                                com.baidu.tieba.im.push.c.ayC().init(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                            }
                            b.this.e(imMessageCenterPojo2);
                        }
                    }
                    b.this.gz(false);
                    b.this.gA(false);
                    b.this.axI();
                    b.this.axJ();
                    b.this.axK();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                b.this.dzI.set(true);
                b.this.axL();
            }
        }
    };

    private b() {
        MessageManager.getInstance().registerListener(this.dzO);
        this.dzN = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.dzN.setTag(this.mId);
    }

    public boolean axG() {
        return this.dzI.get();
    }

    public static b axH() {
        if (dzH == null) {
            synchronized (b.class) {
                if (dzH == null) {
                    dzH = new b();
                }
            }
        }
        return dzH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.dzI.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.dzN.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                LinkedList<ImMessageCenterPojo> avg = i.ave().avg();
                long mp = h.ats().mp(11);
                long mp2 = h.ats().mp(12);
                if (avg == null) {
                    avg = new LinkedList<>();
                }
                if (mp != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    avg.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(d.bO(mp));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (mp2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    avg.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(d.bO(mp2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(avg, data);
            }
        });
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.dzN, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axI() {
        ImMessageCenterPojo mw;
        a mN = mN(-4);
        if (mN != null && (mw = mN.mw("-1003")) != null) {
            String last_content = mw.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    JSONObject jSONObject = new JSONObject(last_content);
                    JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    if (true == jSONObject.isNull("notice_id")) {
                        if (optJSONObject != null) {
                            str = optJSONObject.optString("groupId");
                            str2 = optJSONObject.optString("userName");
                            str3 = optJSONObject.optString("groupName");
                        }
                    } else {
                        str = jSONObject.optString("groupId");
                        str2 = jSONObject.optString("userName");
                        str3 = jSONObject.optString("groupName");
                    }
                    ImMessageCenterPojo mw2 = this.dzJ.mw(str);
                    if (mw2 != null) {
                        str3 = mw2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        mw.setLast_content(str2 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axJ() {
        ImMessageCenterPojo mw;
        a mN = mN(-3);
        if (mN != null && (mw = mN.mw("-1002")) != null) {
            String last_content = mw.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    mw.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axK() {
        ImMessageCenterPojo mw;
        a mN = mN(-5);
        if (mN != null && (mw = mN.mw("-1004")) != null) {
            String last_content = mw.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    mw.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            mN(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Z(String str, int i) {
        a mN;
        if (this.dzI.get() && (mN = mN(i)) != null) {
            return mN.mw(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(String str, int i) {
        ImMessageCenterPojo Z = Z(str, i);
        if (Z != null) {
            ab(str, i);
            f(Z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(String str, int i) {
        a mN;
        if (this.dzI.get() && (mN = mN(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            mN.mx(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dzI.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(gz(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(gA(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dzI.get()) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= Z.getLast_rid()) {
                ab(Z.getGid(), Z.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(Z.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(Z.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                Z.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.dzI.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > Z.getLast_rid()) {
                Z.setLast_rid(imMessageCenterPojo.getLast_rid());
                Z.setLast_content(imMessageCenterPojo.getLast_content());
                Z.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                Z.setUnread_count(Z.getUnread_count() + i);
                Z.setIs_hidden(0);
                Z.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                Z.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(Z, true);
            }
        }
    }

    private void clear() {
        this.dzJ.axF();
        this.dzK.axF();
        this.dzL.axF();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo Z;
        if (this.dzI.get()) {
            UserData userData = null;
            if ((i == 2 || i == 4) && chatMessage != null) {
                if (String.valueOf(chatMessage.getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                    userData = chatMessage.getToUserInfo();
                } else {
                    userData = chatMessage.getUserInfo();
                }
                if (userData != null) {
                    str = userData.getUserId();
                }
            }
            if (!TextUtils.isEmpty(str)) {
                ImMessageCenterPojo Z2 = Z(str, i);
                if (Z2 == null) {
                    Z2 = new ImMessageCenterPojo();
                    Z2.setCustomGroupType(i);
                    Z2.setGid(str);
                    e(Z2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            Z2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            Z2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        Z2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        Z2.setLast_content("");
                        Z2.setLast_rid(0L);
                        Z2.setSend_status(0);
                        Z2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            Z2.setLast_content_time(chatMessage.getTime() * 1000);
                            Z2.setLast_content(e.F(chatMessage.getMsgType(), chatMessage.getContent()));
                            Z2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            Z2.setLast_rid(chatMessage.getRecordId());
                            Z2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            Z2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                Z2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            Z2.setLast_content("");
                            Z2.setLast_rid(0L);
                            Z2.setSend_status(0);
                            Z2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && Z2.getLast_rid() <= chatMessage.getRecordId()) {
                            Z2.setLast_content_time(chatMessage.getTime() * 1000);
                            Z2.setLast_content(e.F(chatMessage.getMsgType(), chatMessage.getContent()));
                            Z2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            Z2.setLast_rid(chatMessage.getRecordId());
                            Z2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            Z2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                Z2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        Z2.setIs_hidden(0);
                        if (i == 4 && (Z = Z("-1000", -8)) != null) {
                            Z.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + Z2.getSend_status());
                a(Z2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dzI.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            ab(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(Z.getPulled_msgId());
            e(imMessageCenterPojo);
            return imMessageCenterPojo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ImMessageCenterPojo imMessageCenterPojo) {
        a(h(imMessageCenterPojo), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bf(String str, String str2) {
        ImMessageCenterPojo Z = Z(str, 1);
        if (Z != null) {
            Z.setGroup_head(str2);
            a(Z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bg(String str, String str2) {
        ImMessageCenterPojo Z = Z(str, 1);
        if (Z != null) {
            Z.setGroup_name(str2);
            a(Z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dzI.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                e(imMessageCenterPojo);
                return;
            }
            Z.setGroup_head(imMessageCenterPojo.getGroup_head());
            Z.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dzI.get()) {
            this.dzJ.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.12
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        next.setIs_hidden(1);
                        next.setLast_content("");
                        next.setLast_content_time(0L);
                        next.setLast_user_name("");
                        next.setUnread_count(0);
                        next.setSend_status(0);
                    }
                }
            });
            this.dzK.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.13
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        next.setIs_hidden(1);
                        next.setLast_content("");
                        next.setLast_content_time(0L);
                        next.setLast_user_name("");
                        next.setUnread_count(0);
                        next.setSend_status(0);
                    }
                }
            });
            this.dzL.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.14
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        next.setIs_hidden(1);
                        next.setLast_content("");
                        next.setLast_content_time(0L);
                        next.setLast_user_name("");
                        next.setUnread_count(0);
                        next.setSend_status(0);
                    }
                }
            });
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dzI.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                e(imMessageCenterPojo);
            } else if (Z.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                Z.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.dzI.get()) {
            ImMessageCenterPojo Z = Z(str, i);
            if (Z == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (Z.getPulled_msgId() < j) {
                Z.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo Z = Z(str, i);
        if (Z != null) {
            if (z) {
                Z.setIs_hidden(0);
            } else {
                Z.setIs_hidden(1);
            }
        }
        return Z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ac(String str, int i) {
        ImMessageCenterPojo Z = Z(str, i);
        if (Z != null) {
            Z.setUnread_count(0);
            a(Z, false);
        }
    }

    void axL() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> axM() {
        final LinkedList linkedList = new LinkedList();
        this.dzJ.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.15
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.dzK.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.16
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.dzL.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.17
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> axN() {
        final LinkedList linkedList = new LinkedList();
        this.dzJ.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.18
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> axO() {
        final LinkedList linkedList = new LinkedList();
        this.dzL.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.2
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> axP() {
        final LinkedList linkedList = new LinkedList();
        this.dzK.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.3
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0) {
                        linkedList.add(next);
                    }
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> axQ() {
        final LinkedList linkedList = new LinkedList();
        this.dzK.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.4
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && next.getIsFriend() == 1 && next.getIs_hidden() == 0) {
                        linkedList.add(next);
                    }
                }
            }
        });
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.dzI.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                b(imMessageCenterPojo, z, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                c(imMessageCenterPojo, z, 1);
            } else {
                a(imMessageCenterPojo, z, 1);
            }
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        a(imMessageCenterPojo, z, i);
        a(gz(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo gz(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a mN = mN(-7);
        if (mN != null) {
            imMessageCenterPojo = mN.mw("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.dzK.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.5
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                        if (imMessageCenterPojo2.getLast_content_time() < next.getLast_content_time()) {
                            imMessageCenterPojo2.setLast_content(next.getLast_content());
                            imMessageCenterPojo2.setLast_content_time(next.getLast_content_time());
                            imMessageCenterPojo2.setLast_rid(next.getLast_rid());
                            imMessageCenterPojo2.setLast_user_name(next.getLast_user_name());
                            imMessageCenterPojo2.setSend_status(next.getSend_status());
                        }
                        imMessageCenterPojo2.setUnread_count(next.getUnread_count() + imMessageCenterPojo2.getUnread_count());
                        imMessageCenterPojo2.setIs_hidden(0);
                    }
                }
            }
        });
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                final ImMessageCenterPojo Z = Z("-1001", -7);
                if (Z != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.6
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            i.ave().c(Z);
                            return null;
                        }
                    });
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        } else if (z) {
            if (ChatStatusManager.getInst().getIsOpen(5)) {
                imMessageCenterPojo.setUnread_count(0);
            } else {
                imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
                imMessageCenterPojo.setIs_hidden(imMessageCenterPojo2.getIs_hidden());
            }
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
        }
        return imMessageCenterPojo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo gA(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a mN = mN(-8);
        if (mN != null) {
            imMessageCenterPojo = mN.mw("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.dzL.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.7
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                        if (imMessageCenterPojo2.getLast_content_time() < next.getLast_content_time()) {
                            imMessageCenterPojo2.setLast_content(next.getLast_content());
                            imMessageCenterPojo2.setLast_content_time(next.getLast_content_time());
                            imMessageCenterPojo2.setLast_rid(next.getLast_rid());
                            imMessageCenterPojo2.setLast_user_name(next.getLast_user_name());
                        }
                        imMessageCenterPojo2.setIs_hidden(0);
                        imMessageCenterPojo2.setUnread_count(next.getUnread_count() + imMessageCenterPojo2.getUnread_count());
                    }
                }
            }
        });
        imMessageCenterPojo.setUserType(imMessageCenterPojo2.getUserType());
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.8
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                        imMessageCenterPojo3.setGid("-1000");
                        imMessageCenterPojo3.setCustomGroupType(-8);
                        imMessageCenterPojo3.setIs_hidden(1);
                        i.ave().c(imMessageCenterPojo3);
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        } else if (z) {
            if (ChatStatusManager.getInst().getIsOpen(4)) {
                imMessageCenterPojo.setUnread_count(0);
            } else {
                imMessageCenterPojo.setIs_hidden(imMessageCenterPojo2.getIs_hidden());
                imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
            }
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
        }
        return imMessageCenterPojo;
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        a(imMessageCenterPojo, z, i);
        a(gA(z), z, i);
    }

    public SparseArray<Long> axR() {
        final SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.dzI.get()) {
            this.dzJ.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.9
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        if (b.this.l(next)) {
                            sparseArray.put(com.baidu.adp.lib.g.b.g(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.d.bP(next.getPulled_msgId())));
                        }
                    }
                }
            });
        }
        return sparseArray;
    }

    public NewpushRepair axS() {
        final NewpushRepair.Builder builder = new NewpushRepair.Builder();
        final ArrayList arrayList = new ArrayList();
        if (this.dzI.get()) {
            this.dzL.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.im.memorycache.b.10
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0097a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        long c = com.baidu.adp.lib.g.b.c(next.getGid(), 0L);
                        long sid = next.getSid();
                        if (sid > 0) {
                            arrayList.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.d.bP(next.getPulled_msgId())));
                        }
                    }
                    if (arrayList.size() <= 10) {
                        builder.groups = arrayList;
                        return;
                    }
                    builder.followType = "0";
                }
            });
        }
        return builder.build(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.getInst().getCustomizedFilter().by(imMessageCenterPojo.getCustomGroupType());
        }
        return c.mO(imMessageCenterPojo.getCustomGroupType());
    }

    public long ad(String str, int i) {
        ImMessageCenterPojo Z = Z(str, i);
        if (Z != null) {
            return Z.getPulled_msgId();
        }
        return 0L;
    }

    public long ae(String str, int i) {
        ImMessageCenterPojo Z = Z(str, i);
        long j = 0;
        if (Z != null) {
            j = Z.getLast_rid() > Z.getPulled_msgId() ? Z.getLast_rid() : Z.getPulled_msgId();
        }
        return j + 1;
    }

    private a mN(int i) {
        if (i == 2) {
            return this.dzK;
        }
        if (i == 4) {
            return this.dzL;
        }
        return this.dzJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bQ(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.dzJ.mx(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
