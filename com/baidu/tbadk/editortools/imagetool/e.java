package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView avu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.avu = multiImgToolView;
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
        dragHorizonScrollView = this.avu.avi;
        if (!dragHorizonScrollView.bgx()) {
            this.avu.bn(view);
            dragHorizonScrollView2 = this.avu.avi;
            int bo = dragHorizonScrollView2.bo(view);
            if (bo >= 0) {
                writeImagesInfo = this.avu.avl;
                if (bo < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.avu.avl;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bo);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.cB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.avu.avi;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.avu.avl;
                    int size = writeImagesInfo3.size();
                    String string = this.avu.getResources().getString(r.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.avu.avj;
                    textView.setText(string);
                    writeImagesInfo4 = this.avu.avl;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    jVar = this.avu.EM;
                    if (jVar != null) {
                        jVar2 = this.avu.EM;
                        i = this.avu.avp;
                        jVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            jVar6 = this.avu.EM;
                            i3 = this.avu.avq;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            jVar3 = this.avu.EM;
                            i2 = this.avu.avq;
                            jVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.avu.avr;
                            if (z) {
                                jVar5 = this.avu.EM;
                                jVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.avu;
                            writeImagesInfo5 = this.avu.avl;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.avu.avj;
                            str = this.avu.avs;
                            textView2.setText(str);
                            jVar4 = this.avu.EM;
                            jVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
