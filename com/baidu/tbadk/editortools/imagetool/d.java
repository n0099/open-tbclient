package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends k {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.k.editor_image), 10, i);
        this.aLW = d.f.btn_pb_add_pic;
        this.aLX = false;
        this.aMb = new int[]{14};
    }
}
