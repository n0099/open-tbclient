package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.l.editor_express), 5, i);
        this.aBZ = d.g.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.aBn = bVar;
        this.aCd = true;
        this.aCc = 6;
        this.aCe = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.l.editor_express), 5, i);
        this.aBZ = d.g.pbeditor_face_button;
        this.aBn = new b(context);
        this.aCd = true;
        this.aCc = 6;
        this.aCe = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void bG(boolean z) {
        ((b) this.aBn).setShowUserCollect(z);
    }
}
