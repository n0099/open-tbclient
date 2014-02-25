package com.baidu.tieba.editortool;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.img.ImageFileInfo;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ g a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, ViewGroup viewGroup) {
        this.a = gVar;
        this.b = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        EditorToolComponetContainer editorToolComponetContainer;
        z zVar;
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
                BdUtilHelper.b(editorToolComponetContainer2.getContext(), (int) R.string.editor_mutiiamge_image_error);
                return;
            }
            editorToolComponetContainer = this.a.a;
            zVar = editorToolComponetContainer.r;
            zVar.a(42, Integer.valueOf(indexOfChild));
        }
    }
}
