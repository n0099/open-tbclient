package com.baidu.tieba.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.voice.f {
    final /* synthetic */ EditorToolComponetContainer ard;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditorToolComponetContainer editorToolComponetContainer) {
        this.ard = editorToolComponetContainer;
    }

    @Override // com.baidu.tieba.voice.f
    public void BW() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.ard.RG;
        wVar.handleAction(14, null);
        this.ard.Bp();
    }

    @Override // com.baidu.tieba.voice.f
    public void BX() {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.ard.RG;
        wVar.handleAction(15, null);
        this.ard.Bp();
    }
}
