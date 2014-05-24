package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ m a;
    private final /* synthetic */ u b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, u uVar) {
        this.a = mVar;
        this.b = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Object tag = this.b.c.getTag();
        if (tag != null && (tag instanceof String) && ((String) tag).equals(str)) {
            this.b.c.invalidate();
        }
    }
}
