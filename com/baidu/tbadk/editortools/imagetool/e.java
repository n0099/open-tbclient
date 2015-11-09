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
    final /* synthetic */ MultiImgToolView apW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.apW = multiImgToolView;
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
        boolean z;
        WriteImagesInfo writeImagesInfo5;
        TextView textView2;
        String str;
        j jVar4;
        j jVar5;
        j jVar6;
        int i3;
        dragHorizonScrollView = this.apW.apK;
        if (!dragHorizonScrollView.axS()) {
            this.apW.av(view);
            dragHorizonScrollView2 = this.apW.apK;
            int aw = dragHorizonScrollView2.aw(view);
            if (aw >= 0) {
                writeImagesInfo = this.apW.apN;
                if (aw < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.apW.apN;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(aw);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.apW.apK;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.apW.apN;
                    int size = writeImagesInfo3.size();
                    String string = this.apW.getResources().getString(i.h.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.apW.apL;
                    textView.setText(string);
                    writeImagesInfo4 = this.apW.apN;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.apW.KB;
                    if (jVar != null) {
                        jVar2 = this.apW.KB;
                        i = this.apW.apR;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar6 = this.apW.KB;
                            i3 = this.apW.apS;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.apW.KB;
                            i2 = this.apW.apS;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.apW.apT;
                            if (z) {
                                jVar5 = this.apW.KB;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.apW;
                            writeImagesInfo5 = this.apW.apN;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.apW.apL;
                            str = this.apW.apU;
                            textView2.setText(str);
                            jVar4 = this.apW.KB;
                            jVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
