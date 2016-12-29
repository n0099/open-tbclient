package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends x {
    public i(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.j.editor_image), 10, i);
        this.auR = r.f.btn_pb_add_pic;
        this.auS = false;
        this.auW = new int[]{14};
    }
}
