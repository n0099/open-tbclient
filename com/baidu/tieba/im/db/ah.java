package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupMsgPojo f1657a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ com.baidu.tieba.im.a d;
    final /* synthetic */ ag e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, GroupMsgPojo groupMsgPojo, String str, int i, com.baidu.tieba.im.a aVar) {
        this.e = agVar;
        this.f1657a = groupMsgPojo;
        this.b = str;
        this.c = i;
        this.d = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        boolean z;
        boolean z2 = true;
        String g = com.baidu.tieba.im.e.d.g(this.f1657a.toChatMessage());
        UserData userData = (UserData) new Gson().fromJson(this.f1657a.getUser_info(), (Class<Object>) UserData.class);
        String str = "";
        if (userData != null) {
            str = userData.getName();
            if (TiebaApplication.C()) {
                String B = TiebaApplication.B();
                if (!TextUtils.isEmpty(B) && B.equals(String.valueOf(userData.getId()))) {
                    z = true;
                    if (concurrentHashMap.get(this.b) == null) {
                        long rid = this.f1657a.getRid();
                        long last_rid = concurrentHashMap.get(this.b).getLast_rid();
                        if (rid > last_rid) {
                            concurrentHashMap.get(this.b).setLast_rid(rid);
                            concurrentHashMap.get(this.b).setLast_content(g);
                            concurrentHashMap.get(this.b).setLast_content_time(this.f1657a.getCreate_time() * 1000);
                            concurrentHashMap.get(this.b).setLast_user_name(str);
                            com.baidu.adp.lib.h.e.d("gid:" + this.b + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + concurrentHashMap.get(this.b).getUnread_count() + " add unread:" + this.c + "content:" + this.f1657a + " readableContent:" + g);
                            if (last_rid < rid) {
                                concurrentHashMap.get(this.b).setLast_rid(rid);
                                concurrentHashMap.get(this.b).setUnread_count(concurrentHashMap.get(this.b).getUnread_count() + this.c);
                            }
                            if (this.c <= 0 && !z) {
                                z2 = false;
                            }
                            if (z2) {
                                concurrentHashMap.get(this.b).setIs_hidden(0);
                            }
                        } else {
                            com.baidu.adp.lib.h.e.d("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + this.f1657a.getContent());
                        }
                    } else {
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        imMessageCenterPojo.setGid(this.b);
                        imMessageCenterPojo.setLast_content(g);
                        imMessageCenterPojo.setLast_content_time(this.f1657a.getCreate_time() * 1000);
                        imMessageCenterPojo.setLast_user_name(str);
                        imMessageCenterPojo.setLast_rid(this.f1657a.getMid());
                        imMessageCenterPojo.setPulled_msgId(this.f1657a.getMid());
                        imMessageCenterPojo.setUnread_count(this.c);
                        concurrentHashMap.put(this.b, imMessageCenterPojo);
                    }
                    if (this.d == null) {
                        this.d.a(null);
                        return;
                    }
                    return;
                }
            }
        }
        z = false;
        if (concurrentHashMap.get(this.b) == null) {
        }
        if (this.d == null) {
        }
    }
}
