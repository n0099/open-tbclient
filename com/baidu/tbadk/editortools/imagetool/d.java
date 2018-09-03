package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class d extends k {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(f.j.editor_image), 10, i);
        this.aMP = f.C0146f.btn_pb_add_pic;
        this.aMQ = false;
        this.aMU = new int[]{14};
    }
}
