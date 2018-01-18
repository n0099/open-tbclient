package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.bqN = d.f.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.bqa = bVar;
        this.bqR = true;
        this.bqQ = 6;
        this.bqS = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.bqN = d.f.pbeditor_face_button;
        this.bqa = new b(context);
        this.bqR = true;
        this.bqQ = 6;
        this.bqS = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void cd(boolean z) {
        ((b) this.bqa).setShowUserCollect(z);
    }
}
