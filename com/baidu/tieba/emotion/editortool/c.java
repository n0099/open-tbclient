package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aCB = d.f.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.aBO = bVar;
        this.aCF = true;
        this.aCE = 6;
        this.aCG = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aCB = d.f.pbeditor_face_button;
        this.aBO = new b(context);
        this.aCF = true;
        this.aCE = 6;
        this.aCG = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void bA(boolean z) {
        ((b) this.aBO).setShowUserCollect(z);
    }
}
