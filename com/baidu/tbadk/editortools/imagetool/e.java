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
    final /* synthetic */ MultiImgToolView avA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.avA = multiImgToolView;
    }

    @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
    public void J(View view) {
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
        dragHorizonScrollView = this.avA.avo;
        if (!dragHorizonScrollView.bjG()) {
            this.avA.bq(view);
            dragHorizonScrollView2 = this.avA.avo;
            int br = dragHorizonScrollView2.br(view);
            if (br >= 0) {
                writeImagesInfo = this.avA.avr;
                if (br < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.avA.avr;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(br);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.cB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.avA.avo;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.avA.avr;
                    int size = writeImagesInfo3.size();
                    String string = this.avA.getResources().getString(t.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.avA.avp;
                    textView.setText(string);
                    writeImagesInfo4 = this.avA.avr;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    lVar = this.avA.EJ;
                    if (lVar != null) {
                        lVar2 = this.avA.EJ;
                        i = this.avA.avv;
                        lVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            lVar6 = this.avA.EJ;
                            i3 = this.avA.avw;
                            lVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            lVar3 = this.avA.EJ;
                            i2 = this.avA.avw;
                            lVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.avA.avx;
                            if (z) {
                                lVar5 = this.avA.EJ;
                                lVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.avA;
                            writeImagesInfo5 = this.avA.avr;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.avA.avp;
                            str = this.avA.avy;
                            textView2.setText(str);
                            lVar4 = this.avA.EJ;
                            lVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
