package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView avX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.avX = multiImgToolView;
    }

    @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
    public void K(View view) {
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
        dragHorizonScrollView = this.avX.avL;
        if (!dragHorizonScrollView.bmI()) {
            this.avX.bo(view);
            dragHorizonScrollView2 = this.avX.avL;
            int bp = dragHorizonScrollView2.bp(view);
            if (bp >= 0) {
                writeImagesInfo = this.avX.avO;
                if (bp < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.avX.avO;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bp);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.cB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.avX.avL;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.avX.avO;
                    int size = writeImagesInfo3.size();
                    String string = this.avX.getResources().getString(r.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.avX.avM;
                    textView.setText(string);
                    writeImagesInfo4 = this.avX.avO;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    lVar = this.avX.EL;
                    if (lVar != null) {
                        lVar2 = this.avX.EL;
                        i = this.avX.avS;
                        lVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            lVar6 = this.avX.EL;
                            i3 = this.avX.avT;
                            lVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            lVar3 = this.avX.EL;
                            i2 = this.avX.avT;
                            lVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.avX.avU;
                            if (z) {
                                lVar5 = this.avX.EL;
                                lVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.avX;
                            writeImagesInfo5 = this.avX.avO;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.avX.avM;
                            str = this.avX.avV;
                            textView2.setText(str);
                            lVar4 = this.avX.EL;
                            lVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
