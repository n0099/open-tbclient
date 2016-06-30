package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class x extends aa {
    public x(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m9getInst().getString(u.j.more_function);
        this.arb = u.f.selector_editor_btn_more;
        this.aqi = new t(context);
        this.arf = true;
        this.are = 6;
        this.arg = new int[]{1};
    }
}
