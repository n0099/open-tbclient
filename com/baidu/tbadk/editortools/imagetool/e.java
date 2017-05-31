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
    final /* synthetic */ MultiImgToolView azW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.azW = multiImgToolView;
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
        dragHorizonScrollView = this.azW.azK;
        if (!dragHorizonScrollView.biF()) {
            this.azW.bo(view);
            dragHorizonScrollView2 = this.azW.azK;
            int bp = dragHorizonScrollView2.bp(view);
            if (bp >= 0) {
                writeImagesInfo = this.azW.azN;
                if (bp < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.azW.azN;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bp);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.azW.azK;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.azW.azN;
                    int size = writeImagesInfo3.size();
                    String string = this.azW.getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.azW.azL;
                    textView.setText(string);
                    writeImagesInfo4 = this.azW.azN;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.azW.JU;
                    if (jVar != null) {
                        jVar2 = this.azW.JU;
                        i = this.azW.azR;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar6 = this.azW.JU;
                            i3 = this.azW.azS;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.azW.JU;
                            i2 = this.azW.azS;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.azW.azT;
                            if (z) {
                                jVar5 = this.azW.JU;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.azW;
                            writeImagesInfo5 = this.azW.azN;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.azW.azL;
                            str = this.azW.azU;
                            textView2.setText(str);
                            jVar4 = this.azW.JU;
                            jVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
