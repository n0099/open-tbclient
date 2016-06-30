package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView arE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.arE = multiImgToolView;
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
        dragHorizonScrollView = this.arE.ars;
        if (!dragHorizonScrollView.bcQ()) {
            this.arE.bs(view);
            dragHorizonScrollView2 = this.arE.ars;
            int bt = dragHorizonScrollView2.bt(view);
            if (bt >= 0) {
                writeImagesInfo = this.arE.arv;
                if (bt < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.arE.arv;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bt);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.bH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.arE.ars;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.arE.arv;
                    int size = writeImagesInfo3.size();
                    String string = this.arE.getResources().getString(u.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.arE.art;
                    textView.setText(string);
                    writeImagesInfo4 = this.arE.arv;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    lVar = this.arE.BW;
                    if (lVar != null) {
                        lVar2 = this.arE.BW;
                        i = this.arE.arz;
                        lVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            lVar6 = this.arE.BW;
                            i3 = this.arE.arA;
                            lVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            lVar3 = this.arE.BW;
                            i2 = this.arE.arA;
                            lVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.arE.arB;
                            if (z) {
                                lVar5 = this.arE.BW;
                                lVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.arE;
                            writeImagesInfo5 = this.arE.arv;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.arE.art;
                            str = this.arE.arC;
                            textView2.setText(str);
                            lVar4 = this.arE.BW;
                            lVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
