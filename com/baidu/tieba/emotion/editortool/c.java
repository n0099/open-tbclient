package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aCJ = d.f.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.aBW = bVar;
        this.aCN = true;
        this.aCM = 6;
        this.aCO = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aCJ = d.f.pbeditor_face_button;
        this.aBW = new b(context);
        this.aCN = true;
        this.aCM = 6;
        this.aCO = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void bB(boolean z) {
        ((b) this.aBW).setShowUserCollect(z);
    }
}
