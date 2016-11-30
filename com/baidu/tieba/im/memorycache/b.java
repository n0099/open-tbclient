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
    private static volatile b dnG;
    private CustomMessage<String> dnM;
    private BdUniqueId mId;
    private final String dnF = "0";
    final AtomicBoolean dnH = new AtomicBoolean(false);
    private final a dnI = new a();
    private final a dnJ = new a();
    private final a dnK = new a();
    private final int dnL = 10;
    private CustomMessageListener dnN = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.dnN);
        this.dnM = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.dnM.setTag(this.mId);
    }

    public boolean axi() {
        return this.dnH.get();
    }

    public static b axj() {
        if (dnG == null) {
            synchronized (b.class) {
                if (dnG == null) {
                    dnG = new b();
                }
            }
        }
        return dnG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.dnH.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.dnM.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.dnM, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axk() {
        ImMessageCenterPojo ml;
        a lS = lS(-4);
        if (lS != null && (ml = lS.ml("-1003")) != null) {
            String last_content = ml.getLast_content();
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
                    ImMessageCenterPojo ml2 = this.dnI.ml(str);
                    if (ml2 != null) {
                        str3 = ml2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        ml.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(r.j.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axl() {
        ImMessageCenterPojo ml;
        a lS = lS(-3);
        if (lS != null && (ml = lS.ml("-1002")) != null) {
            String last_content = ml.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    ml.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axm() {
        ImMessageCenterPojo ml;
        a lS = lS(-5);
        if (lS != null && (ml = lS.ml("-1004")) != null) {
            String last_content = ml.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    ml.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            lS(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo ah(String str, int i) {
        a lS;
        if (this.dnH.get() && (lS = lS(i)) != null) {
            return lS.ml(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(String str, int i) {
        ImMessageCenterPojo ah = ah(str, i);
        if (ah != null) {
            aj(str, i);
            f(ah);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(String str, int i) {
        a lS;
        if (this.dnH.get() && (lS = lS(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            lS.mm(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dnH.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(gt(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(gu(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dnH.get()) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= ah.getLast_rid()) {
                aj(ah.getGid(), ah.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(ah.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(ah.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                ah.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.dnH.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > ah.getLast_rid()) {
                ah.setLast_rid(imMessageCenterPojo.getLast_rid());
                ah.setLast_content(imMessageCenterPojo.getLast_content());
                ah.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                ah.setUnread_count(ah.getUnread_count() + i);
                ah.setIs_hidden(0);
                ah.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                ah.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(ah, true);
            }
        }
    }

    private void clear() {
        this.dnI.axh();
        this.dnJ.axh();
        this.dnK.axh();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo ah;
        if (this.dnH.get()) {
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
                ImMessageCenterPojo ah2 = ah(str, i);
                if (ah2 == null) {
                    ah2 = new ImMessageCenterPojo();
                    ah2.setCustomGroupType(i);
                    ah2.setGid(str);
                    e(ah2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            ah2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            ah2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        ah2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        ah2.setLast_content("");
                        ah2.setLast_rid(0L);
                        ah2.setSend_status(0);
                        ah2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            ah2.setLast_content_time(chatMessage.getTime() * 1000);
                            ah2.setLast_content(com.baidu.tieba.im.util.h.y(chatMessage.getMsgType(), chatMessage.getContent()));
                            ah2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            ah2.setLast_rid(chatMessage.getRecordId());
                            ah2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            ah2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                ah2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            ah2.setLast_content("");
                            ah2.setLast_rid(0L);
                            ah2.setSend_status(0);
                            ah2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && ah2.getLast_rid() <= chatMessage.getRecordId()) {
                            ah2.setLast_content_time(chatMessage.getTime() * 1000);
                            ah2.setLast_content(com.baidu.tieba.im.util.h.y(chatMessage.getMsgType(), chatMessage.getContent()));
                            ah2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            ah2.setLast_rid(chatMessage.getRecordId());
                            ah2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            ah2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                ah2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        ah2.setIs_hidden(0);
                        if (i == 4 && (ah = ah("-1000", -8)) != null) {
                            ah.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + ah2.getSend_status());
                a(ah2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dnH.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            aj(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(ah.getPulled_msgId());
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
    public void bg(String str, String str2) {
        ImMessageCenterPojo ah = ah(str, 1);
        if (ah != null) {
            ah.setGroup_head(str2);
            a(ah, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bh(String str, String str2) {
        ImMessageCenterPojo ah = ah(str, 1);
        if (ah != null) {
            ah.setGroup_name(str2);
            a(ah, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dnH.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                e(imMessageCenterPojo);
                return;
            }
            ah.setGroup_head(imMessageCenterPojo.getGroup_head());
            ah.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.dnH.get()) {
            this.dnI.a(new n(this));
            this.dnJ.a(new o(this));
            this.dnK.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.dnH.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo ah = ah(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (ah == null) {
                e(imMessageCenterPojo);
            } else if (ah.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                ah.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.dnH.get()) {
            ImMessageCenterPojo ah = ah(str, i);
            if (ah == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (ah.getPulled_msgId() < j) {
                ah.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo f(String str, int i, boolean z) {
        ImMessageCenterPojo ah = ah(str, i);
        if (ah != null) {
            if (z) {
                ah.setIs_hidden(0);
            } else {
                ah.setIs_hidden(1);
            }
        }
        return ah;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, int i, boolean z) {
        ImMessageCenterPojo f = f(str, i, z);
        if (f != null) {
            a(f, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ak(String str, int i) {
        ImMessageCenterPojo ah = ah(str, i);
        if (ah != null) {
            ah.setUnread_count(0);
            a(ah, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void axn() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> axo() {
        LinkedList linkedList = new LinkedList();
        this.dnI.a(new q(this, linkedList));
        this.dnJ.a(new r(this, linkedList));
        this.dnK.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> axp() {
        LinkedList linkedList = new LinkedList();
        this.dnI.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> axq() {
        LinkedList linkedList = new LinkedList();
        this.dnK.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> axr() {
        LinkedList linkedList = new LinkedList();
        this.dnJ.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> axs() {
        LinkedList linkedList = new LinkedList();
        this.dnJ.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.dnH.get()) {
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
        a(gt(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo gt(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lS = lS(-7);
        if (lS != null) {
            imMessageCenterPojo = lS.ml("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.dnJ.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo ah = ah("-1001", -7);
                if (ah != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, ah));
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
    public ImMessageCenterPojo gu(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a lS = lS(-8);
        if (lS != null) {
            imMessageCenterPojo = lS.ml("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.dnK.a(new i(this, imMessageCenterPojo2));
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
        a(gu(z), z, i);
    }

    public SparseArray<Long> axt() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.dnH.get()) {
            this.dnI.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair axu() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.dnH.get()) {
            this.dnK.a(new l(this, arrayList, builder));
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
        return bz.lT(imMessageCenterPojo.getCustomGroupType());
    }

    public long al(String str, int i) {
        ImMessageCenterPojo ah = ah(str, i);
        if (ah != null) {
            return ah.getPulled_msgId();
        }
        return 0L;
    }

    public long am(String str, int i) {
        ImMessageCenterPojo ah = ah(str, i);
        long j = 0;
        if (ah != null) {
            j = ah.getLast_rid() > ah.getPulled_msgId() ? ah.getLast_rid() : ah.getPulled_msgId();
        }
        return j + 1;
    }

    private a lS(int i) {
        if (i == 2) {
            return this.dnJ;
        }
        if (i == 4) {
            return this.dnK;
        }
        return this.dnI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bT(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.dnI.mm(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
