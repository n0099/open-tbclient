package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView ast;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.ast = multiImgToolView;
    }

    @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
    public void I(View view) {
        DragHorizonScrollView dragHorizonScrollView;
        DragHorizonScrollView dragHorizonScrollView2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        DragHorizonScrollView dragHorizonScrollView3;
        WriteImagesInfo writeImagesInfo3;
        TextView textView;
        WriteImagesInfo writeImagesInfo4;
        l lVar;
        l lVar2;
        int i;
        l lVar3;
        int i2;
        boolean z;
        WriteImagesInfo writeImagesInfo5;
        TextView textView2;
        String str;
        l lVar4;
        l lVar5;
        l lVar6;
        int i3;
        dragHorizonScrollView = this.ast.ash;
        if (!dragHorizonScrollView.bgf()) {
            this.ast.br(view);
            dragHorizonScrollView2 = this.ast.ash;
            int bs = dragHorizonScrollView2.bs(view);
            if (bs >= 0) {
                writeImagesInfo = this.ast.ask;
                if (bs < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.ast.ask;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bs);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.bG().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.ast.ash;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.ast.ask;
                    int size = writeImagesInfo3.size();
                    String string = this.ast.getResources().getString(u.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.ast.asi;
                    textView.setText(string);
                    writeImagesInfo4 = this.ast.ask;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    lVar = this.ast.Cw;
                    if (lVar != null) {
                        lVar2 = this.ast.Cw;
                        i = this.ast.aso;
                        lVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            lVar6 = this.ast.Cw;
                            i3 = this.ast.asp;
                            lVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            lVar3 = this.ast.Cw;
                            i2 = this.ast.asp;
                            lVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.ast.asq;
                            if (z) {
                                lVar5 = this.ast.Cw;
                                lVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.ast;
                            writeImagesInfo5 = this.ast.ask;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.ast.asi;
                            str = this.ast.asr;
                            textView2.setText(str);
                            lVar4 = this.ast.Cw;
                            lVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
