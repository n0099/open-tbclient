package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends k {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_image), 10, i);
        this.cjk = d.f.btn_pb_add_pic;
        this.cjl = false;
        this.cjp = new int[]{14};
    }
}
