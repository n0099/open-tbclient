package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d extends k {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(e.j.editor_image), 10, i);
        this.aZJ = e.f.btn_pb_add_pic;
        this.aZK = false;
        this.aZO = new int[]{14};
    }
}
