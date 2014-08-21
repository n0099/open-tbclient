package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ q a;
    private final /* synthetic */ FrameLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, FrameLayout frameLayout) {
        this.a = qVar;
        this.b = frameLayout;
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
        WriteImagesInfo writeImagesInfo5;
        EditorToolComponetContainer editorToolComponetContainer17;
        EditorToolComponetContainer editorToolComponetContainer18;
        com.baidu.tbadk.editortool.w wVar2;
        writeImagesInfo = this.a.b;
        editorToolComponetContainer = this.a.a;
        writeImagesInfo2 = editorToolComponetContainer.w;
        if (writeImagesInfo == writeImagesInfo2) {
            editorToolComponetContainer13 = this.a.a;
            if (!editorToolComponetContainer13.l.e()) {
                editorToolComponetContainer14 = this.a.a;
                editorToolComponetContainer14.j.a(this.b);
                editorToolComponetContainer15 = this.a.a;
                int a = editorToolComponetContainer15.l.a(this.b);
                editorToolComponetContainer16 = this.a.a;
                writeImagesInfo5 = editorToolComponetContainer16.w;
                ImageFileInfo remove = writeImagesInfo5.getChosedFiles().remove(a);
                if (remove.isTempFile()) {
                    this.a.a(remove.getFilePath());
                }
                editorToolComponetContainer17 = this.a.a;
                editorToolComponetContainer17.b.e();
                editorToolComponetContainer18 = this.a.a;
                wVar2 = editorToolComponetContainer18.x;
                wVar2.a(51, null);
                return;
            }
            return;
        }
        editorToolComponetContainer2 = this.a.a;
        if (!editorToolComponetContainer2.i.e()) {
            editorToolComponetContainer3 = this.a.a;
            editorToolComponetContainer3.g.a(this.b);
            editorToolComponetContainer4 = this.a.a;
            int a2 = editorToolComponetContainer4.i.a(this.b);
            editorToolComponetContainer5 = this.a.a;
            writeImagesInfo3 = editorToolComponetContainer5.v;
            ImageFileInfo remove2 = writeImagesInfo3.getChosedFiles().remove(a2);
            if (remove2.isTempFile()) {
                this.a.a(remove2.getFilePath());
            }
            editorToolComponetContainer6 = this.a.a;
            int maxItemNum = editorToolComponetContainer6.i.getMaxItemNum();
            editorToolComponetContainer7 = this.a.a;
            writeImagesInfo4 = editorToolComponetContainer7.v;
            int size = writeImagesInfo4.size();
            editorToolComponetContainer8 = this.a.a;
            String string = editorToolComponetContainer8.getResources().getString(com.baidu.tieba.x.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
            editorToolComponetContainer9 = this.a.a;
            editorToolComponetContainer9.m.setText(string);
            editorToolComponetContainer10 = this.a.a;
            editorToolComponetContainer10.b.a(new StringBuilder(String.valueOf(size)).toString());
            if (size == 0) {
                editorToolComponetContainer12 = this.a.a;
                editorToolComponetContainer12.b.a();
            }
            editorToolComponetContainer11 = this.a.a;
            wVar = editorToolComponetContainer11.x;
            wVar.a(13, null);
        }
    }
}
