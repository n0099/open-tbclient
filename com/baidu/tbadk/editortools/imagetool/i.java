package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends v {
    public i(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.h.editor_image), 10, i);
        this.aps = i.e.btn_pb_add_pic;
        this.apt = false;
        this.apx = new int[]{14};
    }
}
