package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ t arh;
    private final /* synthetic */ FrameLayout ari;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, FrameLayout frameLayout) {
        this.arh = tVar;
        this.ari = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteImagesInfo writeImagesInfo;
        EditorToolComponetContainer editorToolComponetContainer;
        WriteImagesInfo writeImagesInfo2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditorToolComponetContainer editorToolComponetContainer3;
        EditorToolComponetContainer editorToolComponetContainer4;
        EditorToolComponetContainer editorToolComponetContainer5;
        WriteImagesInfo writeImagesInfo3;
        EditorToolComponetContainer editorToolComponetContainer6;
        EditorToolComponetContainer editorToolComponetContainer7;
        WriteImagesInfo writeImagesInfo4;
        EditorToolComponetContainer editorToolComponetContainer8;
        EditorToolComponetContainer editorToolComponetContainer9;
        EditorToolComponetContainer editorToolComponetContainer10;
        EditorToolComponetContainer editorToolComponetContainer11;
        com.baidu.tbadk.editortool.w wVar;
        EditorToolComponetContainer editorToolComponetContainer12;
        EditorToolComponetContainer editorToolComponetContainer13;
        EditorToolComponetContainer editorToolComponetContainer14;
        EditorToolComponetContainer editorToolComponetContainer15;
        EditorToolComponetContainer editorToolComponetContainer16;
        EditorToolComponetContainer editorToolComponetContainer17;
        WriteImagesInfo writeImagesInfo5;
        EditorToolComponetContainer editorToolComponetContainer18;
        EditorToolComponetContainer editorToolComponetContainer19;
        EditorToolComponetContainer editorToolComponetContainer20;
        com.baidu.tbadk.editortool.w wVar2;
        EditorToolComponetContainer editorToolComponetContainer21;
        writeImagesInfo = this.arh.arg;
        editorToolComponetContainer = this.arh.ard;
        writeImagesInfo2 = editorToolComponetContainer.arb;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer14 = this.arh.ard;
            if (!editorToolComponetContainer14.aqQ.Sm()) {
                editorToolComponetContainer15 = this.arh.ard;
                editorToolComponetContainer15.aqO.O(this.ari);
                editorToolComponetContainer16 = this.arh.ard;
                int P = editorToolComponetContainer16.aqQ.P(this.ari);
                editorToolComponetContainer17 = this.arh.ard;
                writeImagesInfo5 = editorToolComponetContainer17.arb;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(P);
                if (remove.isTempFile()) {
                    this.arh.eH(remove.getFilePath());
                }
                editorToolComponetContainer18 = this.arh.ard;
                editorToolComponetContainer18.aqF.rM();
                editorToolComponetContainer19 = this.arh.ard;
                editorToolComponetContainer19.aqR.setText("");
                editorToolComponetContainer20 = this.arh.ard;
                wVar2 = editorToolComponetContainer20.RG;
                wVar2.handleAction(51, null);
                editorToolComponetContainer21 = this.arh.ard;
                editorToolComponetContainer21.Bp();
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.arh.ard;
        if (!editorToolComponetContainer2.aqN.Sm()) {
            editorToolComponetContainer3 = this.arh.ard;
            editorToolComponetContainer3.aqL.O(this.ari);
            editorToolComponetContainer4 = this.arh.ard;
            int P2 = editorToolComponetContainer4.aqN.P(this.ari);
            editorToolComponetContainer5 = this.arh.ard;
            writeImagesInfo3 = editorToolComponetContainer5.ara;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(P2);
            if (remove2.isTempFile()) {
                this.arh.eH(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.arh.ard;
            int maxItemNum = editorToolComponetContainer6.aqN.getMaxItemNum();
            editorToolComponetContainer7 = this.arh.ard;
            writeImagesInfo4 = editorToolComponetContainer7.ara;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.arh.ard;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.y.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.arh.ard;
            editorToolComponetContainer9.aqS.setText(string);
            editorToolComponetContainer10 = this.arh.ard;
            editorToolComponetContainer10.aqF.di(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer13 = this.arh.ard;
                editorToolComponetContainer13.aqF.rF();
            }
            editorToolComponetContainer11 = this.arh.ard;
            wVar = editorToolComponetContainer11.RG;
            wVar.handleAction(13, null);
            editorToolComponetContainer12 = this.arh.ard;
            editorToolComponetContainer12.Bp();
        }
    }
}
