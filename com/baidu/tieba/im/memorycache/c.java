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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.stranger.StrangerListActivity;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static volatile c bdb;
    private CustomMessage<String> bdg;
    private BdUniqueId mId;
    final AtomicBoolean bdc = new AtomicBoolean(false);
    private final a bdd = new a();
    private final a bde = new a();
    private final a bdf = new a();
    private CustomMessageListener bdh = new d(this, 2016008);

    private c() {
        MessageManager.getInstance().registerListener(this.bdh);
        this.bdg = new CustomMessage<>(2016008, TbadkApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.bdg.setTag(this.mId);
    }

    public boolean PM() {
        return this.bdc.get();
    }

    public static c PN() {
        com.baidu.adp.lib.util.m.ft();
        if (bdb == null) {
            synchronized (c.class) {
                if (bdb == null) {
                    bdb = new c();
                }
            }
        }
        return bdb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.bdc.set(false);
        clear();
        MessageManager.getInstance().removeMessage(2016008, this.mId);
        this.bdg.setData(TbadkApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.bdg, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PO() {
        ImMessageCenterPojo gq;
        a fU = fU(-4);
        if (fU != null && (gq = fU.gq("-1003")) != null) {
            String last_content = gq.getLast_content();
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
                    ImMessageCenterPojo gq2 = this.bdd.gq(str);
                    if (gq2 != null) {
                        str3 = gq2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        gq.setLast_content(String.valueOf(str2) + TbadkApplication.m251getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PP() {
        ImMessageCenterPojo gq;
        a fU = fU(-3);
        if (fU != null && (gq = fU.gq("-1002")) != null) {
            String last_content = gq.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    gq.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PQ() {
        ImMessageCenterPojo gq;
        a fU = fU(-5);
        if (fU != null && (gq = fU.gq("-1004")) != null) {
            String last_content = gq.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    gq.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            fU(imMessageCenterPojo.getCustomGroupType()).b(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo B(String str, int i) {
        a fU;
        if (this.bdc.get() && (fU = fU(i)) != null) {
            return fU.gq(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(String str, int i) {
        ImMessageCenterPojo B = B(str, i);
        if (B != null) {
            D(str, i);
            d(B);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(String str, int i) {
        a fU;
        if (this.bdc.get() && (fU = fU(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            fU.gr(str);
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bdc.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(dh(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(di(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bdc.get()) {
            ImMessageCenterPojo B = B(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (B == null) {
                c(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= B.getLast_rid()) {
                D(B.getGid(), B.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(B.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(B.getGroup_name());
                }
                c(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                B.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.bdc.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo B = B(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (B == null) {
                imMessageCenterPojo.setUnread_count(i);
                c(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > B.getLast_rid()) {
                B.setLast_rid(imMessageCenterPojo.getLast_rid());
                B.setLast_content(imMessageCenterPojo.getLast_content());
                B.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                B.setUnread_count(B.getUnread_count() + i);
                B.setIs_hidden(0);
                a(B, true);
            }
        }
    }

    private void clear() {
        this.bdd.PL();
        this.bde.PL();
        this.bdf.PL();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        if (this.bdc.get()) {
            UserData userData = null;
            if ((i == 2 || i == 4) && chatMessage != null) {
                if (String.valueOf(chatMessage.getUserId()).equals(TbadkApplication.getCurrentAccount())) {
                    userData = chatMessage.getToUserInfo();
                } else {
                    userData = chatMessage.getUserInfo();
                }
                if (userData != null) {
                    str = userData.getUserId();
                }
            }
            if (!TextUtils.isEmpty(str)) {
                ImMessageCenterPojo B = B(str, i);
                if (B == null) {
                    B = new ImMessageCenterPojo();
                    B.setCustomGroupType(i);
                    B.setGid(str);
                    c(B);
                }
                if ((i == 2 || i == 4) && userData != null) {
                    if (!TextUtils.isEmpty(userData.getPortrait())) {
                        B.setGroup_head(userData.getPortrait());
                    }
                    if (!TextUtils.isEmpty(userData.getUserName())) {
                        B.setGroup_name(userData.getUserName());
                    }
                }
                switch (i2) {
                    case 1:
                        B.setLast_content("");
                        B.setLast_rid(0L);
                        B.setSend_status(0);
                        B.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            B.setLast_content_time(chatMessage.getTime() * 1000);
                            B.setLast_content(com.baidu.tieba.im.util.i.m(chatMessage.getMsgType(), chatMessage.getContent()));
                            B.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            B.setLast_rid(chatMessage.getRecordId());
                            B.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            B.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                B.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            B.setLast_content("");
                            B.setLast_rid(0L);
                            B.setSend_status(0);
                            B.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && B.getLast_rid() <= chatMessage.getRecordId()) {
                            B.setLast_content_time(chatMessage.getTime() * 1000);
                            B.setLast_content(com.baidu.tieba.im.util.i.m(chatMessage.getMsgType(), chatMessage.getContent()));
                            B.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            B.setLast_rid(chatMessage.getRecordId());
                            B.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            B.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                B.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        B.setIs_hidden(0);
                        break;
                }
                BdLog.i("send message status " + B.getSend_status());
                a(B, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bdc.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo B = B(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (B == null) {
                c(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            D(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(B.getPulled_msgId());
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
    public void as(String str, String str2) {
        ImMessageCenterPojo B = B(str, 1);
        if (B != null) {
            B.setGroup_head(str2);
            a(B, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void at(String str, String str2) {
        ImMessageCenterPojo B = B(str, 1);
        if (B != null) {
            B.setGroup_name(str2);
            a(B, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bdc.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo B = B(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (B == null) {
                c(imMessageCenterPojo);
                return;
            }
            B.setGroup_head(imMessageCenterPojo.getGroup_head());
            B.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.bdc.get()) {
            this.bdd.a(new n(this));
            this.bde.a(new o(this));
            this.bdf.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bdc.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo B = B(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (B == null) {
                c(imMessageCenterPojo);
            } else if (B.getPulled_msgId() <= 0) {
                B.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.bdc.get()) {
            ImMessageCenterPojo B = B(str, i);
            if (B == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                c(imMessageCenterPojo);
            } else if (B.getPulled_msgId() < j) {
                B.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo d(String str, int i, boolean z) {
        ImMessageCenterPojo B = B(str, i);
        if (B != null) {
            if (z) {
                B.setIs_hidden(0);
            } else {
                B.setIs_hidden(1);
            }
        }
        return B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, boolean z) {
        ImMessageCenterPojo d = d(str, i, z);
        if (d != null) {
            a(d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(String str, int i) {
        ImMessageCenterPojo B = B(str, i);
        if (B != null) {
            B.setUnread_count(0);
            a(B, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PR() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> PS() {
        LinkedList linkedList = new LinkedList();
        this.bdd.a(new q(this, linkedList));
        this.bde.a(new r(this, linkedList));
        this.bdf.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> PT() {
        LinkedList linkedList = new LinkedList();
        this.bdd.a(new t(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> PU() {
        LinkedList linkedList = new LinkedList();
        this.bdf.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> PV() {
        LinkedList linkedList = new LinkedList();
        this.bde.a(new f(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> PW() {
        LinkedList linkedList = new LinkedList();
        this.bde.a(new g(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016000));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.bdc.get()) {
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
        a(dh(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo dh(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a fU = fU(-7);
        if (fU != null) {
            imMessageCenterPojo = fU.gq("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            c(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bde.a(new h(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo B = B("-1001", -7);
                if (B != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new i(this, B));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        } else if (z) {
            if (StrangerListActivity.isOpen) {
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
    public ImMessageCenterPojo di(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a fU = fU(-8);
        if (fU != null) {
            imMessageCenterPojo = fU.gq("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            c(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bdf.a(new j(this, imMessageCenterPojo2));
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
            if (OfficialBarTipActivity.isOpen) {
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
        a(di(z), z, i);
    }

    public SparseArray<Long> PX() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.bdc.get()) {
            this.bdd.a(new l(this, sparseArray));
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        return imMessageCenterPojo.getCustomGroupType() == 1 || imMessageCenterPojo.getCustomGroupType() == 9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == 3 || imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == 8 || imMessageCenterPojo.getCustomGroupType() == 7 || imMessageCenterPojo.getCustomGroupType() == 6;
    }

    public long F(String str, int i) {
        ImMessageCenterPojo B = B(str, i);
        if (B != null) {
            return B.getPulled_msgId();
        }
        return 0L;
    }

    public long G(String str, int i) {
        ImMessageCenterPojo B = B(str, i);
        long j = 0;
        if (B != null) {
            j = B.getLast_rid() > B.getPulled_msgId() ? B.getLast_rid() : B.getPulled_msgId();
        }
        return j + 1;
    }

    private a fU(int i) {
        if (i == 2) {
            return this.bde;
        }
        if (i == 4) {
            return this.bdf;
        }
        return this.bdd;
    }
}
