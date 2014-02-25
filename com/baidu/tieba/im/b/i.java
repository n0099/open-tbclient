package com.baidu.tieba.im.b;

import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.be;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.ch;
import com.baidu.tieba.im.message.cj;
import com.baidu.tieba.im.message.cu;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.util.cb;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ a a;

    private i(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(a aVar, i iVar) {
        this(aVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        Handler handler;
        Handler handler2;
        long j;
        long j2;
        Map a;
        if (sVar != null) {
            if (sVar.w() == 1003) {
                if (!(sVar instanceof da) || ((da) sVar).l()) {
                    return;
                }
                this.a.p();
            } else if (sVar.w() == 202003) {
                this.a.j = System.currentTimeMillis();
                j = this.a.j;
                j2 = this.a.g;
                cb.a(j - j2);
                if (sVar instanceof cj) {
                    int b = ((cj) sVar).b();
                    TiebaApplication.g().y(b == 1);
                    if (b == 1) {
                        com.baidu.tieba.im.messageCenter.e.a().d(new cu());
                    }
                }
                a = this.a.a(sVar);
                if (a == null || a.size() <= 0) {
                    this.a.n();
                } else {
                    this.a.a(a);
                }
            } else if (sVar.w() == 1001) {
                if (sVar instanceof ch) {
                    ch chVar = (ch) sVar;
                    if (!chVar.l()) {
                        LinkedList linkedList = new LinkedList();
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        LinkedList<ImMessageCenterPojo> linkedList2 = new LinkedList<>();
                        this.a.m();
                        cb.a(1001, 0, null, "online succ", null, chVar.m(), chVar.n());
                        if (chVar.a() != null) {
                            com.baidu.tieba.im.c.a.f().a(chVar.a());
                            for (GroupUpdateMessage groupUpdateMessage : chVar.a()) {
                                if (groupUpdateMessage != null) {
                                    linkedList.add(String.valueOf(groupUpdateMessage.getGroupId()));
                                    if (groupUpdateMessage.getGroupType() == 6) {
                                        if (groupUpdateMessage.getGroupId() != 0 && q.a != groupUpdateMessage.getGroupId()) {
                                            q.a(groupUpdateMessage.getGroupId());
                                            com.baidu.adp.lib.util.f.e("see online1 gid Online=" + groupUpdateMessage.getGroupId());
                                        }
                                    } else {
                                        linkedHashMap.put(String.valueOf(groupUpdateMessage.getGroupId()), Long.valueOf(groupUpdateMessage.getLastMsgId()));
                                    }
                                    if (groupUpdateMessage.getGroupType() == 1) {
                                        com.baidu.tieba.im.c.j.a().a(String.valueOf(groupUpdateMessage.getGroupId()));
                                    }
                                }
                            }
                            com.baidu.tieba.im.j.a(new j(this, linkedHashMap), null);
                        }
                        com.baidu.tieba.im.db.d d = com.baidu.tieba.im.db.h.a().d();
                        if (chVar.a() != null) {
                            for (GroupUpdateMessage groupUpdateMessage2 : chVar.a()) {
                                if (groupUpdateMessage2 != null) {
                                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                    linkedList2.add(imMessageCenterPojo);
                                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage2.getGroupId()));
                                    imMessageCenterPojo.setGroup_name(groupUpdateMessage2.getName());
                                    imMessageCenterPojo.setGroup_type(groupUpdateMessage2.getGroupType());
                                    ImMessageCenterPojo a2 = d.a(new StringBuilder(String.valueOf(groupUpdateMessage2.getGroupId())).toString());
                                    if (a2 == null || a2.getPulled_msgId() == 0 || a2.getLast_rid() == 0) {
                                        long b2 = be.b(groupUpdateMessage2.getLastMsgId());
                                        imMessageCenterPojo.setPulled_msgId(b2);
                                        imMessageCenterPojo.setLast_rid(b2);
                                    }
                                    if (a2 != null) {
                                        imMessageCenterPojo.setIs_hidden(a2.getIs_hidden());
                                    }
                                    imMessageCenterPojo.setGroup_head(groupUpdateMessage2.getPortrait());
                                }
                            }
                        }
                        d.a(new k(this, linkedList, linkedList2));
                        com.baidu.tieba.im.messageCenter.e.a().b(false);
                        com.baidu.adp.lib.util.f.d("----online succ");
                        com.baidu.tieba.im.db.l.a().a(d, linkedList2);
                        if (TiebaApplication.B()) {
                            handler = this.a.t;
                            handler2 = this.a.t;
                            handler.sendMessage(handler2.obtainMessage(3));
                            return;
                        }
                        return;
                    }
                    this.a.a(sVar.w(), chVar.m(), chVar.n());
                    return;
                }
                this.a.a(sVar.w(), -1, (String) null);
            } else if (sVar.w() == -11 && (sVar instanceof com.baidu.tieba.im.message.a)) {
                if (((com.baidu.tieba.im.message.a) sVar).a()) {
                    this.a.h();
                } else {
                    this.a.g();
                }
            }
        }
    }
}
