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
    private static volatile b dcr;
    private CustomMessage<String> dcy;
    private BdUniqueId mId;
    private final String dcq = "0";
    final AtomicBoolean dcs = new AtomicBoolean(false);
    private final a dct = new a();
    private final a dcv = new a();
    private final a dcw = new a();
    private final int dcx = 10;
    private CustomMessageListener dcz = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.dcz);
        this.dcy = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.dcy.setTag(this.mId);
    }

    public boolean aqW() {
        return this.dcs.get();
    }

    public static b aqX() {
        if (dcr == null) {
            synchronized (b.class) {
                if (dcr == null) {
                    dcr = new b();
                }
            }
        }
        return dcr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.dcs.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.dcy.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.dcy, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqY() {
        ImMessageCenterPojo kX;
        a lT = lT(-4);
        if (lT != null && (kX = lT.kX("-1003")) != null) {
            String last_content = kX.getLast_content();
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
                    ImMessageCenterPojo kX2 = this.dct.kX(str);
                    if (kX2 != null) {
                        str3 = kX2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        kX.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(w.l.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqZ() {
        ImMessageCenterPojo kX;
        a lT = lT(-3);
        if (lT != null && (kX = lT.kX("-1002")) != null) {
            String last_content = kX.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    kX.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ara() {
        ImMessageCenterPojo kX;
        a lT = lT(-5);
        if (lT != null && (kX = lT.kX("-1004")) != null) {
            String last_content = kX.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    kX.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            lT(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Z(String str, int i) {
        a lT;
        if (this.dcs.get() && (lT = lT(i)) != null) {
            return lT.kX(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(String str, int i) {
        ImMessageCenterPojo Z = Z(str, i);
        if (Z != null) {
            ab(str, i);
            f(Z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(String str, int i) {
        a lT;
        if (this.dcs.get() && (lT = lT(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            lT.kY(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dcs.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(fV(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(fW(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dcs.get()) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= Z.getLast_rid()) {
                ab(Z.getGid(), Z.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(Z.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(Z.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                Z.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.dcs.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > Z.getLast_rid()) {
                Z.setLast_rid(imMessageCenterPojo.getLast_rid());
                Z.setLast_content(imMessageCenterPojo.getLast_content());
                Z.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                Z.setUnread_count(Z.getUnread_count() + i);
                Z.setIs_hidden(0);
                Z.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                Z.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(Z, true);
            }
        }
    }

    private void clear() {
        this.dct.aqV();
        this.dcv.aqV();
        this.dcw.aqV();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo Z;
        if (this.dcs.get()) {
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
                ImMessageCenterPojo Z2 = Z(str, i);
                if (Z2 == null) {
                    Z2 = new ImMessageCenterPojo();
                    Z2.setCustomGroupType(i);
                    Z2.setGid(str);
                    e(Z2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            Z2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            Z2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        Z2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        Z2.setLast_content("");
                        Z2.setLast_rid(0L);
                        Z2.setSend_status(0);
                        Z2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            Z2.setLast_content_time(chatMessage.getTime() * 1000);
                            Z2.setLast_content(com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent()));
                            Z2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            Z2.setLast_rid(chatMessage.getRecordId());
                            Z2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            Z2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                Z2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            Z2.setLast_content("");
                            Z2.setLast_rid(0L);
                            Z2.setSend_status(0);
                            Z2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && Z2.getLast_rid() <= chatMessage.getRecordId()) {
                            Z2.setLast_content_time(chatMessage.getTime() * 1000);
                            Z2.setLast_content(com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent()));
                            Z2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            Z2.setLast_rid(chatMessage.getRecordId());
                            Z2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            Z2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                Z2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        Z2.setIs_hidden(0);
                        if (i == 4 && (Z = Z("-1000", -8)) != null) {
                            Z.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + Z2.getSend_status());
                a(Z2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dcs.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            ab(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(Z.getPulled_msgId());
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
    public void ba(String str, String str2) {
        ImMessageCenterPojo Z = Z(str, 1);
        if (Z != null) {
            Z.setGroup_head(str2);
            a(Z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bb(String str, String str2) {
        ImMessageCenterPojo Z = Z(str, 1);
        if (Z != null) {
            Z.setGroup_name(str2);
            a(Z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dcs.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                e(imMessageCenterPojo);
                return;
            }
            Z.setGroup_head(imMessageCenterPojo.getGroup_head());
            Z.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dcs.get()) {
            this.dct.a(new n(this));
            this.dcv.a(new o(this));
            this.dcw.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dcs.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo Z = Z(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (Z == null) {
                e(imMessageCenterPojo);
            } else if (Z.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                Z.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.dcs.get()) {
            ImMessageCenterPojo Z = Z(str, i);
            if (Z == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (Z.getPulled_msgId() < j) {
                Z.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo Z = Z(str, i);
        if (Z != null) {
            if (z) {
                Z.setIs_hidden(0);
            } else {
                Z.setIs_hidden(1);
            }
        }
        return Z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ac(String str, int i) {
        ImMessageCenterPojo Z = Z(str, i);
        if (Z != null) {
            Z.setUnread_count(0);
            a(Z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void arb() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> arc() {
        LinkedList linkedList = new LinkedList();
        this.dct.a(new q(this, linkedList));
        this.dcv.a(new r(this, linkedList));
        this.dcw.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> ard() {
        LinkedList linkedList = new LinkedList();
        this.dct.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> are() {
        LinkedList linkedList = new LinkedList();
        this.dcw.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> arf() {
        LinkedList linkedList = new LinkedList();
        this.dcv.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> arg() {
        LinkedList linkedList = new LinkedList();
        this.dcv.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.dcs.get()) {
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
        a(fV(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo fV(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lT = lT(-7);
        if (lT != null) {
            imMessageCenterPojo = lT.kX("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.dcv.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo Z = Z("-1001", -7);
                if (Z != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, Z));
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
    public ImMessageCenterPojo fW(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lT = lT(-8);
        if (lT != null) {
            imMessageCenterPojo = lT.kX("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.dcw.a(new i(this, imMessageCenterPojo2));
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
        a(fW(z), z, i);
    }

    public SparseArray<Long> arh() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.dcs.get()) {
            this.dct.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair ari() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.dcs.get()) {
            this.dcw.a(new l(this, arrayList, builder));
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
        return bz.lU(imMessageCenterPojo.getCustomGroupType());
    }

    public long ad(String str, int i) {
        ImMessageCenterPojo Z = Z(str, i);
        if (Z != null) {
            return Z.getPulled_msgId();
        }
        return 0L;
    }

    public long ae(String str, int i) {
        ImMessageCenterPojo Z = Z(str, i);
        long j = 0;
        if (Z != null) {
            j = Z.getLast_rid() > Z.getPulled_msgId() ? Z.getLast_rid() : Z.getPulled_msgId();
        }
        return j + 1;
    }

    private a lT(int i) {
        if (i == 2) {
            return this.dcv;
        }
        if (i == 4) {
            return this.dcw;
        }
        return this.dct;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bq(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.dct.kY(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
