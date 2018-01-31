package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.bqW = d.f.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.bqj = bVar;
        this.bra = true;
        this.bqZ = 6;
        this.brb = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.bqW = d.f.pbeditor_face_button;
        this.bqj = new b(context);
        this.bra = true;
        this.bqZ = 6;
        this.brb = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void ce(boolean z) {
        ((b) this.bqj).setShowUserCollect(z);
    }
}
