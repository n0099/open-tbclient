package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ t aqY;
    private final /* synthetic */ FrameLayout aqZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, FrameLayout frameLayout) {
        this.aqY = tVar;
        this.aqZ = frameLayout;
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
        writeImagesInfo = this.aqY.aqX;
        editorToolComponetContainer = this.aqY.aqU;
        writeImagesInfo2 = editorToolComponetContainer.aqS;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer14 = this.aqY.aqU;
            if (!editorToolComponetContainer14.aqH.Sj()) {
                editorToolComponetContainer15 = this.aqY.aqU;
                editorToolComponetContainer15.aqF.O(this.aqZ);
                editorToolComponetContainer16 = this.aqY.aqU;
                int P = editorToolComponetContainer16.aqH.P(this.aqZ);
                editorToolComponetContainer17 = this.aqY.aqU;
                writeImagesInfo5 = editorToolComponetContainer17.aqS;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(P);
                if (remove.isTempFile()) {
                    this.aqY.eH(remove.getFilePath());
                }
                editorToolComponetContainer18 = this.aqY.aqU;
                editorToolComponetContainer18.aqw.rK();
                editorToolComponetContainer19 = this.aqY.aqU;
                editorToolComponetContainer19.aqI.setText("");
                editorToolComponetContainer20 = this.aqY.aqU;
                wVar2 = editorToolComponetContainer20.RC;
                wVar2.handleAction(51, null);
                editorToolComponetContainer21 = this.aqY.aqU;
                editorToolComponetContainer21.Bn();
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.aqY.aqU;
        if (!editorToolComponetContainer2.aqE.Sj()) {
            editorToolComponetContainer3 = this.aqY.aqU;
            editorToolComponetContainer3.aqC.O(this.aqZ);
            editorToolComponetContainer4 = this.aqY.aqU;
            int P2 = editorToolComponetContainer4.aqE.P(this.aqZ);
            editorToolComponetContainer5 = this.aqY.aqU;
            writeImagesInfo3 = editorToolComponetContainer5.aqR;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(P2);
            if (remove2.isTempFile()) {
                this.aqY.eH(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.aqY.aqU;
            int maxItemNum = editorToolComponetContainer6.aqE.getMaxItemNum();
            editorToolComponetContainer7 = this.aqY.aqU;
            writeImagesInfo4 = editorToolComponetContainer7.aqR;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.aqY.aqU;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.y.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.aqY.aqU;
            editorToolComponetContainer9.aqJ.setText(string);
            editorToolComponetContainer10 = this.aqY.aqU;
            editorToolComponetContainer10.aqw.di(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer13 = this.aqY.aqU;
                editorToolComponetContainer13.aqw.rD();
            }
            editorToolComponetContainer11 = this.aqY.aqU;
            wVar = editorToolComponetContainer11.RC;
            wVar.handleAction(13, null);
            editorToolComponetContainer12 = this.aqY.aqU;
            editorToolComponetContainer12.Bn();
        }
    }
}
