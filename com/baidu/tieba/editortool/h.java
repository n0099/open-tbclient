package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ EditorToolComponetContainer a;
    private final /* synthetic */ com.baidu.tbadk.editortool.x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.x xVar) {
        this.a = editorToolComponetContainer;
        this.b = xVar;
    }

    @Override // com.baidu.tbadk.editortool.x
    public final void a(int i, Object obj) {
        if (i == 46) {
            this.a.b.b();
        } else if (i == 47) {
            this.a.b.c();
        }
        this.b.a(i, obj);
    }
}
