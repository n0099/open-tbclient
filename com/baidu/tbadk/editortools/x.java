package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends aa {
    public x(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m9getInst().getString(r.j.more_function);
        this.auA = r.f.selector_editor_btn_more;
        this.atI = new t(context);
        this.auE = true;
        this.auD = 6;
        this.auF = new int[]{1};
    }
}
