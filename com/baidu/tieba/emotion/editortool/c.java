package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.l.editor_express), 5, i);
        this.aBh = d.g.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.aAv = bVar;
        this.aBl = true;
        this.aBk = 6;
        this.aBm = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.l.editor_express), 5, i);
        this.aBh = d.g.pbeditor_face_button;
        this.aAv = new b(context);
        this.aBl = true;
        this.aBk = 6;
        this.aBm = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void bE(boolean z) {
        ((b) this.aAv).setShowUserCollect(z);
    }
}
