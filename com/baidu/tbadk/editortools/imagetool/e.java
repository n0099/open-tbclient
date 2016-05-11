package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView aqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.aqO = multiImgToolView;
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
        dragHorizonScrollView = this.aqO.aqC;
        if (!dragHorizonScrollView.aUw()) {
            this.aqO.bk(view);
            dragHorizonScrollView2 = this.aqO.aqC;
            int bl = dragHorizonScrollView2.bl(view);
            if (bl >= 0) {
                writeImagesInfo = this.aqO.aqF;
                if (bl < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.aqO.aqF;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bl);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.bG().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.aqO.aqC;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.aqO.aqF;
                    int size = writeImagesInfo3.size();
                    String string = this.aqO.getResources().getString(t.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.aqO.aqD;
                    textView.setText(string);
                    writeImagesInfo4 = this.aqO.aqF;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    lVar = this.aqO.BV;
                    if (lVar != null) {
                        lVar2 = this.aqO.BV;
                        i = this.aqO.aqJ;
                        lVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            lVar6 = this.aqO.BV;
                            i3 = this.aqO.aqK;
                            lVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            lVar3 = this.aqO.BV;
                            i2 = this.aqO.aqK;
                            lVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.aqO.aqL;
                            if (z) {
                                lVar5 = this.aqO.BV;
                                lVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.aqO;
                            writeImagesInfo5 = this.aqO.aqF;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.aqO.aqD;
                            str = this.aqO.aqM;
                            textView2.setText(str);
                            lVar4 = this.aqO.BV;
                            lVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
