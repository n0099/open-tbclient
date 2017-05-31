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
    final /* synthetic */ MultiImgToolView.b aAb;
    private final /* synthetic */ ViewGroup aAc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MultiImgToolView.b bVar, ViewGroup viewGroup) {
        this.aAb = bVar;
        this.aAc = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        y yVar;
        y yVar2;
        Context context;
        int indexOfChild = this.aAc.indexOfChild(view);
        if (indexOfChild >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.aAb.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                z = new File(imageFileInfo.getFilePath()).exists();
            }
            if (!z) {
                context = this.aAb.mContext;
                k.f(context, w.l.editor_mutiiamge_image_error);
                return;
            }
            yVar = this.aAb.azY;
            if (yVar != null) {
                yVar2 = this.aAb.azY;
                yVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
