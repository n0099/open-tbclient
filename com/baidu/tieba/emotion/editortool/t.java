package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.x {
    public t(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(w.l.editor_express), 5, i);
        this.azt = w.g.pbeditor_face_button;
        this.ayJ = new q(context);
        this.azx = true;
        this.azw = 6;
        this.azy = new int[]{1, 34, 35};
    }
}
