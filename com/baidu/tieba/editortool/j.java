package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer a;
    private final /* synthetic */ com.baidu.tbadk.editortool.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.w wVar) {
        this.a = editorToolComponetContainer;
        this.b = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        if (i == 46) {
            this.a.b.c();
        } else if (i == 47) {
            this.a.b.d();
        }
        this.b.a(i, obj);
    }
}
