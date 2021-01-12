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
    private static volatile b kzI;
    private CustomMessage<String> kzO;
    private BdUniqueId mId;
    private final String kzH = "0";
    final AtomicBoolean kzJ = new AtomicBoolean(false);
    private final a kzK = new a();
    private final a kzL = new a();
    private final a kzM = new a();
    private final int kzN = 10;
    private CustomMessageListener kzP = new CustomMessageListener(CmdConfigCustom.MEMORY_GET_FROM_DB) { // from class: com.baidu.tieba.im.memorycache.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                com.baidu.tieba.im.push.c.cVu().clear();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (TextUtils.isEmpty(uid) || !uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                    if (data != null) {
                        for (ImMessageCenterPojo imMessageCenterPojo : data) {
                            if (imMessageCenterPojo != null && c.CL(imMessageCenterPojo.getCustomGroupType()) && imMessageCenterPojo.getPulled_msgId() > 0) {
                                b.this.f(imMessageCenterPojo);
                            }
                        }
                    }
                    b.this.kzJ.set(true);
                    b.this.cUJ();
                    return;
                }
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : memoryGetFromDBMessage.getData()) {
                        if (!b.this.m(imMessageCenterPojo2) || imMessageCenterPojo2.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo2.getCustomGroupType() == -9 && imMessageCenterPojo2.getPushIds() != null && imMessageCenterPojo2.getPushIds().length() > 0) {
                                com.baidu.tieba.im.push.c.cVu().di(imMessageCenterPojo2.getGid(), imMessageCenterPojo2.getPushIds());
                            }
                            b.this.f(imMessageCenterPojo2);
                        }
                    }
                    b.this.sK(false);
                    b.this.sL(false);
                    b.this.cUH();
                    b.this.cUI();
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                b.this.kzJ.set(true);
                b.this.cUJ();
            }
        }
    };

    private b() {
        MessageManager.getInstance().registerListener(this.kzP);
        this.kzO = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.kzO.setTag(this.mId);
    }

    public boolean isInit() {
        return this.kzJ.get();
    }

    public static b cUG() {
        if (kzI == null) {
            synchronized (b.class) {
                if (kzI == null) {
                    kzI = new b();
                }
            }
        }
        return kzI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.kzJ.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.kzO.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                n.cTP();
                LinkedList<ImMessageCenterPojo> cTH = j.cTF().cTH();
                long gL = g.cTj().gL(11L);
                long gL2 = g.cTj().gL(12L);
                if (cTH == null) {
                    cTH = new LinkedList<>();
                }
                if (gL != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    cTH.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.b.gY(gL));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (gL2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    cTH.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(com.baidu.tieba.im.util.b.gY(gL2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(cTH, data);
            }
        });
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.kzO, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUH() {
        ImMessageCenterPojo Mi;
        a CJ = CJ(-4);
        if (CJ != null && (Mi = CJ.Mi(TbEnum.CustomGroupId.GROUP_VALIDATION)) != null) {
            String last_content = Mi.getLast_content();
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
                    ImMessageCenterPojo Mi2 = this.kzK.Mi(str);
                    if (Mi2 != null) {
                        str3 = Mi2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        Mi.setLast_content(str2 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUI() {
        ImMessageCenterPojo Mi;
        a CJ = CJ(-3);
        if (CJ != null && (Mi = CJ.Mi(TbEnum.CustomGroupId.GROUP_UPDATE)) != null) {
            String last_content = Mi.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    Mi.setLast_content(new JSONObject(last_content).optString(TbEnum.SystemMessage.KEY_USER_MSG));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            CJ(imMessageCenterPojo.getCustomGroupType()).e(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo br(String str, int i) {
        a CJ;
        if (this.kzJ.get() && (CJ = CJ(i)) != null) {
            return CJ.Mi(str);
        }
        return null;
    }

    public void bs(String str, int i) {
        ImMessageCenterPojo br = br(str, i);
        if (br != null) {
            bm(str, i);
            g(br);
        }
    }

    public void bm(String str, int i) {
        a CJ;
        if (this.kzJ.get() && (CJ = CJ(i)) != null) {
            CJ.Mj(str);
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kzJ.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(sK(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(sL(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kzJ.get()) {
            ImMessageCenterPojo br = br(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (br == null) {
                f(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= br.getLast_rid()) {
                bm(br.getGid(), br.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(br.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(br.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(br.getNameShow());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                    imMessageCenterPojo.setBjhAvatar(br.getBjhAvatar());
                }
                f(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                br.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.kzJ.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo br = br(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (br == null) {
                imMessageCenterPojo.setUnread_count(i);
                f(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > br.getLast_rid()) {
                br.setLast_rid(imMessageCenterPojo.getLast_rid());
                br.setLast_content(imMessageCenterPojo.getLast_content());
                br.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                br.setUnread_count(br.getUnread_count() + i);
                br.setIs_hidden(0);
                br.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                br.setGroup_name(imMessageCenterPojo.getGroup_name());
                br.setNameShow(imMessageCenterPojo.getNameShow());
                br.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                a(br, true);
            }
        }
    }

    private void clear() {
        this.kzK.cUF();
        this.kzL.cUF();
        this.kzM.cUF();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo br;
        if (this.kzJ.get()) {
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
                ImMessageCenterPojo br2 = br(str, i);
                if (br2 == null) {
                    br2 = new ImMessageCenterPojo();
                    br2.setCustomGroupType(i);
                    br2.setGid(str);
                    f(br2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            br2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            br2.setGroup_name(userData.getUserName());
                        }
                        if (!TextUtils.isEmpty(userData.getName_show())) {
                            br2.setNameShow(userData.getName_show());
                        }
                        if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                            br2.setBjhAvatar(userData.getImBjhAvatar());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        br2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        br2.setLast_content("");
                        br2.setLast_rid(0L);
                        br2.setSend_status(0);
                        br2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            br2.setLast_content_time(chatMessage.getTime() * 1000);
                            br2.setLast_content(com.baidu.tieba.im.util.c.bz(chatMessage.getMsgType(), chatMessage.getContent()));
                            br2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            br2.setLast_rid(chatMessage.getRecordId());
                            br2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            br2.setIsFriend(chatMessage.getIsFriend());
                            br2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                br2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            br2.setLast_content("");
                            br2.setLast_rid(0L);
                            br2.setSend_status(0);
                            br2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && br2.getLast_rid() <= chatMessage.getRecordId()) {
                            br2.setLast_content_time(chatMessage.getTime() * 1000);
                            br2.setLast_content(com.baidu.tieba.im.util.c.bz(chatMessage.getMsgType(), chatMessage.getContent()));
                            br2.setLast_user_name(chatMessage.getUserInfo().getName_show());
                            br2.setLast_rid(chatMessage.getRecordId());
                            br2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            br2.setIsFriend(chatMessage.getIsFriend());
                            br2.setFollowStatus(chatMessage.getFollowStatus());
                            if (chatMessage.getLocalData() != null) {
                                br2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        br2.setIs_hidden(0);
                        if (i == 4 && (br = br(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                            br.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + br2.getSend_status());
                a(br2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kzJ.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo br = br(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (br == null) {
                f(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            bm(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(br.getPulled_msgId());
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
        ImMessageCenterPojo br = br(str, 1);
        if (br != null) {
            br.setGroup_head(str2);
            a(br, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fv(String str, String str2) {
        ImMessageCenterPojo br = br(str, 1);
        if (br != null) {
            br.setGroup_name(str2);
            a(br, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.kzJ.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo br = br(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (br == null) {
                f(imMessageCenterPojo);
                return;
            }
            br.setGroup_head(imMessageCenterPojo.getGroup_head());
            br.setGroup_name(imMessageCenterPojo.getGroup_name());
            br.setNameShow(imMessageCenterPojo.getNameShow());
            br.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.kzJ.get()) {
            this.kzK.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.12
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
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
            this.kzL.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.13
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
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
            this.kzM.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.14
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
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
        if (this.kzJ.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo br = br(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (br == null) {
                f(imMessageCenterPojo);
            } else if (br.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                br.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i, long j, String str) {
        if (this.kzJ.get()) {
            ImMessageCenterPojo br = br(str, i);
            if (br == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                f(imMessageCenterPojo);
            } else if (br.getPulled_msgId() < j) {
                br.setPulled_msgId(j);
            }
        }
    }

    ImMessageCenterPojo d(String str, int i, boolean z) {
        ImMessageCenterPojo br = br(str, i);
        if (br != null) {
            if (z) {
                br.setIs_hidden(0);
            } else {
                br.setIs_hidden(1);
            }
        }
        return br;
    }

    public void e(String str, int i, boolean z) {
        ImMessageCenterPojo d = d(str, i, z);
        if (d != null) {
            a(d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bt(String str, int i) {
        ImMessageCenterPojo br = br(str, i);
        if (br != null) {
            br.setUnread_count(0);
            a(br, false);
        }
    }

    void cUJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> cUK() {
        final LinkedList linkedList = new LinkedList();
        this.kzK.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.15
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.kzL.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.16
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        this.kzM.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.17
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> cUL() {
        final LinkedList linkedList = new LinkedList();
        this.kzK.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.18
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> cUM() {
        final LinkedList linkedList = new LinkedList();
        this.kzM.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.2
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
            public void a(Iterator<ImMessageCenterPojo> it) {
                while (it.hasNext()) {
                    linkedList.add(it.next());
                }
            }
        });
        return linkedList;
    }

    public List<ImMessageCenterPojo> cUN() {
        final LinkedList linkedList = new LinkedList();
        this.kzL.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.3
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
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
    public List<ImMessageCenterPojo> cUO() {
        final LinkedList linkedList = new LinkedList();
        this.kzL.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.4
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
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
        if (this.kzJ.get()) {
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
        a(sK(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo sK(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a CJ = CJ(-7);
        if (CJ != null) {
            imMessageCenterPojo = CJ.Mi(TbEnum.CustomGroupId.STRANGE_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
            imMessageCenterPojo.setCustomGroupType(-7);
            f(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.kzL.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.5
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
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
                final ImMessageCenterPojo br = br(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                if (br != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.b.6
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.cTF().d(br);
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
    public ImMessageCenterPojo sL(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a CJ = CJ(-8);
        if (CJ != null) {
            imMessageCenterPojo = CJ.Mi(TbEnum.CustomGroupId.OFFICIAL_MERGE);
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            imMessageCenterPojo.setCustomGroupType(-8);
            f(imMessageCenterPojo);
        }
        final ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.kzM.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.7
            @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
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
                        j.cTF().d(imMessageCenterPojo3);
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
        a(sL(z), z, i);
    }

    public void cUP() {
        a(sL(false), false, 1);
    }

    public void cUQ() {
        a(sK(false), false, 1);
    }

    public LongSparseArray<Long> cUR() {
        final LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
        if (this.kzJ.get()) {
            this.kzK.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.9
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        if (b.this.m(next)) {
                            longSparseArray.put(com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L), Long.valueOf(com.baidu.tieba.im.util.b.gZ(next.getPulled_msgId())));
                        }
                    }
                }
            });
        }
        return longSparseArray;
    }

    public NewpushRepair cUS() {
        final NewpushRepair.Builder builder = new NewpushRepair.Builder();
        final ArrayList arrayList = new ArrayList();
        if (this.kzJ.get()) {
            this.kzM.a(new a.InterfaceC0757a() { // from class: com.baidu.tieba.im.memorycache.b.10
                @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0757a
                public void a(Iterator<ImMessageCenterPojo> it) {
                    while (it.hasNext()) {
                        ImMessageCenterPojo next = it.next();
                        long j = com.baidu.adp.lib.f.b.toLong(next.getGid(), 0L);
                        long sid = next.getSid();
                        if (sid > 0) {
                            arrayList.add(MessageUtils.makeNewpushGroupRepair(j, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.b.gZ(next.getPulled_msgId())));
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
            return TbadkCoreApplication.getInst().getCustomizedFilter().mK(imMessageCenterPojo.getCustomGroupType());
        }
        return c.CK(imMessageCenterPojo.getCustomGroupType());
    }

    public long bu(String str, int i) {
        ImMessageCenterPojo br = br(str, i);
        if (br != null) {
            return br.getPulled_msgId();
        }
        return 0L;
    }

    public long bv(String str, int i) {
        ImMessageCenterPojo br = br(str, i);
        long j = 0;
        if (br != null) {
            j = br.getLast_rid() > br.getPulled_msgId() ? br.getLast_rid() : br.getPulled_msgId();
        }
        return j + 1;
    }

    private a CJ(int i) {
        if (i == 2) {
            return this.kzL;
        }
        if (i == 4) {
            return this.kzM;
        }
        return this.kzK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eC(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.kzK.Mj(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
