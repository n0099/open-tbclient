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
    private static volatile b clJ;
    private CustomMessage<String> clP;
    private BdUniqueId mId;
    private final String clI = "0";
    final AtomicBoolean clK = new AtomicBoolean(false);
    private final a clL = new a();
    private final a clM = new a();
    private final a clN = new a();
    private final int clO = 10;
    private CustomMessageListener clQ = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.clQ);
        this.clP = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.clP.setTag(this.mId);
    }

    public boolean agQ() {
        return this.clK.get();
    }

    public static b agR() {
        if (clJ == null) {
            synchronized (b.class) {
                if (clJ == null) {
                    clJ = new b();
                }
            }
        }
        return clJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.clK.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.clP.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.clP, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agS() {
        ImMessageCenterPojo jz;
        a jN = jN(-4);
        if (jN != null && (jz = jN.jz("-1003")) != null) {
            String last_content = jz.getLast_content();
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
                    ImMessageCenterPojo jz2 = this.clL.jz(str);
                    if (jz2 != null) {
                        str3 = jz2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        jz.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(t.j.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agT() {
        ImMessageCenterPojo jz;
        a jN = jN(-3);
        if (jN != null && (jz = jN.jz("-1002")) != null) {
            String last_content = jz.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    jz.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agU() {
        ImMessageCenterPojo jz;
        a jN = jN(-5);
        if (jN != null && (jz = jN.jz("-1004")) != null) {
            String last_content = jz.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    jz.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            jN(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo W(String str, int i) {
        a jN;
        if (this.clK.get() && (jN = jN(i)) != null) {
            return jN.jz(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(String str, int i) {
        ImMessageCenterPojo W = W(str, i);
        if (W != null) {
            Y(str, i);
            f(W);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(String str, int i) {
        a jN;
        if (this.clK.get() && (jN = jN(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            jN.jA(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.clK.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(eh(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(ei(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.clK.get()) {
            ImMessageCenterPojo W = W(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (W == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= W.getLast_rid()) {
                Y(W.getGid(), W.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(W.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(W.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                W.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.clK.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo W = W(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (W == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > W.getLast_rid()) {
                W.setLast_rid(imMessageCenterPojo.getLast_rid());
                W.setLast_content(imMessageCenterPojo.getLast_content());
                W.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                W.setUnread_count(W.getUnread_count() + i);
                W.setIs_hidden(0);
                W.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                W.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(W, true);
            }
        }
    }

    private void clear() {
        this.clL.agP();
        this.clM.agP();
        this.clN.agP();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo W;
        if (this.clK.get()) {
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
                ImMessageCenterPojo W2 = W(str, i);
                if (W2 == null) {
                    W2 = new ImMessageCenterPojo();
                    W2.setCustomGroupType(i);
                    W2.setGid(str);
                    e(W2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            W2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            W2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        W2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        W2.setLast_content("");
                        W2.setLast_rid(0L);
                        W2.setSend_status(0);
                        W2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            W2.setLast_content_time(chatMessage.getTime() * 1000);
                            W2.setLast_content(com.baidu.tieba.im.util.h.y(chatMessage.getMsgType(), chatMessage.getContent()));
                            W2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            W2.setLast_rid(chatMessage.getRecordId());
                            W2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            W2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                W2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            W2.setLast_content("");
                            W2.setLast_rid(0L);
                            W2.setSend_status(0);
                            W2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && W2.getLast_rid() <= chatMessage.getRecordId()) {
                            W2.setLast_content_time(chatMessage.getTime() * 1000);
                            W2.setLast_content(com.baidu.tieba.im.util.h.y(chatMessage.getMsgType(), chatMessage.getContent()));
                            W2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            W2.setLast_rid(chatMessage.getRecordId());
                            W2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            W2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                W2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        W2.setIs_hidden(0);
                        if (i == 4 && (W = W("-1000", -8)) != null) {
                            W.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + W2.getSend_status());
                a(W2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.clK.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo W = W(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (W == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            Y(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(W.getPulled_msgId());
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
    public void aY(String str, String str2) {
        ImMessageCenterPojo W = W(str, 1);
        if (W != null) {
            W.setGroup_head(str2);
            a(W, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(String str, String str2) {
        ImMessageCenterPojo W = W(str, 1);
        if (W != null) {
            W.setGroup_name(str2);
            a(W, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.clK.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo W = W(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (W == null) {
                e(imMessageCenterPojo);
                return;
            }
            W.setGroup_head(imMessageCenterPojo.getGroup_head());
            W.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.clK.get()) {
            this.clL.a(new n(this));
            this.clM.a(new o(this));
            this.clN.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.clK.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo W = W(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (W == null) {
                e(imMessageCenterPojo);
            } else if (W.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                W.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.clK.get()) {
            ImMessageCenterPojo W = W(str, i);
            if (W == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (W.getPulled_msgId() < j) {
                W.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo W = W(str, i);
        if (W != null) {
            if (z) {
                W.setIs_hidden(0);
            } else {
                W.setIs_hidden(1);
            }
        }
        return W;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(String str, int i) {
        ImMessageCenterPojo W = W(str, i);
        if (W != null) {
            W.setUnread_count(0);
            a(W, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void agV() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> agW() {
        LinkedList linkedList = new LinkedList();
        this.clL.a(new q(this, linkedList));
        this.clM.a(new r(this, linkedList));
        this.clN.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> agX() {
        LinkedList linkedList = new LinkedList();
        this.clL.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> agY() {
        LinkedList linkedList = new LinkedList();
        this.clN.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> agZ() {
        LinkedList linkedList = new LinkedList();
        this.clM.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> aha() {
        LinkedList linkedList = new LinkedList();
        this.clM.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.clK.get()) {
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
        a(eh(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo eh(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a jN = jN(-7);
        if (jN != null) {
            imMessageCenterPojo = jN.jz("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.clM.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo W = W("-1001", -7);
                if (W != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, W));
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
    public ImMessageCenterPojo ei(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a jN = jN(-8);
        if (jN != null) {
            imMessageCenterPojo = jN.jz("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.clN.a(new i(this, imMessageCenterPojo2));
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
        a(ei(z), z, i);
    }

    public SparseArray<Long> ahb() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.clK.get()) {
            this.clL.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair ahc() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.clK.get()) {
            this.clN.a(new l(this, arrayList, builder));
        }
        return builder.build(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m411getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m411getInst().getCustomizedFilter().bu(imMessageCenterPojo.getCustomGroupType());
        }
        return bz.jO(imMessageCenterPojo.getCustomGroupType());
    }

    public long aa(String str, int i) {
        ImMessageCenterPojo W = W(str, i);
        if (W != null) {
            return W.getPulled_msgId();
        }
        return 0L;
    }

    public long ab(String str, int i) {
        ImMessageCenterPojo W = W(str, i);
        long j = 0;
        if (W != null) {
            j = W.getLast_rid() > W.getPulled_msgId() ? W.getLast_rid() : W.getPulled_msgId();
        }
        return j + 1;
    }

    private a jN(int i) {
        if (i == 2) {
            return this.clM;
        }
        if (i == 4) {
            return this.clN;
        }
        return this.clL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bj(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.clL.jA(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
