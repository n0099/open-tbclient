package com.baidu.tieba.im.memorycache;

import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
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
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.b.g;
import com.baidu.tieba.im.db.j;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static volatile b eYu;
    private CustomMessage<String> eYA;
    private BdUniqueId mId;
    private final String eYt = "0";
    final AtomicBoolean eYv = new AtomicBoolean(false);
    private final a eYw = new a();
    private final a eYx = new a();
    private final a eYy = new a();
    private final int eYz = 10;
    private CustomMessageListener eYB = new CustomMessageListener(2016008) { // from class: com.baidu.tieba.im.memorycache.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                com.baidu.tieba.im.push.c.aUW().clear();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                    if (data != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo : data) {
                            if (imMessageCenterPojo != null && c.qv(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                                b.this.h(imMessageCenterPojo);
                            }
                        }
                    }
                    b.this.eYv.set(true);
                    b.this.aUd();
                    return;
                }
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                        if (!b.this.o(imMessageCenterPojo2) || imMessageCenterPojo2.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                                com.baidu.tieba.im.push.c.aUW().bQ(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                            }
                            b.this.h(imMessageCenterPojo2);
                        }
                    }
                    b.this.iP(false);
                    b.this.iQ(false);
                    b.this.aUb();
                    b.this.aUc();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                b.this.eYv.set(true);
                b.this.aUd();
            }
        }
    };

    private b() {
        MessageManager.getInstance().registerListener(this.eYB);
        this.eYA = new CustomMessage<>(2016008, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.eYA.setTag(this.mId);
    }

    public boolean qs() {
        return this.eYv.get();
    }

    public static b aUa() {
        if (eYu == null) {
            synchronized (b.class) {
                if (eYu == null) {
                    eYu = new b();
                }
            }
        }
        return eYu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.eYv.set(false);
        clear();
        MessageManager.getInstance().removeMessage(2016008, this.mId);
        this.eYA.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                n.aRV();
                LinkedList<ImMessageCenterPojo> aRO = j.aRM().aRO();
                long cs = g.aPZ().cs(11L);
                long cs2 = g.aPZ().cs(12L);
                if (aRO == null) {
                    aRO = new LinkedList<>();
                }
                if (cs != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    aRO.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(d.cH(cs));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (cs2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    aRO.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(d.cH(cs2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(aRO, data);
            }
        });
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.eYA, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUb() {
        ImMessageCenterPojo qJ;
        a qt = qt(-4);
        if (qt != null && (qJ = qt.qJ("-1003")) != null) {
            String last_content = qJ.getLast_content();
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
                    ImMessageCenterPojo qJ2 = this.eYw.qJ(str);
                    if (qJ2 != null) {
                        str3 = qJ2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        qJ.setLast_content(str2 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(e.j.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUc() {
        ImMessageCenterPojo qJ;
        a qt = qt(-3);
        if (qt != null && (qJ = qt.qJ("-1002")) != null) {
            String last_content = qJ.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    qJ.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            qt(imMessageCenterPojo.getCustomGroupType()).g(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo ay(String str, int i) {
        a qt;
        if (this.eYv.get() && (qt = qt(i)) != null) {
            return qt.qJ(str);
        }
        return null;
    }

    public void az(String str, int i) {
        ImMessageCenterPojo ay = ay(str, i);
        if (ay != null) {
            as(str, i);
            i(ay);
        }
    }

    public void as(String str, int i) {
        a qt;
        if (this.eYv.get() && (qt = qt(i)) != null) {
            qt.qK(str);
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eYv.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(iP(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(iQ(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eYv.get()) {
            ImMessageCenterPojo ay = ay(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ay == null) {
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= ay.getLast_rid()) {
                as(ay.getGid(), ay.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(ay.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(ay.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(ay.getNameShow());
                }
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                ay.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.eYv.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ay = ay(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ay == null) {
                imMessageCenterPojo.setUnread_count(i);
                h(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > ay.getLast_rid()) {
                ay.setLast_rid(imMessageCenterPojo.getLast_rid());
                ay.setLast_content(imMessageCenterPojo.getLast_content());
                ay.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                ay.setUnread_count(ay.getUnread_count() + i);
                ay.setIs_hidden(0);
                ay.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                ay.setGroup_name(imMessageCenterPojo.getGroup_name());
                ay.setNameShow(imMessageCenterPojo.getNameShow());
                a(ay, true);
            }
        }
    }

    private void clear() {
        this.eYw.aTZ();
        this.eYx.aTZ();
        this.eYy.aTZ();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo ay;
        if (this.eYv.get()) {
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
                ImMessageCenterPojo ay2 = ay(str, i);
                if (ay2 == null) {
                    ay2 = new ImMessageCenterPojo();
                    ay2.setCustomGroupType(i);
                    ay2.setGid(str);
                    h(ay2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            ay2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            ay2.setGroup_name(userData.getUserName());
                        }
                        if (!TextUtils.isEmpty(userData.getName_show())) {
                            ay2.setNameShow(userData.getName_show());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        ay2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        ay2.setLast_content("");
                        ay2.setLast_rid(0L);
                        ay2.setSend_status(0);
                        ay2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            ay2.setLast_content_time(chatMessage.getTime() * 1000);
                            ay2.setLast_content(com.baidu.tieba.im.util.e.V(chatMessage.getMsgType(), chatMessage.getContent()));
                            ay2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            ay2.setLast_rid(chatMessage.getRecordId());
                            ay2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            ay2.setIsFriend(chatMessage.getIsFriend());
                            ay2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                ay2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            ay2.setLast_content("");
                            ay2.setLast_rid(0L);
                            ay2.setSend_status(0);
                            ay2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && ay2.getLast_rid() <= chatMessage.getRecordId()) {
                            ay2.setLast_content_time(chatMessage.getTime() * 1000);
                            ay2.setLast_content(com.baidu.tieba.im.util.e.V(chatMessage.getMsgType(), chatMessage.getContent()));
                            ay2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            ay2.setLast_rid(chatMessage.getRecordId());
                            ay2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            ay2.setIsFriend(chatMessage.getIsFriend());
                            ay2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                ay2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        ay2.setIs_hidden(0);
                        if (i == 4 && (ay = ay("-1000", -8)) != null) {
                            ay.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + ay2.getSend_status());
                a(ay2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eYv.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ay = ay(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ay == null) {
                h(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            as(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(ay.getPulled_msgId());
            h(imMessageCenterPojo);
            return imMessageCenterPojo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(ImMessageCenterPojo imMessageCenterPojo) {
        a(k(imMessageCenterPojo), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bO(String str, String str2) {
        ImMessageCenterPojo ay = ay(str, 1);
        if (ay != null) {
            ay.setGroup_head(str2);
            a(ay, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bP(String str, String str2) {
        ImMessageCenterPojo ay = ay(str, 1);
        if (ay != null) {
            ay.setGroup_name(str2);
            a(ay, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eYv.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ay = ay(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ay == null) {
                h(imMessageCenterPojo);
                return;
            }
            ay.setGroup_head(imMessageCenterPojo.getGroup_head());
            ay.setGroup_name(imMessageCenterPojo.getGroup_name());
            ay.setNameShow(imMessageCenterPojo.getNameShow());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.eYv.get()) {
            this.eYw.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.12
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
                public void b(Iterator<ImMessageCenterPojo> it) {
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
            this.eYx.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.13
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
                public void b(Iterator<ImMessageCenterPojo> it) {
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
            this.eYy.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.14
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
                public void b(Iterator<ImMessageCenterPojo> it) {
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
    public void n(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eYv.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo ay = ay(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ay == null) {
                h(imMessageCenterPojo);
            } else if (ay.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                ay.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, long j, String str) {
        if (this.eYv.get()) {
            ImMessageCenterPojo ay = ay(str, i);
            if (ay == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                h(imMessageCenterPojo);
            } else if (ay.getPulled_msgId() < j) {
                ay.setPulled_msgId(j);
            }
        }
    }

    ImMessageCenterPojo d(String str, int i, boolean z) {
        ImMessageCenterPojo ay = ay(str, i);
        if (ay != null) {
            if (z) {
                ay.setIs_hidden(0);
            } else {
                ay.setIs_hidden(1);
            }
        }
        return ay;
    }

    public void e(String str, int i, boolean z) {
        ImMessageCenterPojo d = d(str, i, z);
        if (d != null) {
            a(d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aA(String str, int i) {
        ImMessageCenterPojo ay = ay(str, i);
        if (ay != null) {
            ay.setUnread_count(0);
            a(ay, false);
        }
    }

    void aUd() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> aUe() {
        final LinkedList linkedList = new LinkedList();
        this.eYw.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.15
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.eYx.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.16
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.eYy.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.17
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> aUf() {
        final LinkedList linkedList = new LinkedList();
        this.eYw.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.18
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> aUg() {
        final LinkedList linkedList = new LinkedList();
        this.eYy.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.2
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> aUh() {
        final LinkedList linkedList = new LinkedList();
        this.eYx.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.3
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
            public void b(Iterator<ImMessageCenterPojo> it) {
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
    public List<ImMessageCenterPojo> aUi() {
        final LinkedList linkedList = new LinkedList();
        this.eYx.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.4
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
            public void b(Iterator<ImMessageCenterPojo> it) {
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
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016001));
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.eYv.get()) {
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
        a(iP(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo iP(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a qt = qt(-7);
        if (qt != null) {
            imMessageCenterPojo = qt.qJ("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.eYx.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.5
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
            public void b(Iterator<ImMessageCenterPojo> it) {
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
                final ImMessageCenterPojo ay = ay("-1001", -7);
                if (ay != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.6
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.aRM().f(ay);
                            return null;
                        }
                    });
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        } else {
            if (z) {
                if (ChatStatusManager.getInst().getIsOpen(5)) {
                    imMessageCenterPojo.setUnread_count(0);
                } else {
                    imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
                }
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
            }
            imMessageCenterPojo.setIs_hidden(imMessageCenterPojo2.getIs_hidden());
        }
        return imMessageCenterPojo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo iQ(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a qt = qt(-8);
        if (qt != null) {
            imMessageCenterPojo = qt.qJ("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.eYy.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.7
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
            public void b(Iterator<ImMessageCenterPojo> it) {
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
                        j.aRM().f(imMessageCenterPojo3);
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
        a(iQ(z), z, i);
    }

    public void aUj() {
        a(iQ(false), false, 1);
    }

    public void aUk() {
        a(iP(false), false, 1);
    }

    public LongSparseArray<Long> aUl() {
        final LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
        if (this.eYv.get()) {
            this.eYw.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.9
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
                public void b(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        if (b.this.o(next)) {
                            longSparseArray.put(com.baidu.adp.lib.g.b.d(next.getGid(), 0L), Long.valueOf(d.cI(next.getPulled_msgId())));
                        }
                    }
                }
            });
        }
        return longSparseArray;
    }

    public NewpushRepair aUm() {
        final NewpushRepair.Builder builder = new NewpushRepair.Builder();
        final ArrayList arrayList = new ArrayList();
        if (this.eYv.get()) {
            this.eYy.a(new a.InterfaceC0250a() { // from class: com.baidu.tieba.im.memorycache.b.10
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0250a
                public void b(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        long d = com.baidu.adp.lib.g.b.d(next.getGid(), 0L);
                        long sid = next.getSid();
                        if (sid > 0) {
                            arrayList.add(MessageUtils.makeNewpushGroupRepair(d, next.getUserType(), sid, 0L, d.cI(next.getPulled_msgId())));
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
    public boolean o(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.getInst().getCustomizedFilter().cw(imMessageCenterPojo.getCustomGroupType());
        }
        return c.qu(imMessageCenterPojo.getCustomGroupType());
    }

    public long aB(String str, int i) {
        ImMessageCenterPojo ay = ay(str, i);
        if (ay != null) {
            return ay.getPulled_msgId();
        }
        return 0L;
    }

    public long aC(String str, int i) {
        ImMessageCenterPojo ay = ay(str, i);
        long j = 0;
        if (ay != null) {
            j = ay.getLast_rid() > ay.getPulled_msgId() ? ay.getLast_rid() : ay.getPulled_msgId();
        }
        return j + 1;
    }

    private a qt(int i) {
        if (i == 2) {
            return this.eYx;
        }
        if (i == 4) {
            return this.eYy;
        }
        return this.eYw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cL(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.eYw.qK(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
