package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends r {
    public o(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.aCB = d.f.selector_more_tool_btn;
        this.aBO = new m(context);
        this.aCF = true;
        this.aCE = 6;
        this.aCG = new int[]{1};
    }

    public o(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.aCB = d.f.new_pbeditor_more_button;
        this.aBO = new m(context, !z);
        this.aCF = true;
        this.aCE = 6;
        this.aCG = new int[]{1};
    }
}
