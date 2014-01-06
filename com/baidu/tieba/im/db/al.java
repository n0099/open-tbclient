package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
class al implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.a = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (this.a.b != null) {
            this.a.b.a(bool);
        }
    }
}
