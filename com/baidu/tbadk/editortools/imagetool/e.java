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
    final /* synthetic */ MultiImgToolView azU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.azU = multiImgToolView;
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
        dragHorizonScrollView = this.azU.azI;
        if (!dragHorizonScrollView.bic()) {
            this.azU.bp(view);
            dragHorizonScrollView2 = this.azU.azI;
            int bq = dragHorizonScrollView2.bq(view);
            if (bq >= 0) {
                writeImagesInfo = this.azU.azL;
                if (bq < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.azU.azL;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bq);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.azU.azI;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.azU.azL;
                    int size = writeImagesInfo3.size();
                    String string = this.azU.getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.azU.azJ;
                    textView.setText(string);
                    writeImagesInfo4 = this.azU.azL;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.azU.Ll;
                    if (jVar != null) {
                        jVar2 = this.azU.Ll;
                        i = this.azU.azP;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar6 = this.azU.Ll;
                            i3 = this.azU.azQ;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.azU.Ll;
                            i2 = this.azU.azQ;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.azU.azR;
                            if (z) {
                                jVar5 = this.azU.Ll;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.azU;
                            writeImagesInfo5 = this.azU.azL;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.azU.azJ;
                            str = this.azU.azS;
                            textView2.setText(str);
                            jVar4 = this.azU.Ll;
                            jVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
