package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseQueryGroupCountMessage;
import com.baidu.tieba.im.messageCenter.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1528a = aVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        e eVar;
        e eVar2;
        int i;
        int i2;
        if (message instanceof ResponseQueryGroupCountMessage) {
            ResponseQueryGroupCountMessage responseQueryGroupCountMessage = (ResponseQueryGroupCountMessage) message;
            if (!responseQueryGroupCountMessage.hasError()) {
                this.f1528a.c = responseQueryGroupCountMessage.getUserGroupCount();
                this.f1528a.d = responseQueryGroupCountMessage.getLocalGroupCount();
                if (message.getCmd() == 103011) {
                    a.f1527a = false;
                } else if (message.getCmd() == -114) {
                    this.f1528a.a();
                }
                eVar = this.f1528a.e;
                if (eVar != null) {
                    eVar2 = this.f1528a.e;
                    i = this.f1528a.c;
                    i2 = this.f1528a.d;
                    eVar2.a(i, i2);
                }
            }
        }
    }
}
