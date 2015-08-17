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
    final /* synthetic */ MultiImgToolView arj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.arj = multiImgToolView;
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
        dragHorizonScrollView = this.arj.aqZ;
        if (!dragHorizonScrollView.aqt()) {
            this.arj.am(view);
            dragHorizonScrollView2 = this.arj.aqZ;
            int an = dragHorizonScrollView2.an(view);
            if (an >= 0) {
                writeImagesInfo = this.arj.arc;
                if (an < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.arj.arc;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(an);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.fm().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.arj.aqZ;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.arj.arc;
                    int size = writeImagesInfo3.size();
                    String string = this.arj.getResources().getString(i.C0057i.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.arj.ara;
                    textView.setText(string);
                    writeImagesInfo4 = this.arj.arc;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.arj.Kz;
                    if (jVar != null) {
                        jVar2 = this.arj.Kz;
                        i = this.arj.arg;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar5 = this.arj.Kz;
                            i3 = this.arj.arh;
                            jVar5.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.arj.Kz;
                            i2 = this.arj.arh;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            jVar4 = this.arj.Kz;
                            jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        }
                    }
                }
            }
        }
    }
}
