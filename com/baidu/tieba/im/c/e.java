package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.x;
import com.baidu.tieba.im.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseOnlineMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.baidu.tieba.im.pushNotify.n;
import com.baidu.tieba.util.y;
import java.util.LinkedList;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1488a;

    private e(a aVar) {
        this.f1488a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, b bVar) {
        this(aVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        long j2;
        int i6;
        long j3;
        int i7;
        Map a2;
        long j4;
        long j5;
        boolean z;
        boolean z2;
        if (message != null) {
            if (message.getCmd() == 1003) {
                if (!(message instanceof ResponsedMessage)) {
                    this.f1488a.a(1003, -1);
                    return;
                }
                ResponsedMessage responsedMessage = (ResponsedMessage) message;
                if (responsedMessage.hasError()) {
                    this.f1488a.a(1003, responsedMessage.getErrNo());
                    return;
                }
                StringBuilder append = new StringBuilder().append("----ping succ， cost-");
                long currentTimeMillis = System.currentTimeMillis();
                j4 = this.f1488a.t;
                com.baidu.adp.lib.h.d.c(append.append(currentTimeMillis - j4).toString());
                int errNo = responsedMessage.getErrNo();
                String errMsg = responsedMessage.getErrMsg();
                long currentTimeMillis2 = System.currentTimeMillis();
                j5 = this.f1488a.t;
                y.a(1003, 0, "receive ping", "MessageSync-receive-ping", "succ", errNo, errMsg, currentTimeMillis2 - j5, 0, "");
                this.f1488a.q();
                z = this.f1488a.m;
                if (!z) {
                    z2 = this.f1488a.n;
                    if (!z2) {
                        this.f1488a.a(false);
                    }
                }
            } else if (message.getCmd() == 202003) {
                a2 = this.f1488a.a(message);
                if (a2 == null || a2.size() <= 0) {
                    this.f1488a.n();
                } else {
                    this.f1488a.a(a2);
                }
            } else if (message.getCmd() == 1001) {
                String str = "";
                i2 = this.f1488a.x;
                if (i2 != 3) {
                    i3 = this.f1488a.x;
                    if (i3 != 2) {
                        i4 = this.f1488a.x;
                        if (i4 == 1) {
                            str = "LOCAL_REQUEST";
                        }
                    } else {
                        str = "SERVER_RESPONSE";
                    }
                } else {
                    str = "SOCKET_CONNECT";
                }
                if (!(message instanceof ResponseOnlineMessage)) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    j3 = this.f1488a.s;
                    StringBuilder append2 = new StringBuilder().append("OnlineFailCount-");
                    i7 = this.f1488a.l;
                    y.a(1001, 0, str, "MessageSync-online", "fail", -30, "ERR_DATA_INVALID", currentTimeMillis3 - j3, 0, append2.append(i7).toString());
                    this.f1488a.a(message.getCmd(), -1);
                    return;
                }
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) message;
                if (responseOnlineMessage.hasError()) {
                    int errNo2 = responseOnlineMessage.getErrNo();
                    String errMsg2 = responseOnlineMessage.getErrMsg();
                    long currentTimeMillis4 = System.currentTimeMillis();
                    j2 = this.f1488a.s;
                    StringBuilder append3 = new StringBuilder().append("OnlineFailCount-");
                    i6 = this.f1488a.l;
                    y.a(1001, 0, str, "MessageSync-online", "fail", errNo2, errMsg2, currentTimeMillis4 - j2, 0, append3.append(i6).toString());
                    com.baidu.adp.lib.h.d.c("----online error. errno-" + responseOnlineMessage.getErrNo() + "--errmsg-" + responseOnlineMessage.getErrMsg());
                    this.f1488a.a(message.getCmd(), responseOnlineMessage.getErrNo());
                    return;
                }
                LinkedList linkedList = new LinkedList();
                LinkedList<String> linkedList2 = new LinkedList<>();
                LinkedList linkedList3 = new LinkedList();
                if (responseOnlineMessage.getGroupInfos() == null) {
                    i5 = 0;
                } else {
                    i5 = responseOnlineMessage.getGroupInfos().size();
                }
                int errNo3 = responseOnlineMessage.getErrNo();
                String errMsg3 = responseOnlineMessage.getErrMsg();
                long currentTimeMillis5 = System.currentTimeMillis();
                j = this.f1488a.s;
                y.a(1001, 0, str, "MessageSync-online", "succ", errNo3, errMsg3, currentTimeMillis5 - j, 0, "groupsize-" + String.valueOf(i5));
                if (responseOnlineMessage.getGroupInfos() != null) {
                    com.baidu.tieba.im.pushNotify.a.g().a(responseOnlineMessage.getGroupInfos());
                    for (GroupUpdateMessage groupUpdateMessage : responseOnlineMessage.getGroupInfos()) {
                        if (groupUpdateMessage != null) {
                            linkedList.add(String.valueOf(groupUpdateMessage.getGroupId()));
                            linkedList2.add(String.valueOf(groupUpdateMessage.getGroupId()));
                            if (groupUpdateMessage.getGroupType() == 1) {
                                n.a().a(String.valueOf(groupUpdateMessage.getGroupId()));
                            }
                        }
                    }
                    com.baidu.tieba.im.db.a.a().a(linkedList2, (com.baidu.tieba.im.a<Void>) null);
                }
                x.a().a(new f(this, responseOnlineMessage, linkedList3, linkedList));
            } else if (message.getCmd() == -111) {
                this.f1488a.x = 1;
                this.f1488a.i();
            } else if (message.getCmd() == -112) {
                this.f1488a.x = 2;
                this.f1488a.j();
            } else if (message.getCmd() == -11) {
                if (message instanceof BackgroundSwitchMessage) {
                    if (((BackgroundSwitchMessage) message).isBackground()) {
                        this.f1488a.g();
                    } else {
                        this.f1488a.f();
                    }
                }
            } else if (message.getCmd() == -12) {
                this.f1488a.o();
                a aVar = this.f1488a;
                IDuplicateProcess.RemoveState removeState = IDuplicateProcess.RemoveState.REMOVE_ALL;
                i = a.p;
                aVar.a(removeState, i);
            }
        }
    }
}
