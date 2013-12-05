package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ChatResponsedMessage;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatResponsedMessage f1593a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, ChatResponsedMessage chatResponsedMessage) {
        this.b = aVar;
        this.f1593a = chatResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        WeakReference weakReference;
        WeakReference weakReference2;
        WeakReference weakReference3;
        if (this.f1593a != null) {
            weakReference = this.b.b;
            if (weakReference != null) {
                weakReference2 = this.b.b;
                if (weakReference2.get() != null) {
                    weakReference3 = this.b.b;
                    ((aa) weakReference3.get()).a(this.f1593a);
                }
            }
        }
    }
}
