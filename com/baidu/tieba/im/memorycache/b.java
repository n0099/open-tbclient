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
    private static volatile b dkp;
    private CustomMessage<String> dkv;
    private BdUniqueId mId;
    private final String dko = "0";
    final AtomicBoolean dkq = new AtomicBoolean(false);
    private final a dkr = new a();
    private final a dks = new a();
    private final a dkt = new a();
    private final int dku = 10;
    private CustomMessageListener dkw = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.dkw);
        this.dkv = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.dkv.setTag(this.mId);
    }

    public boolean auH() {
        return this.dkq.get();
    }

    public static b auI() {
        if (dkp == null) {
            synchronized (b.class) {
                if (dkp == null) {
                    dkp = new b();
                }
            }
        }
        return dkp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.dkq.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.dkv.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.dkv, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auJ() {
        ImMessageCenterPojo lW;
        a me = me(-4);
        if (me != null && (lW = me.lW("-1003")) != null) {
            String last_content = lW.getLast_content();
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
                    ImMessageCenterPojo lW2 = this.dkr.lW(str);
                    if (lW2 != null) {
                        str3 = lW2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        lW.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(w.l.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auK() {
        ImMessageCenterPojo lW;
        a me = me(-3);
        if (me != null && (lW = me.lW("-1002")) != null) {
            String last_content = lW.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    lW.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auL() {
        ImMessageCenterPojo lW;
        a me = me(-5);
        if (me != null && (lW = me.lW("-1004")) != null) {
            String last_content = lW.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    lW.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            me(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo ab(String str, int i) {
        a me;
        if (this.dkq.get() && (me = me(i)) != null) {
            return me.lW(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ac(String str, int i) {
        ImMessageCenterPojo ab = ab(str, i);
        if (ab != null) {
            ad(str, i);
            f(ab);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ad(String str, int i) {
        a me;
        if (this.dkq.get() && (me = me(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            me.lX(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dkq.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(gn(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(go(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dkq.get()) {
            ImMessageCenterPojo ab = ab(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ab == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= ab.getLast_rid()) {
                ad(ab.getGid(), ab.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(ab.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(ab.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                ab.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.dkq.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ab = ab(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ab == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > ab.getLast_rid()) {
                ab.setLast_rid(imMessageCenterPojo.getLast_rid());
                ab.setLast_content(imMessageCenterPojo.getLast_content());
                ab.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                ab.setUnread_count(ab.getUnread_count() + i);
                ab.setIs_hidden(0);
                ab.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                ab.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(ab, true);
            }
        }
    }

    private void clear() {
        this.dkr.auG();
        this.dks.auG();
        this.dkt.auG();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo ab;
        if (this.dkq.get()) {
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
                ImMessageCenterPojo ab2 = ab(str, i);
                if (ab2 == null) {
                    ab2 = new ImMessageCenterPojo();
                    ab2.setCustomGroupType(i);
                    ab2.setGid(str);
                    e(ab2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            ab2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            ab2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        ab2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        ab2.setLast_content("");
                        ab2.setLast_rid(0L);
                        ab2.setSend_status(0);
                        ab2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            ab2.setLast_content_time(chatMessage.getTime() * 1000);
                            ab2.setLast_content(com.baidu.tieba.im.util.h.F(chatMessage.getMsgType(), chatMessage.getContent()));
                            ab2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            ab2.setLast_rid(chatMessage.getRecordId());
                            ab2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            ab2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                ab2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            ab2.setLast_content("");
                            ab2.setLast_rid(0L);
                            ab2.setSend_status(0);
                            ab2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && ab2.getLast_rid() <= chatMessage.getRecordId()) {
                            ab2.setLast_content_time(chatMessage.getTime() * 1000);
                            ab2.setLast_content(com.baidu.tieba.im.util.h.F(chatMessage.getMsgType(), chatMessage.getContent()));
                            ab2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            ab2.setLast_rid(chatMessage.getRecordId());
                            ab2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            ab2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                ab2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        ab2.setIs_hidden(0);
                        if (i == 4 && (ab = ab("-1000", -8)) != null) {
                            ab.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + ab2.getSend_status());
                a(ab2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dkq.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ab = ab(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ab == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            ad(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(ab.getPulled_msgId());
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
        ImMessageCenterPojo ab = ab(str, 1);
        if (ab != null) {
            ab.setGroup_head(str2);
            a(ab, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bi(String str, String str2) {
        ImMessageCenterPojo ab = ab(str, 1);
        if (ab != null) {
            ab.setGroup_name(str2);
            a(ab, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dkq.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ab = ab(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ab == null) {
                e(imMessageCenterPojo);
                return;
            }
            ab.setGroup_head(imMessageCenterPojo.getGroup_head());
            ab.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dkq.get()) {
            this.dkr.a(new n(this));
            this.dks.a(new o(this));
            this.dkt.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dkq.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo ab = ab(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ab == null) {
                e(imMessageCenterPojo);
            } else if (ab.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                ab.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.dkq.get()) {
            ImMessageCenterPojo ab = ab(str, i);
            if (ab == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (ab.getPulled_msgId() < j) {
                ab.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo ab = ab(str, i);
        if (ab != null) {
            if (z) {
                ab.setIs_hidden(0);
            } else {
                ab.setIs_hidden(1);
            }
        }
        return ab;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ae(String str, int i) {
        ImMessageCenterPojo ab = ab(str, i);
        if (ab != null) {
            ab.setUnread_count(0);
            a(ab, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auM() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> auN() {
        LinkedList linkedList = new LinkedList();
        this.dkr.a(new q(this, linkedList));
        this.dks.a(new r(this, linkedList));
        this.dkt.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> auO() {
        LinkedList linkedList = new LinkedList();
        this.dkr.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> auP() {
        LinkedList linkedList = new LinkedList();
        this.dkt.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> auQ() {
        LinkedList linkedList = new LinkedList();
        this.dks.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> auR() {
        LinkedList linkedList = new LinkedList();
        this.dks.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.dkq.get()) {
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
        a(gn(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo gn(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a me = me(-7);
        if (me != null) {
            imMessageCenterPojo = me.lW("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.dks.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo ab = ab("-1001", -7);
                if (ab != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, ab));
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
    public ImMessageCenterPojo go(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a me = me(-8);
        if (me != null) {
            imMessageCenterPojo = me.lW("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.dkt.a(new i(this, imMessageCenterPojo2));
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
        a(go(z), z, i);
    }

    public SparseArray<Long> auS() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.dkq.get()) {
            this.dkr.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair auT() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.dkq.get()) {
            this.dkt.a(new l(this, arrayList, builder));
        }
        return builder.build(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m9getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m9getInst().getCustomizedFilter().bu(imMessageCenterPojo.getCustomGroupType());
        }
        return bz.mf(imMessageCenterPojo.getCustomGroupType());
    }

    public long af(String str, int i) {
        ImMessageCenterPojo ab = ab(str, i);
        if (ab != null) {
            return ab.getPulled_msgId();
        }
        return 0L;
    }

    public long ag(String str, int i) {
        ImMessageCenterPojo ab = ab(str, i);
        long j = 0;
        if (ab != null) {
            j = ab.getLast_rid() > ab.getPulled_msgId() ? ab.getLast_rid() : ab.getPulled_msgId();
        }
        return j + 1;
    }

    private a me(int i) {
        if (i == 2) {
            return this.dks;
        }
        if (i == 4) {
            return this.dkt;
        }
        return this.dkr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bB(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.dkr.lX(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
