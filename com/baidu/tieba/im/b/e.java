package com.baidu.tieba.im.b;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.x;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.tieba.im.f.q;
import com.baidu.tieba.im.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class e {
    public static synchronized void a() {
        synchronized (e.class) {
            a.a().d();
            k.a().d();
            j.a().d();
            f fVar = new f();
            g gVar = new g();
            a.a().a(fVar);
            k.a().a(gVar);
            j.a().a(gVar);
        }
    }

    public static synchronized void b() {
        synchronized (e.class) {
            x.a();
            long a = x.a(11);
            x.a();
            long a2 = x.a(12);
            if (a != -1) {
                com.baidu.tbadk.coreExtra.messageCenter.d.a().a(11, a);
            }
            if (a2 != -1) {
                com.baidu.tbadk.coreExtra.messageCenter.d.a().a(12, a2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (com.baidu.tieba.im.b.j.a().c() != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean c() {
        boolean z = true;
        synchronized (e.class) {
            if (TbadkApplication.F()) {
                if (a.a().c() && k.a().c()) {
                }
                z = false;
            }
        }
        return z;
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

    public static synchronized void a(d dVar) {
        synchronized (e.class) {
            ArrayList<c> arrayList = new ArrayList();
            arrayList.add(a.a());
            arrayList.add(k.a());
            arrayList.add(j.a());
            for (c cVar : arrayList) {
                cVar.a(dVar);
            }
        }
    }

    public static synchronized void d() {
        synchronized (e.class) {
            a.a().e();
            k.a().e();
            j.a().e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(c cVar, String str, int i, CommonMsgPojo commonMsgPojo) {
        boolean z;
        ImMessageCenterPojo a;
        boolean z2;
        OldUserData oldUserData;
        if (commonMsgPojo != null) {
            String h = q.h(commonMsgPojo.toChatMessage());
            UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
            String str2 = "";
            if (userData != null) {
                if (com.baidu.adp.lib.util.h.b(userData.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) OldUserData.class)) != null) {
                    oldUserData.setToUserData(userData);
                }
                str2 = userData.getUserName();
                if (TbadkApplication.F()) {
                    String E = TbadkApplication.E();
                    if (!TextUtils.isEmpty(E) && E.equals(String.valueOf(userData.getUserId()))) {
                        z = true;
                        if (com.baidu.adp.lib.util.f.a()) {
                            com.baidu.adp.lib.util.f.e("see gid:" + str + " content:" + h);
                            com.baidu.adp.lib.util.f.e("see pojo1:" + commonMsgPojo);
                        }
                        a = cVar.a(str);
                        if (a == null) {
                            com.baidu.adp.lib.util.f.e("see private group found in mem");
                            long rid = commonMsgPojo.getRid();
                            long last_rid = a.getLast_rid();
                            com.baidu.adp.lib.util.f.e("gid:" + str + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + a.getUnread_count() + " add unread:" + i + "content:" + commonMsgPojo + " readableContent:" + h);
                            if (rid > last_rid) {
                                a.setLast_rid(rid);
                                a.setLast_content(h);
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
                                    r.a(new h(str), null);
                                    return;
                                }
                                return;
                            }
                            com.baidu.adp.lib.util.f.e("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + commonMsgPojo.getContent());
                            return;
                        }
                        com.baidu.adp.lib.util.f.e("see add private chat");
                        ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(commonMsgPojo);
                        if (fromCommonMsg != null) {
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(fromCommonMsg.getGid());
                            r.a(new i(linkedList), null);
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
            if (com.baidu.adp.lib.util.f.a()) {
            }
            a = cVar.a(str);
            if (a == null) {
            }
        }
    }
}
