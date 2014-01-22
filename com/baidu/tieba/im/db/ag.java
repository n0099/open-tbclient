package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends SingleRunnable<LinkedList<ImMessageCenterPojo>> {
    final /* synthetic */ ae a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.a = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<ImMessageCenterPojo> b() {
        AtomicBoolean atomicBoolean;
        boolean z;
        String str;
        ImMessageCenterPojo imMessageCenterPojo = null;
        atomicBoolean = this.a.c;
        if (!atomicBoolean.get()) {
            LinkedList<ImMessageCenterPojo> b = t.a().b();
            if (b != null) {
                Iterator<ImMessageCenterPojo> it = b.iterator();
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setUnread_count(d.a().a(next.getGid()));
                    next.setPulled_msgId(d.a().c(next.getGid()));
                    CommonMsgPojo d = d.a().d(next.getGid());
                    if (d != null) {
                        if (!TextUtils.isEmpty(d.getGid()) && d.getGid().equals(String.valueOf(com.baidu.tieba.im.chat.q.a))) {
                            next.setLast_rid(d.getRid());
                            next.setPulled_msgId(d.getMid());
                        } else {
                            d.checkRidAndSelf();
                            String h = com.baidu.tieba.im.d.d.h(d.toChatMessage());
                            UserData userData = (UserData) new Gson().fromJson(d.getUser_info(), (Class<Object>) UserData.class);
                            if (userData == null) {
                                str = "";
                            } else {
                                str = userData.getUserName();
                            }
                            next.setLast_content(h);
                            next.setLast_user_name(str);
                            next.setLast_rid(d.getRid());
                            next.setLast_content_time(d.getCreate_time() * 1000);
                            next = imMessageCenterPojo;
                        }
                    } else {
                        next.setLast_content("");
                        next.setPulled_msgId(0L);
                        next.setLast_rid(0L);
                        next.setLast_user_name("");
                        next.setLast_content_time(0L);
                        next = imMessageCenterPojo;
                    }
                    imMessageCenterPojo = next;
                }
                com.baidu.adp.lib.g.e.d("see init private chat begin ");
                if (imMessageCenterPojo != null) {
                    z = false;
                } else {
                    com.baidu.adp.lib.g.e.d("see init private chat group new  ");
                    imMessageCenterPojo = new ImMessageCenterPojo();
                    z = true;
                }
                imMessageCenterPojo.setGid(String.valueOf(com.baidu.tieba.im.chat.q.a));
                imMessageCenterPojo.setGroup_type(6);
                for (String str2 : au.a().c()) {
                    com.baidu.adp.lib.g.e.d("see init private chat id:" + str2);
                    if (!TextUtils.isEmpty(str2)) {
                        long b2 = au.a().b(str2);
                        if (b2 > imMessageCenterPojo.getPulled_msgId()) {
                            imMessageCenterPojo.setPulled_msgId(b2);
                        }
                        CommonMsgPojo c = au.a().c(str2);
                        if (c == null) {
                            com.baidu.adp.lib.g.e.d("see init private chat cmpojo null id:" + str2);
                        } else {
                            ImMessageCenterPojo a = ae.a(c);
                            if (a == null) {
                                com.baidu.adp.lib.g.e.d("see init private chat person null id:" + str2);
                            } else {
                                b.add(a);
                                if (c.getRid() > imMessageCenterPojo.getLast_rid()) {
                                    imMessageCenterPojo.setLast_rid(c.getRid());
                                }
                                String b3 = t.b(str2);
                                Iterator<ImMessageCenterPojo> it2 = b.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    ImMessageCenterPojo next2 = it2.next();
                                    if (next2 != null && next2.getGid() != null && b3 != null && next2.getGid().equals(b3)) {
                                        imMessageCenterPojo.setIs_hidden(next2.getIs_hidden());
                                        a.setIs_hidden(next2.getIs_hidden());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (z) {
                    b.add(imMessageCenterPojo);
                }
            }
            return b;
        }
        com.baidu.adp.lib.g.e.d("see init ready return null");
        return null;
    }
}
