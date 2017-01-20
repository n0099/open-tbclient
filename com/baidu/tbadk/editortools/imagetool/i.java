package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends x {
    public i(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.l.editor_image), 10, i);
        this.atW = r.g.btn_pb_add_pic;
        this.atX = false;
        this.aub = new int[]{14};
    }
}
