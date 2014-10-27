package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.voice.f {
    final /* synthetic */ EditorToolComponetContainer aqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditorToolComponetContainer editorToolComponetContainer) {
        this.aqU = editorToolComponetContainer;
    }

    @Override // com.baidu.tieba.voice.f
    public void BU() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.aqU.RC;
        wVar.handleAction(14, null);
        this.aqU.Bn();
    }

    @Override // com.baidu.tieba.voice.f
    public void BV() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.aqU.RC;
        wVar.handleAction(15, null);
        this.aqU.Bn();
    }
}
