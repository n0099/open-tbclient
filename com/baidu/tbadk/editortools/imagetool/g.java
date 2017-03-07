package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import java.io.File;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ ViewGroup aAa;
    final /* synthetic */ MultiImgToolView.b azZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MultiImgToolView.b bVar, ViewGroup viewGroup) {
        this.azZ = bVar;
        this.aAa = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        y yVar;
        y yVar2;
        Context context;
        int indexOfChild = this.aAa.indexOfChild(view);
        if (indexOfChild >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.azZ.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                z = new File(imageFileInfo.getFilePath()).exists();
            }
            if (!z) {
                context = this.azZ.mContext;
                k.f(context, w.l.editor_mutiiamge_image_error);
                return;
            }
            yVar = this.azZ.azW;
            if (yVar != null) {
                yVar2 = this.azZ.azW;
                yVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
