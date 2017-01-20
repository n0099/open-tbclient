package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView auz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.auz = multiImgToolView;
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
        j jVar;
        j jVar2;
        int i;
        j jVar3;
        int i2;
        boolean z;
        WriteImagesInfo writeImagesInfo5;
        TextView textView2;
        String str;
        j jVar4;
        j jVar5;
        j jVar6;
        int i3;
        dragHorizonScrollView = this.auz.aun;
        if (!dragHorizonScrollView.bim()) {
            this.auz.bq(view);
            dragHorizonScrollView2 = this.auz.aun;
            int br = dragHorizonScrollView2.br(view);
            if (br >= 0) {
                writeImagesInfo = this.auz.auq;
                if (br < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.auz.auq;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(br);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.cz().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.auz.aun;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.auz.auq;
                    int size = writeImagesInfo3.size();
                    String string = this.auz.getResources().getString(r.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.auz.auo;
                    textView.setText(string);
                    writeImagesInfo4 = this.auz.auq;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.auz.DX;
                    if (jVar != null) {
                        jVar2 = this.auz.DX;
                        i = this.auz.auu;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar6 = this.auz.DX;
                            i3 = this.auz.auv;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.auz.DX;
                            i2 = this.auz.auv;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.auz.auw;
                            if (z) {
                                jVar5 = this.auz.DX;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.auz;
                            writeImagesInfo5 = this.auz.auq;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.auz.auo;
                            str = this.auz.aux;
                            textView2.setText(str);
                            jVar4 = this.auz.DX;
                            jVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
