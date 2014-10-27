package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer aqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditorToolComponetContainer editorToolComponetContainer) {
        this.aqU = editorToolComponetContainer;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.aqU.RC;
        wVar.handleAction(i, obj);
    }
}
