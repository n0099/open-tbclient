package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1595a;

    private h(a aVar) {
        this.f1595a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(a aVar, b bVar) {
        this(aVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        WeakReference weakReference;
        WeakReference weakReference2;
        WeakReference weakReference3;
        WeakReference weakReference4;
        WeakReference weakReference5;
        WeakReference weakReference6;
        if (message == null) {
            com.baidu.adp.lib.h.e.a("msg == null");
        } else if (message.getCmd() == -100) {
            this.f1595a.a(message);
        } else if (message.getCmd() == 202001) {
            this.f1595a.b(message);
        } else if (message.getCmd() == -103) {
            if (message instanceof LoadDraftResponsedMessage) {
                weakReference4 = this.f1595a.b;
                if (weakReference4 != null) {
                    weakReference5 = this.f1595a.b;
                    if (weakReference5.get() != null) {
                        weakReference6 = this.f1595a.b;
                        ((aa) weakReference6.get()).a(message);
                    }
                }
            }
        } else if (message.getCmd() == -105) {
            if (message instanceof LoadHistoryResponsedMessage) {
                weakReference = this.f1595a.b;
                if (weakReference != null) {
                    weakReference2 = this.f1595a.b;
                    if (weakReference2.get() != null) {
                        weakReference3 = this.f1595a.b;
                        ((aa) weakReference3.get()).a(message);
                    }
                }
            }
        } else {
            com.baidu.adp.lib.h.e.a("convert error need GroupMsgData");
        }
    }
}
