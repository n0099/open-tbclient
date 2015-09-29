package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView arq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.arq = multiImgToolView;
    }

    @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
    public void t(View view) {
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
        j jVar4;
        j jVar5;
        int i3;
        dragHorizonScrollView = this.arq.arg;
        if (!dragHorizonScrollView.awW()) {
            this.arq.aw(view);
            dragHorizonScrollView2 = this.arq.arg;
            int ax = dragHorizonScrollView2.ax(view);
            if (ax >= 0) {
                writeImagesInfo = this.arq.arj;
                if (ax < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.arq.arj;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(ax);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.arq.arg;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.arq.arj;
                    int size = writeImagesInfo3.size();
                    String string = this.arq.getResources().getString(i.h.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.arq.arh;
                    textView.setText(string);
                    writeImagesInfo4 = this.arq.arj;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.arq.Kz;
                    if (jVar != null) {
                        jVar2 = this.arq.Kz;
                        i = this.arq.arn;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar5 = this.arq.Kz;
                            i3 = this.arq.aro;
                            jVar5.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.arq.Kz;
                            i2 = this.arq.aro;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            jVar4 = this.arq.Kz;
                            jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        }
                    }
                }
            }
        }
    }
}
