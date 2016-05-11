package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends aa {
    public i(Context context, int i) {
        super(context, TbadkCoreApplication.m11getInst().getString(t.j.editor_image), 10, i);
        this.aql = t.f.btn_pb_add_pic;
        this.aqm = false;
        this.aqq = new int[]{14};
    }
}
