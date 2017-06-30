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
    final /* synthetic */ MultiImgToolView aAZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.aAZ = multiImgToolView;
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
        dragHorizonScrollView = this.aAZ.aAN;
        if (!dragHorizonScrollView.bmT()) {
            this.aAZ.bq(view);
            dragHorizonScrollView2 = this.aAZ.aAN;
            int br = dragHorizonScrollView2.br(view);
            if (br >= 0) {
                writeImagesInfo = this.aAZ.aAQ;
                if (br < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.aAZ.aAQ;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(br);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.aAZ.aAN;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.aAZ.aAQ;
                    int size = writeImagesInfo3.size();
                    String string = this.aAZ.getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.aAZ.aAO;
                    textView.setText(string);
                    writeImagesInfo4 = this.aAZ.aAQ;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.aAZ.JT;
                    if (jVar != null) {
                        jVar2 = this.aAZ.JT;
                        i = this.aAZ.aAU;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar6 = this.aAZ.JT;
                            i3 = this.aAZ.aAV;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.aAZ.JT;
                            i2 = this.aAZ.aAV;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.aAZ.aAW;
                            if (z) {
                                jVar5 = this.aAZ.JT;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.aAZ;
                            writeImagesInfo5 = this.aAZ.aAQ;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.aAZ.aAO;
                            str = this.aAZ.aAX;
                            textView2.setText(str);
                            jVar4 = this.aAZ.JT;
                            jVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
