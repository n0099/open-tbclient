package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class h {
    private static h a = new h();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final d c = new d();

    private h() {
    }

    public static h a() {
        return a;
    }

    public boolean b() {
        return this.b.get();
    }

    public synchronized void c() {
        this.b.set(false);
        this.c.a();
        f();
        g();
        this.b.set(true);
    }

    public synchronized d d() {
        if (Thread.currentThread().getId() != com.baidu.tieba.im.f.a) {
            com.baidu.adp.lib.util.f.b("!!!!!!!!!!!!!!!获取缓存不是在主线程里面执行了！");
            if (com.baidu.tieba.data.i.F()) {
                new RuntimeException().printStackTrace();
            }
        }
        return this.c;
    }

    public void e() {
        this.c.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, int i, CommonMsgPojo commonMsgPojo) {
        boolean z;
        String str2;
        ImMessageCenterPojo a2;
        boolean z2;
        if (commonMsgPojo != null) {
            String i2 = com.baidu.tieba.im.util.l.i(commonMsgPojo.toChatMessage());
            UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
            String str3 = "";
            if (userData != null) {
                str3 = userData.getUserName();
                if (TiebaApplication.B()) {
                    String A = TiebaApplication.A();
                    if (!TextUtils.isEmpty(A) && A.equals(String.valueOf(userData.getUserId()))) {
                        z = true;
                        str2 = str3;
                        com.baidu.adp.lib.util.f.e("see gid:" + str + " content:" + i2);
                        com.baidu.adp.lib.util.f.e("see pojo1:" + commonMsgPojo);
                        a2 = this.c.a(str);
                        if (a2 == null) {
                            if (a2.getGroup_type() == 6) {
                                com.baidu.adp.lib.util.f.e("see private group found in mem");
                            }
                            long rid = commonMsgPojo.getRid();
                            long last_rid = a2.getLast_rid();
                            com.baidu.adp.lib.util.f.e("gid:" + str + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + a2.getUnread_count() + " add unread:" + i + "content:" + commonMsgPojo + " readableContent:" + i2);
                            if (rid > last_rid) {
                                a2.setLast_rid(rid);
                                a2.setLast_content(i2);
                                a2.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                                a2.setLast_user_name(str2);
                                if (last_rid < rid) {
                                    a2.setLast_rid(rid);
                                    a2.setUnread_count(a2.getUnread_count() + i);
                                }
                                if (i > 0) {
                                    z2 = true;
                                } else if (!z) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    a2.setIs_hidden(0);
                                    com.baidu.tieba.im.j.a(new i(this, str), null);
                                    return;
                                }
                                return;
                            }
                            com.baidu.adp.lib.util.f.e("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + commonMsgPojo.getContent());
                            return;
                        } else if (commonMsgPojo.isPrivate()) {
                            com.baidu.adp.lib.util.f.e("see add private chat");
                            ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(commonMsgPojo);
                            if (fromCommonMsg != null) {
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(fromCommonMsg.getGid());
                                com.baidu.tieba.im.j.a(new j(this, linkedList), null);
                                new LinkedList().add(commonMsgPojo);
                                fromCommonMsg.setUnread_count(i);
                                this.c.a(fromCommonMsg);
                                return;
                            }
                            return;
                        } else {
                            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setGid(str);
                            imMessageCenterPojo.setLast_content(i2);
                            imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                            imMessageCenterPojo.setLast_user_name(str2);
                            imMessageCenterPojo.setLast_rid(commonMsgPojo.getMid());
                            imMessageCenterPojo.setPulled_msgId(commonMsgPojo.getMid());
                            imMessageCenterPojo.setUnread_count(i);
                            this.c.a(imMessageCenterPojo);
                            return;
                        }
                    }
                }
            }
            z = false;
            str2 = str3;
            com.baidu.adp.lib.util.f.e("see gid:" + str + " content:" + i2);
            com.baidu.adp.lib.util.f.e("see pojo1:" + commonMsgPojo);
            a2 = this.c.a(str);
            if (a2 == null) {
            }
        }
    }

    private void f() {
        String str;
        LinkedList<ImMessageCenterPojo> b = k.a().b();
        if (b != null) {
            Iterator<ImMessageCenterPojo> it = b.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                next.setUnread_count(b.a().a(next.getGid()));
                next.setPulled_msgId(b.a().c(next.getGid()));
                CommonMsgPojo d = b.a().d(next.getGid());
                if (d != null) {
                    d.checkRidAndSelf();
                    String i = com.baidu.tieba.im.util.l.i(d.toChatMessage());
                    UserData userData = (UserData) new Gson().fromJson(d.getUser_info(), (Class<Object>) UserData.class);
                    if (userData == null) {
                        str = "";
                    } else {
                        str = userData.getUserName();
                    }
                    next.setLast_content(i);
                    next.setLast_user_name(str);
                    next.setLast_rid(d.getRid());
                    next.setLast_content_time(d.getCreate_time() * 1000);
                } else {
                    next.setLast_content("");
                    next.setPulled_msgId(0L);
                    next.setLast_rid(0L);
                    next.setLast_user_name("");
                    next.setLast_content_time(0L);
                }
                this.c.a(next);
            }
        }
    }

    private void g() {
        ImMessageCenterPojo a2;
        com.baidu.adp.lib.util.f.e("see init private chat begin ");
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(com.baidu.tieba.im.chat.q.a));
        imMessageCenterPojo.setGroup_type(6);
        for (String str : q.a().c()) {
            com.baidu.adp.lib.util.f.e("see init private chat id:" + str);
            if (!TextUtils.isEmpty(str)) {
                long b = q.a().b(str);
                if (b > imMessageCenterPojo.getPulled_msgId()) {
                    imMessageCenterPojo.setPulled_msgId(b);
                }
                CommonMsgPojo c = q.a().c(str);
                if (c == null) {
                    com.baidu.adp.lib.util.f.e("see init private chat cmpojo null id:" + str);
                } else {
                    ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(c);
                    if (fromCommonMsg == null) {
                        com.baidu.adp.lib.util.f.e("see init private chat person null id:" + str);
                    } else {
                        this.c.a(fromCommonMsg);
                        if (c.getRid() > imMessageCenterPojo.getLast_rid()) {
                            imMessageCenterPojo.setLast_rid(c.getRid());
                        }
                        String b2 = k.b(str);
                        if (b2 != null && (a2 = this.c.a(b2)) != null) {
                            imMessageCenterPojo.setIs_hidden(a2.getIs_hidden());
                            fromCommonMsg.setIs_hidden(a2.getIs_hidden());
                        }
                    }
                }
            }
        }
        this.c.a(imMessageCenterPojo);
    }
}
