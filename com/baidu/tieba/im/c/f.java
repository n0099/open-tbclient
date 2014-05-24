package com.baidu.tieba.im.c;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.chat.bv;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.pushNotify.p;
import java.util.LinkedHashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        Handler handler;
        Handler handler2;
        int i;
        Handler handler3;
        Handler handler4;
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 1003) {
                if (!(socketResponsedMessage instanceof ResponsedMessage) || socketResponsedMessage.getError() != 0) {
                    return;
                }
                this.a.k();
            } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                TiebaStatic.imNet(responseOnlineMessage);
                if (responseOnlineMessage.getError() == 0) {
                    LinkedList linkedList = new LinkedList();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    LinkedList<ImMessageCenterPojo> linkedList2 = new LinkedList<>();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    if (responseOnlineMessage.getGroupInfos() != null) {
                        com.baidu.tieba.im.pushNotify.a.f().a(responseOnlineMessage.getGroupInfos());
                        for (GroupUpdateMessage groupUpdateMessage : responseOnlineMessage.getGroupInfos()) {
                            if (groupUpdateMessage != null) {
                                linkedList.add(String.valueOf(groupUpdateMessage.getGroupId()));
                                if (groupUpdateMessage.getGroupType() == 6) {
                                    if (groupUpdateMessage.getGroupId() != 0 && w.a != groupUpdateMessage.getGroupId()) {
                                        w.a(groupUpdateMessage.getGroupId());
                                        BdLog.d("see online1 gid Online=" + groupUpdateMessage.getGroupId());
                                    }
                                } else if (groupUpdateMessage.getGroupType() == 11 || groupUpdateMessage.getGroupType() == 12) {
                                    linkedHashMap2.put(String.valueOf(groupUpdateMessage.getGroupId()), Long.valueOf(groupUpdateMessage.getLastMsgId()));
                                } else {
                                    linkedHashMap.put(String.valueOf(groupUpdateMessage.getGroupId()), Long.valueOf(groupUpdateMessage.getLastMsgId()));
                                }
                                if (groupUpdateMessage.getGroupType() == 1) {
                                    p.a().a(String.valueOf(groupUpdateMessage.getGroupId()));
                                }
                            }
                        }
                        com.baidu.tieba.im.i.a(new g(this, linkedHashMap2, linkedHashMap), null);
                    }
                    if (responseOnlineMessage.getGroupInfos() != null) {
                        for (GroupUpdateMessage groupUpdateMessage2 : responseOnlineMessage.getGroupInfos()) {
                            if (groupUpdateMessage2 != null) {
                                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                linkedList2.add(imMessageCenterPojo);
                                imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage2.getGroupId()));
                                imMessageCenterPojo.setGroup_name(groupUpdateMessage2.getName());
                                imMessageCenterPojo.setCustomGroupType(a.a(groupUpdateMessage2.getGroupType()));
                                ImMessageCenterPojo a = com.baidu.tieba.im.b.e.a(new StringBuilder(String.valueOf(groupUpdateMessage2.getGroupId())).toString());
                                if (a == null || a.getPulled_msgId() == 0 || a.getLast_rid() == 0) {
                                    long b = bv.b(groupUpdateMessage2.getLastMsgId());
                                    imMessageCenterPojo.setPulled_msgId(b);
                                    imMessageCenterPojo.setLast_rid(b);
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
                    if (responseOnlineMessage.getGroupInfos() != null) {
                        for (GroupUpdateMessage groupUpdateMessage3 : responseOnlineMessage.getGroupInfos()) {
                            if (com.baidu.tbadk.coreExtra.messageCenter.e.a().c(groupUpdateMessage3.getGroupId()) < groupUpdateMessage3.getLastMsgId()) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        handler3 = this.a.l;
                        handler4 = this.a.l;
                        handler3.sendMessage(handler4.obtainMessage(3));
                        return;
                    }
                    handler = b.a().l;
                    handler2 = b.a().l;
                    Message obtainMessage = handler2.obtainMessage(3);
                    i = b.a().d;
                    handler.sendMessageDelayed(obtainMessage, i);
                }
            }
        }
    }
}
