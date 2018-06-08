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
import com.baidu.tieba.d;
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
    private static volatile b eqb;
    private CustomMessage<String> eqh;
    private BdUniqueId mId;
    private final String eqa = "0";
    final AtomicBoolean eqc = new AtomicBoolean(false);
    private final a eqd = new a();
    private final a eqe = new a();
    private final a eqf = new a();
    private final int eqg = 10;
    private CustomMessageListener eqi = new CustomMessageListener(2016008) { // from class: com.baidu.tieba.im.memorycache.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                com.baidu.tieba.im.push.c.aLo().clear();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                    if (data != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo : data) {
                            if (imMessageCenterPojo != null && c.nX(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                                b.this.h(imMessageCenterPojo);
                            }
                        }
                    }
                    b.this.eqc.set(true);
                    b.this.aKu();
                    return;
                }
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                        if (!b.this.o(imMessageCenterPojo2) || imMessageCenterPojo2.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                                com.baidu.tieba.im.push.c.aLo().bo(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                            }
                            b.this.h(imMessageCenterPojo2);
                        }
                    }
                    b.this.hx(false);
                    b.this.hy(false);
                    b.this.aKs();
                    b.this.aKt();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                b.this.eqc.set(true);
                b.this.aKu();
            }
        }
    };

    private b() {
        MessageManager.getInstance().registerListener(this.eqi);
        this.eqh = new CustomMessage<>(2016008, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.eqh.setTag(this.mId);
    }

    public boolean aKq() {
        return this.eqc.get();
    }

    public static b aKr() {
        if (eqb == null) {
            synchronized (b.class) {
                if (eqb == null) {
                    eqb = new b();
                }
            }
        }
        return eqb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.eqc.set(false);
        clear();
        MessageManager.getInstance().removeMessage(2016008, this.mId);
        this.eqh.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                n.aIk();
                LinkedList<ImMessageCenterPojo> aId = j.aIb().aId();
                long bZ = g.aGo().bZ(11L);
                long bZ2 = g.aGo().bZ(12L);
                if (aId == null) {
                    aId = new LinkedList<>();
                }
                if (bZ != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    aId.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(d.co(bZ));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (bZ2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    aId.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(d.co(bZ2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(aId, data);
            }
        });
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.eqh, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKs() {
        ImMessageCenterPojo oB;
        a nV = nV(-4);
        if (nV != null && (oB = nV.oB("-1003")) != null) {
            String last_content = oB.getLast_content();
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
                    ImMessageCenterPojo oB2 = this.eqd.oB(str);
                    if (oB2 != null) {
                        str3 = oB2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        oB.setLast_content(str2 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.k.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKt() {
        ImMessageCenterPojo oB;
        a nV = nV(-3);
        if (nV != null && (oB = nV.oB("-1002")) != null) {
            String last_content = oB.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    oB.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            nV(imMessageCenterPojo.getCustomGroupType()).g(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo as(String str, int i) {
        a nV;
        if (this.eqc.get() && (nV = nV(i)) != null) {
            return nV.oB(str);
        }
        return null;
    }

    public void at(String str, int i) {
        ImMessageCenterPojo as = as(str, i);
        if (as != null) {
            am(str, i);
            i(as);
        }
    }

    public void am(String str, int i) {
        a nV;
        if (this.eqc.get() && (nV = nV(i)) != null) {
            nV.oC(str);
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eqc.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(hx(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(hy(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eqc.get()) {
            ImMessageCenterPojo as = as(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (as == null) {
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= as.getLast_rid()) {
                am(as.getGid(), as.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(as.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(as.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(as.getNameShow());
                }
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                as.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.eqc.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo as = as(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (as == null) {
                imMessageCenterPojo.setUnread_count(i);
                h(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > as.getLast_rid()) {
                as.setLast_rid(imMessageCenterPojo.getLast_rid());
                as.setLast_content(imMessageCenterPojo.getLast_content());
                as.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                as.setUnread_count(as.getUnread_count() + i);
                as.setIs_hidden(0);
                as.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                as.setGroup_name(imMessageCenterPojo.getGroup_name());
                as.setNameShow(imMessageCenterPojo.getNameShow());
                a(as, true);
            }
        }
    }

    private void clear() {
        this.eqd.aKp();
        this.eqe.aKp();
        this.eqf.aKp();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo as;
        if (this.eqc.get()) {
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
                ImMessageCenterPojo as2 = as(str, i);
                if (as2 == null) {
                    as2 = new ImMessageCenterPojo();
                    as2.setCustomGroupType(i);
                    as2.setGid(str);
                    h(as2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            as2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            as2.setGroup_name(userData.getUserName());
                        }
                        if (!TextUtils.isEmpty(userData.getName_show())) {
                            as2.setNameShow(userData.getName_show());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        as2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        as2.setLast_content("");
                        as2.setLast_rid(0L);
                        as2.setSend_status(0);
                        as2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            as2.setLast_content_time(chatMessage.getTime() * 1000);
                            as2.setLast_content(e.X(chatMessage.getMsgType(), chatMessage.getContent()));
                            as2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            as2.setLast_rid(chatMessage.getRecordId());
                            as2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            as2.setIsFriend(chatMessage.getIsFriend());
                            as2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                as2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            as2.setLast_content("");
                            as2.setLast_rid(0L);
                            as2.setSend_status(0);
                            as2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && as2.getLast_rid() <= chatMessage.getRecordId()) {
                            as2.setLast_content_time(chatMessage.getTime() * 1000);
                            as2.setLast_content(e.X(chatMessage.getMsgType(), chatMessage.getContent()));
                            as2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            as2.setLast_rid(chatMessage.getRecordId());
                            as2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            as2.setIsFriend(chatMessage.getIsFriend());
                            as2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                as2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        as2.setIs_hidden(0);
                        if (i == 4 && (as = as("-1000", -8)) != null) {
                            as.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + as2.getSend_status());
                a(as2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eqc.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo as = as(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (as == null) {
                h(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            am(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(as.getPulled_msgId());
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
    public void bm(String str, String str2) {
        ImMessageCenterPojo as = as(str, 1);
        if (as != null) {
            as.setGroup_head(str2);
            a(as, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bn(String str, String str2) {
        ImMessageCenterPojo as = as(str, 1);
        if (as != null) {
            as.setGroup_name(str2);
            a(as, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eqc.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo as = as(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (as == null) {
                h(imMessageCenterPojo);
                return;
            }
            as.setGroup_head(imMessageCenterPojo.getGroup_head());
            as.setGroup_name(imMessageCenterPojo.getGroup_name());
            as.setNameShow(imMessageCenterPojo.getNameShow());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.eqc.get()) {
            this.eqd.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.12
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
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
            this.eqe.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.13
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
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
            this.eqf.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.14
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
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
    public void n(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eqc.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo as = as(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (as == null) {
                h(imMessageCenterPojo);
            } else if (as.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                as.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, long j, String str) {
        if (this.eqc.get()) {
            ImMessageCenterPojo as = as(str, i);
            if (as == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                h(imMessageCenterPojo);
            } else if (as.getPulled_msgId() < j) {
                as.setPulled_msgId(j);
            }
        }
    }

    ImMessageCenterPojo d(String str, int i, boolean z) {
        ImMessageCenterPojo as = as(str, i);
        if (as != null) {
            if (z) {
                as.setIs_hidden(0);
            } else {
                as.setIs_hidden(1);
            }
        }
        return as;
    }

    public void e(String str, int i, boolean z) {
        ImMessageCenterPojo d = d(str, i, z);
        if (d != null) {
            a(d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(String str, int i) {
        ImMessageCenterPojo as = as(str, i);
        if (as != null) {
            as.setUnread_count(0);
            a(as, false);
        }
    }

    void aKu() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> aKv() {
        final LinkedList linkedList = new LinkedList();
        this.eqd.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.15
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.eqe.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.16
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.eqf.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.17
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> aKw() {
        final LinkedList linkedList = new LinkedList();
        this.eqd.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.18
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> aKx() {
        final LinkedList linkedList = new LinkedList();
        this.eqf.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.2
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> aKy() {
        final LinkedList linkedList = new LinkedList();
        this.eqe.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.3
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
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
    public List<ImMessageCenterPojo> aKz() {
        final LinkedList linkedList = new LinkedList();
        this.eqe.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.4
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
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
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016001));
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.eqc.get()) {
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
        a(hx(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo hx(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a nV = nV(-7);
        if (nV != null) {
            imMessageCenterPojo = nV.oB("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.eqe.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.5
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
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
                final ImMessageCenterPojo as = as("-1001", -7);
                if (as != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.6
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.aIb().f(as);
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
    public ImMessageCenterPojo hy(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a nV = nV(-8);
        if (nV != null) {
            imMessageCenterPojo = nV.oB("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.eqf.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.7
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
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
                        j.aIb().f(imMessageCenterPojo3);
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
        a(hy(z), z, i);
    }

    public void aKA() {
        a(hy(false), false, 1);
    }

    public void aKB() {
        a(hx(false), false, 1);
    }

    public LongSparseArray<Long> aKC() {
        final LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
        if (this.eqc.get()) {
            this.eqd.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.9
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        if (b.this.o(next)) {
                            longSparseArray.put(com.baidu.adp.lib.g.b.c(next.getGid(), 0L), Long.valueOf(com.baidu.tieba.im.util.d.cp(next.getPulled_msgId())));
                        }
                    }
                }
            });
        }
        return longSparseArray;
    }

    public NewpushRepair aKD() {
        final NewpushRepair.Builder builder = new NewpushRepair.Builder();
        final ArrayList arrayList = new ArrayList();
        if (this.eqc.get()) {
            this.eqf.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.im.memorycache.b.10
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0176a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        long c = com.baidu.adp.lib.g.b.c(next.getGid(), 0L);
                        long sid = next.getSid();
                        if (sid > 0) {
                            arrayList.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.d.cp(next.getPulled_msgId())));
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
            return TbadkCoreApplication.getInst().getCustomizedFilter().bx(imMessageCenterPojo.getCustomGroupType());
        }
        return c.nW(imMessageCenterPojo.getCustomGroupType());
    }

    public long av(String str, int i) {
        ImMessageCenterPojo as = as(str, i);
        if (as != null) {
            return as.getPulled_msgId();
        }
        return 0L;
    }

    public long aw(String str, int i) {
        ImMessageCenterPojo as = as(str, i);
        long j = 0;
        if (as != null) {
            j = as.getLast_rid() > as.getPulled_msgId() ? as.getLast_rid() : as.getPulled_msgId();
        }
        return j + 1;
    }

    private a nV(int i) {
        if (i == 2) {
            return this.eqe;
        }
        if (i == 4) {
            return this.eqf;
        }
        return this.eqd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cn(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.eqd.oC(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
