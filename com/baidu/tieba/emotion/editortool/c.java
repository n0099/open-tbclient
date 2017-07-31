package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.l.editor_express), 5, i);
        this.aCN = d.g.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.aCc = bVar;
        this.aCR = true;
        this.aCQ = 6;
        this.aCS = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.l.editor_express), 5, i);
        this.aCN = d.g.pbeditor_face_button;
        this.aCc = new b(context);
        this.aCR = true;
        this.aCQ = 6;
        this.aCS = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void bH(boolean z) {
        ((b) this.aCc).setShowUserCollect(z);
    }
}
