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
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static volatile b daA;
    private CustomMessage<String> daG;
    private BdUniqueId mId;
    private final String daz = "0";
    final AtomicBoolean daB = new AtomicBoolean(false);
    private final a daC = new a();
    private final a daD = new a();
    private final a daE = new a();
    private final int daF = 10;
    private CustomMessageListener daH = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.daH);
        this.daG = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.daG.setTag(this.mId);
    }

    public boolean asb() {
        return this.daB.get();
    }

    public static b asc() {
        if (daA == null) {
            synchronized (b.class) {
                if (daA == null) {
                    daA = new b();
                }
            }
        }
        return daA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.daB.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.daG.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.daG, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asd() {
        ImMessageCenterPojo kI;
        a lG = lG(-4);
        if (lG != null && (kI = lG.kI("-1003")) != null) {
            String last_content = kI.getLast_content();
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
                    ImMessageCenterPojo kI2 = this.daC.kI(str);
                    if (kI2 != null) {
                        str3 = kI2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        kI.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(w.l.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ase() {
        ImMessageCenterPojo kI;
        a lG = lG(-3);
        if (lG != null && (kI = lG.kI("-1002")) != null) {
            String last_content = kI.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    kI.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asf() {
        ImMessageCenterPojo kI;
        a lG = lG(-5);
        if (lG != null && (kI = lG.kI("-1004")) != null) {
            String last_content = kI.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    kI.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            lG(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Y(String str, int i) {
        a lG;
        if (this.daB.get() && (lG = lG(i)) != null) {
            return lG.kI(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(String str, int i) {
        ImMessageCenterPojo Y = Y(str, i);
        if (Y != null) {
            aa(str, i);
            f(Y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(String str, int i) {
        a lG;
        if (this.daB.get() && (lG = lG(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            lG.kJ(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.daB.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(fX(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(fY(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.daB.get()) {
            ImMessageCenterPojo Y = Y(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Y == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= Y.getLast_rid()) {
                aa(Y.getGid(), Y.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(Y.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(Y.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                Y.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.daB.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo Y = Y(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Y == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > Y.getLast_rid()) {
                Y.setLast_rid(imMessageCenterPojo.getLast_rid());
                Y.setLast_content(imMessageCenterPojo.getLast_content());
                Y.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                Y.setUnread_count(Y.getUnread_count() + i);
                Y.setIs_hidden(0);
                Y.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                Y.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(Y, true);
            }
        }
    }

    private void clear() {
        this.daC.asa();
        this.daD.asa();
        this.daE.asa();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo Y;
        if (this.daB.get()) {
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
                ImMessageCenterPojo Y2 = Y(str, i);
                if (Y2 == null) {
                    Y2 = new ImMessageCenterPojo();
                    Y2.setCustomGroupType(i);
                    Y2.setGid(str);
                    e(Y2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            Y2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            Y2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        Y2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        Y2.setLast_content("");
                        Y2.setLast_rid(0L);
                        Y2.setSend_status(0);
                        Y2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            Y2.setLast_content_time(chatMessage.getTime() * 1000);
                            Y2.setLast_content(com.baidu.tieba.im.util.h.C(chatMessage.getMsgType(), chatMessage.getContent()));
                            Y2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            Y2.setLast_rid(chatMessage.getRecordId());
                            Y2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            Y2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                Y2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            Y2.setLast_content("");
                            Y2.setLast_rid(0L);
                            Y2.setSend_status(0);
                            Y2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && Y2.getLast_rid() <= chatMessage.getRecordId()) {
                            Y2.setLast_content_time(chatMessage.getTime() * 1000);
                            Y2.setLast_content(com.baidu.tieba.im.util.h.C(chatMessage.getMsgType(), chatMessage.getContent()));
                            Y2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            Y2.setLast_rid(chatMessage.getRecordId());
                            Y2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            Y2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                Y2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        Y2.setIs_hidden(0);
                        if (i == 4 && (Y = Y("-1000", -8)) != null) {
                            Y.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + Y2.getSend_status());
                a(Y2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.daB.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo Y = Y(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Y == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            aa(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(Y.getPulled_msgId());
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
    public void bd(String str, String str2) {
        ImMessageCenterPojo Y = Y(str, 1);
        if (Y != null) {
            Y.setGroup_head(str2);
            a(Y, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void be(String str, String str2) {
        ImMessageCenterPojo Y = Y(str, 1);
        if (Y != null) {
            Y.setGroup_name(str2);
            a(Y, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.daB.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo Y = Y(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Y == null) {
                e(imMessageCenterPojo);
                return;
            }
            Y.setGroup_head(imMessageCenterPojo.getGroup_head());
            Y.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.daB.get()) {
            this.daC.a(new n(this));
            this.daD.a(new o(this));
            this.daE.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.daB.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo Y = Y(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Y == null) {
                e(imMessageCenterPojo);
            } else if (Y.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                Y.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.daB.get()) {
            ImMessageCenterPojo Y = Y(str, i);
            if (Y == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (Y.getPulled_msgId() < j) {
                Y.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo Y = Y(str, i);
        if (Y != null) {
            if (z) {
                Y.setIs_hidden(0);
            } else {
                Y.setIs_hidden(1);
            }
        }
        return Y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(String str, int i) {
        ImMessageCenterPojo Y = Y(str, i);
        if (Y != null) {
            Y.setUnread_count(0);
            a(Y, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asg() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> ash() {
        LinkedList linkedList = new LinkedList();
        this.daC.a(new q(this, linkedList));
        this.daD.a(new r(this, linkedList));
        this.daE.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> asi() {
        LinkedList linkedList = new LinkedList();
        this.daC.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> asj() {
        LinkedList linkedList = new LinkedList();
        this.daE.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> ask() {
        LinkedList linkedList = new LinkedList();
        this.daD.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> asl() {
        LinkedList linkedList = new LinkedList();
        this.daD.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.daB.get()) {
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
        a(fX(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo fX(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lG = lG(-7);
        if (lG != null) {
            imMessageCenterPojo = lG.kI("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.daD.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo Y = Y("-1001", -7);
                if (Y != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, Y));
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
    public ImMessageCenterPojo fY(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lG = lG(-8);
        if (lG != null) {
            imMessageCenterPojo = lG.kI("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.daE.a(new i(this, imMessageCenterPojo2));
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
        a(fY(z), z, i);
    }

    public SparseArray<Long> asm() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.daB.get()) {
            this.daC.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair asn() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.daB.get()) {
            this.daE.a(new l(this, arrayList, builder));
        }
        return builder.build(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m9getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m9getInst().getCustomizedFilter().bw(imMessageCenterPojo.getCustomGroupType());
        }
        return bz.lH(imMessageCenterPojo.getCustomGroupType());
    }

    public long ac(String str, int i) {
        ImMessageCenterPojo Y = Y(str, i);
        if (Y != null) {
            return Y.getPulled_msgId();
        }
        return 0L;
    }

    public long ad(String str, int i) {
        ImMessageCenterPojo Y = Y(str, i);
        long j = 0;
        if (Y != null) {
            j = Y.getLast_rid() > Y.getPulled_msgId() ? Y.getLast_rid() : Y.getPulled_msgId();
        }
        return j + 1;
    }

    private a lG(int i) {
        if (i == 2) {
            return this.daD;
        }
        if (i == 4) {
            return this.daE;
        }
        return this.daC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bx(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.daC.kJ(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
