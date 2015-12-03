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
import com.baidu.tieba.n;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static volatile b bTc;
    private CustomMessage<String> bTh;
    private BdUniqueId mId;
    final AtomicBoolean bTd = new AtomicBoolean(false);
    private final a bTe = new a();
    private final a bTf = new a();
    private final a bTg = new a();
    private CustomMessageListener bTi = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.bTi);
        this.bTh = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.bTh.setTag(this.mId);
    }

    public boolean isInit() {
        return this.bTd.get();
    }

    public static b Zt() {
        com.baidu.adp.lib.util.k.je();
        if (bTc == null) {
            synchronized (b.class) {
                if (bTc == null) {
                    bTc = new b();
                }
            }
        }
        return bTc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.bTd.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.bTh.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new l(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.bTh, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zu() {
        ImMessageCenterPojo iB;
        a il = il(-4);
        if (il != null && (iB = il.iB("-1003")) != null) {
            String last_content = iB.getLast_content();
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
                    ImMessageCenterPojo iB2 = this.bTe.iB(str);
                    if (iB2 != null) {
                        str3 = iB2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        iB.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(n.i.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zv() {
        ImMessageCenterPojo iB;
        a il = il(-3);
        if (il != null && (iB = il.iB("-1002")) != null) {
            String last_content = iB.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    iB.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zw() {
        ImMessageCenterPojo iB;
        a il = il(-5);
        if (il != null && (iB = il.iB("-1004")) != null) {
            String last_content = iB.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    iB.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            il(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo O(String str, int i) {
        a il;
        if (this.bTd.get() && (il = il(i)) != null) {
            return il.iB(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(String str, int i) {
        ImMessageCenterPojo O = O(str, i);
        if (O != null) {
            Q(str, i);
            f(O);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(String str, int i) {
        a il;
        if (this.bTd.get() && (il = il(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            il.iC(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bTd.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(dE(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(dF(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bTd.get()) {
            ImMessageCenterPojo O = O(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (O == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= O.getLast_rid()) {
                Q(O.getGid(), O.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(O.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(O.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                O.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.bTd.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo O = O(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (O == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > O.getLast_rid()) {
                O.setLast_rid(imMessageCenterPojo.getLast_rid());
                O.setLast_content(imMessageCenterPojo.getLast_content());
                O.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                O.setUnread_count(O.getUnread_count() + i);
                O.setIs_hidden(0);
                O.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                O.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(O, true);
            }
        }
    }

    private void clear() {
        this.bTe.Zs();
        this.bTf.Zs();
        this.bTg.Zs();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo O;
        if (this.bTd.get()) {
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
                ImMessageCenterPojo O2 = O(str, i);
                if (O2 == null) {
                    O2 = new ImMessageCenterPojo();
                    O2.setCustomGroupType(i);
                    O2.setGid(str);
                    e(O2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            O2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            O2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        O2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        O2.setLast_content("");
                        O2.setLast_rid(0L);
                        O2.setSend_status(0);
                        O2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            O2.setLast_content_time(chatMessage.getTime() * 1000);
                            O2.setLast_content(com.baidu.tieba.im.util.h.E(chatMessage.getMsgType(), chatMessage.getContent()));
                            O2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            O2.setLast_rid(chatMessage.getRecordId());
                            O2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            O2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                O2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            O2.setLast_content("");
                            O2.setLast_rid(0L);
                            O2.setSend_status(0);
                            O2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && O2.getLast_rid() <= chatMessage.getRecordId()) {
                            O2.setLast_content_time(chatMessage.getTime() * 1000);
                            O2.setLast_content(com.baidu.tieba.im.util.h.E(chatMessage.getMsgType(), chatMessage.getContent()));
                            O2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            O2.setLast_rid(chatMessage.getRecordId());
                            O2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            O2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                O2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        O2.setIs_hidden(0);
                        if (i == 4 && (O = O("-1000", -8)) != null) {
                            O.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + O2.getSend_status());
                a(O2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bTd.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo O = O(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (O == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            Q(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(O.getPulled_msgId());
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
        ImMessageCenterPojo O = O(str, 1);
        if (O != null) {
            O.setGroup_head(str2);
            a(O, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aM(String str, String str2) {
        ImMessageCenterPojo O = O(str, 1);
        if (O != null) {
            O.setGroup_name(str2);
            a(O, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bTd.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo O = O(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (O == null) {
                e(imMessageCenterPojo);
                return;
            }
            O.setGroup_head(imMessageCenterPojo.getGroup_head());
            O.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.bTd.get()) {
            this.bTe.a(new m(this));
            this.bTf.a(new n(this));
            this.bTg.a(new o(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.bTd.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo O = O(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (O == null) {
                e(imMessageCenterPojo);
            } else if (O.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                O.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.bTd.get()) {
            ImMessageCenterPojo O = O(str, i);
            if (O == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (O.getPulled_msgId() < j) {
                O.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo O = O(str, i);
        if (O != null) {
            if (z) {
                O.setIs_hidden(0);
            } else {
                O.setIs_hidden(1);
            }
        }
        return O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(String str, int i) {
        ImMessageCenterPojo O = O(str, i);
        if (O != null) {
            O.setUnread_count(0);
            a(O, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Zx() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Zy() {
        LinkedList linkedList = new LinkedList();
        this.bTe.a(new p(this, linkedList));
        this.bTf.a(new q(this, linkedList));
        this.bTg.a(new r(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> Zz() {
        LinkedList linkedList = new LinkedList();
        this.bTe.a(new s(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> ZA() {
        LinkedList linkedList = new LinkedList();
        this.bTg.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> ZB() {
        LinkedList linkedList = new LinkedList();
        this.bTf.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> ZC() {
        LinkedList linkedList = new LinkedList();
        this.bTf.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.bTd.get()) {
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
        a(dE(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo dE(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a il = il(-7);
        if (il != null) {
            imMessageCenterPojo = il.iB("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bTf.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo O = O("-1001", -7);
                if (O != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, O));
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
    public ImMessageCenterPojo dF(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a il = il(-8);
        if (il != null) {
            imMessageCenterPojo = il.iB("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.bTg.a(new i(this, imMessageCenterPojo2));
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
        a(dF(z), z, i);
    }

    public SparseArray<Long> ZD() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.bTd.get()) {
            this.bTe.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m411getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m411getInst().getCustomizedFilter().bp(imMessageCenterPojo.getCustomGroupType());
        }
        return bw.im(imMessageCenterPojo.getCustomGroupType());
    }

    public long S(String str, int i) {
        ImMessageCenterPojo O = O(str, i);
        if (O != null) {
            return O.getPulled_msgId();
        }
        return 0L;
    }

    public long T(String str, int i) {
        ImMessageCenterPojo O = O(str, i);
        long j = 0;
        if (O != null) {
            j = O.getLast_rid() > O.getPulled_msgId() ? O.getLast_rid() : O.getPulled_msgId();
        }
        return j + 1;
    }

    private a il(int i) {
        if (i == 2) {
            return this.bTf;
        }
        if (i == 4) {
            return this.bTg;
        }
        return this.bTe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ba(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.bTe.iC(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
