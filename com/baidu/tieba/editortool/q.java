package com.baidu.tieba.editortool;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ o a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, ViewGroup viewGroup) {
        this.a = oVar;
        this.b = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        EditorToolComponetContainer editorToolComponetContainer;
        com.baidu.tbadk.editortool.x xVar;
        EditorToolComponetContainer editorToolComponetContainer2;
        int indexOfChild = this.b.indexOfChild(view);
        if (indexOfChild >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.a.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                editorToolComponetContainer2 = this.a.a;
                com.baidu.adp.lib.util.k.b(editorToolComponetContainer2.getContext(), com.baidu.tieba.y.editor_mutiiamge_image_error);
                return;
            }
            editorToolComponetContainer = this.a.a;
            xVar = editorToolComponetContainer.t;
            xVar.a(42, Integer.valueOf(indexOfChild));
        }
    }
}
