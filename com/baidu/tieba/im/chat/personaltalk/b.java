package com.baidu.tieba.im.chat.personaltalk;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.c<Boolean> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2) {
        this.a = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(a.b(this.a, this.c));
    }
}
