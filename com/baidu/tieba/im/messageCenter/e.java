package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.AckedMessage;
import com.baidu.tieba.im.message.Message;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends SingleRunnable<List<Message>> {

    /* renamed from: a  reason: collision with root package name */
    private List<Message> f1730a;
    private com.baidu.tieba.im.codec.p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<Message> list, com.baidu.tieba.im.codec.p pVar) {
        this.f1730a = null;
        this.b = null;
        this.f1730a = list;
        this.b = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public List<Message> b() {
        a a2;
        if (this.f1730a == null) {
            return null;
        }
        int size = this.f1730a.size();
        for (int i = 0; i < size; i++) {
            Message message = this.f1730a.get(i);
            if (!(message instanceof AckedMessage) && (a2 = f.a().a(message.getCmd())) != null) {
                a2.a(message, this.b);
            }
        }
        return this.f1730a;
    }
}
