package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.tbadk.coreExtra.c.c {
    final /* synthetic */ ProgressCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ProgressCountDownView progressCountDownView, long j, long j2) {
        super(j, j2);
        this.a = progressCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void a(long j) {
        this.a.a(j);
        this.a.b(j);
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void c() {
        ar arVar;
        ar arVar2;
        arVar = this.a.g;
        if (arVar != null) {
            arVar2 = this.a.g;
            arVar2.a();
        }
    }
}
