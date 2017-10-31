package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends r {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_image), 10, i);
        this.aBQ = d.f.btn_pb_add_pic;
        this.aBR = false;
        this.aBV = new int[]{14};
    }
}
