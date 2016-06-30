package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class s extends aa {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(u.j.editor_express), 5, i);
        this.arb = u.f.pbeditor_face_button;
        this.aqi = new p(context);
        this.arf = true;
        this.are = 6;
        this.arg = new int[]{1, 34, 35};
    }
}
