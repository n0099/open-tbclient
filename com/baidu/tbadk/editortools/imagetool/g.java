package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.io.File;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ MultiImgToolView.b aqb;
    private final /* synthetic */ ViewGroup aqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MultiImgToolView.b bVar, ViewGroup viewGroup) {
        this.aqb = bVar;
        this.aqc = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        x xVar;
        x xVar2;
        Context context;
        int indexOfChild = this.aqc.indexOfChild(view);
        if (indexOfChild >= 0) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.aqb.getItem(indexOfChild);
            if (imageFileInfo == null) {
                z = false;
            } else {
                File file = new File(imageFileInfo.getFilePath());
                z = file.exists() && file.length() != 0;
            }
            if (!z) {
                context = this.aqb.mContext;
                k.c(context, i.h.editor_mutiiamge_image_error);
                return;
            }
            xVar = this.aqb.apY;
            if (xVar != null) {
                xVar2 = this.aqb.apY;
                xVar2.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }
}
