package com.baidu.tieba.im.c;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.pushNotify.o;
import com.baidu.tieba.im.r;
import java.util.LinkedHashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.framework.c.g {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar, int i) {
        super(0);
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        Handler handler;
        Handler handler2;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null) {
            if (socketResponsedMessage2.g() == 1003) {
                if ((socketResponsedMessage2 instanceof com.baidu.adp.framework.message.f) && socketResponsedMessage2.e() == 0) {
                    this.a.i();
                }
            } else if (socketResponsedMessage2.g() == 1001 && (socketResponsedMessage2 instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage2;
                TiebaStatic.a(responseOnlineMessage);
                if (responseOnlineMessage.e() == 0) {
                    LinkedList linkedList = new LinkedList();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    LinkedList<ImMessageCenterPojo> linkedList2 = new LinkedList<>();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    if (responseOnlineMessage.d() != null) {
                        com.baidu.tieba.im.pushNotify.a.d().a(responseOnlineMessage.d());
                        for (GroupUpdateMessage groupUpdateMessage : responseOnlineMessage.d()) {
                            if (groupUpdateMessage != null) {
                                linkedList.add(String.valueOf(groupUpdateMessage.getGroupId()));
                                if (groupUpdateMessage.getGroupType() == 6) {
                                    if (groupUpdateMessage.getGroupId() != 0 && x.a != groupUpdateMessage.getGroupId()) {
                                        x.a(groupUpdateMessage.getGroupId());
                                        com.baidu.adp.lib.util.f.e("see online1 gid Online=" + groupUpdateMessage.getGroupId());
                                    }
                                } else if (groupUpdateMessage.getGroupType() == 11 || groupUpdateMessage.getGroupType() == 12) {
                                    linkedHashMap2.put(String.valueOf(groupUpdateMessage.getGroupId()), Long.valueOf(groupUpdateMessage.getLastMsgId()));
                                } else {
                                    linkedHashMap.put(String.valueOf(groupUpdateMessage.getGroupId()), Long.valueOf(groupUpdateMessage.getLastMsgId()));
                                }
                                if (groupUpdateMessage.getGroupType() == 1) {
                                    o.a().a(String.valueOf(groupUpdateMessage.getGroupId()));
                                }
                            }
                        }
                        r.a(new g(this, linkedHashMap2, linkedHashMap), null);
                    }
                    if (responseOnlineMessage.d() != null) {
                        for (GroupUpdateMessage groupUpdateMessage2 : responseOnlineMessage.d()) {
                            if (groupUpdateMessage2 != null) {
                                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                linkedList2.add(imMessageCenterPojo);
                                imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage2.getGroupId()));
                                imMessageCenterPojo.setGroup_name(groupUpdateMessage2.getName());
                                imMessageCenterPojo.setCustomGroupType(a.a(groupUpdateMessage2.getGroupType()));
                                ImMessageCenterPojo a = com.baidu.tieba.im.b.e.a(new StringBuilder(String.valueOf(groupUpdateMessage2.getGroupId())).toString());
                                if (a == null || a.getPulled_msgId() == 0 || a.getLast_rid() == 0) {
                                    long lastMsgId = groupUpdateMessage2.getLastMsgId() * 100;
                                    imMessageCenterPojo.setPulled_msgId(lastMsgId);
                                    imMessageCenterPojo.setLast_rid(lastMsgId);
                                }
                                if (a != null) {
                                    imMessageCenterPojo.setIs_hidden(a.getIs_hidden());
                                }
                                imMessageCenterPojo.setGroup_head(groupUpdateMessage2.getPortrait());
                            }
                        }
                    }
                    com.baidu.tieba.im.b.e.a(new h(this, linkedList, linkedList2));
                    com.baidu.tieba.im.db.i.a().a(linkedList2);
                    handler = this.a.l;
                    handler2 = this.a.l;
                    handler.sendMessage(handler2.obtainMessage(3));
                }
            }
        }
    }
}
