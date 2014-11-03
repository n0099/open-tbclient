package com.baidu.tieba.editortool;
/* loaded from: classes.dex */
class af implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbEditorToolView arE;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.arE = pbEditorToolView;
        this.arw = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        this.arw.handleAction(i, obj);
    }
}
