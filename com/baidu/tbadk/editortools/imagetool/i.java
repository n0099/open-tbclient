package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends x {
    public i(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(w.l.editor_image), 10, i);
        this.azr = w.g.btn_pb_add_pic;
        this.azs = false;
        this.azw = new int[]{14};
    }
}
