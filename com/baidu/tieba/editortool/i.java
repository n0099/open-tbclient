package com.baidu.tieba.editortool;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.img.ImageFileInfo;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
final class i implements View.OnClickListener {
    final /* synthetic */ g a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, ViewGroup viewGroup) {
        this.a = gVar;
        this.b = viewGroup;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        boolean z;
        EditorToolComponetContainer editorToolComponetContainer;
        aa aaVar;
        EditorToolComponetContainer editorToolComponetContainer2;
        int indexOfChild = this.b.indexOfChild(view);
        if (indexOfChild >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.a.getItem(indexOfChild);
            if (imageFileInfo != null) {
                File file = new File(imageFileInfo.getFilePath());
                if (file.exists() && file.length() != 0) {
                    z = true;
                    if (z) {
                        editorToolComponetContainer2 = this.a.a;
                        BdUtilHelper.b(editorToolComponetContainer2.getContext(), (int) R.string.editor_mutiiamge_image_error);
                        return;
                    }
                    editorToolComponetContainer = this.a.a;
                    aaVar = editorToolComponetContainer.r;
                    aaVar.a(42, Integer.valueOf(indexOfChild));
                    return;
                }
            }
            z = false;
            if (z) {
            }
        }
    }
}
