package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView atx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.atx = multiImgToolView;
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
        k kVar;
        k kVar2;
        int i;
        k kVar3;
        int i2;
        boolean z;
        WriteImagesInfo writeImagesInfo5;
        TextView textView2;
        String str;
        k kVar4;
        k kVar5;
        k kVar6;
        int i3;
        dragHorizonScrollView = this.atx.atl;
        if (!dragHorizonScrollView.aFQ()) {
            this.atx.aL(view);
            dragHorizonScrollView2 = this.atx.atl;
            int aM = dragHorizonScrollView2.aM(view);
            if (aM >= 0) {
                writeImagesInfo = this.atx.ato;
                if (aM < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.atx.ato;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(aM);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.atx.atl;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.atx.ato;
                    int size = writeImagesInfo3.size();
                    String string = this.atx.getResources().getString(n.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.atx.atm;
                    textView.setText(string);
                    writeImagesInfo4 = this.atx.ato;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    kVar = this.atx.Li;
                    if (kVar != null) {
                        kVar2 = this.atx.Li;
                        i = this.atx.ats;
                        kVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            kVar6 = this.atx.Li;
                            i3 = this.atx.att;
                            kVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            kVar3 = this.atx.Li;
                            i2 = this.atx.att;
                            kVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.atx.atu;
                            if (z) {
                                kVar5 = this.atx.Li;
                                kVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.atx;
                            writeImagesInfo5 = this.atx.ato;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.atx.atm;
                            str = this.atx.atv;
                            textView2.setText(str);
                            kVar4 = this.atx.Li;
                            kVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
