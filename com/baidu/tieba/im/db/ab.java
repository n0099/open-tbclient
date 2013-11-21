package com.baidu.tieba.im.db;

import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.google.gson.Gson;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupMsgPojo f1594a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ com.baidu.tieba.im.a d;
    final /* synthetic */ aa e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, GroupMsgPojo groupMsgPojo, String str, int i, com.baidu.tieba.im.a aVar) {
        this.e = aaVar;
        this.f1594a = groupMsgPojo;
        this.b = str;
        this.c = i;
        this.d = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        String g = com.baidu.tieba.im.d.c.g(this.f1594a.toChatMessage());
        UserData userData = (UserData) new Gson().fromJson(this.f1594a.getUser_info(), (Class<Object>) UserData.class);
        String str = "";
        if (userData != null) {
            str = userData.getUserName();
        }
        if (concurrentHashMap.get(this.b) != null) {
            concurrentHashMap.get(this.b).setLast_content(g);
            concurrentHashMap.get(this.b).setLast_content_time(this.f1594a.getCreate_time() * 1000);
            concurrentHashMap.get(this.b).setLast_user_name(str);
            long last_msgId = concurrentHashMap.get(this.b).getLast_msgId();
            long mid = this.f1594a.getMid();
            com.baidu.adp.lib.h.d.d("gid:" + this.b + "curLastMid:" + mid + "orginalLastMid:" + last_msgId + " cur unRead:" + concurrentHashMap.get(this.b).getUnread_count() + " add unread:" + this.c + "content:" + this.f1594a + " readableContent:" + g);
            if (last_msgId < mid) {
                concurrentHashMap.get(this.b).setLast_msgId(mid);
                concurrentHashMap.get(this.b).setUnread_count(concurrentHashMap.get(this.b).getUnread_count() + this.c);
            }
            if (this.c > 0) {
                concurrentHashMap.get(this.b).setIs_hidden(0);
            }
        } else {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(this.b);
            imMessageCenterPojo.setLast_content(g);
            imMessageCenterPojo.setLast_content_time(this.f1594a.getCreate_time() * 1000);
            imMessageCenterPojo.setLast_user_name(str);
            imMessageCenterPojo.setLast_msgId(this.f1594a.getMid());
            imMessageCenterPojo.setPulled_msgId(this.f1594a.getMid());
            imMessageCenterPojo.setUnread_count(this.c);
            concurrentHashMap.put(this.b, imMessageCenterPojo);
        }
        if (this.d != null) {
            this.d.a(null);
        }
    }
}
