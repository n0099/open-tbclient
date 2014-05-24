package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ o a;
    private final /* synthetic */ FrameLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, FrameLayout frameLayout) {
        this.a = oVar;
        this.b = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
        com.baidu.tbadk.editortool.x xVar;
        EditorToolComponetContainer editorToolComponetContainer11;
        editorToolComponetContainer = this.a.a;
        if (!editorToolComponetContainer.i.e()) {
            editorToolComponetContainer2 = this.a.a;
            editorToolComponetContainer2.g.a(this.b);
            editorToolComponetContainer3 = this.a.a;
            int a = editorToolComponetContainer3.i.a(this.b);
            editorToolComponetContainer4 = this.a.a;
            writeImagesInfo = editorToolComponetContainer4.s;
            ImageFileInfo remove = writeImagesInfo.getChosedFiles().remove(a);
            if (remove.isTempFile()) {
                this.a.a(remove.getFilePath());
            }
            editorToolComponetContainer5 = this.a.a;
            int maxItemNum = editorToolComponetContainer5.i.getMaxItemNum();
            editorToolComponetContainer6 = this.a.a;
            writeImagesInfo2 = editorToolComponetContainer6.s;
            int size = writeImagesInfo2.size();
            editorToolComponetContainer7 = this.a.a;
            String string = editorToolComponetContainer7.getResources().getString(com.baidu.tieba.y.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer8 = this.a.a;
            editorToolComponetContainer8.j.setText(string);
            editorToolComponetContainer9 = this.a.a;
            editorToolComponetContainer9.b.a(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer11 = this.a.a;
                editorToolComponetContainer11.b.a();
            }
            editorToolComponetContainer10 = this.a.a;
            xVar = editorToolComponetContainer10.t;
            xVar.a(13, null);
        }
    }
}
