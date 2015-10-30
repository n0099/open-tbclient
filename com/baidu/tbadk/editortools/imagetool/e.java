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
    final /* synthetic */ MultiImgToolView arr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.arr = multiImgToolView;
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
        dragHorizonScrollView = this.arr.arh;
        if (!dragHorizonScrollView.axc()) {
            this.arr.aw(view);
            dragHorizonScrollView2 = this.arr.arh;
            int ax = dragHorizonScrollView2.ax(view);
            if (ax >= 0) {
                writeImagesInfo = this.arr.ark;
                if (ax < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.arr.ark;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(ax);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.arr.arh;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.arr.ark;
                    int size = writeImagesInfo3.size();
                    String string = this.arr.getResources().getString(i.h.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.arr.ari;
                    textView.setText(string);
                    writeImagesInfo4 = this.arr.ark;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.arr.KA;
                    if (jVar != null) {
                        jVar2 = this.arr.KA;
                        i = this.arr.aro;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar5 = this.arr.KA;
                            i3 = this.arr.arp;
                            jVar5.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.arr.KA;
                            i2 = this.arr.arp;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            jVar4 = this.arr.KA;
                            jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        }
                    }
                }
            }
        }
    }
}
