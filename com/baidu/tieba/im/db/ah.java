package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ CommonMsgPojo a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ com.baidu.tieba.im.a d;
    final /* synthetic */ ag e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, CommonMsgPojo commonMsgPojo, String str, int i, com.baidu.tieba.im.a aVar) {
        this.e = agVar;
        this.a = commonMsgPojo;
        this.b = str;
        this.c = i;
        this.d = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        String str;
        boolean z;
        String g = com.baidu.tieba.im.d.d.g(this.a.toChatMessage());
        UserData userData = (UserData) new Gson().fromJson(this.a.getUser_info(), (Class<Object>) UserData.class);
        String str2 = "";
        if (userData != null) {
            str2 = userData.getName();
            if (TiebaApplication.C()) {
                String B = TiebaApplication.B();
                if (!TextUtils.isEmpty(B) && B.equals(String.valueOf(userData.getId()))) {
                    str = str2;
                    z = true;
                    com.baidu.adp.lib.h.e.d("see gid:" + this.b + " content:" + g);
                    com.baidu.adp.lib.h.e.d("see pojo1:" + this.a);
                    if (concurrentHashMap.get(this.b) == null) {
                        if (concurrentHashMap.get(this.b).getGroup_type() == 6) {
                            com.baidu.adp.lib.h.e.d("see private group found in mem");
                        }
                        long rid = this.a.getRid();
                        long last_rid = concurrentHashMap.get(this.b).getLast_rid();
                        com.baidu.adp.lib.h.e.d("gid:" + this.b + "curLastMid:" + rid + "orginalLastMid:" + last_rid + " cur unRead:" + concurrentHashMap.get(this.b).getUnread_count() + " add unread:" + this.c + "content:" + this.a + " readableContent:" + g);
                        if (rid > last_rid) {
                            concurrentHashMap.get(this.b).setLast_rid(rid);
                            concurrentHashMap.get(this.b).setLast_content(g);
                            concurrentHashMap.get(this.b).setLast_content_time(this.a.getCreate_time() * 1000);
                            concurrentHashMap.get(this.b).setLast_user_name(str);
                            if (last_rid < rid) {
                                concurrentHashMap.get(this.b).setLast_rid(rid);
                                concurrentHashMap.get(this.b).setUnread_count(concurrentHashMap.get(this.b).getUnread_count() + this.c);
                            }
                            boolean z2 = false;
                            if (this.c > 0) {
                                z2 = true;
                            } else if (z) {
                                z2 = true;
                            }
                            if (z2) {
                                concurrentHashMap.get(this.b).setIs_hidden(0);
                            }
                        } else {
                            com.baidu.adp.lib.h.e.d("curRid(" + rid + ") <= orginalLastRid(" + last_rid + "), 所以没有更新消息中心。消息： " + this.a.getContent());
                        }
                    } else if (this.a.isPrivate()) {
                        com.baidu.adp.lib.h.e.d("see add private chat");
                        ImMessageCenterPojo a = ad.a(this.a);
                        if (a != null) {
                            LinkedList<String> linkedList = new LinkedList<>();
                            linkedList.add(a.getGid());
                            ar.a().a(linkedList, (com.baidu.tieba.im.a<Void>) null);
                            new LinkedList().add(this.a);
                            a.setUnread_count(this.c);
                            concurrentHashMap.put(this.b, a);
                        } else {
                            return;
                        }
                    } else {
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        imMessageCenterPojo.setGid(this.b);
                        imMessageCenterPojo.setLast_content(g);
                        imMessageCenterPojo.setLast_content_time(this.a.getCreate_time() * 1000);
                        imMessageCenterPojo.setLast_user_name(str);
                        imMessageCenterPojo.setLast_rid(this.a.getMid());
                        imMessageCenterPojo.setPulled_msgId(this.a.getMid());
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
        str = str2;
        z = false;
        com.baidu.adp.lib.h.e.d("see gid:" + this.b + " content:" + g);
        com.baidu.adp.lib.h.e.d("see pojo1:" + this.a);
        if (concurrentHashMap.get(this.b) == null) {
        }
        if (this.d == null) {
        }
    }
}
