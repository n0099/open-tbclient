package com.baidu.tieba.editortool;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.io.File;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ q a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, ViewGroup viewGroup) {
        this.a = qVar;
        this.b = viewGroup;
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
        writeImagesInfo = this.a.b;
        editorToolComponetContainer = this.a.a;
        writeImagesInfo2 = editorToolComponetContainer.w;
        if (writeImagesInfo == writeImagesInfo2 && (indexOfChild = this.b.indexOfChild(view)) >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.a.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                editorToolComponetContainer3 = this.a.a;
                com.baidu.adp.lib.util.j.b(editorToolComponetContainer3.getContext(), com.baidu.tieba.y.editor_mutiiamge_image_error);
                return;
            }
            editorToolComponetContainer2 = this.a.a;
            wVar = editorToolComponetContainer2.y;
            wVar.a(42, Integer.valueOf(indexOfChild));
        }
    }
}
