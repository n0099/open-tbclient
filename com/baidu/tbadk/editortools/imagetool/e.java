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
    final /* synthetic */ MultiImgToolView aAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.aAk = multiImgToolView;
    }

    @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
    public void F(View view) {
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
        dragHorizonScrollView = this.aAk.azY;
        if (!dragHorizonScrollView.bhl()) {
            this.aAk.bj(view);
            dragHorizonScrollView2 = this.aAk.azY;
            int bk = dragHorizonScrollView2.bk(view);
            if (bk >= 0) {
                writeImagesInfo = this.aAk.aAb;
                if (bk < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.aAk.aAb;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bk);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.aAk.azY;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.aAk.aAb;
                    int size = writeImagesInfo3.size();
                    String string = this.aAk.getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.aAk.azZ;
                    textView.setText(string);
                    writeImagesInfo4 = this.aAk.aAb;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.aAk.Kg;
                    if (jVar != null) {
                        jVar2 = this.aAk.Kg;
                        i = this.aAk.aAf;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar6 = this.aAk.Kg;
                            i3 = this.aAk.aAg;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.aAk.Kg;
                            i2 = this.aAk.aAg;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.aAk.aAh;
                            if (z) {
                                jVar5 = this.aAk.Kg;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.aAk;
                            writeImagesInfo5 = this.aAk.aAb;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.aAk.azZ;
                            str = this.aAk.aAi;
                            textView2.setText(str);
                            jVar4 = this.aAk.Kg;
                            jVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
