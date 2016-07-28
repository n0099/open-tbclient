package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class i extends aa {
    public i(Context context, int i) {
        super(context, TbadkCoreApplication.m10getInst().getString(u.j.editor_image), 10, i);
        this.arQ = u.f.btn_pb_add_pic;
        this.arR = false;
        this.arV = new int[]{14};
    }
}
