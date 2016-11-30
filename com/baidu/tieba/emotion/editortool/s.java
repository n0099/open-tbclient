package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends aa {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.j.editor_express), 5, i);
        this.avu = r.f.pbeditor_face_button;
        this.auC = new p(context);
        this.avy = true;
        this.avx = 6;
        this.avz = new int[]{1, 34, 35};
    }
}
