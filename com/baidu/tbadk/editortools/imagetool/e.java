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
    final /* synthetic */ MultiImgToolView avd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.avd = multiImgToolView;
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
        dragHorizonScrollView = this.avd.auR;
        if (!dragHorizonScrollView.bks()) {
            this.avd.bo(view);
            dragHorizonScrollView2 = this.avd.auR;
            int bp = dragHorizonScrollView2.bp(view);
            if (bp >= 0) {
                writeImagesInfo = this.avd.auU;
                if (bp < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.avd.auU;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bp);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.cB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.avd.auR;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.avd.auU;
                    int size = writeImagesInfo3.size();
                    String string = this.avd.getResources().getString(r.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.avd.auS;
                    textView.setText(string);
                    writeImagesInfo4 = this.avd.auU;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    lVar = this.avd.EJ;
                    if (lVar != null) {
                        lVar2 = this.avd.EJ;
                        i = this.avd.auY;
                        lVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            lVar6 = this.avd.EJ;
                            i3 = this.avd.auZ;
                            lVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            lVar3 = this.avd.EJ;
                            i2 = this.avd.auZ;
                            lVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.avd.ava;
                            if (z) {
                                lVar5 = this.avd.EJ;
                                lVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.avd;
                            writeImagesInfo5 = this.avd.auU;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.avd.auS;
                            str = this.avd.avb;
                            textView2.setText(str);
                            lVar4 = this.avd.EJ;
                            lVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
