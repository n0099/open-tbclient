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
    private static volatile c b;
    private CustomMessage<String> f;
    private BdUniqueId g;
    final AtomicBoolean a = new AtomicBoolean(false);
    private final a c = new a();
    private final a d = new a();
    private final a e = new a();
    private CustomMessageListener h = new d(this, 2016008);

    private c() {
        MessageManager.getInstance().registerListener(this.h);
        this.f = new CustomMessage<>(2016008, TbadkApplication.getCurrentAccount());
        this.g = BdUniqueId.gen();
        this.f.setTag(this.g);
    }

    public boolean a() {
        return this.a.get();
    }

    public static c b() {
        com.baidu.adp.lib.util.j.a();
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.a.set(false);
        p();
        MessageManager.getInstance().removeMessage(2016008, this.g);
        this.f.setData(TbadkApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new m(this));
        customMessageTask.setParallel(com.baidu.tbadk.k.b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.f, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ImMessageCenterPojo a;
        a a2 = a(-4);
        if (a2 != null && (a = a2.a("-1003")) != null) {
            String last_content = a.getLast_content();
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
                    ImMessageCenterPojo a3 = this.c.a(str);
                    if (a3 != null) {
                        str3 = a3.getGroup_name();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        a.setLast_content(String.valueOf(str2) + TbadkApplication.m252getInst().getApp().getApplicationContext().getString(com.baidu.tieba.x.validate_im_apply_prefix1) + str3);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ImMessageCenterPojo a;
        a a2 = a(-3);
        if (a2 != null && (a = a2.a("-1002")) != null) {
            String last_content = a.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    a.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ImMessageCenterPojo a;
        a a2 = a(-5);
        if (a2 != null && (a = a2.a("-1004")) != null) {
            String last_content = a.getLast_content();
            if (!TextUtils.isEmpty(last_content)) {
                try {
                    a.setLast_content(new JSONObject(last_content).optString("userMsg"));
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            a(imMessageCenterPojo.getCustomGroupType()).a(imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo a(String str, int i) {
        a a;
        if (this.a.get() && (a = a(i)) != null) {
            return a.a(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, int i) {
        ImMessageCenterPojo a = a(str, i);
        if (a != null) {
            c(str, i);
            g(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i) {
        a a;
        if (this.a.get() && (a = a(i)) != null) {
            if (i == 9) {
                BdLog.i("quit live group. ");
            }
            a.b(str);
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.a.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                a(imMessageCenterPojo, false, 2);
                a(a(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a(imMessageCenterPojo, false, 2);
                a(b(false), false, 1);
            } else {
                a(imMessageCenterPojo, false, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.a.get()) {
            ImMessageCenterPojo a = a(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (a == null) {
                f(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= a.getLast_rid()) {
                c(a.getGid(), a.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(a.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(a.getGroup_name());
                }
                f(imMessageCenterPojo);
                a(imMessageCenterPojo, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (this.a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo a = a(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (a == null) {
                imMessageCenterPojo.setUnread_count(i);
                f(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                a(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > a.getLast_rid()) {
                a.setLast_rid(imMessageCenterPojo.getLast_rid());
                a.setLast_content(imMessageCenterPojo.getLast_content());
                a.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                a.setUnread_count(a.getUnread_count() + i);
                a.setIs_hidden(0);
                a(a, true);
            }
        }
    }

    private void p() {
        this.c.a();
        this.d.a();
        this.e.a();
        k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ChatMessage chatMessage, String str, int i2) {
        if (this.a.get()) {
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
                ImMessageCenterPojo a = a(str, i);
                if (a == null) {
                    a = new ImMessageCenterPojo();
                    a.setCustomGroupType(i);
                    a.setGid(str);
                    f(a);
                }
                if ((i == 2 || i == 4) && userData != null) {
                    if (!TextUtils.isEmpty(userData.getPortrait())) {
                        a.setGroup_head(userData.getPortrait());
                    }
                    if (!TextUtils.isEmpty(userData.getUserName())) {
                        a.setGroup_name(userData.getUserName());
                    }
                }
                switch (i2) {
                    case 1:
                        a.setLast_content("");
                        a.setLast_rid(0L);
                        a.setSend_status(0);
                        a.setUnread_count(0);
                        break;
                    case 2:
                        if (chatMessage != null) {
                            a.setLast_content_time(chatMessage.getTime() * 1000);
                            a.setLast_content(com.baidu.tieba.im.d.j.a(chatMessage.getMsgType(), chatMessage.getContent()));
                            a.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            a.setLast_rid(chatMessage.getRecordId());
                            a.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            a.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                a.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                                break;
                            }
                        } else {
                            a.setLast_content("");
                            a.setLast_rid(0L);
                            a.setSend_status(0);
                            a.setUnread_count(0);
                            break;
                        }
                        break;
                    case 3:
                        if (chatMessage != null && a.getLast_rid() <= chatMessage.getRecordId()) {
                            a.setLast_content_time(chatMessage.getTime() * 1000);
                            a.setLast_content(com.baidu.tieba.im.d.j.a(chatMessage.getMsgType(), chatMessage.getContent()));
                            a.setLast_user_name(chatMessage.getUserInfo().getUserName());
                            a.setLast_rid(chatMessage.getRecordId());
                            a.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                            a.setIsFriend(chatMessage.getIsFriend());
                            if (chatMessage.getLocalData() != null) {
                                a.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                            }
                        }
                        a.setIs_hidden(0);
                        break;
                }
                BdLog.i("send message status " + a.getSend_status());
                a(a, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo b(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo a = a(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (a == null) {
                f(imMessageCenterPojo);
                return imMessageCenterPojo;
            }
            c(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            imMessageCenterPojo.setPulled_msgId(a.getPulled_msgId());
            f(imMessageCenterPojo);
            return imMessageCenterPojo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImMessageCenterPojo imMessageCenterPojo) {
        a(b(imMessageCenterPojo), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        ImMessageCenterPojo a = a(str, 1);
        if (a != null) {
            a.setGroup_head(str2);
            a(a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2) {
        ImMessageCenterPojo a = a(str, 1);
        if (a != null) {
            a.setGroup_name(str2);
            a(a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo a = a(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (a == null) {
                f(imMessageCenterPojo);
                return;
            }
            a.setGroup_head(imMessageCenterPojo.getGroup_head());
            a.setGroup_name(imMessageCenterPojo.getGroup_name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.a.get()) {
            this.c.a(new n(this));
            this.d.a(new o(this));
            this.e.a(new p(this));
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.a.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid()) && a(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType()) == null) {
            f(imMessageCenterPojo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j, String str) {
        if (this.a.get()) {
            ImMessageCenterPojo a = a(str, i);
            if (a == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i);
                imMessageCenterPojo.setPulled_msgId(j);
                imMessageCenterPojo.setGid(str);
                f(imMessageCenterPojo);
            } else if (a.getPulled_msgId() < j) {
                a.setPulled_msgId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImMessageCenterPojo a(String str, int i, boolean z) {
        ImMessageCenterPojo a = a(str, i);
        if (a != null) {
            if (z) {
                a.setIs_hidden(0);
            } else {
                a.setIs_hidden(1);
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, int i, boolean z) {
        ImMessageCenterPojo a = a(str, i, z);
        if (a != null) {
            a(a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, int i) {
        ImMessageCenterPojo a = a(str, i);
        if (a != null) {
            a.setUnread_count(0);
            a(a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> f() {
        LinkedList linkedList = new LinkedList();
        this.c.a(new q(this, linkedList));
        this.d.a(new r(this, linkedList));
        this.e.a(new s(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> g() {
        LinkedList linkedList = new LinkedList();
        this.c.a(new t(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> h() {
        LinkedList linkedList = new LinkedList();
        this.e.a(new e(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> i() {
        LinkedList linkedList = new LinkedList();
        this.d.a(new f(this, linkedList));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ImMessageCenterPojo> j() {
        LinkedList linkedList = new LinkedList();
        this.d.a(new g(this, linkedList));
        return linkedList;
    }

    void k() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016000));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i));
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.a.get()) {
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
        a(a(z), z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo a(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a a = a(-7);
        if (a != null) {
            imMessageCenterPojo = a.a("-1001");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1001");
            imMessageCenterPojo.setCustomGroupType(-7);
            f(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.d.a(new h(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                ImMessageCenterPojo a2 = a("-1001", -7);
                if (a2 != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new i(this, a2));
                    customMessageTask.setParallel(com.baidu.tbadk.k.b());
                    customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        } else if (z) {
            if (StrangerListActivity.a) {
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
    public ImMessageCenterPojo b(boolean z) {
        ImMessageCenterPojo imMessageCenterPojo = null;
        a a = a(-8);
        if (a != null) {
            imMessageCenterPojo = a.a("-1000");
        }
        if (imMessageCenterPojo == null) {
            imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid("-1000");
            imMessageCenterPojo.setCustomGroupType(-8);
            f(imMessageCenterPojo);
        }
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setIs_hidden(1);
        this.e.a(new j(this, imMessageCenterPojo2));
        imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
        imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
        imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
        imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
        if (imMessageCenterPojo2.getIs_hidden() == 1) {
            imMessageCenterPojo.setUnread_count(0);
            if (imMessageCenterPojo.getIs_hidden() != 1) {
                imMessageCenterPojo.setIs_hidden(1);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new k(this));
                customMessageTask.setParallel(com.baidu.tbadk.k.b());
                customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        } else if (z) {
            if (OfficialBarTipActivity.a) {
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
        a(b(z), z, i);
    }

    public SparseArray<Long> l() {
        SparseArray<Long> sparseArray = new SparseArray<>();
        if (this.a.get()) {
            this.c.a(new l(this, sparseArray));
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        return imMessageCenterPojo.getCustomGroupType() == 1 || imMessageCenterPojo.getCustomGroupType() == 9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == 3 || imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == 8 || imMessageCenterPojo.getCustomGroupType() == 7 || imMessageCenterPojo.getCustomGroupType() == 6;
    }

    public long e(String str, int i) {
        ImMessageCenterPojo a = a(str, i);
        if (a != null) {
            return a.getPulled_msgId();
        }
        return 0L;
    }

    private a a(int i) {
        if (i == 2) {
            return this.d;
        }
        if (i == 4) {
            return this.e;
        }
        return this.c;
    }
}
