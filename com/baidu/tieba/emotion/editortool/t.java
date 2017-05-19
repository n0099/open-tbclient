package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.x {
    public t(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(w.l.editor_express), 5, i);
        this.azH = w.g.pbeditor_face_button;
        this.ayX = new q(context);
        this.azL = true;
        this.azK = 6;
        this.azM = new int[]{1, 34, 35};
    }
}
