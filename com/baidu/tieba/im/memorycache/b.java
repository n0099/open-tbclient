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
    private static volatile b hDq;
    private CustomMessage<String> hDw;
    private BdUniqueId mId;
    private final String hDp = "0";
    final AtomicBoolean hDr = new AtomicBoolean(false);
    private final a hDs = new a();
    private final a hDt = new a();
    private final a hDu = new a();
    private final int hDv = 10;
    private CustomMessageListener hDx = new CustomMessageListener(CmdConfigCustom.MEMORY_GET_FROM_DB) { // from class: com.baidu.tieba.im.memorycache.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                com.baidu.tieba.im.push.c.bVY().clear();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                    if (data != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo : data) {
                            if (imMessageCenterPojo != null && c.wB(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                                b.this.h(imMessageCenterPojo);
                            }
                        }
                    }
                    b.this.hDr.set(true);
                    b.this.bVi();
                    return;
                }
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                        if (!b.this.o(imMessageCenterPojo2) || imMessageCenterPojo2.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                                com.baidu.tieba.im.push.c.bVY().bF(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                            }
                            b.this.h(imMessageCenterPojo2);
                        }
                    }
                    b.this.nJ(false);
                    b.this.nK(false);
                    b.this.bVg();
                    b.this.bVh();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                b.this.hDr.set(true);
                b.this.bVi();
            }
        }
    };

    private b() {
        MessageManager.getInstance().registerListener(this.hDx);
        this.hDw = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.hDw.setTag(this.mId);
    }

    public boolean isInit() {
        return this.hDr.get();
    }

    public static b bVf() {
        if (hDq == null) {
            synchronized (b.class) {
                if (hDq == null) {
                    hDq = new b();
                }
            }
        }
        return hDq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.hDr.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.hDw.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                n.bTc();
                LinkedList<ImMessageCenterPojo> bSV = j.bST().bSV();
                long dO = g.bRg().dO(11L);
                long dO2 = g.bRg().dO(12L);
                if (bSV == null) {
                    bSV = new LinkedList<>();
                }
                if (dO != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    bSV.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(d.ec(dO));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (dO2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    bSV.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(d.ec(dO2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(bSV, data);
            }
        });
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.hDw, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVg() {
        ImMessageCenterPojo CZ;
        a wz = wz(-4);
        if (wz != null && (CZ = wz.CZ(TbEnum.CustomGroupId.GROUP_VALIDATION)) != null) {
            String last_content = CZ.getLast_content();
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
                    ImMessageCenterPojo CZ2 = this.hDs.CZ(str);
                    if (CZ2 != null) {
                        str3 = CZ2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        CZ.setLast_content(str2 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVh() {
        ImMessageCenterPojo CZ;
        a wz = wz(-3);
        if (wz != null && (CZ = wz.CZ(TbEnum.CustomGroupId.GROUP_UPDATE)) != null) {
            String last_content = CZ.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    CZ.setLast_content(new JSONObject(last_content).optString(TbEnum.SystemMessage.KEY_USER_MSG));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            wz(imMessageCenterPojo.getCustomGroupType()).g(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo aX(String str, int i) {
        a wz;
        if (this.hDr.get() && (wz = wz(i)) != null) {
            return wz.CZ(str);
        }
        return null;
    }

    public void aY(String str, int i) {
        ImMessageCenterPojo aX = aX(str, i);
        if (aX != null) {
            aR(str, i);
            i(aX);
        }
    }

    public void aR(String str, int i) {
        a wz;
        if (this.hDr.get() && (wz = wz(i)) != null) {
            wz.Da(str);
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.hDr.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(nJ(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(nK(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.hDr.get()) {
            ImMessageCenterPojo aX = aX(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aX == null) {
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= aX.getLast_rid()) {
                aR(aX.getGid(), aX.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(aX.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(aX.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(aX.getNameShow());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                    imMessageCenterPojo.setBjhAvatar(aX.getBjhAvatar());
                }
                h(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                aX.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.hDr.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo aX = aX(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aX == null) {
                imMessageCenterPojo.setUnread_count(i);
                h(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > aX.getLast_rid()) {
                aX.setLast_rid(imMessageCenterPojo.getLast_rid());
                aX.setLast_content(imMessageCenterPojo.getLast_content());
                aX.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                aX.setUnread_count(aX.getUnread_count() + i);
                aX.setIs_hidden(0);
                aX.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                aX.setGroup_name(imMessageCenterPojo.getGroup_name());
                aX.setNameShow(imMessageCenterPojo.getNameShow());
                aX.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                a(aX, true);
            }
        }
    }

    private void clear() {
        this.hDs.bVe();
        this.hDt.bVe();
        this.hDu.bVe();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo aX;
        if (this.hDr.get()) {
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
                ImMessageCenterPojo aX2 = aX(str, i);
                if (aX2 == null) {
                    aX2 = new ImMessageCenterPojo();
                    aX2.setCustomGroupType(i);
                    aX2.setGid(str);
                    h(aX2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            aX2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            aX2.setGroup_name(userData.getUserName());
                        }
                        if (!TextUtils.isEmpty(userData.getName_show())) {
                            aX2.setNameShow(userData.getName_show());
                        }
                        if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                            aX2.setBjhAvatar(userData.getImBjhAvatar());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        aX2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        aX2.setLast_content("");
                        aX2.setLast_rid(0L);
                        aX2.setSend_status(0);
                        aX2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            aX2.setLast_content_time(chatMessage.getTime() * 1000);
                            aX2.setLast_content(e.aK(chatMessage.getMsgType(), chatMessage.getContent()));
                            aX2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            aX2.setLast_rid(chatMessage.getRecordId());
                            aX2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            aX2.setIsFriend(chatMessage.getIsFriend());
                            aX2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                aX2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            aX2.setLast_content("");
                            aX2.setLast_rid(0L);
                            aX2.setSend_status(0);
                            aX2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && aX2.getLast_rid() <= chatMessage.getRecordId()) {
                            aX2.setLast_content_time(chatMessage.getTime() * 1000);
                            aX2.setLast_content(e.aK(chatMessage.getMsgType(), chatMessage.getContent()));
                            aX2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            aX2.setLast_rid(chatMessage.getRecordId());
                            aX2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            aX2.setIsFriend(chatMessage.getIsFriend());
                            aX2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                aX2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        aX2.setIs_hidden(0);
                        if (i == 4 && (aX = aX(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                            aX.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + aX2.getSend_status());
                a(aX2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.hDr.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo aX = aX(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aX == null) {
                h(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            aR(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(aX.getPulled_msgId());
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
    public void dt(String str, String str2) {
        ImMessageCenterPojo aX = aX(str, 1);
        if (aX != null) {
            aX.setGroup_head(str2);
            a(aX, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void du(String str, String str2) {
        ImMessageCenterPojo aX = aX(str, 1);
        if (aX != null) {
            aX.setGroup_name(str2);
            a(aX, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.hDr.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo aX = aX(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aX == null) {
                h(imMessageCenterPojo);
                return;
            }
            aX.setGroup_head(imMessageCenterPojo.getGroup_head());
            aX.setGroup_name(imMessageCenterPojo.getGroup_name());
            aX.setNameShow(imMessageCenterPojo.getNameShow());
            aX.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.hDr.get()) {
            this.hDs.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.12
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
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
            this.hDt.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.13
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
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
            this.hDu.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.14
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
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
        if (this.hDr.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo aX = aX(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aX == null) {
                h(imMessageCenterPojo);
            } else if (aX.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                aX.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i, long j, String str) {
        if (this.hDr.get()) {
            ImMessageCenterPojo aX = aX(str, i);
            if (aX == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                h(imMessageCenterPojo);
            } else if (aX.getPulled_msgId() < j) {
                aX.setPulled_msgId(j);
            }
        }
    }

    ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo aX = aX(str, i);
        if (aX != null) {
            if (z) {
                aX.setIs_hidden(0);
            } else {
                aX.setIs_hidden(1);
            }
        }
        return aX;
    }

    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(String str, int i) {
        ImMessageCenterPojo aX = aX(str, i);
        if (aX != null) {
            aX.setUnread_count(0);
            a(aX, false);
        }
    }

    void bVi() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> bVj() {
        final LinkedList linkedList = new LinkedList();
        this.hDs.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.15
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.hDt.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.16
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.hDu.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.17
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> bVk() {
        final LinkedList linkedList = new LinkedList();
        this.hDs.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.18
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> bVl() {
        final LinkedList linkedList = new LinkedList();
        this.hDu.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.2
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> bVm() {
        final LinkedList linkedList = new LinkedList();
        this.hDt.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.3
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
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
    public List<ImMessageCenterPojo> bVn() {
        final LinkedList linkedList = new LinkedList();
        this.hDt.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.4
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
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
        if (this.hDr.get()) {
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
        a(nJ(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo nJ(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a wz = wz(-7);
        if (wz != null) {
            imMessageCenterPojo = wz.CZ(TbEnum.CustomGroupId.STRANGE_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
            imMessageCenterPojo.setCustomGroupType(-7);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.hDt.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.5
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
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
                final ImMessageCenterPojo aX = aX(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                if (aX != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.6
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.bST().f(aX);
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
    public ImMessageCenterPojo nK(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a wz = wz(-8);
        if (wz != null) {
            imMessageCenterPojo = wz.CZ(TbEnum.CustomGroupId.OFFICIAL_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            imMessageCenterPojo.setCustomGroupType(-8);
            h(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.hDu.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.7
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
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
                        j.bST().f(imMessageCenterPojo3);
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
        a(nK(z), z, i);
    }

    public void bVo() {
        a(nK(false), false, 1);
    }

    public void bVp() {
        a(nJ(false), false, 1);
    }

    public LongSparseArray<Long> bVq() {
        final LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
        if (this.hDr.get()) {
            this.hDs.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.9
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        if (b.this.o(next)) {
                            longSparseArray.put(com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L), Long.valueOf(d.ed(next.getPulled_msgId())));
                        }
                    }
                }
            });
        }
        return longSparseArray;
    }

    public NewpushRepair bVr() {
        final NewpushRepair.Builder builder = new NewpushRepair.Builder();
        final ArrayList arrayList = new ArrayList();
        if (this.hDr.get()) {
            this.hDu.a(new a.InterfaceC0526a() { // from class: com.baidu.tieba.im.memorycache.b.10
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0526a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        long j = com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L);
                        long sid = next.getSid();
                        if (sid > 0) {
                            arrayList.add(MessageUtils.makeNewpushGroupRepair(j, next.getUserType(), sid, 0L, d.ed(next.getPulled_msgId())));
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
            return TbadkCoreApplication.getInst().getCustomizedFilter().iZ(imMessageCenterPojo.getCustomGroupType());
        }
        return c.wA(imMessageCenterPojo.getCustomGroupType());
    }

    public long ba(String str, int i) {
        ImMessageCenterPojo aX = aX(str, i);
        if (aX != null) {
            return aX.getPulled_msgId();
        }
        return 0L;
    }

    public long bb(String str, int i) {
        ImMessageCenterPojo aX = aX(str, i);
        long j = 0;
        if (aX != null) {
            j = aX.getLast_rid() > aX.getPulled_msgId() ? aX.getLast_rid() : aX.getPulled_msgId();
        }
        return j + 1;
    }

    private a wz(int i) {
        if (i == 2) {
            return this.hDt;
        }
        if (i == 4) {
            return this.hDu;
        }
        return this.hDs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void df(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.hDs.Da(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
