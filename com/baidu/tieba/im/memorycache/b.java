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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static volatile b cZK;
    private CustomMessage<String> cZQ;
    private BdUniqueId mId;
    private final String cZJ = "0";
    final AtomicBoolean cZL = new AtomicBoolean(false);
    private final a cZM = new a();
    private final a cZN = new a();
    private final a cZO = new a();
    private final int cZP = 10;
    private CustomMessageListener cZR = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.cZR);
        this.cZQ = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.cZQ.setTag(this.mId);
    }

    public boolean asN() {
        return this.cZL.get();
    }

    public static b asO() {
        if (cZK == null) {
            synchronized (b.class) {
                if (cZK == null) {
                    cZK = new b();
                }
            }
        }
        return cZK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.cZL.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.cZQ.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.cZQ, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asP() {
        ImMessageCenterPojo lb;
        a lP = lP(-4);
        if (lP != null && (lb = lP.lb("-1003")) != null) {
            String last_content = lb.getLast_content();
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
                    ImMessageCenterPojo lb2 = this.cZM.lb(str);
                    if (lb2 != null) {
                        str3 = lb2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        lb.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(r.l.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asQ() {
        ImMessageCenterPojo lb;
        a lP = lP(-3);
        if (lP != null && (lb = lP.lb("-1002")) != null) {
            String last_content = lb.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    lb.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asR() {
        ImMessageCenterPojo lb;
        a lP = lP(-5);
        if (lP != null && (lb = lP.lb("-1004")) != null) {
            String last_content = lb.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    lb.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            lP(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo af(String str, int i) {
        a lP;
        if (this.cZL.get() && (lP = lP(i)) != null) {
            return lP.lb(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ag(String str, int i) {
        ImMessageCenterPojo af = af(str, i);
        if (af != null) {
            ah(str, i);
            f(af);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ah(String str, int i) {
        a lP;
        if (this.cZL.get() && (lP = lP(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            lP.lc(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cZL.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(gg(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(gh(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cZL.get()) {
            ImMessageCenterPojo af = af(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (af == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= af.getLast_rid()) {
                ah(af.getGid(), af.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(af.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(af.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                af.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.cZL.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo af = af(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (af == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > af.getLast_rid()) {
                af.setLast_rid(imMessageCenterPojo.getLast_rid());
                af.setLast_content(imMessageCenterPojo.getLast_content());
                af.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                af.setUnread_count(af.getUnread_count() + i);
                af.setIs_hidden(0);
                af.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                af.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(af, true);
            }
        }
    }

    private void clear() {
        this.cZM.asM();
        this.cZN.asM();
        this.cZO.asM();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo af;
        if (this.cZL.get()) {
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
                ImMessageCenterPojo af2 = af(str, i);
                if (af2 == null) {
                    af2 = new ImMessageCenterPojo();
                    af2.setCustomGroupType(i);
                    af2.setGid(str);
                    e(af2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            af2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            af2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        af2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        af2.setLast_content("");
                        af2.setLast_rid(0L);
                        af2.setSend_status(0);
                        af2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            af2.setLast_content_time(chatMessage.getTime() * 1000);
                            af2.setLast_content(com.baidu.tieba.im.util.h.A(chatMessage.getMsgType(), chatMessage.getContent()));
                            af2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            af2.setLast_rid(chatMessage.getRecordId());
                            af2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            af2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                af2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            af2.setLast_content("");
                            af2.setLast_rid(0L);
                            af2.setSend_status(0);
                            af2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && af2.getLast_rid() <= chatMessage.getRecordId()) {
                            af2.setLast_content_time(chatMessage.getTime() * 1000);
                            af2.setLast_content(com.baidu.tieba.im.util.h.A(chatMessage.getMsgType(), chatMessage.getContent()));
                            af2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            af2.setLast_rid(chatMessage.getRecordId());
                            af2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            af2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                af2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        af2.setIs_hidden(0);
                        if (i == 4 && (af = af("-1000", -8)) != null) {
                            af.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + af2.getSend_status());
                a(af2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cZL.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo af = af(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (af == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(af.getPulled_msgId());
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
    public void bh(String str, String str2) {
        ImMessageCenterPojo af = af(str, 1);
        if (af != null) {
            af.setGroup_head(str2);
            a(af, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bi(String str, String str2) {
        ImMessageCenterPojo af = af(str, 1);
        if (af != null) {
            af.setGroup_name(str2);
            a(af, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cZL.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo af = af(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (af == null) {
                e(imMessageCenterPojo);
                return;
            }
            af.setGroup_head(imMessageCenterPojo.getGroup_head());
            af.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cZL.get()) {
            this.cZM.a(new n(this));
            this.cZN.a(new o(this));
            this.cZO.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cZL.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo af = af(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (af == null) {
                e(imMessageCenterPojo);
            } else if (af.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                af.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.cZL.get()) {
            ImMessageCenterPojo af = af(str, i);
            if (af == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (af.getPulled_msgId() < j) {
                af.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo af = af(str, i);
        if (af != null) {
            if (z) {
                af.setIs_hidden(0);
            } else {
                af.setIs_hidden(1);
            }
        }
        return af;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(String str, int i) {
        ImMessageCenterPojo af = af(str, i);
        if (af != null) {
            af.setUnread_count(0);
            a(af, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asS() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> asT() {
        LinkedList linkedList = new LinkedList();
        this.cZM.a(new q(this, linkedList));
        this.cZN.a(new r(this, linkedList));
        this.cZO.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> asU() {
        LinkedList linkedList = new LinkedList();
        this.cZM.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> asV() {
        LinkedList linkedList = new LinkedList();
        this.cZO.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> asW() {
        LinkedList linkedList = new LinkedList();
        this.cZN.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> asX() {
        LinkedList linkedList = new LinkedList();
        this.cZN.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.cZL.get()) {
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
        a(gg(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo gg(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lP = lP(-7);
        if (lP != null) {
            imMessageCenterPojo = lP.lb("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cZN.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo af = af("-1001", -7);
                if (af != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, af));
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
    public ImMessageCenterPojo gh(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lP = lP(-8);
        if (lP != null) {
            imMessageCenterPojo = lP.lb("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cZO.a(new i(this, imMessageCenterPojo2));
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
        a(gh(z), z, i);
    }

    public SparseArray<Long> asY() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.cZL.get()) {
            this.cZM.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair asZ() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.cZL.get()) {
            this.cZO.a(new l(this, arrayList, builder));
        }
        return builder.build(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m9getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m9getInst().getCustomizedFilter().bz(imMessageCenterPojo.getCustomGroupType());
        }
        return bz.lQ(imMessageCenterPojo.getCustomGroupType());
    }

    public long aj(String str, int i) {
        ImMessageCenterPojo af = af(str, i);
        if (af != null) {
            return af.getPulled_msgId();
        }
        return 0L;
    }

    public long ak(String str, int i) {
        ImMessageCenterPojo af = af(str, i);
        long j = 0;
        if (af != null) {
            j = af.getLast_rid() > af.getPulled_msgId() ? af.getLast_rid() : af.getPulled_msgId();
        }
        return j + 1;
    }

    private a lP(int i) {
        if (i == 2) {
            return this.cZN;
        }
        if (i == 4) {
            return this.cZO;
        }
        return this.cZM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bQ(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.cZM.lc(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
