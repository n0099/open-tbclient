package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class i extends aa {
    public i(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(u.j.editor_image), 10, i);
        this.arb = u.f.btn_pb_add_pic;
        this.arc = false;
        this.arg = new int[]{14};
    }
}
