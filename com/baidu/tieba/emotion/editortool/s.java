package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.editortools.x {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(w.l.editor_express), 5, i);
        this.azr = w.g.pbeditor_face_button;
        this.ayH = new p(context);
        this.azv = true;
        this.azu = 6;
        this.azw = new int[]{1, 34, 35};
    }
}
