package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ EditorToolComponetContainer ard;
    private final /* synthetic */ com.baidu.tbadk.editortool.w are;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditorToolComponetContainer editorToolComponetContainer, com.baidu.tbadk.editortool.w wVar) {
        this.ard = editorToolComponetContainer;
        this.are = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 46) {
            this.ard.aqF.rH();
        } else if (i == 47) {
            this.ard.aqF.rI();
        }
        this.are.handleAction(i, obj);
    }
}
