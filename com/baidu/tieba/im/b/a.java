package com.baidu.tieba.im.b;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.tieba.im.f.r;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends c {
    private static a c;
    private String d = x.a + File.separator + TbConfig.getTempDirName() + File.separator + "GroupChatMemoryCache.";

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    private a() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, int i, CommonMsgPojo commonMsgPojo, boolean z) {
        boolean z2;
        ImMessageCenterPojo a;
        boolean z3;
        OldUserData oldUserData;
        if (commonMsgPojo != null) {
            String i2 = r.i(commonMsgPojo.toChatMessage());
            UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
            String str2 = "";
            if (userData != null) {
                if (com.baidu.adp.lib.util.g.b(userData.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) OldUserData.class)) != null) {
                    oldUserData.setToUserData(userData);
                }
                str2 = userData.getUserName();
                if (TbadkApplication.isLogin()) {
                    String currentAccount = TbadkApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(userData.getUserId()))) {
                        z2 = true;
                        if (BdLog.isDebugMode()) {
                            BdLog.d("see gid:" + str + " content:" + i2);
                            BdLog.d("see pojo1:" + commonMsgPojo);
                        }
                        a = a(str);
                        if (a == null) {
                            long rid = commonMsgPojo.getRid();
                            long last_rid = a.getLast_rid();
                            BdLog.d("gid:" + str + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + a.getUnread_count() + " add unread:" + i + "content:" + commonMsgPojo + " readableContent:" + i2);
                            if (rid > last_rid) {
                                a.setLast_rid(rid);
                                a.setLast_content(i2);
                                a.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                                a.setLast_user_name(str2);
                                if (last_rid < rid) {
                                    a.setLast_rid(rid);
                                    a.setUnread_count(a.getUnread_count() + i);
                                }
                                if (i > 0) {
                                    z3 = true;
                                } else if (!z2) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    a.setIs_hidden(0);
                                    com.baidu.tieba.im.i.a(new b(this, str), null);
                                    return;
                                }
                                return;
                            }
                            BdLog.d("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + commonMsgPojo.getContent());
                            return;
                        }
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        imMessageCenterPojo.setGid(str);
                        imMessageCenterPojo.setLast_content(i2);
                        imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                        imMessageCenterPojo.setLast_user_name(str2);
                        imMessageCenterPojo.setLast_rid(commonMsgPojo.getMid());
                        imMessageCenterPojo.setPulled_msgId(commonMsgPojo.getMid());
                        imMessageCenterPojo.setUnread_count(i);
                        imMessageCenterPojo.setIs_hidden(z ? 1 : 0);
                        a(imMessageCenterPojo);
                        return;
                    }
                }
            }
            z2 = false;
            if (BdLog.isDebugMode()) {
            }
            a = a(str);
            if (a == null) {
            }
        }
    }

    @Override // com.baidu.tieba.im.b.c
    protected void b() {
        String str;
        OldUserData oldUserData;
        LinkedList<ImMessageCenterPojo> b = com.baidu.tieba.im.db.h.a().b();
        if (b != null) {
            Iterator<ImMessageCenterPojo> it = b.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                next.setUnread_count(com.baidu.tieba.im.db.c.a().a(next.getGid()));
                next.setPulled_msgId(com.baidu.tieba.im.db.c.a().c(next.getGid()));
                CommonMsgPojo d = com.baidu.tieba.im.db.c.a().d(next.getGid());
                if (d != null) {
                    d.checkRidAndSelf();
                    String i = r.i(d.toChatMessage());
                    UserData userData = (UserData) new Gson().fromJson(d.getUser_info(), (Class<Object>) UserData.class);
                    if (userData == null) {
                        str = "";
                    } else {
                        if (com.baidu.adp.lib.util.g.b(userData.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(d.getUser_info(), (Class<Object>) OldUserData.class)) != null) {
                            oldUserData.setToUserData(userData);
                        }
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
                a(next);
            }
        }
    }

    public void c() {
        if (x.a()) {
            this.b.a(new File(String.valueOf(this.d) + TbadkApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.im.b.c
    public void d() {
        if (x.a()) {
            this.b.b(new File(String.valueOf(this.d) + TbadkApplication.getCurrentAccount()));
        }
    }
}
