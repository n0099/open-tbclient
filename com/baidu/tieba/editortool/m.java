package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer ard;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EditorToolComponetContainer editorToolComponetContainer) {
        this.ard = editorToolComponetContainer;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.ard.RG;
        wVar.handleAction(i, obj);
    }
}
