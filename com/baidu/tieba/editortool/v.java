package com.baidu.tieba.editortool;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.File;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    private final /* synthetic */ ViewGroup ahK;
    final /* synthetic */ t aqY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, ViewGroup viewGroup) {
        this.aqY = tVar;
        this.ahK = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteImagesInfo writeImagesInfo;
        EditorToolComponetContainer editorToolComponetContainer;
        WriteImagesInfo writeImagesInfo2;
        int indexOfChild;
        boolean z;
        EditorToolComponetContainer editorToolComponetContainer2;
        com.baidu.tbadk.editortool.w wVar;
        EditorToolComponetContainer editorToolComponetContainer3;
        writeImagesInfo = this.aqY.aqX;
        editorToolComponetContainer = this.aqY.aqU;
        writeImagesInfo2 = editorToolComponetContainer.aqR;
        if (writeImagesInfo == writeImagesInfo2 && (indexOfChild = this.ahK.indexOfChild(view)) >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.aqY.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                editorToolComponetContainer3 = this.aqY.aqU;
                com.baidu.adp.lib.util.m.b(editorToolComponetContainer3.getContext(), com.baidu.tieba.y.editor_mutiiamge_image_error);
                return;
            }
            editorToolComponetContainer2 = this.aqY.aqU;
            wVar = editorToolComponetContainer2.RC;
            wVar.handleAction(42, Integer.valueOf(indexOfChild));
        }
    }
}
