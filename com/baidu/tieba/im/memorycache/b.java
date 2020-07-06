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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
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
    private static volatile b iXv;
    private CustomMessage<String> iXB;
    private BdUniqueId mId;
    private final String iXu = "0";
    final AtomicBoolean iXw = new AtomicBoolean(false);
    private final a iXx = new a();
    private final a iXy = new a();
    private final a iXz = new a();
    private final int iXA = 10;
    private CustomMessageListener iXC = new CustomMessageListener(CmdConfigCustom.MEMORY_GET_FROM_DB) { // from class: com.baidu.tieba.im.memorycache.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                com.baidu.tieba.im.push.c.csQ().clear();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                    if (data != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo : data) {
                            if (imMessageCenterPojo != null && c.yF(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                                b.this.h(imMessageCenterPojo);
                            }
                        }
                    }
                    b.this.iXw.set(true);
                    b.this.csa();
                    return;
                }
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                        if (!b.this.o(imMessageCenterPojo2) || imMessageCenterPojo2.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                                com.baidu.tieba.im.push.c.csQ().cv(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                            }
                            b.this.h(imMessageCenterPojo2);
                        }
                    }
                    b.this.pB(false);
                    b.this.pC(false);
                    b.this.crY();
                    b.this.crZ();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                b.this.iXw.set(true);
                b.this.csa();
            }
        }
    };

    private b() {
        MessageManager.getInstance().registerListener(this.iXC);
        this.iXB = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.iXB.setTag(this.mId);
    }

    public boolean isInit() {
        return this.iXw.get();
    }

    public static b crX() {
        if (iXv == null) {
            synchronized (b.class) {
                if (iXv == null) {
                    iXv = new b();
                }
            }
        }
        return iXv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.iXw.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.iXB.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                n.cpU();
                LinkedList<ImMessageCenterPojo> cpN = j.cpL().cpN();
                long eC = g.cnY().eC(11L);
                long eC2 = g.cnY().eC(12L);
                if (cpN == null) {
                    cpN = new LinkedList<>();
                }
                if (eC != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    cpN.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(d.eQ(eC));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (eC2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    cpN.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(d.eQ(eC2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(cpN, data);
            }
        });
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.iXB, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crY() {
        ImMessageCenterPojo Hm;
        a yD = yD(-4);
        if (yD != null && (Hm = yD.Hm(TbEnum.CustomGroupId.GROUP_VALIDATION)) != null) {
            String last_content = Hm.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    JSONObject jSONObject = new JSONObject(last_content);
                    JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    if (true == jSONObject.isNull("notice_id")) {
                        if (optJSONObject != null) {
                            str = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                            str2 = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                            str3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                        }
                    } else {
                        str = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                        str2 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                        str3 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                    }
                    ImMessageCenterPojo Hm2 = this.iXx.Hm(str);
                    if (Hm2 != null) {
                        str3 = Hm2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        Hm.setLast_content(str2 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crZ() {
        ImMessageCenterPojo Hm;
        a yD = yD(-3);
        if (yD != null && (Hm = yD.Hm(TbEnum.CustomGroupId.GROUP_UPDATE)) != null) {
            String last_content = Hm.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    Hm.setLast_content(new JSONObject(last_content).optString(TbEnum.SystemMessage.KEY_USER_MSG));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            yD(imMessageCenterPojo.getCustomGroupType()).g(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo bf(String str, int i) {
        a yD;
        if (this.iXw.get() && (yD = yD(i)) != null) {
            return yD.Hm(str);
        }
        return null;
    }

    public void bg(String str, int i) {
        ImMessageCenterPojo bf = bf(str, i);
        if (bf != null) {
            aZ(str, i);
            i(bf);
        }
    }

    public void aZ(String str, int i) {
        a yD;
        if (this.iXw.get() && (yD = yD(i)) != null) {
            yD.Hn(str);
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.iXw.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(pB(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(pC(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.iXw.get()) {
            ImMessageCenterPojo bf = bf(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bf == null) {
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= bf.getLast_rid()) {
                aZ(bf.getGid(), bf.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(bf.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(bf.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(bf.getNameShow());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                    imMessageCenterPojo.setBjhAvatar(bf.getBjhAvatar());
                }
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                bf.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.iXw.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo bf = bf(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bf == null) {
                imMessageCenterPojo.setUnread_count(i);
                h(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > bf.getLast_rid()) {
                bf.setLast_rid(imMessageCenterPojo.getLast_rid());
                bf.setLast_content(imMessageCenterPojo.getLast_content());
                bf.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                bf.setUnread_count(bf.getUnread_count() + i);
                bf.setIs_hidden(0);
                bf.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                bf.setGroup_name(imMessageCenterPojo.getGroup_name());
                bf.setNameShow(imMessageCenterPojo.getNameShow());
                bf.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                a(bf, true);
            }
        }
    }

    private void clear() {
        this.iXx.crW();
        this.iXy.crW();
        this.iXz.crW();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo bf;
        if (this.iXw.get()) {
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
                ImMessageCenterPojo bf2 = bf(str, i);
                if (bf2 == null) {
                    bf2 = new ImMessageCenterPojo();
                    bf2.setCustomGroupType(i);
                    bf2.setGid(str);
                    h(bf2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            bf2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            bf2.setGroup_name(userData.getUserName());
                        }
                        if (!TextUtils.isEmpty(userData.getName_show())) {
                            bf2.setNameShow(userData.getName_show());
                        }
                        if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                            bf2.setBjhAvatar(userData.getImBjhAvatar());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        bf2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        bf2.setLast_content("");
                        bf2.setLast_rid(0L);
                        bf2.setSend_status(0);
                        bf2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            bf2.setLast_content_time(chatMessage.getTime() * 1000);
                            bf2.setLast_content(e.bi(chatMessage.getMsgType(), chatMessage.getContent()));
                            bf2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            bf2.setLast_rid(chatMessage.getRecordId());
                            bf2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            bf2.setIsFriend(chatMessage.getIsFriend());
                            bf2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                bf2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            bf2.setLast_content("");
                            bf2.setLast_rid(0L);
                            bf2.setSend_status(0);
                            bf2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && bf2.getLast_rid() <= chatMessage.getRecordId()) {
                            bf2.setLast_content_time(chatMessage.getTime() * 1000);
                            bf2.setLast_content(e.bi(chatMessage.getMsgType(), chatMessage.getContent()));
                            bf2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            bf2.setLast_rid(chatMessage.getRecordId());
                            bf2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            bf2.setIsFriend(chatMessage.getIsFriend());
                            bf2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                bf2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        bf2.setIs_hidden(0);
                        if (i == 4 && (bf = bf(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                            bf.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + bf2.getSend_status());
                a(bf2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.iXw.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo bf = bf(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bf == null) {
                h(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            aZ(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(bf.getPulled_msgId());
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
    public void ew(String str, String str2) {
        ImMessageCenterPojo bf = bf(str, 1);
        if (bf != null) {
            bf.setGroup_head(str2);
            a(bf, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ex(String str, String str2) {
        ImMessageCenterPojo bf = bf(str, 1);
        if (bf != null) {
            bf.setGroup_name(str2);
            a(bf, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.iXw.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo bf = bf(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bf == null) {
                h(imMessageCenterPojo);
                return;
            }
            bf.setGroup_head(imMessageCenterPojo.getGroup_head());
            bf.setGroup_name(imMessageCenterPojo.getGroup_name());
            bf.setNameShow(imMessageCenterPojo.getNameShow());
            bf.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.iXw.get()) {
            this.iXx.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.12
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
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
            this.iXy.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.13
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
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
            this.iXz.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.14
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
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
        if (this.iXw.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo bf = bf(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bf == null) {
                h(imMessageCenterPojo);
            } else if (bf.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                bf.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i, long j, String str) {
        if (this.iXw.get()) {
            ImMessageCenterPojo bf = bf(str, i);
            if (bf == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                h(imMessageCenterPojo);
            } else if (bf.getPulled_msgId() < j) {
                bf.setPulled_msgId(j);
            }
        }
    }

    ImMessageCenterPojo d(String str, int i, boolean z) {
        ImMessageCenterPojo bf = bf(str, i);
        if (bf != null) {
            if (z) {
                bf.setIs_hidden(0);
            } else {
                bf.setIs_hidden(1);
            }
        }
        return bf;
    }

    public void e(String str, int i, boolean z) {
        ImMessageCenterPojo d = d(str, i, z);
        if (d != null) {
            a(d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bh(String str, int i) {
        ImMessageCenterPojo bf = bf(str, i);
        if (bf != null) {
            bf.setUnread_count(0);
            a(bf, false);
        }
    }

    void csa() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> csb() {
        final LinkedList linkedList = new LinkedList();
        this.iXx.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.15
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.iXy.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.16
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.iXz.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.17
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> csc() {
        final LinkedList linkedList = new LinkedList();
        this.iXx.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.18
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> csd() {
        final LinkedList linkedList = new LinkedList();
        this.iXz.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.2
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> cse() {
        final LinkedList linkedList = new LinkedList();
        this.iXy.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.3
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
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
    public List<ImMessageCenterPojo> csf() {
        final LinkedList linkedList = new LinkedList();
        this.iXy.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.4
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
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

    public void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.iXw.get()) {
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
        a(pB(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo pB(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a yD = yD(-7);
        if (yD != null) {
            imMessageCenterPojo = yD.Hm(TbEnum.CustomGroupId.STRANGE_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
            imMessageCenterPojo.setCustomGroupType(-7);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.iXy.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.5
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
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
                final ImMessageCenterPojo bf = bf(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                if (bf != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.6
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.cpL().f(bf);
                            return null;
                        }
                    });
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
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
    public ImMessageCenterPojo pC(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a yD = yD(-8);
        if (yD != null) {
            imMessageCenterPojo = yD.Hm(TbEnum.CustomGroupId.OFFICIAL_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            imMessageCenterPojo.setCustomGroupType(-8);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.iXz.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.7
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
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
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.8
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                        imMessageCenterPojo3.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                        imMessageCenterPojo3.setCustomGroupType(-8);
                        imMessageCenterPojo3.setIs_hidden(1);
                        j.cpL().f(imMessageCenterPojo3);
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
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
        a(pC(z), z, i);
    }

    public void csg() {
        a(pC(false), false, 1);
    }

    public void csh() {
        a(pB(false), false, 1);
    }

    public LongSparseArray<Long> csi() {
        final LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
        if (this.iXw.get()) {
            this.iXx.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.9
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        if (b.this.o(next)) {
                            longSparseArray.put(com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L), Long.valueOf(d.eR(next.getPulled_msgId())));
                        }
                    }
                }
            });
        }
        return longSparseArray;
    }

    public NewpushRepair csj() {
        final NewpushRepair.Builder builder = new NewpushRepair.Builder();
        final ArrayList arrayList = new ArrayList();
        if (this.iXw.get()) {
            this.iXz.a(new a.InterfaceC0655a() { // from class: com.baidu.tieba.im.memorycache.b.10
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0655a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        long j = com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L);
                        long sid = next.getSid();
                        if (sid > 0) {
                            arrayList.add(MessageUtils.makeNewpushGroupRepair(j, next.getUserType(), sid, 0L, d.eR(next.getPulled_msgId())));
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
            return TbadkCoreApplication.getInst().getCustomizedFilter().kk(imMessageCenterPojo.getCustomGroupType());
        }
        return c.yE(imMessageCenterPojo.getCustomGroupType());
    }

    public long bi(String str, int i) {
        ImMessageCenterPojo bf = bf(str, i);
        if (bf != null) {
            return bf.getPulled_msgId();
        }
        return 0L;
    }

    public long bj(String str, int i) {
        ImMessageCenterPojo bf = bf(str, i);
        long j = 0;
        if (bf != null) {
            j = bf.getLast_rid() > bf.getPulled_msgId() ? bf.getLast_rid() : bf.getPulled_msgId();
        }
        return j + 1;
    }

    private a yD(int i) {
        if (i == 2) {
            return this.iXy;
        }
        if (i == 4) {
            return this.iXz;
        }
        return this.iXx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dz(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.iXx.Hn(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
