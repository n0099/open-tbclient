package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ l a;
    private final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, t tVar) {
        this.a = lVar;
        this.b = tVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Object tag = this.b.c.getTag();
        if (tag != null && (tag instanceof String) && ((String) tag).equals(str)) {
            this.b.c.invalidate();
        }
    }
}
