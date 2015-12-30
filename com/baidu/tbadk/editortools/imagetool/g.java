package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.z;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import java.io.File;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ MultiImgToolView.b atC;
    private final /* synthetic */ ViewGroup atD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MultiImgToolView.b bVar, ViewGroup viewGroup) {
        this.atC = bVar;
        this.atD = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z zVar;
        z zVar2;
        Context context;
        int indexOfChild = this.atD.indexOfChild(view);
        if (indexOfChild >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.atC.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.atC.mContext;
                k.c(context, n.j.editor_mutiiamge_image_error);
                return;
            }
            zVar = this.atC.atz;
            if (zVar != null) {
                zVar2 = this.atC.atz;
                zVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
