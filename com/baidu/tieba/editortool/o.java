package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer aqU;
    private final /* synthetic */ com.baidu.tbadk.editortool.w aqV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.w wVar) {
        this.aqU = editorToolComponetContainer;
        this.aqV = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 46) {
            this.aqU.aqw.rF();
        } else if (i == 47) {
            this.aqU.aqw.rG();
        }
        this.aqV.handleAction(i, obj);
    }
}
