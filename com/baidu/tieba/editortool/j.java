package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class j implements View.OnClickListener {
    final /* synthetic */ g a;
    private final /* synthetic */ FrameLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, FrameLayout frameLayout) {
        this.a = gVar;
        this.b = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditorToolComponetContainer editorToolComponetContainer3;
        EditorToolComponetContainer editorToolComponetContainer4;
        WriteImagesInfo writeImagesInfo;
        EditorToolComponetContainer editorToolComponetContainer5;
        EditorToolComponetContainer editorToolComponetContainer6;
        WriteImagesInfo writeImagesInfo2;
        EditorToolComponetContainer editorToolComponetContainer7;
        EditorToolComponetContainer editorToolComponetContainer8;
        EditorToolComponetContainer editorToolComponetContainer9;
        EditorToolComponetContainer editorToolComponetContainer10;
        aa aaVar;
        EditorToolComponetContainer editorToolComponetContainer11;
        editorToolComponetContainer = this.a.a;
        if (!editorToolComponetContainer.i.e()) {
            editorToolComponetContainer2 = this.a.a;
            editorToolComponetContainer2.g.a(this.b);
            editorToolComponetContainer3 = this.a.a;
            int a = editorToolComponetContainer3.i.a(this.b);
            editorToolComponetContainer4 = this.a.a;
            writeImagesInfo = editorToolComponetContainer4.q;
            ImageFileInfo remove = writeImagesInfo.getChosedFiles().remove(a);
            if (remove.isTempFile()) {
                new k(this.a, remove.getFilePath()).execute(new Void[0]);
            }
            editorToolComponetContainer5 = this.a.a;
            int maxItemNum = editorToolComponetContainer5.i.getMaxItemNum();
            editorToolComponetContainer6 = this.a.a;
            writeImagesInfo2 = editorToolComponetContainer6.q;
            int size = writeImagesInfo2.size();
            editorToolComponetContainer7 = this.a.a;
            String string = editorToolComponetContainer7.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer8 = this.a.a;
            editorToolComponetContainer8.j.setText(string);
            editorToolComponetContainer9 = this.a.a;
            editorToolComponetContainer9.b.a(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer11 = this.a.a;
                editorToolComponetContainer11.b.a();
            }
            editorToolComponetContainer10 = this.a.a;
            aaVar = editorToolComponetContainer10.r;
            aaVar.a(13, null);
        }
    }
}
