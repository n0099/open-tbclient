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
    private static volatile b bDB;
    private CustomMessage<String> bDG;
    private BdUniqueId mId;
    final AtomicBoolean bDC = new AtomicBoolean(false);
    private final a bDD = new a();
    private final a bDE = new a();
    private final a bDF = new a();
    private CustomMessageListener bDH = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.bDH);
        this.bDG = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.bDG.setTag(this.mId);
    }

    public boolean isInit() {
        return this.bDC.get();
    }

    public static b VS() {
        com.baidu.adp.lib.util.k.jb();
        if (bDB == null) {
            synchronized (b.class) {
                if (bDB == null) {
                    bDB = new b();
                }
            }
        }
        return bDB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.bDC.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.bDG.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new l(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.bDG, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VT() {
        ImMessageCenterPojo ie;
        a hk = hk(-4);
        if (hk != null && (ie = hk.ie("-1003")) != null) {
            String last_content = ie.getLast_content();
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
                    ImMessageCenterPojo ie2 = this.bDD.ie(str);
                    if (ie2 != null) {
                        str3 = ie2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        ie.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.h.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU() {
        ImMessageCenterPojo ie;
        a hk = hk(-3);
        if (hk != null && (ie = hk.ie("-1002")) != null) {
            String last_content = ie.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    ie.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VV() {
        ImMessageCenterPojo ie;
        a hk = hk(-5);
        if (hk != null && (ie = hk.ie("-1004")) != null) {
            String last_content = ie.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    ie.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            hk(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo J(String str, int i) {
        a hk;
        if (this.bDC.get() && (hk = hk(i)) != null) {
            return hk.ie(str);
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
        a hk;
        if (this.bDC.get() && (hk = hk(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            hk.ig(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bDC.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(dg(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(dh(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bDC.get()) {
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
        if (this.bDC.get() && imMessageCenterPojo != null) {
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
        this.bDD.VR();
        this.bDE.VR();
        this.bDF.VR();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo J;
        if (this.bDC.get()) {
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
        if (this.bDC.get() && imMessageCenterPojo != null) {
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
    public void aH(String str, String str2) {
        ImMessageCenterPojo J = J(str, 1);
        if (J != null) {
            J.setGroup_head(str2);
            a(J, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aI(String str, String str2) {
        ImMessageCenterPojo J = J(str, 1);
        if (J != null) {
            J.setGroup_name(str2);
            a(J, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bDC.get() && imMessageCenterPojo != null) {
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
        if (this.bDC.get()) {
            this.bDD.a(new m(this));
            this.bDE.a(new n(this));
            this.bDF.a(new o(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bDC.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
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
        if (this.bDC.get()) {
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
    public void VW() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> VX() {
        LinkedList linkedList = new LinkedList();
        this.bDD.a(new p(this, linkedList));
        this.bDE.a(new q(this, linkedList));
        this.bDF.a(new r(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> VY() {
        LinkedList linkedList = new LinkedList();
        this.bDD.a(new s(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> VZ() {
        LinkedList linkedList = new LinkedList();
        this.bDF.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> Wa() {
        LinkedList linkedList = new LinkedList();
        this.bDE.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Wb() {
        LinkedList linkedList = new LinkedList();
        this.bDE.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.bDC.get()) {
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
        a(dg(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo dg(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a hk = hk(-7);
        if (hk != null) {
            imMessageCenterPojo = hk.ie("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bDE.a(new g(this, imMessageCenterPojo2));
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
    public ImMessageCenterPojo dh(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a hk = hk(-8);
        if (hk != null) {
            imMessageCenterPojo = hk.ie("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bDF.a(new i(this, imMessageCenterPojo2));
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
        a(dh(z), z, i);
    }

    public SparseArray<Long> Wc() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.bDC.get()) {
            this.bDD.a(new k(this, sparseArray));
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
        return bw.hl(imMessageCenterPojo.getCustomGroupType());
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

    private a hk(int i) {
        if (i == 2) {
            return this.bDE;
        }
        if (i == 4) {
            return this.bDF;
        }
        return this.bDD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aL(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.bDD.ig(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
