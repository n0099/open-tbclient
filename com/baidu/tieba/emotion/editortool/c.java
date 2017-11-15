package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aBY = d.f.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.aBn = bVar;
        this.aCc = true;
        this.aCb = 6;
        this.aCd = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aBY = d.f.pbeditor_face_button;
        this.aBn = new b(context);
        this.aCc = true;
        this.aCb = 6;
        this.aCd = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void bA(boolean z) {
        ((b) this.aBn).setShowUserCollect(z);
    }
}
