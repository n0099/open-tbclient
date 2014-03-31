package com.baidu.tieba.im.pushNotify;
/* loaded from: classes.dex */
final class n extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ m b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str, String str2) {
        this.b = mVar;
        this.c = str;
        this.d = str2;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        l b = this.b.b(this.c, this.d);
        if (b == null) {
            return false;
        }
        return Boolean.valueOf(b.isAcceptNotify());
    }
}
