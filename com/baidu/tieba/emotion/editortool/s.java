package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends aa {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(t.j.editor_express), 5, i);
        this.auX = t.f.pbeditor_face_button;
        this.aue = new p(context);
        this.avb = true;
        this.ava = 6;
        this.avc = new int[]{1, 34, 35};
    }
}
