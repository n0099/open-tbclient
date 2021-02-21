package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import androidx.collection.LongSparseArray;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static volatile b kIb;
    private CustomMessage<String> kIh;
    private BdUniqueId mId;
    private final String kIa = "0";
    final AtomicBoolean kIc = new AtomicBoolean(false);
    private final a kId = new a();
    private final a kIe = new a();
    private final a kIf = new a();
    private final int kIg = 10;
    private CustomMessageListener kIi = new CustomMessageListener(CmdConfigCustom.MEMORY_GET_FROM_DB) { // from class: com.baidu.tieba.im.memorycache.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                com.baidu.tieba.im.push.c.cXz().clear();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                    if (data != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo : data) {
                            if (imMessageCenterPojo != null && c.Dc(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                                b.this.f(imMessageCenterPojo);
                            }
                        }
                    }
                    b.this.kIc.set(true);
                    b.this.cWO();
                    return;
                }
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                        if (!b.this.m(imMessageCenterPojo2) || imMessageCenterPojo2.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                                com.baidu.tieba.im.push.c.cXz().dc(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                            }
                            b.this.f(imMessageCenterPojo2);
                        }
                    }
                    b.this.sX(false);
                    b.this.sY(false);
                    b.this.cWM();
                    b.this.cWN();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                b.this.kIc.set(true);
                b.this.cWO();
            }
        }
    };

    private b() {
        MessageManager.getInstance().registerListener(this.kIi);
        this.kIh = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.kIh.setTag(this.mId);
    }

    public boolean isInit() {
        return this.kIc.get();
    }

    public static b cWL() {
        if (kIb == null) {
            synchronized (b.class) {
                if (kIb == null) {
                    kIb = new b();
                }
            }
        }
        return kIb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.kIc.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.kIh.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                n.cVU();
                LinkedList<ImMessageCenterPojo> cVM = j.cVK().cVM();
                long gQ = g.cVo().gQ(11L);
                long gQ2 = g.cVo().gQ(12L);
                if (cVM == null) {
                    cVM = new LinkedList<>();
                }
                if (gQ != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    cVM.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.b.hd(gQ));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (gQ2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    cVM.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.b.hd(gQ2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(cVM, data);
            }
        });
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.kIh, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWM() {
        ImMessageCenterPojo MY;
        a Da = Da(-4);
        if (Da != null && (MY = Da.MY(TbEnum.CustomGroupId.GROUP_VALIDATION)) != null) {
            String last_content = MY.getLast_content();
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
                    ImMessageCenterPojo MY2 = this.kId.MY(str);
                    if (MY2 != null) {
                        str3 = MY2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        MY.setLast_content(str2 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWN() {
        ImMessageCenterPojo MY;
        a Da = Da(-3);
        if (Da != null && (MY = Da.MY(TbEnum.CustomGroupId.GROUP_UPDATE)) != null) {
            String last_content = MY.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    MY.setLast_content(new JSONObject(last_content).optString(TbEnum.SystemMessage.KEY_USER_MSG));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            Da(imMessageCenterPojo.getCustomGroupType()).e(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo bs(String str, int i) {
        a Da;
        if (this.kIc.get() && (Da = Da(i)) != null) {
            return Da.MY(str);
        }
        return null;
    }

    public void bt(String str, int i) {
        ImMessageCenterPojo bs = bs(str, i);
        if (bs != null) {
            bn(str, i);
            g(bs);
        }
    }

    public void bn(String str, int i) {
        a Da;
        if (this.kIc.get() && (Da = Da(i)) != null) {
            Da.MZ(str);
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kIc.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(sX(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(sY(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kIc.get()) {
            ImMessageCenterPojo bs = bs(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bs == null) {
                f(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= bs.getLast_rid()) {
                bn(bs.getGid(), bs.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(bs.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(bs.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(bs.getNameShow());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                    imMessageCenterPojo.setBjhAvatar(bs.getBjhAvatar());
                }
                f(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                bs.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.kIc.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo bs = bs(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bs == null) {
                imMessageCenterPojo.setUnread_count(i);
                f(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > bs.getLast_rid()) {
                bs.setLast_rid(imMessageCenterPojo.getLast_rid());
                bs.setLast_content(imMessageCenterPojo.getLast_content());
                bs.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                bs.setUnread_count(bs.getUnread_count() + i);
                bs.setIs_hidden(0);
                bs.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                bs.setGroup_name(imMessageCenterPojo.getGroup_name());
                bs.setNameShow(imMessageCenterPojo.getNameShow());
                bs.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                a(bs, true);
            }
        }
    }

    private void clear() {
        this.kId.cWK();
        this.kIe.cWK();
        this.kIf.cWK();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo bs;
        if (this.kIc.get()) {
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
                ImMessageCenterPojo bs2 = bs(str, i);
                if (bs2 == null) {
                    bs2 = new ImMessageCenterPojo();
                    bs2.setCustomGroupType(i);
                    bs2.setGid(str);
                    f(bs2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            bs2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            bs2.setGroup_name(userData.getUserName());
                        }
                        if (!TextUtils.isEmpty(userData.getName_show())) {
                            bs2.setNameShow(userData.getName_show());
                        }
                        if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                            bs2.setBjhAvatar(userData.getImBjhAvatar());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        bs2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        bs2.setLast_content("");
                        bs2.setLast_rid(0L);
                        bs2.setSend_status(0);
                        bs2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            bs2.setLast_content_time(chatMessage.getTime() * 1000);
                            bs2.setLast_content(com.baidu.tieba.im.util.c.bF(chatMessage.getMsgType(), chatMessage.getContent()));
                            bs2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            bs2.setLast_rid(chatMessage.getRecordId());
                            bs2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            bs2.setIsFriend(chatMessage.getIsFriend());
                            bs2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                bs2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            bs2.setLast_content("");
                            bs2.setLast_rid(0L);
                            bs2.setSend_status(0);
                            bs2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && bs2.getLast_rid() <= chatMessage.getRecordId()) {
                            bs2.setLast_content_time(chatMessage.getTime() * 1000);
                            bs2.setLast_content(com.baidu.tieba.im.util.c.bF(chatMessage.getMsgType(), chatMessage.getContent()));
                            bs2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            bs2.setLast_rid(chatMessage.getRecordId());
                            bs2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            bs2.setIsFriend(chatMessage.getIsFriend());
                            bs2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                bs2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        bs2.setIs_hidden(0);
                        if (i == 4 && (bs = bs(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                            bs.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + bs2.getSend_status());
                a(bs2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kIc.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo bs = bs(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bs == null) {
                f(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            bn(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(bs.getPulled_msgId());
            f(imMessageCenterPojo);
            return imMessageCenterPojo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        a(i(imMessageCenterPojo), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fu(String str, String str2) {
        ImMessageCenterPojo bs = bs(str, 1);
        if (bs != null) {
            bs.setGroup_head(str2);
            a(bs, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fv(String str, String str2) {
        ImMessageCenterPojo bs = bs(str, 1);
        if (bs != null) {
            bs.setGroup_name(str2);
            a(bs, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kIc.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo bs = bs(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bs == null) {
                f(imMessageCenterPojo);
                return;
            }
            bs.setGroup_head(imMessageCenterPojo.getGroup_head());
            bs.setGroup_name(imMessageCenterPojo.getGroup_name());
            bs.setNameShow(imMessageCenterPojo.getNameShow());
            bs.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.kIc.get()) {
            this.kId.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.12
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
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
            this.kIe.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.13
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
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
            this.kIf.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.14
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
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
    public void l(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kIc.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo bs = bs(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bs == null) {
                f(imMessageCenterPojo);
            } else if (bs.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                bs.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i, long j, String str) {
        if (this.kIc.get()) {
            ImMessageCenterPojo bs = bs(str, i);
            if (bs == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                f(imMessageCenterPojo);
            } else if (bs.getPulled_msgId() < j) {
                bs.setPulled_msgId(j);
            }
        }
    }

    ImMessageCenterPojo d(String str, int i, boolean z) {
        ImMessageCenterPojo bs = bs(str, i);
        if (bs != null) {
            if (z) {
                bs.setIs_hidden(0);
            } else {
                bs.setIs_hidden(1);
            }
        }
        return bs;
    }

    public void e(String str, int i, boolean z) {
        ImMessageCenterPojo d = d(str, i, z);
        if (d != null) {
            a(d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bu(String str, int i) {
        ImMessageCenterPojo bs = bs(str, i);
        if (bs != null) {
            bs.setUnread_count(0);
            a(bs, false);
        }
    }

    void cWO() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> cWP() {
        final LinkedList linkedList = new LinkedList();
        this.kId.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.15
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.kIe.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.16
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.kIf.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.17
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> cWQ() {
        final LinkedList linkedList = new LinkedList();
        this.kId.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.18
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> cWR() {
        final LinkedList linkedList = new LinkedList();
        this.kIf.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.2
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> cWS() {
        final LinkedList linkedList = new LinkedList();
        this.kIe.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.3
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
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
    public List<ImMessageCenterPojo> cWT() {
        final LinkedList linkedList = new LinkedList();
        this.kIe.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.4
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
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
        if (this.kIc.get()) {
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
        a(sX(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo sX(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a Da = Da(-7);
        if (Da != null) {
            imMessageCenterPojo = Da.MY(TbEnum.CustomGroupId.STRANGE_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
            imMessageCenterPojo.setCustomGroupType(-7);
            f(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.kIe.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.5
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
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
                final ImMessageCenterPojo bs = bs(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                if (bs != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.6
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.cVK().d(bs);
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
    public ImMessageCenterPojo sY(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a Da = Da(-8);
        if (Da != null) {
            imMessageCenterPojo = Da.MY(TbEnum.CustomGroupId.OFFICIAL_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            imMessageCenterPojo.setCustomGroupType(-8);
            f(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.kIf.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.7
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
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
                        j.cVK().d(imMessageCenterPojo3);
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
        a(sY(z), z, i);
    }

    public void cWU() {
        a(sY(false), false, 1);
    }

    public void cWV() {
        a(sX(false), false, 1);
    }

    public LongSparseArray<Long> cWW() {
        final LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
        if (this.kIc.get()) {
            this.kId.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.9
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        if (b.this.m(next)) {
                            longSparseArray.put(com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L), Long.valueOf(com.baidu.tieba.im.util.b.he(next.getPulled_msgId())));
                        }
                    }
                }
            });
        }
        return longSparseArray;
    }

    public NewpushRepair cWX() {
        final NewpushRepair.Builder builder = new NewpushRepair.Builder();
        final ArrayList arrayList = new ArrayList();
        if (this.kIc.get()) {
            this.kIf.a(new a.InterfaceC0760a() { // from class: com.baidu.tieba.im.memorycache.b.10
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0760a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        long j = com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L);
                        long sid = next.getSid();
                        if (sid > 0) {
                            arrayList.add(MessageUtils.makeNewpushGroupRepair(j, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.b.he(next.getPulled_msgId())));
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
    public boolean m(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.getInst().getCustomizedFilter().mN(imMessageCenterPojo.getCustomGroupType());
        }
        return c.Db(imMessageCenterPojo.getCustomGroupType());
    }

    public long bv(String str, int i) {
        ImMessageCenterPojo bs = bs(str, i);
        if (bs != null) {
            return bs.getPulled_msgId();
        }
        return 0L;
    }

    public long bw(String str, int i) {
        ImMessageCenterPojo bs = bs(str, i);
        long j = 0;
        if (bs != null) {
            j = bs.getLast_rid() > bs.getPulled_msgId() ? bs.getLast_rid() : bs.getPulled_msgId();
        }
        return j + 1;
    }

    private a Da(int i) {
        if (i == 2) {
            return this.kIe;
        }
        if (i == 4) {
            return this.kIf;
        }
        return this.kId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eA(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.kId.MZ(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
