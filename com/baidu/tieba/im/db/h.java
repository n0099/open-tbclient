package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class h {
    private static h a = new h();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final d c = new d();

    private h() {
    }

    public static h a() {
        return a;
    }

    public final boolean b() {
        return this.b.get();
    }

    public final synchronized void c() {
        ImMessageCenterPojo a2;
        this.b.set(false);
        this.c.a();
        k.a();
        LinkedList<ImMessageCenterPojo> b = k.b();
        if (b != null) {
            Iterator<ImMessageCenterPojo> it = b.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                next.setUnread_count(b.a().a(next.getGid()));
                next.setPulled_msgId(b.a().c(next.getGid()));
                CommonMsgPojo d = b.a().d(next.getGid());
                if (d != null) {
                    d.checkRidAndSelf();
                    String h = com.baidu.tieba.im.util.l.h(d.toChatMessage());
                    UserData userData = (UserData) new Gson().fromJson(d.getUser_info(), (Class<Object>) UserData.class);
                    String userName = userData != null ? userData.getUserName() : "";
                    next.setLast_content(h);
                    next.setLast_user_name(userName);
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
        com.baidu.adp.lib.util.e.e("see init private chat begin ");
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(com.baidu.tieba.im.chat.q.a));
        imMessageCenterPojo.setGroup_type(6);
        q.a();
        for (String str : q.c()) {
            com.baidu.adp.lib.util.e.e("see init private chat id:" + str);
            if (!TextUtils.isEmpty(str)) {
                long b2 = q.a().b(str);
                if (b2 > imMessageCenterPojo.getPulled_msgId()) {
                    imMessageCenterPojo.setPulled_msgId(b2);
                }
                CommonMsgPojo c = q.a().c(str);
                if (c == null) {
                    com.baidu.adp.lib.util.e.e("see init private chat cmpojo null id:" + str);
                } else {
                    ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(c);
                    if (fromCommonMsg == null) {
                        com.baidu.adp.lib.util.e.e("see init private chat person null id:" + str);
                    } else {
                        this.c.a(fromCommonMsg);
                        if (c.getRid() > imMessageCenterPojo.getLast_rid()) {
                            imMessageCenterPojo.setLast_rid(c.getRid());
                        }
                        String b3 = k.b(str);
                        if (b3 != null && (a2 = this.c.a(b3)) != null) {
                            imMessageCenterPojo.setIs_hidden(a2.getIs_hidden());
                            fromCommonMsg.setIs_hidden(a2.getIs_hidden());
                        }
                    }
                }
            }
        }
        this.c.a(imMessageCenterPojo);
        this.b.set(true);
    }

    public final synchronized d d() {
        if (Thread.currentThread().getId() != com.baidu.tieba.im.e.a) {
            com.baidu.adp.lib.util.e.b("!!!!!!!!!!!!!!!获取缓存不是在主线程里面执行了！");
            if (com.baidu.tieba.data.i.F()) {
                new RuntimeException().printStackTrace();
            }
        }
        return this.c;
    }

    public final void e() {
        this.c.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, int i, CommonMsgPojo commonMsgPojo) {
        boolean z;
        ImMessageCenterPojo a2;
        boolean z2;
        OldUserData oldUserData;
        if (commonMsgPojo != null) {
            String h = com.baidu.tieba.im.util.l.h(commonMsgPojo.toChatMessage());
            UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
            String str2 = "";
            if (userData != null) {
                if (com.baidu.adp.lib.util.g.b(userData.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) OldUserData.class)) != null) {
                    oldUserData.setToUserData(userData);
                }
                str2 = userData.getUserName();
                if (TiebaApplication.w()) {
                    String v = TiebaApplication.v();
                    if (!TextUtils.isEmpty(v) && v.equals(String.valueOf(userData.getUserId()))) {
                        z = true;
                        com.baidu.adp.lib.util.e.e("see gid:" + str + " content:" + h);
                        com.baidu.adp.lib.util.e.e("see pojo1:" + commonMsgPojo);
                        a2 = this.c.a(str);
                        if (a2 == null) {
                            if (a2.getGroup_type() == 6) {
                                com.baidu.adp.lib.util.e.e("see private group found in mem");
                            }
                            long rid = commonMsgPojo.getRid();
                            long last_rid = a2.getLast_rid();
                            com.baidu.adp.lib.util.e.e("gid:" + str + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + a2.getUnread_count() + " add unread:" + i + "content:" + commonMsgPojo + " readableContent:" + h);
                            if (rid > last_rid) {
                                a2.setLast_rid(rid);
                                a2.setLast_content(h);
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
                                    com.baidu.tieba.im.i.a(new i(this, str), null);
                                    return;
                                }
                                return;
                            }
                            com.baidu.adp.lib.util.e.e("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + commonMsgPojo.getContent());
                            return;
                        } else if (commonMsgPojo.isPrivate()) {
                            com.baidu.adp.lib.util.e.e("see add private chat");
                            ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(commonMsgPojo);
                            if (fromCommonMsg != null) {
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(fromCommonMsg.getGid());
                                com.baidu.tieba.im.i.a(new j(this, linkedList), null);
                                new LinkedList().add(commonMsgPojo);
                                fromCommonMsg.setUnread_count(i);
                                this.c.a(fromCommonMsg);
                                return;
                            }
                            return;
                        } else {
                            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setGid(str);
                            imMessageCenterPojo.setLast_content(h);
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
            com.baidu.adp.lib.util.e.e("see gid:" + str + " content:" + h);
            com.baidu.adp.lib.util.e.e("see pojo1:" + commonMsgPojo);
            a2 = this.c.a(str);
            if (a2 == null) {
            }
        }
    }
}
