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
    final /* synthetic */ MultiImgToolView asT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.asT = multiImgToolView;
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
        dragHorizonScrollView = this.asT.asJ;
        if (!dragHorizonScrollView.auH()) {
            this.asT.av(view);
            dragHorizonScrollView2 = this.asT.asJ;
            int aw = dragHorizonScrollView2.aw(view);
            if (aw >= 0) {
                writeImagesInfo = this.asT.asM;
                if (aw < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.asT.asM;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(aw);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.asT.asJ;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.asT.asM;
                    int size = writeImagesInfo3.size();
                    String string = this.asT.getResources().getString(i.h.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.asT.asK;
                    textView.setText(string);
                    writeImagesInfo4 = this.asT.asM;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.asT.Kz;
                    if (jVar != null) {
                        jVar2 = this.asT.Kz;
                        i = this.asT.asQ;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar5 = this.asT.Kz;
                            i3 = this.asT.asR;
                            jVar5.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.asT.Kz;
                            i2 = this.asT.asR;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            jVar4 = this.asT.Kz;
                            jVar4.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        }
                    }
                }
            }
        }
    }
}
