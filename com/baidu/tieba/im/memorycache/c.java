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
import com.baidu.tbadk.util.ChatStatusManager;
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
public class c {
    private static volatile c bgt;
    private CustomMessage<String> bgy;
    private BdUniqueId mId;
    final AtomicBoolean bgu = new AtomicBoolean(false);
    private final a bgv = new a();
    private final a bgw = new a();
    private final a bgx = new a();
    private CustomMessageListener bgz = new d(this, 2016008);

    private c() {
        MessageManager.getInstance().registerListener(this.bgz);
        this.bgy = new CustomMessage<>(2016008, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.bgy.setTag(this.mId);
    }

    public boolean isInit() {
        return this.bgu.get();
    }

    public static c Qs() {
        com.baidu.adp.lib.util.l.ft();
        if (bgt == null) {
            synchronized (c.class) {
                if (bgt == null) {
                    bgt = new c();
                }
            }
        }
        return bgt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.bgu.set(false);
        clear();
        MessageManager.getInstance().removeMessage(2016008, this.mId);
        this.bgy.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.bgy, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qt() {
        ImMessageCenterPojo gR;
        a gd = gd(-4);
        if (gd != null && (gR = gd.gR("-1003")) != null) {
            String last_content = gR.getLast_content();
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
                    ImMessageCenterPojo gR2 = this.bgv.gR(str);
                    if (gR2 != null) {
                        str3 = gR2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        gR.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m255getInst().getApp().getApplicationContext().getString(com.baidu.tieba.z.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qu() {
        ImMessageCenterPojo gR;
        a gd = gd(-3);
        if (gd != null && (gR = gd.gR("-1002")) != null) {
            String last_content = gR.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    gR.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qv() {
        ImMessageCenterPojo gR;
        a gd = gd(-5);
        if (gd != null && (gR = gd.gR("-1004")) != null) {
            String last_content = gR.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    gR.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            gd(imMessageCenterPojo.getCustomGroupType()).i(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo H(String str, int i) {
        a gd;
        if (this.bgu.get() && (gd = gd(i)) != null) {
            return gd.gR(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(String str, int i) {
        ImMessageCenterPojo H = H(str, i);
        if (H != null) {
            J(str, i);
            k(H);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(String str, int i) {
        a gd;
        if (this.bgu.get() && (gd = gd(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            gd.gS(str);
        }
    }

    private void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bgu.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(cW(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(cX(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bgu.get()) {
            ImMessageCenterPojo H = H(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (H == null) {
                j(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= H.getLast_rid()) {
                J(H.getGid(), H.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(H.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(H.getGroup_name());
                }
                j(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                H.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.bgu.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo H = H(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (H == null) {
                imMessageCenterPojo.setUnread_count(i);
                j(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > H.getLast_rid()) {
                H.setLast_rid(imMessageCenterPojo.getLast_rid());
                H.setLast_content(imMessageCenterPojo.getLast_content());
                H.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                H.setUnread_count(H.getUnread_count() + i);
                H.setIs_hidden(0);
                a(H, true);
            }
        }
    }

    private void clear() {
        this.bgv.Qr();
        this.bgw.Qr();
        this.bgx.Qr();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        if (this.bgu.get()) {
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
                ImMessageCenterPojo H = H(str, i);
                if (H == null) {
                    H = new ImMessageCenterPojo();
                    H.setCustomGroupType(i);
                    H.setGid(str);
                    j(H);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            H.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            H.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.c.a(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        H.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        H.setLast_content("");
                        H.setLast_rid(0L);
                        H.setSend_status(0);
                        H.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            H.setLast_content_time(chatMessage.getTime() * 1000);
                            H.setLast_content(com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent()));
                            H.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            H.setLast_rid(chatMessage.getRecordId());
                            H.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            H.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                H.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            H.setLast_content("");
                            H.setLast_rid(0L);
                            H.setSend_status(0);
                            H.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && H.getLast_rid() <= chatMessage.getRecordId()) {
                            H.setLast_content_time(chatMessage.getTime() * 1000);
                            H.setLast_content(com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent()));
                            H.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            H.setLast_rid(chatMessage.getRecordId());
                            H.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            H.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                H.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        H.setIs_hidden(0);
                        break;
                }
                BdLog.i("send message status " + H.getSend_status());
                a(H, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo m(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bgu.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo H = H(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (H == null) {
                j(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            J(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(H.getPulled_msgId());
            j(imMessageCenterPojo);
            return imMessageCenterPojo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(ImMessageCenterPojo imMessageCenterPojo) {
        a(m(imMessageCenterPojo), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(String str, String str2) {
        ImMessageCenterPojo H = H(str, 1);
        if (H != null) {
            H.setGroup_head(str2);
            a(H, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void az(String str, String str2) {
        ImMessageCenterPojo H = H(str, 1);
        if (H != null) {
            H.setGroup_name(str2);
            a(H, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bgu.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo H = H(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (H == null) {
                j(imMessageCenterPojo);
                return;
            }
            H.setGroup_head(imMessageCenterPojo.getGroup_head());
            H.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.bgu.get()) {
            this.bgv.a(new n(this));
            this.bgw.a(new o(this));
            this.bgx.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bgu.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo H = H(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (H == null) {
                j(imMessageCenterPojo);
            } else if (H.getPulled_msgId() <= 0) {
                H.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.bgu.get()) {
            ImMessageCenterPojo H = H(str, i);
            if (H == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                j(imMessageCenterPojo);
            } else if (H.getPulled_msgId() < j) {
                H.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo H = H(str, i);
        if (H != null) {
            if (z) {
                H.setIs_hidden(0);
            } else {
                H.setIs_hidden(1);
            }
        }
        return H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(String str, int i) {
        ImMessageCenterPojo H = H(str, i);
        if (H != null) {
            H.setUnread_count(0);
            a(H, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Qw() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Qx() {
        LinkedList linkedList = new LinkedList();
        this.bgv.a(new q(this, linkedList));
        this.bgw.a(new r(this, linkedList));
        this.bgx.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Qy() {
        LinkedList linkedList = new LinkedList();
        this.bgv.a(new t(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Qz() {
        LinkedList linkedList = new LinkedList();
        this.bgx.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> QA() {
        LinkedList linkedList = new LinkedList();
        this.bgw.a(new f(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> QB() {
        LinkedList linkedList = new LinkedList();
        this.bgw.a(new g(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016000));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.bgu.get()) {
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
        a(cW(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo cW(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a gd = gd(-7);
        if (gd != null) {
            imMessageCenterPojo = gd.gR("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            j(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bgw.a(new h(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo H = H("-1001", -7);
                if (H != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new i(this, H));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
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
    public ImMessageCenterPojo cX(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a gd = gd(-8);
        if (gd != null) {
            imMessageCenterPojo = gd.gR("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            j(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bgx.a(new j(this, imMessageCenterPojo2));
        imMessageCenterPojo.setUserType(imMessageCenterPojo2.getUserType());
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new k(this));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
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
        a(cX(z), z, i);
    }

    public SparseArray<Long> QC() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.bgu.get()) {
            this.bgv.a(new l(this, sparseArray));
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        return imMessageCenterPojo.getCustomGroupType() == 1 || imMessageCenterPojo.getCustomGroupType() == 9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == 3 || imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == 8 || imMessageCenterPojo.getCustomGroupType() == 7 || imMessageCenterPojo.getCustomGroupType() == 6;
    }

    public long L(String str, int i) {
        ImMessageCenterPojo H = H(str, i);
        if (H != null) {
            return H.getPulled_msgId();
        }
        return 0L;
    }

    public long M(String str, int i) {
        ImMessageCenterPojo H = H(str, i);
        long j = 0;
        if (H != null) {
            j = H.getLast_rid() > H.getPulled_msgId() ? H.getLast_rid() : H.getPulled_msgId();
        }
        return j + 1;
    }

    private a gd(int i) {
        if (i == 2) {
            return this.bgw;
        }
        if (i == 4) {
            return this.bgx;
        }
        return this.bgv;
    }
}
