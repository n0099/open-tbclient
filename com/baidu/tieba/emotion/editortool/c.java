package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aBQ = d.f.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.aBf = bVar;
        this.aBU = true;
        this.aBT = 6;
        this.aBV = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aBQ = d.f.pbeditor_face_button;
        this.aBf = new b(context);
        this.aBU = true;
        this.aBT = 6;
        this.aBV = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void bz(boolean z) {
        ((b) this.aBf).setShowUserCollect(z);
    }
}
