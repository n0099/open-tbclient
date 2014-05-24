package com.baidu.tieba.im.b;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.ab;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.tieba.im.f.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e {
    public static synchronized void a() {
        synchronized (e.class) {
            a.a().f();
            k.a().f();
            j.a().f();
        }
    }

    public static synchronized void b() {
        synchronized (e.class) {
            a.a().e();
            k.a().e();
            j.a().e();
            f fVar = new f();
            g gVar = new g();
            a.a().a(fVar);
            k.a().a(gVar);
            j.a().a(gVar);
        }
    }

    public static synchronized void c() {
        synchronized (e.class) {
            long a = ab.a().a(11);
            long a2 = ab.a().a(12);
            if (a != -1) {
                com.baidu.tbadk.coreExtra.messageCenter.e.a().a(11, a);
            }
            if (a2 != -1) {
                com.baidu.tbadk.coreExtra.messageCenter.e.a().a(12, a2);
            }
        }
    }

    public static boolean d() {
        com.baidu.adp.lib.util.k.b();
        if (TbadkApplication.isLogin()) {
            return a.a().a.get() && k.a().a.get() && j.a().a.get();
        }
        return true;
    }

    public static synchronized ImMessageCenterPojo a(String str) {
        ImMessageCenterPojo imMessageCenterPojo;
        synchronized (e.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.a());
            arrayList.add(k.a());
            arrayList.add(j.a());
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    imMessageCenterPojo = ((c) it.next()).a(str);
                    if (imMessageCenterPojo != null) {
                        break;
                    }
                } else {
                    imMessageCenterPojo = null;
                    break;
                }
            }
        }
        return imMessageCenterPojo;
    }

    public static void a(d dVar) {
        ArrayList<c> arrayList = new ArrayList();
        arrayList.add(a.a());
        arrayList.add(k.a());
        arrayList.add(j.a());
        for (c cVar : arrayList) {
            cVar.a(dVar);
        }
    }

    public static synchronized void e() {
        synchronized (e.class) {
            a.a().g();
            k.a().g();
            j.a().g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(c cVar, String str, int i, CommonMsgPojo commonMsgPojo) {
        boolean z;
        ImMessageCenterPojo a;
        boolean z2;
        OldUserData oldUserData;
        if (commonMsgPojo != null) {
            String i2 = r.i(commonMsgPojo.toChatMessage());
            UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
            String str2 = "";
            if (userData != null) {
                if (com.baidu.adp.lib.util.j.b(userData.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) OldUserData.class)) != null) {
                    oldUserData.setToUserData(userData);
                }
                str2 = userData.getUserName();
                if (TbadkApplication.isLogin()) {
                    String currentAccount = TbadkApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(userData.getUserId()))) {
                        z = true;
                        if (BdLog.isDebugMode()) {
                            BdLog.d("see gid:" + str + " content:" + i2);
                            BdLog.d("see pojo1:" + commonMsgPojo);
                        }
                        a = cVar.a(str);
                        if (a == null) {
                            BdLog.d("see private group found in mem");
                            long rid = commonMsgPojo.getRid();
                            long last_rid = a.getLast_rid();
                            BdLog.d("gid:" + str + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + a.getUnread_count() + " add unread:" + i + "content:" + commonMsgPojo + " readableContent:" + i2);
                            if (rid > last_rid) {
                                a.setLast_rid(rid);
                                a.setLast_content(i2);
                                a.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                                a.setLast_user_name(str2);
                                a.setSelf(commonMsgPojo.isSelf());
                                if (last_rid < rid) {
                                    a.setLast_rid(rid);
                                    a.setUnread_count(a.getUnread_count() + i);
                                }
                                if (i > 0) {
                                    z2 = true;
                                } else if (!z) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    a.setIs_hidden(0);
                                    com.baidu.tieba.im.i.a(new h(str), null);
                                    return;
                                }
                                return;
                            }
                            BdLog.d("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + commonMsgPojo.getContent());
                            return;
                        }
                        BdLog.d("see add private chat");
                        ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(commonMsgPojo);
                        if (fromCommonMsg != null) {
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(fromCommonMsg.getGid());
                            com.baidu.tieba.im.i.a(new i(linkedList), null);
                            new LinkedList().add(commonMsgPojo);
                            fromCommonMsg.setUnread_count(i);
                            cVar.a(fromCommonMsg);
                            return;
                        }
                        return;
                    }
                }
            }
            z = false;
            if (BdLog.isDebugMode()) {
            }
            a = cVar.a(str);
            if (a == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(c cVar) {
        ImMessageCenterPojo b;
        BdLog.d("see init private chat begin ");
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(w.a));
        imMessageCenterPojo.setCustomGroupType(2);
        for (String str : o.d().b()) {
            BdLog.d("see init private chat id:" + str);
            if (!TextUtils.isEmpty(str)) {
                long c = o.d().c(str);
                if (c > imMessageCenterPojo.getPulled_msgId()) {
                    imMessageCenterPojo.setPulled_msgId(c);
                }
                CommonMsgPojo d = o.d().d(str);
                if (d == null) {
                    BdLog.d("see init private chat cmpojo null id:" + str);
                } else {
                    ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(d);
                    if (fromCommonMsg == null) {
                        BdLog.d("see init private chat person null id:" + str);
                    } else {
                        fromCommonMsg.setUnread_count(o.d().a(str));
                        if (d.getRid() > imMessageCenterPojo.getLast_rid()) {
                            imMessageCenterPojo.setLast_rid(d.getRid());
                        }
                        if (com.baidu.tieba.im.db.h.c(str) != null && (b = com.baidu.tieba.im.db.h.a().b(str)) != null) {
                            imMessageCenterPojo.setIs_hidden(b.getIs_hidden());
                            fromCommonMsg.setIs_hidden(b.getIs_hidden());
                        }
                        cVar.a(fromCommonMsg);
                    }
                }
            }
        }
        cVar.a(imMessageCenterPojo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(c cVar) {
        ImMessageCenterPojo b;
        BdLog.d("see init private chat begin ");
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(w.a));
        imMessageCenterPojo.setCustomGroupType(4);
        for (String str : n.d().b()) {
            BdLog.d("see init private chat id:" + str);
            if (!TextUtils.isEmpty(str)) {
                long c = n.d().c(str);
                if (c > imMessageCenterPojo.getPulled_msgId()) {
                    imMessageCenterPojo.setPulled_msgId(c);
                }
                CommonMsgPojo d = n.d().d(str);
                if (d == null) {
                    BdLog.d("see init private chat cmpojo null id:" + str);
                } else {
                    d.checkRidAndSelf();
                    ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(d);
                    if (fromCommonMsg == null) {
                        BdLog.d("see init private chat person null id:" + str);
                    } else {
                        fromCommonMsg.setUnread_count(n.d().a(str));
                        if (d.getRid() > imMessageCenterPojo.getLast_rid()) {
                            imMessageCenterPojo.setLast_rid(d.getRid());
                        }
                        if (com.baidu.tieba.im.db.h.c(str) != null && (b = com.baidu.tieba.im.db.h.a().b(str)) != null) {
                            imMessageCenterPojo.setIs_hidden(b.getIs_hidden());
                            fromCommonMsg.setIs_hidden(b.getIs_hidden());
                        }
                        cVar.a(fromCommonMsg);
                    }
                }
            }
        }
        cVar.a(imMessageCenterPojo);
    }
}
