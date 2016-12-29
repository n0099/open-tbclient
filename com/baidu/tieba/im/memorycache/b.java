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
    private static volatile b cSC;
    private CustomMessage<String> cSI;
    private BdUniqueId mId;
    private final String cSB = "0";
    final AtomicBoolean cSD = new AtomicBoolean(false);
    private final a cSE = new a();
    private final a cSF = new a();
    private final a cSG = new a();
    private final int cSH = 10;
    private CustomMessageListener cSJ = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.cSJ);
        this.cSI = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.cSI.setTag(this.mId);
    }

    public boolean arH() {
        return this.cSD.get();
    }

    public static b arI() {
        if (cSC == null) {
            synchronized (b.class) {
                if (cSC == null) {
                    cSC = new b();
                }
            }
        }
        return cSC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.cSD.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.cSI.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.cSI, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arJ() {
        ImMessageCenterPojo kO;
        a lc = lc(-4);
        if (lc != null && (kO = lc.kO("-1003")) != null) {
            String last_content = kO.getLast_content();
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
                    ImMessageCenterPojo kO2 = this.cSE.kO(str);
                    if (kO2 != null) {
                        str3 = kO2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        kO.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(r.j.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arK() {
        ImMessageCenterPojo kO;
        a lc = lc(-3);
        if (lc != null && (kO = lc.kO("-1002")) != null) {
            String last_content = kO.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    kO.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arL() {
        ImMessageCenterPojo kO;
        a lc = lc(-5);
        if (lc != null && (kO = lc.kO("-1004")) != null) {
            String last_content = kO.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    kO.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            lc(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo af(String str, int i) {
        a lc;
        if (this.cSD.get() && (lc = lc(i)) != null) {
            return lc.kO(str);
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
        a lc;
        if (this.cSD.get() && (lc = lc(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            lc.kP(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cSD.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(gd(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(ge(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cSD.get()) {
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
        if (this.cSD.get() && imMessageCenterPojo != null) {
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
        this.cSE.arG();
        this.cSF.arG();
        this.cSG.arG();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo af;
        if (this.cSD.get()) {
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
                        if (com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
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
                            af2.setLast_content(com.baidu.tieba.im.util.h.v(chatMessage.getMsgType(), chatMessage.getContent()));
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
                            af2.setLast_content(com.baidu.tieba.im.util.h.v(chatMessage.getMsgType(), chatMessage.getContent()));
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
        if (this.cSD.get() && imMessageCenterPojo != null) {
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
    public void bc(String str, String str2) {
        ImMessageCenterPojo af = af(str, 1);
        if (af != null) {
            af.setGroup_head(str2);
            a(af, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bd(String str, String str2) {
        ImMessageCenterPojo af = af(str, 1);
        if (af != null) {
            af.setGroup_name(str2);
            a(af, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cSD.get() && imMessageCenterPojo != null) {
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
        if (this.cSD.get()) {
            this.cSE.a(new n(this));
            this.cSF.a(new o(this));
            this.cSG.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cSD.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
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
        if (this.cSD.get()) {
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
    public void arM() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> arN() {
        LinkedList linkedList = new LinkedList();
        this.cSE.a(new q(this, linkedList));
        this.cSF.a(new r(this, linkedList));
        this.cSG.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> arO() {
        LinkedList linkedList = new LinkedList();
        this.cSE.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> arP() {
        LinkedList linkedList = new LinkedList();
        this.cSG.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> arQ() {
        LinkedList linkedList = new LinkedList();
        this.cSF.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> arR() {
        LinkedList linkedList = new LinkedList();
        this.cSF.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.cSD.get()) {
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
        a(gd(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo gd(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lc = lc(-7);
        if (lc != null) {
            imMessageCenterPojo = lc.kO("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cSF.a(new g(this, imMessageCenterPojo2));
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
    public ImMessageCenterPojo ge(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lc = lc(-8);
        if (lc != null) {
            imMessageCenterPojo = lc.kO("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cSG.a(new i(this, imMessageCenterPojo2));
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
        a(ge(z), z, i);
    }

    public SparseArray<Long> arS() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.cSD.get()) {
            this.cSE.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair arT() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.cSD.get()) {
            this.cSG.a(new l(this, arrayList, builder));
        }
        return builder.build(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m9getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m9getInst().getCustomizedFilter().bA(imMessageCenterPojo.getCustomGroupType());
        }
        return bz.ld(imMessageCenterPojo.getCustomGroupType());
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

    private a lc(int i) {
        if (i == 2) {
            return this.cSF;
        }
        if (i == 4) {
            return this.cSG;
        }
        return this.cSE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bL(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.cSE.kP(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
