package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends com.baidu.tbadk.coreExtra.c.b {
    final /* synthetic */ ProgressCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(ProgressCountDownView progressCountDownView, long j, long j2) {
        super(j, j2);
        this.a = progressCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void a(long j) {
        ProgressCountDownView.a(this.a, j);
        ProgressCountDownView.b(this.a, j);
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void c() {
        ac acVar;
        ac acVar2;
        acVar = this.a.g;
        if (acVar != null) {
            acVar2 = this.a.g;
            acVar2.a();
        }
    }
}
