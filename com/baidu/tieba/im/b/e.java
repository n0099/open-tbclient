package com.baidu.tieba.im.b;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.ac;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.db.p;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.tieba.im.e.r;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    public static final AtomicBoolean a = new AtomicBoolean(false);

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

    public static void c() {
        long a2 = ac.a().a(11);
        long a3 = ac.a().a(12);
        if (a2 != -1) {
            com.baidu.tbadk.coreExtra.messageCenter.e.a().a(11, a2);
        }
        if (a3 != -1) {
            com.baidu.tbadk.coreExtra.messageCenter.e.a().a(12, a3);
        }
    }

    public static boolean d() {
        com.baidu.adp.lib.util.j.a();
        if (TbadkApplication.isLogin()) {
            return a.a().a.get() && k.a().a.get() && j.a().a.get();
        }
        return true;
    }

    public static ImMessageCenterPojo a(String str) {
        ArrayList<c> arrayList = new ArrayList();
        arrayList.add(a.a());
        arrayList.add(k.a());
        arrayList.add(j.a());
        for (c cVar : arrayList) {
            ImMessageCenterPojo a2 = cVar.a(str);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
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
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(c cVar, String str, int i, CommonMsgPojo commonMsgPojo) {
        boolean z;
        ImMessageCenterPojo a2;
        boolean z2;
        OldUserData oldUserData;
        if (commonMsgPojo != null) {
            String i2 = r.i(commonMsgPojo.toChatMessage());
            UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
            String str2 = "";
            if (userData != null) {
                if (com.baidu.adp.lib.util.i.b(userData.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) OldUserData.class)) != null) {
                    oldUserData.setToUserData(userData);
                }
                str2 = userData.getUserName();
                if (TbadkApplication.isLogin()) {
                    String currentAccount = TbadkApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(userData.getUserId()))) {
                        z = true;
                        a2 = cVar.a(str);
                        if (a2 == null) {
                            long rid = commonMsgPojo.getRid();
                            long last_rid = a2.getLast_rid();
                            if (rid >= last_rid) {
                                a2.setLast_rid(rid);
                                a2.setLast_content(i2);
                                a2.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                                a2.setLast_user_name(str2);
                                a2.setSelf(commonMsgPojo.isSelf());
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
                                    com.baidu.tieba.im.i.a(new h(str), null);
                                }
                            }
                            com.baidu.tieba.im.stranger.a.a(a2, commonMsgPojo.getIsFriend());
                            return;
                        }
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
            a2 = cVar.a(str);
            if (a2 == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(c cVar) {
        ImMessageCenterPojo fromCommonMsg;
        ImMessageCenterPojo b;
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(w.a));
        imMessageCenterPojo.setCustomGroupType(2);
        for (String str : p.d().b()) {
            if (!TextUtils.isEmpty(str)) {
                long c = p.d().c(str);
                if (c > imMessageCenterPojo.getPulled_msgId()) {
                    imMessageCenterPojo.setPulled_msgId(c);
                }
                CommonMsgPojo d = p.d().d(str);
                if (d != null && (fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(d)) != null) {
                    fromCommonMsg.setUnread_count(p.d().a(str));
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
        cVar.a(imMessageCenterPojo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(c cVar) {
        ImMessageCenterPojo b;
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(w.a));
        imMessageCenterPojo.setCustomGroupType(4);
        for (String str : o.d().b()) {
            if (!TextUtils.isEmpty(str)) {
                long c = o.d().c(str);
                if (c > imMessageCenterPojo.getPulled_msgId()) {
                    imMessageCenterPojo.setPulled_msgId(c);
                }
                CommonMsgPojo d = o.d().d(str);
                if (d != null) {
                    d.checkRidAndSelf();
                    ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(d);
                    if (fromCommonMsg != null) {
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

    public static void a(int i, ChatMessage chatMessage, String str) {
        c a2;
        ImMessageCenterPojo a3;
        if (chatMessage != null && !TextUtils.isEmpty(str) && (a2 = a(i)) != null && (a3 = a2.a(str)) != null && a3.getLast_rid() <= chatMessage.getRecordId()) {
            a3.setLast_content_time(chatMessage.getTime() * 1000);
            a3.setLast_content(r.i(chatMessage));
            a3.setLast_user_name(chatMessage.getUserInfo().getUserName());
            a3.setLast_rid(chatMessage.getRecordId());
        }
    }

    private static c a(int i) {
        switch (i) {
            case 1:
                return a.a();
            case 2:
                return k.a();
            case 3:
                return j.a();
            default:
                return null;
        }
    }
}
