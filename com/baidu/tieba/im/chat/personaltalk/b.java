package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
final class b extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2) {
        this.a = str;
        this.c = str2;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(a.b(this.a, this.c));
    }
}
