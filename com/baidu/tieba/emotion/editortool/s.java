package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends aa {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.j.editor_express), 5, i);
        this.auA = r.f.pbeditor_face_button;
        this.atI = new p(context);
        this.auE = true;
        this.auD = 6;
        this.auF = new int[]{1, 34, 35};
    }
}
