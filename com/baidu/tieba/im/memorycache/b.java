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
    private static volatile b bDW;
    private CustomMessage<String> bEb;
    private BdUniqueId mId;
    final AtomicBoolean bDX = new AtomicBoolean(false);
    private final a bDY = new a();
    private final a bDZ = new a();
    private final a bEa = new a();
    private CustomMessageListener bEc = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.bEc);
        this.bEb = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.bEb.setTag(this.mId);
    }

    public boolean isInit() {
        return this.bDX.get();
    }

    public static b Wn() {
        com.baidu.adp.lib.util.k.jc();
        if (bDW == null) {
            synchronized (b.class) {
                if (bDW == null) {
                    bDW = new b();
                }
            }
        }
        return bDW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.bDX.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.bEb.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new l(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.bEb, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wo() {
        ImMessageCenterPojo ih;
        a hx = hx(-4);
        if (hx != null && (ih = hx.ih("-1003")) != null) {
            String last_content = ih.getLast_content();
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
                    ImMessageCenterPojo ih2 = this.bDY.ih(str);
                    if (ih2 != null) {
                        str3 = ih2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        ih.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.h.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wp() {
        ImMessageCenterPojo ih;
        a hx = hx(-3);
        if (hx != null && (ih = hx.ih("-1002")) != null) {
            String last_content = ih.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    ih.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wq() {
        ImMessageCenterPojo ih;
        a hx = hx(-5);
        if (hx != null && (ih = hx.ih("-1004")) != null) {
            String last_content = ih.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    ih.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            hx(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo J(String str, int i) {
        a hx;
        if (this.bDX.get() && (hx = hx(i)) != null) {
            return hx.ih(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(String str, int i) {
        ImMessageCenterPojo J = J(str, i);
        if (J != null) {
            L(str, i);
            f(J);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(String str, int i) {
        a hx;
        if (this.bDX.get() && (hx = hx(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            hx.ii(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bDX.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(di(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(dj(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bDX.get()) {
            ImMessageCenterPojo J = J(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (J == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= J.getLast_rid()) {
                L(J.getGid(), J.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(J.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(J.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                J.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.bDX.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo J = J(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (J == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > J.getLast_rid()) {
                J.setLast_rid(imMessageCenterPojo.getLast_rid());
                J.setLast_content(imMessageCenterPojo.getLast_content());
                J.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                J.setUnread_count(J.getUnread_count() + i);
                J.setIs_hidden(0);
                J.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                J.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(J, true);
            }
        }
    }

    private void clear() {
        this.bDY.Wm();
        this.bDZ.Wm();
        this.bEa.Wm();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo J;
        if (this.bDX.get()) {
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
                ImMessageCenterPojo J2 = J(str, i);
                if (J2 == null) {
                    J2 = new ImMessageCenterPojo();
                    J2.setCustomGroupType(i);
                    J2.setGid(str);
                    e(J2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            J2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            J2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        J2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        J2.setLast_content("");
                        J2.setLast_rid(0L);
                        J2.setSend_status(0);
                        J2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            J2.setLast_content_time(chatMessage.getTime() * 1000);
                            J2.setLast_content(com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent()));
                            J2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            J2.setLast_rid(chatMessage.getRecordId());
                            J2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            J2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                J2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            J2.setLast_content("");
                            J2.setLast_rid(0L);
                            J2.setSend_status(0);
                            J2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && J2.getLast_rid() <= chatMessage.getRecordId()) {
                            J2.setLast_content_time(chatMessage.getTime() * 1000);
                            J2.setLast_content(com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent()));
                            J2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            J2.setLast_rid(chatMessage.getRecordId());
                            J2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            J2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                J2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        J2.setIs_hidden(0);
                        if (i == 4 && (J = J("-1000", -8)) != null) {
                            J.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + J2.getSend_status());
                a(J2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bDX.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo J = J(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (J == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            L(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(J.getPulled_msgId());
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
    public void aG(String str, String str2) {
        ImMessageCenterPojo J = J(str, 1);
        if (J != null) {
            J.setGroup_head(str2);
            a(J, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aH(String str, String str2) {
        ImMessageCenterPojo J = J(str, 1);
        if (J != null) {
            J.setGroup_name(str2);
            a(J, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bDX.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo J = J(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (J == null) {
                e(imMessageCenterPojo);
                return;
            }
            J.setGroup_head(imMessageCenterPojo.getGroup_head());
            J.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.bDX.get()) {
            this.bDY.a(new m(this));
            this.bDZ.a(new n(this));
            this.bEa.a(new o(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bDX.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo J = J(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (J == null) {
                e(imMessageCenterPojo);
            } else if (J.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                J.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.bDX.get()) {
            ImMessageCenterPojo J = J(str, i);
            if (J == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (J.getPulled_msgId() < j) {
                J.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo J = J(str, i);
        if (J != null) {
            if (z) {
                J.setIs_hidden(0);
            } else {
                J.setIs_hidden(1);
            }
        }
        return J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(String str, int i) {
        ImMessageCenterPojo J = J(str, i);
        if (J != null) {
            J.setUnread_count(0);
            a(J, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wr() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Ws() {
        LinkedList linkedList = new LinkedList();
        this.bDY.a(new p(this, linkedList));
        this.bDZ.a(new q(this, linkedList));
        this.bEa.a(new r(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Wt() {
        LinkedList linkedList = new LinkedList();
        this.bDY.a(new s(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> Wu() {
        LinkedList linkedList = new LinkedList();
        this.bEa.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> Wv() {
        LinkedList linkedList = new LinkedList();
        this.bDZ.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Ww() {
        LinkedList linkedList = new LinkedList();
        this.bDZ.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.bDX.get()) {
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
        a(di(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo di(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a hx = hx(-7);
        if (hx != null) {
            imMessageCenterPojo = hx.ih("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bDZ.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo J = J("-1001", -7);
                if (J != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, J));
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
    public ImMessageCenterPojo dj(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a hx = hx(-8);
        if (hx != null) {
            imMessageCenterPojo = hx.ih("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bEa.a(new i(this, imMessageCenterPojo2));
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
        a(dj(z), z, i);
    }

    public SparseArray<Long> Wx() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.bDX.get()) {
            this.bDY.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m411getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m411getInst().getCustomizedFilter().bn(imMessageCenterPojo.getCustomGroupType());
        }
        return bw.hy(imMessageCenterPojo.getCustomGroupType());
    }

    public long N(String str, int i) {
        ImMessageCenterPojo J = J(str, i);
        if (J != null) {
            return J.getPulled_msgId();
        }
        return 0L;
    }

    public long O(String str, int i) {
        ImMessageCenterPojo J = J(str, i);
        long j = 0;
        if (J != null) {
            j = J.getLast_rid() > J.getPulled_msgId() ? J.getLast_rid() : J.getPulled_msgId();
        }
        return j + 1;
    }

    private a hx(int i) {
        if (i == 2) {
            return this.bDZ;
        }
        if (i == 4) {
            return this.bEa;
        }
        return this.bDY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aP(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.bDY.ii(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
