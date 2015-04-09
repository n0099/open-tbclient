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
    private static volatile c bjq;
    private CustomMessage<String> bjv;
    private BdUniqueId mId;
    final AtomicBoolean bjr = new AtomicBoolean(false);
    private final a bjs = new a();
    private final a bjt = new a();
    private final a bju = new a();
    private CustomMessageListener bjw = new d(this, 2016008);

    private c() {
        MessageManager.getInstance().registerListener(this.bjw);
        this.bjv = new CustomMessage<>(2016008, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.bjv.setTag(this.mId);
    }

    public boolean isInit() {
        return this.bjr.get();
    }

    public static c Sq() {
        com.baidu.adp.lib.util.n.iV();
        if (bjq == null) {
            synchronized (c.class) {
                if (bjq == null) {
                    bjq = new c();
                }
            }
        }
        return bjq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.bjr.set(false);
        clear();
        MessageManager.getInstance().removeMessage(2016008, this.mId);
        this.bjv.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.bjv, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sr() {
        ImMessageCenterPojo gM;
        a fZ = fZ(-4);
        if (fZ != null && (gM = fZ.gM("-1003")) != null) {
            String last_content = gM.getLast_content();
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
                    ImMessageCenterPojo gM2 = this.bjs.gM(str);
                    if (gM2 != null) {
                        str3 = gM2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        gM.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ss() {
        ImMessageCenterPojo gM;
        a fZ = fZ(-3);
        if (fZ != null && (gM = fZ.gM("-1002")) != null) {
            String last_content = gM.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    gM.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void St() {
        ImMessageCenterPojo gM;
        a fZ = fZ(-5);
        if (fZ != null && (gM = fZ.gM("-1004")) != null) {
            String last_content = gM.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    gM.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            fZ(imMessageCenterPojo.getCustomGroupType()).b(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo D(String str, int i) {
        a fZ;
        if (this.bjr.get() && (fZ = fZ(i)) != null) {
            return fZ.gM(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(String str, int i) {
        ImMessageCenterPojo D = D(str, i);
        if (D != null) {
            F(str, i);
            d(D);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(String str, int i) {
        a fZ;
        if (this.bjr.get() && (fZ = fZ(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            fZ.gN(str);
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bjr.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(cN(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(cO(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bjr.get()) {
            ImMessageCenterPojo D = D(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (D == null) {
                c(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= D.getLast_rid()) {
                F(D.getGid(), D.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(D.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(D.getGroup_name());
                }
                c(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                D.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.bjr.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo D = D(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (D == null) {
                imMessageCenterPojo.setUnread_count(i);
                c(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > D.getLast_rid()) {
                D.setLast_rid(imMessageCenterPojo.getLast_rid());
                D.setLast_content(imMessageCenterPojo.getLast_content());
                D.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                D.setUnread_count(D.getUnread_count() + i);
                D.setIs_hidden(0);
                a(D, true);
            }
        }
    }

    private void clear() {
        this.bjs.Sp();
        this.bjt.Sp();
        this.bju.Sp();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        if (this.bjr.get()) {
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
                ImMessageCenterPojo D = D(str, i);
                if (D == null) {
                    D = new ImMessageCenterPojo();
                    D.setCustomGroupType(i);
                    D.setGid(str);
                    c(D);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            D.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            D.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.c.a(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        D.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        D.setLast_content("");
                        D.setLast_rid(0L);
                        D.setSend_status(0);
                        D.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            D.setLast_content_time(chatMessage.getTime() * 1000);
                            D.setLast_content(com.baidu.tieba.im.util.i.v(chatMessage.getMsgType(), chatMessage.getContent()));
                            D.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            D.setLast_rid(chatMessage.getRecordId());
                            D.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            D.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                D.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            D.setLast_content("");
                            D.setLast_rid(0L);
                            D.setSend_status(0);
                            D.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && D.getLast_rid() <= chatMessage.getRecordId()) {
                            D.setLast_content_time(chatMessage.getTime() * 1000);
                            D.setLast_content(com.baidu.tieba.im.util.i.v(chatMessage.getMsgType(), chatMessage.getContent()));
                            D.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            D.setLast_rid(chatMessage.getRecordId());
                            D.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            D.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                D.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        D.setIs_hidden(0);
                        break;
                }
                BdLog.i("send message status " + D.getSend_status());
                a(D, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bjr.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo D = D(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (D == null) {
                c(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            F(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(D.getPulled_msgId());
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
    public void aB(String str, String str2) {
        ImMessageCenterPojo D = D(str, 1);
        if (D != null) {
            D.setGroup_head(str2);
            a(D, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aC(String str, String str2) {
        ImMessageCenterPojo D = D(str, 1);
        if (D != null) {
            D.setGroup_name(str2);
            a(D, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bjr.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo D = D(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (D == null) {
                c(imMessageCenterPojo);
                return;
            }
            D.setGroup_head(imMessageCenterPojo.getGroup_head());
            D.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.bjr.get()) {
            this.bjs.a(new n(this));
            this.bjt.a(new o(this));
            this.bju.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bjr.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo D = D(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (D == null) {
                c(imMessageCenterPojo);
            } else if (D.getPulled_msgId() <= 0) {
                D.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.bjr.get()) {
            ImMessageCenterPojo D = D(str, i);
            if (D == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                c(imMessageCenterPojo);
            } else if (D.getPulled_msgId() < j) {
                D.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo d(String str, int i, boolean z) {
        ImMessageCenterPojo D = D(str, i);
        if (D != null) {
            if (z) {
                D.setIs_hidden(0);
            } else {
                D.setIs_hidden(1);
            }
        }
        return D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, boolean z) {
        ImMessageCenterPojo d = d(str, i, z);
        if (d != null) {
            a(d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(String str, int i) {
        ImMessageCenterPojo D = D(str, i);
        if (D != null) {
            D.setUnread_count(0);
            a(D, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Su() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Sv() {
        LinkedList linkedList = new LinkedList();
        this.bjs.a(new q(this, linkedList));
        this.bjt.a(new r(this, linkedList));
        this.bju.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Sw() {
        LinkedList linkedList = new LinkedList();
        this.bjs.a(new t(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Sx() {
        LinkedList linkedList = new LinkedList();
        this.bju.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Sy() {
        LinkedList linkedList = new LinkedList();
        this.bjt.a(new f(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Sz() {
        LinkedList linkedList = new LinkedList();
        this.bjt.a(new g(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016000));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.bjr.get()) {
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
        a(cN(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo cN(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a fZ = fZ(-7);
        if (fZ != null) {
            imMessageCenterPojo = fZ.gM("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            c(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bjt.a(new h(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo D = D("-1001", -7);
                if (D != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new i(this, D));
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
    public ImMessageCenterPojo cO(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a fZ = fZ(-8);
        if (fZ != null) {
            imMessageCenterPojo = fZ.gM("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            c(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bju.a(new j(this, imMessageCenterPojo2));
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
        a(cO(z), z, i);
    }

    public SparseArray<Long> SA() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.bjr.get()) {
            this.bjs.a(new l(this, sparseArray));
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m411getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m411getInst().getCustomizedFilter().bh(imMessageCenterPojo.getCustomGroupType());
        }
        return bx.ga(imMessageCenterPojo.getCustomGroupType());
    }

    public long H(String str, int i) {
        ImMessageCenterPojo D = D(str, i);
        if (D != null) {
            return D.getPulled_msgId();
        }
        return 0L;
    }

    public long I(String str, int i) {
        ImMessageCenterPojo D = D(str, i);
        long j = 0;
        if (D != null) {
            j = D.getLast_rid() > D.getPulled_msgId() ? D.getLast_rid() : D.getPulled_msgId();
        }
        return j + 1;
    }

    private a fZ(int i) {
        if (i == 2) {
            return this.bjt;
        }
        if (i == 4) {
            return this.bju;
        }
        return this.bjs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aG(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.bjs.gN(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
