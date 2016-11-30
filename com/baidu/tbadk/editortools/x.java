package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends aa {
    public x(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m9getInst().getString(r.j.more_function);
        this.avu = r.f.selector_editor_btn_more;
        this.auC = new t(context);
        this.avy = true;
        this.avx = 6;
        this.avz = new int[]{1};
    }
}
