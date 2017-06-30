package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.x {
    public v(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.m9getInst().getString(w.l.editor_express), 5, i);
        this.aAw = w.g.pbeditor_face_button;
        r rVar = new r(context);
        rVar.setShowBigEmotion(z);
        this.azL = rVar;
        this.aAA = true;
        this.aAz = 6;
        this.aAB = new int[]{1, 34, 35};
    }

    public v(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(w.l.editor_express), 5, i);
        this.aAw = w.g.pbeditor_face_button;
        this.azL = new r(context);
        this.aAA = true;
        this.aAz = 6;
        this.aAB = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.x
    public void bE(boolean z) {
        ((r) this.azL).setShowUserCollect(z);
    }
}
