package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
final class b extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(a.b(this.a, this.b));
    }
}
