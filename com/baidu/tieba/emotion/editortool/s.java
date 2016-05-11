package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends aa {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m11getInst().getString(t.j.editor_express), 5, i);
        this.aql = t.f.pbeditor_face_button;
        this.aps = new p(context);
        this.aqp = true;
        this.aqo = 6;
        this.aqq = new int[]{1, 34, 35};
    }
}
