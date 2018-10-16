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
    private static volatile b eMI;
    private CustomMessage<String> eMO;
    private BdUniqueId mId;
    private final String eMH = "0";
    final AtomicBoolean eMJ = new AtomicBoolean(false);
    private final a eMK = new a();
    private final a eML = new a();
    private final a eMM = new a();
    private final int eMN = 10;
    private CustomMessageListener eMP = new CustomMessageListener(2016008) { // from class: com.baidu.tieba.im.memorycache.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                com.baidu.tieba.im.push.c.aSu().clear();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                    if (data != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo : data) {
                            if (imMessageCenterPojo != null && c.pu(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                                b.this.h(imMessageCenterPojo);
                            }
                        }
                    }
                    b.this.eMJ.set(true);
                    b.this.aRB();
                    return;
                }
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                        if (!b.this.o(imMessageCenterPojo2) || imMessageCenterPojo2.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                                com.baidu.tieba.im.push.c.aSu().bK(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                            }
                            b.this.h(imMessageCenterPojo2);
                        }
                    }
                    b.this.iA(false);
                    b.this.iB(false);
                    b.this.aRz();
                    b.this.aRA();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                b.this.eMJ.set(true);
                b.this.aRB();
            }
        }
    };

    private b() {
        MessageManager.getInstance().registerListener(this.eMP);
        this.eMO = new CustomMessage<>(2016008, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.eMO.setTag(this.mId);
    }

    public boolean qr() {
        return this.eMJ.get();
    }

    public static b aRy() {
        if (eMI == null) {
            synchronized (b.class) {
                if (eMI == null) {
                    eMI = new b();
                }
            }
        }
        return eMI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.eMJ.set(false);
        clear();
        MessageManager.getInstance().removeMessage(2016008, this.mId);
        this.eMO.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                n.aPt();
                LinkedList<ImMessageCenterPojo> aPm = j.aPk().aPm();
                long cl = g.aNx().cl(11L);
                long cl2 = g.aNx().cl(12L);
                if (aPm == null) {
                    aPm = new LinkedList<>();
                }
                if (cl != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    aPm.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(d.cA(cl));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (cl2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    aPm.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(d.cA(cl2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(aPm, data);
            }
        });
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.eMO, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRz() {
        ImMessageCenterPojo pN;
        a ps = ps(-4);
        if (ps != null && (pN = ps.pN("-1003")) != null) {
            String last_content = pN.getLast_content();
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
                    ImMessageCenterPojo pN2 = this.eMK.pN(str);
                    if (pN2 != null) {
                        str3 = pN2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        pN.setLast_content(str2 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(e.j.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRA() {
        ImMessageCenterPojo pN;
        a ps = ps(-3);
        if (ps != null && (pN = ps.pN("-1002")) != null) {
            String last_content = pN.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    pN.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            ps(imMessageCenterPojo.getCustomGroupType()).g(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo aw(String str, int i) {
        a ps;
        if (this.eMJ.get() && (ps = ps(i)) != null) {
            return ps.pN(str);
        }
        return null;
    }

    public void ax(String str, int i) {
        ImMessageCenterPojo aw = aw(str, i);
        if (aw != null) {
            aq(str, i);
            i(aw);
        }
    }

    public void aq(String str, int i) {
        a ps;
        if (this.eMJ.get() && (ps = ps(i)) != null) {
            ps.pO(str);
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eMJ.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(iA(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(iB(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eMJ.get()) {
            ImMessageCenterPojo aw = aw(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aw == null) {
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= aw.getLast_rid()) {
                aq(aw.getGid(), aw.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(aw.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(aw.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(aw.getNameShow());
                }
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                aw.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.eMJ.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo aw = aw(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aw == null) {
                imMessageCenterPojo.setUnread_count(i);
                h(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > aw.getLast_rid()) {
                aw.setLast_rid(imMessageCenterPojo.getLast_rid());
                aw.setLast_content(imMessageCenterPojo.getLast_content());
                aw.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                aw.setUnread_count(aw.getUnread_count() + i);
                aw.setIs_hidden(0);
                aw.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                aw.setGroup_name(imMessageCenterPojo.getGroup_name());
                aw.setNameShow(imMessageCenterPojo.getNameShow());
                a(aw, true);
            }
        }
    }

    private void clear() {
        this.eMK.aRx();
        this.eML.aRx();
        this.eMM.aRx();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo aw;
        if (this.eMJ.get()) {
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
                ImMessageCenterPojo aw2 = aw(str, i);
                if (aw2 == null) {
                    aw2 = new ImMessageCenterPojo();
                    aw2.setCustomGroupType(i);
                    aw2.setGid(str);
                    h(aw2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            aw2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            aw2.setGroup_name(userData.getUserName());
                        }
                        if (!TextUtils.isEmpty(userData.getName_show())) {
                            aw2.setNameShow(userData.getName_show());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        aw2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        aw2.setLast_content("");
                        aw2.setLast_rid(0L);
                        aw2.setSend_status(0);
                        aw2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            aw2.setLast_content_time(chatMessage.getTime() * 1000);
                            aw2.setLast_content(com.baidu.tieba.im.util.e.W(chatMessage.getMsgType(), chatMessage.getContent()));
                            aw2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            aw2.setLast_rid(chatMessage.getRecordId());
                            aw2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            aw2.setIsFriend(chatMessage.getIsFriend());
                            aw2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                aw2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            aw2.setLast_content("");
                            aw2.setLast_rid(0L);
                            aw2.setSend_status(0);
                            aw2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && aw2.getLast_rid() <= chatMessage.getRecordId()) {
                            aw2.setLast_content_time(chatMessage.getTime() * 1000);
                            aw2.setLast_content(com.baidu.tieba.im.util.e.W(chatMessage.getMsgType(), chatMessage.getContent()));
                            aw2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            aw2.setLast_rid(chatMessage.getRecordId());
                            aw2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            aw2.setIsFriend(chatMessage.getIsFriend());
                            aw2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                aw2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        aw2.setIs_hidden(0);
                        if (i == 4 && (aw = aw("-1000", -8)) != null) {
                            aw.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + aw2.getSend_status());
                a(aw2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eMJ.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo aw = aw(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aw == null) {
                h(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            aq(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(aw.getPulled_msgId());
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
    public void bI(String str, String str2) {
        ImMessageCenterPojo aw = aw(str, 1);
        if (aw != null) {
            aw.setGroup_head(str2);
            a(aw, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bJ(String str, String str2) {
        ImMessageCenterPojo aw = aw(str, 1);
        if (aw != null) {
            aw.setGroup_name(str2);
            a(aw, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.eMJ.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo aw = aw(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aw == null) {
                h(imMessageCenterPojo);
                return;
            }
            aw.setGroup_head(imMessageCenterPojo.getGroup_head());
            aw.setGroup_name(imMessageCenterPojo.getGroup_name());
            aw.setNameShow(imMessageCenterPojo.getNameShow());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.eMJ.get()) {
            this.eMK.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.12
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
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
            this.eML.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.13
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
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
            this.eMM.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.14
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
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
        if (this.eMJ.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo aw = aw(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aw == null) {
                h(imMessageCenterPojo);
            } else if (aw.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                aw.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, long j, String str) {
        if (this.eMJ.get()) {
            ImMessageCenterPojo aw = aw(str, i);
            if (aw == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                h(imMessageCenterPojo);
            } else if (aw.getPulled_msgId() < j) {
                aw.setPulled_msgId(j);
            }
        }
    }

    ImMessageCenterPojo d(String str, int i, boolean z) {
        ImMessageCenterPojo aw = aw(str, i);
        if (aw != null) {
            if (z) {
                aw.setIs_hidden(0);
            } else {
                aw.setIs_hidden(1);
            }
        }
        return aw;
    }

    public void e(String str, int i, boolean z) {
        ImMessageCenterPojo d = d(str, i, z);
        if (d != null) {
            a(d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(String str, int i) {
        ImMessageCenterPojo aw = aw(str, i);
        if (aw != null) {
            aw.setUnread_count(0);
            a(aw, false);
        }
    }

    void aRB() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> aRC() {
        final LinkedList linkedList = new LinkedList();
        this.eMK.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.15
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.eML.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.16
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.eMM.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.17
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> aRD() {
        final LinkedList linkedList = new LinkedList();
        this.eMK.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.18
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> aRE() {
        final LinkedList linkedList = new LinkedList();
        this.eMM.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.2
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
            public void b(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> aRF() {
        final LinkedList linkedList = new LinkedList();
        this.eML.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.3
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
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
    public List<ImMessageCenterPojo> aRG() {
        final LinkedList linkedList = new LinkedList();
        this.eML.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.4
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
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
        if (this.eMJ.get()) {
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
        a(iA(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo iA(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a ps = ps(-7);
        if (ps != null) {
            imMessageCenterPojo = ps.pN("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.eML.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.5
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
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
                final ImMessageCenterPojo aw = aw("-1001", -7);
                if (aw != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.6
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.aPk().f(aw);
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
    public ImMessageCenterPojo iB(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a ps = ps(-8);
        if (ps != null) {
            imMessageCenterPojo = ps.pN("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.eMM.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.7
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
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
                        j.aPk().f(imMessageCenterPojo3);
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
        a(iB(z), z, i);
    }

    public void aRH() {
        a(iB(false), false, 1);
    }

    public void aRI() {
        a(iA(false), false, 1);
    }

    public LongSparseArray<Long> aRJ() {
        final LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
        if (this.eMJ.get()) {
            this.eMK.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.9
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
                public void b(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        if (b.this.o(next)) {
                            longSparseArray.put(com.baidu.adp.lib.g.b.d(next.getGid(), 0L), Long.valueOf(d.cB(next.getPulled_msgId())));
                        }
                    }
                }
            });
        }
        return longSparseArray;
    }

    public NewpushRepair aRK() {
        final NewpushRepair.Builder builder = new NewpushRepair.Builder();
        final ArrayList arrayList = new ArrayList();
        if (this.eMJ.get()) {
            this.eMM.a(new a.InterfaceC0213a() { // from class: com.baidu.tieba.im.memorycache.b.10
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0213a
                public void b(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        long d = com.baidu.adp.lib.g.b.d(next.getGid(), 0L);
                        long sid = next.getSid();
                        if (sid > 0) {
                            arrayList.add(MessageUtils.makeNewpushGroupRepair(d, next.getUserType(), sid, 0L, d.cB(next.getPulled_msgId())));
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
            return TbadkCoreApplication.getInst().getCustomizedFilter().bT(imMessageCenterPojo.getCustomGroupType());
        }
        return c.pt(imMessageCenterPojo.getCustomGroupType());
    }

    public long az(String str, int i) {
        ImMessageCenterPojo aw = aw(str, i);
        if (aw != null) {
            return aw.getPulled_msgId();
        }
        return 0L;
    }

    public long aA(String str, int i) {
        ImMessageCenterPojo aw = aw(str, i);
        long j = 0;
        if (aw != null) {
            j = aw.getLast_rid() > aw.getPulled_msgId() ? aw.getLast_rid() : aw.getPulled_msgId();
        }
        return j + 1;
    }

    private a ps(int i) {
        if (i == 2) {
            return this.eML;
        }
        if (i == 4) {
            return this.eMM;
        }
        return this.eMK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cH(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.eMK.pO(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
