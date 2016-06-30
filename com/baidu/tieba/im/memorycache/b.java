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
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static volatile b cRW;
    private CustomMessage<String> cSc;
    private BdUniqueId mId;
    private final String cRV = "0";
    final AtomicBoolean cRX = new AtomicBoolean(false);
    private final a cRY = new a();
    private final a cRZ = new a();
    private final a cSa = new a();
    private final int cSb = 10;
    private CustomMessageListener cSd = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.cSd);
        this.cSc = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.cSc.setTag(this.mId);
    }

    public boolean apm() {
        return this.cRX.get();
    }

    public static b apn() {
        if (cRW == null) {
            synchronized (b.class) {
                if (cRW == null) {
                    cRW = new b();
                }
            }
        }
        return cRW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.cRX.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.cSc.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.cSc, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apo() {
        ImMessageCenterPojo kV;
        a kT = kT(-4);
        if (kT != null && (kV = kT.kV("-1003")) != null) {
            String last_content = kV.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    JSONObject jSONObject = new JSONObject(last_content);
                    JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    if (jSONObject.isNull("notice_id")) {
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
                    ImMessageCenterPojo kV2 = this.cRY.kV(str);
                    if (kV2 != null) {
                        str3 = kV2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        kV.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(u.j.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void app() {
        ImMessageCenterPojo kV;
        a kT = kT(-3);
        if (kT != null && (kV = kT.kV("-1002")) != null) {
            String last_content = kV.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    kV.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apq() {
        ImMessageCenterPojo kV;
        a kT = kT(-5);
        if (kT != null && (kV = kT.kV("-1004")) != null) {
            String last_content = kV.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    kV.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            kT(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo ah(String str, int i) {
        a kT;
        if (this.cRX.get() && (kT = kT(i)) != null) {
            return kT.kV(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(String str, int i) {
        ImMessageCenterPojo ah = ah(str, i);
        if (ah != null) {
            aj(str, i);
            f(ah);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(String str, int i) {
        a kT;
        if (this.cRX.get() && (kT = kT(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            kT.kW(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cRX.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(fx(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(fy(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cRX.get()) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= ah.getLast_rid()) {
                aj(ah.getGid(), ah.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(ah.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(ah.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                ah.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.cRX.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > ah.getLast_rid()) {
                ah.setLast_rid(imMessageCenterPojo.getLast_rid());
                ah.setLast_content(imMessageCenterPojo.getLast_content());
                ah.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                ah.setUnread_count(ah.getUnread_count() + i);
                ah.setIs_hidden(0);
                ah.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                ah.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(ah, true);
            }
        }
    }

    private void clear() {
        this.cRY.apl();
        this.cRZ.apl();
        this.cSa.apl();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo ah;
        if (this.cRX.get()) {
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
                ImMessageCenterPojo ah2 = ah(str, i);
                if (ah2 == null) {
                    ah2 = new ImMessageCenterPojo();
                    ah2.setCustomGroupType(i);
                    ah2.setGid(str);
                    e(ah2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            ah2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            ah2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        ah2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        ah2.setLast_content("");
                        ah2.setLast_rid(0L);
                        ah2.setSend_status(0);
                        ah2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            ah2.setLast_content_time(chatMessage.getTime() * 1000);
                            ah2.setLast_content(com.baidu.tieba.im.util.h.B(chatMessage.getMsgType(), chatMessage.getContent()));
                            ah2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            ah2.setLast_rid(chatMessage.getRecordId());
                            ah2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            ah2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                ah2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            ah2.setLast_content("");
                            ah2.setLast_rid(0L);
                            ah2.setSend_status(0);
                            ah2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && ah2.getLast_rid() <= chatMessage.getRecordId()) {
                            ah2.setLast_content_time(chatMessage.getTime() * 1000);
                            ah2.setLast_content(com.baidu.tieba.im.util.h.B(chatMessage.getMsgType(), chatMessage.getContent()));
                            ah2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            ah2.setLast_rid(chatMessage.getRecordId());
                            ah2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            ah2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                ah2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        ah2.setIs_hidden(0);
                        if (i == 4 && (ah = ah("-1000", -8)) != null) {
                            ah.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + ah2.getSend_status());
                a(ah2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cRX.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            aj(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(ah.getPulled_msgId());
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
    public void bc(String str, String str2) {
        ImMessageCenterPojo ah = ah(str, 1);
        if (ah != null) {
            ah.setGroup_head(str2);
            a(ah, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bd(String str, String str2) {
        ImMessageCenterPojo ah = ah(str, 1);
        if (ah != null) {
            ah.setGroup_name(str2);
            a(ah, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cRX.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                e(imMessageCenterPojo);
                return;
            }
            ah.setGroup_head(imMessageCenterPojo.getGroup_head());
            ah.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cRX.get()) {
            this.cRY.a(new n(this));
            this.cRZ.a(new o(this));
            this.cSa.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cRX.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                e(imMessageCenterPojo);
            } else if (ah.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                ah.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.cRX.get()) {
            ImMessageCenterPojo ah = ah(str, i);
            if (ah == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (ah.getPulled_msgId() < j) {
                ah.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo f(String str, int i, boolean z) {
        ImMessageCenterPojo ah = ah(str, i);
        if (ah != null) {
            if (z) {
                ah.setIs_hidden(0);
            } else {
                ah.setIs_hidden(1);
            }
        }
        return ah;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, int i, boolean z) {
        ImMessageCenterPojo f = f(str, i, z);
        if (f != null) {
            a(f, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ak(String str, int i) {
        ImMessageCenterPojo ah = ah(str, i);
        if (ah != null) {
            ah.setUnread_count(0);
            a(ah, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void apr() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> aps() {
        LinkedList linkedList = new LinkedList();
        this.cRY.a(new q(this, linkedList));
        this.cRZ.a(new r(this, linkedList));
        this.cSa.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> apt() {
        LinkedList linkedList = new LinkedList();
        this.cRY.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> apu() {
        LinkedList linkedList = new LinkedList();
        this.cSa.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> apv() {
        LinkedList linkedList = new LinkedList();
        this.cRZ.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> apw() {
        LinkedList linkedList = new LinkedList();
        this.cRZ.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.cRX.get()) {
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
        a(fx(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo fx(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a kT = kT(-7);
        if (kT != null) {
            imMessageCenterPojo = kT.kV("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cRZ.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo ah = ah("-1001", -7);
                if (ah != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, ah));
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
    public ImMessageCenterPojo fy(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a kT = kT(-8);
        if (kT != null) {
            imMessageCenterPojo = kT.kV("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cSa.a(new i(this, imMessageCenterPojo2));
        imMessageCenterPojo.setUserType(imMessageCenterPojo2.getUserType());
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new j(this));
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
        a(fy(z), z, i);
    }

    public SparseArray<Long> apx() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.cRX.get()) {
            this.cRY.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair apy() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.cRX.get()) {
            this.cSa.a(new l(this, arrayList, builder));
        }
        return builder.build(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m9getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m9getInst().getCustomizedFilter().bj(imMessageCenterPojo.getCustomGroupType());
        }
        return bz.kU(imMessageCenterPojo.getCustomGroupType());
    }

    public long al(String str, int i) {
        ImMessageCenterPojo ah = ah(str, i);
        if (ah != null) {
            return ah.getPulled_msgId();
        }
        return 0L;
    }

    public long am(String str, int i) {
        ImMessageCenterPojo ah = ah(str, i);
        long j = 0;
        if (ah != null) {
            j = ah.getLast_rid() > ah.getPulled_msgId() ? ah.getLast_rid() : ah.getPulled_msgId();
        }
        return j + 1;
    }

    private a kT(int i) {
        if (i == 2) {
            return this.cRZ;
        }
        if (i == 4) {
            return this.cSa;
        }
        return this.cRY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bJ(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.cRY.kW(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
