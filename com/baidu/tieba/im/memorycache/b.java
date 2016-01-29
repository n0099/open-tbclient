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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static volatile b cbf;
    private CustomMessage<String> cbl;
    private BdUniqueId mId;
    private final String cbe = "0";
    final AtomicBoolean cbg = new AtomicBoolean(false);
    private final a cbh = new a();
    private final a cbi = new a();
    private final a cbj = new a();
    private final int cbk = 10;
    private CustomMessageListener cbm = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.cbm);
        this.cbl = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.cbl.setTag(this.mId);
    }

    public boolean adx() {
        return this.cbg.get();
    }

    public static b ady() {
        if (cbf == null) {
            synchronized (b.class) {
                if (cbf == null) {
                    cbf = new b();
                }
            }
        }
        return cbf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.cbg.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.cbl.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.cbl, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adz() {
        ImMessageCenterPojo iQ;
        a jh = jh(-4);
        if (jh != null && (iQ = jh.iQ("-1003")) != null) {
            String last_content = iQ.getLast_content();
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
                    ImMessageCenterPojo iQ2 = this.cbh.iQ(str);
                    if (iQ2 != null) {
                        str3 = iQ2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        iQ.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(t.j.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adA() {
        ImMessageCenterPojo iQ;
        a jh = jh(-3);
        if (jh != null && (iQ = jh.iQ("-1002")) != null) {
            String last_content = iQ.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    iQ.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adB() {
        ImMessageCenterPojo iQ;
        a jh = jh(-5);
        if (jh != null && (iQ = jh.iQ("-1004")) != null) {
            String last_content = iQ.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    iQ.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            jh(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo P(String str, int i) {
        a jh;
        if (this.cbg.get() && (jh = jh(i)) != null) {
            return jh.iQ(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(String str, int i) {
        ImMessageCenterPojo P = P(str, i);
        if (P != null) {
            R(str, i);
            f(P);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(String str, int i) {
        a jh;
        if (this.cbg.get() && (jh = jh(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            jh.iR(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cbg.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(dL(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(dM(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cbg.get()) {
            ImMessageCenterPojo P = P(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (P == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= P.getLast_rid()) {
                R(P.getGid(), P.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(P.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(P.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                P.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.cbg.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo P = P(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (P == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > P.getLast_rid()) {
                P.setLast_rid(imMessageCenterPojo.getLast_rid());
                P.setLast_content(imMessageCenterPojo.getLast_content());
                P.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                P.setUnread_count(P.getUnread_count() + i);
                P.setIs_hidden(0);
                P.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                P.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(P, true);
            }
        }
    }

    private void clear() {
        this.cbh.adw();
        this.cbi.adw();
        this.cbj.adw();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo P;
        if (this.cbg.get()) {
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
                ImMessageCenterPojo P2 = P(str, i);
                if (P2 == null) {
                    P2 = new ImMessageCenterPojo();
                    P2.setCustomGroupType(i);
                    P2.setGid(str);
                    e(P2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            P2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            P2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        P2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        P2.setLast_content("");
                        P2.setLast_rid(0L);
                        P2.setSend_status(0);
                        P2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            P2.setLast_content_time(chatMessage.getTime() * 1000);
                            P2.setLast_content(com.baidu.tieba.im.util.h.G(chatMessage.getMsgType(), chatMessage.getContent()));
                            P2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            P2.setLast_rid(chatMessage.getRecordId());
                            P2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            P2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                P2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            P2.setLast_content("");
                            P2.setLast_rid(0L);
                            P2.setSend_status(0);
                            P2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && P2.getLast_rid() <= chatMessage.getRecordId()) {
                            P2.setLast_content_time(chatMessage.getTime() * 1000);
                            P2.setLast_content(com.baidu.tieba.im.util.h.G(chatMessage.getMsgType(), chatMessage.getContent()));
                            P2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            P2.setLast_rid(chatMessage.getRecordId());
                            P2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            P2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                P2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        P2.setIs_hidden(0);
                        if (i == 4 && (P = P("-1000", -8)) != null) {
                            P.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + P2.getSend_status());
                a(P2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cbg.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo P = P(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (P == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            R(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(P.getPulled_msgId());
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
    public void aL(String str, String str2) {
        ImMessageCenterPojo P = P(str, 1);
        if (P != null) {
            P.setGroup_head(str2);
            a(P, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aM(String str, String str2) {
        ImMessageCenterPojo P = P(str, 1);
        if (P != null) {
            P.setGroup_name(str2);
            a(P, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cbg.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo P = P(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (P == null) {
                e(imMessageCenterPojo);
                return;
            }
            P.setGroup_head(imMessageCenterPojo.getGroup_head());
            P.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cbg.get()) {
            this.cbh.a(new n(this));
            this.cbi.a(new o(this));
            this.cbj.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cbg.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo P = P(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (P == null) {
                e(imMessageCenterPojo);
            } else if (P.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                P.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.cbg.get()) {
            ImMessageCenterPojo P = P(str, i);
            if (P == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (P.getPulled_msgId() < j) {
                P.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo P = P(str, i);
        if (P != null) {
            if (z) {
                P.setIs_hidden(0);
            } else {
                P.setIs_hidden(1);
            }
        }
        return P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(String str, int i) {
        ImMessageCenterPojo P = P(str, i);
        if (P != null) {
            P.setUnread_count(0);
            a(P, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adC() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> adD() {
        LinkedList linkedList = new LinkedList();
        this.cbh.a(new q(this, linkedList));
        this.cbi.a(new r(this, linkedList));
        this.cbj.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> adE() {
        LinkedList linkedList = new LinkedList();
        this.cbh.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> adF() {
        LinkedList linkedList = new LinkedList();
        this.cbj.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> adG() {
        LinkedList linkedList = new LinkedList();
        this.cbi.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> adH() {
        LinkedList linkedList = new LinkedList();
        this.cbi.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.cbg.get()) {
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
        a(dL(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo dL(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a jh = jh(-7);
        if (jh != null) {
            imMessageCenterPojo = jh.iQ("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cbi.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo P = P("-1001", -7);
                if (P != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, P));
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
    public ImMessageCenterPojo dM(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a jh = jh(-8);
        if (jh != null) {
            imMessageCenterPojo = jh.iQ("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cbj.a(new i(this, imMessageCenterPojo2));
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
        a(dM(z), z, i);
    }

    public SparseArray<Long> adI() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.cbg.get()) {
            this.cbh.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair adJ() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.cbg.get()) {
            this.cbj.a(new l(this, arrayList, builder));
        }
        return builder.build(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m411getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m411getInst().getCustomizedFilter().bv(imMessageCenterPojo.getCustomGroupType());
        }
        return bz.ji(imMessageCenterPojo.getCustomGroupType());
    }

    public long T(String str, int i) {
        ImMessageCenterPojo P = P(str, i);
        if (P != null) {
            return P.getPulled_msgId();
        }
        return 0L;
    }

    public long U(String str, int i) {
        ImMessageCenterPojo P = P(str, i);
        long j = 0;
        if (P != null) {
            j = P.getLast_rid() > P.getPulled_msgId() ? P.getLast_rid() : P.getPulled_msgId();
        }
        return j + 1;
    }

    private a jh(int i) {
        if (i == 2) {
            return this.cbi;
        }
        if (i == 4) {
            return this.cbj;
        }
        return this.cbh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aY(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.cbh.iR(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
