package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView aAm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.aAm = multiImgToolView;
    }

    @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
    public void G(View view) {
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
        dragHorizonScrollView = this.aAm.aAa;
        if (!dragHorizonScrollView.bjO()) {
            this.aAm.bn(view);
            dragHorizonScrollView2 = this.aAm.aAa;
            int bo = dragHorizonScrollView2.bo(view);
            if (bo >= 0) {
                writeImagesInfo = this.aAm.aAd;
                if (bo < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.aAm.aAd;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bo);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.aAm.aAa;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.aAm.aAd;
                    int size = writeImagesInfo3.size();
                    String string = this.aAm.getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.aAm.aAb;
                    textView.setText(string);
                    writeImagesInfo4 = this.aAm.aAd;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.aAm.KO;
                    if (jVar != null) {
                        jVar2 = this.aAm.KO;
                        i = this.aAm.aAh;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar6 = this.aAm.KO;
                            i3 = this.aAm.aAi;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.aAm.KO;
                            i2 = this.aAm.aAi;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.aAm.aAj;
                            if (z) {
                                jVar5 = this.aAm.KO;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.aAm;
                            writeImagesInfo5 = this.aAm.aAd;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.aAm.aAb;
                            str = this.aAm.aAk;
                            textView2.setText(str);
                            jVar4 = this.aAm.KO;
                            jVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
