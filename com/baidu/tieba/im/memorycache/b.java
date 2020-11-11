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
    private static volatile b kkJ;
    private CustomMessage<String> kkP;
    private BdUniqueId mId;
    private final String kkI = "0";
    final AtomicBoolean kkK = new AtomicBoolean(false);
    private final a kkL = new a();
    private final a kkM = new a();
    private final a kkN = new a();
    private final int kkO = 10;
    private CustomMessageListener kkQ = new CustomMessageListener(CmdConfigCustom.MEMORY_GET_FROM_DB) { // from class: com.baidu.tieba.im.memorycache.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                com.baidu.tieba.im.push.c.cUG().clear();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                    if (data != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo : data) {
                            if (imMessageCenterPojo != null && c.Dj(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                                b.this.f(imMessageCenterPojo);
                            }
                        }
                    }
                    b.this.kkK.set(true);
                    b.this.cTN();
                    return;
                }
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                        if (!b.this.m(imMessageCenterPojo2) || imMessageCenterPojo2.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                                com.baidu.tieba.im.push.c.cUG().de(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                            }
                            b.this.f(imMessageCenterPojo2);
                        }
                    }
                    b.this.sf(false);
                    b.this.sg(false);
                    b.this.cTL();
                    b.this.cTM();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                b.this.kkK.set(true);
                b.this.cTN();
            }
        }
    };

    private b() {
        MessageManager.getInstance().registerListener(this.kkQ);
        this.kkP = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.kkP.setTag(this.mId);
    }

    public boolean isInit() {
        return this.kkK.get();
    }

    public static b cTK() {
        if (kkJ == null) {
            synchronized (b.class) {
                if (kkJ == null) {
                    kkJ = new b();
                }
            }
        }
        return kkJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.kkK.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.kkP.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                n.cRp();
                LinkedList<ImMessageCenterPojo> cRh = j.cRf().cRh();
                long gf = g.cPt().gf(11L);
                long gf2 = g.cPt().gf(12L);
                if (cRh == null) {
                    cRh = new LinkedList<>();
                }
                if (gf != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    cRh.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(d.gt(gf));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (gf2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    cRh.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(d.gt(gf2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(cRh, data);
            }
        });
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.kkP, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTL() {
        ImMessageCenterPojo Na;
        a Dh = Dh(-4);
        if (Dh != null && (Na = Dh.Na(TbEnum.CustomGroupId.GROUP_VALIDATION)) != null) {
            String last_content = Na.getLast_content();
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
                    ImMessageCenterPojo Na2 = this.kkL.Na(str);
                    if (Na2 != null) {
                        str3 = Na2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        Na.setLast_content(str2 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTM() {
        ImMessageCenterPojo Na;
        a Dh = Dh(-3);
        if (Dh != null && (Na = Dh.Na(TbEnum.CustomGroupId.GROUP_UPDATE)) != null) {
            String last_content = Na.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    Na.setLast_content(new JSONObject(last_content).optString(TbEnum.SystemMessage.KEY_USER_MSG));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            Dh(imMessageCenterPojo.getCustomGroupType()).e(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo bl(String str, int i) {
        a Dh;
        if (this.kkK.get() && (Dh = Dh(i)) != null) {
            return Dh.Na(str);
        }
        return null;
    }

    public void bm(String str, int i) {
        ImMessageCenterPojo bl = bl(str, i);
        if (bl != null) {
            bf(str, i);
            g(bl);
        }
    }

    public void bf(String str, int i) {
        a Dh;
        if (this.kkK.get() && (Dh = Dh(i)) != null) {
            Dh.Nb(str);
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kkK.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(sf(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(sg(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kkK.get()) {
            ImMessageCenterPojo bl = bl(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bl == null) {
                f(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= bl.getLast_rid()) {
                bf(bl.getGid(), bl.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(bl.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(bl.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(bl.getNameShow());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                    imMessageCenterPojo.setBjhAvatar(bl.getBjhAvatar());
                }
                f(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                bl.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.kkK.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo bl = bl(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bl == null) {
                imMessageCenterPojo.setUnread_count(i);
                f(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > bl.getLast_rid()) {
                bl.setLast_rid(imMessageCenterPojo.getLast_rid());
                bl.setLast_content(imMessageCenterPojo.getLast_content());
                bl.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                bl.setUnread_count(bl.getUnread_count() + i);
                bl.setIs_hidden(0);
                bl.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                bl.setGroup_name(imMessageCenterPojo.getGroup_name());
                bl.setNameShow(imMessageCenterPojo.getNameShow());
                bl.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                a(bl, true);
            }
        }
    }

    private void clear() {
        this.kkL.cTJ();
        this.kkM.cTJ();
        this.kkN.cTJ();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo bl;
        if (this.kkK.get()) {
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
                ImMessageCenterPojo bl2 = bl(str, i);
                if (bl2 == null) {
                    bl2 = new ImMessageCenterPojo();
                    bl2.setCustomGroupType(i);
                    bl2.setGid(str);
                    f(bl2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            bl2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            bl2.setGroup_name(userData.getUserName());
                        }
                        if (!TextUtils.isEmpty(userData.getName_show())) {
                            bl2.setNameShow(userData.getName_show());
                        }
                        if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                            bl2.setBjhAvatar(userData.getImBjhAvatar());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        bl2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        bl2.setLast_content("");
                        bl2.setLast_rid(0L);
                        bl2.setSend_status(0);
                        bl2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            bl2.setLast_content_time(chatMessage.getTime() * 1000);
                            bl2.setLast_content(e.bA(chatMessage.getMsgType(), chatMessage.getContent()));
                            bl2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            bl2.setLast_rid(chatMessage.getRecordId());
                            bl2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            bl2.setIsFriend(chatMessage.getIsFriend());
                            bl2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                bl2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            bl2.setLast_content("");
                            bl2.setLast_rid(0L);
                            bl2.setSend_status(0);
                            bl2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && bl2.getLast_rid() <= chatMessage.getRecordId()) {
                            bl2.setLast_content_time(chatMessage.getTime() * 1000);
                            bl2.setLast_content(e.bA(chatMessage.getMsgType(), chatMessage.getContent()));
                            bl2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            bl2.setLast_rid(chatMessage.getRecordId());
                            bl2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            bl2.setIsFriend(chatMessage.getIsFriend());
                            bl2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                bl2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        bl2.setIs_hidden(0);
                        if (i == 4 && (bl = bl(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                            bl.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + bl2.getSend_status());
                a(bl2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kkK.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo bl = bl(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bl == null) {
                f(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            bf(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(bl.getPulled_msgId());
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
    public void fp(String str, String str2) {
        ImMessageCenterPojo bl = bl(str, 1);
        if (bl != null) {
            bl.setGroup_head(str2);
            a(bl, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fq(String str, String str2) {
        ImMessageCenterPojo bl = bl(str, 1);
        if (bl != null) {
            bl.setGroup_name(str2);
            a(bl, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kkK.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo bl = bl(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bl == null) {
                f(imMessageCenterPojo);
                return;
            }
            bl.setGroup_head(imMessageCenterPojo.getGroup_head());
            bl.setGroup_name(imMessageCenterPojo.getGroup_name());
            bl.setNameShow(imMessageCenterPojo.getNameShow());
            bl.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.kkK.get()) {
            this.kkL.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.12
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
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
            this.kkM.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.13
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
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
            this.kkN.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.14
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
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
        if (this.kkK.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo bl = bl(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (bl == null) {
                f(imMessageCenterPojo);
            } else if (bl.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                bl.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i, long j, String str) {
        if (this.kkK.get()) {
            ImMessageCenterPojo bl = bl(str, i);
            if (bl == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                f(imMessageCenterPojo);
            } else if (bl.getPulled_msgId() < j) {
                bl.setPulled_msgId(j);
            }
        }
    }

    ImMessageCenterPojo d(String str, int i, boolean z) {
        ImMessageCenterPojo bl = bl(str, i);
        if (bl != null) {
            if (z) {
                bl.setIs_hidden(0);
            } else {
                bl.setIs_hidden(1);
            }
        }
        return bl;
    }

    public void e(String str, int i, boolean z) {
        ImMessageCenterPojo d = d(str, i, z);
        if (d != null) {
            a(d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bn(String str, int i) {
        ImMessageCenterPojo bl = bl(str, i);
        if (bl != null) {
            bl.setUnread_count(0);
            a(bl, false);
        }
    }

    void cTN() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> cTO() {
        final LinkedList linkedList = new LinkedList();
        this.kkL.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.15
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.kkM.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.16
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.kkN.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.17
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> cTP() {
        final LinkedList linkedList = new LinkedList();
        this.kkL.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.18
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> cTQ() {
        final LinkedList linkedList = new LinkedList();
        this.kkN.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.2
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> cTR() {
        final LinkedList linkedList = new LinkedList();
        this.kkM.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.3
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
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
    public List<ImMessageCenterPojo> cTS() {
        final LinkedList linkedList = new LinkedList();
        this.kkM.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.4
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
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
        if (this.kkK.get()) {
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
        a(sf(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo sf(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a Dh = Dh(-7);
        if (Dh != null) {
            imMessageCenterPojo = Dh.Na(TbEnum.CustomGroupId.STRANGE_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
            imMessageCenterPojo.setCustomGroupType(-7);
            f(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.kkM.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.5
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
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
                final ImMessageCenterPojo bl = bl(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                if (bl != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.6
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.cRf().d(bl);
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
    public ImMessageCenterPojo sg(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a Dh = Dh(-8);
        if (Dh != null) {
            imMessageCenterPojo = Dh.Na(TbEnum.CustomGroupId.OFFICIAL_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            imMessageCenterPojo.setCustomGroupType(-8);
            f(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.kkN.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.7
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
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
                        j.cRf().d(imMessageCenterPojo3);
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
        a(sg(z), z, i);
    }

    public void cTT() {
        a(sg(false), false, 1);
    }

    public void cTU() {
        a(sf(false), false, 1);
    }

    public LongSparseArray<Long> cTV() {
        final LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
        if (this.kkK.get()) {
            this.kkL.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.9
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        if (b.this.m(next)) {
                            longSparseArray.put(com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L), Long.valueOf(d.gu(next.getPulled_msgId())));
                        }
                    }
                }
            });
        }
        return longSparseArray;
    }

    public NewpushRepair cTW() {
        final NewpushRepair.Builder builder = new NewpushRepair.Builder();
        final ArrayList arrayList = new ArrayList();
        if (this.kkK.get()) {
            this.kkN.a(new a.InterfaceC0763a() { // from class: com.baidu.tieba.im.memorycache.b.10
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0763a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        long j = com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L);
                        long sid = next.getSid();
                        if (sid > 0) {
                            arrayList.add(MessageUtils.makeNewpushGroupRepair(j, next.getUserType(), sid, 0L, d.gu(next.getPulled_msgId())));
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
            return TbadkCoreApplication.getInst().getCustomizedFilter().nM(imMessageCenterPojo.getCustomGroupType());
        }
        return c.Di(imMessageCenterPojo.getCustomGroupType());
    }

    public long bo(String str, int i) {
        ImMessageCenterPojo bl = bl(str, i);
        if (bl != null) {
            return bl.getPulled_msgId();
        }
        return 0L;
    }

    public long bp(String str, int i) {
        ImMessageCenterPojo bl = bl(str, i);
        long j = 0;
        if (bl != null) {
            j = bl.getLast_rid() > bl.getPulled_msgId() ? bl.getLast_rid() : bl.getPulled_msgId();
        }
        return j + 1;
    }

    private a Dh(int i) {
        if (i == 2) {
            return this.kkM;
        }
        if (i == 4) {
            return this.kkN;
        }
        return this.kkL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ep(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.kkL.Nb(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
