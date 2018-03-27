package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends r {
    public c(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.bsZ = d.f.pbeditor_face_button;
        b bVar = new b(context);
        bVar.setShowBigEmotion(z);
        this.bsm = bVar;
        this.btd = true;
        this.btc = 6;
        this.bte = new int[]{1, 34, 35};
    }

    public c(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.bsZ = d.f.pbeditor_face_button;
        this.bsm = new b(context);
        this.btd = true;
        this.btc = 6;
        this.bte = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.r
    public void ci(boolean z) {
        ((b) this.bsm).setShowUserCollect(z);
    }
}
