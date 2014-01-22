package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.a = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (this.a.b != null) {
            this.a.b.a(bool);
        }
    }
}
