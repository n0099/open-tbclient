package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w arn;
    final /* synthetic */ PbEditorToolView arv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.arv = pbEditorToolView;
        this.arn = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        this.arn.handleAction(i, obj);
    }
}
