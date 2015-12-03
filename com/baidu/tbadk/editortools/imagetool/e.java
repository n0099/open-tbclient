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
    final /* synthetic */ MultiImgToolView arT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.arT = multiImgToolView;
    }

    @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
    public void u(View view) {
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
        dragHorizonScrollView = this.arT.arH;
        if (!dragHorizonScrollView.aDD()) {
            this.arT.aF(view);
            dragHorizonScrollView2 = this.arT.arH;
            int aG = dragHorizonScrollView2.aG(view);
            if (aG >= 0) {
                writeImagesInfo = this.arT.arK;
                if (aG < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.arT.arK;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(aG);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.arT.arH;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.arT.arK;
                    int size = writeImagesInfo3.size();
                    String string = this.arT.getResources().getString(n.i.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.arT.arI;
                    textView.setText(string);
                    writeImagesInfo4 = this.arT.arK;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    kVar = this.arT.KS;
                    if (kVar != null) {
                        kVar2 = this.arT.KS;
                        i = this.arT.arO;
                        kVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            kVar6 = this.arT.KS;
                            i3 = this.arT.arP;
                            kVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            kVar3 = this.arT.KS;
                            i2 = this.arT.arP;
                            kVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.arT.arQ;
                            if (z) {
                                kVar5 = this.arT.KS;
                                kVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.arT;
                            writeImagesInfo5 = this.arT.arK;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.arT.arI;
                            str = this.arT.arR;
                            textView2.setText(str);
                            kVar4 = this.arT.KS;
                            kVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
