package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView auP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.auP = multiImgToolView;
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
        dragHorizonScrollView = this.auP.auD;
        if (!dragHorizonScrollView.aTW()) {
            this.auP.bh(view);
            dragHorizonScrollView2 = this.auP.auD;
            int bi = dragHorizonScrollView2.bi(view);
            if (bi >= 0) {
                writeImagesInfo = this.auP.auG;
                if (bi < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.auP.auG;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bi);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.fs().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.auP.auD;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.auP.auG;
                    int size = writeImagesInfo3.size();
                    String string = this.auP.getResources().getString(t.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.auP.auE;
                    textView.setText(string);
                    writeImagesInfo4 = this.auP.auG;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    lVar = this.auP.LE;
                    if (lVar != null) {
                        lVar2 = this.auP.LE;
                        i = this.auP.auK;
                        lVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            lVar6 = this.auP.LE;
                            i3 = this.auP.auL;
                            lVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            lVar3 = this.auP.LE;
                            i2 = this.auP.auL;
                            lVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.auP.auM;
                            if (z) {
                                lVar5 = this.auP.LE;
                                lVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.auP;
                            writeImagesInfo5 = this.auP.auG;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.auP.auE;
                            str = this.auP.auN;
                            textView2.setText(str);
                            lVar4 = this.auP.LE;
                            lVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
