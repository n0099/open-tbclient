package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.editortools.x {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.j.editor_express), 5, i);
        this.auR = r.f.pbeditor_face_button;
        this.auh = new p(context);
        this.auV = true;
        this.auU = 6;
        this.auW = new int[]{1, 34, 35};
    }
}
