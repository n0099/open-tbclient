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
import com.baidu.tieba.i;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static volatile b bzH;
    private CustomMessage<String> bzM;
    private BdUniqueId mId;
    final AtomicBoolean bzI = new AtomicBoolean(false);
    private final a bzJ = new a();
    private final a bzK = new a();
    private final a bzL = new a();
    private CustomMessageListener bzN = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.bzN);
        this.bzM = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.bzM.setTag(this.mId);
    }

    public boolean isInit() {
        return this.bzI.get();
    }

    public static b Vl() {
        com.baidu.adp.lib.util.k.jd();
        if (bzH == null) {
            synchronized (b.class) {
                if (bzH == null) {
                    bzH = new b();
                }
            }
        }
        return bzH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.bzI.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.bzM.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new l(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.bzM, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vm() {
        ImMessageCenterPojo hR;
        a gU = gU(-4);
        if (gU != null && (hR = gU.hR("-1003")) != null) {
            String last_content = hR.getLast_content();
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
                    ImMessageCenterPojo hR2 = this.bzJ.hR(str);
                    if (hR2 != null) {
                        str3 = hR2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        hR.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.C0057i.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vn() {
        ImMessageCenterPojo hR;
        a gU = gU(-3);
        if (gU != null && (hR = gU.hR("-1002")) != null) {
            String last_content = hR.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    hR.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo() {
        ImMessageCenterPojo hR;
        a gU = gU(-5);
        if (gU != null && (hR = gU.hR("-1004")) != null) {
            String last_content = hR.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    hR.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            gU(imMessageCenterPojo.getCustomGroupType()).b(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo G(String str, int i) {
        a gU;
        if (this.bzI.get() && (gU = gU(i)) != null) {
            return gU.hR(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str, int i) {
        ImMessageCenterPojo G = G(str, i);
        if (G != null) {
            I(str, i);
            d(G);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(String str, int i) {
        a gU;
        if (this.bzI.get() && (gU = gU(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            gU.hS(str);
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bzI.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(db(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(dc(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bzI.get()) {
            ImMessageCenterPojo G = G(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (G == null) {
                c(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= G.getLast_rid()) {
                I(G.getGid(), G.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(G.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(G.getGroup_name());
                }
                c(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                G.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.bzI.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo G = G(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (G == null) {
                imMessageCenterPojo.setUnread_count(i);
                c(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > G.getLast_rid()) {
                G.setLast_rid(imMessageCenterPojo.getLast_rid());
                G.setLast_content(imMessageCenterPojo.getLast_content());
                G.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                G.setUnread_count(G.getUnread_count() + i);
                G.setIs_hidden(0);
                G.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                G.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(G, true);
            }
        }
    }

    private void clear() {
        this.bzJ.Vk();
        this.bzK.Vk();
        this.bzL.Vk();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        if (this.bzI.get()) {
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
                ImMessageCenterPojo G = G(str, i);
                if (G == null) {
                    G = new ImMessageCenterPojo();
                    G.setCustomGroupType(i);
                    G.setGid(str);
                    c(G);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            G.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            G.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        G.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        G.setLast_content("");
                        G.setLast_rid(0L);
                        G.setSend_status(0);
                        G.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            G.setLast_content_time(chatMessage.getTime() * 1000);
                            G.setLast_content(com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent()));
                            G.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            G.setLast_rid(chatMessage.getRecordId());
                            G.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            G.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                G.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            G.setLast_content("");
                            G.setLast_rid(0L);
                            G.setSend_status(0);
                            G.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && G.getLast_rid() <= chatMessage.getRecordId()) {
                            G.setLast_content_time(chatMessage.getTime() * 1000);
                            G.setLast_content(com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent()));
                            G.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            G.setLast_rid(chatMessage.getRecordId());
                            G.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            G.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                G.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        G.setIs_hidden(0);
                        break;
                }
                BdLog.i("send message status " + G.getSend_status());
                a(G, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bzI.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo G = G(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (G == null) {
                c(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            I(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(G.getPulled_msgId());
            c(imMessageCenterPojo);
            return imMessageCenterPojo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        a(f(imMessageCenterPojo), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aG(String str, String str2) {
        ImMessageCenterPojo G = G(str, 1);
        if (G != null) {
            G.setGroup_head(str2);
            a(G, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aH(String str, String str2) {
        ImMessageCenterPojo G = G(str, 1);
        if (G != null) {
            G.setGroup_name(str2);
            a(G, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bzI.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo G = G(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (G == null) {
                c(imMessageCenterPojo);
                return;
            }
            G.setGroup_head(imMessageCenterPojo.getGroup_head());
            G.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.bzI.get()) {
            this.bzJ.a(new m(this));
            this.bzK.a(new n(this));
            this.bzL.a(new o(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bzI.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo G = G(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (G == null) {
                c(imMessageCenterPojo);
            } else if (G.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                G.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.bzI.get()) {
            ImMessageCenterPojo G = G(str, i);
            if (G == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                c(imMessageCenterPojo);
            } else if (G.getPulled_msgId() < j) {
                G.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo G = G(str, i);
        if (G != null) {
            if (z) {
                G.setIs_hidden(0);
            } else {
                G.setIs_hidden(1);
            }
        }
        return G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(String str, int i) {
        ImMessageCenterPojo G = G(str, i);
        if (G != null) {
            G.setUnread_count(0);
            a(G, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Vp() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Vq() {
        LinkedList linkedList = new LinkedList();
        this.bzJ.a(new p(this, linkedList));
        this.bzK.a(new q(this, linkedList));
        this.bzL.a(new r(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Vr() {
        LinkedList linkedList = new LinkedList();
        this.bzJ.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Vs() {
        LinkedList linkedList = new LinkedList();
        this.bzL.a(new d(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Vt() {
        LinkedList linkedList = new LinkedList();
        this.bzK.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Vu() {
        LinkedList linkedList = new LinkedList();
        this.bzK.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.bzI.get()) {
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
        a(db(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo db(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a gU = gU(-7);
        if (gU != null) {
            imMessageCenterPojo = gU.hR("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            c(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bzK.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo G = G("-1001", -7);
                if (G != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, G));
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
    public ImMessageCenterPojo dc(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a gU = gU(-8);
        if (gU != null) {
            imMessageCenterPojo = gU.hR("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            c(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bzL.a(new i(this, imMessageCenterPojo2));
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
        a(dc(z), z, i);
    }

    public SparseArray<Long> Vv() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.bzI.get()) {
            this.bzJ.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m411getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m411getInst().getCustomizedFilter().bn(imMessageCenterPojo.getCustomGroupType());
        }
        return by.gV(imMessageCenterPojo.getCustomGroupType());
    }

    public long K(String str, int i) {
        ImMessageCenterPojo G = G(str, i);
        if (G != null) {
            return G.getPulled_msgId();
        }
        return 0L;
    }

    public long L(String str, int i) {
        ImMessageCenterPojo G = G(str, i);
        long j = 0;
        if (G != null) {
            j = G.getLast_rid() > G.getPulled_msgId() ? G.getLast_rid() : G.getPulled_msgId();
        }
        return j + 1;
    }

    private a gU(int i) {
        if (i == 2) {
            return this.bzK;
        }
        if (i == 4) {
            return this.bzL;
        }
        return this.bzJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aI(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.bzJ.hS(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
