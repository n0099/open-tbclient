package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
/* loaded from: classes.dex */
class e implements MultiImgToolView.a {
    final /* synthetic */ MultiImgToolView aup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiImgToolView multiImgToolView) {
        this.aup = multiImgToolView;
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
        k kVar;
        k kVar2;
        int i;
        k kVar3;
        int i2;
        boolean z;
        WriteImagesInfo writeImagesInfo5;
        TextView textView2;
        String str;
        k kVar4;
        k kVar5;
        k kVar6;
        int i3;
        dragHorizonScrollView = this.aup.aud;
        if (!dragHorizonScrollView.aMV()) {
            this.aup.bc(view);
            dragHorizonScrollView2 = this.aup.aud;
            int bd = dragHorizonScrollView2.bd(view);
            if (bd >= 0) {
                writeImagesInfo = this.aup.aug;
                if (bd < writeImagesInfo.getChosedFiles().size()) {
                    writeImagesInfo2 = this.aup.aug;
                    ImageFileInfo remove = writeImagesInfo2.getChosedFiles().remove(bd);
                    if (remove.isTempFile()) {
                        com.baidu.adp.lib.Disk.d.fr().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                    dragHorizonScrollView3 = this.aup.aud;
                    int maxItemNum = dragHorizonScrollView3.getMaxItemNum();
                    writeImagesInfo3 = this.aup.aug;
                    int size = writeImagesInfo3.size();
                    String string = this.aup.getResources().getString(t.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size));
                    textView = this.aup.aue;
                    textView.setText(string);
                    writeImagesInfo4 = this.aup.aug;
                    int size2 = writeImagesInfo4.getChosedFiles().size();
                    kVar = this.aup.Lx;
                    if (kVar != null) {
                        kVar2 = this.aup.Lx;
                        i = this.aup.auk;
                        kVar2.b(new com.baidu.tbadk.editortools.a(i, -1, null));
                        if (size2 > 0) {
                            kVar6 = this.aup.Lx;
                            i3 = this.aup.aul;
                            kVar6.b(new com.baidu.tbadk.editortools.a(2, i3, String.valueOf(size2)));
                        } else {
                            kVar3 = this.aup.Lx;
                            i2 = this.aup.aul;
                            kVar3.b(new com.baidu.tbadk.editortools.a(2, i2, null));
                        }
                        if (maxItemNum == 1 && size2 == 0) {
                            z = this.aup.aum;
                            if (z) {
                                kVar5 = this.aup.Lx;
                                kVar5.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                return;
                            }
                            MultiImgToolView multiImgToolView = this.aup;
                            writeImagesInfo5 = this.aup.aug;
                            multiImgToolView.a(writeImagesInfo5, true);
                            textView2 = this.aup.aue;
                            str = this.aup.aun;
                            textView2.setText(str);
                            kVar4 = this.aup.Lx;
                            kVar4.invalidate();
                        }
                    }
                }
            }
        }
    }
}
