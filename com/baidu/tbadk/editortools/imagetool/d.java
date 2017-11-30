package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends r {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_image), 10, i);
        this.aCB = d.f.btn_pb_add_pic;
        this.aCC = false;
        this.aCG = new int[]{14};
    }
}
