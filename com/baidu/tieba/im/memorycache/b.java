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
    private static volatile b cmH;
    private CustomMessage<String> cmN;
    private BdUniqueId mId;
    private final String cmG = "0";
    final AtomicBoolean cmI = new AtomicBoolean(false);
    private final a cmJ = new a();
    private final a cmK = new a();
    private final a cmL = new a();
    private final int cmM = 10;
    private CustomMessageListener cmO = new c(this, CmdConfigCustom.MEMORY_GET_FROM_DB);

    private b() {
        MessageManager.getInstance().registerListener(this.cmO);
        this.cmN = new CustomMessage<>((int) CmdConfigCustom.MEMORY_GET_FROM_DB, TbadkCoreApplication.getCurrentAccount());
        this.mId = BdUniqueId.gen();
        this.cmN.setTag(this.mId);
    }

    public boolean agZ() {
        return this.cmI.get();
    }

    public static b aha() {
        if (cmH == null) {
            synchronized (b.class) {
                if (cmH == null) {
                    cmH = new b();
                }
            }
        }
        return cmH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.cmI.set(false);
        clear();
        MessageManager.getInstance().removeMessage(CmdConfigCustom.MEMORY_GET_FROM_DB, this.mId);
        this.cmN.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_GET_FROM_DB, new m(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.cmN, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahb() {
        ImMessageCenterPojo jC;
        a jr = jr(-4);
        if (jr != null && (jC = jr.jC("-1003")) != null) {
            String last_content = jC.getLast_content();
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
                    ImMessageCenterPojo jC2 = this.cmJ.jC(str);
                    if (jC2 != null) {
                        str3 = jC2.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        jC.setLast_content(String.valueOf(str2) + TbadkCoreApplication.m11getInst().getApp().getApplicationContext().getString(t.j.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahc() {
        ImMessageCenterPojo jC;
        a jr = jr(-3);
        if (jr != null && (jC = jr.jC("-1002")) != null) {
            String last_content = jC.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    jC.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahd() {
        ImMessageCenterPojo jC;
        a jr = jr(-5);
        if (jr != null && (jC = jr.jC("-1004")) != null) {
            String last_content = jC.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    jC.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            jr(imMessageCenterPojo.getCustomGroupType()).d(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo aa(String str, int i) {
        a jr;
        if (this.cmI.get() && (jr = jr(i)) != null) {
            return jr.jC(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(String str, int i) {
        ImMessageCenterPojo aa = aa(str, i);
        if (aa != null) {
            ac(str, i);
            f(aa);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ac(String str, int i) {
        a jr;
        if (this.cmI.get() && (jr = jr(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            jr.jD(str);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cmI.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(eJ(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(eK(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cmI.get()) {
            ImMessageCenterPojo aa = aa(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aa == null) {
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= aa.getLast_rid()) {
                ac(aa.getGid(), aa.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(aa.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(aa.getGroup_name());
                }
                e(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else {
                aa.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.cmI.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo aa = aa(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aa == null) {
                imMessageCenterPojo.setUnread_count(i);
                e(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > aa.getLast_rid()) {
                aa.setLast_rid(imMessageCenterPojo.getLast_rid());
                aa.setLast_content(imMessageCenterPojo.getLast_content());
                aa.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                aa.setUnread_count(aa.getUnread_count() + i);
                aa.setIs_hidden(0);
                aa.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                aa.setGroup_name(imMessageCenterPojo.getGroup_name());
                a(aa, true);
            }
        }
    }

    private void clear() {
        this.cmJ.agY();
        this.cmK.agY();
        this.cmL.agY();
        sendClearMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        int userType;
        ImMessageCenterPojo aa;
        if (this.cmI.get()) {
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
                ImMessageCenterPojo aa2 = aa(str, i);
                if (aa2 == null) {
                    aa2 = new ImMessageCenterPojo();
                    aa2.setCustomGroupType(i);
                    aa2.setGid(str);
                    e(aa2);
                }
                if (i == 2 || i == 4) {
                    if (userData != null) {
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            aa2.setGroup_head(userData.getPortrait());
                        }
                        if (!TextUtils.isEmpty(userData.getUserName())) {
                            aa2.setGroup_name(userData.getUserName());
                        }
                    }
                    if (chatMessage != null) {
                        if (com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                            userType = chatMessage.getUserInfo().getUserType();
                        } else {
                            userType = chatMessage.getToUserInfo().getUserType();
                        }
                        aa2.setUserType(userType);
                    }
                }
                switch (i2) {
                    case 1:
                        aa2.setLast_content("");
                        aa2.setLast_rid(0L);
                        aa2.setSend_status(0);
                        aa2.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            aa2.setLast_content_time(chatMessage.getTime() * 1000);
                            aa2.setLast_content(com.baidu.tieba.im.util.h.x(chatMessage.getMsgType(), chatMessage.getContent()));
                            aa2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            aa2.setLast_rid(chatMessage.getRecordId());
                            aa2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            aa2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                aa2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            aa2.setLast_content("");
                            aa2.setLast_rid(0L);
                            aa2.setSend_status(0);
                            aa2.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && aa2.getLast_rid() <= chatMessage.getRecordId()) {
                            aa2.setLast_content_time(chatMessage.getTime() * 1000);
                            aa2.setLast_content(com.baidu.tieba.im.util.h.x(chatMessage.getMsgType(), chatMessage.getContent()));
                            aa2.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            aa2.setLast_rid(chatMessage.getRecordId());
                            aa2.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            aa2.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                aa2.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        aa2.setIs_hidden(0);
                        if (i == 4 && (aa = aa("-1000", -8)) != null) {
                            aa.setIs_hidden(0);
                            break;
                        }
                        break;
                }
                BdLog.i("send message status " + aa2.getSend_status());
                a(aa2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo h(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cmI.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo aa = aa(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aa == null) {
                e(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            ac(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(aa.getPulled_msgId());
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
        ImMessageCenterPojo aa = aa(str, 1);
        if (aa != null) {
            aa.setGroup_head(str2);
            a(aa, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bd(String str, String str2) {
        ImMessageCenterPojo aa = aa(str, 1);
        if (aa != null) {
            aa.setGroup_name(str2);
            a(aa, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cmI.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo aa = aa(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aa == null) {
                e(imMessageCenterPojo);
                return;
            }
            aa.setGroup_head(imMessageCenterPojo.getGroup_head());
            aa.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        if (this.cmI.get()) {
            this.cmJ.a(new n(this));
            this.cmK.a(new o(this));
            this.cmL.a(new p(this));
            sendClearMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.cmI.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo aa = aa(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (aa == null) {
                e(imMessageCenterPojo);
            } else if (aa.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                aa.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.cmI.get()) {
            ImMessageCenterPojo aa = aa(str, i);
            if (aa == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                e(imMessageCenterPojo);
            } else if (aa.getPulled_msgId() < j) {
                aa.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo e(String str, int i, boolean z) {
        ImMessageCenterPojo aa = aa(str, i);
        if (aa != null) {
            if (z) {
                aa.setIs_hidden(0);
            } else {
                aa.setIs_hidden(1);
            }
        }
        return aa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, boolean z) {
        ImMessageCenterPojo e = e(str, i, z);
        if (e != null) {
            a(e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ad(String str, int i) {
        ImMessageCenterPojo aa = aa(str, i);
        if (aa != null) {
            aa.setUnread_count(0);
            a(aa, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ahe() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> ahf() {
        LinkedList linkedList = new LinkedList();
        this.cmJ.a(new q(this, linkedList));
        this.cmK.a(new r(this, linkedList));
        this.cmL.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> ahg() {
        LinkedList linkedList = new LinkedList();
        this.cmJ.a(new t(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> ahh() {
        LinkedList linkedList = new LinkedList();
        this.cmL.a(new d(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> ahi() {
        LinkedList linkedList = new LinkedList();
        this.cmK.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> ahj() {
        LinkedList linkedList = new LinkedList();
        this.cmK.a(new f(this, linkedList));
        return linkedList;
    }

    void sendClearMessage() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MEMORY_CLEAR));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.cmI.get()) {
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
        a(eJ(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo eJ(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a jr = jr(-7);
        if (jr != null) {
            imMessageCenterPojo = jr.jC("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cmK.a(new g(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo aa = aa("-1001", -7);
                if (aa != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new h(this, aa));
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
    public ImMessageCenterPojo eK(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a jr = jr(-8);
        if (jr != null) {
            imMessageCenterPojo = jr.jC("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            e(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.cmL.a(new i(this, imMessageCenterPojo2));
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
        a(eK(z), z, i);
    }

    public SparseArray<Long> ahk() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.cmI.get()) {
            this.cmJ.a(new k(this, sparseArray));
        }
        return sparseArray;
    }

    public NewpushRepair ahl() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.cmI.get()) {
            this.cmL.a(new l(this, arrayList, builder));
        }
        return builder.build(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.m11getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m11getInst().getCustomizedFilter().bi(imMessageCenterPojo.getCustomGroupType());
        }
        return bz.js(imMessageCenterPojo.getCustomGroupType());
    }

    public long ae(String str, int i) {
        ImMessageCenterPojo aa = aa(str, i);
        if (aa != null) {
            return aa.getPulled_msgId();
        }
        return 0L;
    }

    public long af(String str, int i) {
        ImMessageCenterPojo aa = aa(str, i);
        long j = 0;
        if (aa != null) {
            j = aa.getLast_rid() > aa.getPulled_msgId() ? aa.getLast_rid() : aa.getPulled_msgId();
        }
        return j + 1;
    }

    private a jr(int i) {
        if (i == 2) {
            return this.cmK;
        }
        if (i == 4) {
            return this.cmL;
        }
        return this.cmJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bj(List<ImMessageCenterPojo> list) {
        if (list != null && list.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (imMessageCenterPojo != null) {
                    this.cmJ.jD(imMessageCenterPojo.getGid());
                }
            }
        }
    }
}
