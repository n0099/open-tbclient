package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.editortools.x {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.l.editor_express), 5, i);
        this.atW = r.g.pbeditor_face_button;
        this.atm = new p(context);
        this.aua = true;
        this.atZ = 6;
        this.aub = new int[]{1, 34, 35};
    }
}
