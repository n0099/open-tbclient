package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends r {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.l.editor_image), 10, i);
        this.aCN = d.g.btn_pb_add_pic;
        this.aCO = false;
        this.aCS = new int[]{14};
    }
}
