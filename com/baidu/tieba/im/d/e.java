package com.baidu.tieba.im.d;

import com.baidu.tieba.im.db.ad;
import com.baidu.tieba.im.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseOnlineMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.pushNotify.l;
import com.baidu.tieba.log.i;
import java.util.LinkedList;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1643a;

    private e(a aVar) {
        this.f1643a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, b bVar) {
        this(aVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        Map a2;
        if (message != null) {
            if (message.getCmd() == 1003) {
                if ((message instanceof ResponsedMessage) && !((ResponsedMessage) message).hasError()) {
                    this.f1643a.j();
                }
            } else if (message.getCmd() == 202003) {
                this.f1643a.j = System.currentTimeMillis();
                a2 = this.f1643a.a(message);
                if (a2 == null || a2.size() <= 0) {
                    this.f1643a.h();
                } else {
                    this.f1643a.a(a2);
                }
            } else if (message.getCmd() == 1001) {
                if (!(message instanceof ResponseOnlineMessage)) {
                    this.f1643a.a(message.getCmd(), -1, (String) null);
                    return;
                }
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) message;
                if (responseOnlineMessage.hasError()) {
                    this.f1643a.a(message.getCmd(), responseOnlineMessage.getErrNo(), responseOnlineMessage.getErrMsg());
                    return;
                }
                LinkedList linkedList = new LinkedList();
                LinkedList<String> linkedList2 = new LinkedList<>();
                LinkedList linkedList3 = new LinkedList();
                com.baidu.tieba.log.a.b(i.a(1001, 0, null, "online succ", null, responseOnlineMessage.getErrNo(), responseOnlineMessage.getErrMsg()));
                if (responseOnlineMessage.getGroupInfos() != null) {
                    com.baidu.tieba.im.pushNotify.a.h().a(responseOnlineMessage.getGroupInfos());
                    for (GroupUpdateMessage groupUpdateMessage : responseOnlineMessage.getGroupInfos()) {
                        if (groupUpdateMessage != null) {
                            linkedList.add(String.valueOf(groupUpdateMessage.getGroupId()));
                            linkedList2.add(String.valueOf(groupUpdateMessage.getGroupId()));
                            if (groupUpdateMessage.getGroupType() == 1) {
                                l.a().a(String.valueOf(groupUpdateMessage.getGroupId()));
                            }
                        }
                    }
                    com.baidu.tieba.im.db.d.a().a(linkedList2, (com.baidu.tieba.im.a<Void>) null);
                }
                ad.a().a(new f(this, responseOnlineMessage, linkedList3, linkedList));
            } else if (message.getCmd() == -11 && (message instanceof BackgroundSwitchMessage)) {
                if (((BackgroundSwitchMessage) message).isBackground()) {
                    this.f1643a.f();
                } else {
                    this.f1643a.e();
                }
            }
        }
    }
}
