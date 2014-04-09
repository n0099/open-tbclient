package com.baidu.tieba.im.b;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.tieba.im.f.q;
import com.baidu.tieba.im.r;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class a extends c {
    private static a a;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    private a() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, int i, CommonMsgPojo commonMsgPojo) {
        boolean z;
        ImMessageCenterPojo a2;
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
                        a2 = a(str);
                        if (a2 == null) {
                            long rid = commonMsgPojo.getRid();
                            long last_rid = a2.getLast_rid();
                            com.baidu.adp.lib.util.f.e("gid:" + str + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + a2.getUnread_count() + " add unread:" + i + "content:" + commonMsgPojo + " readableContent:" + h);
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
                                    r.a(new b(this, str), null);
                                    return;
                                }
                                return;
                            }
                            com.baidu.adp.lib.util.f.e("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + commonMsgPojo.getContent());
                            return;
                        }
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        imMessageCenterPojo.setGid(str);
                        imMessageCenterPojo.setLast_content(h);
                        imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                        imMessageCenterPojo.setLast_user_name(str2);
                        imMessageCenterPojo.setLast_rid(commonMsgPojo.getMid());
                        imMessageCenterPojo.setPulled_msgId(commonMsgPojo.getMid());
                        imMessageCenterPojo.setUnread_count(i);
                        a(imMessageCenterPojo);
                        return;
                    }
                }
            }
            z = false;
            if (com.baidu.adp.lib.util.f.a()) {
            }
            a2 = a(str);
            if (a2 == null) {
            }
        }
    }

    @Override // com.baidu.tieba.im.b.c
    protected final void b() {
        String str;
        OldUserData oldUserData;
        com.baidu.tieba.im.db.h.a();
        LinkedList<ImMessageCenterPojo> b = com.baidu.tieba.im.db.h.b();
        if (b != null) {
            Iterator<ImMessageCenterPojo> it = b.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                next.setUnread_count(com.baidu.tieba.im.db.c.a().a(next.getGid()));
                next.setPulled_msgId(com.baidu.tieba.im.db.c.a().c(next.getGid()));
                CommonMsgPojo d = com.baidu.tieba.im.db.c.a().d(next.getGid());
                if (d != null) {
                    d.checkRidAndSelf();
                    String h = q.h(d.toChatMessage());
                    UserData userData = (UserData) new Gson().fromJson(d.getUser_info(), (Class<Object>) UserData.class);
                    if (userData == null) {
                        str = "";
                    } else {
                        if (com.baidu.adp.lib.util.h.b(userData.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(d.getUser_info(), (Class<Object>) OldUserData.class)) != null) {
                            oldUserData.setToUserData(userData);
                        }
                        str = userData.getUserName();
                    }
                    next.setLast_content(h);
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
                a(next);
            }
        }
    }
}
