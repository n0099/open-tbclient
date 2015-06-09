package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class f extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c bpT;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.bpT = cVar;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        this.bpT.UN().remove(this.val$key);
        return null;
    }
}
