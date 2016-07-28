package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class s extends aa {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m10getInst().getString(u.j.editor_express), 5, i);
        this.arQ = u.f.pbeditor_face_button;
        this.aqX = new p(context);
        this.arU = true;
        this.arT = 6;
        this.arV = new int[]{1, 34, 35};
    }
}
